package com.urbandroid.sleep.service.google.calendar.api;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.Utils;
import com.urbandroid.sleep.service.health.session.HealthSession;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"pretty", "", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class GoogleCalendarApiKt {
    public static final String pretty(HealthSession healthSession) {
        healthSession.getClass();
        return Fragment$$ExternalSyntheticOutline1.m(healthSession.getId(), " - ", Utils.getPrettyDate(healthSession.getFromInMillis()), " - ", Utils.getPrettyDate(healthSession.getToInMillis()));
    }
}
