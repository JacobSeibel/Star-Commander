package mechanics.characters;

import java.util.Arrays;
import java.util.List;

import mechanics.CentralBrain;
import mechanics.comms.ChatterTask;
import mechanics.comms.Message;
import mechanics.comms.MessageMoodEnum;
import mechanics.comms.MessagesEnum;
import mechanics.ships.FacingEnum;
import mechanics.ships.RelativeDirectionEnum;

public class AllianceCharacterBrain extends AbstractCharacterBrain{

	private MessageMoodEnum mood;
	private MessagesEnum lastMessage;
	private MessagesEnum reactToMessage;
	private AllianceCharacter reactToTarget;
	private boolean celebrate = false;
	private boolean dying = false;
	
	public AllianceCharacterBrain(CentralBrain centralBrain, AllianceCharacter character, MessageMoodEnum mood, double fleePercent) {
		super(centralBrain, character, fleePercent);
		this.mood = mood;
		centralBrain.schedule(new ChatterTask(this));
	}

	public int getCommFrequency() {
		return (int)(Math.random()*40)+16;
	}

	public MessageMoodEnum getMood() {
		return mood;
	}

	public void setMood(MessageMoodEnum mood) {
		this.mood = mood;
	}
	
	public Message getMessage(){
		List<MessagesEnum> messages;
		
		if(dying){
			dying = false;
			getCharacter().setDead();
			return new Message((AllianceCharacter)getCharacter(), MessagesEnum.COMBAT_DEATH_1.message());
		}
		
		if(celebrate){
			celebrate = false;
			return new Message((AllianceCharacter)getCharacter(), MessagesEnum.COMBAT_KILL.message());
		}
		
		boolean helpMe = false;
		RelativeDirectionEnum enemyDirection = null;
		if(getTarget() != null && Math.random()*10 < 5){
			if(getTarget().getPilot().isDead()){
				setTarget(null);
			}else{
				FacingEnum targetCardinalDirection = null;
				
				int x = getTarget().getXcoord();
				int y = getTarget().getYcoord();
				int z = getTarget().getZcoord();
				
				double largestDist = Math.abs(x);
				if(largestDist < Math.abs(y)) largestDist = Math.abs(y);
				if(largestDist < Math.abs(z)) largestDist = Math.abs(z);
				
				if(largestDist == Math.abs(x)){
					if(x >= 0){
						targetCardinalDirection = FacingEnum.POSITIVE_X;
					}else{
						targetCardinalDirection = FacingEnum.NEGATIVE_X;
					}
				}else if(largestDist == Math.abs(y)){
					if(y >= 0){
						targetCardinalDirection = FacingEnum.POSITIVE_Y;
					}else{
						targetCardinalDirection = FacingEnum.NEGATIVE_Y;
					}
				}else if(largestDist == Math.abs(z)){
					if(z >= 0){
						targetCardinalDirection = FacingEnum.POSITIVE_Z;
					}else{
						targetCardinalDirection = FacingEnum.NEGATIVE_Z;
					}
				}
				
				enemyDirection = CentralBrain.determineRelativeDirection(getCharacter().getSpacecraft().getFacingDirection(), targetCardinalDirection);
				
				if(getCharacter().getSpacecraft().isRunningAway()){
					helpMe = true;
				}
			}
		}
		if(enemyDirection != null){
			if(enemyDirection.equals(RelativeDirectionEnum.ABOVE)){
				if(helpMe){
					return new Message((AllianceCharacter)getCharacter(), MessagesEnum.HELP_ABOVE.message());
				}else{
					return new Message((AllianceCharacter)getCharacter(), MessagesEnum.COMBAT_ABOVE.message());
				}
			}
			if(enemyDirection.equals(RelativeDirectionEnum.AHEAD)){
				if(helpMe){
					return new Message((AllianceCharacter)getCharacter(), MessagesEnum.HELP_AHEAD.message());
				}else{
					return new Message((AllianceCharacter)getCharacter(), MessagesEnum.COMBAT_AHEAD.message());
				}
			}
			if(enemyDirection.equals(RelativeDirectionEnum.BEHIND)){
				if(helpMe){
					return new Message((AllianceCharacter)getCharacter(), MessagesEnum.HELP_BEHIND.message());
				}else{
					return new Message((AllianceCharacter)getCharacter(), MessagesEnum.COMBAT_BEHIND.message());
				}
			}
			if(enemyDirection.equals(RelativeDirectionEnum.BELOW)){
				if(helpMe){
					return new Message((AllianceCharacter)getCharacter(), MessagesEnum.HELP_BELOW.message());
				}else{
					return new Message((AllianceCharacter)getCharacter(), MessagesEnum.COMBAT_BELOW.message());
				}
			}
			if(enemyDirection.equals(RelativeDirectionEnum.LEFT)){
				if(helpMe){
					return new Message((AllianceCharacter)getCharacter(), MessagesEnum.HELP_LEFT.message());
				}else{
					return new Message((AllianceCharacter)getCharacter(), MessagesEnum.COMBAT_LEFT.message());
				}
			}
			if(enemyDirection.equals(RelativeDirectionEnum.RIGHT)){
				if(helpMe){
					return new Message((AllianceCharacter)getCharacter(), MessagesEnum.HELP_RIGHT.message());
				}else{
					return new Message((AllianceCharacter)getCharacter(), MessagesEnum.COMBAT_RIGHT.message());
				}
			}
		}
		
		AllianceCharacter reactToTarget = null;
		if(reactToMessage != null){
			messages = MessagesEnum.getReactionsForMessageAndMood(reactToMessage, mood);
			reactToMessage = null;
			reactToTarget = this.reactToTarget;
			this.reactToTarget = null;
		}else{
			messages = MessagesEnum.getMessagesForMood(mood);
		}
		
		MessagesEnum message = null;
		do{
			int randIndex = (int)(Math.random()*messages.size());
			message = messages.get(randIndex);
		}while(message.equals(lastMessage) || (message.hasTarget() && getCentralBrain().getAllianceCharacters().size() == 1));
		
		lastMessage = message;
		
		if(reactToTarget != null){
			return new Message((AllianceCharacter)getCharacter(), reactToTarget, message.message());
		}
		
		if(message.hasTarget()){
			AllianceCharacter target = getCentralBrain().getRandomAllianceCharacter(Arrays.asList((AllianceCharacter)getCharacter()));
			((AllianceCharacterBrain)target.getBrain()).queueForReaction(message, (AllianceCharacter)getCharacter());
			return new Message((AllianceCharacter)getCharacter(), target, message.message());
		}
		return new Message((AllianceCharacter)getCharacter(), message.message());
	}
	
	public void queueForReaction(MessagesEnum message, AllianceCharacter reactToTarget){
		reactToMessage = message;
		this.reactToTarget = reactToTarget;
	}

	public void queueForCelebration(){
		celebrate = true;
	}
	
	public void queueForDeathMessage(){
		dying = true;
	}
	
}
