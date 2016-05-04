package mechanics.comms;

import mechanics.AbstractTask;
import mechanics.characters.AllianceCharacterBrain;

public class ChatterTask extends AbstractTask {
	
	private final CommsBrain commsBrain;
	private final AllianceCharacterBrain allianceCharacterBrain;
	
	public ChatterTask(AllianceCharacterBrain allianceCharacterBrain) {
		super();
		this.commsBrain = allianceCharacterBrain.getCentralBrain().getCommsBrain();
		this.allianceCharacterBrain = allianceCharacterBrain;
	}
	
	@Override
	protected int getPeriod() {
		return allianceCharacterBrain.getCommFrequency();
	}

	@Override
	protected void doTask() {
		if(!allianceCharacterBrain.getCharacter().isDead()){
			commsBrain.addMessage(allianceCharacterBrain.getMessage());
		}
	}

}
