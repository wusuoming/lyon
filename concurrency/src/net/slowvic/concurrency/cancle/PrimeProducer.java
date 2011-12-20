package net.slowvic.concurrency.cancle;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PrimeProducer extends Thread {
    private BlockingQueue<BigInteger> queue;

    public void setQueue(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void cancer() {
        interrupt();
    }

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                queue.put(p = p.nextProbablePrime());
            }
            catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(
            20);
        PrimeProducer pp = new PrimeProducer();
        pp.setQueue(queue);
        pp.start();
        try {
            Thread.sleep(35);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            pp.cancer();
        }
        for (BigInteger bi : queue) {
            System.out.println(bi);
        }
    }
}
