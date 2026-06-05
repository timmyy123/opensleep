package com.urbandroid.sleep.service.google.calendar;

import com.urbandroid.sleep.service.google.calendar.JavaProviderApi;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class JavaProviderApi$getEvents$1$$ExternalSyntheticLambda0 implements Function2 {
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(JavaProviderApi.AnonymousClass1.invokeSuspend$lambda$0(null, (GoogleCalendar) obj, (GoogleCalendar.Event) obj2));
    }
}
