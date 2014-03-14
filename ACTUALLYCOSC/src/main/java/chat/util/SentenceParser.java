package main.java.chat.util;

import java.util.Random;

import main.java.chat.component.Keyword;
import main.java.chat.component.Response;

public class SentenceParser {

	//Default Constructor
	public SentenceParser(){
		
	}//sentenceParser
	
	
	// userInputParser
	public String[] userInputParser(String userInput){
		//Method Instances
		String[] parsedUserInput;
		String delimsPuctuation = "[ |,.?/;:{}\\-\\!\\)\\(]";
		
		//Parse out punctuation from the userInput.
		parsedUserInput = userInput.toLowerCase().split(delimsPuctuation, 0);
		
		return parsedUserInput;	
	}//userInputParser
	
	
	//compareKeyWordToInput
	public Keyword compareKeywordToInput(Keyword theKey,String[] theStringArray){
		//Method Instances
		Keyword result = null;
		
		//(1)First Step: Get Keyword "theKey"'s enumerated word 'MatchType'.
		switch (theKey.getSentenceMatch()) 
		{
		case ENDS_WITH:
			//For each element of Keyword "theKey"'s keyword[] string array,-
			for(String s: theKey.getKeywords()){
				//-, if that keyword element matches the last entry of "theStringArray" (a.k.a: the parsed user input array).
				if(theStringArray[theStringArray.length-1].matches(s)){
					//Set the returned "result" Keyword variable as "theKey" (aka: the relevant Keyword).
					result=theKey;
					break;
				}//if
			}//forS
			break;
			
		case STARTS_WITH:
			//For each element of Keyword "theKey"'s keyword[] string array,-
			for(String s: theKey.getKeywords()){
				//-, if that keyword element matches the first entry of "theStringArray" (a.k.a: the parsed user input array).
				if(theStringArray[0].matches(s)){
					//Set the returned "result" Keyword variable as "theKey" (aka: the relevant Keyword).
					result=theKey;
					break;
				}//if
			}//forS
			break;
		case CONTAINS: 	
			contains://break label
			//For each element of Keyword "theKey"'s keyword[] string array,-
			for(String s: theKey.getKeywords()){
				//- and for each string element in "theStringArray" (a.k.a: the parsed user input array).
				for(String r : theStringArray){
					if(s.equals(r)){
						//Set the returned "result" Keyword variable as "theKey" (aka: the relevant Keyword).
						result=theKey;
						break contains;
					}//if
				}//forR
			}//forS
			break;
		case EXACT:  //!@# Note: This case was added to prevent bugs. Correct search method needed later. 	
			exact://break label
			//For each element of Keyword "theKey"'s keyword[] string array,-
			for(String s: theKey.getKeywords()){
				//- and for each string element in "theStringArray" (a.k.a: the parsed user input array).
				for(String r : theStringArray){
					if(s.equals(r)){
						//Set the returned "result" Keyword variable as "theKey" (aka: the relevant Keyword).
						result=theKey;
						break exact;
						
					}//if
				}//forR
			}//forS
			break;
		//default
		default:
			//Keyword not given MatchType
			System.out.println("Keyword not given MatchType");
			break;
		}//switch
		
		//Return Keyword "result" (the first appropriate keyword to the user's input)
		return result;		
	}//compareKeywordToInput
	
	
	//compareKeywordResponsesToInput
	public String compareKeywordResponsesToInput(Response theResponse,String[] theStringArray){
		//Method Instances
		String finalResponse=null;
		
		//Now, we are being given the individual Responses of the matched keyword. We can now match -
		//- each Response object's contained "keywords" string[] (i.e: secondary keywords matching
		//- a particular response) for further response specification.
		searchResponse: //break tag
		//For each one of this Response's keyword strings, -
		for(String k: theResponse.getKeywords()){
			//- and for each word of "theStringArray" (i.e: user's parsed input),-
			for(int s=0;s<theStringArray.length;s++){
				if(k.matches(theStringArray[s])){
					//-, find a match and set the "finalResponse" string to an appropriate (!@#randgen?) response string.
					finalResponse=theResponse.getResponses()[0]; //!@#$ change note: randgen removed
					break searchResponse;
				}
			}//s
		}//k
		
		//conditional check to ensure "finalResonse"!=null. This sets a resopnse in case of no secondary keyword hit.
		if(finalResponse==null){
			//randomly generated number (appropriate to response[]) used to set 'finalResponse' string to the 'temp'th element of responses
			finalResponse=theResponse.getResponses()[0]; //!@#$ change note: reoved randgen
		}
		
		//Return the string containing the computer's appropriate statement.
		return finalResponse;
	}//compareKeywordResponseToInput
	
	
}// class
