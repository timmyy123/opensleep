package androidx.health.platform.client.response;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.ResponseProto;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/health/platform/client/response/GetChangesTokenResponse;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/ResponseProto$GetChangesTokenResponse;", "proto", "<init>", "(Landroidx/health/platform/client/proto/ResponseProto$GetChangesTokenResponse;)V", "getProto", "()Landroidx/health/platform/client/proto/ResponseProto$GetChangesTokenResponse;", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GetChangesTokenResponse extends ProtoParcelable<ResponseProto.GetChangesTokenResponse> {
    private final ResponseProto.GetChangesTokenResponse proto;
    public static final Parcelable.Creator<GetChangesTokenResponse> CREATOR = new Parcelable.Creator<GetChangesTokenResponse>() { // from class: androidx.health.platform.client.response.GetChangesTokenResponse$special$$inlined$newCreator$connect_client_release$1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r2v7, types: [androidx.health.platform.client.impl.data.ProtoParcelable, androidx.health.platform.client.response.GetChangesTokenResponse] */
        @Override // android.os.Parcelable.Creator
        public GetChangesTokenResponse createFromParcel(Parcel source) {
            source.getClass();
            int i = source.readInt();
            if (i != 0) {
                if (i == 1) {
                    return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], GetChangesTokenResponse>() { // from class: androidx.health.platform.client.response.GetChangesTokenResponse$special$$inlined$newCreator$connect_client_release$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final GetChangesTokenResponse invoke(byte[] bArr) {
                            bArr.getClass();
                            ResponseProto.GetChangesTokenResponse from = ResponseProto.GetChangesTokenResponse.parseFrom(bArr);
                            from.getClass();
                            return new GetChangesTokenResponse(from);
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
            ResponseProto.GetChangesTokenResponse from = ResponseProto.GetChangesTokenResponse.parseFrom(bArrCreateByteArray);
            from.getClass();
            return new GetChangesTokenResponse(from);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetChangesTokenResponse[] newArray(int size) {
            return new GetChangesTokenResponse[size];
        }
    };

    public GetChangesTokenResponse(ResponseProto.GetChangesTokenResponse getChangesTokenResponse) {
        getChangesTokenResponse.getClass();
        this.proto = getChangesTokenResponse;
    }

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public ResponseProto.GetChangesTokenResponse getProto() {
        return this.proto;
    }
}
