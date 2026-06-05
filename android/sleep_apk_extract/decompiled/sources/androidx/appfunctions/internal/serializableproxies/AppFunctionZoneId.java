package androidx.appfunctions.internal.serializableproxies;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.ZoneId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\n¨\u0006\u0018"}, d2 = {"Landroidx/appfunctions/internal/serializableproxies/AppFunctionZoneId;", "", "", "zoneID", "<init>", "(Ljava/lang/String;)V", "j$/time/ZoneId", "toZoneId", "()Lj$/time/ZoneId;", "component1", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;)Landroidx/appfunctions/internal/serializableproxies/AppFunctionZoneId;", InAppPurchaseConstants.METHOD_TO_STRING, "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getZoneID", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionZoneId {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String zoneID;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/appfunctions/internal/serializableproxies/AppFunctionZoneId$Companion;", "", "<init>", "()V", "j$/time/ZoneId", "zoneId", "Landroidx/appfunctions/internal/serializableproxies/AppFunctionZoneId;", "fromZoneId", "(Lj$/time/ZoneId;)Landroidx/appfunctions/internal/serializableproxies/AppFunctionZoneId;", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppFunctionZoneId fromZoneId(ZoneId zoneId) {
            zoneId.getClass();
            String id = zoneId.getId();
            id.getClass();
            return new AppFunctionZoneId(id);
        }

        private Companion() {
        }
    }

    public AppFunctionZoneId(String str) {
        str.getClass();
        this.zoneID = str;
    }

    public static /* synthetic */ AppFunctionZoneId copy$default(AppFunctionZoneId appFunctionZoneId, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionZoneId.zoneID;
        }
        return appFunctionZoneId.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getZoneID() {
        return this.zoneID;
    }

    public final AppFunctionZoneId copy(String zoneID) {
        zoneID.getClass();
        return new AppFunctionZoneId(zoneID);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AppFunctionZoneId) && Intrinsics.areEqual(this.zoneID, ((AppFunctionZoneId) other).zoneID);
    }

    public final String getZoneID() {
        return this.zoneID;
    }

    public int hashCode() {
        return this.zoneID.hashCode();
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("AppFunctionZoneId(zoneID="), this.zoneID, ')');
    }

    public final ZoneId toZoneId() {
        ZoneId zoneIdOf = ZoneId.of(this.zoneID);
        zoneIdOf.getClass();
        return zoneIdOf;
    }
}
