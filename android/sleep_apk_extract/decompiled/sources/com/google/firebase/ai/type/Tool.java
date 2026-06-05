package com.google.firebase.ai.type;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.FunctionDeclaration;
import com.google.firebase.ai.type.GoogleSearch;
import com.google.firebase.ai.type.UrlContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cBO\b\u0000\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aR\u001c\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0005\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/google/firebase/ai/type/Tool;", "", "functionDeclarations", "", "Lcom/google/firebase/ai/type/FunctionDeclaration;", "autoFunctionDeclarations", "Lcom/google/firebase/ai/type/AutoFunctionDeclaration;", "googleSearch", "Lcom/google/firebase/ai/type/GoogleSearch;", "codeExecution", "Lkotlinx/serialization/json/JsonObject;", "urlContext", "Lcom/google/firebase/ai/type/UrlContext;", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/google/firebase/ai/type/GoogleSearch;Lkotlinx/serialization/json/JsonObject;Lcom/google/firebase/ai/type/UrlContext;)V", "getFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai", "()Ljava/util/List;", "getAutoFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai", "getGoogleSearch$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/GoogleSearch;", "getCodeExecution$com_google_firebase_ai_logic_firebase_ai", "()Lkotlinx/serialization/json/JsonObject;", "getUrlContext$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/UrlContext;", "toInternal", "Lcom/google/firebase/ai/type/Tool$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "Internal", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Tool {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<Tool> codeExecutionInstance$delegate = LazyKt.lazy(new Tool$$ExternalSyntheticLambda0(0));
    private final List<AutoFunctionDeclaration<?, ?>> autoFunctionDeclarations;
    private final JsonObject codeExecution;
    private final List<FunctionDeclaration> functionDeclarations;
    private final GoogleSearch googleSearch;
    private final UrlContext urlContext;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J2\u0010\u000b\u001a\u00020\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0016\u0010\u000e\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f\u0018\u00010\fH\u0007J\b\u0010\u0010\u001a\u00020\u0005H\u0007J\u0012\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007R!\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/google/firebase/ai/type/Tool$Companion;", "", "<init>", "()V", "codeExecutionInstance", "Lcom/google/firebase/ai/type/Tool;", "getCodeExecutionInstance$annotations", "getCodeExecutionInstance", "()Lcom/google/firebase/ai/type/Tool;", "codeExecutionInstance$delegate", "Lkotlin/Lazy;", "functionDeclarations", "", "Lcom/google/firebase/ai/type/FunctionDeclaration;", "autoFunctionDeclarations", "Lcom/google/firebase/ai/type/AutoFunctionDeclaration;", "codeExecution", "urlContext", "Lcom/google/firebase/ai/type/UrlContext;", "googleSearch", "Lcom/google/firebase/ai/type/GoogleSearch;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Tool functionDeclarations$default(Companion companion, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = null;
            }
            return companion.functionDeclarations(list, list2);
        }

        private final Tool getCodeExecutionInstance() {
            return (Tool) Tool.codeExecutionInstance$delegate.getValue();
        }

        private static /* synthetic */ void getCodeExecutionInstance$annotations() {
        }

        public static /* synthetic */ Tool googleSearch$default(Companion companion, GoogleSearch googleSearch, int i, Object obj) {
            if ((i & 1) != 0) {
                googleSearch = new GoogleSearch();
            }
            return companion.googleSearch(googleSearch);
        }

        public static /* synthetic */ Tool urlContext$default(Companion companion, UrlContext urlContext, int i, Object obj) {
            if ((i & 1) != 0) {
                urlContext = new UrlContext();
            }
            return companion.urlContext(urlContext);
        }

        public final Tool codeExecution() {
            return getCodeExecutionInstance();
        }

        public final Tool functionDeclarations(List<FunctionDeclaration> functionDeclarations) {
            functionDeclarations.getClass();
            return new Tool(functionDeclarations, null, null, null, null);
        }

        public final Tool googleSearch(GoogleSearch googleSearch) {
            googleSearch.getClass();
            return new Tool(null, null, googleSearch, null, null);
        }

        public final Tool urlContext(UrlContext urlContext) {
            urlContext.getClass();
            return new Tool(null, null, null, null, urlContext);
        }

        private Companion() {
        }

        public final Tool functionDeclarations(List<FunctionDeclaration> functionDeclarations, List<? extends AutoFunctionDeclaration<?, ?>> autoFunctionDeclarations) {
            return new Tool(functionDeclarations, autoFunctionDeclarations, null, null, null);
        }

        public final Tool googleSearch() {
            return googleSearch$default(this, null, 1, null);
        }

        public final Tool urlContext() {
            return urlContext$default(this, null, 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Tool(List<FunctionDeclaration> list, List<? extends AutoFunctionDeclaration<?, ?>> list2, GoogleSearch googleSearch, JsonObject jsonObject, UrlContext urlContext) {
        this.functionDeclarations = list;
        this.autoFunctionDeclarations = list2;
        this.googleSearch = googleSearch;
        this.codeExecution = jsonObject;
        this.urlContext = urlContext;
    }

    public static final Tool codeExecution() {
        return INSTANCE.codeExecution();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Tool codeExecutionInstance_delegate$lambda$5() {
        return new Tool(null, null, null, new JsonObject(MapsKt.emptyMap()), null);
    }

    public static final Tool functionDeclarations(List<FunctionDeclaration> list) {
        return INSTANCE.functionDeclarations(list);
    }

    public static final Tool googleSearch() {
        return INSTANCE.googleSearch();
    }

    public static final Tool urlContext() {
        return INSTANCE.urlContext();
    }

    public final List<AutoFunctionDeclaration<?, ?>> getAutoFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai() {
        return this.autoFunctionDeclarations;
    }

    /* JADX INFO: renamed from: getCodeExecution$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final JsonObject getCodeExecution() {
        return this.codeExecution;
    }

    public final List<FunctionDeclaration> getFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai() {
        return this.functionDeclarations;
    }

    /* JADX INFO: renamed from: getGoogleSearch$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final GoogleSearch getGoogleSearch() {
        return this.googleSearch;
    }

    /* JADX INFO: renamed from: getUrlContext$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final UrlContext getUrlContext() {
        return this.urlContext;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        List<FunctionDeclaration> list = this.functionDeclarations;
        if (list != null) {
            List<FunctionDeclaration> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((FunctionDeclaration) it.next()).toInternal$com_google_firebase_ai_logic_firebase_ai());
            }
            listCreateListBuilder.addAll(arrayList);
        }
        List<AutoFunctionDeclaration<?, ?>> list3 = this.autoFunctionDeclarations;
        if (list3 != null) {
            List<AutoFunctionDeclaration<?, ?>> list4 = list3;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((AutoFunctionDeclaration) it2.next()).toInternal$com_google_firebase_ai_logic_firebase_ai());
            }
            listCreateListBuilder.addAll(arrayList2);
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        GoogleSearch googleSearch = this.googleSearch;
        GoogleSearch.Internal internal$com_google_firebase_ai_logic_firebase_ai = googleSearch != null ? googleSearch.toInternal$com_google_firebase_ai_logic_firebase_ai() : null;
        JsonObject jsonObject = this.codeExecution;
        UrlContext urlContext = this.urlContext;
        return new Internal(listBuild, internal$com_google_firebase_ai_logic_firebase_ai, jsonObject, urlContext != null ? urlContext.toInternal$com_google_firebase_ai_logic_firebase_ai() : null);
    }

    public static final Tool functionDeclarations(List<FunctionDeclaration> list, List<? extends AutoFunctionDeclaration<?, ?>> list2) {
        return INSTANCE.functionDeclarations(list, list2);
    }

    public static final Tool googleSearch(GoogleSearch googleSearch) {
        return INSTANCE.googleSearch(googleSearch);
    }

    public static final Tool urlContext(UrlContext urlContext) {
        return INSTANCE.urlContext(urlContext);
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 .2\u00020\u0001:\u0002-.B=\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBI\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\u001e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u000eHÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lcom/google/firebase/ai/type/Tool$Internal;", "", "functionDeclarations", "", "Lcom/google/firebase/ai/type/FunctionDeclaration$Internal;", "googleSearch", "Lcom/google/firebase/ai/type/GoogleSearch$Internal;", "codeExecution", "Lkotlinx/serialization/json/JsonObject;", "urlContext", "Lcom/google/firebase/ai/type/UrlContext$Internal;", "<init>", "(Ljava/util/List;Lcom/google/firebase/ai/type/GoogleSearch$Internal;Lkotlinx/serialization/json/JsonObject;Lcom/google/firebase/ai/type/UrlContext$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lcom/google/firebase/ai/type/GoogleSearch$Internal;Lkotlinx/serialization/json/JsonObject;Lcom/google/firebase/ai/type/UrlContext$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFunctionDeclarations", "()Ljava/util/List;", "getGoogleSearch", "()Lcom/google/firebase/ai/type/GoogleSearch$Internal;", "getCodeExecution", "()Lkotlinx/serialization/json/JsonObject;", "getUrlContext", "()Lcom/google/firebase/ai/type/UrlContext$Internal;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private final JsonObject codeExecution;
        private final List<FunctionDeclaration.Internal> functionDeclarations;
        private final GoogleSearch.Internal googleSearch;
        private final UrlContext.Internal urlContext;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(FunctionDeclaration$Internal$$serializer.INSTANCE), null, null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/Tool$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/Tool$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return Tool$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, List list, GoogleSearch.Internal internal, JsonObject jsonObject, UrlContext.Internal internal2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.functionDeclarations = null;
            } else {
                this.functionDeclarations = list;
            }
            if ((i & 2) == 0) {
                this.googleSearch = null;
            } else {
                this.googleSearch = internal;
            }
            if ((i & 4) == 0) {
                this.codeExecution = null;
            } else {
                this.codeExecution = jsonObject;
            }
            if ((i & 8) == 0) {
                this.urlContext = null;
            } else {
                this.urlContext = internal2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, List list, GoogleSearch.Internal internal2, JsonObject jsonObject, UrlContext.Internal internal3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = internal.functionDeclarations;
            }
            if ((i & 2) != 0) {
                internal2 = internal.googleSearch;
            }
            if ((i & 4) != 0) {
                jsonObject = internal.codeExecution;
            }
            if ((i & 8) != 0) {
                internal3 = internal.urlContext;
            }
            return internal.copy(list, internal2, jsonObject, internal3);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.functionDeclarations != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.functionDeclarations);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.googleSearch != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, GoogleSearch$Internal$$serializer.INSTANCE, self.googleSearch);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.codeExecution != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, JsonObjectSerializer.INSTANCE, self.codeExecution);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.urlContext == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 3, UrlContext$Internal$$serializer.INSTANCE, self.urlContext);
        }

        public final List<FunctionDeclaration.Internal> component1() {
            return this.functionDeclarations;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final GoogleSearch.Internal getGoogleSearch() {
            return this.googleSearch;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final JsonObject getCodeExecution() {
            return this.codeExecution;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final UrlContext.Internal getUrlContext() {
            return this.urlContext;
        }

        public final Internal copy(List<FunctionDeclaration.Internal> functionDeclarations, GoogleSearch.Internal googleSearch, JsonObject codeExecution, UrlContext.Internal urlContext) {
            return new Internal(functionDeclarations, googleSearch, codeExecution, urlContext);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.functionDeclarations, internal.functionDeclarations) && Intrinsics.areEqual(this.googleSearch, internal.googleSearch) && Intrinsics.areEqual(this.codeExecution, internal.codeExecution) && Intrinsics.areEqual(this.urlContext, internal.urlContext);
        }

        public final JsonObject getCodeExecution() {
            return this.codeExecution;
        }

        public final List<FunctionDeclaration.Internal> getFunctionDeclarations() {
            return this.functionDeclarations;
        }

        public final GoogleSearch.Internal getGoogleSearch() {
            return this.googleSearch;
        }

        public final UrlContext.Internal getUrlContext() {
            return this.urlContext;
        }

        public int hashCode() {
            List<FunctionDeclaration.Internal> list = this.functionDeclarations;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            GoogleSearch.Internal internal = this.googleSearch;
            int iHashCode2 = (iHashCode + (internal == null ? 0 : internal.hashCode())) * 31;
            JsonObject jsonObject = this.codeExecution;
            int iHashCode3 = (iHashCode2 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
            UrlContext.Internal internal2 = this.urlContext;
            return iHashCode3 + (internal2 != null ? internal2.hashCode() : 0);
        }

        public String toString() {
            return "Internal(functionDeclarations=" + this.functionDeclarations + ", googleSearch=" + this.googleSearch + ", codeExecution=" + this.codeExecution + ", urlContext=" + this.urlContext + ')';
        }

        public Internal() {
            this((List) null, (GoogleSearch.Internal) null, (JsonObject) null, (UrlContext.Internal) null, 15, (DefaultConstructorMarker) null);
        }

        public Internal(List<FunctionDeclaration.Internal> list, GoogleSearch.Internal internal, JsonObject jsonObject, UrlContext.Internal internal2) {
            this.functionDeclarations = list;
            this.googleSearch = internal;
            this.codeExecution = jsonObject;
            this.urlContext = internal2;
        }

        public /* synthetic */ Internal(List list, GoogleSearch.Internal internal, JsonObject jsonObject, UrlContext.Internal internal2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : internal, (i & 4) != 0 ? null : jsonObject, (i & 8) != 0 ? null : internal2);
        }
    }
}
