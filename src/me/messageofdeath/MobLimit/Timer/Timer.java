package me.messageofdeath.MobLimit.Timer;

public class Timer implements Runnable {

	private boolean spawned;
	private long ticks;
	private final long resetTicks;
	
	public Timer(long resetTicks) {
		this.ticks = resetTicks;
		this.resetTicks = resetTicks;
	}
	
	@Override
	public void run() {
		if(this.ticks >= this.resetTicks) {
			this.ticks = this.resetTicks;
			this.setSpawned(false);
		}else{
			this.ticks--;
		}
	}
	
	public boolean isSpawned() {
		return this.spawned;
	}
	
	public void setSpawned(boolean spawned) {
		this.spawned = spawned;
	}
}
