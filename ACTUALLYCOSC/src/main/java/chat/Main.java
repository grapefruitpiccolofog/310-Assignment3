package main.java.chat;

public class Main
{
    public static void main( String[] args )
    {
        Chat chat = new ActuallyChat();
        chat.initialize( new ActuallyResponder() );
        chat.chat();
    }
}
