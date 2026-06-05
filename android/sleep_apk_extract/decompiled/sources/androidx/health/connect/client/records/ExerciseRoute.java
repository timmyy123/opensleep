package androidx.health.connect.client.records;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.units.Length;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.Instant;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Landroidx/health/connect/client/records/ExerciseRoute;", "", "route", "", "Landroidx/health/connect/client/records/ExerciseRoute$Location;", "<init>", "(Ljava/util/List;)V", "getRoute", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "Location", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExerciseRoute {
    private final List<Location> route;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 #2\u00020\u0001:\u0001#BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b!\u0010 R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\"\u0010 ¨\u0006$"}, d2 = {"Landroidx/health/connect/client/records/ExerciseRoute$Location;", "", "j$/time/Instant", "time", "", "latitude", "longitude", "Landroidx/health/connect/client/units/Length;", "horizontalAccuracy", "verticalAccuracy", "altitude", "<init>", "(Lj$/time/Instant;DDLandroidx/health/connect/client/units/Length;Landroidx/health/connect/client/units/Length;Landroidx/health/connect/client/units/Length;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getTime", "()Lj$/time/Instant;", "D", "getLatitude", "()D", "getLongitude", "Landroidx/health/connect/client/units/Length;", "getHorizontalAccuracy", "()Landroidx/health/connect/client/units/Length;", "getVerticalAccuracy", "getAltitude", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Location {
        private final Length altitude;
        private final Length horizontalAccuracy;
        private final double latitude;
        private final double longitude;
        private final Instant time;
        private final Length verticalAccuracy;

        public Location(Instant instant, double d, double d2, Length length, Length length2, Length length3) {
            instant.getClass();
            this.time = instant;
            this.latitude = d;
            this.longitude = d2;
            this.horizontalAccuracy = length;
            this.verticalAccuracy = length2;
            this.altitude = length3;
            UtilsKt.requireNotLess(Double.valueOf(d), Double.valueOf(-90.0d), "latitude");
            UtilsKt.requireNotMore(Double.valueOf(d), Double.valueOf(90.0d), "latitude");
            UtilsKt.requireNotLess(Double.valueOf(d2), Double.valueOf(-180.0d), "longitude");
            UtilsKt.requireNotMore(Double.valueOf(d2), Double.valueOf(180.0d), "longitude");
            if (length != null) {
                UtilsKt.requireNotLess(length, length.zero$connect_client_release(), "horizontalAccuracy");
            }
            if (length2 != null) {
                UtilsKt.requireNotLess(length2, length2.zero$connect_client_release(), "verticalAccuracy");
            }
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Location)) {
                return false;
            }
            Location location = (Location) other;
            return Intrinsics.areEqual(this.time, location.time) && this.latitude == location.latitude && this.longitude == location.longitude && Intrinsics.areEqual(this.horizontalAccuracy, location.horizontalAccuracy) && Intrinsics.areEqual(this.verticalAccuracy, location.verticalAccuracy) && Intrinsics.areEqual(this.altitude, location.altitude);
        }

        public final Length getAltitude() {
            return this.altitude;
        }

        public final Length getHorizontalAccuracy() {
            return this.horizontalAccuracy;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        public final Instant getTime() {
            return this.time;
        }

        public final Length getVerticalAccuracy() {
            return this.verticalAccuracy;
        }

        public int hashCode() {
            int iHashCode = (Double.hashCode(this.longitude) + ((Double.hashCode(this.latitude) + (this.time.hashCode() * 31)) * 31)) * 31;
            Length length = this.horizontalAccuracy;
            int iHashCode2 = (iHashCode + (length != null ? length.hashCode() : 0)) * 31;
            Length length2 = this.verticalAccuracy;
            int iHashCode3 = (iHashCode2 + (length2 != null ? length2.hashCode() : 0)) * 31;
            Length length3 = this.altitude;
            return iHashCode3 + (length3 != null ? length3.hashCode() : 0);
        }

        public String toString() {
            return "Location(time=" + this.time + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", horizontalAccuracy=" + this.horizontalAccuracy + ", verticalAccuracy=" + this.verticalAccuracy + ", altitude=" + this.altitude + ')';
        }
    }

    public ExerciseRoute(List<Location> list) {
        list.getClass();
        this.route = list;
        List listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: androidx.health.connect.client.records.ExerciseRoute$special$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((ExerciseRoute.Location) t).getTime(), ((ExerciseRoute.Location) t2).getTime());
            }
        });
        int lastIndex = CollectionsKt.getLastIndex(listSortedWith);
        int i = 0;
        while (i < lastIndex) {
            Instant time = ((Location) listSortedWith.get(i)).getTime();
            i++;
            if (!time.isBefore(((Location) listSortedWith.get(i)).getTime())) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Failed requirement.");
                throw null;
            }
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ExerciseRoute) {
            return Intrinsics.areEqual(this.route, ((ExerciseRoute) other).route);
        }
        return false;
    }

    public final List<Location> getRoute() {
        return this.route;
    }

    public int hashCode() {
        return this.route.hashCode();
    }

    public String toString() {
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder("ExerciseRoute(route="), (List) this.route, ')');
    }
}
