package com.urbandroid.sleep.marketing;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager$31$$ExternalSyntheticLambda0;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00192\u00020\u0001:\b\u001a\u001b\u001c\u001d\u001e\u001f \u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0086D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00128\u0006X\u0086D¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006!"}, d2 = {"Lcom/urbandroid/sleep/marketing/MonetizationSegmentation;", "", "<init>", "()V", "Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Scoring;", "scoring", "Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Buckets;", "b", "Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Result;", "score", "(Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Scoring;Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Buckets;)Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Result;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Callback;", "cb", "", "calculateSegments", "(Landroid/content/Context;Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Callback;)V", "", "bucketMapJson", "Ljava/lang/String;", "getBucketMapJson", "()Ljava/lang/String;", "scoringJson", "getScoringJson", "Companion", "Result", "Callback", "Buckets", "BucketMap", "Scoring", "RawSignals", "Attribution", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MonetizationSegmentation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Gson gson = new Gson();
    private final String bucketMapJson = "{\n  \"country_tiers\": {\n    \"CTRY_T1\": [\"AT\", \"AU\", \"CH\", \"CO\", \"IL\", \"MX\", \"NO\", \"US\", \"TR\", \"ZA\"],\n    \"CTRY_T2\": [\n      \"BE\",\n      \"BR\",\n      \"CA\",\n      \"CZ\",\n      \"DE\",\n      \"DK\",\n      \"GB\",\n      \"KZ\",\n      \"PE\",\n      \"RO\",\n      \"UA\"\n    ],\n    \"CTRY_T3\": [\n      \"AR\",\n      \"CL\",\n      \"FI\",\n      \"FR\",\n      \"HU\",\n      \"ID\",\n      \"IE\",\n      \"JP\",\n      \"KR\",\n      \"MY\",\n      \"NL\",\n      \"PH\",\n      \"PL\",\n      \"PT\",\n      \"SA\",\n      \"SE\",\n      \"TH\",\n      \"VN\"\n    ],\n    \"CTRY_T4\": [\n      \"BD\",\n      \"CN\",\n      \"DZ\",\n      \"EG\",\n      \"ES\",\n      \"GR\",\n      \"IN\",\n      \"IQ\",\n      \"IR\",\n      \"IT\",\n      \"MA\",\n      \"PK\",\n      \"RU\"\n    ]\n  },\n  \"brand_tiers\": {\n    \"BRAND_T1\": [\"Google\"],\n    \"BRAND_T2\": [\"docomo\", \"DOCOMO\", \"Nothing\", \"OnePlus\", \"RAKUTEN\", \"Samsung\", \"Sharp\", \"Sony\"],\n    \"BRAND_T3\": [\n      \"Honor\",\n      \"Huawei\",\n      \"Infinix\",\n      \"iQOO\",\n      \"Motorola\",\n      \"nubia\",\n      \"OPPO\",\n      \"POCO\",\n      \"Redmi\",\n      \"Realme\",\n      \"Tecno\",\n      \"Vivo\",\n      \"Xiaomi\",\n      \"ZTE\"\n    ]\n  },\n  \"hw_top_map\": {\n    \"23090RA98G\": \"HW_TOP_59\",\n    \"23117RA68G\": \"HW_TOP_49\",\n    \"2311DRK48G\": \"HW_TOP_52\",\n    \"23124RA7EO\": \"HW_TOP_50\",\n    \"2312DRA50G\": \"HW_TOP_53\",\n    \"24090RA29G\": \"HW_TOP_55\",\n    \"2412DPC0AG\": \"HW_TOP_36\",\n    \"M2101K6G\": \"HW_TOP_57\",\n    \"Pixel 10\": \"HW_TOP_29\",\n    \"Pixel 10 Pro\": \"HW_TOP_16\",\n    \"Pixel 10 Pro XL\": \"HW_TOP_20\",\n    \"Pixel 6\": \"HW_TOP_47\",\n    \"Pixel 6a\": \"HW_TOP_41\",\n    \"Pixel 7\": \"HW_TOP_18\",\n    \"Pixel 7 Pro\": \"HW_TOP_28\",\n    \"Pixel 7a\": \"HW_TOP_26\",\n    \"Pixel 8\": \"HW_TOP_14\",\n    \"Pixel 8 Pro\": \"HW_TOP_13\",\n    \"Pixel 8a\": \"HW_TOP_24\",\n    \"Pixel 9\": \"HW_TOP_17\",\n    \"Pixel 9 Pro\": \"HW_TOP_23\",\n    \"Pixel 9 Pro XL\": \"HW_TOP_22\",\n    \"Pixel 9a\": \"HW_TOP_09\",\n    \"SM-A145F\": \"HW_TOP_56\",\n    \"SM-A145M\": \"HW_TOP_56\",\n    \"SM-A145MB\": \"HW_TOP_56\",\n    \"SM-A145P\": \"HW_TOP_56\",\n    \"SM-A145R\": \"HW_TOP_56\",\n    \"SM-A155F\": \"HW_TOP_37\",\n    \"SM-A155M\": \"HW_TOP_37\",\n    \"SM-A155N\": \"HW_TOP_37\",\n    \"SM-A1560\": \"HW_TOP_51\",\n    \"SM-A156B\": \"HW_TOP_51\",\n    \"SM-A156E\": \"HW_TOP_51\",\n    \"SM-A156L\": \"HW_TOP_51\",\n    \"SM-A156M\": \"HW_TOP_51\",\n    \"SM-A156U\": \"HW_TOP_51\",\n    \"SM-A156U1\": \"HW_TOP_51\",\n    \"SM-A156W\": \"HW_TOP_51\",\n    \"SM-A165F\": \"HW_TOP_39\",\n    \"SM-A165M\": \"HW_TOP_39\",\n    \"SM-A165N\": \"HW_TOP_39\",\n    \"SM-A1660\": \"HW_TOP_42\",\n    \"SM-A166B\": \"HW_TOP_42\",\n    \"SM-A166E\": \"HW_TOP_42\",\n    \"SM-A166L\": \"HW_TOP_42\",\n    \"SM-A166M\": \"HW_TOP_42\",\n    \"SM-A166P\": \"HW_TOP_42\",\n    \"SM-A166U\": \"HW_TOP_42\",\n    \"SM-A166U1\": \"HW_TOP_42\",\n    \"SM-A166W\": \"HW_TOP_42\",\n    \"SM-A256B\": \"HW_TOP_48\",\n    \"SM-A256E\": \"HW_TOP_48\",\n    \"SM-A256N\": \"HW_TOP_48\",\n    \"SM-A256U\": \"HW_TOP_48\",\n    \"SM-A256U1\": \"HW_TOP_48\",\n    \"SM-A3360\": \"HW_TOP_58\",\n    \"SM-A336B\": \"HW_TOP_58\",\n    \"SM-A336E\": \"HW_TOP_58\",\n    \"SM-A336M\": \"HW_TOP_58\",\n    \"SM-A336N\": \"HW_TOP_58\",\n    \"SM-A3460\": \"HW_TOP_30\",\n    \"SM-A346B\": \"HW_TOP_30\",\n    \"SM-A346E\": \"HW_TOP_30\",\n    \"SM-A346M\": \"HW_TOP_30\",\n    \"SM-A346N\": \"HW_TOP_30\",\n    \"SM-A3560\": \"HW_TOP_31\",\n    \"SM-A356B\": \"HW_TOP_31\",\n    \"SM-A356E\": \"HW_TOP_31\",\n    \"SM-A356N\": \"HW_TOP_31\",\n    \"SM-A356U\": \"HW_TOP_31\",\n    \"SM-A356U1\": \"HW_TOP_31\",\n    \"SM-A356W\": \"HW_TOP_31\",\n    \"SM-A3660\": \"HW_TOP_43\",\n    \"SM-A366B\": \"HW_TOP_43\",\n    \"SM-A366E\": \"HW_TOP_43\",\n    \"SM-A366N\": \"HW_TOP_43\",\n    \"SM-A366Q\": \"HW_TOP_43\",\n    \"SM-A366U\": \"HW_TOP_43\",\n    \"SM-A366U1\": \"HW_TOP_43\",\n    \"SM-A366W\": \"HW_TOP_43\",\n    \"SM-A528B\": \"HW_TOP_40\",\n    \"SM-A528N\": \"HW_TOP_40\",\n    \"SM-A5360\": \"HW_TOP_33\",\n    \"SM-A536B\": \"HW_TOP_33\",\n    \"SM-A536E\": \"HW_TOP_33\",\n    \"SM-A536N\": \"HW_TOP_33\",\n    \"SM-A536U\": \"HW_TOP_33\",\n    \"SM-A536U1\": \"HW_TOP_33\",\n    \"SM-A536V\": \"HW_TOP_33\",\n    \"SM-A536W\": \"HW_TOP_33\",\n    \"SM-A5460\": \"HW_TOP_08\",\n    \"SM-A546B\": \"HW_TOP_08\",\n    \"SM-A546E\": \"HW_TOP_08\",\n    \"SM-A546S\": \"HW_TOP_08\",\n    \"SM-A546U\": \"HW_TOP_08\",\n    \"SM-A546U1\": \"HW_TOP_08\",\n    \"SM-A546V\": \"HW_TOP_08\",\n    \"SM-A546W\": \"HW_TOP_08\",\n    \"SM-A5560\": \"HW_TOP_07\",\n    \"SM-A556B\": \"HW_TOP_07\",\n    \"SM-A556E\": \"HW_TOP_07\",\n    \"SM-A556S\": \"HW_TOP_07\",\n    \"SM-A5660\": \"HW_TOP_10\",\n    \"SM-A566B\": \"HW_TOP_10\",\n    \"SM-A566E\": \"HW_TOP_10\",\n    \"SM-A566S\": \"HW_TOP_10\",\n    \"SM-A566U1\": \"HW_TOP_10\",\n    \"SM-A566W\": \"HW_TOP_10\",\n    \"SM-F7660\": \"HW_TOP_60\",\n    \"SM-F766B\": \"HW_TOP_60\",\n    \"SM-F766N\": \"HW_TOP_60\",\n    \"SM-F766Q\": \"HW_TOP_60\",\n    \"SM-F766U\": \"HW_TOP_60\",\n    \"SM-F766U1\": \"HW_TOP_60\",\n    \"SM-F766W\": \"HW_TOP_60\",\n    \"SM-F766Z\": \"HW_TOP_60\",\n    \"SM-F9660\": \"HW_TOP_38\",\n    \"SM-F966B\": \"HW_TOP_38\",\n    \"SM-F966N\": \"HW_TOP_38\",\n    \"SM-F966Q\": \"HW_TOP_38\",\n    \"SM-F966U\": \"HW_TOP_38\",\n    \"SM-F966U1\": \"HW_TOP_38\",\n    \"SM-F966W\": \"HW_TOP_38\",\n    \"SM-F966Z\": \"HW_TOP_38\",\n    \"SM-G780F\": \"HW_TOP_45\",\n    \"SM-G780G\": \"HW_TOP_45\",\n    \"SM-G7810\": \"HW_TOP_34\",\n    \"SM-G781B\": \"HW_TOP_34\",\n    \"SM-G781N\": \"HW_TOP_34\",\n    \"SM-G781U\": \"HW_TOP_34\",\n    \"SM-G781U1\": \"HW_TOP_34\",\n    \"SM-G781V\": \"HW_TOP_34\",\n    \"SM-G781W\": \"HW_TOP_34\",\n    \"SM-G9900\": \"HW_TOP_25\",\n    \"SM-G990B\": \"HW_TOP_25\",\n    \"SM-G990B2\": \"HW_TOP_25\",\n    \"SM-G990E\": \"HW_TOP_25\",\n    \"SM-G990U\": \"HW_TOP_25\",\n    \"SM-G990U1\": \"HW_TOP_25\",\n    \"SM-G990U2\": \"HW_TOP_25\",\n    \"SM-G990U3\": \"HW_TOP_25\",\n    \"SM-G990W\": \"HW_TOP_25\",\n    \"SM-G990W2\": \"HW_TOP_25\",\n    \"SM-G9910\": \"HW_TOP_27\",\n    \"SM-G991B\": \"HW_TOP_27\",\n    \"SM-G991N\": \"HW_TOP_27\",\n    \"SM-G991Q\": \"HW_TOP_27\",\n    \"SM-G991U\": \"HW_TOP_27\",\n    \"SM-G991U1\": \"HW_TOP_27\",\n    \"SM-G991W\": \"HW_TOP_27\",\n    \"SM-G9980\": \"HW_TOP_44\",\n    \"SM-G998B\": \"HW_TOP_44\",\n    \"SM-G998N\": \"HW_TOP_44\",\n    \"SM-G998U\": \"HW_TOP_44\",\n    \"SM-G998U1\": \"HW_TOP_44\",\n    \"SM-G998W\": \"HW_TOP_44\",\n    \"SM-S7110\": \"HW_TOP_35\",\n    \"SM-S711B\": \"HW_TOP_35\",\n    \"SM-S711N\": \"HW_TOP_35\",\n    \"SM-S711U\": \"HW_TOP_35\",\n    \"SM-S711U1\": \"HW_TOP_35\",\n    \"SM-S711W\": \"HW_TOP_35\",\n    \"SM-S7210\": \"HW_TOP_19\",\n    \"SM-S721B\": \"HW_TOP_19\",\n    \"SM-S721N\": \"HW_TOP_19\",\n    \"SM-S721Q\": \"HW_TOP_19\",\n    \"SM-S721U\": \"HW_TOP_19\",\n    \"SM-S721U1\": \"HW_TOP_19\",\n    \"SM-S721W\": \"HW_TOP_19\",\n    \"SM-S731B\": \"HW_TOP_46\",\n    \"SM-S731N\": \"HW_TOP_46\",\n    \"SM-S731U\": \"HW_TOP_46\",\n    \"SM-S731U1\": \"HW_TOP_46\",\n    \"SM-S731W\": \"HW_TOP_46\",\n    \"SM-S9010\": \"HW_TOP_11\",\n    \"SM-S901B\": \"HW_TOP_11\",\n    \"SM-S901E\": \"HW_TOP_11\",\n    \"SM-S901N\": \"HW_TOP_11\",\n    \"SM-S901U\": \"HW_TOP_11\",\n    \"SM-S901U1\": \"HW_TOP_11\",\n    \"SM-S901W\": \"HW_TOP_11\",\n    \"SM-S9060\": \"HW_TOP_54\",\n    \"SM-S906B\": \"HW_TOP_54\",\n    \"SM-S906E\": \"HW_TOP_54\",\n    \"SM-S906N\": \"HW_TOP_54\",\n    \"SM-S906U\": \"HW_TOP_54\",\n    \"SM-S906U1\": \"HW_TOP_54\",\n    \"SM-S906W\": \"HW_TOP_54\",\n    \"SM-S9080\": \"HW_TOP_12\",\n    \"SM-S908B\": \"HW_TOP_12\",\n    \"SM-S908E\": \"HW_TOP_12\",\n    \"SM-S908N\": \"HW_TOP_12\",\n    \"SM-S908U\": \"HW_TOP_12\",\n    \"SM-S908U1\": \"HW_TOP_12\",\n    \"SM-S908W\": \"HW_TOP_12\",\n    \"SM-S9110\": \"HW_TOP_06\",\n    \"SM-S911B\": \"HW_TOP_06\",\n    \"SM-S911C\": \"HW_TOP_06\",\n    \"SM-S911N\": \"HW_TOP_06\",\n    \"SM-S911U\": \"HW_TOP_06\",\n    \"SM-S911U1\": \"HW_TOP_06\",\n    \"SM-S911W\": \"HW_TOP_06\",\n    \"SM-S9160\": \"HW_TOP_32\",\n    \"SM-S916B\": \"HW_TOP_32\",\n    \"SM-S916N\": \"HW_TOP_32\",\n    \"SM-S916U\": \"HW_TOP_32\",\n    \"SM-S916U1\": \"HW_TOP_32\",\n    \"SM-S916W\": \"HW_TOP_32\",\n    \"SM-S9180\": \"HW_TOP_03\",\n    \"SM-S918B\": \"HW_TOP_03\",\n    \"SM-S918N\": \"HW_TOP_03\",\n    \"SM-S918U\": \"HW_TOP_03\",\n    \"SM-S918U1\": \"HW_TOP_03\",\n    \"SM-S918W\": \"HW_TOP_03\",\n    \"SM-S9210\": \"HW_TOP_05\",\n    \"SM-S921B\": \"HW_TOP_05\",\n    \"SM-S921E\": \"HW_TOP_05\",\n    \"SM-S921N\": \"HW_TOP_05\",\n    \"SM-S921Q\": \"HW_TOP_05\",\n    \"SM-S921U\": \"HW_TOP_05\",\n    \"SM-S921U1\": \"HW_TOP_05\",\n    \"SM-S921W\": \"HW_TOP_05\",\n    \"SM-S9260\": \"HW_TOP_15\",\n    \"SM-S926B\": \"HW_TOP_15\",\n    \"SM-S926N\": \"HW_TOP_15\",\n    \"SM-S926U\": \"HW_TOP_15\",\n    \"SM-S926U1\": \"HW_TOP_15\",\n    \"SM-S926W\": \"HW_TOP_15\",\n    \"SM-S9280\": \"HW_TOP_02\",\n    \"SM-S928B\": \"HW_TOP_02\",\n    \"SM-S928N\": \"HW_TOP_02\",\n    \"SM-S928Q\": \"HW_TOP_02\",\n    \"SM-S928U\": \"HW_TOP_02\",\n    \"SM-S928U1\": \"HW_TOP_02\",\n    \"SM-S928W\": \"HW_TOP_02\",\n    \"SM-S9310\": \"HW_TOP_04\",\n    \"SM-S931B\": \"HW_TOP_04\",\n    \"SM-S931N\": \"HW_TOP_04\",\n    \"SM-S931Q\": \"HW_TOP_04\",\n    \"SM-S931U\": \"HW_TOP_04\",\n    \"SM-S931U1\": \"HW_TOP_04\",\n    \"SM-S931W\": \"HW_TOP_04\",\n    \"SM-S931Z\": \"HW_TOP_04\",\n    \"SM-S9360\": \"HW_TOP_21\",\n    \"SM-S936B\": \"HW_TOP_21\",\n    \"SM-S936N\": \"HW_TOP_21\",\n    \"SM-S936U\": \"HW_TOP_21\",\n    \"SM-S936U1\": \"HW_TOP_21\",\n    \"SM-S936W\": \"HW_TOP_21\",\n    \"SM-S9380\": \"HW_TOP_01\",\n    \"SM-S938B\": \"HW_TOP_01\",\n    \"SM-S938N\": \"HW_TOP_01\",\n    \"SM-S938Q\": \"HW_TOP_01\",\n    \"SM-S938U\": \"HW_TOP_01\",\n    \"SM-S938U1\": \"HW_TOP_01\",\n    \"SM-S938W\": \"HW_TOP_01\",\n    \"SM-S938Z\": \"HW_TOP_01\"\n  },\n  \"defaults\": {\n    \"country_default\": \"CTRY_OTHER_LOWVOL\",\n    \"country_unknown\": \"CTRY_UNKNOWN\",\n    \"brand_default\": \"BRAND_OTHER_LOWVOL\",\n    \"brand_unknown\": \"BRAND_UNKNOWN\",\n    \"hw_default\": \"HW_OTHER\"\n  }\n}";
    private final String scoringJson = "{\n  \"points_scale\": 1000,\n  \"vip_points_cutoff\": 429,\n  \"likely_points_cutoff\": 296,\n  \"weights_points\": {\n    \"INTERCEPT\": { \"INTERCEPT\": -1 },\n    \"brand_bucket\": {\n      \"BRAND_OTHER_LOWVOL\": -20,\n      \"BRAND_T1\": 51,\n      \"BRAND_T2\": 13,\n      \"BRAND_T3\": -38\n    },\n    \"country_bucket\": {\n      \"CTRY_OTHER_LOWVOL\": -19,\n      \"CTRY_T1\": 64,\n      \"CTRY_T2\": 10,\n      \"CTRY_T3\": -18,\n      \"CTRY_T4\": -51\n    },\n    \"device_category_bucket\": {\n      \"DEVICE_OTHER\": -74,\n      \"DEVICE_PHONE\": -1,\n      \"DEVICE_TABLET\": -45\n    },\n    \"hw_model_bucket\": {\n      \"HW_OTHER\": -30,\n      \"HW_TOP_01\": 101,\n      \"HW_TOP_02\": 97,\n      \"HW_TOP_03\": 53,\n      \"HW_TOP_04\": 22,\n      \"HW_TOP_05\": 20,\n      \"HW_TOP_06\": 16,\n      \"HW_TOP_07\": -13,\n      \"HW_TOP_08\": -6,\n      \"HW_TOP_09\": 27,\n      \"HW_TOP_10\": -37,\n      \"HW_TOP_11\": -7,\n      \"HW_TOP_12\": 83,\n      \"HW_TOP_13\": 69,\n      \"HW_TOP_14\": 29,\n      \"HW_TOP_15\": 71,\n      \"HW_TOP_16\": 26,\n      \"HW_TOP_17\": 85,\n      \"HW_TOP_18\": 39,\n      \"HW_TOP_19\": 13,\n      \"HW_TOP_20\": 80,\n      \"HW_TOP_21\": 76,\n      \"HW_TOP_22\": 107,\n      \"HW_TOP_23\": 98,\n      \"HW_TOP_24\": 39,\n      \"HW_TOP_25\": -47,\n      \"HW_TOP_26\": 52,\n      \"HW_TOP_27\": -3,\n      \"HW_TOP_28\": 44,\n      \"HW_TOP_29\": 75,\n      \"HW_TOP_30\": -37,\n      \"HW_TOP_31\": -33,\n      \"HW_TOP_32\": 41,\n      \"HW_TOP_33\": -16,\n      \"HW_TOP_34\": -5,\n      \"HW_TOP_35\": 27,\n      \"HW_TOP_36\": -26,\n      \"HW_TOP_37\": -48,\n      \"HW_TOP_38\": 174,\n      \"HW_TOP_39\": -70,\n      \"HW_TOP_40\": -36,\n      \"HW_TOP_41\": 15,\n      \"HW_TOP_42\": -27,\n      \"HW_TOP_43\": -19,\n      \"HW_TOP_44\": 55,\n      \"HW_TOP_45\": -27,\n      \"HW_TOP_46\": 47,\n      \"HW_TOP_47\": -7,\n      \"HW_TOP_48\": -10,\n      \"HW_TOP_49\": -37,\n      \"HW_TOP_50\": -45,\n      \"HW_TOP_51\": -55,\n      \"HW_TOP_52\": -4,\n      \"HW_TOP_53\": -19,\n      \"HW_TOP_54\": 67,\n      \"HW_TOP_55\": 1,\n      \"HW_TOP_56\": -66,\n      \"HW_TOP_57\": -66,\n      \"HW_TOP_58\": -38,\n      \"HW_TOP_59\": 15,\n      \"HW_TOP_60\": 148\n    },\n    \"install_source_bucket\": { \"INSTALL_OTHER\": -68, \"INSTALL_PLAY\": 1 },\n    \"language_bucket\": {\n      \"LANG_OTHER\": -23,\n      \"LANG_ar-ae\": -66,\n      \"LANG_ar-eg\": -71,\n      \"LANG_cs-cz\": -1,\n      \"LANG_da-dk\": 11,\n      \"LANG_de-at\": 86,\n      \"LANG_de-ch\": 174,\n      \"LANG_de-de\": 4,\n      \"LANG_en-au\": 55,\n      \"LANG_en-ca\": 37,\n      \"LANG_en-gb\": -6,\n      \"LANG_en-ie\": -14,\n      \"LANG_en-in\": -34,\n      \"LANG_en-us\": 34,\n      \"LANG_en-za\": 52,\n      \"LANG_es-es\": -37,\n      \"LANG_es-mx\": 35,\n      \"LANG_es-us\": -8,\n      \"LANG_fa-ir\": -75,\n      \"LANG_fi-fi\": -30,\n      \"LANG_fr-ca\": 34,\n      \"LANG_fr-fr\": -27,\n      \"LANG_he-il\": 10,\n      \"LANG_hu-hu\": -30,\n      \"LANG_it-it\": -38,\n      \"LANG_ja-jp\": -9,\n      \"LANG_ko-kr\": -11,\n      \"LANG_nb-no\": 67,\n      \"LANG_nl-be\": 14,\n      \"LANG_nl-nl\": 6,\n      \"LANG_pl-pl\": -20,\n      \"LANG_pt-br\": 20,\n      \"LANG_pt-pt\": -31,\n      \"LANG_ru-ru\": -49,\n      \"LANG_sv-se\": -12,\n      \"LANG_th-th\": -12,\n      \"LANG_tr-tr\": 62,\n      \"LANG_uk-ua\": 25,\n      \"LANG_vi-vn\": -38,\n      \"LANG_zh-cn\": -48,\n      \"LANG_zh-tw\": -38\n    },\n    \"os_bucket\": {\n      \"OS_10\": -62,\n      \"OS_11\": -55,\n      \"OS_12\": -44,\n      \"OS_13\": -31,\n      \"OS_14\": -37,\n      \"OS_15\": -23,\n      \"OS_16\": 39,\n      \"OS_4\": -74,\n      \"OS_5\": -73,\n      \"OS_6\": -75,\n      \"OS_7\": -64,\n      \"OS_8\": -72,\n      \"OS_9\": -55\n    },\n    \"traffic_medium_bucket\": { \"TSM_ORGANIC\": 22, \"TSM_OTHER\": -13 },\n    \"traffic_name_bucket\": { \"TSN_GOOGLE_ADS\": 113, \"TSN_OTHER\": -16 },\n    \"traffic_source_bucket\": {\n      \"TSS_GOOGLE\": 102,\n      \"TSS_GOOGLE_PLAY\": 39,\n      \"TSS_OTHER\": -40\n    }\n  }\n}";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Attribution;", "", "installerPackage", "", "utmSource", "utmMedium", "utmCampaign", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInstallerPackage", "()Ljava/lang/String;", "getUtmSource", "getUtmMedium", "getUtmCampaign", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Attribution {
        private final String installerPackage;
        private final String utmCampaign;
        private final String utmMedium;
        private final String utmSource;

        public Attribution(String str, String str2, String str3, String str4) {
            this.installerPackage = str;
            this.utmSource = str2;
            this.utmMedium = str3;
            this.utmCampaign = str4;
        }

        public final String getInstallerPackage() {
            return this.installerPackage;
        }

        public final String getUtmCampaign() {
            return this.utmCampaign;
        }

        public final String getUtmMedium() {
            return this.utmMedium;
        }

        public final String getUtmSource() {
            return this.utmSource;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\b\u001f\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0006J\u0012\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\u0012\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0006R)\u0010\u0004\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR)\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR!\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012¨\u0006&"}, d2 = {"Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$BucketMap;", "", "<init>", "()V", "countryTiers", "", "", "", "getCountryTiers", "()Ljava/util/Map;", "brandTiers", "getBrandTiers", "hwTopMap", "getHwTopMap", "countryDefault", "getCountryDefault", "()Ljava/lang/String;", "setCountryDefault", "(Ljava/lang/String;)V", "countryUnknown", "getCountryUnknown", "setCountryUnknown", "brandDefault", "getBrandDefault", "setBrandDefault", "brandUnknown", "getBrandUnknown", "setBrandUnknown", "hwDefault", "getHwDefault", "setHwDefault", "bucketCountry", "countryName", "bucketBrand", "brandName", "bucketHw", "hwModel", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class BucketMap {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<String, Set<String>> countryTiers = new HashMap();
        private final Map<String, Set<String>> brandTiers = new HashMap();
        private final Map<String, String> hwTopMap = new HashMap();
        private String countryDefault = "CTRY_OTHER_LOWVOL";
        private String countryUnknown = "CTRY_UNKNOWN";
        private String brandDefault = "BRAND_OTHER_LOWVOL";
        private String brandUnknown = "BRAND_UNKNOWN";
        private String hwDefault = "HW_OTHER";

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J<\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\f0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$BucketMap$Companion;", "", "<init>", "()V", "parse", "Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$BucketMap;", "json", "", "contains", "", "m", "", "", "bucket", SDKConstants.PARAM_KEY, "getOr", "d", "Lcom/google/gson/JsonElement;", "def", "isNullish", "s", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final boolean contains(Map<String, Set<String>> m, String bucket, String key) {
                Set<String> set = m.get(bucket);
                return set != null && set.contains(key);
            }

            private final String getOr(JsonElement d, String key, String def) {
                try {
                    JsonElement jsonElement = d.getAsJsonObject().get(key);
                    if (jsonElement != null) {
                        return jsonElement.getAsString();
                    }
                } catch (Exception unused) {
                }
                return def;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final boolean isNullish(String s) {
                if (s != null) {
                    int length = s.length() - 1;
                    int i = 0;
                    boolean z = false;
                    while (i <= length) {
                        boolean z2 = Intrinsics.compare((int) s.charAt(!z ? i : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (z2) {
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    String string = s.subSequence(i, length + 1).toString();
                    if (string.length() != 0 && !StringsKt__StringsJVMKt.equals("(not set)", string, true)) {
                        return false;
                    }
                }
                return true;
            }

            public final BucketMap parse(String json) {
                BucketMap bucketMap = new BucketMap();
                if (!TextUtils.isEmpty(json)) {
                    try {
                        Object objFromJson = MonetizationSegmentation.gson.fromJson(json, (Class<Object>) JsonElement.class);
                        objFromJson.getClass();
                        JsonElement jsonElement = (JsonElement) objFromJson;
                        if (jsonElement.getAsJsonObject().has("country_tiers")) {
                            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().get("country_tiers").getAsJsonObject().entrySet()) {
                                String key = entry.getKey();
                                HashSet hashSet = new HashSet();
                                Iterator<JsonElement> it = entry.getValue().getAsJsonArray().iterator();
                                it.getClass();
                                while (it.hasNext()) {
                                    JsonElement next = it.next();
                                    Companion companion = MonetizationSegmentation.INSTANCE;
                                    String asString = next.getAsString();
                                    asString.getClass();
                                    String lowerCase = asString.toLowerCase(Locale.ROOT);
                                    lowerCase.getClass();
                                    hashSet.add(companion.norm(lowerCase));
                                }
                                bucketMap.getCountryTiers().put(key, hashSet);
                            }
                        }
                        if (jsonElement.getAsJsonObject().has("brand_tiers")) {
                            for (Map.Entry<String, JsonElement> entry2 : jsonElement.getAsJsonObject().get("brand_tiers").getAsJsonObject().entrySet()) {
                                String key2 = entry2.getKey();
                                HashSet hashSet2 = new HashSet();
                                Iterator<JsonElement> it2 = entry2.getValue().getAsJsonArray().iterator();
                                it2.getClass();
                                while (it2.hasNext()) {
                                    hashSet2.add(MonetizationSegmentation.INSTANCE.norm(it2.next().getAsString()));
                                }
                                bucketMap.getBrandTiers().put(key2, hashSet2);
                            }
                        }
                        if (jsonElement.getAsJsonObject().has("hw_top_map")) {
                            for (Map.Entry<String, JsonElement> entry3 : jsonElement.getAsJsonObject().get("hw_top_map").getAsJsonObject().entrySet()) {
                                bucketMap.getHwTopMap().put(MonetizationSegmentation.INSTANCE.norm(entry3.getKey()), entry3.getValue().getAsString());
                            }
                        }
                        if (jsonElement.getAsJsonObject().has("defaults")) {
                            JsonElement jsonElement2 = jsonElement.getAsJsonObject().get("defaults");
                            jsonElement2.getClass();
                            bucketMap.setCountryDefault(getOr(jsonElement2, "country_default", bucketMap.getCountryDefault()));
                            bucketMap.setCountryUnknown(getOr(jsonElement2, "country_unknown", bucketMap.getCountryUnknown()));
                            bucketMap.setBrandDefault(getOr(jsonElement2, "brand_default", bucketMap.getBrandDefault()));
                            bucketMap.setBrandUnknown(getOr(jsonElement2, "brand_unknown", bucketMap.getBrandUnknown()));
                            bucketMap.setHwDefault(getOr(jsonElement2, "hw_default", bucketMap.getHwDefault()));
                        }
                    } catch (Exception e) {
                        Logger.logSevere(e);
                        return bucketMap;
                    }
                }
                return bucketMap;
            }

            private Companion() {
            }
        }

        public final String bucketBrand(String brandName) {
            Companion companion = INSTANCE;
            if (companion.isNullish(brandName)) {
                return this.brandUnknown;
            }
            String strNorm = MonetizationSegmentation.INSTANCE.norm(brandName);
            return companion.contains(this.brandTiers, "BRAND_T1", strNorm) ? "BRAND_T1" : companion.contains(this.brandTiers, "BRAND_T2", strNorm) ? "BRAND_T2" : companion.contains(this.brandTiers, "BRAND_T3", strNorm) ? "BRAND_T3" : this.brandDefault;
        }

        public final String bucketCountry(String countryName) {
            Companion companion = INSTANCE;
            if (companion.isNullish(countryName)) {
                return this.countryUnknown;
            }
            String strNorm = MonetizationSegmentation.INSTANCE.norm(countryName);
            zza$$ExternalSyntheticOutline0.m("Bucketize country ", countryName);
            return companion.contains(this.countryTiers, "CTRY_T1", strNorm) ? "CTRY_T1" : companion.contains(this.countryTiers, "CTRY_T2", strNorm) ? "CTRY_T2" : companion.contains(this.countryTiers, "CTRY_T3", strNorm) ? "CTRY_T3" : companion.contains(this.countryTiers, "CTRY_T4", strNorm) ? "CTRY_T4" : this.countryDefault;
        }

        public final String bucketHw(String hwModel) {
            if (INSTANCE.isNullish(hwModel)) {
                return this.hwDefault;
            }
            String str = this.hwTopMap.get(MonetizationSegmentation.INSTANCE.norm(hwModel));
            return str == null ? this.hwDefault : str;
        }

        public final String getBrandDefault() {
            return this.brandDefault;
        }

        public final Map<String, Set<String>> getBrandTiers() {
            return this.brandTiers;
        }

        public final String getBrandUnknown() {
            return this.brandUnknown;
        }

        public final String getCountryDefault() {
            return this.countryDefault;
        }

        public final Map<String, Set<String>> getCountryTiers() {
            return this.countryTiers;
        }

        public final String getCountryUnknown() {
            return this.countryUnknown;
        }

        public final String getHwDefault() {
            return this.hwDefault;
        }

        public final Map<String, String> getHwTopMap() {
            return this.hwTopMap;
        }

        public final void setBrandDefault(String str) {
            this.brandDefault = str;
        }

        public final void setBrandUnknown(String str) {
            this.brandUnknown = str;
        }

        public final void setCountryDefault(String str) {
            this.countryDefault = str;
        }

        public final void setCountryUnknown(String str) {
            this.countryUnknown = str;
        }

        public final void setHwDefault(String str) {
            this.hwDefault = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBk\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Buckets;", "", "countryBucket", "", "languageBucket", "deviceCategoryBucket", "brandBucket", "hwModelBucket", "osBucket", "installSourceBucket", "trafficNameBucket", "trafficMediumBucket", "trafficSourceBucket", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountryBucket", "()Ljava/lang/String;", "getLanguageBucket", "getDeviceCategoryBucket", "getBrandBucket", "getHwModelBucket", "getOsBucket", "getInstallSourceBucket", "getTrafficNameBucket", "getTrafficMediumBucket", "getTrafficSourceBucket", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Buckets {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String brandBucket;
        private final String countryBucket;
        private final String deviceCategoryBucket;
        private final String hwModelBucket;
        private final String installSourceBucket;
        private final String languageBucket;
        private final String osBucket;
        private final String trafficMediumBucket;
        private final String trafficNameBucket;
        private final String trafficSourceBucket;

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Buckets$Companion;", "", "<init>", "()V", "bucketize", "Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Buckets;", "raw", "Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$RawSignals;", "bm", "Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$BucketMap;", "scoring", "Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Scoring;", "bucketTrafficMedium", "", "utmMedium", "bucketTrafficSource", "utmSource", "installerPkg", "bucketTrafficName", "utmCampaign", "isNullish", "", "s", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final String bucketTrafficMedium(String utmMedium) {
                if (isNullish(utmMedium)) {
                    return "TSM_OTHER";
                }
                utmMedium.getClass();
                int length = utmMedium.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) utmMedium.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                String lowerCase = utmMedium.subSequence(i, length + 1).toString().toLowerCase(Locale.ROOT);
                lowerCase.getClass();
                return Intrinsics.areEqual("cpc", lowerCase) ? "TSM_CPC" : Intrinsics.areEqual("organic", lowerCase) ? "TSM_ORGANIC" : "TSM_OTHER";
            }

            private final String bucketTrafficName(String utmCampaign, Scoring scoring) {
                if (isNullish(utmCampaign)) {
                    return "TSN_OTHER";
                }
                if (Intrinsics.areEqual("google_ads", utmCampaign)) {
                    return "TSN_GOOGLE_ADS";
                }
                utmCampaign.getClass();
                int length = utmCampaign.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) utmCampaign.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                String string = utmCampaign.subSequence(i, length + 1).toString();
                String strM = FileInsert$$ExternalSyntheticOutline0.m("TSN_", string);
                return scoring.hasCategory("traffic_name_bucket", strM) ? strM : StringsKt.startsWith$default(string, "SAA_AND_ACQ_") ? "TSN_PAID_ACQ_OTHER" : "TSN_OTHER";
            }

            private final String bucketTrafficSource(String utmSource, String installerPkg) {
                if (isNullish(utmSource)) {
                    return "TSS_OTHER";
                }
                utmSource.getClass();
                int length = utmSource.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) utmSource.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                String string = utmSource.subSequence(i, length + 1).toString();
                return StringsKt__StringsJVMKt.equals("google", string, true) ? "TSS_GOOGLE" : StringsKt__StringsJVMKt.equals("google-play", string, true) ? "TSS_GOOGLE_PLAY" : "TSS_OTHER";
            }

            private final boolean isNullish(String s) {
                if (s != null) {
                    int length = s.length() - 1;
                    int i = 0;
                    boolean z = false;
                    while (i <= length) {
                        boolean z2 = Intrinsics.compare((int) s.charAt(!z ? i : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (z2) {
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    String string = s.subSequence(i, length + 1).toString();
                    if (string.length() != 0 && !StringsKt__StringsJVMKt.equals("(not set)", string, true) && !StringsKt__StringsJVMKt.equals("null", string, true)) {
                        return false;
                    }
                }
                return true;
            }

            public final Buckets bucketize(RawSignals raw, BucketMap bm, Scoring scoring) {
                raw.getClass();
                bm.getClass();
                scoring.getClass();
                String strBucketCountry = bm.bucketCountry(raw.getCountryName());
                zza$$ExternalSyntheticOutline0.m("Country bucket ", strBucketCountry);
                String strBucketBrand = bm.bucketBrand(raw.getBrandName());
                String strBucketHw = bm.bucketHw(raw.getHwModel());
                String str = raw.getIsTablet() ? "DEVICE_TABLET" : "DEVICE_PHONE";
                if (raw.getIsTvOrOther()) {
                    str = "DEVICE_OTHER";
                }
                String str2 = str;
                String strM = FileInsert$$ExternalSyntheticOutline0.m(raw.getAndroidMajor(), "OS_");
                String str3 = Intrinsics.areEqual("com.android.vending", raw.getInstallerPackage()) ? "INSTALL_PLAY" : "INSTALL_OTHER";
                String languageTag = raw.getLanguageTag();
                return new Buckets(strBucketCountry, scoring.hasCategory("language_bucket", FileInsert$$ExternalSyntheticOutline0.m("LANG_", languageTag)) ? FileInsert$$ExternalSyntheticOutline0.m("LANG_", languageTag) : "LANG_OTHER", str2, strBucketBrand, strBucketHw, strM, str3, bucketTrafficName(raw.getUtmCampaign(), scoring), bucketTrafficMedium(raw.getUtmMedium()), bucketTrafficSource(raw.getUtmSource(), raw.getInstallerPackage()));
            }

            private Companion() {
            }
        }

        public Buckets(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
            this.countryBucket = str;
            this.languageBucket = str2;
            this.deviceCategoryBucket = str3;
            this.brandBucket = str4;
            this.hwModelBucket = str5;
            this.osBucket = str6;
            this.installSourceBucket = str7;
            this.trafficNameBucket = str8;
            this.trafficMediumBucket = str9;
            this.trafficSourceBucket = str10;
        }

        public final String getBrandBucket() {
            return this.brandBucket;
        }

        public final String getCountryBucket() {
            return this.countryBucket;
        }

        public final String getDeviceCategoryBucket() {
            return this.deviceCategoryBucket;
        }

        public final String getHwModelBucket() {
            return this.hwModelBucket;
        }

        public final String getInstallSourceBucket() {
            return this.installSourceBucket;
        }

        public final String getLanguageBucket() {
            return this.languageBucket;
        }

        public final String getOsBucket() {
            return this.osBucket;
        }

        public final String getTrafficMediumBucket() {
            return this.trafficMediumBucket;
        }

        public final String getTrafficNameBucket() {
            return this.trafficNameBucket;
        }

        public final String getTrafficSourceBucket() {
            return this.trafficSourceBucket;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Callback;", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface Callback {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Companion;", "", "<init>", "()V", "SEGMENTATION_VERSION", "", "gson", "Lcom/google/gson/Gson;", "norm", "", "s", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String norm(String s) {
            if (s == null) {
                return "";
            }
            int length = s.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) s.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            String lowerCase = s.subSequence(i, length + 1).toString().toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            String strNormalize = Normalizer.normalize(StringsKt__StringsJVMKt.replace$default(lowerCase, (char) 8217, '\'', false, 4, (Object) null), Normalizer.Form.NFKD);
            strNormalize.getClass();
            return new Regex("\\s+").replace(new Regex("\\p{M}").replace(strNormalize, ""), " ");
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#Bw\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0007\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\b\u0010\u0019R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b \u0010\u0015R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b!\u0010\u0015R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\"\u0010\u0015¨\u0006$"}, d2 = {"Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$RawSignals;", "", "", "countryName", "deviceCountry", "languageTag", "", "isTablet", "isTvOrOther", "brandName", "hwModel", "", "androidMajor", "installerPackage", "utmSource", "utmMedium", "utmCampaign", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/String;", "getCountryName", "()Ljava/lang/String;", "getDeviceCountry", "getLanguageTag", "Z", "()Z", "getBrandName", "getHwModel", "I", "getAndroidMajor", "()I", "getInstallerPackage", "getUtmSource", "getUtmMedium", "getUtmCampaign", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class RawSignals {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int androidMajor;
        private final String brandName;
        private final String countryName;
        private final String deviceCountry;
        private final String hwModel;
        private final String installerPackage;
        private final boolean isTablet;
        private final boolean isTvOrOther;
        private final String languageTag;
        private final String utmCampaign;
        private final String utmMedium;
        private final String utmSource;

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$RawSignals$Companion;", "", "<init>", "()V", "detect", "Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$RawSignals;", "ctx", "Landroid/content/Context;", "attrib", "Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Attribution;", "androidMajorFromSdk", "", ServerProtocol.DIALOG_PARAM_SDK_VERSION, "safeStr", "", "s", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final int androidMajorFromSdk(int sdk) {
                if (sdk >= 36) {
                    return 16;
                }
                if (sdk == 35) {
                    return 15;
                }
                if (sdk == 34) {
                    return 14;
                }
                if (sdk == 33) {
                    return 13;
                }
                if (sdk == 31 || sdk == 32) {
                    return 12;
                }
                if (sdk == 30) {
                    return 11;
                }
                if (sdk == 29) {
                    return 10;
                }
                if (sdk == 28) {
                    return 9;
                }
                if (sdk == 26 || sdk == 27) {
                    return 8;
                }
                if (sdk == 24 || sdk == 25) {
                    return 7;
                }
                return sdk == 23 ? 6 : 5;
            }

            private final String safeStr(String s) {
                return s == null ? "" : s;
            }

            public final RawSignals detect(Context ctx, Attribution attrib) {
                boolean z;
                ctx.getClass();
                attrib.getClass();
                Locale locale = Locale.getDefault();
                String country = new Settings(ctx).getCountry();
                String country2 = locale.getCountry();
                Logger.logInfo("Country ISO " + country);
                Logger.logInfo("Country Device " + locale.getCountry());
                String language = locale.getLanguage();
                if (!TextUtils.isEmpty(country)) {
                    language = FileInsert$$ExternalSyntheticOutline0.m$1(language, "-", country);
                }
                language.getClass();
                String lowerCase = language.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
                Configuration configuration = ctx.getResources().getConfiguration();
                boolean z2 = false;
                if (configuration.smallestScreenWidthDp >= 600) {
                    z = false;
                    z2 = true;
                } else {
                    z = false;
                }
                return new RawSignals(country, country2, lowerCase, z2, (configuration.uiMode & 15) != 4 ? z : true, safeStr(Build.BRAND), safeStr(Build.MODEL), androidMajorFromSdk(Build.VERSION.SDK_INT), safeStr(attrib.getInstallerPackage()), attrib.getUtmSource(), attrib.getUtmMedium(), attrib.getUtmCampaign());
            }

            private Companion() {
            }
        }

        public RawSignals(String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, int i, String str6, String str7, String str8, String str9) {
            str3.getClass();
            this.countryName = str;
            this.deviceCountry = str2;
            this.languageTag = str3;
            this.isTablet = z;
            this.isTvOrOther = z2;
            this.brandName = str4;
            this.hwModel = str5;
            this.androidMajor = i;
            this.installerPackage = str6;
            this.utmSource = str7;
            this.utmMedium = str8;
            this.utmCampaign = str9;
        }

        public final int getAndroidMajor() {
            return this.androidMajor;
        }

        public final String getBrandName() {
            return this.brandName;
        }

        public final String getCountryName() {
            return this.countryName;
        }

        public final String getHwModel() {
            return this.hwModel;
        }

        public final String getInstallerPackage() {
            return this.installerPackage;
        }

        public final String getLanguageTag() {
            return this.languageTag;
        }

        public final String getUtmCampaign() {
            return this.utmCampaign;
        }

        public final String getUtmMedium() {
            return this.utmMedium;
        }

        public final String getUtmSource() {
            return this.utmSource;
        }

        /* JADX INFO: renamed from: isTablet, reason: from getter */
        public final boolean getIsTablet() {
            return this.isTablet;
        }

        /* JADX INFO: renamed from: isTvOrOther, reason: from getter */
        public final boolean getIsTvOrOther() {
            return this.isTvOrOther;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u007f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\n\u0010\u0015\u001a\u00020\u0005H\u0096\u0080\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Result;", "", "scorePoints", "", "segment", "", "countryBucket", "languageBucket", "deviceCategoryBucket", "brandBucket", "hwModelBucket", "osBucket", "installSourceBucket", "trafficNameBucket", "trafficMediumBucket", "trafficSourceBucket", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "logit", "", "probability", InAppPurchaseConstants.METHOD_TO_STRING, "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Result {
        public final String brandBucket;
        public final String countryBucket;
        public final String deviceCategoryBucket;
        public final String hwModelBucket;
        public final String installSourceBucket;
        public final String languageBucket;
        public final String osBucket;
        public final int scorePoints;
        public final String segment;
        public final String trafficMediumBucket;
        public final String trafficNameBucket;
        public final String trafficSourceBucket;

        public Result(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
            this.scorePoints = i;
            this.segment = str;
            this.countryBucket = str2;
            this.languageBucket = str3;
            this.deviceCategoryBucket = str4;
            this.brandBucket = str5;
            this.hwModelBucket = str6;
            this.osBucket = str7;
            this.installSourceBucket = str8;
            this.trafficNameBucket = str9;
            this.trafficMediumBucket = str10;
            this.trafficSourceBucket = str11;
        }

        public final double logit() {
            return ((double) this.scorePoints) / 1000.0d;
        }

        public final double probability() {
            return 1.0d / (Math.exp(-(((double) this.scorePoints) / 1000.0d)) + 1.0d);
        }

        public String toString() {
            int i = this.scorePoints;
            double dLogit = logit();
            double dProbability = probability();
            String str = this.segment;
            String str2 = this.countryBucket;
            String str3 = this.languageBucket;
            String str4 = this.deviceCategoryBucket;
            String str5 = this.brandBucket;
            String str6 = this.hwModelBucket;
            String str7 = this.osBucket;
            String str8 = this.installSourceBucket;
            String str9 = this.trafficNameBucket;
            String str10 = this.trafficMediumBucket;
            String str11 = this.trafficSourceBucket;
            StringBuilder sb = new StringBuilder("Segmentation: ");
            sb.append(i);
            sb.append(" ");
            sb.append(dLogit);
            sb.append(" ");
            sb.append(dProbability);
            sb.append(" ");
            FileInsert$$ExternalSyntheticOutline0.m(sb, str, " ", str2, " ");
            FileInsert$$ExternalSyntheticOutline0.m(sb, str3, " ", str4, " ");
            FileInsert$$ExternalSyntheticOutline0.m(sb, str5, " ", str6, " ");
            FileInsert$$ExternalSyntheticOutline0.m(sb, str7, " ", str8, " ");
            FileInsert$$ExternalSyntheticOutline0.m(sb, str9, " ", str10, " ");
            sb.append(str11);
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\b\b\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012RB\u0010\u001a\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00190\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Scoring;", "", "<init>", "()V", "", "feature", IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY, "", "getPoints", "(Ljava/lang/String;Ljava/lang/String;)I", "", "hasCategory", "(Ljava/lang/String;Ljava/lang/String;)Z", "pointsScale", "I", "getPointsScale", "()I", "setPointsScale", "(I)V", "vipPointsCutoff", "getVipPointsCutoff", "setVipPointsCutoff", "likelyPointsCutoff", "getLikelyPointsCutoff", "setLikelyPointsCutoff", "", "weights", "Ljava/util/Map;", "getWeights", "()Ljava/util/Map;", "setWeights", "(Ljava/util/Map;)V", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Scoring {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private int pointsScale = 1000;
        private int vipPointsCutoff = 405;
        private int likelyPointsCutoff = 182;
        private Map<String, Map<String, Integer>> weights = new HashMap();

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Scoring$Companion;", "", "<init>", "()V", "parse", "Lcom/urbandroid/sleep/marketing/MonetizationSegmentation$Scoring;", "json", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Scoring parse(String json) {
                Scoring scoring = new Scoring();
                if (!TextUtils.isEmpty(json)) {
                    try {
                        Object objFromJson = MonetizationSegmentation.gson.fromJson(json, (Class<Object>) JsonElement.class);
                        objFromJson.getClass();
                        JsonElement jsonElement = (JsonElement) objFromJson;
                        scoring.setPointsScale(jsonElement.getAsJsonObject().get("points_scale").getAsInt());
                        scoring.setVipPointsCutoff(jsonElement.getAsJsonObject().get("vip_points_cutoff").getAsInt());
                        scoring.setLikelyPointsCutoff(jsonElement.getAsJsonObject().get("likely_points_cutoff").getAsInt());
                        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get("weights_points");
                        if (jsonElement2 != null && jsonElement2.isJsonObject()) {
                            for (Map.Entry<String, JsonElement> entry : jsonElement2.getAsJsonObject().entrySet()) {
                                String key = entry.getKey();
                                HashMap map = new HashMap();
                                for (Map.Entry<String, JsonElement> entry2 : entry.getValue().getAsJsonObject().entrySet()) {
                                    String key2 = entry2.getKey();
                                    Logger.logInfo("Segmentation: " + key + " : " + ((Object) key2) + " " + entry2.getValue());
                                    map.put(entry2.getKey(), Integer.valueOf(entry2.getValue().getAsInt()));
                                }
                                scoring.getWeights().put(key, map);
                            }
                        }
                    } catch (Exception e) {
                        Logger.logSevere(e);
                        return scoring;
                    }
                }
                return scoring;
            }

            private Companion() {
            }
        }

        public final int getLikelyPointsCutoff() {
            return this.likelyPointsCutoff;
        }

        public final int getPoints(String feature, String category) {
            Integer num;
            Map<String, Integer> map = this.weights.get(feature);
            if (map == null || (num = map.get(category)) == null) {
                return 0;
            }
            return num.intValue();
        }

        public final int getVipPointsCutoff() {
            return this.vipPointsCutoff;
        }

        public final Map<String, Map<String, Integer>> getWeights() {
            return this.weights;
        }

        public final boolean hasCategory(String feature, String category) {
            Map<String, Integer> map = this.weights.get(feature);
            return map != null && map.containsKey(category);
        }

        public final void setLikelyPointsCutoff(int i) {
            this.likelyPointsCutoff = i;
        }

        public final void setPointsScale(int i) {
            this.pointsScale = i;
        }

        public final void setVipPointsCutoff(int i) {
            this.vipPointsCutoff = i;
        }
    }

    private final Result score(Scoring scoring, Buckets b) {
        int points = scoring.getPoints("INTERCEPT", "INTERCEPT") + scoring.getPoints("country_bucket", b.getCountryBucket()) + scoring.getPoints("language_bucket", b.getLanguageBucket()) + scoring.getPoints("device_category_bucket", b.getDeviceCategoryBucket()) + scoring.getPoints("brand_bucket", b.getBrandBucket()) + scoring.getPoints("hw_model_bucket", b.getHwModelBucket()) + scoring.getPoints("os_bucket", b.getOsBucket()) + scoring.getPoints("install_source_bucket", b.getInstallSourceBucket()) + scoring.getPoints("traffic_name_bucket", b.getTrafficNameBucket()) + scoring.getPoints("traffic_medium_bucket", b.getTrafficMediumBucket()) + scoring.getPoints("traffic_source_bucket", b.getTrafficSourceBucket());
        return new Result(points, points >= scoring.getVipPointsCutoff() ? "VIP" : points >= scoring.getLikelyPointsCutoff() ? "LIKELY_PAYER" : "REST_F2P", b.getCountryBucket(), b.getLanguageBucket(), b.getDeviceCategoryBucket(), b.getBrandBucket(), b.getHwModelBucket(), b.getOsBucket(), b.getInstallSourceBucket(), b.getTrafficNameBucket(), b.getTrafficMediumBucket(), b.getTrafficSourceBucket());
    }

    public final void calculateSegments(Context context, Callback cb) {
        String installerPackageName;
        context.getClass();
        cb.getClass();
        Settings settings = new Settings(context);
        if (settings.getMarketingScore() == -1 || settings.getMarketingSegment() == null) {
            BucketMap bucketMap = BucketMap.INSTANCE.parse(this.bucketMapJson);
            Scoring scoring = Scoring.INSTANCE.parse(this.scoringJson);
            try {
                installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            } catch (Exception e) {
                Logger.logSevere("TrialFilter: installer package not available: " + e.getMessage());
                installerPackageName = "com.android";
            }
            ((FirebaseAnalyticsManager$31$$ExternalSyntheticLambda0) cb).onResult(score(scoring, Buckets.INSTANCE.bucketize(RawSignals.INSTANCE.detect(context, new Attribution(installerPackageName, settings.getMarketingSource(), settings.getMarketingMedium(), settings.getMarketingCampaign())), bucketMap, scoring)));
        }
    }
}
