package com.urbandroid.sleep.smartlight;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0006\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\rJ\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096D¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/sleep/smartlight/Dummy;", "Lcom/urbandroid/sleep/smartlight/SmartLight;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "", "off", "", "force", "(Z)V", "", "timeoutSeconds", "nightLight", "(I)V", "progress", "max", "sunrise", "(II)V", "sunriseStart", "sunriseFull", ViewHierarchyConstants.HINT_KEY, "loop", "shortHint", "close", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Dummy implements SmartLight, FeatureLogger {
    private final String tag = Common_smartlightKt.TAG;

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void close() {
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void hint() {
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void nightLight(int timeoutSeconds) {
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void off() {
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void shortHint() {
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunrise(int progress, int max) {
        String strM = Fragment$$ExternalSyntheticOutline1.m(progress, max, "SmartLight: Dummy sunrise ", " / ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunriseFull() {
        Logger.logInfo(Logger.defaultTag, getTag() + ": SmartLight: Dummy light full", null);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunriseStart() {
        Logger.logInfo(Logger.defaultTag, getTag() + ": SmartLight: Dummy light start", null);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void hint(int loop) {
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void off(boolean force) {
    }
}
