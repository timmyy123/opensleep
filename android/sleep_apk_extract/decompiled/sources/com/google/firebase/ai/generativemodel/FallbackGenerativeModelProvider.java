package com.google.firebase.ai.generativemodel;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.util.Log;
import com.google.firebase.ai.ondevice.interop.FirebaseAIOnDeviceException;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.FirebaseAIException;
import com.google.firebase.ai.type.GenerateContentResponse;
import com.google.firebase.ai.type.Tool$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B1\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u00018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/google/firebase/ai/generativemodel/FallbackGenerativeModelProvider;", "Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;", "defaultModel", "fallbackModel", "Lkotlin/Function0;", "", "precondition", "shouldFallbackInException", "<init>", "(Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;Lkotlin/jvm/functions/Function0;Z)V", "", "Lcom/google/firebase/ai/type/Content;", "prompt", "Lcom/google/firebase/ai/type/GenerateContentResponse;", "generateContent", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;", "getDefaultModel$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;", "getFallbackModel$com_google_firebase_ai_logic_firebase_ai", "Lkotlin/jvm/functions/Function0;", "Z", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FallbackGenerativeModelProvider implements GenerativeModelProvider {
    private static final String TAG = "FallbackGenerativeModelProvider";
    private final GenerativeModelProvider defaultModel;
    private final GenerativeModelProvider fallbackModel;
    private final Function0<Boolean> precondition;
    private final boolean shouldFallbackInException;

    /* JADX INFO: renamed from: com.google.firebase.ai.generativemodel.FallbackGenerativeModelProvider$generateContent$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.generativemodel.FallbackGenerativeModelProvider", f = "FallbackGenerativeModelProvider.kt", l = {57, 57, 57}, m = "generateContent")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FallbackGenerativeModelProvider.this.generateContent(null, this);
        }
    }

    public FallbackGenerativeModelProvider(GenerativeModelProvider generativeModelProvider, GenerativeModelProvider generativeModelProvider2, Function0<Boolean> function0, boolean z) {
        generativeModelProvider.getClass();
        generativeModelProvider2.getClass();
        function0.getClass();
        this.defaultModel = generativeModelProvider;
        this.fallbackModel = generativeModelProvider2;
        this.precondition = function0;
        this.shouldFallbackInException = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0094, code lost:
    
        if (r12 == r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fc, code lost:
    
        if (r12 == r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.firebase.ai.generativemodel.GenerativeModelProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object generateContent(List<Content> list, Continuation<? super GenerateContentResponse> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        String str;
        Object objGenerateContent;
        Exception e;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objGenerateContent2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(objGenerateContent2);
                return (GenerateContentResponse) objGenerateContent2;
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    ResultKt.throwOnFailure(objGenerateContent2);
                    return (GenerateContentResponse) objGenerateContent2;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            String str2 = (String) anonymousClass1.L$2;
            FallbackGenerativeModelProvider fallbackGenerativeModelProvider = (FallbackGenerativeModelProvider) anonymousClass1.L$1;
            List<Content> list2 = (List) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(objGenerateContent2);
                str = str2;
                this = fallbackGenerativeModelProvider;
                list = list2;
                objGenerateContent = objGenerateContent2;
                return (GenerateContentResponse) objGenerateContent;
            } catch (Exception e2) {
                str = str2;
                this = fallbackGenerativeModelProvider;
                list = list2;
                e = e2;
                if (this.shouldFallbackInException) {
                }
                throw e;
            }
        }
        ResultKt.throwOnFailure(objGenerateContent2);
        str = "generateContent";
        if (this.precondition.invoke().booleanValue()) {
            try {
                GenerativeModelProvider generativeModelProvider = this.defaultModel;
                anonymousClass1.L$0 = list;
                anonymousClass1.L$1 = this;
                anonymousClass1.L$2 = "generateContent";
                anonymousClass1.label = 2;
                objGenerateContent = generativeModelProvider.generateContent(list, anonymousClass1);
                if (objGenerateContent == coroutine_suspended) {
                }
                return (GenerateContentResponse) objGenerateContent;
            } catch (Exception e3) {
                e = e3;
                if (this.shouldFallbackInException || !((e instanceof FirebaseAIException) || (e instanceof FirebaseAIOnDeviceException))) {
                    throw e;
                }
                String str3 = TAG;
                StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Error running `", str, "` on `");
                sbM5m.append(this.defaultModel.getClass().getSimpleName());
                sbM5m.append("`. Falling back to `");
                sbM5m.append(this.fallbackModel.getClass().getSimpleName());
                sbM5m.append('`');
                Log.w(str3, sbM5m.toString(), e);
                GenerativeModelProvider generativeModelProvider2 = this.fallbackModel;
                anonymousClass1.L$0 = null;
                anonymousClass1.L$1 = null;
                anonymousClass1.L$2 = null;
                anonymousClass1.label = 3;
                objGenerateContent2 = generativeModelProvider2.generateContent(list, anonymousClass1);
            }
        } else {
            Log.w(TAG, "Precondition was not met, switching to fallback model `" + this.fallbackModel.getClass().getSimpleName() + '`');
            GenerativeModelProvider generativeModelProvider3 = this.fallbackModel;
            anonymousClass1.label = 1;
            objGenerateContent2 = generativeModelProvider3.generateContent(list, anonymousClass1);
        }
        return coroutine_suspended;
    }

    public /* synthetic */ FallbackGenerativeModelProvider(GenerativeModelProvider generativeModelProvider, GenerativeModelProvider generativeModelProvider2, Function0 function0, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(generativeModelProvider, generativeModelProvider2, (i & 4) != 0 ? new Tool$$ExternalSyntheticLambda0(13) : function0, (i & 8) != 0 ? true : z);
    }
}
