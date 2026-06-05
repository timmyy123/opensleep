package com.urbandroid.sleep.service.health.api;

import java.util.Date;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0010R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/service/health/api/HealthUserProfile;", "", "birthDate", "Ljava/util/Date;", "getBirthDate", "()Ljava/util/Date;", "gender", "Lcom/urbandroid/sleep/service/health/api/HealthUserProfile$Gender;", "getGender", "()Lcom/urbandroid/sleep/service/health/api/HealthUserProfile$Gender;", "heightInCentimeters", "", "getHeightInCentimeters", "()F", "weightInKilograms", "getWeightInKilograms", "Gender", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface HealthUserProfile {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbandroid/sleep/service/health/api/HealthUserProfile$Gender;", "", "<init>", "(Ljava/lang/String;I)V", "MALE", "FEMALE", "UNKNOWN", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Gender {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Gender[] $VALUES;
        public static final Gender MALE = new Gender("MALE", 0);
        public static final Gender FEMALE = new Gender("FEMALE", 1);
        public static final Gender UNKNOWN = new Gender("UNKNOWN", 2);

        private static final /* synthetic */ Gender[] $values() {
            return new Gender[]{MALE, FEMALE, UNKNOWN};
        }

        static {
            Gender[] genderArr$values = $values();
            $VALUES = genderArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(genderArr$values);
        }

        private Gender(String str, int i) {
        }

        public static Gender valueOf(String str) {
            return (Gender) Enum.valueOf(Gender.class, str);
        }

        public static Gender[] values() {
            return (Gender[]) $VALUES.clone();
        }
    }

    Date getBirthDate();

    Gender getGender();

    float getHeightInCentimeters();

    float getWeightInKilograms();
}
