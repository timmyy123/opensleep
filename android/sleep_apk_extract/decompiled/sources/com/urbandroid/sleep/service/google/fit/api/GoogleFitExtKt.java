package com.urbandroid.sleep.service.google.fit.api;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Session;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.activityrecognition.ActivityBootReceiver$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.service.google.fit.GoogleFitSleepSegmentTypeKt;
import com.urbandroid.sleep.service.health.session.HealthIntervalKt;
import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.HealthSessionSegment;
import com.urbandroid.sleep.service.health.session.SleepSegmentType;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0007¨\u0006\f"}, d2 = {"hasPermissions", "", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/google/android/gms/fitness/FitnessOptions;", "toFitSegmentDataSet", "Lcom/google/android/gms/fitness/data/DataSet;", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "toFitSession", "Lcom/google/android/gms/fitness/data/Session;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class GoogleFitExtKt {
    public static final boolean hasPermissions(GoogleSignInAccount googleSignInAccount, FitnessOptions fitnessOptions) {
        googleSignInAccount.getClass();
        fitnessOptions.getClass();
        return GoogleSignIn.hasPermissions(googleSignInAccount, fitnessOptions);
    }

    public static final DataSet toFitSegmentDataSet(HealthSession healthSession, Context context) {
        healthSession.getClass();
        context.getClass();
        if (!healthSession.hasSegments()) {
            return null;
        }
        final boolean z = false;
        DataSource dataSourceBuild = new DataSource.Builder().setDataType(DataType.TYPE_SLEEP_SEGMENT).setType(0).setStreamName("saa-generic").setAppPackageName(context).build();
        dataSourceBuild.getClass();
        DataSet.Builder builder = DataSet.builder(dataSourceBuild);
        builder.getClass();
        final String str = "fit-api";
        FeatureLogger featureLogger = new FeatureLogger() { // from class: com.urbandroid.sleep.service.google.fit.api.GoogleFitExtKt$toFitSegmentDataSet$$inlined$featureLog$default$1
            @Override // com.urbandroid.common.FeatureLogger
            public String getTag() {
                String str2 = str;
                boolean z2 = z;
                StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(str2);
                String strConcat = "";
                if (z2) {
                    String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
                    if (strM == null) {
                        strConcat = null;
                    } else if (!StringsKt.isBlank(strM)) {
                        strConcat = ":".concat(strM);
                    }
                }
                sbM.append(strConcat);
                return sbM.toString();
            }
        };
        for (HealthSessionSegment healthSessionSegment : healthSession.getSegments()) {
            if (!HealthIntervalKt.isValid(healthSessionSegment)) {
                String str2 = Logger.defaultTag;
                Logger.logWarning(str2, featureLogger.getTag() + ": " + ("Segment is not valid: " + healthSessionSegment), null);
            } else if (HealthIntervalKt.isExceeding(healthSessionSegment, healthSession)) {
                String str3 = Logger.defaultTag;
                Logger.logWarning(str3, featureLogger.getTag() + ": " + ("Segment is exceeding session: " + healthSessionSegment), null);
            } else {
                SleepSegmentType sleepSegmentType = healthSessionSegment.getSleepSegmentType();
                if (sleepSegmentType != null) {
                    DataPoint dataPointBuild = DataPoint.builder(dataSourceBuild).setTimeInterval(healthSessionSegment.getFromInMillis(), healthSessionSegment.getToInMillis(), TimeUnit.MILLISECONDS).setField(Field.FIELD_SLEEP_SEGMENT_TYPE, GoogleFitSleepSegmentTypeKt.toDataFieldValue(sleepSegmentType)).build();
                    dataPointBuild.getClass();
                    builder.add(dataPointBuild);
                }
            }
        }
        return builder.build();
    }

    public static final Session toFitSession(HealthSession healthSession) {
        healthSession.getClass();
        Session.Builder name = new Session.Builder().setName("Sleep");
        long fromInMillis = healthSession.getFromInMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Session.Builder activity = name.setStartTime(fromInMillis, timeUnit).setEndTime(healthSession.getToInMillis(), timeUnit).setActivity("sleep");
        String id = healthSession.getId();
        if (id != null) {
            activity.setIdentifier(id);
        }
        Session sessionBuild = activity.build();
        sessionBuild.getClass();
        return sessionBuild;
    }
}
