package androidx.health.platform.client.request;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.RequestProto;
import androidx.health.platform.client.request.UpsertDataRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/health/platform/client/request/UpsertDataRequest;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/RequestProto$UpsertDataRequest;", "dataPoints", "", "Landroidx/health/platform/client/proto/DataProto$DataPoint;", "<init>", "(Ljava/util/List;)V", "getDataPoints", "()Ljava/util/List;", "proto", "getProto", "()Landroidx/health/platform/client/proto/RequestProto$UpsertDataRequest;", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UpsertDataRequest extends ProtoParcelable<RequestProto.UpsertDataRequest> {
    private final List<DataProto.DataPoint> dataPoints;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<UpsertDataRequest> CREATOR = new Parcelable.Creator<UpsertDataRequest>() { // from class: androidx.health.platform.client.request.UpsertDataRequest$special$$inlined$newCreator$connect_client_release$1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r2v8, types: [androidx.health.platform.client.impl.data.ProtoParcelable, androidx.health.platform.client.request.UpsertDataRequest] */
        @Override // android.os.Parcelable.Creator
        public UpsertDataRequest createFromParcel(Parcel source) {
            source.getClass();
            int i = source.readInt();
            if (i != 0) {
                if (i == 1) {
                    return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], UpsertDataRequest>() { // from class: androidx.health.platform.client.request.UpsertDataRequest$special$$inlined$newCreator$connect_client_release$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final UpsertDataRequest invoke(byte[] bArr) {
                            bArr.getClass();
                            RequestProto.UpsertDataRequest from = RequestProto.UpsertDataRequest.parseFrom(bArr);
                            UpsertDataRequest.Companion companion = UpsertDataRequest.INSTANCE;
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
            RequestProto.UpsertDataRequest from = RequestProto.UpsertDataRequest.parseFrom(bArrCreateByteArray);
            UpsertDataRequest.Companion companion = UpsertDataRequest.INSTANCE;
            from.getClass();
            return companion.fromProto$connect_client_release(from);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpsertDataRequest[] newArray(int size) {
            return new UpsertDataRequest[size];
        }
    };

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/health/platform/client/request/UpsertDataRequest$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/health/platform/client/request/UpsertDataRequest;", "fromProto", "proto", "Landroidx/health/platform/client/proto/RequestProto$UpsertDataRequest;", "fromProto$connect_client_release", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UpsertDataRequest fromProto$connect_client_release(RequestProto.UpsertDataRequest proto) {
            proto.getClass();
            List<DataProto.DataPoint> dataPointList = proto.getDataPointList();
            dataPointList.getClass();
            return new UpsertDataRequest(dataPointList);
        }

        private Companion() {
        }
    }

    public UpsertDataRequest(List<DataProto.DataPoint> list) {
        list.getClass();
        this.dataPoints = list;
    }

    public final List<DataProto.DataPoint> getDataPoints() {
        return this.dataPoints;
    }

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public RequestProto.UpsertDataRequest getProto() {
        RequestProto.UpsertDataRequest upsertDataRequestBuild = RequestProto.UpsertDataRequest.newBuilder().addAllDataPoint(this.dataPoints).build();
        upsertDataRequestBuild.getClass();
        return upsertDataRequestBuild;
    }
}
