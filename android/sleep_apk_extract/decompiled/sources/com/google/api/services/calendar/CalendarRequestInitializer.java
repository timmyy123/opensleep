package com.google.api.services.calendar;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CalendarRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    public CalendarRequestInitializer(String str) {
        super(str);
    }

    public void initializeCalendarRequest(CalendarRequest<?> calendarRequest) {
    }

    @Override // com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer
    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        initializeCalendarRequest((CalendarRequest) abstractGoogleJsonClientRequest);
    }
}
