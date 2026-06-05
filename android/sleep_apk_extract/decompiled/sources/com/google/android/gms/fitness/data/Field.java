package com.google.android.gms.fitness.data;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class Field extends AbstractSafeParcelable {
    public static final Field FIELD_ACCURACY;
    public static final Field FIELD_ALTITUDE;
    public static final Field FIELD_AVERAGE;
    public static final Field FIELD_BPM;
    public static final Field FIELD_CALORIES;

    @Deprecated
    public static final Field FIELD_CIRCUMFERENCE;
    public static final Field FIELD_DISTANCE;
    public static final Field FIELD_EXERCISE;
    public static final Field FIELD_FOOD_ITEM;
    public static final Field FIELD_HEIGHT;
    public static final Field FIELD_HIGH_LATITUDE;
    public static final Field FIELD_HIGH_LONGITUDE;
    public static final Field FIELD_INTENSITY;
    public static final Field FIELD_LATITUDE;
    public static final Field FIELD_LONGITUDE;
    public static final Field FIELD_LOW_LATITUDE;
    public static final Field FIELD_LOW_LONGITUDE;
    public static final Field FIELD_MAX;
    public static final Field FIELD_MAX_INT;
    public static final Field FIELD_MEAL_TYPE;
    public static final Field FIELD_MIN;
    public static final Field FIELD_MIN_INT;
    public static final Field FIELD_NUM_SEGMENTS;
    public static final Field FIELD_NUTRIENTS;
    public static final Field FIELD_OCCURRENCES;
    public static final Field FIELD_PERCENTAGE;
    public static final Field FIELD_REPETITIONS;
    public static final Field FIELD_RESISTANCE;
    public static final Field FIELD_RESISTANCE_TYPE;
    public static final Field FIELD_REVOLUTIONS;
    public static final Field FIELD_RPM;
    public static final Field FIELD_SPEED;
    public static final Field FIELD_VOLUME;
    public static final Field FIELD_WATTS;
    public static final Field FIELD_WEIGHT;
    public static final Field zzA;
    public static final Field zzB;
    public static final Field zzC;
    public static final Field zzD;
    public static final Field zzE;
    public static final Field zzF;
    public static final Field zzG;
    public static final Field zzH;
    public static final Field zzI;
    public static final Field zzJ;
    public static final Field zzK;
    public static final Field zzL;
    public static final Field zzM;
    public static final Field zzN;
    public static final Field zzO;
    public static final Field zzP;
    public static final Field zzQ;
    public static final Field zzR;
    public static final Field zzS;
    public static final Field zzT;
    public static final Field zzU;
    public static final Field zzV;
    public static final Field zzW;
    public static final Field zzX;
    public static final Field zzY;
    public static final Field zzZ;
    public static final Field zzb;
    public static final Field zzc;
    public static final Field zzd;
    public static final Field zze;
    public static final Field zzf;
    public static final Field zzg;
    public static final Field zzh;
    public static final Field zzi;
    public static final Field zzj;
    public static final Field zzk;
    public static final Field zzl;
    public static final Field zzm;
    public static final Field zzn;
    public static final Field zzo;
    public static final Field zzp;
    public static final Field zzq;
    public static final Field zzr;
    public static final Field zzs;
    public static final Field zzt;
    public static final Field zzu;
    public static final Field zzv;
    public static final Field zzw;
    public static final Field zzx;
    public static final Field zzy;
    public static final Field zzz;
    private final String zzaa;
    private final int zzab;
    private final Boolean zzac;
    public static final Parcelable.Creator<Field> CREATOR = new zzo();
    public static final Field FIELD_ACTIVITY = new Field("activity", 1, null);
    public static final Field FIELD_SLEEP_SEGMENT_TYPE = new Field("sleep_segment_type", 1, null);
    public static final Field FIELD_CONFIDENCE = new Field("confidence", 2, null);
    public static final Field FIELD_STEPS = new Field("steps", 1, null);

    @Deprecated
    public static final Field FIELD_STEP_LENGTH = new Field("step_length", 2, null);
    public static final Field FIELD_DURATION = new Field("duration", 1, null);
    public static final Field zza = zza("duration");

    static {
        new Field("activity_duration.ascending", 4, null);
        new Field("activity_duration.descending", 4, null);
        FIELD_BPM = new Field("bpm", 2, null);
        zzb = new Field("respiratory_rate", 2, null);
        FIELD_LATITUDE = new Field("latitude", 2, null);
        FIELD_LONGITUDE = new Field("longitude", 2, null);
        FIELD_ACCURACY = new Field("accuracy", 2, null);
        FIELD_ALTITUDE = zzb("altitude");
        FIELD_DISTANCE = new Field("distance", 2, null);
        FIELD_HEIGHT = new Field(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 2, null);
        FIELD_WEIGHT = new Field("weight", 2, null);
        FIELD_PERCENTAGE = new Field("percentage", 2, null);
        FIELD_SPEED = new Field("speed", 2, null);
        FIELD_RPM = new Field("rpm", 2, null);
        zzc = new Field("google.android.fitness.GoalV2", 7, null);
        new Field("google.android.fitness.Device", 7, null);
        FIELD_REVOLUTIONS = new Field("revolutions", 1, null);
        FIELD_CALORIES = new Field("calories", 2, null);
        FIELD_WATTS = new Field("watts", 2, null);
        FIELD_VOLUME = new Field("volume", 2, null);
        FIELD_MEAL_TYPE = zza("meal_type");
        FIELD_FOOD_ITEM = new Field("food_item", 3, Boolean.TRUE);
        FIELD_NUTRIENTS = new Field("nutrients", 4, null);
        FIELD_EXERCISE = new Field("exercise", 3, null);
        FIELD_REPETITIONS = zza("repetitions");
        FIELD_RESISTANCE = zzb("resistance");
        FIELD_RESISTANCE_TYPE = zza("resistance_type");
        FIELD_NUM_SEGMENTS = new Field("num_segments", 1, null);
        FIELD_AVERAGE = new Field("average", 2, null);
        FIELD_MAX = new Field("max", 2, null);
        FIELD_MIN = new Field("min", 2, null);
        FIELD_LOW_LATITUDE = new Field("low_latitude", 2, null);
        FIELD_LOW_LONGITUDE = new Field("low_longitude", 2, null);
        FIELD_HIGH_LATITUDE = new Field("high_latitude", 2, null);
        FIELD_HIGH_LONGITUDE = new Field("high_longitude", 2, null);
        FIELD_OCCURRENCES = new Field("occurrences", 1, null);
        zzd = new Field("sensor_type", 1, null);
        zze = new Field("timestamps", 5, null);
        zzf = new Field("sensor_values", 6, null);
        FIELD_INTENSITY = new Field("intensity", 2, null);
        zzg = new Field("activity_confidence", 4, null);
        zzh = new Field("probability", 2, null);
        zzi = new Field("google.android.fitness.SleepAttributes", 7, null);
        zzj = new Field("google.android.fitness.SleepDisorderedBreathingFeatures", 7, null);
        zzk = new Field("google.android.fitness.SleepSchedule", 7, null);
        zzl = new Field("google.android.fitness.SleepSoundscape", 7, null);
        FIELD_CIRCUMFERENCE = new Field("circumference", 2, null);
        zzm = new Field("google.android.fitness.PacedWalkingAttributes", 7, null);
        zzn = new Field("zone_id", 3, null);
        zzo = new Field("met", 2, null);
        zzp = new Field("internal_device_temperature", 2, null);
        zzq = new Field("skin_temperature", 2, null);
        zzr = new Field("custom_heart_rate_zone_status", 1, null);
        FIELD_MIN_INT = new Field("min_int", 1, null);
        FIELD_MAX_INT = new Field("max_int", 1, null);
        zzs = zza("lightly_active_duration");
        zzt = zza("moderately_active_duration");
        zzu = zza("very_active_duration");
        zzv = new Field("google.android.fitness.SedentaryTime", 7, null);
        zzw = new Field("google.android.fitness.LivePace", 7, null);
        zzx = new Field("google.android.fitness.MomentaryStressAlgorithm", 7, null);
        zzy = new Field("magnet_presence", 1, null);
        zzz = new Field("google.android.fitness.MomentaryStressWindows", 7, null);
        zzA = new Field("google.android.fitness.ExerciseDetectionThresholds", 7, null);
        zzB = new Field("google.android.fitness.RecoveryHeartRate", 7, null);
        zzC = new Field("google.android.fitness.HeartRateVariability", 7, null);
        zzD = new Field("google.android.fitness.HeartRateVariabilitySummary", 7, null);
        zzE = new Field("google.android.fitness.ContinuousEDA", 7, null);
        zzF = new Field("google.android.fitness.TimeInSleepStages", 7, null);
        zzG = new Field("google.android.fitness.Grok", 7, null);
        zzH = new Field("google.android.fitness.WakeMagnitude", 7, null);
        zzI = new Field("google.android.fitness.FatBurnMinutes", 1, null);
        zzJ = new Field("google.android.fitness.CardioMinutes", 1, null);
        zzK = new Field("google.android.fitness.PeakHeartRateMinutes", 1, null);
        zzL = new Field("google.android.fitness.ActiveZoneMinutes", 1, null);
        zzM = new Field("google.android.fitness.SleepCoefficient", 7, null);
        zzN = new Field("google.android.fitness.RunVO2Max", 7, null);
        zzO = new Field("device_location_type", 1, null);
        zzP = new Field("device_id", 3, null);
        zzQ = new Field("google.android.fitness.DemographicVO2Max", 7, null);
        zzR = new Field("google.android.fitness.SleepSetting", 7, null);
        zzS = new Field("google.android.fitness.ValuesInHeartRateZones", 7, null);
        zzT = new Field("google.android.fitness.HeartHistogram", 7, null);
        zzU = new Field("google.android.fitness.StressScore", 7, null);
        zzV = new Field("google.android.fitness.RespiratoryRateSummary", 7, null);
        zzW = new Field("google.android.fitness.DailySkinSleepTemperatureDerivations", 7, null);
        zzX = new Field("google.android.fitness.SwimLengthsData", 7, null);
        zzY = new Field("google.android.fitness.DailySleep", 7, null);
        zzZ = new Field("google.android.fitness.DailyInternalDeviceTemperatureSleepTemperatureDerivations", 7, null);
    }

    public Field(String str, int i, Boolean bool) {
        this.zzaa = (String) Preconditions.checkNotNull(str);
        this.zzab = i;
        this.zzac = bool;
    }

    public static Field zza(String str) {
        return new Field(str, 1, Boolean.TRUE);
    }

    public static Field zzb(String str) {
        return new Field(str, 2, Boolean.TRUE);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Field)) {
            return false;
        }
        Field field = (Field) obj;
        return this.zzaa.equals(field.zzaa) && this.zzab == field.zzab;
    }

    public int getFormat() {
        return this.zzab;
    }

    public String getName() {
        return this.zzaa;
    }

    public int hashCode() {
        return this.zzaa.hashCode();
    }

    public Boolean isOptional() {
        return this.zzac;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(this.zzaa, "(", this.zzab == 1 ? "i" : "f", ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, getFormat());
        SafeParcelWriter.writeBooleanObject(parcel, 3, isOptional(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
