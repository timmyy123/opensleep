package androidx.appfunctions.internal.serializableproxies;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u000e¨\u0006\u001e"}, d2 = {"Landroidx/appfunctions/internal/serializableproxies/AppFunctionInstant;", "", "", "epochSecond", "", "nanoAdjustment", "<init>", "(JI)V", "j$/time/Instant", "toInstant", "()Lj$/time/Instant;", "component1", "()J", "component2", "()I", "copy", "(JI)Landroidx/appfunctions/internal/serializableproxies/AppFunctionInstant;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getEpochSecond", "I", "getNanoAdjustment", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionInstant {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long epochSecond;
    private final int nanoAdjustment;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/appfunctions/internal/serializableproxies/AppFunctionInstant$Companion;", "", "<init>", "()V", "j$/time/Instant", "instant", "Landroidx/appfunctions/internal/serializableproxies/AppFunctionInstant;", "fromInstant", "(Lj$/time/Instant;)Landroidx/appfunctions/internal/serializableproxies/AppFunctionInstant;", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppFunctionInstant fromInstant(Instant instant) {
            instant.getClass();
            return new AppFunctionInstant(instant.getEpochSecond(), instant.getNano());
        }

        private Companion() {
        }
    }

    public AppFunctionInstant(long j, int i) {
        this.epochSecond = j;
        this.nanoAdjustment = i;
    }

    public static /* synthetic */ AppFunctionInstant copy$default(AppFunctionInstant appFunctionInstant, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = appFunctionInstant.epochSecond;
        }
        if ((i2 & 2) != 0) {
            i = appFunctionInstant.nanoAdjustment;
        }
        return appFunctionInstant.copy(j, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getEpochSecond() {
        return this.epochSecond;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getNanoAdjustment() {
        return this.nanoAdjustment;
    }

    public final AppFunctionInstant copy(long epochSecond, int nanoAdjustment) {
        return new AppFunctionInstant(epochSecond, nanoAdjustment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionInstant)) {
            return false;
        }
        AppFunctionInstant appFunctionInstant = (AppFunctionInstant) other;
        return this.epochSecond == appFunctionInstant.epochSecond && this.nanoAdjustment == appFunctionInstant.nanoAdjustment;
    }

    public final long getEpochSecond() {
        return this.epochSecond;
    }

    public final int getNanoAdjustment() {
        return this.nanoAdjustment;
    }

    public int hashCode() {
        return Integer.hashCode(this.nanoAdjustment) + (Long.hashCode(this.epochSecond) * 31);
    }

    public final Instant toInstant() {
        Instant instantOfEpochSecond = Instant.ofEpochSecond(this.epochSecond, this.nanoAdjustment);
        instantOfEpochSecond.getClass();
        return instantOfEpochSecond;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionInstant(epochSecond=");
        sb.append(this.epochSecond);
        sb.append(", nanoAdjustment=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.nanoAdjustment, ')');
    }
}
