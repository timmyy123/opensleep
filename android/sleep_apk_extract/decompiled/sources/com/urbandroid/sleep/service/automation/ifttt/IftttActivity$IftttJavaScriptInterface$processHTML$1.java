package com.urbandroid.sleep.service.automation.ifttt;

import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;
import com.urbandroid.common.Utils;
import com.urbandroid.sleep.R;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.service.automation.ifttt.IftttActivity$IftttJavaScriptInterface$processHTML$1", f = "IftttActivity.kt", l = {150}, m = "invokeSuspend", v = 2)
public final class IftttActivity$IftttJavaScriptInterface$processHTML$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AtomicReference<String> $foundKey;
    int label;
    final /* synthetic */ IftttActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IftttActivity$IftttJavaScriptInterface$processHTML$1(IftttActivity iftttActivity, AtomicReference<String> atomicReference, Continuation<? super IftttActivity$IftttJavaScriptInterface$processHTML$1> continuation) {
        super(2, continuation);
        this.this$0 = iftttActivity;
        this.$foundKey = atomicReference;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IftttActivity$IftttJavaScriptInterface$processHTML$1(this.this$0, this.$foundKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IftttActivity$IftttJavaScriptInterface$processHTML$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        EditText editText = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WebView webView = this.this$0.browser;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("browser");
                webView = null;
            }
            webView.setVisibility(8);
            EditText editText2 = this.this$0.keyText;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyText");
            } else {
                editText = editText2;
            }
            editText.setText(this.$foundKey.get());
            long secondsInMillis = Utils.getSecondsInMillis(1);
            this.label = 1;
            if (DelayKt.delay(secondsInMillis, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        IftttActivity iftttActivity = this.this$0;
        String string = iftttActivity.getResources().getString(R.string.share_connected, "IFTTT");
        string.getClass();
        Toast.makeText(iftttActivity, string, 1).show();
        this.this$0.finish();
        return Unit.INSTANCE;
    }
}
