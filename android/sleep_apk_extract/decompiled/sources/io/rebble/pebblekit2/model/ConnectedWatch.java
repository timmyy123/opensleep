package io.rebble.pebblekit2.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.rebble.pebblekit2.common.model.WatchIdentifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001a\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001b\u0010\u0010R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001e\u0010\u0012R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001f\u0010\u0012R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b \u0010\u0010¨\u0006!"}, d2 = {"Lio/rebble/pebblekit2/model/ConnectedWatch;", "", "Lio/rebble/pebblekit2/common/model/WatchIdentifier;", "id", "", "name", "platform", "revision", "", "firmwareVersionMajor", "firmwareVersionMinor", "firmwareVersionPatch", "firmwareVersionTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId-UneDRvs", "getName", "getPlatform", "getRevision", "I", "getFirmwareVersionMajor", "getFirmwareVersionMinor", "getFirmwareVersionPatch", "getFirmwareVersionTag", "client-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ConnectedWatch {
    private final int firmwareVersionMajor;
    private final int firmwareVersionMinor;
    private final int firmwareVersionPatch;
    private final String firmwareVersionTag;
    private final String id;
    private final String name;
    private final String platform;
    private final String revision;

    private ConnectedWatch(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        this.id = str;
        this.name = str2;
        this.platform = str3;
        this.revision = str4;
        this.firmwareVersionMajor = i;
        this.firmwareVersionMinor = i2;
        this.firmwareVersionPatch = i3;
        this.firmwareVersionTag = str5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectedWatch)) {
            return false;
        }
        ConnectedWatch connectedWatch = (ConnectedWatch) other;
        return WatchIdentifier.m2352equalsimpl0(this.id, connectedWatch.id) && Intrinsics.areEqual(this.name, connectedWatch.name) && Intrinsics.areEqual(this.platform, connectedWatch.platform) && Intrinsics.areEqual(this.revision, connectedWatch.revision) && this.firmwareVersionMajor == connectedWatch.firmwareVersionMajor && this.firmwareVersionMinor == connectedWatch.firmwareVersionMinor && this.firmwareVersionPatch == connectedWatch.firmwareVersionPatch && Intrinsics.areEqual(this.firmwareVersionTag, connectedWatch.firmwareVersionTag);
    }

    public int hashCode() {
        int iM = FileInsert$$ExternalSyntheticOutline0.m(this.firmwareVersionPatch, FileInsert$$ExternalSyntheticOutline0.m(this.firmwareVersionMinor, FileInsert$$ExternalSyntheticOutline0.m(this.firmwareVersionMajor, FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(WatchIdentifier.m2353hashCodeimpl(this.id) * 31, 31, this.name), 31, this.platform), 31, this.revision), 31), 31), 31);
        String str = this.firmwareVersionTag;
        return iM + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String strM2354toStringimpl = WatchIdentifier.m2354toStringimpl(this.id);
        String str = this.name;
        String str2 = this.platform;
        String str3 = this.revision;
        int i = this.firmwareVersionMajor;
        int i2 = this.firmwareVersionMinor;
        int i3 = this.firmwareVersionPatch;
        String str4 = this.firmwareVersionTag;
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("ConnectedWatch(id=", strM2354toStringimpl, ", name=", str, ", platform=");
        FileInsert$$ExternalSyntheticOutline0.m(sbM6m, str2, ", revision=", str3, ", firmwareVersionMajor=");
        Fragment$$ExternalSyntheticOutline1.m(sbM6m, i, ", firmwareVersionMinor=", i2, ", firmwareVersionPatch=");
        sbM6m.append(i3);
        sbM6m.append(", firmwareVersionTag=");
        sbM6m.append(str4);
        sbM6m.append(")");
        return sbM6m.toString();
    }

    public /* synthetic */ ConnectedWatch(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i, i2, i3, str5);
    }
}
