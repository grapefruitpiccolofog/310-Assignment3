package main.java.Google;
import com.google.api.GoogleAPI;
import com.google.api.GoogleAPIException;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;

public class translateData {

	public static void main(String[] args) throws GoogleAPIException {
		// Set the HTTP referrer to your website address.
	    GoogleAPI.setHttpReferrer("http://translate.google.com/");

	    // Set the Google Translate API key
	    // See: http://code.google.com/apis/language/translate/v2/getting_started.html
	    GoogleAPI.setKey("AIzaSyBn4qi3FfwPRFjKq12caNntLshhmA9ScAg");

	    String translatedText = Translate.DEFAULT.execute("Bonjour le monde", Language.FRENCH, Language.ENGLISH);

	    System.out.println(translatedText);
	}

}
