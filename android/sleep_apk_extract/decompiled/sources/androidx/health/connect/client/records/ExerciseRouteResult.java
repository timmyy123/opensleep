package androidx.health.connect.client.records;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Landroidx/health/connect/client/records/ExerciseRouteResult;", "", "<init>", "()V", "Data", "ConsentRequired", "NoData", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ExerciseRouteResult {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/health/connect/client/records/ExerciseRouteResult$ConsentRequired;", "Landroidx/health/connect/client/records/ExerciseRouteResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ConsentRequired extends ExerciseRouteResult {
        public boolean equals(Object other) {
            return other instanceof ConsentRequired;
        }

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "ConsentRequired";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/health/connect/client/records/ExerciseRouteResult$Data;", "Landroidx/health/connect/client/records/ExerciseRouteResult;", "exerciseRoute", "Landroidx/health/connect/client/records/ExerciseRoute;", "<init>", "(Landroidx/health/connect/client/records/ExerciseRoute;)V", "getExerciseRoute", "()Landroidx/health/connect/client/records/ExerciseRoute;", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Data extends ExerciseRouteResult {
        private final ExerciseRoute exerciseRoute;

        public Data(ExerciseRoute exerciseRoute) {
            exerciseRoute.getClass();
            this.exerciseRoute = exerciseRoute;
        }

        public boolean equals(Object other) {
            if (other instanceof Data) {
                return Intrinsics.areEqual(this.exerciseRoute, ((Data) other).exerciseRoute);
            }
            return false;
        }

        public final ExerciseRoute getExerciseRoute() {
            return this.exerciseRoute;
        }

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "Data(exerciseRoute=" + this.exerciseRoute + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/health/connect/client/records/ExerciseRouteResult$NoData;", "Landroidx/health/connect/client/records/ExerciseRouteResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NoData extends ExerciseRouteResult {
        public boolean equals(Object other) {
            return other instanceof NoData;
        }

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "NoData";
        }
    }
}
