package androidx.health.connect.client.records;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.Length;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b&\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\r"}, d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "", "<init>", "()V", "DistanceGoal", "DistanceAndDurationGoal", "StepsGoal", "DurationGoal", "RepetitionsGoal", "TotalCaloriesBurnedGoal", "ActiveCaloriesBurnedGoal", "UnknownGoal", "ManualCompletion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ExerciseCompletionGoal {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$ActiveCaloriesBurnedGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "activeCalories", "Landroidx/health/connect/client/units/Energy;", "<init>", "(Landroidx/health/connect/client/units/Energy;)V", "getActiveCalories", "()Landroidx/health/connect/client/units/Energy;", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ActiveCaloriesBurnedGoal extends ExerciseCompletionGoal {
        private final Energy activeCalories;

        public ActiveCaloriesBurnedGoal(Energy energy) {
            energy.getClass();
            this.activeCalories = energy;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof ActiveCaloriesBurnedGoal) {
                return Intrinsics.areEqual(this.activeCalories, ((ActiveCaloriesBurnedGoal) other).activeCalories);
            }
            return false;
        }

        public final Energy getActiveCalories() {
            return this.activeCalories;
        }

        public int hashCode() {
            return this.activeCalories.hashCode();
        }

        public String toString() {
            return "ActiveCaloriesBurnedGoal(activeCalories=" + this.activeCalories + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$DistanceAndDurationGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "Landroidx/health/connect/client/units/Length;", "distance", "j$/time/Duration", "duration", "<init>", "(Landroidx/health/connect/client/units/Length;Lj$/time/Duration;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "Landroidx/health/connect/client/units/Length;", "getDistance", "()Landroidx/health/connect/client/units/Length;", "Lj$/time/Duration;", "getDuration", "()Lj$/time/Duration;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DistanceAndDurationGoal extends ExerciseCompletionGoal {
        private final Length distance;
        private final Duration duration;

        public DistanceAndDurationGoal(Length length, Duration duration) {
            length.getClass();
            duration.getClass();
            this.distance = length;
            this.duration = duration;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DistanceAndDurationGoal)) {
                return false;
            }
            DistanceAndDurationGoal distanceAndDurationGoal = (DistanceAndDurationGoal) other;
            return Intrinsics.areEqual(this.distance, distanceAndDurationGoal.distance) && Intrinsics.areEqual(this.duration, distanceAndDurationGoal.duration);
        }

        public final Length getDistance() {
            return this.distance;
        }

        public final Duration getDuration() {
            return this.duration;
        }

        public int hashCode() {
            return this.duration.hashCode() + (this.distance.hashCode() * 31);
        }

        public String toString() {
            return "DistanceAndDurationGoal(distance=" + this.distance + ", duration=" + this.duration + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$DistanceGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "distance", "Landroidx/health/connect/client/units/Length;", "<init>", "(Landroidx/health/connect/client/units/Length;)V", "getDistance", "()Landroidx/health/connect/client/units/Length;", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DistanceGoal extends ExerciseCompletionGoal {
        private final Length distance;

        public DistanceGoal(Length length) {
            length.getClass();
            this.distance = length;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof DistanceGoal) {
                return Intrinsics.areEqual(this.distance, ((DistanceGoal) other).distance);
            }
            return false;
        }

        public final Length getDistance() {
            return this.distance;
        }

        public int hashCode() {
            return this.distance.hashCode();
        }

        public String toString() {
            return "DistanceGoal(distance=" + this.distance + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$DurationGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "j$/time/Duration", "duration", "<init>", "(Lj$/time/Duration;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Duration;", "getDuration", "()Lj$/time/Duration;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DurationGoal extends ExerciseCompletionGoal {
        private final Duration duration;

        public DurationGoal(Duration duration) {
            duration.getClass();
            this.duration = duration;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof DurationGoal) {
                return Intrinsics.areEqual(this.duration, ((DurationGoal) other).duration);
            }
            return false;
        }

        public final Duration getDuration() {
            return this.duration;
        }

        public int hashCode() {
            return this.duration.hashCode();
        }

        public String toString() {
            return "DurationGoal(duration=" + this.duration + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$ManualCompletion;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "<init>", "()V", InAppPurchaseConstants.METHOD_TO_STRING, "", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ManualCompletion extends ExerciseCompletionGoal {
        public static final ManualCompletion INSTANCE = new ManualCompletion();

        private ManualCompletion() {
        }

        public String toString() {
            return "ManualCompletion()";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$RepetitionsGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "repetitions", "", "<init>", "(I)V", "getRepetitions", "()I", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RepetitionsGoal extends ExerciseCompletionGoal {
        private final int repetitions;

        public RepetitionsGoal(int i) {
            this.repetitions = i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RepetitionsGoal) && this.repetitions == ((RepetitionsGoal) other).repetitions;
        }

        public final int getRepetitions() {
            return this.repetitions;
        }

        public int hashCode() {
            return Integer.hashCode(this.repetitions);
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("RepetitionsGoal(repetitions="), this.repetitions, ')');
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$StepsGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "steps", "", "<init>", "(I)V", "getSteps", "()I", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StepsGoal extends ExerciseCompletionGoal {
        private final int steps;

        public StepsGoal(int i) {
            this.steps = i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StepsGoal) && this.steps == ((StepsGoal) other).steps;
        }

        public final int getSteps() {
            return this.steps;
        }

        public int hashCode() {
            return this.steps;
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("StepsGoal(steps="), this.steps, ')');
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$TotalCaloriesBurnedGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "totalCalories", "Landroidx/health/connect/client/units/Energy;", "<init>", "(Landroidx/health/connect/client/units/Energy;)V", "getTotalCalories", "()Landroidx/health/connect/client/units/Energy;", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TotalCaloriesBurnedGoal extends ExerciseCompletionGoal {
        private final Energy totalCalories;

        public TotalCaloriesBurnedGoal(Energy energy) {
            energy.getClass();
            this.totalCalories = energy;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof TotalCaloriesBurnedGoal) {
                return Intrinsics.areEqual(this.totalCalories, ((TotalCaloriesBurnedGoal) other).totalCalories);
            }
            return false;
        }

        public final Energy getTotalCalories() {
            return this.totalCalories;
        }

        public int hashCode() {
            return this.totalCalories.hashCode();
        }

        public String toString() {
            return "TotalCaloriesBurnedGoal(totalCalories=" + this.totalCalories + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/records/ExerciseCompletionGoal$UnknownGoal;", "Landroidx/health/connect/client/records/ExerciseCompletionGoal;", "<init>", "()V", InAppPurchaseConstants.METHOD_TO_STRING, "", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class UnknownGoal extends ExerciseCompletionGoal {
        public static final UnknownGoal INSTANCE = new UnknownGoal();

        private UnknownGoal() {
        }

        public String toString() {
            return "UnknownGoal()";
        }
    }
}
