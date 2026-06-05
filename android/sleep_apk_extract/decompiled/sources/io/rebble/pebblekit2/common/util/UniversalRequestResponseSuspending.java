package io.rebble.pebblekit2.common.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import com.facebook.share.internal.ShareConstants;
import io.rebble.pebblekit2.common.SendDataCallback;
import io.rebble.pebblekit2.common.UniversalRequestResponse;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ \u0010\b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH¤@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/rebble/pebblekit2/common/util/UniversalRequestResponseSuspending;", "Lio/rebble/pebblekit2/common/UniversalRequestResponse$Stub;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;)V", "request", "", "data", "Landroid/os/Bundle;", "callback", "Lio/rebble/pebblekit2/common/SendDataCallback;", "callingPackage", "", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class UniversalRequestResponseSuspending extends UniversalRequestResponse.Stub {
    private final Context context;
    private final CoroutineScope coroutineScope;

    /* JADX INFO: renamed from: io.rebble.pebblekit2.common.util.UniversalRequestResponseSuspending$request$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.rebble.pebblekit2.common.util.UniversalRequestResponseSuspending$request$1", f = "AidlCoroutines.kt", l = {41}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SendDataCallback $callback;
        final /* synthetic */ String $callingPackage;
        final /* synthetic */ Bundle $data;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Bundle bundle, String str, SendDataCallback sendDataCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$data = bundle;
            this.$callingPackage = str;
            this.$callback = sendDataCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UniversalRequestResponseSuspending.this.new AnonymousClass1(this.$data, this.$callingPackage, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Bundle bundle;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    UniversalRequestResponseSuspending universalRequestResponseSuspending = UniversalRequestResponseSuspending.this;
                    Bundle bundle2 = this.$data;
                    String str = this.$callingPackage;
                    this.label = 1;
                    obj = universalRequestResponseSuspending.request(bundle2, str, this);
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
                bundle = (Bundle) obj;
            } catch (CancellationException e) {
                throw e;
            } catch (Exception e2) {
                String string = this.$data.getString(ShareConstants.ACTION);
                if (string == null) {
                    string = "UNKNOWN";
                }
                Logger loggerWithTag = Logger.INSTANCE.withTag("PebbleKit2");
                String tag = loggerWithTag.getTag();
                Severity severity = Severity.Error;
                if (loggerWithTag.getConfig().get_minSeverity().compareTo(severity) <= 0) {
                    loggerWithTag.processLog(severity, tag, e2, FileInsert$$ExternalSyntheticOutline0.m("Failed to process '", string, "' bundle"));
                }
                bundle = new Bundle();
            }
            try {
                this.$callback.onResult(bundle);
            } catch (DeadObjectException unused) {
            }
            return Unit.INSTANCE;
        }
    }

    public UniversalRequestResponseSuspending(Context context, CoroutineScope coroutineScope) {
        context.getClass();
        coroutineScope.getClass();
        this.context = context;
        this.coroutineScope = coroutineScope;
    }

    public abstract Object request(Bundle bundle, String str, Continuation<? super Bundle> continuation);

    @Override // io.rebble.pebblekit2.common.UniversalRequestResponse
    public final void request(Bundle data2, SendDataCallback callback) {
        data2.getClass();
        callback.getClass();
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(data2, this.context.getPackageManager().getNameForUid(Binder.getCallingUid()), callback, null), 3, null);
    }
}
