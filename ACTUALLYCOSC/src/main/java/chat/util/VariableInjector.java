package main.java.chat.util;

public interface VariableInjector
{
    String inject( String inputSentence, String... variables );
}
