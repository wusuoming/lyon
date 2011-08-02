package net.slowvic.lab;

import java.util.Timer;
import java.util.TimerTask;

public class Remainder {
	private Timer timer;

	public Remainder(int seconds) {
		timer = new Timer();
		timer.schedule(new RemaindTask(), seconds * 1000);
	}

	private class RemaindTask extends TimerTask {
		@Override
		public void run() {
			System.out.println("¿¡≥Ê∆¥≤¡À£°");
			timer.cancel();
		}
	}

	public static void main(String[] args) {
		new Remainder(2);
	}
}