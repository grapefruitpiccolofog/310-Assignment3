package main.java.chat.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Keyword
{
    public enum MatchType
    {
        EXACT, STARTS_WITH, ENDS_WITH, CONTAINS
    }

    public enum KeywordType
    {
        WORD, PHRASE
    }

    String[] keywords;
    private KeywordType type;
    private MatchType sentenceMatch;
    private MatchType wordMatch;
    private List<Response> responses;
    private String randResponse;

    private int weight;

    public Keyword( String[] keywords, KeywordType type, MatchType sentenceMatch, MatchType wordMatch, List<Response> responses, int weight )
    {
        this.keywords = keywords;
        this.type = type;
        this.sentenceMatch = sentenceMatch;
        this.wordMatch = wordMatch;
        this.responses = new ArrayList<Response>();
        this.responses.addAll(responses);
        this.weight = weight;
    }

    public String[] getKeywords()
    {
        return keywords;
    }

    public void setKeywords( String[] keywords )
    {
        this.keywords = keywords;
    }

    public KeywordType getType()
    {
        return type;
    }

    public void setType( KeywordType type )
    {
        this.type = type;
    }

    public MatchType getSentenceMatch()
    {
        return sentenceMatch;
    }

    public void setSentenceMatch( MatchType sentenceMatch )
    {
        this.sentenceMatch = sentenceMatch;
    }

    public MatchType getWordMatch()
    {
        return wordMatch;
    }

    public void setWordMatch( MatchType wordMatch )
    {
        this.wordMatch = wordMatch;
    }

    public List<Response> getResponses()
    {
        return responses;
    }
    
    public String getRandResponse(){
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

    public void setResponses( List<Response> responses )
    {
        this.responses = responses;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight( int weight )
    {
        this.weight = weight;
    }

    public String toString()
    {
    	String str = "Keywords: ";
    	if(keywords != null)
    		for(String s: keywords)
    			if (!s.equals(keywords[keywords.length - 1]))
    				str += s + " | ";
    			else
    				str += s;
    	else 
    		str += "null";
    	str += "\nType:" + type + "\nSentence Match: " + sentenceMatch + "\nWord Match: " + wordMatch + "\n";
    	str += "Responses: \n\n";
    	if(responses != null)
    		for(Response r: responses)
    			str += r.toString() + "\n";
    	else 
    		str += "null\n";
    	str += "Weight:" + weight + "\n";
        return str;
    }
}
