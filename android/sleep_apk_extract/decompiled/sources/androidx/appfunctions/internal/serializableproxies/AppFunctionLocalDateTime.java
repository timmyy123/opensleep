package androidx.appfunctions.internal.serializableproxies;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.LocalDateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0010JV\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0010J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b#\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b$\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b%\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b&\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b'\u0010\u0010R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b(\u0010\u0010¨\u0006*"}, d2 = {"Landroidx/appfunctions/internal/serializableproxies/AppFunctionLocalDateTime;", "", "", "year", "month", "dayOfMonth", "hour", "minute", "second", "nanoOfSecond", "<init>", "(IIIIIII)V", "j$/time/LocalDateTime", "toLocalDateTime", "()Lj$/time/LocalDateTime;", "component1", "()I", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(IIIIIII)Landroidx/appfunctions/internal/serializableproxies/AppFunctionLocalDateTime;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getYear", "getMonth", "getDayOfMonth", "getHour", "getMinute", "getSecond", "getNanoOfSecond", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionLocalDateTime {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int dayOfMonth;
    private final int hour;
    private final int minute;
    private final int month;
    private final int nanoOfSecond;
    private final int second;
    private final int year;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/appfunctions/internal/serializableproxies/AppFunctionLocalDateTime$Companion;", "", "<init>", "()V", "j$/time/LocalDateTime", "localDateTime", "Landroidx/appfunctions/internal/serializableproxies/AppFunctionLocalDateTime;", "fromLocalDateTime", "(Lj$/time/LocalDateTime;)Landroidx/appfunctions/internal/serializableproxies/AppFunctionLocalDateTime;", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppFunctionLocalDateTime fromLocalDateTime(LocalDateTime localDateTime) {
            localDateTime.getClass();
            return new AppFunctionLocalDateTime(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth(), localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond(), localDateTime.getNano());
        }

        private Companion() {
        }
    }

    public AppFunctionLocalDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.year = i;
        this.month = i2;
        this.dayOfMonth = i3;
        this.hour = i4;
        this.minute = i5;
        this.second = i6;
        this.nanoOfSecond = i7;
    }

    public static /* synthetic */ AppFunctionLocalDateTime copy$default(AppFunctionLocalDateTime appFunctionLocalDateTime, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i = appFunctionLocalDateTime.year;
        }
        if ((i8 & 2) != 0) {
            i2 = appFunctionLocalDateTime.month;
        }
        if ((i8 & 4) != 0) {
            i3 = appFunctionLocalDateTime.dayOfMonth;
        }
        if ((i8 & 8) != 0) {
            i4 = appFunctionLocalDateTime.hour;
        }
        if ((i8 & 16) != 0) {
            i5 = appFunctionLocalDateTime.minute;
        }
        if ((i8 & 32) != 0) {
            i6 = appFunctionLocalDateTime.second;
        }
        if ((i8 & 64) != 0) {
            i7 = appFunctionLocalDateTime.nanoOfSecond;
        }
        int i9 = i6;
        int i10 = i7;
        int i11 = i5;
        int i12 = i3;
        return appFunctionLocalDateTime.copy(i, i2, i12, i4, i11, i9, i10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMonth() {
        return this.month;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getHour() {
        return this.hour;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getMinute() {
        return this.minute;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSecond() {
        return this.second;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getNanoOfSecond() {
        return this.nanoOfSecond;
    }

    public final AppFunctionLocalDateTime copy(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond) {
        return new AppFunctionLocalDateTime(year, month, dayOfMonth, hour, minute, second, nanoOfSecond);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionLocalDateTime)) {
            return false;
        }
        AppFunctionLocalDateTime appFunctionLocalDateTime = (AppFunctionLocalDateTime) other;
        return this.year == appFunctionLocalDateTime.year && this.month == appFunctionLocalDateTime.month && this.dayOfMonth == appFunctionLocalDateTime.dayOfMonth && this.hour == appFunctionLocalDateTime.hour && this.minute == appFunctionLocalDateTime.minute && this.second == appFunctionLocalDateTime.second && this.nanoOfSecond == appFunctionLocalDateTime.nanoOfSecond;
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getNanoOfSecond() {
        return this.nanoOfSecond;
    }

    public final int getSecond() {
        return this.second;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return Integer.hashCode(this.nanoOfSecond) + FileInsert$$ExternalSyntheticOutline0.m(this.second, FileInsert$$ExternalSyntheticOutline0.m(this.minute, FileInsert$$ExternalSyntheticOutline0.m(this.hour, FileInsert$$ExternalSyntheticOutline0.m(this.dayOfMonth, FileInsert$$ExternalSyntheticOutline0.m(this.month, Integer.hashCode(this.year) * 31, 31), 31), 31), 31), 31);
    }

    public final LocalDateTime toLocalDateTime() {
        LocalDateTime localDateTimeOf = LocalDateTime.of(this.year, this.month, this.dayOfMonth, this.hour, this.minute, this.second, this.nanoOfSecond);
        localDateTimeOf.getClass();
        return localDateTimeOf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionLocalDateTime(year=");
        sb.append(this.year);
        sb.append(", month=");
        sb.append(this.month);
        sb.append(", dayOfMonth=");
        sb.append(this.dayOfMonth);
        sb.append(", hour=");
        sb.append(this.hour);
        sb.append(", minute=");
        sb.append(this.minute);
        sb.append(", second=");
        sb.append(this.second);
        sb.append(", nanoOfSecond=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.nanoOfSecond, ')');
    }
}
