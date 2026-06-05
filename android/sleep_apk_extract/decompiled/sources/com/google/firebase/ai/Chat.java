package com.google.firebase.ai;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.ai.type.Candidate;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.ContentKt;
import com.google.firebase.ai.type.FunctionCallPart;
import com.google.firebase.ai.type.FunctionResponsePart;
import com.google.firebase.ai.type.GenerateContentResponse;
import com.google.firebase.ai.type.InvalidStateException;
import com.google.firebase.ai.type.Part;
import com.google.firebase.ai.type.RequestTimeoutException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SpreadBuilder;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u00020\t*\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0010\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/google/firebase/ai/Chat;", "", "Lcom/google/firebase/ai/GenerativeModel;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", "Lcom/google/firebase/ai/type/Content;", "history", "<init>", "(Lcom/google/firebase/ai/GenerativeModel;Ljava/util/List;)V", "", "assertComesFromUser", "(Lcom/google/firebase/ai/type/Content;)V", "attemptLock", "()V", "prompt", "Lcom/google/firebase/ai/type/GenerateContentResponse;", "sendMessage", "(Lcom/google/firebase/ai/type/Content;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/firebase/ai/GenerativeModel;", "Ljava/util/List;", "getHistory", "()Ljava/util/List;", "Ljava/util/concurrent/Semaphore;", "lock", "Ljava/util/concurrent/Semaphore;", "", "turns", "I", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Chat {
    private final List<Content> history;
    private Semaphore lock;
    private final GenerativeModel model;
    private int turns;

    /* JADX INFO: renamed from: com.google.firebase.ai.Chat$sendMessage$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.Chat", f = "Chat.kt", l = {75, 89}, m = "sendMessage")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Chat.this.sendMessage((Content) null, this);
        }
    }

    public Chat(GenerativeModel generativeModel, List<Content> list) {
        generativeModel.getClass();
        list.getClass();
        this.model = generativeModel;
        this.history = list;
        this.lock = new Semaphore(1);
    }

    private final void assertComesFromUser(Content content) {
        if (!CollectionsKt.contains(CollectionsKt.listOf((Object[]) new String[]{"user", "function"}), content.getRole())) {
            throw new InvalidStateException("Chat prompts should come from the 'user' or 'function' role.", null, 2, null);
        }
    }

    private final void attemptLock() {
        if (!this.lock.tryAcquire()) {
            throw new InvalidStateException("This chat instance currently has an ongoing request, please wait for it to complete before sending more messages", null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendMessage$lambda$2(String str, Content.Builder builder) {
        builder.getClass();
        builder.addText(str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f3 A[Catch: all -> 0x00ff, TryCatch #2 {all -> 0x00ff, blocks: (B:26:0x0079, B:30:0x00bd, B:31:0x00ed, B:33:0x00f3, B:35:0x00fb, B:38:0x0102, B:51:0x0139, B:41:0x0109, B:43:0x011a, B:54:0x0148, B:46:0x0121, B:47:0x0125, B:49:0x012b, B:65:0x0199, B:66:0x01a3, B:25:0x0071), top: B:73:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0109 A[Catch: all -> 0x00ff, TryCatch #2 {all -> 0x00ff, blocks: (B:26:0x0079, B:30:0x00bd, B:31:0x00ed, B:33:0x00f3, B:35:0x00fb, B:38:0x0102, B:51:0x0139, B:41:0x0109, B:43:0x011a, B:54:0x0148, B:46:0x0121, B:47:0x0125, B:49:0x012b, B:65:0x0199, B:66:0x01a3, B:25:0x0071), top: B:73:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0161 A[Catch: all -> 0x0064, TryCatch #0 {all -> 0x0064, blocks: (B:62:0x0181, B:56:0x015b, B:58:0x0161, B:63:0x018a, B:20:0x005e), top: B:69:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018a A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #0 {all -> 0x0064, blocks: (B:62:0x0181, B:56:0x015b, B:58:0x0161, B:63:0x018a, B:20:0x005e), top: B:69:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0157 -> B:56:0x015b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x017c -> B:62:0x0181). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendMessage(Content content, Continuation<? super GenerateContentResponse> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Chat chat;
        List listMutableListOf;
        Chat chat2;
        List list;
        ArrayList arrayList;
        Object objGenerateContent;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
                chat = this;
            } else {
                chat = this;
                anonymousClass1 = chat.new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            assertComesFromUser(content);
            chat.attemptLock();
            try {
                listMutableListOf = CollectionsKt.mutableListOf(content);
                GenerativeModel generativeModel = chat.model;
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.addSpread(chat.history.toArray(new Content[0]));
                spreadBuilder.addSpread(listMutableListOf.toArray(new Content[0]));
                List<Content> listListOf = CollectionsKt.listOf(spreadBuilder.toArray(new Content[spreadBuilder.size()]));
                anonymousClass1.L$0 = chat;
                anonymousClass1.L$1 = listMutableListOf;
                anonymousClass1.L$2 = null;
                anonymousClass1.L$3 = null;
                anonymousClass1.L$4 = null;
                anonymousClass1.label = 1;
                objGenerateContent = generativeModel.generateContent(listListOf, anonymousClass1);
                if (objGenerateContent == coroutine_suspended) {
                }
            } catch (Throwable th) {
                th = th;
            }
        } else if (i2 == 1) {
            List list2 = (List) anonymousClass1.L$1;
            chat2 = (Chat) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                list = list2;
                chat = chat2;
                GenerateContentResponse generateContentResponse = (GenerateContentResponse) obj;
                list.add(((Candidate) CollectionsKt.first((List) generateContentResponse.getCandidates())).getContent());
                List<Part> parts = ((Candidate) CollectionsKt.first((List) generateContentResponse.getCandidates())).getContent().getParts();
                arrayList = new ArrayList();
                while (r4.hasNext()) {
                }
                if (arrayList.isEmpty()) {
                }
                chat.history.addAll(list);
                chat.lock.release();
                chat.turns = 0;
                return generateContentResponse;
            } catch (Throwable th2) {
                th = th2;
                chat = chat2;
            }
        } else {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Collection collection = (Collection) anonymousClass1.L$4;
            Iterator it = (Iterator) anonymousClass1.L$3;
            Collection collection2 = (Collection) anonymousClass1.L$2;
            List list3 = (List) anonymousClass1.L$1;
            Chat chat3 = (Chat) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                Iterator it2 = it;
                chat2 = chat3;
                collection.add((FunctionResponsePart) obj);
                collection = collection2;
                listMutableListOf = list3;
                Iterator it3 = it2;
                if (it3.hasNext()) {
                    FunctionCallPart functionCallPart = (FunctionCallPart) it3.next();
                    GenerativeModel generativeModel2 = chat2.model;
                    anonymousClass1.L$0 = chat2;
                    anonymousClass1.L$1 = listMutableListOf;
                    anonymousClass1.L$2 = collection;
                    anonymousClass1.L$3 = it3;
                    anonymousClass1.L$4 = collection;
                    anonymousClass1.label = 2;
                    Object objExecuteFunction$com_google_firebase_ai_logic_firebase_ai = generativeModel2.executeFunction$com_google_firebase_ai_logic_firebase_ai(functionCallPart, anonymousClass1);
                    if (objExecuteFunction$com_google_firebase_ai_logic_firebase_ai != coroutine_suspended) {
                        list3 = listMutableListOf;
                        obj = objExecuteFunction$com_google_firebase_ai_logic_firebase_ai;
                        it2 = it3;
                        collection2 = collection;
                        collection.add((FunctionResponsePart) obj);
                        collection = collection2;
                        listMutableListOf = list3;
                        Iterator it32 = it2;
                        if (it32.hasNext()) {
                            listMutableListOf.add(new Content("function", (List) collection));
                            chat = chat2;
                            GenerativeModel generativeModel3 = chat.model;
                            SpreadBuilder spreadBuilder2 = new SpreadBuilder(2);
                            spreadBuilder2.addSpread(chat.history.toArray(new Content[0]));
                            spreadBuilder2.addSpread(listMutableListOf.toArray(new Content[0]));
                            List<Content> listListOf2 = CollectionsKt.listOf(spreadBuilder2.toArray(new Content[spreadBuilder2.size()]));
                            anonymousClass1.L$0 = chat;
                            anonymousClass1.L$1 = listMutableListOf;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.L$3 = null;
                            anonymousClass1.L$4 = null;
                            anonymousClass1.label = 1;
                            objGenerateContent = generativeModel3.generateContent(listListOf2, anonymousClass1);
                            if (objGenerateContent == coroutine_suspended) {
                                list = listMutableListOf;
                                obj = objGenerateContent;
                                GenerateContentResponse generateContentResponse2 = (GenerateContentResponse) obj;
                                list.add(((Candidate) CollectionsKt.first((List) generateContentResponse2.getCandidates())).getContent());
                                List<Part> parts2 = ((Candidate) CollectionsKt.first((List) generateContentResponse2.getCandidates())).getContent().getParts();
                                arrayList = new ArrayList();
                                for (Object obj2 : parts2) {
                                    if (obj2 instanceof FunctionCallPart) {
                                        arrayList.add(obj2);
                                    }
                                }
                                if (arrayList.isEmpty()) {
                                    int autoFunctionCallingTurnLimit = chat.model.getRequestOptions().getAutoFunctionCallingTurnLimit();
                                    int i3 = chat.turns + 1;
                                    chat.turns = i3;
                                    if (autoFunctionCallingTurnLimit < i3) {
                                        throw new RequestTimeoutException("Request took too many turns", null, list, 2, null);
                                    }
                                    if (!arrayList.isEmpty()) {
                                        Iterator it4 = arrayList.iterator();
                                        while (it4.hasNext()) {
                                            if (!chat.model.hasFunction$com_google_firebase_ai_logic_firebase_ai((FunctionCallPart) it4.next())) {
                                                break;
                                            }
                                        }
                                    }
                                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                                    it32 = arrayList.iterator();
                                    chat2 = chat;
                                    collection = arrayList2;
                                    listMutableListOf = list;
                                    if (it32.hasNext()) {
                                    }
                                }
                                chat.history.addAll(list);
                                chat.lock.release();
                                chat.turns = 0;
                                return generateContentResponse2;
                            }
                        }
                    }
                    return coroutine_suspended;
                }
            } catch (Throwable th3) {
                th = th3;
                chat = chat3;
            }
        }
        chat.lock.release();
        chat.turns = 0;
        throw th;
    }

    public final Object sendMessage(String str, Continuation<? super GenerateContentResponse> continuation) {
        return sendMessage(ContentKt.content$default(null, new Chat$$ExternalSyntheticLambda0(str, 0), 1, null), continuation);
    }
}
