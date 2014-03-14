package main.java.chat.util;

import java.util.Scanner;

/**
 * 
 * @author Barrett
 *
 */
public class TestParser {

//Instances
	public String[] responses= new String[5];
	public static boolean isQuestion, atEnd, atStart,contains=false;
	

	//version 2: Input Parser, and Word Properties/Location
	public static String k2P(String keyword, String userInput){
		//Instances
			String[] parsedUserInput,parsedUserInputSymbols;
			String delimsPuctuation="[ |,.?/;:{}\\-\\!\\)\\(]"; 
			String delimsAlphabet="[ qwertyuiopasdfghjklzxcvbnm]+";
		//Parse	
			//Parse out punctuation
			parsedUserInput=userInput.toLowerCase().split(delimsPuctuation,0);
			//Parse out letters
			parsedUserInputSymbols=userInput.toLowerCase().split(delimsAlphabet,0);
			
		//Word Properties/Position	
			//isQuestionFxn Call
			isQuestionFxn(userInput);
			//atStart
			if(parsedUserInput[0].matches(keyword)){
				atStart=true;
			}
			//atEnd
			if(parsedUserInput[parsedUserInput.length-1].matches(keyword)){
				atEnd=true;
			}
			//contains
			for(String s:parsedUserInput){
				if(s.matches(keyword)){
					contains=true;
				}
			}
			
			String result="Word: "+keyword+"\nisQuestion: "+isQuestion+"\natStart: "+atStart+"\ncontains: "+contains+"\natEnd: "+atEnd;
		return result;
	}
	
	//isQuestionFxn
	public static boolean isQuestionFxn(String theInput){
		return isQuestion=theInput.contains("?");
	}
	
	//ArrayIterator
	public static String ArrayIterator(String[] array){
		String result="";
		for(String s:array){
			result+=s+" \n";
		}
		return result;
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////	
	
//Main	
	public static void main(String[] args) {
		//Instances
		String input = null;
		String output= null;
		boolean ctd=true;
		//Scanners
		Scanner scan=new Scanner(System.in);
		
		do{
			//Introduction
			System.out.print("Please Type Statement (\"0\" to quit): ");
			//Scanner
			input=scan.nextLine();
			//ctd==true?
			if(input.equalsIgnoreCase("0")){
				ctd=false;
			}
			//Input Analysis/Output Deduction
			//output=inputAnalysis(input);
			//Report Output
			System.out.println(k2P("hello", input));
		}while(ctd==true);
		
		//End
		System.out.println("Quiting...");
		scan.close();
	}//main

}//class

///////////////////////////
//Methods
////InputAnalysis
//public static String inputAnalysis(String userInput){
//	//Variables
//	String[] parsedUserInput,parsedUserInputSymbols;
//	String delimsPuctuation="[ |,.?/;:{}\\-\\!\\)\\(]"; // no "\" as it is an escape seq. no "!" as it is illegal
//	String delimsAlphabet="[ qwertyuiopasdfghjklzxcvbnm]+";
//	//Parse out punctuation
//	parsedUserInput=userInput.toLowerCase().split(delimsPuctuation,0);
//	//Parse out letters
//	parsedUserInputSymbols=userInput.toLowerCase().split(delimsAlphabet,0);
//	//isQuestionFxn Call
//	isQuestionFxn(userInput);
//	
//	//null
//	String result = null;
//	
//   //Test
//	System.out.println(ArrayIterator(parsedUserInputSymbols));
//	System.out.println("_________\n"+ArrayIterator(parsedUserInput));
//	return result;
//}//input


////////////////////////////////////////////////////////////////////////////////////
//Useful

////location of word test
//public static String keywordPosition(String keyword, String theInput){
//	//Instances
//	String result="";
//	Boolean atEnd,atStart,contains=false;
//	
//	//atStart/End
//	
//	atEnd=theInput.toLowerCase().startsWith(keyword, theInput.length()-(keyword.length()+1)); //helloe sets it off
//	
//	atStart=theInput.toLowerCase().startsWith(keyword.toLowerCase());
//	
//	//contains
//	for(int i=0;i<theInput.length();i++){ //initial offset needed?
//	 if(theInput.toLowerCase().startsWith(keyword, i)){
//		 contains=true;
//	 }//if
//	}//for		
//	
//	//print out result
//	result="atStart: "+atStart+"\ncontains: "+contains+"\natEnd: "+atEnd;
//	return result;
//}


