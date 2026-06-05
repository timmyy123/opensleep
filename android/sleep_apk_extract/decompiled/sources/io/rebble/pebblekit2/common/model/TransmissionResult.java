package io.rebble.pebblekit2.common.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lio/rebble/pebblekit2/common/model/TransmissionResult;", "", "<init>", "()V", "Success", "FailedWatchNotConnected", "FailedWatchNacked", "FailedTimeout", "FailedDifferentAppOpen", "FailedNoPermissions", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Companion", "Lio/rebble/pebblekit2/common/model/TransmissionResult$FailedDifferentAppOpen;", "Lio/rebble/pebblekit2/common/model/TransmissionResult$FailedNoPermissions;", "Lio/rebble/pebblekit2/common/model/TransmissionResult$FailedTimeout;", "Lio/rebble/pebblekit2/common/model/TransmissionResult$FailedWatchNacked;", "Lio/rebble/pebblekit2/common/model/TransmissionResult$FailedWatchNotConnected;", "Lio/rebble/pebblekit2/common/model/TransmissionResult$Success;", "Lio/rebble/pebblekit2/common/model/TransmissionResult$Unknown;", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class TransmissionResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/rebble/pebblekit2/common/model/TransmissionResult$Companion;", "", "<init>", "()V", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/rebble/pebblekit2/common/model/TransmissionResult$FailedDifferentAppOpen;", "Lio/rebble/pebblekit2/common/model/TransmissionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class FailedDifferentAppOpen extends TransmissionResult {
        public static final FailedDifferentAppOpen INSTANCE = new FailedDifferentAppOpen();

        private FailedDifferentAppOpen() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof FailedDifferentAppOpen);
        }

        public int hashCode() {
            return 1660462014;
        }

        public String toString() {
            return "FailedDifferentAppOpen";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/rebble/pebblekit2/common/model/TransmissionResult$FailedNoPermissions;", "Lio/rebble/pebblekit2/common/model/TransmissionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class FailedNoPermissions extends TransmissionResult {
        public static final FailedNoPermissions INSTANCE = new FailedNoPermissions();

        private FailedNoPermissions() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof FailedNoPermissions);
        }

        public int hashCode() {
            return 727050583;
        }

        public String toString() {
            return "FailedNoPermissions";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/rebble/pebblekit2/common/model/TransmissionResult$FailedTimeout;", "Lio/rebble/pebblekit2/common/model/TransmissionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class FailedTimeout extends TransmissionResult {
        public static final FailedTimeout INSTANCE = new FailedTimeout();

        private FailedTimeout() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof FailedTimeout);
        }

        public int hashCode() {
            return -1709266507;
        }

        public String toString() {
            return "FailedTimeout";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/rebble/pebblekit2/common/model/TransmissionResult$FailedWatchNacked;", "Lio/rebble/pebblekit2/common/model/TransmissionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class FailedWatchNacked extends TransmissionResult {
        public static final FailedWatchNacked INSTANCE = new FailedWatchNacked();

        private FailedWatchNacked() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof FailedWatchNacked);
        }

        public int hashCode() {
            return 1466058557;
        }

        public String toString() {
            return "FailedWatchNacked";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/rebble/pebblekit2/common/model/TransmissionResult$FailedWatchNotConnected;", "Lio/rebble/pebblekit2/common/model/TransmissionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class FailedWatchNotConnected extends TransmissionResult {
        public static final FailedWatchNotConnected INSTANCE = new FailedWatchNotConnected();

        private FailedWatchNotConnected() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof FailedWatchNotConnected);
        }

        public int hashCode() {
            return 1327186745;
        }

        public String toString() {
            return "FailedWatchNotConnected";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/rebble/pebblekit2/common/model/TransmissionResult$Success;", "Lio/rebble/pebblekit2/common/model/TransmissionResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Success extends TransmissionResult {
        public static final Success INSTANCE = new Success();

        private Success() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Success);
        }

        public int hashCode() {
            return 644446228;
        }

        public String toString() {
            return "Success";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/rebble/pebblekit2/common/model/TransmissionResult$Unknown;", "Lio/rebble/pebblekit2/common/model/TransmissionResult;", "", "message", "<init>", "(Ljava/lang/String;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessage", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Unknown extends TransmissionResult {
        private final String message;

        public Unknown(String str) {
            super(null);
            this.message = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Unknown) && Intrinsics.areEqual(this.message, ((Unknown) other).message);
        }

        public int hashCode() {
            String str = this.message;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m("Unknown(message=", this.message, ")");
        }
    }

    public /* synthetic */ TransmissionResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TransmissionResult() {
    }
}
