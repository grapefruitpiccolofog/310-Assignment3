package main.java.chat.component;

public class Response
{
    public enum QuestionFlag
    {
        QUESTION_ONLY, STATEMENT_ONLY, EITHER_QUESTION_OR_STATEMENT
    }

    private String[] keywords;
    private QuestionFlag questionFlag;
    private String[] responses;
    private int weight;

    public Response( String[] keywords, QuestionFlag questionFlag, String[] responses, int weight )
    {
        this.keywords = keywords;
        this.questionFlag = questionFlag;
        this.responses = responses;
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

    public QuestionFlag getQuestionFlag()
    {
        return questionFlag;
    }

    public void setQuestionFlag( QuestionFlag questionFlag )
    {
        this.questionFlag = questionFlag;
    }

    public String[] getResponses()
    {
        return responses;
    }

    public void setResponses( String[] responses )
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
    	str += "\nQuestionFlag: " + questionFlag + "\n";
    	str += "Responses: \n";
    	if(responses != null)
    		for(String s: responses)
    			str += s + "\n";
    	else 
    		str += "null";
        return str;
    }
}
