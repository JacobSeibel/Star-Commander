package mechanics;

import java.util.TimerTask;

public abstract class AbstractTask extends TimerTask{
	
	private int loopNumber = 0;
	
	@Override
	public void run() {
		loopNumber++;
		if(loopNumber%getPeriod() == 0){
			doTask();
		}
	}
	
	protected abstract int getPeriod();
	protected abstract void doTask();
}
