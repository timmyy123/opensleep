package com.urbandroid.sleep.service.google.calendar.api;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleeprecordExtKt;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.LocationService;
import com.urbandroid.sleep.service.google.calendar.CalendarKt;
import com.urbandroid.sleep.service.google.calendar.FromToZeroMillisIdResolver;
import com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarNotifierKt;
import com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi;
import com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi;
import com.urbandroid.sleep.service.google.calendar.api.provider.ProviderApi;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendarKt;
import com.urbandroid.sleep.service.google.calendar.session.GoogleCalendarSession;
import com.urbandroid.sleep.service.health.ResultStatus;
import com.urbandroid.sleep.service.health.api.AbstractHealthApi;
import com.urbandroid.sleep.service.health.api.HealthApi;
import com.urbandroid.sleep.service.health.session.HealthIntervalKt;
import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.SleepRecordHealthSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_concurrentKt;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ9\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u0015J%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0017¢\u0006\u0004\b\u0012\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0017¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0017¢\u0006\u0004\b\"\u0010#J%\u0010\"\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010%\u001a\u00020$H\u0017¢\u0006\u0004\b\"\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010*R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-R\u0016\u0010\u0019\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\"\u00104\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/api/GoogleCalendarApi;", "Lcom/urbandroid/sleep/service/health/api/AbstractHealthApi;", "Lcom/urbandroid/sleep/service/google/calendar/session/GoogleCalendarSession;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "accountName", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "calendar", "Ljava/util/Date;", "from", "to", "", "singleEvent", "", "find", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;Ljava/util/Date;Ljava/util/Date;Z)Ljava/util/List;", "connect", "()Z", "", "disconnect", "()V", "isConnected", "", "(Ljava/util/Date;Ljava/util/Date;)Ljava/util/Collection;", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "session", "Lcom/urbandroid/sleep/service/health/ResultStatus;", "insert", "(Lcom/urbandroid/sleep/service/health/session/HealthSession;)Lcom/urbandroid/sleep/service/health/ResultStatus;", "sessions", "delete", "(Ljava/util/Collection;)Lcom/urbandroid/sleep/service/health/ResultStatus;", "Lcom/urbandroid/sleep/service/health/api/HealthApi$Listener;", "listener", "(Ljava/util/Collection;Lcom/urbandroid/sleep/service/health/api/HealthApi$Listener;)Lcom/urbandroid/sleep/service/health/ResultStatus;", "Lcom/urbandroid/sleep/service/google/calendar/FromToZeroMillisIdResolver;", "getIdResolver", "()Lcom/urbandroid/sleep/service/google/calendar/FromToZeroMillisIdResolver;", "Landroid/content/Context;", "Ljava/lang/String;", "getAccountName", "()Ljava/lang/String;", "tag", "getTag", "Z", "Lcom/urbandroid/sleep/service/google/calendar/api/provider/CachedCalendarProviderApi;", "calendarProvider", "Lcom/urbandroid/sleep/service/google/calendar/api/provider/CachedCalendarProviderApi;", "sleepCalendar", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "getSleepCalendar", "()Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;", "setSleepCalendar", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleCalendarApi extends AbstractHealthApi<GoogleCalendarSession> implements FeatureLogger {
    private final String accountName;
    private final CachedCalendarProviderApi calendarProvider;
    private final Context context;
    private boolean isConnected;
    public GoogleCalendar sleepCalendar;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.GoogleCalendarApi$delete$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/service/health/ResultStatus;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.GoogleCalendarApi$delete$2", f = "GoogleCalendarApi.kt", l = {163}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResultStatus>, Object> {
        final /* synthetic */ Collection<GoogleCalendarSession> $sessions;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        final /* synthetic */ GoogleCalendarApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Collection<GoogleCalendarSession> collection, GoogleCalendarApi googleCalendarApi, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$sessions = collection;
            this.this$0 = googleCalendarApi;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$sessions, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResultStatus> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00d5  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00c5 -> B:21:0x00c6). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            GoogleCalendarApi googleCalendarApi;
            Iterable iterable;
            Iterable iterable2;
            Iterator it;
            Collection collection;
            int i;
            int i2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Collection<GoogleCalendarSession> collection2 = this.$sessions;
                GoogleCalendarApi googleCalendarApi2 = this.this$0;
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : collection2) {
                    if (GoogleCalendarKt.isSleepEvent(((GoogleCalendarSession) obj2).getEvent(), googleCalendarApi2.context)) {
                        arrayList.add(obj2);
                    }
                }
                GoogleCalendarApi googleCalendarApi3 = this.this$0;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                googleCalendarApi = googleCalendarApi3;
                iterable = arrayList;
                iterable2 = iterable;
                it = arrayList.iterator();
                collection = arrayList2;
                i = 0;
                i2 = 0;
                if (it.hasNext()) {
                }
            } else {
                if (i3 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i = this.I$1;
                i2 = this.I$0;
                collection = (Collection) this.L$7;
                it = (Iterator) this.L$4;
                Collection collection3 = (Collection) this.L$3;
                iterable = (Iterable) this.L$2;
                googleCalendarApi = (GoogleCalendarApi) this.L$1;
                iterable2 = (Iterable) this.L$0;
                ResultKt.throwOnFailure(obj);
                collection.add(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
                collection = collection3;
                if (it.hasNext()) {
                    Object next = it.next();
                    GoogleCalendarSession googleCalendarSession = (GoogleCalendarSession) next;
                    CachedCalendarProviderApi cachedCalendarProviderApi = googleCalendarApi.calendarProvider;
                    GoogleCalendar.Event event = googleCalendarSession.getEvent();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(iterable2);
                    this.L$1 = googleCalendarApi;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$3 = collection;
                    this.L$4 = it;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(next);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(googleCalendarSession);
                    this.L$7 = collection;
                    this.I$0 = i2;
                    this.I$1 = i;
                    this.I$2 = 0;
                    this.label = 1;
                    obj = cachedCalendarProviderApi.deleteEvent(event, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    collection3 = collection;
                    collection.add(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
                    collection = collection3;
                    if (it.hasNext()) {
                        List list = (List) collection;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator it2 = list.iterator();
                            while (it2.hasNext()) {
                                if (!((Boolean) it2.next()).booleanValue()) {
                                    return ResultStatus.FAILURE;
                                }
                            }
                        }
                        return ResultStatus.SUCCESS;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.GoogleCalendarApi$delete$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/service/health/ResultStatus;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.GoogleCalendarApi$delete$3", f = "GoogleCalendarApi.kt", l = {173}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResultStatus>, Object> {
        final /* synthetic */ HealthApi.Listener $listener;
        final /* synthetic */ Collection<GoogleCalendarSession> $sessions;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        final /* synthetic */ GoogleCalendarApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Collection<GoogleCalendarSession> collection, GoogleCalendarApi googleCalendarApi, HealthApi.Listener listener, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$sessions = collection;
            this.this$0 = googleCalendarApi;
            this.$listener = listener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$sessions, this.this$0, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResultStatus> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0101  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00e9 -> B:24:0x00ea). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            GoogleCalendarApi googleCalendarApi;
            HealthApi.Listener listener;
            Iterable iterable;
            Iterable iterable2;
            Iterator it;
            int i;
            int i2;
            Collection collection;
            int i3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                Collection<GoogleCalendarSession> collection2 = this.$sessions;
                GoogleCalendarApi googleCalendarApi2 = this.this$0;
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : collection2) {
                    if (GoogleCalendarKt.isSleepEvent(((GoogleCalendarSession) obj2).getEvent(), googleCalendarApi2.context)) {
                        arrayList.add(obj2);
                    }
                }
                GoogleCalendarApi googleCalendarApi3 = this.this$0;
                HealthApi.Listener listener2 = this.$listener;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                googleCalendarApi = googleCalendarApi3;
                listener = listener2;
                iterable = arrayList;
                iterable2 = iterable;
                it = arrayList.iterator();
                i = 0;
                i2 = 0;
                collection = arrayList2;
                i3 = 0;
                if (it.hasNext()) {
                }
            } else {
                if (i4 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i = this.I$3;
                int i5 = this.I$2;
                i2 = this.I$1;
                i3 = this.I$0;
                collection = (Collection) this.L$8;
                it = (Iterator) this.L$5;
                Collection collection3 = (Collection) this.L$4;
                iterable = (Iterable) this.L$3;
                listener = (HealthApi.Listener) this.L$2;
                googleCalendarApi = (GoogleCalendarApi) this.L$1;
                iterable2 = (Iterable) this.L$0;
                ResultKt.throwOnFailure(obj);
                Object objDeleteEvent = obj;
                boolean z = true;
                Collection collection4 = collection3;
                int i6 = i5;
                Boolean bool = (Boolean) objDeleteEvent;
                bool.getClass();
                listener.deleted(i);
                collection.add(Boxing.boxBoolean(bool.booleanValue()));
                collection = collection4;
                i = i6;
                if (it.hasNext()) {
                    Object next = it.next();
                    i6 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    GoogleCalendarSession googleCalendarSession = (GoogleCalendarSession) next;
                    CachedCalendarProviderApi cachedCalendarProviderApi = googleCalendarApi.calendarProvider;
                    GoogleCalendar.Event event = googleCalendarSession.getEvent();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(iterable2);
                    this.L$1 = googleCalendarApi;
                    this.L$2 = listener;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$4 = collection;
                    this.L$5 = it;
                    this.L$6 = SpillingKt.nullOutSpilledVariable(next);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(googleCalendarSession);
                    this.L$8 = collection;
                    this.I$0 = i3;
                    this.I$1 = i2;
                    this.I$2 = i6;
                    this.I$3 = i;
                    this.I$4 = 0;
                    z = true;
                    this.label = 1;
                    objDeleteEvent = cachedCalendarProviderApi.deleteEvent(event, this);
                    if (objDeleteEvent == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    collection4 = collection;
                    Boolean bool2 = (Boolean) objDeleteEvent;
                    bool2.getClass();
                    listener.deleted(i);
                    collection.add(Boxing.boxBoolean(bool2.booleanValue()));
                    collection = collection4;
                    i = i6;
                    if (it.hasNext()) {
                        List list = (List) collection;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator it2 = list.iterator();
                            while (it2.hasNext()) {
                                if (!((Boolean) it2.next()).booleanValue()) {
                                    return ResultStatus.FAILURE;
                                }
                            }
                        }
                        return ResultStatus.SUCCESS;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.api.GoogleCalendarApi$find$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/service/google/calendar/session/GoogleCalendarSession;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.api.GoogleCalendarApi$find$1", f = "GoogleCalendarApi.kt", l = {71}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends GoogleCalendarSession>>, Object> {
        final /* synthetic */ GoogleCalendar $calendar;
        final /* synthetic */ Date $from;
        final /* synthetic */ boolean $singleEvent;
        final /* synthetic */ Date $to;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GoogleCalendar googleCalendar, Date date, Date date2, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$calendar = googleCalendar;
            this.$from = date;
            this.$to = date2;
            this.$singleEvent = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoogleCalendarApi.this.new AnonymousClass1(this.$calendar, this.$from, this.$to, this.$singleEvent, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<GoogleCalendarSession>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object events$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CachedCalendarProviderApi cachedCalendarProviderApi = GoogleCalendarApi.this.calendarProvider;
                    GoogleCalendar googleCalendar = this.$calendar;
                    long time = this.$from.getTime();
                    long time2 = this.$to.getTime();
                    String timezone_default = CalendarKt.getTIMEZONE_DEFAULT();
                    boolean z = this.$singleEvent;
                    this.label = 1;
                    events$default = ProviderApi.getEvents$default(cachedCalendarProviderApi, googleCalendar, time, time2, timezone_default, z, null, this, 32, null);
                    if (events$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    events$default = obj;
                }
                Iterable iterable = (Iterable) events$default;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(new GoogleCalendarSession((GoogleCalendar.Event) it.next()));
                }
                return arrayList;
            } catch (UserRecoverableAuthException e) {
                GoogleCalendarNotifierKt.calendarPermissionMissingNotification(GoogleCalendarApi.this.context, e);
                return null;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends GoogleCalendarSession>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<GoogleCalendarSession>>) continuation);
        }
    }

    public GoogleCalendarApi(Context context, String str) {
        context.getClass();
        str.getClass();
        this.context = context;
        this.accountName = str;
        this.tag = "calendar:api";
        this.calendarProvider = new CachedCalendarProviderApi(context, new CalendarProviderApi(context, str));
    }

    private static final Pair<String, String> insert$format(Location location) {
        if (location == null) {
            return null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return TuplesKt.to("Loc ", String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(location.getLat())}, 1)) + ", " + String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(location.getLon())}, 1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String insert$format$3(Object obj, GoogleCalendarApi googleCalendarApi, int i, String str) {
        if (obj == null) {
            return "";
        }
        return googleCalendarApi.context.getString(i) + ":\t<b>" + obj + str + "</b>\n";
    }

    public static /* synthetic */ String insert$format$3$default(Object obj, GoogleCalendarApi googleCalendarApi, int i, String str, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            str = "";
        }
        return insert$format$3(obj, googleCalendarApi, i, str);
    }

    private static final String insert$prettyGeo(SleepRecord sleepRecord) {
        Pair<String, String> pairInsert$format;
        String second;
        return (sleepRecord.getGeo() == null || (pairInsert$format = insert$format(LocationService.computeLocation(sleepRecord.getGeo()))) == null || (second = pairInsert$format.getSecond()) == null) ? "" : second;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public boolean connect() {
        this.isConnected = true;
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus delete(Collection<GoogleCalendarSession> sessions, HealthApi.Listener listener) {
        sessions.getClass();
        listener.getClass();
        Object objRunBlockingK$default = BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new AnonymousClass3(sessions, this, listener, null), 1, null);
        objRunBlockingK$default.getClass();
        return (ResultStatus) objRunBlockingK$default;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public void disconnect() {
        this.isConnected = false;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public Collection<GoogleCalendarSession> find(Date from, Date to) {
        from.getClass();
        to.getClass();
        if (this.sleepCalendar == null) {
            throw new SleepCalendarNotFoundException();
        }
        List<GoogleCalendarSession> listFind = find(getSleepCalendar(), from, to, true);
        return listFind != null ? listFind : CollectionsKt.emptyList();
    }

    public final String getAccountName() {
        return this.accountName;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public FromToZeroMillisIdResolver getIdResolver() {
        return new FromToZeroMillisIdResolver();
    }

    public final GoogleCalendar getSleepCalendar() {
        GoogleCalendar googleCalendar = this.sleepCalendar;
        if (googleCalendar != null) {
            return googleCalendar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sleepCalendar");
        return null;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d2  */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v31, types: [T, java.lang.String] */
    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ResultStatus insert(HealthSession session) {
        CoroutineContext coroutineContext;
        int i;
        float f;
        T string;
        T string2;
        session.getClass();
        if (this.sleepCalendar == null) {
            throw new SleepCalendarNotFoundException();
        }
        if (HealthIntervalKt.getDuration(session) < Utils.getMinutesInMillis(10)) {
            String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(GoogleCalendarApiKt.pretty(session), " too short (less than 10 minutes)");
            Logger.logWarning(Logger.defaultTag, getTag() + ": " + strM$1, null);
            ResultStatus resultStatus = ResultStatus.FAILURE;
            resultStatus.getClass();
            return resultStatus;
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = session.getTimeZoneId();
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef5 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef6 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef7 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef8 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef9 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef10 = new Ref$ObjectRef();
        if (session instanceof SleepRecordHealthSession) {
            SleepRecord sleepRecord = ((SleepRecordHealthSession) session).getSleepRecord();
            ?? timezone = sleepRecord.getTimezone();
            timezone.getClass();
            ref$ObjectRef2.element = timezone;
            ref$ObjectRef.element = sleepRecord.hasTag(Tag.HOME) ? TuplesKt.to("Home", insert$prettyGeo(sleepRecord)) : sleepRecord.hasTag(Tag.GEO0) ? TuplesKt.to("Geo0", insert$prettyGeo(sleepRecord)) : sleepRecord.hasTag(Tag.GEO1) ? TuplesKt.to("Geo1", insert$prettyGeo(sleepRecord)) : sleepRecord.hasTag(Tag.GEO2) ? TuplesKt.to("Geo2", insert$prettyGeo(sleepRecord)) : sleepRecord.hasTag(Tag.GEO3) ? TuplesKt.to("Geo3", insert$prettyGeo(sleepRecord)) : insert$format(LocationService.computeLocation(sleepRecord.getGeo()));
            int sleepLengthMinutes = sleepRecord.getSleepLengthMinutes();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            ref$ObjectRef4.element = (sleepLengthMinutes / 60) + ":" + String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(sleepLengthMinutes % 60)}, 1));
            if (sleepRecord.getQuality() > 0.0f) {
                int quality = (int) (sleepRecord.getQuality() * 100.0f);
                f = 0.0f;
                StringBuilder sb = new StringBuilder();
                sb.append(quality);
                string = sb.toString();
            } else {
                f = 0.0f;
                string = 0;
            }
            ref$ObjectRef3.element = string;
            if (sleepRecord.getNoiseLevel() > f) {
                int noiseLevel = (int) (sleepRecord.getNoiseLevel() * 100.0f);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(noiseLevel);
                string2 = sb2.toString();
            } else {
                string2 = 0;
            }
            ref$ObjectRef5.element = string2;
            if (sleepRecord.getSnore() > 0) {
                ref$ObjectRef6.element = ((sleepRecord.getSnore() / 60) / 60) + ":" + String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf((sleepRecord.getSnore() / 60) % 60)}, 1));
            }
            ref$ObjectRef7.element = sleepRecord.getCycles() > 0 ? String.valueOf(sleepRecord.getCycles()) : 0;
            String comment = sleepRecord.getComment();
            if (comment != null) {
                boolean zIsBlank = StringsKt.isBlank(comment);
                T t = comment;
                if (zIsBlank) {
                    t = 0;
                }
                ref$ObjectRef8.element = t;
                ref$ObjectRef9.element = sleepRecord.getRating() > f ? SleeprecordExtKt.toAsciiRating(sleepRecord) : 0;
                i = 1;
                coroutineContext = null;
                ref$ObjectRef10.element = SleeprecordExtKt.toAsciiHypnogram$default(sleepRecord, 0, 24, 1, null);
            }
        } else {
            coroutineContext = null;
            i = 1;
        }
        if (((String) BuildersKt__Builders_concurrentKt.runBlockingK$default(coroutineContext, new GoogleCalendarApi$insert$id$1(this, session, ref$ObjectRef, ref$ObjectRef9, ref$ObjectRef4, ref$ObjectRef3, ref$ObjectRef7, ref$ObjectRef5, ref$ObjectRef6, ref$ObjectRef8, ref$ObjectRef10, ref$ObjectRef2, null), i, coroutineContext)) != null) {
            ResultStatus resultStatus2 = ResultStatus.SUCCESS;
            resultStatus2.getClass();
            return resultStatus2;
        }
        ResultStatus resultStatus3 = ResultStatus.FAILURE;
        resultStatus3.getClass();
        return resultStatus3;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    /* JADX INFO: renamed from: isConnected, reason: from getter */
    public boolean getConnected() {
        return this.isConnected;
    }

    public final void setSleepCalendar(GoogleCalendar googleCalendar) {
        googleCalendar.getClass();
        this.sleepCalendar = googleCalendar;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus delete(Collection<GoogleCalendarSession> sessions) {
        sessions.getClass();
        Object objRunBlockingK$default = BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new AnonymousClass2(sessions, this, null), 1, null);
        objRunBlockingK$default.getClass();
        return (ResultStatus) objRunBlockingK$default;
    }

    private final List<GoogleCalendarSession> find(GoogleCalendar calendar, Date from, Date to, boolean singleEvent) {
        return (List) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new AnonymousClass1(calendar, from, to, singleEvent, null), 1, null);
    }
}
