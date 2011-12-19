package net.slowvic.concurrency.cancle;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用标志位取消线程
 * 
 * @author xus
 * <p>
 */
public class PrimeGenerator implements Runnable {
    private final List<BigInteger> primes = new ArrayList<BigInteger>();
    // 一定要设置为volatile
    private volatile boolean cancelled;

    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<BigInteger>(primes);
    }

    public static void main(String[] args) {
        PrimeGenerator pg = new PrimeGenerator();
        Thread t = new Thread(pg);
        t.start();
        try {
            Thread.sleep(35);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            pg.cancel();
        }
        List<BigInteger> primes = pg.get();
        for (BigInteger bi : primes) {
            System.out.println(bi);
        }
    }
}
