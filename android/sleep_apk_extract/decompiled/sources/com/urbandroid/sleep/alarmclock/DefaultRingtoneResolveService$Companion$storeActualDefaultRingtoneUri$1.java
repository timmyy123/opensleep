package com.urbandroid.sleep.alarmclock;

import android.content.Context;
import com.urbandroid.common.AsyncContext;
import com.urbandroid.common.Utils;
import com.urbandroid.sleep.alarmclock.DefaultRingtoneResolveService;
import com.urbandroid.sleep.media.MediaListAdapter;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/common/AsyncContext;", "Lcom/urbandroid/sleep/alarmclock/DefaultRingtoneResolveService$Companion;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.alarmclock.DefaultRingtoneResolveService$Companion$storeActualDefaultRingtoneUri$1", f = "DefaultRingtoneResolveService.kt", l = {32}, m = "invokeSuspend", v = 2)
public final class DefaultRingtoneResolveService$Companion$storeActualDefaultRingtoneUri$1 extends SuspendLambda implements Function2<AsyncContext<DefaultRingtoneResolveService.Companion>, Continuation<? super Unit>, Object> {
    final /* synthetic */ DefaultRingtoneResolveService.DefaultRingtoneCallback $callback;
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultRingtoneResolveService$Companion$storeActualDefaultRingtoneUri$1(Context context, DefaultRingtoneResolveService.DefaultRingtoneCallback defaultRingtoneCallback, Continuation<? super DefaultRingtoneResolveService$Companion$storeActualDefaultRingtoneUri$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$callback = defaultRingtoneCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(DefaultRingtoneResolveService.DefaultRingtoneCallback defaultRingtoneCallback, DefaultRingtoneResolveService.Companion companion) {
        ((Events$$ExternalSyntheticBUOutline0) defaultRingtoneCallback).getClass();
        MediaListAdapter.lambda$toggleCheck$5();
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultRingtoneResolveService$Companion$storeActualDefaultRingtoneUri$1 defaultRingtoneResolveService$Companion$storeActualDefaultRingtoneUri$1 = new DefaultRingtoneResolveService$Companion$storeActualDefaultRingtoneUri$1(this.$context, this.$callback, continuation);
        defaultRingtoneResolveService$Companion$storeActualDefaultRingtoneUri$1.L$0 = obj;
        return defaultRingtoneResolveService$Companion$storeActualDefaultRingtoneUri$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AsyncContext<DefaultRingtoneResolveService.Companion> asyncContext, Continuation<? super Unit> continuation) {
        return ((DefaultRingtoneResolveService$Companion$storeActualDefaultRingtoneUri$1) create(asyncContext, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AsyncContext asyncContext = (AsyncContext) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DefaultRingtoneResolveService.INSTANCE.storeActualDefaultRingtoneUri(this.$context);
            final DefaultRingtoneResolveService.DefaultRingtoneCallback defaultRingtoneCallback = this.$callback;
            Function1 function1 = new Function1() { // from class: com.urbandroid.sleep.alarmclock.DefaultRingtoneResolveService$Companion$storeActualDefaultRingtoneUri$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DefaultRingtoneResolveService$Companion$storeActualDefaultRingtoneUri$1.invokeSuspend$lambda$0(defaultRingtoneCallback, (DefaultRingtoneResolveService.Companion) obj2);
                }
            };
            this.L$0 = SpillingKt.nullOutSpilledVariable(asyncContext);
            this.label = 1;
            if (Utils.uiThread(asyncContext, function1, this) == coroutine_suspended) {
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
