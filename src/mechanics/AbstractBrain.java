package mechanics;

public abstract class AbstractBrain {

	private CentralBrain centralBrain;
	
	public AbstractBrain(CentralBrain centralBrain) {
		this.centralBrain = centralBrain;
	}

	public CentralBrain getCentralBrain() {
		return centralBrain;
	}
	
}
