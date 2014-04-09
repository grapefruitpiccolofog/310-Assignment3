package main.java.Google;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class translateBing {
  public static String translate(String s) throws Exception {
    // Set your Windows Azure Marketplace client info - See http://msdn.microsoft.com/en-us/library/hh454950.aspx
    Translate.setClientId("6d116940-4e5e-475c-a546-f7dcf3bd8017");
    Translate.setClientSecret("40R/xve9LnSTG1N/BwiOaNPb0m8wpbeZQoqagCuxtmQ=");

    String translatedText = Translate.execute(s, Language.ENGLISH, Language.FRENCH);

    return translatedText;
  }
}