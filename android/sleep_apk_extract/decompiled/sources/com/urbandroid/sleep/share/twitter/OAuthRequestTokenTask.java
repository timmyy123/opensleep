package com.urbandroid.sleep.share.twitter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/* JADX INFO: loaded from: classes5.dex */
public class OAuthRequestTokenTask extends AsyncTask<Void, Void, String> {
    private Activity context;

    public OAuthRequestTokenTask(Activity activity) {
        this.context = activity;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        try {
            ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
            configurationBuilder.setOAuthConsumerKey(Constants.CONSUMER_KEY);
            configurationBuilder.setOAuthConsumerSecret(Constants.CONSUMER_SECRET);
            configurationBuilder.setOAuthAccessTokenSecret("MmQ9k4gAH8UFh9jPCvo6sLd40Jg26BYxoaJNs5yEDghA9");
            RequestToken oAuthRequestToken = new TwitterFactory(configurationBuilder.build()).getInstance().getOAuthRequestToken();
            SharedPreferences.Editor editorEdit = this.context.getSharedPreferences(Constants.SERVICE_KEY, 0).edit();
            Logger.logInfo("Twitter Storing Request Token " + oAuthRequestToken.getToken());
            editorEdit.putString("twitter_request_token", oAuthRequestToken.getToken());
            editorEdit.putString("twitter_request_token_secret", oAuthRequestToken.getTokenSecret());
            editorEdit.apply();
            Logger.logInfo("Twitter Retrieving request token from Twitter servers");
            return oAuthRequestToken.getAuthenticationURL();
        } catch (Exception e) {
            Logger.logSevere("Twitter Error during OAUth retrieve request token", e);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        if (str == null) {
            Toast.makeText(this.context, R.string.message_connectivity_wait, 1).show();
            return;
        }
        Logger.logInfo("Twitter Popping a browser with the authorize URL : ".concat(str));
        this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).setFlags(ClientDefaults.MAX_MSG_SIZE));
    }
}
