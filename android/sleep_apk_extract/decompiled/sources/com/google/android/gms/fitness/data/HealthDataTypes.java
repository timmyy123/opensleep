package com.google.android.gms.fitness.data;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HealthDataTypes {

    @Deprecated
    public static final DataType AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY;
    public static final DataType AGGREGATE_BLOOD_GLUCOSE_SUMMARY;
    public static final DataType AGGREGATE_BLOOD_PRESSURE_SUMMARY;
    public static final DataType AGGREGATE_BODY_TEMPERATURE_SUMMARY;
    public static final DataType AGGREGATE_OXYGEN_SATURATION_SUMMARY;

    @Deprecated
    public static final DataType TYPE_BASAL_BODY_TEMPERATURE;
    public static final DataType TYPE_BLOOD_GLUCOSE;
    public static final DataType TYPE_BLOOD_PRESSURE;
    public static final DataType TYPE_BODY_TEMPERATURE;
    public static final DataType TYPE_CERVICAL_MUCUS;
    public static final DataType TYPE_CERVICAL_POSITION;
    public static final DataType TYPE_MENSTRUATION;
    public static final DataType TYPE_OVULATION_TEST;
    public static final DataType TYPE_OXYGEN_SATURATION;
    public static final DataType TYPE_VAGINAL_SPOTTING;

    static {
        Field field = HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC;
        Field field2 = HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC;
        Field field3 = HealthFields.FIELD_BODY_POSITION;
        Field field4 = HealthFields.FIELD_BLOOD_PRESSURE_MEASUREMENT_LOCATION;
        TYPE_BLOOD_PRESSURE = new DataType("com.google.blood_pressure", 1, "https://www.googleapis.com/auth/fitness.blood_pressure.read", "https://www.googleapis.com/auth/fitness.blood_pressure.write", field, field2, field3, field4);
        Field field5 = HealthFields.FIELD_BLOOD_GLUCOSE_LEVEL;
        Field field6 = HealthFields.FIELD_TEMPORAL_RELATION_TO_MEAL;
        Field field7 = Field.FIELD_MEAL_TYPE;
        Field field8 = HealthFields.FIELD_TEMPORAL_RELATION_TO_SLEEP;
        Field field9 = HealthFields.FIELD_BLOOD_GLUCOSE_SPECIMEN_SOURCE;
        TYPE_BLOOD_GLUCOSE = new DataType("com.google.blood_glucose", 1, "https://www.googleapis.com/auth/fitness.blood_glucose.read", "https://www.googleapis.com/auth/fitness.blood_glucose.write", field5, field6, field7, field8, field9);
        Field field10 = HealthFields.FIELD_OXYGEN_SATURATION;
        Field field11 = HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE;
        Field field12 = HealthFields.FIELD_OXYGEN_THERAPY_ADMINISTRATION_MODE;
        Field field13 = HealthFields.FIELD_OXYGEN_SATURATION_SYSTEM;
        Field field14 = HealthFields.FIELD_OXYGEN_SATURATION_MEASUREMENT_METHOD;
        TYPE_OXYGEN_SATURATION = new DataType("com.google.oxygen_saturation", 1, "https://www.googleapis.com/auth/fitness.oxygen_saturation.read", "https://www.googleapis.com/auth/fitness.oxygen_saturation.write", field10, field11, field12, field13, field14);
        Field field15 = HealthFields.FIELD_BODY_TEMPERATURE;
        Field field16 = HealthFields.FIELD_BODY_TEMPERATURE_MEASUREMENT_LOCATION;
        TYPE_BODY_TEMPERATURE = new DataType("com.google.body.temperature", 1, "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", field15, field16);
        TYPE_BASAL_BODY_TEMPERATURE = new DataType("com.google.body.temperature.basal", 1, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", field15, field16);
        TYPE_CERVICAL_MUCUS = new DataType("com.google.cervical_mucus", 1, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", HealthFields.FIELD_CERVICAL_MUCUS_TEXTURE, HealthFields.FIELD_CERVICAL_MUCUS_AMOUNT);
        TYPE_CERVICAL_POSITION = new DataType("com.google.cervical_position", 1, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", HealthFields.FIELD_CERVICAL_POSITION, HealthFields.FIELD_CERVICAL_DILATION, HealthFields.FIELD_CERVICAL_FIRMNESS);
        TYPE_MENSTRUATION = new DataType("com.google.menstruation", 1, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", HealthFields.FIELD_MENSTRUAL_FLOW);
        TYPE_OVULATION_TEST = new DataType("com.google.ovulation_test", 1, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", HealthFields.FIELD_OVULATION_TEST_RESULT);
        TYPE_VAGINAL_SPOTTING = new DataType("com.google.vaginal_spotting", 1, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", Field.FIELD_OCCURRENCES);
        AGGREGATE_BLOOD_PRESSURE_SUMMARY = new DataType("com.google.blood_pressure.summary", 2, "https://www.googleapis.com/auth/fitness.blood_pressure.read", "https://www.googleapis.com/auth/fitness.blood_pressure.write", HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_AVERAGE, HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_MAX, HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_MIN, HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_AVERAGE, HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_MAX, HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_MIN, field3, field4);
        Field field17 = Field.FIELD_AVERAGE;
        Field field18 = Field.FIELD_MAX;
        Field field19 = Field.FIELD_MIN;
        AGGREGATE_BLOOD_GLUCOSE_SUMMARY = new DataType("com.google.blood_glucose.summary", 2, "https://www.googleapis.com/auth/fitness.blood_glucose.read", "https://www.googleapis.com/auth/fitness.blood_glucose.write", field17, field18, field19, field6, field7, field8, field9);
        AGGREGATE_OXYGEN_SATURATION_SUMMARY = new DataType("com.google.oxygen_saturation.summary", 2, "https://www.googleapis.com/auth/fitness.oxygen_saturation.read", "https://www.googleapis.com/auth/fitness.oxygen_saturation.write", HealthFields.FIELD_OXYGEN_SATURATION_AVERAGE, HealthFields.FIELD_OXYGEN_SATURATION_MAX, HealthFields.FIELD_OXYGEN_SATURATION_MIN, HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_AVERAGE, HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MAX, HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MIN, field12, field13, field14);
        AGGREGATE_BODY_TEMPERATURE_SUMMARY = new DataType("com.google.body.temperature.summary", 2, "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", field17, field18, field19, field16);
        AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY = new DataType("com.google.body.temperature.basal.summary", 2, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", field17, field18, field19, field16);
    }
}
