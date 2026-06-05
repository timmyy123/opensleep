package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.R$styleable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzz {
    private final AdSize[] zza;
    private final String zzb;

    public zzz(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.AdsAttrs);
        String string = typedArrayObtainAttributes.getString(R$styleable.AdsAttrs_adSize);
        String string2 = typedArrayObtainAttributes.getString(R$styleable.AdsAttrs_adSizes);
        boolean zIsEmpty = TextUtils.isEmpty(string);
        boolean zIsEmpty2 = TextUtils.isEmpty(string2);
        if (!zIsEmpty && zIsEmpty2) {
            this.zza = zzc(string);
        } else {
            if (!zIsEmpty || zIsEmpty2) {
                if (zIsEmpty) {
                    typedArrayObtainAttributes.recycle();
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Required XML attribute \"adSize\" was missing.");
                    throw null;
                }
                typedArrayObtainAttributes.recycle();
                Utf8$$ExternalSyntheticBUOutline0.m$2("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
                throw null;
            }
            this.zza = zzc(string2);
        }
        String string3 = typedArrayObtainAttributes.getString(R$styleable.AdsAttrs_adUnitId);
        this.zzb = string3;
        typedArrayObtainAttributes.recycle();
        if (TextUtils.isEmpty(string3)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Required XML attribute \"adUnitId\" was missing.");
            throw null;
        }
    }

    private static AdSize[] zzc(String str) {
        String[] strArrSplit = str.split("\\s*,\\s*");
        int length = strArrSplit.length;
        AdSize[] adSizeArr = new AdSize[length];
        for (int i = 0; i < strArrSplit.length; i++) {
            String strTrim = strArrSplit[i].trim();
            if (strTrim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] strArrSplit2 = strTrim.split("[xX]");
                strArrSplit2[0] = strArrSplit2[0].trim();
                strArrSplit2[1] = strArrSplit2[1].trim();
                try {
                    String str2 = strArrSplit2[0];
                    int i2 = "FULL_WIDTH".equals(str2) ? -1 : Integer.parseInt(str2);
                    String str3 = strArrSplit2[1];
                    adSizeArr[i] = new AdSize(i2, "AUTO_HEIGHT".equals(str3) ? -2 : Integer.parseInt(str3));
                } catch (NumberFormatException unused) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Could not parse XML attribute \"adSize\": ".concat(strTrim));
                    return null;
                }
            } else if ("BANNER".equals(strTrim)) {
                adSizeArr[i] = AdSize.BANNER;
            } else if ("LARGE_BANNER".equals(strTrim)) {
                adSizeArr[i] = AdSize.LARGE_BANNER;
            } else if ("FULL_BANNER".equals(strTrim)) {
                adSizeArr[i] = AdSize.FULL_BANNER;
            } else if ("LEADERBOARD".equals(strTrim)) {
                adSizeArr[i] = AdSize.LEADERBOARD;
            } else if ("MEDIUM_RECTANGLE".equals(strTrim)) {
                adSizeArr[i] = AdSize.MEDIUM_RECTANGLE;
            } else if ("SMART_BANNER".equals(strTrim)) {
                adSizeArr[i] = AdSize.SMART_BANNER;
            } else if ("WIDE_SKYSCRAPER".equals(strTrim)) {
                adSizeArr[i] = AdSize.WIDE_SKYSCRAPER;
            } else if ("FLUID".equals(strTrim)) {
                adSizeArr[i] = AdSize.FLUID;
            } else {
                if (!"ICON".equals(strTrim)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Could not parse XML attribute \"adSize\": ".concat(strTrim));
                    return null;
                }
                adSizeArr[i] = AdSize.zza;
            }
        }
        if (length != 0) {
            return adSizeArr;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Could not parse XML attribute \"adSize\": ".concat(str));
        return null;
    }

    public final AdSize[] zza(boolean z) {
        if (z || this.zza.length == 1) {
            return this.zza;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("The adSizes XML attribute is only allowed on PublisherAdViews.");
        return null;
    }

    public final String zzb() {
        return this.zzb;
    }
}
