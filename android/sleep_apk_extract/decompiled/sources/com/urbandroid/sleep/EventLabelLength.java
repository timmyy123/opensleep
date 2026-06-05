package com.urbandroid.sleep;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.urbandroid.sleep.domain.EventLabel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/EventLabelLength;", "", "Lcom/urbandroid/sleep/domain/EventLabel;", "label", "", "length", "<init>", "(Lcom/urbandroid/sleep/domain/EventLabel;J)V", "copy", "(Lcom/urbandroid/sleep/domain/EventLabel;J)Lcom/urbandroid/sleep/EventLabelLength;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/urbandroid/sleep/domain/EventLabel;", "getLabel", "()Lcom/urbandroid/sleep/domain/EventLabel;", "J", "getLength", "()J", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
final /* data */ class EventLabelLength {
    private final EventLabel label;
    private final long length;

    public EventLabelLength(EventLabel eventLabel, long j) {
        eventLabel.getClass();
        this.label = eventLabel;
        this.length = j;
    }

    public static /* synthetic */ EventLabelLength copy$default(EventLabelLength eventLabelLength, EventLabel eventLabel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            eventLabel = eventLabelLength.label;
        }
        if ((i & 2) != 0) {
            j = eventLabelLength.length;
        }
        return eventLabelLength.copy(eventLabel, j);
    }

    public final EventLabelLength copy(EventLabel label, long length) {
        label.getClass();
        return new EventLabelLength(label, length);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventLabelLength)) {
            return false;
        }
        EventLabelLength eventLabelLength = (EventLabelLength) other;
        return this.label == eventLabelLength.label && this.length == eventLabelLength.length;
    }

    public final EventLabel getLabel() {
        return this.label;
    }

    public final long getLength() {
        return this.length;
    }

    public int hashCode() {
        return Long.hashCode(this.length) + (this.label.hashCode() * 31);
    }

    public String toString() {
        return "EventLabelLength(label=" + this.label + ", length=" + this.length + ")";
    }
}
