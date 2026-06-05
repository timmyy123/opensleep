package io.rebble.pebblekit2.client;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/content/Intent;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.rebble.pebblekit2.client.DefaultPebbleSender$connector$1", f = "DefaultPebbleSender.kt", l = {30}, m = "invokeSuspend", v = 2)
public final class DefaultPebbleSender$connector$1 extends SuspendLambda implements Function1<Continuation<? super Intent>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultPebbleSender$connector$1(Context context, Continuation<? super DefaultPebbleSender$connector$1> continuation) {
        super(1, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DefaultPebbleSender$connector$1(this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Intent> continuation) {
        return ((DefaultPebbleSender$connector$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PebbleAndroidAppPicker companion = DefaultPebbleAndroidAppPicker.INSTANCE.getInstance(this.$context);
            this.label = 1;
            obj = companion.getCurrentlySelectedApp(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        String str = (String) obj;
        if (str == null) {
            return null;
        }
        return new Intent("io.rebble.pebblekit2.SEND_DATA_TO_WATCH").setPackage(str);
    }
}
