package io.rebble.pebblekit2.common.model;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0005\u0006\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lio/rebble/pebblekit2/common/model/ReceiveResult;", "", "<init>", "()V", "Companion", "Ack", "Nack", "Lio/rebble/pebblekit2/common/model/ReceiveResult$Ack;", "Lio/rebble/pebblekit2/common/model/ReceiveResult$Nack;", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ReceiveResult {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/rebble/pebblekit2/common/model/ReceiveResult$Ack;", "Lio/rebble/pebblekit2/common/model/ReceiveResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Ack extends ReceiveResult {
        public static final Ack INSTANCE = new Ack();

        private Ack() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Ack);
        }

        public int hashCode() {
            return -739996003;
        }

        public String toString() {
            return "Ack";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/rebble/pebblekit2/common/model/ReceiveResult$Nack;", "Lio/rebble/pebblekit2/common/model/ReceiveResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "common-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Nack extends ReceiveResult {
        public static final Nack INSTANCE = new Nack();

        private Nack() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Nack);
        }

        public int hashCode() {
            return -1464654393;
        }

        public String toString() {
            return "Nack";
        }
    }

    public /* synthetic */ ReceiveResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ReceiveResult() {
    }
}
