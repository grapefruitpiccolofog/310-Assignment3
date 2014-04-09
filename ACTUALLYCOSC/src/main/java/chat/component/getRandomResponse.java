package main.java.chat.component;

import java.util.Random;

public class getRandomResponse {
	public static String getRandomResponse(){
		
		String randResponse;
		Random rand = new Random();
    	int randInt = rand.nextInt(5);
    	
    	switch (randInt){
    	case 1: randResponse = "Aren't we on a date? Lets talk about that.";
    		break;
    	case 2: randResponse = "Don't go there.";
    		break;
    	case 3: randResponse = "How about we focus on us";
    		break;
    	case 4: randResponse = "What does that mean?";
    		break;
    	case 5: randResponse = "Tell me you like me again.";
    		break;
    	default: randResponse = "Aren't we on a date? Lets talk about that.";
    		break;
    	}
    	
    	return randResponse;
		
	}
}
