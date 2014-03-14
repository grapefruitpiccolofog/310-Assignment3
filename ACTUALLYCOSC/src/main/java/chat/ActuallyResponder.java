package main.java.chat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.postag.*;
import opennlp.tools.util.Sequence;
import opennlp.tools.util.Span;

import java.util.List;
import java.util.Random;

import main.java.chat.component.Keyword;
import main.java.chat.util.SentenceParser;
import main.java.chat.util.ReadABook;

public class ActuallyResponder implements Responder {
	private static List<Keyword> keywords;
	public static boolean lovehate = true; //when true it means the system likes you

	public ActuallyResponder() {
		// TODO
	}

	@Override
	public void readConfigFile() {

		ReadABook.fileReader("src/main/java/chat/input/Input.txt");

        ActuallyResponder.keywords = new ArrayList<Keyword>();
        ActuallyResponder.keywords.addAll(ReadABook.fileReader("src/main/java/chat/input/Input.txt"));

	}

	@Override
	public String respond(String inputSentence) {
		// Method Instance Variables
		SentenceParser parser = new SentenceParser();
		String[] arrayParsedInput;
		boolean done=false;
		Keyword match=null;
		String responseMatch=null;
		String senten = inputSentence;
		String name = null;
		
		InputStream modelIn = null;
		
		try {
			modelIn = new FileInputStream("en-ner-person.bin");
			TokenNameFinderModel model1 = new TokenNameFinderModel(modelIn);
			senten = senten.replace(".", " . ");
			senten = senten.replace("?", " ? ");
			senten = senten.replace(",", " , ");
			senten = senten.replace("!", " ! ");
			String sent[] = senten.split(" ");
			NameFinderME nameFinder = new NameFinderME(model1);
			Span nameSpansper[] = nameFinder.find(sent);
			//for (int j = 0; j < nameSpansper.length ; j++){
			if (nameSpansper.length > 0)
				  name = sent[nameSpansper[0].getStart()] + " " + sent[nameSpansper[0].getEnd() - 1];
			 // }
			
		}catch (IOException e) {
			  // Model loading failed, handle the error
			  e.printStackTrace();
			}
			finally {
			  if (modelIn != null) {
			    try {
			      modelIn.close();
			    }
			    catch (IOException e) {
			    }
			  }
			}

		//(1) First Step: Parse inputSentence into local arrayParsedInput[] String array.
		arrayParsedInput = parser.userInputParser(inputSentence);


		//(2) Second Step: Use SentenceParser.compareKeywordToInput() method to compare each -
		// - Keyword from "keywords" list against the parsed user input "arrayParsedInput".  
		while(!done){
			//Using the SentenceParser.compareKeywordToInput() method to return the directly matching keyword.
			//We use a for iterator to hand the method each Keyword k in "keywords" list.
			for(int k=0;k<keywords.size();k++){ 											
				//Assign Keyword "match" to either null or the correct keyword.
				match=parser.compareKeywordToInput(keywords.get(k), arrayParsedInput);
				
				//If match is NOT null, break the "keywords" for loop. This is the exit conditional.
				if(match!=null){
					break;
				}else if(k==keywords.size()-1){
					//If no keywords have been identified (i.e: match==null) by this last iteration, it is about to break the "keywords" for loop. 
					//So, we need to assign "match" to something before it leaves. The first keywords keyword element is assigned to "match".
					match=keywords.get(0); //!@#$place randgen
				}
			}//k
			
			//Now, with the appropriate keyword in hand ("match"), we use the parser's SentenceParser.compareKeywordResponseToInput() method. 
			//So, for each of the Responses listed in match's "response[]" Response array, as soon as one is hit, -
			//- that string is set to the "resoponseMatch" string.
			//for(int r=0;r<match.getResponses().size();r++){ Original for loop
				//System.out.println(r); Used for testing delete
				
				
				if (lovehate == true){
					responseMatch=parser.compareKeywordResponsesToInput(match.getResponses().get(0), arrayParsedInput);
				}else{
					responseMatch=parser.compareKeywordResponsesToInput(match.getResponses().get(1), arrayParsedInput);
				}
				
				if (match.getKeywords()[0].equals("annoying") == true){
					lovehate = false;
				}
				if(match.getKeywords()[0].equals("sorry") == true){
					lovehate = true;
				}
				
				if (match.getKeywords()[0].equals("know") == true){
					if (name != null)
						responseMatch = responseMatch + name;
				}
				
				//if the first response is chosen, set responseMatch to something random from getRandResponses
				if (responseMatch.equals("problem") == true){
					responseMatch=match.getRandResponse();
					done=true;
				}else if(responseMatch!=null){//for all other cases that "responseMatch" is NOT null, break the response for loop. This is the exit conditional.
					//Now, with a value for responseMatch, set "done"=true to stop the whole ActuallyResponder.respond() method.
					done=true;
					break;
				}else{
					//If no "responseMatch" strings have been identified (i.e: responseMatch==null), it is set to the first response[] string.
					//!@#$change notes: removed randgen
					responseMatch=match.getResponses().get(0).toString();
					//Now, with a value for responseMatch, set "done"=true to stop the whole ActuallyResponder.respond() method.
					done=true;
				}
			//}//r Original for loop
			
		//By this point, the "responseMatch" string now has a value(i.e: "the computers response").
			
		}//!done
		
		//Return the computer's response in String format.
		return responseMatch;
		
	}// respond

}// class
