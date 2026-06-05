package androidx.health.platform.client.request;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.platform.client.impl.data.ProtoParcelable;
import androidx.health.platform.client.impl.data.SharedMemory27Impl;
import androidx.health.platform.client.proto.RequestProto;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R!\u0010\u0012\u001a\u00020\u00028VX\u0096\u0084\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Landroidx/health/platform/client/request/RequestContext;", "Landroidx/health/platform/client/impl/data/ProtoParcelable;", "Landroidx/health/platform/client/proto/RequestProto$RequestContext;", "callingPackage", "", "sdkVersion", "", "permissionToken", "isInForeground", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getCallingPackage", "()Ljava/lang/String;", "getSdkVersion", "()I", "getPermissionToken", "()Z", "proto", "getProto$annotations", "()V", "getProto", "()Landroidx/health/platform/client/proto/RequestProto$RequestContext;", "proto$delegate", "Lkotlin/Lazy;", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RequestContext extends ProtoParcelable<RequestProto.RequestContext> {
    private final String callingPackage;
    private final boolean isInForeground;
    private final String permissionToken;

    /* JADX INFO: renamed from: proto$delegate, reason: from kotlin metadata */
    private final Lazy proto;
    private final int sdkVersion;
    public static final Parcelable.Creator<RequestContext> CREATOR = new Parcelable.Creator<RequestContext>() { // from class: androidx.health.platform.client.request.RequestContext$special$$inlined$newCreator$connect_client_release$1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r3v8, types: [androidx.health.platform.client.impl.data.ProtoParcelable, androidx.health.platform.client.request.RequestContext] */
        @Override // android.os.Parcelable.Creator
        public RequestContext createFromParcel(Parcel source) {
            source.getClass();
            int i = source.readInt();
            if (i != 0) {
                if (i == 1) {
                    return (ProtoParcelable) SharedMemory27Impl.INSTANCE.parseParcelUsingSharedMemory(source, new Function1<byte[], RequestContext>() { // from class: androidx.health.platform.client.request.RequestContext$special$$inlined$newCreator$connect_client_release$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final RequestContext invoke(byte[] bArr) {
                            bArr.getClass();
                            RequestProto.RequestContext from = RequestProto.RequestContext.parseFrom(bArr);
                            String callingPackage = from.getCallingPackage();
                            callingPackage.getClass();
                            return new RequestContext(callingPackage, from.getSdkVersion(), from.getPermissionToken(), from.getIsInForeground());
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
            RequestProto.RequestContext from = RequestProto.RequestContext.parseFrom(bArrCreateByteArray);
            String callingPackage = from.getCallingPackage();
            callingPackage.getClass();
            return new RequestContext(callingPackage, from.getSdkVersion(), from.getPermissionToken(), from.getIsInForeground());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RequestContext[] newArray(int size) {
            return new RequestContext[size];
        }
    };

    public RequestContext(String str, int i, String str2, boolean z) {
        str.getClass();
        this.callingPackage = str;
        this.sdkVersion = i;
        this.permissionToken = str2;
        this.isInForeground = z;
        this.proto = LazyKt.lazy(new Function0<RequestProto.RequestContext>() { // from class: androidx.health.platform.client.request.RequestContext$proto$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RequestProto.RequestContext invoke() {
                RequestContext requestContext = this.this$0;
                RequestProto.RequestContext.Builder sdkVersion = RequestProto.RequestContext.newBuilder().setCallingPackage(requestContext.getCallingPackage()).setSdkVersion(requestContext.getSdkVersion());
                String permissionToken = requestContext.getPermissionToken();
                if (permissionToken != null) {
                    sdkVersion.setPermissionToken(permissionToken);
                }
                return sdkVersion.setIsInForeground(requestContext.getIsInForeground()).build();
            }
        });
    }

    public static /* synthetic */ void getProto$annotations() {
    }

    public final String getCallingPackage() {
        return this.callingPackage;
    }

    public final String getPermissionToken() {
        return this.permissionToken;
    }

    @Override // androidx.health.platform.client.impl.data.ProtoData
    public RequestProto.RequestContext getProto() {
        Object value = this.proto.getValue();
        value.getClass();
        return (RequestProto.RequestContext) value;
    }

    public final int getSdkVersion() {
        return this.sdkVersion;
    }

    /* JADX INFO: renamed from: isInForeground, reason: from getter */
    public final boolean getIsInForeground() {
        return this.isInForeground;
    }
}
