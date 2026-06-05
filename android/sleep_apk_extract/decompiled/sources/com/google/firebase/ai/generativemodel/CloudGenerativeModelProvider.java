package com.google.firebase.ai.generativemodel;

import com.google.firebase.ai.common.APIController;
import com.google.firebase.ai.common.GenerateContentRequest;
import com.google.firebase.ai.type.Candidate;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.FinishReason;
import com.google.firebase.ai.type.FirebaseAIException;
import com.google.firebase.ai.type.GenerateContentResponse;
import com.google.firebase.ai.type.GenerationConfig;
import com.google.firebase.ai.type.GenerativeBackend;
import com.google.firebase.ai.type.GenerativeBackendEnum;
import com.google.firebase.ai.type.InvalidStateException;
import com.google.firebase.ai.type.PromptBlockedException;
import com.google.firebase.ai.type.PromptFeedback;
import com.google.firebase.ai.type.ResponseStoppedException;
import com.google.firebase.ai.type.SafetySetting;
import com.google.firebase.ai.type.SerializationException;
import com.google.firebase.ai.type.Tool;
import com.google.firebase.ai.type.ToolConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J4\u0010\u001a\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00152\u001c\u0010\u0019\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016H\u0082@¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001f\u001a\u00020\u001e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010\"\u001a\u00020!*\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u001e\u0010$\u001a\u00020!2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u0006H\u0096@¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010&R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010(R\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010(R\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010)R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010*R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010+R\u001a\u0010\u0012\u001a\u00020\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/google/firebase/ai/generativemodel/CloudGenerativeModelProvider;", "Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;", "", "modelName", "Lcom/google/firebase/ai/type/GenerationConfig;", "generationConfig", "", "Lcom/google/firebase/ai/type/SafetySetting;", "safetySettings", "Lcom/google/firebase/ai/type/Tool;", "tools", "Lcom/google/firebase/ai/type/ToolConfig;", "toolConfig", "Lcom/google/firebase/ai/type/Content;", "systemInstruction", "Lcom/google/firebase/ai/type/GenerativeBackend;", "generativeBackend", "Lcom/google/firebase/ai/common/APIController;", "controller", "<init>", "(Ljava/lang/String;Lcom/google/firebase/ai/type/GenerationConfig;Ljava/util/List;Ljava/util/List;Lcom/google/firebase/ai/type/ToolConfig;Lcom/google/firebase/ai/type/Content;Lcom/google/firebase/ai/type/GenerativeBackend;Lcom/google/firebase/ai/common/APIController;)V", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "withFirebaseAIExceptionHandling", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prompt", "overrideConfig", "Lcom/google/firebase/ai/common/GenerateContentRequest;", "buildGenerateContentRequest", "(Ljava/util/List;Lcom/google/firebase/ai/type/GenerationConfig;)Lcom/google/firebase/ai/common/GenerateContentRequest;", "Lcom/google/firebase/ai/type/GenerateContentResponse;", "validate", "(Lcom/google/firebase/ai/type/GenerateContentResponse;)Lcom/google/firebase/ai/type/GenerateContentResponse;", "generateContent", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/String;", "Lcom/google/firebase/ai/type/GenerationConfig;", "Ljava/util/List;", "Lcom/google/firebase/ai/type/ToolConfig;", "Lcom/google/firebase/ai/type/Content;", "Lcom/google/firebase/ai/type/GenerativeBackend;", "Lcom/google/firebase/ai/common/APIController;", "getController$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/common/APIController;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CloudGenerativeModelProvider implements GenerativeModelProvider {
    private final APIController controller;
    private final GenerationConfig generationConfig;
    private final GenerativeBackend generativeBackend;
    private final String modelName;
    private final List<SafetySetting> safetySettings;
    private final Content systemInstruction;
    private final ToolConfig toolConfig;
    private final List<Tool> tools;

    /* JADX INFO: renamed from: com.google.firebase.ai.generativemodel.CloudGenerativeModelProvider$generateContent$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/google/firebase/ai/type/GenerateContentResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.generativemodel.CloudGenerativeModelProvider$generateContent$2", f = "CloudGenerativeModelProvider.kt", l = {56}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super GenerateContentResponse>, Object> {
        final /* synthetic */ List<Content> $prompt;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<Content> list, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$prompt = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CloudGenerativeModelProvider.this.new AnonymousClass2(this.$prompt, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super GenerateContentResponse> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CloudGenerativeModelProvider cloudGenerativeModelProvider;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CloudGenerativeModelProvider cloudGenerativeModelProvider2 = CloudGenerativeModelProvider.this;
                APIController controller = cloudGenerativeModelProvider2.getController();
                GenerateContentRequest generateContentRequestBuildGenerateContentRequest$default = CloudGenerativeModelProvider.buildGenerateContentRequest$default(CloudGenerativeModelProvider.this, this.$prompt, null, 2, null);
                this.L$0 = cloudGenerativeModelProvider2;
                this.label = 1;
                Object objGenerateContent = controller.generateContent(generateContentRequestBuildGenerateContentRequest$default, this);
                if (objGenerateContent == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objGenerateContent;
                cloudGenerativeModelProvider = cloudGenerativeModelProvider2;
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                cloudGenerativeModelProvider = (CloudGenerativeModelProvider) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return cloudGenerativeModelProvider.validate(((GenerateContentResponse.Internal) obj).toPublic$com_google_firebase_ai_logic_firebase_ai());
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.generativemodel.CloudGenerativeModelProvider$withFirebaseAIExceptionHandling$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.generativemodel.CloudGenerativeModelProvider", f = "CloudGenerativeModelProvider.kt", l = {89}, m = "withFirebaseAIExceptionHandling")
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CloudGenerativeModelProvider.this.withFirebaseAIExceptionHandling(null, this);
        }
    }

    public CloudGenerativeModelProvider(String str, GenerationConfig generationConfig, List<SafetySetting> list, List<Tool> list2, ToolConfig toolConfig, Content content, GenerativeBackend generativeBackend, APIController aPIController) {
        str.getClass();
        generativeBackend.getClass();
        aPIController.getClass();
        this.modelName = str;
        this.generationConfig = generationConfig;
        this.safetySettings = list;
        this.tools = list2;
        this.toolConfig = toolConfig;
        this.systemInstruction = content;
        this.generativeBackend = generativeBackend;
        this.controller = aPIController;
    }

    private final GenerateContentRequest buildGenerateContentRequest(List<Content> prompt, GenerationConfig overrideConfig) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Content contentCopy$default;
        String str = this.modelName;
        List<Content> list = prompt;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList3.add(((Content) it.next()).toInternal$com_google_firebase_ai_logic_firebase_ai());
        }
        List<SafetySetting> list2 = this.safetySettings;
        Content.Internal internal$com_google_firebase_ai_logic_firebase_ai = null;
        if (list2 != null) {
            if (this.generativeBackend.getBackend() == GenerativeBackendEnum.GOOGLE_AI) {
                List<SafetySetting> list3 = list2;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    Iterator<T> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        if (((SafetySetting) it2.next()).getMethod() != null) {
                            throw new InvalidStateException("HarmBlockMethod is unsupported by the Google Developer API", null, 2, null);
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            List<SafetySetting> list4 = list2;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it3 = list4.iterator();
            while (it3.hasNext()) {
                arrayList.add(((SafetySetting) it3.next()).toInternal$com_google_firebase_ai_logic_firebase_ai());
            }
        } else {
            arrayList = null;
        }
        if (overrideConfig == null) {
            overrideConfig = this.generationConfig;
        }
        GenerationConfig.Internal internal$com_google_firebase_ai_logic_firebase_ai2 = overrideConfig != null ? overrideConfig.toInternal$com_google_firebase_ai_logic_firebase_ai() : null;
        List<Tool> list5 = this.tools;
        if (list5 != null) {
            List<Tool> list6 = list5;
            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
            Iterator<T> it4 = list6.iterator();
            while (it4.hasNext()) {
                arrayList2.add(((Tool) it4.next()).toInternal$com_google_firebase_ai_logic_firebase_ai());
            }
        } else {
            arrayList2 = null;
        }
        ToolConfig toolConfig = this.toolConfig;
        ToolConfig.Internal internal$com_google_firebase_ai_logic_firebase_ai3 = toolConfig != null ? toolConfig.toInternal$com_google_firebase_ai_logic_firebase_ai() : null;
        Content content = this.systemInstruction;
        if (content != null && (contentCopy$default = Content.copy$default(content, "system", null, 2, null)) != null) {
            internal$com_google_firebase_ai_logic_firebase_ai = contentCopy$default.toInternal$com_google_firebase_ai_logic_firebase_ai();
        }
        return new GenerateContentRequest(str, arrayList3, arrayList, internal$com_google_firebase_ai_logic_firebase_ai2, arrayList2, internal$com_google_firebase_ai_logic_firebase_ai3, internal$com_google_firebase_ai_logic_firebase_ai);
    }

    public static /* synthetic */ GenerateContentRequest buildGenerateContentRequest$default(CloudGenerativeModelProvider cloudGenerativeModelProvider, List list, GenerationConfig generationConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            generationConfig = null;
        }
        return cloudGenerativeModelProvider.buildGenerateContentRequest(list, generationConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final GenerateContentResponse validate(GenerateContentResponse generateContentResponse) {
        Object next;
        int i = 2;
        Throwable th = null;
        Object[] objArr = 0;
        if (generateContentResponse.getCandidates().isEmpty() && generateContentResponse.getPromptFeedback() == null) {
            throw new SerializationException("Error deserializing response, found no valid fields", null, 2, null);
        }
        PromptFeedback promptFeedback = generateContentResponse.getPromptFeedback();
        if (promptFeedback != null && promptFeedback.getBlockReason() != null) {
            throw new PromptBlockedException(generateContentResponse, null, null, 6, null);
        }
        List<Candidate> candidates = generateContentResponse.getCandidates();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = candidates.iterator();
        while (it.hasNext()) {
            FinishReason finishReason = ((Candidate) it.next()).getFinishReason();
            if (finishReason != null) {
                arrayList.add(finishReason);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (!Intrinsics.areEqual((FinishReason) next, FinishReason.STOP)) {
                break;
            }
        }
        if (((FinishReason) next) == null) {
            return generateContentResponse;
        }
        throw new ResponseStoppedException(generateContentResponse, th, i, objArr == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object withFirebaseAIExceptionHandling(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                anonymousClass1.label = 1;
                Object objInvoke = function1.invoke(anonymousClass1);
                return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        } catch (Throwable th) {
            throw FirebaseAIException.INSTANCE.from$com_google_firebase_ai_logic_firebase_ai(th);
        }
    }

    @Override // com.google.firebase.ai.generativemodel.GenerativeModelProvider
    public Object generateContent(List<Content> list, Continuation<? super GenerateContentResponse> continuation) {
        return withFirebaseAIExceptionHandling(new AnonymousClass2(list, null), continuation);
    }

    /* JADX INFO: renamed from: getController$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final APIController getController() {
        return this.controller;
    }
}
