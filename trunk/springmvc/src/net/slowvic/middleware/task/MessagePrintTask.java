package net.slowvic.middleware.task;

public class MessagePrintTask implements Runnable {

    private String message;

    public MessagePrintTask(String message) {
        this.message = message;
    }

    public void run() {
        System.out.println(message);
    }
}
