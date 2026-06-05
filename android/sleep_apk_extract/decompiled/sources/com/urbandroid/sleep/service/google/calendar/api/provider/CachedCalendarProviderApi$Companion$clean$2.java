package com.urbandroid.sleep.service.google.calendar.api.provider;

import com.urbandroid.sleep.JsonSharedPreferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/JsonSharedPreferences;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi$Companion$clean$2", f = "CachedCalendarProviderApi.kt", l = {76}, m = "invokeSuspend", v = 2)
public final class CachedCalendarProviderApi$Companion$clean$2 extends SuspendLambda implements Function2<JsonSharedPreferences, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi$Companion$clean$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi$Companion$clean$2$1", f = "CachedCalendarProviderApi.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JsonSharedPreferences $$this$withJsonPrefs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(JsonSharedPreferences jsonSharedPreferences, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$withJsonPrefs = jsonSharedPreferences;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$$this$withJsonPrefs, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            this.$$this$withJsonPrefs.delete("google_calendar_sleep_calendars_2");
            this.$$this$withJsonPrefs.delete("google_calendar_primary_calendar");
            this.$$this$withJsonPrefs.delete("google_calendar_holiday_calendars");
            return Unit.INSTANCE;
        }
    }

    public CachedCalendarProviderApi$Companion$clean$2(Continuation<? super CachedCalendarProviderApi$Companion$clean$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CachedCalendarProviderApi$Companion$clean$2 cachedCalendarProviderApi$Companion$clean$2 = new CachedCalendarProviderApi$Companion$clean$2(continuation);
        cachedCalendarProviderApi$Companion$clean$2.L$0 = obj;
        return cachedCalendarProviderApi$Companion$clean$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(JsonSharedPreferences jsonSharedPreferences, Continuation<? super Unit> continuation) {
        return ((CachedCalendarProviderApi$Companion$clean$2) create(jsonSharedPreferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        JsonSharedPreferences jsonSharedPreferences = (JsonSharedPreferences) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(jsonSharedPreferences, null);
            this.L$0 = SpillingKt.nullOutSpilledVariable(jsonSharedPreferences);
            this.label = 1;
            if (BuildersKt.withContext(io2, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
