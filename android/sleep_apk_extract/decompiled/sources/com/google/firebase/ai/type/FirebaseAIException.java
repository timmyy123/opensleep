package com.google.firebase.ai.type;

import com.google.firebase.ai.ondevice.interop.FirebaseAIOnDeviceException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.TimeoutCancellationException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b&\u0018\u0000 \t2\u00060\u0001j\u0002`\u0002:\u0001\tB\u001d\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/google/firebase/ai/type/FirebaseAIException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class FirebaseAIException extends RuntimeException {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\bJ4\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0080@¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0010\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0011H\u0000¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/google/firebase/ai/type/FirebaseAIException$Companion;", "", "<init>", "()V", "from", "Lcom/google/firebase/ai/type/FirebaseAIException;", "cause", "", "from$com_google_firebase_ai_logic_firebase_ai", "catchAsync", "T", "callback", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "catchAsync$com_google_firebase_ai_logic_firebase_ai", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "catch", "Lkotlin/Function0;", "catch$com_google_firebase_ai_logic_firebase_ai", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> T catch$com_google_firebase_ai_logic_firebase_ai(Function0<? extends T> callback) {
            callback.getClass();
            try {
                return callback.invoke();
            } catch (Exception e) {
                throw this.from$com_google_firebase_ai_logic_firebase_ai(e);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <T> Object catchAsync$com_google_firebase_ai_logic_firebase_ai(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
            FirebaseAIException$Companion$catchAsync$1 firebaseAIException$Companion$catchAsync$1;
            if (continuation instanceof FirebaseAIException$Companion$catchAsync$1) {
                firebaseAIException$Companion$catchAsync$1 = (FirebaseAIException$Companion$catchAsync$1) continuation;
                int i = firebaseAIException$Companion$catchAsync$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    firebaseAIException$Companion$catchAsync$1.label = i - Integer.MIN_VALUE;
                } else {
                    firebaseAIException$Companion$catchAsync$1 = new FirebaseAIException$Companion$catchAsync$1(this, continuation);
                }
            }
            Object obj = firebaseAIException$Companion$catchAsync$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = firebaseAIException$Companion$catchAsync$1.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    firebaseAIException$Companion$catchAsync$1.L$0 = this;
                    firebaseAIException$Companion$catchAsync$1.label = 1;
                    Object objInvoke = function1.invoke(firebaseAIException$Companion$catchAsync$1);
                    return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                }
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            } catch (Exception e) {
                throw from$com_google_firebase_ai_logic_firebase_ai(e);
            }
        }

        public final FirebaseAIException from$com_google_firebase_ai_logic_firebase_ai(Throwable cause) throws Throwable {
            cause.getClass();
            if (cause instanceof FirebaseAIException) {
                return (FirebaseAIException) cause;
            }
            if (cause instanceof FirebaseAIOnDeviceException) {
                FirebaseAIOnDeviceException firebaseAIOnDeviceException = (FirebaseAIOnDeviceException) cause;
                return firebaseAIOnDeviceException instanceof com.google.firebase.ai.ondevice.interop.FirebaseAIOnDeviceNotAvailableException ? new FirebaseAIOnDeviceNotAvailableException((com.google.firebase.ai.ondevice.interop.FirebaseAIOnDeviceNotAvailableException) cause) : new FirebaseAIOnDeviceUnknownException(firebaseAIOnDeviceException);
            }
            if (cause instanceof TimeoutCancellationException) {
                return new RequestTimeoutException("The request failed to complete in the allotted time.", null, null, 6, null);
            }
            if (cause instanceof CancellationException) {
                throw cause;
            }
            return new UnknownException("Something unexpected happened.", cause);
        }

        private Companion() {
        }
    }

    public /* synthetic */ FirebaseAIException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirebaseAIException(String str, Throwable th) {
        super(str, th);
        str.getClass();
    }
}
