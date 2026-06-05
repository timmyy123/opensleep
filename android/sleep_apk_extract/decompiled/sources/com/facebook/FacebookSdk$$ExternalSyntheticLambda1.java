package com.facebook;

import android.adservices.measurement.MeasurementManager;
import android.app.ApplicationExitInfo;
import android.health.connect.AggregateRecordsGroupedByDurationResponse;
import android.health.connect.datatypes.units.Mass;
import android.os.IBinder;
import androidx.arch.core.util.Function;
import androidx.health.platform.client.impl.ipc.Client;
import androidx.health.platform.client.impl.ipc.RemoteOperation;
import androidx.health.platform.client.service.IHealthDataService;
import androidx.work.impl.model.WorkSpec;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FacebookSdk$$ExternalSyntheticLambda1 implements Client.ServiceGetter, RemoteOperation, Function, FacebookSdk.GraphRequestCreator {
    public static /* synthetic */ void m(int i, Object obj) {
        throw new IllegalStateException("Source subfield " + i + ((Object) " is present but null: ") + obj);
    }

    public static /* synthetic */ void m$1(String str, Object obj) {
        throw new IllegalStateException((str + obj + '\'').toString());
    }

    public static /* synthetic */ void m$2(String str, Object obj) {
        throw new IllegalStateException((str + obj).toString());
    }

    @Override // androidx.arch.core.util.Function
    public Object apply(Object obj) {
        return WorkSpec.WORK_INFO_MAPPER$lambda$1((List) obj);
    }

    @Override // com.facebook.FacebookSdk.GraphRequestCreator
    public GraphRequest createPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
        return FacebookSdk.graphRequestCreator$lambda$0(accessToken, str, jSONObject, callback);
    }

    @Override // androidx.health.platform.client.impl.ipc.RemoteOperation
    public Object execute(Object obj) {
        return Integer.valueOf(((IHealthDataService) obj).getApiVersion());
    }

    @Override // androidx.health.platform.client.impl.ipc.Client.ServiceGetter
    public Object getService(IBinder iBinder) {
        return IHealthDataService.Stub.asInterface(iBinder);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ApplicationExitInfo m263m(Object obj) {
        return (ApplicationExitInfo) obj;
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return MeasurementManager.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Mass m264m(Object obj) {
        return (Mass) obj;
    }

    public static /* bridge */ /* synthetic */ Class m() {
        return AggregateRecordsGroupedByDurationResponse.class;
    }

    public static /* bridge */ /* synthetic */ MeasurementManager m(Object obj) {
        return (MeasurementManager) obj;
    }

    public static /* synthetic */ void m(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void m(Object obj, Object obj2, Object obj3, Object obj4, String str) {
        throw new IllegalStateException(str + obj + obj2 + obj3 + obj4);
    }

    public static /* synthetic */ void m(Object obj, Object obj2, Object obj3, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        sb.append(obj3);
        throw new IllegalStateException(sb.toString(), th);
    }

    public static /* synthetic */ void m(String str) {
        throw new FacebookException(str);
    }

    public static /* synthetic */ void m(String str, int i, Object obj, int i2) {
        throw new IllegalArgumentException(str + i + obj + i2);
    }

    public static /* synthetic */ void m(String str, Object obj) {
        throw new RuntimeException(str + obj);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalStateException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3, Object obj4, Throwable th) {
        throw new RuntimeException(str + obj + obj2 + obj3 + obj4, th);
    }

    public static /* synthetic */ void m(StringBuilder sb, Object obj) {
        sb.append(obj);
        throw new IllegalStateException(sb.toString());
    }

    public static /* synthetic */ void m(Throwable th, Object obj, String str) {
        throw new RuntimeException(str + obj, th);
    }
}
