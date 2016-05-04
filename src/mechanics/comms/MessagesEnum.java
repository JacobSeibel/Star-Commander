package mechanics.comms;

import java.util.ArrayList;
import java.util.List;

public enum MessagesEnum {

	HAPPY_1 (MessageMoodEnum.HAPPY, "Wooo! Let's do this!"),
	HAPPY_2 (MessageMoodEnum.HAPPY, MessagesConstants.TARGET_SUB+", I'm gonna tag more than you!", true),
	HAPPY_3 (MessageMoodEnum.HAPPY, "Oh yeah! Let's go!"),
	HAPPY_4 (MessageMoodEnum.HAPPY, "Boom Boom Boom!"),
	HAPPY_5 (MessageMoodEnum.HAPPY, "These guys are toast!"),
	
	HAPPY_2_R_1 (MessageMoodEnum.HAPPY, "You're on, "+MessagesConstants.TARGET_SUB+"!", true, HAPPY_2),
	HAPPY_2_R_2 (MessageMoodEnum.HAPPY, "Good luck with that, "+MessagesConstants.TARGET_SUB+"!", true, HAPPY_2),
	HAPPY_2_R_3 (MessageMoodEnum.HAPPY, "Not gonna happen, "+MessagesConstants.TARGET_SUB+"!", true, HAPPY_2),
	HAPPY_2_R_4 (MessageMoodEnum.ANGRY, MessagesConstants.TARGET_SUB+"! Now is not the time.", true, HAPPY_2),
	HAPPY_2_R_5 (MessageMoodEnum.ANGRY, "Seriously? Can it, "+MessagesConstants.TARGET_SUB+".", true, HAPPY_2),
	HAPPY_2_R_6 (MessageMoodEnum.ANGRY, "Hey "+MessagesConstants.TARGET_SUB+"! Shut your yap.", true, HAPPY_2),
	HAPPY_2_R_7 (MessageMoodEnum.SCARED, "No complaints here, "+MessagesConstants.TARGET_SUB+"...", true, HAPPY_2),
	HAPPY_2_R_8 (MessageMoodEnum.SCARED, "Be my guest, "+MessagesConstants.TARGET_SUB+"!", true, HAPPY_2),
	HAPPY_2_R_9 (MessageMoodEnum.SCARED, "Get them before they get me, "+MessagesConstants.TARGET_SUB+"!", true, HAPPY_2),
	
	ANGRY_1 (MessageMoodEnum.ANGRY, "These frakkin' aliens are getting under my skin!"),
	ANGRY_2 (MessageMoodEnum.ANGRY, "I'm going to KILL every one of these mother lovers!"),
	ANGRY_3 (MessageMoodEnum.ANGRY, "RRRAAAAAGGHHHHH!"),
	ANGRY_4 (MessageMoodEnum.ANGRY, "FOR FRAK'S SAKE, "+MessagesConstants.TARGET_SUB+"!", true),
	ANGRY_5 (MessageMoodEnum.ANGRY, "I'm gonna skin these lizards alive!"),
	
	ANGRY_4_R_1 (MessageMoodEnum.HAPPY, "Hey "+MessagesConstants.TARGET_SUB+", what's got your undies in a bundle?", true, ANGRY_4),
	ANGRY_4_R_2 (MessageMoodEnum.HAPPY, "Cool your jets, "+MessagesConstants.TARGET_SUB+"!", true, ANGRY_4),
	ANGRY_4_R_3 (MessageMoodEnum.HAPPY, "Save it for the lizards, "+MessagesConstants.TARGET_SUB+"!", true, ANGRY_4),
	ANGRY_4_R_4 (MessageMoodEnum.ANGRY, "WHAT'S YOUR PROBLEM, "+MessagesConstants.TARGET_SUB+"?!", true, ANGRY_4),
	ANGRY_4_R_5 (MessageMoodEnum.ANGRY, MessagesConstants.TARGET_SUB+"! Just wait til we get back!", true, ANGRY_4),
	ANGRY_4_R_6 (MessageMoodEnum.ANGRY, "I think I'll do it again to spite you, "+MessagesConstants.TARGET_SUB+"!", true, ANGRY_4),
	ANGRY_4_R_7 (MessageMoodEnum.SCARED, "Sorry, "+MessagesConstants.TARGET_SUB+"! Sorry! Sorry!", true, ANGRY_4),
	ANGRY_4_R_8 (MessageMoodEnum.SCARED, "Oh no! I'm so sorry "+MessagesConstants.TARGET_SUB+"!", true, ANGRY_4),
	ANGRY_4_R_9 (MessageMoodEnum.SCARED, "Agh! Crap! Sorry "+MessagesConstants.TARGET_SUB+"!", true, ANGRY_4),
	
	SCARED_1 (MessageMoodEnum.SCARED, "Guys, can we do this?"),
	SCARED_2 (MessageMoodEnum.SCARED, "My hands are shaking..."),
	SCARED_3 (MessageMoodEnum.SCARED, "We're gonna die, aren't we?"),
	SCARED_4 (MessageMoodEnum.SCARED, MessagesConstants.TARGET_SUB+", can you keep your eye on my six?", true),
	SCARED_5 (MessageMoodEnum.SCARED, "Is it too late to go back?"),
	
