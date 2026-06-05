package com.urbandroid.sleep.service.google.calendar.api;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi;
import com.urbandroid.sleep.service.health.session.HealthSession;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.GoogleCalendarApi$insert$id$1", f = "GoogleCalendarApi.kt", l = {133}, m = "invokeSuspend", v = 2)
public final class GoogleCalendarApi$insert$id$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Ref$ObjectRef<String> $comment;
    final /* synthetic */ Ref$ObjectRef<String> $cycle;
    final /* synthetic */ Ref$ObjectRef<String> $deepSleep;
    final /* synthetic */ Ref$ObjectRef<String> $duration;
    final /* synthetic */ Ref$ObjectRef<String> $hypnogram;
    final /* synthetic */ Ref$ObjectRef<Pair<String, String>> $location;
    final /* synthetic */ Ref$ObjectRef<String> $noise;
    final /* synthetic */ Ref$ObjectRef<String> $rating;
    final /* synthetic */ HealthSession $session;
    final /* synthetic */ Ref$ObjectRef<String> $snoring;
    final /* synthetic */ Ref$ObjectRef<String> $timeZoneId;
    int label;
    final /* synthetic */ GoogleCalendarApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleCalendarApi$insert$id$1(GoogleCalendarApi googleCalendarApi, HealthSession healthSession, Ref$ObjectRef<Pair<String, String>> ref$ObjectRef, Ref$ObjectRef<String> ref$ObjectRef2, Ref$ObjectRef<String> ref$ObjectRef3, Ref$ObjectRef<String> ref$ObjectRef4, Ref$ObjectRef<String> ref$ObjectRef5, Ref$ObjectRef<String> ref$ObjectRef6, Ref$ObjectRef<String> ref$ObjectRef7, Ref$ObjectRef<String> ref$ObjectRef8, Ref$ObjectRef<String> ref$ObjectRef9, Ref$ObjectRef<String> ref$ObjectRef10, Continuation<? super GoogleCalendarApi$insert$id$1> continuation) {
        super(2, continuation);
        this.this$0 = googleCalendarApi;
        this.$session = healthSession;
        this.$location = ref$ObjectRef;
        this.$rating = ref$ObjectRef2;
        this.$duration = ref$ObjectRef3;
        this.$deepSleep = ref$ObjectRef4;
        this.$cycle = ref$ObjectRef5;
        this.$noise = ref$ObjectRef6;
        this.$snoring = ref$ObjectRef7;
        this.$comment = ref$ObjectRef8;
        this.$hypnogram = ref$ObjectRef9;
        this.$timeZoneId = ref$ObjectRef10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleCalendarApi$insert$id$1(this.this$0, this.$session, this.$location, this.$rating, this.$duration, this.$deepSleep, this.$cycle, this.$noise, this.$snoring, this.$comment, this.$hypnogram, this.$timeZoneId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((GoogleCalendarApi$insert$id$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String second;
        String strInsert$format$3$default;
        String first;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        CachedCalendarProviderApi cachedCalendarProviderApi = this.this$0.calendarProvider;
        String id = this.this$0.getSleepCalendar().getId();
        long fromInMillis = this.$session.getFromInMillis();
        long toInMillis = this.$session.getToInMillis();
        String string = this.this$0.context.getString(R.string.sleep);
        string.getClass();
        Pair<String, String> pair = this.$location.element;
        if (pair == null || (second = pair.getSecond()) == null) {
            second = "";
        }
        String str = this.$rating.element;
        String strConcat = str != null ? str.concat("\n") : "";
        Pair<String, String> pair2 = this.$location.element;
        if (pair2 == null || (first = pair2.getFirst()) == null || (strInsert$format$3$default = GoogleCalendarApi.insert$format$3$default(first, this.this$0, R.string.location, null, 4, null)) == null) {
            strInsert$format$3$default = "";
        }
        String strInsert$format$3$default2 = GoogleCalendarApi.insert$format$3$default(this.$duration.element, this.this$0, R.string.stats_caption_sleep, null, 4, null);
        String strInsert$format$3 = GoogleCalendarApi.insert$format$3(this.$deepSleep.element, this.this$0, R.string.label_deep_sleep, "%");
        String strInsert$format$3$default3 = GoogleCalendarApi.insert$format$3$default(this.$cycle.element, this.this$0, R.string.stats_caption_cycle, null, 4, null);
        String strInsert$format$32 = GoogleCalendarApi.insert$format$3(this.$noise.element, this.this$0, R.string.noise, "%");
        String strInsert$format$3$default4 = GoogleCalendarApi.insert$format$3$default(this.$snoring.element, this.this$0, R.string.stats_caption_snore, null, 4, null);
        String strInsert$format$3$default5 = GoogleCalendarApi.insert$format$3$default(this.$comment.element, this.this$0, R.string.rating_comment_label, null, 4, null);
        String str2 = this.$hypnogram.element;
        String strM = Fragment$$ExternalSyntheticOutline1.m(Fragment$$ExternalSyntheticOutline1.m66m(strConcat, strInsert$format$3$default, strInsert$format$3$default2, strInsert$format$3, strInsert$format$3$default3), strInsert$format$32, strInsert$format$3$default4, strInsert$format$3$default5, str2 != null ? "\n".concat(str2) : "");
        String str3 = this.$timeZoneId.element;
        this.label = 1;
        Object objInsertEvent = cachedCalendarProviderApi.insertEvent(id, fromInMillis, toInMillis, string, second, strM, str3, this);
        return objInsertEvent == coroutine_suspended ? coroutine_suspended : objInsertEvent;
    }
}
