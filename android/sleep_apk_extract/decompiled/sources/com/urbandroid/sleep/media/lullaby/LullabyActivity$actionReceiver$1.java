package com.urbandroid.sleep.media.lullaby;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.media.lullaby.LullabyActivity;
import com.urbandroid.sleep.service.SharedApplicationContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/urbandroid/sleep/media/lullaby/LullabyActivity$actionReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LullabyActivity$actionReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ LullabyActivity this$0;

    public LullabyActivity$actionReceiver$1(LullabyActivity lullabyActivity) {
        this.this$0 = lullabyActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReceive$lambda$0(LullabyActivity lullabyActivity) {
        LullabyFragment fragment = lullabyActivity.getFragment();
        if (fragment != null) {
            fragment.refresh();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            action = null;
        }
        LullabyActivity.Companion companion = LullabyActivity.INSTANCE;
        if (Intrinsics.areEqual(action, companion.getACTION_CLOSE())) {
            if (this.this$0.getStartedFromTracking()) {
                this.this$0.finish();
            }
        } else {
            if (Intrinsics.areEqual(action, companion.getACTION_REFRESH())) {
                Logger.logInfo("Lullaby: refresh action");
                LullabyFragment fragment = this.this$0.getFragment();
                if (fragment != null) {
                    fragment.refresh();
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(action, companion.getACTION_REFRESH_SPOTIFY()) && SharedApplicationContext.getSettings().isSpotify()) {
                LullabyActivity lullabyActivity = this.this$0;
                MediaListActivity.loadSpotifyAlbums(lullabyActivity, new LullabyActivity$actionReceiver$1$$ExternalSyntheticLambda0(lullabyActivity, 0));
            }
        }
    }
}
