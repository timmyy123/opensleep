package com.urbandroid.sleep.service.google.calendar;

import android.app.Activity;
import android.content.Context;
import androidx.appfunctions.AppFunctionException;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarNotifierKt;
import com.urbandroid.sleep.service.health.session.HealthSession;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u001a'\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\t\u001a\u00020\u0000*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000b\u001a\u00020\u0001*\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000b\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\r\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\u000e\u001a!\u0010\u0012\u001a\u0004\u0018\u00010\u0010*\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0018\u001a\u00020\u0017*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019\"\u0011\u0010\u001c\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Ljava/util/Calendar;", "", "pattern", "Ljava/util/TimeZone;", "timeZone", "format", "(Ljava/util/Calendar;Ljava/lang/String;Ljava/util/TimeZone;)Ljava/lang/String;", "", "zone", "calendar", "(JLjava/util/TimeZone;)Ljava/util/Calendar;", "prettyDate", "(JLjava/util/TimeZone;)Ljava/lang/String;", "zoneId", "(JLjava/lang/String;)Ljava/lang/String;", "", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "session", "findSame", "(Ljava/util/Collection;Lcom/urbandroid/sleep/service/health/session/HealthSession;)Lcom/urbandroid/sleep/service/health/session/HealthSession;", "Lcom/google/android/gms/auth/UserRecoverableAuthException;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "recover", "(Lcom/google/android/gms/auth/UserRecoverableAuthException;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTIMEZONE_DEFAULT", "()Ljava/lang/String;", "TIMEZONE_DEFAULT", "getPrettyDate", "(Ljava/util/Calendar;)Ljava/lang/String;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class CalendarKt {

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.CalendarKt$recover$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.CalendarKt$recover$2", f = "calendar.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ UserRecoverableAuthException $this_recover;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, UserRecoverableAuthException userRecoverableAuthException, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$this_recover = userRecoverableAuthException;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, this.$this_recover, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            Context context = this.$context;
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(this.$this_recover.getIntent(), AppFunctionException.ERROR_FUNCTION_NOT_FOUND);
            } else {
                GoogleCalendarNotifierKt.calendarPermissionMissingNotification(context, this.$this_recover);
            }
            return Unit.INSTANCE;
        }
    }

    public static final Calendar calendar(long j, TimeZone timeZone) {
        timeZone.getClass();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeZone);
        calendar.setTimeInMillis(j);
        return calendar;
    }

    public static final HealthSession findSame(Collection<? extends HealthSession> collection, HealthSession healthSession) {
        Object next;
        collection.getClass();
        healthSession.getClass();
        Iterator<T> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(healthSession, (HealthSession) next)) {
                break;
            }
        }
        return (HealthSession) next;
    }

    public static final String format(Calendar calendar, String str, TimeZone timeZone) {
        calendar.getClass();
        str.getClass();
        timeZone.getClass();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(timeZone);
        String str2 = simpleDateFormat.format(calendar.getTime());
        str2.getClass();
        return str2;
    }

    public static final String getPrettyDate(Calendar calendar) {
        calendar.getClass();
        TimeZone timeZone = calendar.getTimeZone();
        timeZone.getClass();
        return format(calendar, "yyyy-MM-dd HH:mm:ss", timeZone);
    }

    public static final String getTIMEZONE_DEFAULT() {
        String id = TimeZone.getDefault().getID();
        id.getClass();
        return id;
    }

    public static final String prettyDate(long j, String str) {
        str.getClass();
        TimeZone timeZone = DesugarTimeZone.getTimeZone(str);
        timeZone.getClass();
        return prettyDate(j, timeZone);
    }

    public static /* synthetic */ String prettyDate$default(long j, TimeZone timeZone, int i, Object obj) {
        if ((i & 1) != 0) {
            timeZone = TimeZone.getDefault();
            timeZone.getClass();
        }
        return prettyDate(j, timeZone);
    }

    public static final Object recover(UserRecoverableAuthException userRecoverableAuthException, Context context, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(context, userRecoverableAuthException, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public static final String prettyDate(long j, TimeZone timeZone) {
        timeZone.getClass();
        return format(calendar(j, timeZone), "yyyy-MM-dd HH:mm:ss", timeZone);
    }

    public static final String prettyDate(long j) {
        return prettyDate$default(j, null, 1, null);
    }
}
