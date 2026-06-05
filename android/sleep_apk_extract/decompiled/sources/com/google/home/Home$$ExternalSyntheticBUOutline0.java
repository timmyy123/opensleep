package com.google.home;

import com.google.android.ump.ConsentInformation;
import com.google.android.ump.FormError;
import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import com.philips.lighting.hue.sdk.exception.PHHueInvalidAPIException;
import com.urbandroid.privacy.Consent;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.ChronoRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.ChronoRecords;
import java.io.FileNotFoundException;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Home$$ExternalSyntheticBUOutline0 implements ConsentInformation.OnConsentInfoUpdateFailureListener, ChronoRecords.RecordToFloat, ChronoRecords.RecordToBool {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Home$$ExternalSyntheticBUOutline0(int i) {
        this.$r8$classId = i;
    }

    public static /* synthetic */ void m(int i, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append((Object) "#read(byte[]) returned invalid result: ");
        sb.append(i);
        sb.append((Object) "\nThe InputStream implementation is buggy.");
        throw new IllegalStateException(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m$1(int i, int i2) {
        throw new ArrayIndexOutOfBoundsException("Failed writing " + ((char) i) + ((Object) " at index ") + i2);
    }

    public static /* synthetic */ void m$2(String str, Object obj) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void m$3() {
        throw new PHHueInvalidAPIException(PHHueResourcesConstants.TXT_INVALID_API_CALL);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.socialjetlag.ChronoRecords.RecordToFloat
    public float apply(ChronoRecord chronoRecord) {
        switch (this.$r8$classId) {
            case 24:
                return chronoRecord.getMidSleep();
            case 25:
                return chronoRecord.getMidSleepUTC();
            case 26:
                return chronoRecord.getLength();
            case 27:
                return chronoRecord.getToHour();
            default:
                return chronoRecord.getFromHour();
        }
    }

    @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateFailureListener
    public void onConsentInfoUpdateFailure(FormError formError) {
        Consent.Companion.loadAndShowConsent$lambda$1(formError);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(int i, int i2) {
        throw new ArrayIndexOutOfBoundsException("Failed writing " + ((char) i) + ((Object) " at index ") + i2);
    }

    public static /* synthetic */ void m$1() {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ void m$2() {
        throw new IllegalStateException();
    }

    public static /* synthetic */ void m(int i, int i2, String str) {
        throw new IllegalArgumentException(str + i + 'x' + i2);
    }

    public static /* synthetic */ void m$1(String str, Object obj) throws FileNotFoundException {
        throw new FileNotFoundException(str + obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(int i, long j) {
        throw new ArrayIndexOutOfBoundsException("Failed writing " + ((char) i) + ((Object) " at index ") + j);
    }

    public static /* synthetic */ void m$1(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void m() {
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ void m$1(String str, Object[] objArr) {
        throw new ArrayIndexOutOfBoundsException(String.format(str, objArr));
    }

    public static /* synthetic */ void m(long j) {
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + j);
    }

    public static /* synthetic */ void m$1(StringBuilder sb, Object obj, Object obj2) {
        sb.append(obj);
        sb.append(obj2);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public static /* synthetic */ void m(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public static /* synthetic */ void m(Object obj, Object obj2, int i, Object obj3, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        sb.append(i);
        sb.append(obj3);
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void m(String str, double d) {
        throw new IllegalArgumentException(str + d);
    }

    public static /* synthetic */ void m(String str, Object obj) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2) {
        throw new IllegalArgumentException((str + obj + obj2).toString());
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException((str + obj + obj2 + obj3).toString());
    }

    public static /* synthetic */ void m(String str, Object[] objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static /* synthetic */ void m(StringBuilder sb, Object obj, Object obj2) {
        sb.append(obj);
        sb.append(obj2);
        throw new IllegalArgumentException(sb.toString());
    }
}
