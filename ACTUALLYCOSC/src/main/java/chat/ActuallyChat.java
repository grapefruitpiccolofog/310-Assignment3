package main.java.chat;

import java.util.Scanner;

public class ActuallyChat implements Chat
{
    boolean chat;
    Responder responder;
    Scanner scan;

    public ActuallyChat()
    {
        chat = true;
        scan = new Scanner( System.in );
        // TODO
    }//Constructor

    @Override
    public void initialize( Responder responderIn )
    {
        responder = responderIn;
        responder.readConfigFile();

    }//initialize

    @Override
    public String getSentence()
    {
        return scan.nextLine();
    }//getSentence()

    private void print( String string )
    {
    	System.out.println( string );
    }//print
    @Override
    public void chat()
    {
        //greet;
    	print( "Welcome to Chat." );
    	
        //chat
        while( chat )
        {
            String sentence = getSentence();

            try{
            	String output=responder.respond(sentence);
            	System.out.println(output);
            }catch(IllegalArgumentException x){
            	System.out.println("I don't understand how to respond: an IllegalArgument keeps calling me.");
            }catch(NullPointerException x){
            	System.out.println("I missed that. Let's pretend that last thing was null.");
            }//try/catch
        }//while
    }//chat
}
