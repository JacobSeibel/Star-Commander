package mechanics.comms;

import mechanics.characters.AllianceCharacter;

public class Message {

	private AllianceCharacter source;
	private AllianceCharacter target;
	private String message;
	
	public Message(AllianceCharacter source, String message){
		this(source, null, message);
	}
	
	public Message(AllianceCharacter source, AllianceCharacter target, String message) {
		this.source = source;
		this.target = target;
		this.message = message;
	}
	
	public String getConstructedMessage(){
		if(target != null){
			message = message.replace(MessagesConstants.TARGET_SUB, target.getCallsign());
		}
		return source.getCallsign() + ": " + message;
	}
	
}
