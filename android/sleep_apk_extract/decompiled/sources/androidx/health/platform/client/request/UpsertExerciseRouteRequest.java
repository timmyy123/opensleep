package androidx.health.platform.client.request;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.RequestProto;
import androidx.health.platform.client.request.UpsertExerciseRouteRequest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/health/platform/client/request/UpsertExerciseRouteRequest;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/RequestProto$UpsertExerciseRouteRequest;", "sessionUid", "", "route", "Landroidx/health/platform/client/proto/DataProto$DataPoint;", "<init>", "(Ljava/lang/String;Landroidx/health/platform/client/proto/DataProto$DataPoint;)V", "getSessionUid", "()Ljava/lang/String;", "getRoute", "()Landroidx/health/platform/client/proto/DataProto$DataPoint;", "proto", "getProto", "()Landroidx/health/platform/client/proto/RequestProto$UpsertExerciseRouteRequest;", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UpsertExerciseRouteRequest extends ProtoParcelable<RequestProto.UpsertExerciseRouteRequest> {
    private final DataProto.DataPoint route;
    private final String sessionUid;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<UpsertExerciseRouteRequest> CREATOR = new Parcelable.Creator<UpsertExerciseRouteRequest>() { // from class: androidx.health.platform.client.request.UpsertExerciseRouteRequest$special$$inlined$newCreator$connect_client_release$1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r2v8, types: [androidx.health.platform.client.impl.data.ProtoParcelable, androidx.health.platform.client.request.UpsertExerciseRouteRequest] */
        @Override // android.os.Parcelable.Creator
        public UpsertExerciseRouteRequest createFromParcel(Parcel source) {
            source.getClass();
            int i = source.readInt();
            if (i != 0) {
                if (i == 1) {
                    return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], UpsertExerciseRouteRequest>() { // from class: androidx.health.platform.client.request.UpsertExerciseRouteRequest$special$$inlined$newCreator$connect_client_release$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final UpsertExerciseRouteRequest invoke(byte[] bArr) {
                            bArr.getClass();
                            RequestProto.UpsertExerciseRouteRequest from = RequestProto.UpsertExerciseRouteRequest.parseFrom(bArr);
                            UpsertExerciseRouteRequest.Companion companion = UpsertExerciseRouteRequest.INSTANCE;
                            from.getClass();
                            return companion.fromProto$connect_client_release(from);
                        }
                    });
                }
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "Unknown storage: "));
                return null;
            }
            byte[] bArrCreateByteArray = source.createByteArray();
            if (bArrCreateByteArray == null) {
                return null;
            }
            RequestProto.UpsertExerciseRouteRequest from = RequestProto.UpsertExerciseRouteRequest.parseFrom(bArrCreateByteArray);
            UpsertExerciseRouteRequest.Companion companion = UpsertExerciseRouteRequest.INSTANCE;
            from.getClass();
            return companion.fromProto$connect_client_release(from);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpsertExerciseRouteRequest[] newArray(int size) {
            return new UpsertExerciseRouteRequest[size];
        }
    };

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/health/platform/client/request/UpsertExerciseRouteRequest$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/health/platform/client/request/UpsertExerciseRouteRequest;", "fromProto", "proto", "Landroidx/health/platform/client/proto/RequestProto$UpsertExerciseRouteRequest;", "fromProto$connect_client_release", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UpsertExerciseRouteRequest fromProto$connect_client_release(RequestProto.UpsertExerciseRouteRequest proto) {
            proto.getClass();
            String sessionUid = proto.getSessionUid();
            sessionUid.getClass();
            DataProto.DataPoint exerciseRoute = proto.getExerciseRoute();
            exerciseRoute.getClass();
            return new UpsertExerciseRouteRequest(sessionUid, exerciseRoute);
        }

        private Companion() {
        }
    }

    public UpsertExerciseRouteRequest(String str, DataProto.DataPoint dataPoint) {
        str.getClass();
        dataPoint.getClass();
        this.sessionUid = str;
        this.route = dataPoint;
    }

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public RequestProto.UpsertExerciseRouteRequest getProto() {
        RequestProto.UpsertExerciseRouteRequest upsertExerciseRouteRequestBuild = RequestProto.UpsertExerciseRouteRequest.newBuilder().setSessionUid(this.sessionUid).setExerciseRoute(this.route).build();
        upsertExerciseRouteRequestBuild.getClass();
        return upsertExerciseRouteRequestBuild;
    }

    public final DataProto.DataPoint getRoute() {
        return this.route;
    }

    public final String getSessionUid() {
        return this.sessionUid;
    }
}
