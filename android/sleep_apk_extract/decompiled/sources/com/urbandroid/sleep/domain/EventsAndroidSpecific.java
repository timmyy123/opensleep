package com.urbandroid.sleep.domain;

import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EventsAndroidSpecific {
    public static Events readFromParcel(Parcel parcel) {
        Events events = new Events();
        int i = parcel.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            events.addEventDirect(Events.deserializeEvent(parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readFloat()));
        }
        return events;
    }

    public static void writeToParcel(Events events, Parcel parcel) {
        List<Event> copiedEvents = events.getCopiedEvents();
        parcel.writeInt(copiedEvents.size());
        for (Event event : copiedEvents) {
            parcel.writeLong(event.getTimestamp());
            parcel.writeInt((event.getLabel() == null ? EventLabel.UNKNOWN : event.getLabel()).ordinal());
            parcel.writeString(event.getLabelString() != null ? event.getLabelString() : "");
            parcel.writeFloat(event.getValue());
        }
    }
}
