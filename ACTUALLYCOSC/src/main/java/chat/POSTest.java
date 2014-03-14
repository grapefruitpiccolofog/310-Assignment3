package main.java.chat;

import java.io.*;
import java.util.Scanner;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.postag.*;
import opennlp.tools.util.Sequence;
import opennlp.tools.util.Span;

public class POSTest {
	public static void main (String[] args){
		InputStream modelIn = null;
		InputStream modelIn1 = null;
		InputStream modelIn2 = null;
		InputStream modelIn3 = null;
		Scanner scan = new Scanner(System.in);

		try {
		  modelIn = new FileInputStream("en-pos-maxent.bin");
		  modelIn1 = new FileInputStream("en-ner-person.bin");//
		  modelIn2 = new FileInputStream("en-ner-organization.bin");
		  modelIn3 = new FileInputStream("en-ner-location.bin");
		  POSModel model = new POSModel(modelIn);
		  TokenNameFinderModel model1 = new TokenNameFinderModel(modelIn1);//
		  TokenNameFinderModel model2 = new TokenNameFinderModel(modelIn2);
		  TokenNameFinderModel model3 = new TokenNameFinderModel(modelIn3);
		  POSTaggerME tagger = new POSTaggerME(model);
		  NameFinderME nameFinder1 = new NameFinderME(model2);
		  NameFinderME nameFinder2 = new NameFinderME(model3);
		  System.out.println("Enter a Sentence");
		  String sentence = scan.nextLine();
		  sentence = sentence.replace(".", " . ");
		  sentence = sentence.replace("?", " ? ");
		  sentence = sentence.replace(",", " , ");
		  sentence = sentence.replace("!", " ! ");
		  String sent[] = sentence.split(" ");
		 // sent[] = new String[]{"Most", "large", "cities", "in", "Canada", "had",
                //  "morning", "and", "afternoon", "newspapers", "."};		  
		  String tags[] = tagger.tag(sent);
		  double probs[] = tagger.probs();
		  Sequence topSequences[] = tagger.topKSequences(sent);
		  
		  Span nameSpansorg[] = nameFinder1.find(sent);
		  Span nameSpansloc[] = nameFinder2.find(sent);
		  for (int i = 0; i < probs.length; i++){
			  System.out.println(sent[i] + " " + tags[i] + " " + probs[i]);
			  
		  }
		  
		  for (int j = 0; j < nameSpansloc.length ; j++){
			  System.out.println(nameSpansloc[j].getType());
			  System.out.println(sent[nameSpansloc[j].getStart()]);
		  }
		  
		  //To recognize people
		  NameFinderME nameFinder = new NameFinderME(model1);//
		  Span nameSpansper[] = nameFinder.find(sent);//
		  for (int j = 0; j < nameSpansper.length ; j++){
			  System.out.println(nameSpansper[j].getType());
			  System.out.println(sent[nameSpansper[j].getStart()]);
		  }
		  nameFinder.clearAdaptiveData();
		  
		  for (int j = 0; j < nameSpansorg.length ; j++){
			  System.out.println(nameSpansorg[j].getType());
			  System.out.println(sent[nameSpansorg[j].getStart()]);
		  }
		  System.out.println("Complete");
		}
		catch (IOException e) {
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
	}
}
