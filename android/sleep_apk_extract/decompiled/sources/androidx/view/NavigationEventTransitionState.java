package androidx.view;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00042\u00020\u0001:\u0003\u0005\u0006\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Landroidx/navigationevent/NavigationEventTransitionState;", "", "<init>", "()V", "Companion", "Idle", "InProgress", "Landroidx/navigationevent/NavigationEventTransitionState$Idle;", "Landroidx/navigationevent/NavigationEventTransitionState$InProgress;", "navigationevent"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class NavigationEventTransitionState {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Landroidx/navigationevent/NavigationEventTransitionState$Idle;", "Landroidx/navigationevent/NavigationEventTransitionState;", "<init>", "()V", InAppPurchaseConstants.METHOD_TO_STRING, "", "navigationevent"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Idle extends NavigationEventTransitionState {
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }

        public String toString() {
            return "Idle()";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0017"}, d2 = {"Landroidx/navigationevent/NavigationEventTransitionState$InProgress;", "Landroidx/navigationevent/NavigationEventTransitionState;", "Landroidx/navigationevent/NavigationEvent;", "latestEvent", "", "direction", "<init>", "(Landroidx/navigationevent/NavigationEvent;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Landroidx/navigationevent/NavigationEvent;", "getLatestEvent", "()Landroidx/navigationevent/NavigationEvent;", "I", "getDirection", "navigationevent"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InProgress extends NavigationEventTransitionState {
        private final int direction;
        private final NavigationEvent latestEvent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InProgress(NavigationEvent navigationEvent, int i) {
            super(null);
            navigationEvent.getClass();
            this.latestEvent = navigationEvent;
            this.direction = i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || InProgress.class != other.getClass()) {
                return false;
            }
            InProgress inProgress = (InProgress) other;
            return this.direction == inProgress.direction && Intrinsics.areEqual(this.latestEvent, inProgress.latestEvent);
        }

        public int hashCode() {
            return this.latestEvent.hashCode() + (this.direction * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("InProgress(latestEvent=");
            sb.append(this.latestEvent);
            sb.append(", direction=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.direction, ')');
        }
    }

    public /* synthetic */ NavigationEventTransitionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private NavigationEventTransitionState() {
    }
}
