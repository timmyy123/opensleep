package com.urbandroid.sleep.share.twitter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.Measure;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.share.AbstractAsyncShareService;
import java.io.Serializable;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes5.dex */
public class TwitterAPI extends AbstractAsyncShareService {
    @Override // com.urbandroid.sleep.share.IShareService
    public boolean authenticate(Context context) {
        return TwitterUtils.isAuthenticated(getPrefs(context));
    }

    @Override // com.urbandroid.sleep.share.AbstractAsyncShareService
    public void doPublishImageAndCommentIt(Context context, byte[] bArr, Object obj) {
        Logger.logInfo("Publish image and comment it begin");
        TwitterUtils.sendTweet(getPrefs(context), new SleepRecordStringBuilder(context).setAppendComment(new Settings(context).isPublicComment()).setLimit(124).setAppendSparkleTweet(true).setAppendMeasures(true, Measure.ALL_TWITTER).setShort(true).setPrependSleep(true).setAppendAppName(true).setAppendAppHashtag(true).build((SleepRecord) obj), context.getString(R.string.app_name_long), bArr);
        Logger.logInfo("Publish image and comment it done");
    }

    @Override // com.urbandroid.sleep.share.AbstractAsyncShareService
    public void doPublishStatus(Context context, String str) {
        TwitterUtils.sendTweet(getPrefs(context), str);
    }

    @Override // com.urbandroid.sleep.share.IShareService
    public String getName(Context context) {
        return "X (Twitter)";
    }

    @Override // com.urbandroid.sleep.share.AbstractShareService
    public String getServiceKey() {
        return Constants.SERVICE_KEY;
    }

    @Override // com.urbandroid.sleep.share.AbstractShareService
    public String getTokenKey() {
        return "twitter_oauth_token";
    }

    @Override // com.urbandroid.sleep.share.IShareService
    public void initiateLoginActivity(Context context, Object obj) {
        Intent intent = new Intent(context.getApplicationContext(), (Class<?>) InitiateLoginActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        }
        if (obj != null) {
            intent.putExtra("sharing_resubmit_object_key", (Serializable) obj);
        }
        context.startActivity(intent);
    }
}
