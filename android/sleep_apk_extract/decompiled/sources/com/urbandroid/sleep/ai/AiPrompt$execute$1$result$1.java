package com.urbandroid.sleep.ai;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.firebase.ai.GenerativeModel;
import com.google.firebase.ai.type.GenerateContentResponse;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ai.AiPrompt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.ai.AiPrompt$execute$1$result$1", f = "AiPrompt.kt", l = {233, 243, 253}, m = "invokeSuspend", v = 2)
public final class AiPrompt$execute$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ GenerativeModel $model;
    final /* synthetic */ Ref$ObjectRef<String> $prompt;
    Object L$0;
    int label;
    final /* synthetic */ AiPrompt this$0;

    /* JADX INFO: renamed from: com.urbandroid.sleep.ai.AiPrompt$execute$1$result$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.ai.AiPrompt$execute$1$result$1$1", f = "AiPrompt.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $cached;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$cached = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$cached, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return this.$cached;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiPrompt$execute$1$result$1(Ref$ObjectRef<String> ref$ObjectRef, AiPrompt aiPrompt, GenerativeModel generativeModel, Continuation<? super AiPrompt$execute$1$result$1> continuation) {
        super(2, continuation);
        this.$prompt = ref$ObjectRef;
        this.this$0 = aiPrompt;
        this.$model = generativeModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AiPrompt$execute$1$result$1(this.$prompt, this.this$0, this.$model, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((AiPrompt$execute$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00e8, code lost:
    
        if (r10 == r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x011a, code lost:
    
        if (r10 == r0) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref$ObjectRef<String> ref$ObjectRef;
        T t;
        Object obj2;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ref$ObjectRef = this.$prompt;
                AiPrompt aiPrompt = this.this$0;
                this.L$0 = ref$ObjectRef;
                this.label = 1;
                Object objDoLoad = aiPrompt.doLoad(this);
                t = objDoLoad;
                if (objDoLoad != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    return (String) obj2;
                }
                if (i != 3) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                obj3 = obj;
                return ((GenerateContentResponse) obj3).getText();
            }
            ref$ObjectRef = (Ref$ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            t = obj;
            ref$ObjectRef.element = t;
            AiPrompt.Companion companion = AiPrompt.INSTANCE;
            companion.setLastQuestion(this.$prompt.element);
            AiPrompt aiPrompt2 = this.this$0;
            String strM = Fragment$$ExternalSyntheticOutline1.m("prompt: ", (Object) this.$prompt.element);
            Logger.logInfo(Logger.defaultTag, aiPrompt2.getTag() + ": " + strM, null);
            companion.getHistoryList().add("User asks: " + ((Object) this.$prompt.element));
            if (companion.getHistory().containsKey(this.$prompt.element)) {
                String str = companion.getHistory().get(this.$prompt.element);
                AiPrompt aiPrompt3 = this.this$0;
                String strM2 = FileInsert$$ExternalSyntheticOutline0.m("cached: ", str);
                Logger.logInfo(Logger.defaultTag, aiPrompt3.getTag() + ": " + strM2, null);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(str, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                this.label = 2;
                Object objWithContext = BuildersKt.withContext(main, anonymousClass1, this);
                obj2 = objWithContext;
            } else {
                AiPrompt aiPrompt4 = this.this$0;
                Logger.logInfo(Logger.defaultTag, aiPrompt4.getTag() + ": generate content ", null);
                GenerativeModel generativeModel = this.$model;
                String str2 = this.$prompt.element;
                this.L$0 = null;
                this.label = 3;
                Object objGenerateContent = generativeModel.generateContent(str2, this);
                obj3 = objGenerateContent;
            }
            return coroutine_suspended;
        } catch (Exception e) {
            Logger.logSevere(Logger.defaultTag, this.this$0.getTag(), e);
            return null;
        }
    }
}
