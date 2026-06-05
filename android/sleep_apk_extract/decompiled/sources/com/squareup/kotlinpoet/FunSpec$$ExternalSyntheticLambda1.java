package com.squareup.kotlinpoet;

import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.os.Parcel;
import androidx.appfunctions.AppFunctionUriGrant;
import androidx.appfunctions.ExecuteAppFunctionResponse;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableInterface;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import androidx.appsearch.app.SearchResult;
import androidx.compose.runtime.snapshots.SnapshotStateList$Companion$CREATOR$1;
import androidx.sqlite.SQLiteConnection;
import androidx.work.Data;
import androidx.work.WorkInfo$State;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.polar.sdk.api.model.PolarDeviceInfo;
import com.urbandroid.sleep.StartTrackActivity$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.activityrecognition.ActivityIntervals;
import com.urbandroid.sleep.activityrecognition.calculator.SleepTimeDetectedActivityCalculator;
import com.urbandroid.sleep.hr.polar.PolarApiFacade;
import com.urbandroid.sleep.smartwatch.polar.Polar;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.websocket.BuildersKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Calendar;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.android.HandlerContext;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FunSpec$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ FunSpec$$ExternalSyntheticLambda1(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (i) {
            case 0:
                return FunSpec.emitSignature$lambda$8((CodeWriter) obj3, (FunSpec) obj2, (ParameterSpec) obj);
            case 1:
                return ExecuteAppFunctionResponse.Success.grantUriAccess$lambda$0((Context) obj3, (String) obj2, (AppFunctionUriGrant) obj);
            case 2:
                AnnotatedAppFunctionSerializableInterface annotatedAppFunctionSerializableInterface = (AnnotatedAppFunctionSerializableInterface) obj3;
                Map map = (Map) obj2;
                if (obj == null) {
                    return AnnotatedAppFunctionSerializableInterface.getProperties$lambda$0(annotatedAppFunctionSerializableInterface, map, null);
                }
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            case 3:
                return AppSearchAppFunctionReader.performSearch$lambda$0((AppSearchAppFunctionReader) obj3, (Map) obj2, (SearchResult) obj);
            case 4:
                return SnapshotStateList$Companion$CREATOR$1.createFromParcel$lambda$0((Parcel) obj3, (ClassLoader) obj2, ((Integer) obj).intValue());
            case 5:
                return DependencyDao_Impl.insertDependency$lambda$0((DependencyDao_Impl) obj3, (Dependency) obj2, (SQLiteConnection) obj);
            case 6:
                return PreferenceDao_Impl.insertPreference$lambda$0((PreferenceDao_Impl) obj3, (Preference) obj2, (SQLiteConnection) obj);
            case 7:
                return SystemIdInfoDao_Impl.insertSystemIdInfo$lambda$0((SystemIdInfoDao_Impl) obj3, (SystemIdInfo) obj2, (SQLiteConnection) obj);
            case 8:
                return WorkNameDao_Impl.insert$lambda$0((WorkNameDao_Impl) obj3, (WorkName) obj2, (SQLiteConnection) obj);
            case 9:
                return WorkProgressDao_Impl.insert$lambda$0((WorkProgressDao_Impl) obj3, (WorkProgress) obj2, (SQLiteConnection) obj);
            case 10:
                return Integer.valueOf(WorkSpecDao_Impl.setState$lambda$38("UPDATE workspec SET state=? WHERE id=?", (WorkInfo$State) obj3, (String) obj2, (SQLiteConnection) obj));
            case 11:
                return WorkSpecDao_Impl.insertWorkSpec$lambda$0((WorkSpecDao_Impl) obj3, (WorkSpec) obj2, (SQLiteConnection) obj);
            case 12:
                return WorkSpecDao_Impl.setOutput$lambda$41("UPDATE workspec SET output=? WHERE id=?", (Data) obj3, (String) obj2, (SQLiteConnection) obj);
            case 13:
                return WorkTagDao_Impl.insert$lambda$0((WorkTagDao_Impl) obj3, (WorkTag) obj2, (SQLiteConnection) obj);
            case 14:
                return Boolean.valueOf(SleepTimeDetectedActivityCalculator.estimate$lambda$1((Calendar) obj3, (Calendar) obj2, (ActivityIntervals.Interval) obj));
            case 15:
                return PolarApiFacade.configureCharacteristics$lambda$2$0((BluetoothGattCharacteristic) obj3, (PolarApiFacade) obj2, (BluetoothGattCharacteristic) obj);
            case 16:
                return Polar.asyncConnectionCheck$lambda$0((PolarDeviceInfo) obj3, (Polar) obj2, (PolarDeviceInfo) obj);
            case 17:
                return HttpClientConfig.install$lambda$3((Function1) obj3, (Function1) obj2, obj);
            case 18:
                return BuildersKt.webSocketSession$lambda$6((String) obj3, (Function1) obj2, (HttpRequestBuilder) obj);
            default:
                return HandlerContext.scheduleResumeAfterDelay$lambda$1((HandlerContext) obj3, (StartTrackActivity$$ExternalSyntheticLambda0) obj2, (Throwable) obj);
        }
    }
}
