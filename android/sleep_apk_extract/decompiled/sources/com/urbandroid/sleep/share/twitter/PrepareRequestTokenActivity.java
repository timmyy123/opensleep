package com.urbandroid.sleep.share.twitter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.settings.SocialSettingsActivity;
import com.urbandroid.sleep.share.ShareLoginActivity;
import oauth.signpost.OAuth;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/* JADX INFO: loaded from: classes5.dex */
public class PrepareRequestTokenActivity extends ShareLoginActivity {

    public class RetrieveAccessTokenTask extends AsyncTask<Uri, Void, Void> {
        private SharedPreferences prefs;

        public RetrieveAccessTokenTask(SharedPreferences sharedPreferences) {
            this.prefs = sharedPreferences;
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Uri... uriArr) {
            String queryParameter = uriArr[0].getQueryParameter(OAuth.OAUTH_VERIFIER);
            ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
            configurationBuilder.setOAuthConsumerKey(Constants.CONSUMER_KEY);
            configurationBuilder.setOAuthConsumerSecret(Constants.CONSUMER_SECRET);
            Twitter twitterFactory = new TwitterFactory(configurationBuilder.build()).getInstance();
            try {
                String string = this.prefs.getString("twitter_request_token", "");
                String string2 = this.prefs.getString("twitter_request_token_secret", "");
                Logger.logInfo("Twitter Retrieved Request Token " + string);
                AccessToken oAuthAccessToken = twitterFactory.getOAuthAccessToken(new RequestToken(string, string2), queryParameter);
                SharedPreferences.Editor editorEdit = this.prefs.edit();
                editorEdit.putString("twitter_oauth_token", oAuthAccessToken.getToken());
                editorEdit.putString("twitter_oauth_token_secret", oAuthAccessToken.getTokenSecret());
                editorEdit.putString("twitter_request_token", "");
                editorEdit.putString("twitter_request_token_secret", "");
                editorEdit.apply();
                return null;
            } catch (Exception e) {
                Logger.logSevere("Twitter OAuth - Access Token Retrieval Error", e);
                return null;
            }
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.logInfo("Twitter Prepare Request Token  Activity Start");
        GlobalInitializator.initializeIfRequired(this);
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.SERVICE_KEY, 0);
        Uri data2 = getIntent().getData();
        if (data2 == null || !data2.getScheme().equals(TournamentShareDialogURIBuilder.scheme)) {
            Logger.logSevere("Twitter PrepareRequestTokenActivity started without a callback from oauth");
        } else {
            new RetrieveAccessTokenTask(sharedPreferences) { // from class: com.urbandroid.sleep.share.twitter.PrepareRequestTokenActivity.1
                @Override // android.os.AsyncTask
                public void onPostExecute(Void r3) {
                    super.onPostExecute(r3);
                    PrepareRequestTokenActivity.this.resubmit();
                    Intent intent = new Intent(PrepareRequestTokenActivity.this, (Class<?>) SocialSettingsActivity.class);
                    intent.setFlags(872415232);
                    PrepareRequestTokenActivity.this.startActivity(intent);
                    PrepareRequestTokenActivity.this.finish();
                }
            }.execute(data2);
        }
    }
}
