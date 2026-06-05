package com.urbandroid.sleep.share.twitter;

import android.content.SharedPreferences;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterV2ExKt;
import twitter4j.auth.AccessToken;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TwitterUtils {
    public static boolean isAuthenticated(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("twitter_oauth_token", "");
        if (string != null && string.length() >= 1) {
            AccessToken accessToken = new AccessToken(string, sharedPreferences.getString("twitter_oauth_token_secret", ""));
            Twitter twitterFactory = new TwitterFactory().getInstance();
            twitterFactory.setOAuthConsumer(Constants.CONSUMER_KEY, Constants.CONSUMER_SECRET);
            twitterFactory.setOAuthAccessToken(accessToken);
            if (twitterFactory.getAuthorization() != null) {
                return true;
            }
        }
        return false;
    }

    public static void sendTweet(SharedPreferences sharedPreferences, String str, String str2, byte[] bArr) {
        AccessToken accessToken = new AccessToken(sharedPreferences.getString("twitter_oauth_token", ""), sharedPreferences.getString("twitter_oauth_token_secret", ""));
        Twitter twitterFactory = new TwitterFactory().getInstance();
        twitterFactory.setOAuthConsumer(Constants.CONSUMER_KEY, Constants.CONSUMER_SECRET);
        twitterFactory.setOAuthAccessToken(accessToken);
        TwitterV2ExKt.getV2(twitterFactory).createTweet(null, null, null, null, null, null, null, null, null, null, null, str);
    }

    public static void sendTweet(SharedPreferences sharedPreferences, String str) {
        sendTweet(sharedPreferences, str, null, null);
    }
}
