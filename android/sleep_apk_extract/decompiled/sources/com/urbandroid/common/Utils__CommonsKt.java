package com.urbandroid.common;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\u001a\u0010\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\u0006\u001a\n \t*\u0004\u0018\u00010\u00050\u0005*\u00020\b¢\u0006\u0004\b\u0006\u0010\n\u001a\u001d\u0010\u000b\u001a\u00020\u0003*\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a4\u0010\u0017\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140\u0013H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018\u001aA\u0010\u001d\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0011*\u00028\u00002(\u0010\u001c\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019¢\u0006\u0004\b\u001d\u0010\u001e\"\u0015\u0010!\u001a\u00020\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0015\u0010$\u001a\u00020\u0000*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0015\u0010&\u001a\u00020\u0000*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b%\u0010#\"\u0015\u0010$\u001a\u00020\u0000*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\"\u0010'\"\u0015\u0010)\u001a\u00020\u0000*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b(\u0010#\"\u0015\u0010)\u001a\u00020\u0000*\u00020\r8F¢\u0006\u0006\u001a\u0004\b(\u0010'\"\u0015\u0010+\u001a\u00020\u0000*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b*\u0010#\"\u0015\u0010+\u001a\u00020\u0000*\u00020\r8F¢\u0006\u0006\u001a\u0004\b*\u0010'\"\u0015\u0010&\u001a\u00020\u0000*\u00020\r8F¢\u0006\u0006\u001a\u0004\b%\u0010'\"\u0015\u0010.\u001a\u00020\u0005*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"", "now", "()J", "", "pattern", "Ljava/util/Calendar;", "toCalendar", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Calendar;", "Ljava/util/Date;", "kotlin.jvm.PlatformType", "(Ljava/util/Date;)Ljava/util/Calendar;", "format", "(Ljava/util/Calendar;Ljava/lang/String;)Ljava/lang/String;", "", "days", "plusDays", "(Ljava/util/Calendar;I)Ljava/util/Calendar;", "T", "Lcom/urbandroid/common/AsyncContext;", "Lkotlin/Function1;", "", "block", "", "uiThread", "(Lcom/urbandroid/common/AsyncContext;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "task", "doAsyncThrowOnUI", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "getPrettyDate", "(J)Ljava/lang/String;", "prettyDate", "getHoursInMillis", "(J)J", "hoursInMillis", "getHoursInMinutes", "hoursInMinutes", "(I)J", "getMinutesInMillis", "minutesInMillis", "getSecondsInMillis", "secondsInMillis", "getCalendar", "(J)Ljava/util/Calendar;", "calendar", "common_release"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "com/urbandroid/common/Utils")
abstract /* synthetic */ class Utils__CommonsKt {

    /* JADX INFO: renamed from: com.urbandroid.common.Utils__CommonsKt$doAsyncThrowOnUI$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.common.Utils__CommonsKt$doAsyncThrowOnUI$1", f = "commons.kt", l = {174}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AsyncContext<T> $context;
        final /* synthetic */ Function2<AsyncContext<T>, Continuation<? super Unit>, Object> $task;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function2<? super AsyncContext<T>, ? super Continuation<? super Unit>, ? extends Object> function2, AsyncContext<T> asyncContext, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$task = function2;
            this.$context = asyncContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$task, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function2<AsyncContext<T>, Continuation<? super Unit>, Object> function2 = this.$task;
                Object obj2 = this.$context;
                this.label = 1;
                if (function2.invoke(obj2, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.common.Utils__CommonsKt$uiThread$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.common.Utils__CommonsKt", f = "commons.kt", l = {157}, m = "uiThread")
    public static final class C20801<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C20801(Continuation<? super C20801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Utils.uiThread(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.common.Utils__CommonsKt$uiThread$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.common.Utils__CommonsKt$uiThread$2", f = "commons.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<T, Unit> $block;
        final /* synthetic */ T $ref;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super T, Unit> function1, T t, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function1;
            this.$ref = t;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$block, this.$ref, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            this.$block.invoke(this.$ref);
            return Unit.INSTANCE;
        }
    }

    public static final <T> void doAsyncThrowOnUI(T t, Function2<? super AsyncContext<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        function2.getClass();
        AsyncContext asyncContext = new AsyncContext(new WeakReference(t));
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault().plus(new Utils__CommonsKt$doAsyncThrowOnUI$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE)), null, new AnonymousClass1(function2, asyncContext, null), 2, null);
    }

    public static final String format(Calendar calendar, String str) {
        calendar.getClass();
        str.getClass();
        String str2 = new SimpleDateFormat(str).format(calendar.getTime());
        str2.getClass();
        return str2;
    }

    public static /* synthetic */ String format$default(Calendar calendar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "yyyy-MM-dd HH:mm";
        }
        return Utils.format(calendar, str);
    }

    public static final Calendar getCalendar(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar;
    }

    public static final long getHoursInMillis(long j) {
        return TimeUnit.HOURS.toMillis(j);
    }

    public static final long getHoursInMinutes(long j) {
        return TimeUnit.HOURS.toMinutes(j);
    }

    public static final long getMinutesInMillis(long j) {
        return TimeUnit.MINUTES.toMillis(j);
    }

    public static final String getPrettyDate(long j) {
        return Utils.format(Utils.getCalendar(j), "yyyy-MM-dd HH:mm:ss");
    }

    public static final long getSecondsInMillis(long j) {
        return TimeUnit.SECONDS.toMillis(j);
    }

    public static final long now() {
        return System.currentTimeMillis();
    }

    public static final Calendar plusDays(Calendar calendar, int i) {
        calendar.getClass();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        calendar2.add(6, i);
        return calendar2;
    }

    public static final Calendar toCalendar(String str, String str2) {
        str.getClass();
        str2.getClass();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(str2).parse(str));
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object uiThread(AsyncContext<T> asyncContext, Function1<? super T, Unit> function1, Continuation<? super Boolean> continuation) {
        C20801 c20801;
        if (continuation instanceof C20801) {
            c20801 = (C20801) continuation;
            int i = c20801.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20801.label = i - Integer.MIN_VALUE;
            } else {
                c20801 = new C20801(continuation);
            }
        }
        Object obj = c20801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20801.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            T t = asyncContext.getWeakRef().get();
            if (t == null) {
                return Boxing.boxBoolean(false);
            }
            CoroutineContext coroutineContextPlus = Dispatchers.getMain().plus(new Utils__CommonsKt$uiThread$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(function1, t, null);
            c20801.label = 1;
            if (BuildersKt.withContext(coroutineContextPlus, anonymousClass2, c20801) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(true);
    }

    public static final long getHoursInMillis(int i) {
        return Utils.getHoursInMillis(i);
    }

    public static final long getHoursInMinutes(int i) {
        return Utils.getHoursInMinutes(i);
    }

    public static final long getMinutesInMillis(int i) {
        return Utils.getMinutesInMillis(i);
    }

    public static final long getSecondsInMillis(int i) {
        return Utils.getSecondsInMillis(i);
    }

    public static final String format(Calendar calendar) {
        calendar.getClass();
        return format$default(calendar, null, 1, null);
    }

    public static final Calendar toCalendar(Date date) {
        date.getClass();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
