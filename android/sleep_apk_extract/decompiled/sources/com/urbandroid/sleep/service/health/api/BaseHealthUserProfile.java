package com.urbandroid.sleep.service.health.api;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.urbandroid.sleep.service.health.api.HealthUserProfile;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001f\u0010\u001e¨\u0006 "}, d2 = {"Lcom/urbandroid/sleep/service/health/api/BaseHealthUserProfile;", "Lcom/urbandroid/sleep/service/health/api/HealthUserProfile;", "Ljava/util/Date;", "birthDate", "Lcom/urbandroid/sleep/service/health/api/HealthUserProfile$Gender;", "gender", "", "heightInCentimeters", "weightInKilograms", "<init>", "(Ljava/util/Date;Lcom/urbandroid/sleep/service/health/api/HealthUserProfile$Gender;FF)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Date;", "getBirthDate", "()Ljava/util/Date;", "Lcom/urbandroid/sleep/service/health/api/HealthUserProfile$Gender;", "getGender", "()Lcom/urbandroid/sleep/service/health/api/HealthUserProfile$Gender;", "F", "getHeightInCentimeters", "()F", "getWeightInKilograms", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class BaseHealthUserProfile implements HealthUserProfile {
    private final Date birthDate;
    private final HealthUserProfile.Gender gender;
    private final float heightInCentimeters;
    private final float weightInKilograms;

    public BaseHealthUserProfile(Date date, HealthUserProfile.Gender gender, float f, float f2) {
        gender.getClass();
        this.birthDate = date;
        this.gender = gender;
        this.heightInCentimeters = f;
        this.weightInKilograms = f2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BaseHealthUserProfile)) {
            return false;
        }
        BaseHealthUserProfile baseHealthUserProfile = (BaseHealthUserProfile) other;
        return Intrinsics.areEqual(this.birthDate, baseHealthUserProfile.birthDate) && this.gender == baseHealthUserProfile.gender && Float.compare(this.heightInCentimeters, baseHealthUserProfile.heightInCentimeters) == 0 && Float.compare(this.weightInKilograms, baseHealthUserProfile.weightInKilograms) == 0;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthUserProfile
    public Date getBirthDate() {
        return this.birthDate;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthUserProfile
    public HealthUserProfile.Gender getGender() {
        return this.gender;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthUserProfile
    public float getHeightInCentimeters() {
        return this.heightInCentimeters;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthUserProfile
    public float getWeightInKilograms() {
        return this.weightInKilograms;
    }

    public int hashCode() {
        Date date = this.birthDate;
        return Float.hashCode(this.weightInKilograms) + Fragment$$ExternalSyntheticOutline1.m(this.heightInCentimeters, (this.gender.hashCode() + ((date == null ? 0 : date.hashCode()) * 31)) * 31, 31);
    }

    public String toString() {
        return "BaseHealthUserProfile(birthDate=" + this.birthDate + ", gender=" + this.gender + ", heightInCentimeters=" + this.heightInCentimeters + ", weightInKilograms=" + this.weightInKilograms + ")";
    }
}
