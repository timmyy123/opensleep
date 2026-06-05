package com.urbandroid.sleep.service.google.calendar.api.provider;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.api.services.calendar.model.Calendar;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/api/services/calendar/model/Calendar;", "", "pretty", "(Lcom/google/api/services/calendar/model/Calendar;)Ljava/lang/String;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class CalendarProviderApiKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String pretty(Calendar calendar) {
        String id = calendar.getId();
        String summary = calendar.getSummary();
        String description = calendar.getDescription();
        String timeZone = calendar.getTimeZone();
        String kind = calendar.getKind();
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("GCalendar[id=", id, ", summary=", summary, ", desc=");
        FileInsert$$ExternalSyntheticOutline0.m(sbM6m, description, ", tz=", timeZone, " kind=");
        sbM6m.append(kind);
        return sbM6m.toString();
    }
}