	SCARED_4_R_1 (MessageMoodEnum.HAPPY, "No problem, "+MessagesConstants.TARGET_SUB+". I got your back.", true, SCARED_4),
	SCARED_4_R_2 (MessageMoodEnum.HAPPY, "Gotcha covered, "+MessagesConstants.TARGET_SUB+".", true, SCARED_4),
	SCARED_4_R_3 (MessageMoodEnum.HAPPY, "You'll be fine, "+MessagesConstants.TARGET_SUB+"! I promise.", true, SCARED_4),
	SCARED_4_R_4 (MessageMoodEnum.ANGRY, "If it'll keep you from wetting your pants, "+MessagesConstants.TARGET_SUB+"!", true, SCARED_4),
	SCARED_4_R_5 (MessageMoodEnum.ANGRY, ""+MessagesConstants.TARGET_SUB+", do I have to do everything myself?!", true, SCARED_4),
	SCARED_4_R_6 (MessageMoodEnum.ANGRY, "For the last time, "+MessagesConstants.TARGET_SUB+", there's nothing at your six!", true, SCARED_4),
	SCARED_4_R_7 (MessageMoodEnum.SCARED, "Only if you'll watch mine, too, "+MessagesConstants.TARGET_SUB+"!", true, SCARED_4),
	SCARED_4_R_8 (MessageMoodEnum.SCARED, "I can try, "+MessagesConstants.TARGET_SUB+".", true, SCARED_4),
	SCARED_4_R_9 (MessageMoodEnum.SCARED, "Not sure how much help I'll be, "+MessagesConstants.TARGET_SUB+", but sure.", true, SCARED_4),
	
	COMBAT_AHEAD (MessageMoodEnum.COMBAT, "Bogeys straight ahead!"),
	COMBAT_LEFT (MessageMoodEnum.COMBAT, "Bogeys to the left!"),
	COMBAT_RIGHT (MessageMoodEnum.COMBAT, "Bogeys to the right!"),
	COMBAT_ABOVE (MessageMoodEnum.COMBAT, "Bogeys above me!"),
	COMBAT_BELOW (MessageMoodEnum.COMBAT, "Bogeys below me!"),
	COMBAT_BEHIND (MessageMoodEnum.COMBAT, "Bogey on my six!"),
	COMBAT_KILL (MessageMoodEnum.COMBAT, "Got one!"),
	COMBAT_SQUAD_KILL (MessageMoodEnum.COMBAT, "That squad is done!"),
	COMBAT_DEATH_1 (MessageMoodEnum.COMBAT, "AGGGHHHHH---"),
	COMBAT_DEATH_2 (MessageMoodEnum.COMBAT, "No no no no NO AGGHHH!"),
	
	HELP_AHEAD (MessageMoodEnum.HELP, "Need help, bogeys ahead!"),
	HELP_LEFT (MessageMoodEnum.HELP, "Need help, bogeys on my left!"),
	HELP_RIGHT (MessageMoodEnum.HELP, "Need help, bogeys on my right!"),
	HELP_ABOVE (MessageMoodEnum.HELP, "Need help, bogeys above me!"),
	HELP_BELOW (MessageMoodEnum.HELP, "Need help, bogeys below me!"),
	HELP_BEHIND (MessageMoodEnum.HELP, "Need help, bogeys on my six!"),
	HELP_COMING (MessageMoodEnum.HELP, "I'm on my way, "+MessagesConstants.TARGET_SUB+"!", true);
	
	
	
	private final MessageMoodEnum mood;
	private final String message;
	private final boolean hasTarget;
	private final MessagesEnum reactionTo;
	
	MessagesEnum(MessageMoodEnum mood, String message){
		this(mood, message, false, null);
	}
	
	MessagesEnum(MessageMoodEnum mood, String message, boolean hasTarget){
		this(mood, message, hasTarget, null);
	}
	
	MessagesEnum(MessageMoodEnum mood, String message, MessagesEnum reactionTo){
		this(mood, message, false, reactionTo);
	}
	
	MessagesEnum(MessageMoodEnum mood, String message, boolean hasTarget, MessagesEnum reactionTo){
		this.mood = mood;
		this.message = message;
		this.reactionTo = reactionTo;
		this.hasTarget = hasTarget;
	}
	
	public MessageMoodEnum mood(){
		return mood;
	}
	
	public String message(){
		return message;
	}
	
	public MessagesEnum reactionTo(){
		return reactionTo;
	}
	
	public boolean hasTarget(){
		return hasTarget;
	}
	
	public static List<MessagesEnum> getMessagesForMood(MessageMoodEnum mood){
		List<MessagesEnum> messages = new ArrayList<>();
		for(MessagesEnum message : MessagesEnum.values()){
			if(message.reactionTo() == null && message.mood().equals(mood)){
				messages.add(message);
			}
		}
		return messages;
	}
	
	public static List<MessagesEnum> getReactionsForMessageAndMood(MessagesEnum msg, MessageMoodEnum mood){
		List<MessagesEnum> messages = new ArrayList<>();
		for(MessagesEnum message : MessagesEnum.values()){
			if(message.reactionTo() != null && message.reactionTo().equals(msg) && message.mood().equals(mood)){
				messages.add(message);
			}
		}
		return messages;
	}
}
