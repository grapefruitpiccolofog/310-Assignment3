package main.java.twitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class twitterData {

	public static void main(String[] args) {
	    ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	          .setOAuthConsumerKey("db15O5LO8S3quu3lJmtp4j6hZ")
	          .setOAuthConsumerSecret("SF6PZALuAmID4A2Pzrn85D9KHK0Tuh4CUhcvSLqqj6g8w6mkdu")
	          .setOAuthAccessToken("")
	          .setOAuthAccessTokenSecret("");
	    TwitterFactory tf = new TwitterFactory(cb.build());
	    Twitter twitter = tf.getInstance();
	        try {
	            Query query = new Query("Steve Nash");
	            QueryResult result;
	            result = twitter.search(query);
	            List<Status> tweets = result.getTweets();
	            for (Status tweet : tweets) {
	                System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
	            }

	            System.exit(0);
	        } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to search tweets: " + te.getMessage());
	            System.exit(-1);
	        }
	}
}
