package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzfi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class DataSet extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DataSet> CREATOR = new zzg();
    private final int zza;
    private final DataSource zzb;
    private final List zzc;
    private final List zzd;

    public static class Builder {
        private final DataSet zza;
        private boolean zzb = false;

        public /* synthetic */ Builder(DataSource dataSource, byte[] bArr) {
            this.zza = DataSet.create(dataSource);
        }

        public Builder add(DataPoint dataPoint) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.add(dataPoint);
            return this;
        }

        public DataSet build() {
            Preconditions.checkState(!this.zzb, "DataSet#build() should only be called once.");
            this.zzb = true;
            return this.zza;
        }
    }

    public DataSet(RawDataSet rawDataSet, List list) {
        this.zza = 3;
        this.zzb = (DataSource) list.get(rawDataSet.zza);
        this.zzd = list;
        List list2 = rawDataSet.zzb;
        this.zzc = new ArrayList(list2.size());
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            this.zzc.add(new DataPoint(this.zzd, (RawDataPoint) it.next()));
        }
    }

    public static Builder builder(DataSource dataSource) {
        Preconditions.checkNotNull(dataSource, "DataSource should be specified");
        return new Builder(dataSource, null);
    }

    public static DataSet create(DataSource dataSource) {
        Preconditions.checkNotNull(dataSource, "DataSource should be specified");
        return new DataSet(dataSource);
    }

    /* JADX WARN: Code restructure failed: missing block: B:319:0x0534, code lost:
    
        r3 = "DataPoint out of range";
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void zzb(DataPoint dataPoint) {
        DataType dataType;
        double dAsFloat;
        String name = dataPoint.getDataType().getName();
        int i = zzj.$r8$clinit;
        String strConcat = null;
        switch (name.hashCode()) {
            case -2099142418:
                dataType = !name.equals("com.google.internal.time_in_sleep_stages") ? null : DataType.zzC;
                break;
            case -2060095039:
                dataType = !name.equals("com.google.cycling.wheel_revolution.rpm") ? null : DataType.TYPE_CYCLING_WHEEL_RPM;
                break;
            case -2032495331:
                dataType = !name.equals("com.google.respiratory_rate") ? null : DataType.zze;
                break;
            case -2023954015:
                dataType = !name.equals("com.google.location.bounding_box") ? null : DataType.AGGREGATE_LOCATION_BOUNDING_BOX;
                break;
            case -1999891138:
                dataType = !name.equals("com.google.heart_minutes") ? null : DataType.TYPE_HEART_POINTS;
                break;
            case -1939429191:
                dataType = !name.equals("com.google.blood_glucose.summary") ? null : HealthDataTypes.AGGREGATE_BLOOD_GLUCOSE_SUMMARY;
                break;
            case -1891372774:
                dataType = !name.equals("com.google.internal.recovery_heart_rate") ? null : DataType.zzx;
                break;
            case -1885232357:
                dataType = !name.equals("com.google.internal.demographic_vo2_max") ? null : DataType.zzI;
                break;
            case -1823712045:
                dataType = !name.equals("com.google.internal.met") ? null : DataType.zzl;
                break;
            case -1800259106:
                dataType = !name.equals("com.google.internal.wake_magnitude") ? null : DataType.zzE;
                break;
            case -1757812901:
                dataType = !name.equals("com.google.location.sample") ? null : DataType.TYPE_LOCATION_SAMPLE;
                break;
            case -1659958877:
                dataType = !name.equals("com.google.menstruation") ? null : HealthDataTypes.TYPE_MENSTRUATION;
                break;
            case -1431431801:
                dataType = !name.equals("com.google.height.summary") ? null : DataType.AGGREGATE_HEIGHT_SUMMARY;
                break;
            case -1416335448:
                dataType = !name.equals("com.google.internal.sleep_schedule") ? null : DataType.zzi;
                break;
            case -1282143440:
                dataType = !name.equals("com.google.internal.stress_score") ? null : DataType.zzN;
                break;
            case -1257869408:
                dataType = !name.equals("com.google.internal.exercise_detection_thresholds") ? null : DataType.zzw;
                break;
            case -1248818137:
                dataType = !name.equals("com.google.distance.delta") ? null : DataType.TYPE_DISTANCE_DELTA;
                break;
            case -1240326399:
                dataType = !name.equals("com.google.internal.run_vo2_max") ? null : DataType.zzH;
                break;
            case -1150975205:
                dataType = !name.equals("com.google.internal.continuous_eda") ? null : DataType.zzA;
                break;
            case -1103712522:
                dataType = !name.equals("com.google.heart_minutes.summary") ? null : DataType.AGGREGATE_HEART_POINTS;
                break;
            case -1102520626:
                dataType = !name.equals("com.google.step_count.delta") ? null : DataType.TYPE_STEP_COUNT_DELTA;
                break;
            case -1091068721:
                dataType = !name.equals("com.google.height") ? null : DataType.TYPE_HEIGHT;
                break;
            case -1045435751:
                dataType = !name.equals("com.google.internal.grok_data") ? null : DataType.zzD;
                break;
            case -1026139708:
                dataType = !name.equals("com.google.internal.momentary_stress_algorithm") ? null : DataType.zzt;
                break;
            case -922976890:
                dataType = !name.equals("com.google.cycling.pedaling.cumulative") ? null : DataType.TYPE_CYCLING_PEDALING_CUMULATIVE;
                break;
            case -900592674:
                dataType = !name.equals("com.google.cycling.pedaling.cadence") ? null : DataType.TYPE_CYCLING_PEDALING_CADENCE;
                break;
            case -892966990:
                dataType = !name.equals("com.google.internal.magnetic_field_presence") ? null : DataType.zzu;
                break;
            case -886569606:
                dataType = !name.equals("com.google.location.track") ? null : DataType.TYPE_LOCATION_TRACK;
                break;
            case -812484668:
                dataType = !name.equals("com.google.internal.internal_device_temperature") ? null : DataType.zzm;
                break;
            case -777285735:
                dataType = !name.equals("com.google.heart_rate.summary") ? null : DataType.AGGREGATE_HEART_RATE_SUMMARY;
                break;
            case -734488296:
                dataType = !name.equals("com.google.internal.momentary_stress_windows") ? null : DataType.zzv;
                break;
            case -700668164:
                dataType = !name.equals("com.google.internal.goal") ? null : DataType.zza;
                break;
            case -661631456:
                dataType = !name.equals("com.google.weight") ? null : DataType.TYPE_WEIGHT;
                break;
            case -526422027:
                dataType = !name.equals("com.google.internal.active_minutes_combined") ? null : DataType.zzp;
                break;
            case -424876584:
                dataType = !name.equals("com.google.weight.summary") ? null : DataType.AGGREGATE_WEIGHT_SUMMARY;
                break;
            case -362418992:
                dataType = !name.equals("com.google.body.temperature") ? null : HealthDataTypes.TYPE_BODY_TEMPERATURE;
                break;
            case -316596620:
                dataType = !name.equals("com.google.sleep.segment") ? null : DataType.TYPE_SLEEP_SEGMENT;
                break;
            case -217611775:
                dataType = !name.equals("com.google.blood_glucose") ? null : HealthDataTypes.TYPE_BLOOD_GLUCOSE;
                break;
            case -185830635:
                dataType = !name.equals("com.google.power.summary") ? null : DataType.AGGREGATE_POWER_SUMMARY;
                break;
            case -177293656:
                dataType = !name.equals("com.google.nutrition.summary") ? null : DataType.AGGREGATE_NUTRITION_SUMMARY;
                break;
            case -177035827:
                dataType = !name.equals("com.google.internal.custom_heart_rate_zone") ? null : DataType.zzo;
                break;
            case -169054219:
                dataType = !name.equals("com.google.internal.device_location") ? null : DataType.zzO;
                break;
            case -164586193:
                dataType = !name.equals("com.google.activity.exercise") ? null : DataType.TYPE_WORKOUT_EXERCISE;
                break;
            case -98150574:
                dataType = !name.equals("com.google.heart_rate.bpm") ? null : DataType.TYPE_HEART_RATE_BPM;
                break;
            case -56824761:
                dataType = !name.equals("com.google.calories.bmr") ? null : DataType.TYPE_BASAL_METABOLIC_RATE;
                break;
            case 53773386:
                dataType = !name.equals("com.google.blood_pressure.summary") ? null : HealthDataTypes.AGGREGATE_BLOOD_PRESSURE_SUMMARY;
                break;
            case 70615049:
                dataType = !name.equals("com.google.internal.sleep_disordered_breathing_features") ? null : DataType.zzb;
                break;
            case 250049721:
                dataType = !name.equals("com.google.internal.custom_max_heart_rate") ? null : DataType.zzs;
                break;
            case 269180370:
                dataType = !name.equals("com.google.activity.samples") ? null : DataType.zzg;
                break;
            case 295793957:
                dataType = !name.equals("com.google.sensor.events") ? null : DataType.zzd;
                break;
            case 296250623:
                dataType = !name.equals("com.google.calories.bmr.summary") ? null : DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY;
                break;
            case 324760871:
                dataType = !name.equals("com.google.step_count.cadence") ? null : DataType.TYPE_STEP_COUNT_CADENCE;
                break;
            case 331245188:
                dataType = !name.equals("com.google.internal.sleep_coefficient") ? null : DataType.zzG;
                break;
            case 378060028:
                dataType = !name.equals("com.google.activity.segment") ? null : DataType.TYPE_ACTIVITY_SEGMENT;
                break;
            case 529727579:
                dataType = !name.equals("com.google.power.sample") ? null : DataType.TYPE_POWER_SAMPLE;
                break;
            case 551831579:
                dataType = !name.equals("com.google.internal.skin_temperature") ? null : DataType.zzn;
                break;
            case 577293087:
                dataType = !name.equals("com.google.internal.sleep_setting") ? null : DataType.zzJ;
                break;
            case 657433501:
                dataType = !name.equals("com.google.step_count.cumulative") ? null : DataType.TYPE_STEP_COUNT_CUMULATIVE;
                break;
            case 682891187:
                dataType = !name.equals("com.google.body.fat.percentage") ? null : DataType.TYPE_BODY_FAT_PERCENTAGE;
                break;
            case 728746274:
                dataType = !name.equals("com.google.internal.heart_histogram") ? null : DataType.zzL;
                break;
            case 768831208:
                dataType = !name.equals("com.google.internal.sleep_soundscape") ? null : DataType.zzc;
                break;
            case 841663855:
                dataType = !name.equals("com.google.activity.summary") ? null : DataType.AGGREGATE_ACTIVITY_SUMMARY;
                break;
            case 877955159:
                dataType = !name.equals("com.google.speed.summary") ? null : DataType.AGGREGATE_SPEED_SUMMARY;
                break;
            case 899666941:
                dataType = !name.equals("com.google.calories.expended") ? null : DataType.TYPE_CALORIES_EXPENDED;
                break;
            case 936279698:
                dataType = !name.equals("com.google.blood_pressure") ? null : HealthDataTypes.TYPE_BLOOD_PRESSURE;
                break;
            case 946706510:
                dataType = !name.equals("com.google.hydration") ? null : DataType.TYPE_HYDRATION;
                break;
            case 994069086:
                dataType = !name.equals("com.google.internal.altitude_sample") ? null : DataType.zzB;
                break;
            case 1029221057:
                dataType = !name.equals("com.google.device_on_body") ? null : DataType.zzf;
                break;
            case 1111569113:
                dataType = !name.equals("com.google.time_zone_change") ? null : DataType.zzk;
                break;
            case 1111714923:
                dataType = !name.equals("com.google.body.fat.percentage.summary") ? null : DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY;
                break;
            case 1203049798:
                dataType = !name.equals("com.google.internal.sedentary_time") ? null : DataType.zzq;
                break;
            case 1214093899:
                dataType = !name.equals("com.google.vaginal_spotting") ? null : HealthDataTypes.TYPE_VAGINAL_SPOTTING;
                break;
            case 1336696170:
                dataType = !name.equals("com.google.internal.swim_lengths_data") ? null : DataType.zzQ;
                break;
            case 1404118825:
                dataType = !name.equals("com.google.oxygen_saturation") ? null : HealthDataTypes.TYPE_OXYGEN_SATURATION;
                break;
            case 1439932546:
                dataType = !name.equals("com.google.ovulation_test") ? null : HealthDataTypes.TYPE_OVULATION_TEST;
                break;
            case 1498973736:
                dataType = !name.equals("com.google.internal.sleep_attributes") ? null : DataType.zzh;
                break;
            case 1518502354:
                dataType = !name.equals("com.google.internal.heart_rate_variability_summary") ? null : DataType.zzz;
                break;
            case 1524007137:
                dataType = !name.equals("com.google.cycling.wheel_revolution.cumulative") ? null : DataType.TYPE_CYCLING_WHEEL_REVOLUTION;
                break;
            case 1532018766:
                dataType = !name.equals("com.google.active_minutes") ? null : DataType.TYPE_MOVE_MINUTES;
                break;
            case 1630804803:
                dataType = !name.equals("com.google.internal.active_zone_minutes_summary") ? null : DataType.zzF;
                break;
            case 1633152752:
                dataType = !name.equals("com.google.nutrition") ? null : DataType.TYPE_NUTRITION;
                break;
            case 1639960171:
                dataType = !name.equals("com.google.internal.heart_rate_variability") ? null : DataType.zzy;
                break;
            case 1676380456:
                dataType = !name.equals("com.google.internal.daily_sleep") ? null : DataType.zzR;
                break;
            case 1690370806:
                dataType = !name.equals("com.google.internal.daily_skin_sleep_temperature_derivations") ? null : DataType.zzP;
                break;
            case 1704117287:
                dataType = !name.equals("com.google.internal.values_in_heart_rate_zones") ? null : DataType.zzK;
                break;
            case 1739857477:
                dataType = !name.equals("com.google.internal.respiratory_rate_summary") ? null : DataType.zzM;
                break;
            case 1747943229:
                dataType = !name.equals("com.google.internal.live_pace") ? null : DataType.zzr;
                break;
            case 1925848149:
                dataType = !name.equals("com.google.cervical_position") ? null : HealthDataTypes.TYPE_CERVICAL_POSITION;
                break;
            case 1975902189:
                dataType = !name.equals("com.google.cervical_mucus") ? null : HealthDataTypes.TYPE_CERVICAL_MUCUS;
                break;
            case 2051843553:
                dataType = !name.equals("com.google.oxygen_saturation.summary") ? null : HealthDataTypes.AGGREGATE_OXYGEN_SATURATION_SUMMARY;
                break;
            case 2053496735:
                dataType = !name.equals("com.google.speed") ? null : DataType.TYPE_SPEED;
                break;
            case 2053535688:
                dataType = !name.equals("com.google.internal.daily_internal_device_temperature_sleep_temperature_derivations") ? null : DataType.zzS;
                break;
            case 2131809416:
                dataType = !name.equals("com.google.body.temperature.summary") ? null : HealthDataTypes.AGGREGATE_BODY_TEMPERATURE_SUMMARY;
                break;
            case 2145123220:
                dataType = !name.equals("com.google.internal.paced_walking_attributes") ? null : DataType.zzj;
                break;
            default:
                dataType = null;
                break;
        }
        if (dataType != null) {
            DataType dataType2 = dataPoint.getDataType();
            int i2 = 0;
            while (true) {
                if (i2 < dataType2.getFields().size()) {
                    String name2 = dataType2.getFields().get(i2).getName();
                    if (dataPoint.zza(i2).isSet()) {
                        double format = dataType2.getFields().get(i2).getFormat();
                        if (format == 1.0d) {
                            dAsFloat = dataPoint.zza(i2).asInt();
                        } else if (format == 2.0d) {
                            dAsFloat = dataPoint.zza(i2).asFloat();
                        } else {
                            continue;
                            i2++;
                        }
                        zzag zzagVarZza = zzah.zzc().zza(name2);
                        if (zzagVarZza == null || zzagVarZza.zza(dAsFloat)) {
                            zzag zzagVarZzb = zzah.zzc().zzb(dataType2.getName(), name2);
                            if (zzagVarZzb != null) {
                                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                                long endTime = dataPoint.getEndTime(timeUnit) - dataPoint.getStartTime(timeUnit);
                                if (endTime == 0) {
                                    if (dAsFloat != 0.0d) {
                                    }
                                } else if (!zzagVarZzb.zza(dAsFloat / endTime)) {
                                }
                            } else {
                                continue;
                            }
                            i2++;
                        } else {
                            strConcat = "Field out of range";
                        }
                    } else if (Boolean.TRUE.equals(dataType2.getFields().get(i2).isOptional()) || zzah.zzd.contains(name2)) {
                        i2++;
                    } else {
                        strConcat = String.valueOf(name2).concat(" not set");
                    }
                } else if ("com.google.activity.segment".equals(dataPoint.getDataSource().getDataType().getName())) {
                    Value value = dataPoint.getValue(Field.FIELD_ACTIVITY);
                    if (value == null) {
                        strConcat = "activity is not set";
                    } else if (zzfi.zzb(value.asInt(), zzfi.UNKNOWN).zza()) {
                        strConcat = "Sleep types are not a valid activity for com.google.activity.segment";
                    }
                }
            }
        }
        if (strConcat == null) {
            return;
        }
        Log.w("Fitness", "Invalid data point: ".concat(String.valueOf(dataPoint)));
        Utf8$$ExternalSyntheticBUOutline0.m$2(strConcat);
    }

    @Deprecated
    public void add(DataPoint dataPoint) {
        DataSource dataSource = dataPoint.getDataSource();
        String streamIdentifier = dataSource.getStreamIdentifier();
        DataSource dataSource2 = this.zzb;
        Preconditions.checkArgument(streamIdentifier.equals(dataSource2.getStreamIdentifier()), "Conflicting data sources found %s vs %s", dataSource, dataSource2);
        dataPoint.zze();
        zzb(dataPoint);
        zza(dataPoint);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataSet)) {
            return false;
        }
        DataSet dataSet = (DataSet) obj;
        return Objects.equal(this.zzb, dataSet.zzb) && Objects.equal(this.zzc, dataSet.zzc);
    }

    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.zzc);
    }

    public DataSource getDataSource() {
        return this.zzb;
    }

    public DataType getDataType() {
        return this.zzb.getDataType();
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb);
    }

    public String toString() {
        List listZzd = zzd(this.zzd);
        Locale locale = Locale.US;
        String strZzb = this.zzb.zzb();
        List list = this.zzc;
        Object obj = listZzd;
        if (list.size() >= 10) {
            obj = String.format(locale, "%d data points, first 5: %s", Integer.valueOf(list.size()), listZzd.subList(0, 5));
        }
        return String.format(locale, "DataSet{%s %s}", strZzb, obj);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataSource(), i, false);
        List list = this.zzd;
        SafeParcelWriter.writeList(parcel, 3, zzd(list), false);
        SafeParcelWriter.writeTypedList(parcel, 4, list, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Deprecated
    public final void zza(DataPoint dataPoint) {
        this.zzc.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null) {
            List list = this.zzd;
            if (list.contains(originalDataSource)) {
                return;
            }
            list.add(originalDataSource);
        }
    }

    public final List zzd(List list) {
        List list2 = this.zzc;
        ArrayList arrayList = new ArrayList(list2.size());
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawDataPoint((DataPoint) it.next(), list));
        }
        return arrayList;
    }

    public DataSet(DataSource dataSource) {
        this.zza = 3;
        DataSource dataSource2 = (DataSource) Preconditions.checkNotNull(dataSource);
        this.zzb = dataSource2;
        this.zzc = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.zzd = arrayList;
        arrayList.add(dataSource2);
    }

    public DataSet(int i, DataSource dataSource, List list, List list2) {
        this.zza = i;
        this.zzb = dataSource;
        this.zzc = new ArrayList(list.size());
        this.zzd = i < 2 ? Collections.singletonList(dataSource) : list2;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.zzc.add(new DataPoint(this.zzd, (RawDataPoint) it.next()));
        }
    }
}
