package com.samsung.android.sdk.healthdata;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.samsung.android.sdk.internal.healthdata.ErrorUtil;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class HealthUserProfile {
    private final String a;
    private final float b;
    private final float c;
    private final String d;
    private final int e;
    private final String f;
    private final Bitmap g;

    private HealthUserProfile(String str, float f, float f2, String str2, int i, String str3, Bitmap bitmap) {
        this.a = str;
        this.b = f;
        this.c = f2;
        this.d = str2;
        this.e = i;
        this.f = str3;
        this.g = bitmap;
    }

    public static HealthUserProfile getProfile(HealthDataStore healthDataStore) {
        try {
            Bundle userProfile2 = HealthDataStore.getInterface(healthDataStore).getUserProfile2(healthDataStore.a().getPackageName());
            if (userProfile2 == null) {
                throw new IllegalStateException("profileBundle is null");
            }
            String string = userProfile2.getString("birth_date");
            float f = userProfile2.getFloat(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0.0f);
            float f2 = userProfile2.getFloat("weight", 0.0f);
            String string2 = userProfile2.getString("user_id");
            int i = userProfile2.getInt("gender", 0);
            String string3 = userProfile2.getString("name");
            byte[] byteArray = userProfile2.getByteArray("image");
            return new HealthUserProfile(string, f, f2, string2, i, string3, byteArray == null ? null : BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
        } catch (RemoteException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(ErrorUtil.getRemoteExceptionMessage(e));
            return null;
        }
    }

    public String getBirthDate() {
        return this.a;
    }

    public int getGender() {
        return this.e;
    }

    public float getHeight() {
        return this.b;
    }

    public float getWeight() {
        return this.c;
    }
}
