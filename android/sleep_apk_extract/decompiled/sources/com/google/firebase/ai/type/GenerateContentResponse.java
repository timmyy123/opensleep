package com.google.firebase.ai.type;

import androidx.work.Data$$ExternalSyntheticLambda0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.InferenceSource;
import com.google.firebase.ai.type.Candidate;
import com.google.firebase.ai.type.PromptFeedback;
import com.google.firebase.ai.type.UsageMetadata;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001*B3\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB+\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\rJ\u0012\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0003*\u00020\u0004H\u0002J\u0012\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u0003*\u00020\u0004H\u0002R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u001e\u0010\u000fR\u001d\u0010 \u001a\u0004\u0018\u00010\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b!\u0010\u0019R!\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b%\u0010\u000f¨\u0006+"}, d2 = {"Lcom/google/firebase/ai/type/GenerateContentResponse;", "", "candidates", "", "Lcom/google/firebase/ai/type/Candidate;", "inferenceSource", "Lcom/google/firebase/ai/InferenceSource;", "promptFeedback", "Lcom/google/firebase/ai/type/PromptFeedback;", "usageMetadata", "Lcom/google/firebase/ai/type/UsageMetadata;", "<init>", "(Ljava/util/List;Lcom/google/firebase/ai/InferenceSource;Lcom/google/firebase/ai/type/PromptFeedback;Lcom/google/firebase/ai/type/UsageMetadata;)V", "(Ljava/util/List;Lcom/google/firebase/ai/type/PromptFeedback;Lcom/google/firebase/ai/type/UsageMetadata;)V", "getCandidates", "()Ljava/util/List;", "getInferenceSource", "()Lcom/google/firebase/ai/InferenceSource;", "getPromptFeedback", "()Lcom/google/firebase/ai/type/PromptFeedback;", "getUsageMetadata", "()Lcom/google/firebase/ai/type/UsageMetadata;", "text", "", "getText", "()Ljava/lang/String;", "text$delegate", "Lkotlin/Lazy;", "functionCalls", "Lcom/google/firebase/ai/type/FunctionCallPart;", "getFunctionCalls", "functionCalls$delegate", "thoughtSummary", "getThoughtSummary", "thoughtSummary$delegate", "inlineDataParts", "Lcom/google/firebase/ai/type/InlineDataPart;", "getInlineDataParts", "inlineDataParts$delegate", "thoughtParts", "Lcom/google/firebase/ai/type/Part;", "nonThoughtParts", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GenerateContentResponse {
    private final List<Candidate> candidates;

    /* JADX INFO: renamed from: functionCalls$delegate, reason: from kotlin metadata */
    private final Lazy functionCalls;
    private final InferenceSource inferenceSource;

    /* JADX INFO: renamed from: inlineDataParts$delegate, reason: from kotlin metadata */
    private final Lazy inlineDataParts;
    private final PromptFeedback promptFeedback;

    /* JADX INFO: renamed from: text$delegate, reason: from kotlin metadata */
    private final Lazy text;

    /* JADX INFO: renamed from: thoughtSummary$delegate, reason: from kotlin metadata */
    private final Lazy thoughtSummary;
    private final UsageMetadata usageMetadata;

    public GenerateContentResponse(List<Candidate> list, InferenceSource inferenceSource, PromptFeedback promptFeedback, UsageMetadata usageMetadata) {
        list.getClass();
        inferenceSource.getClass();
        this.candidates = list;
        this.inferenceSource = inferenceSource;
        this.promptFeedback = promptFeedback;
        this.usageMetadata = usageMetadata;
        final int i = 0;
        this.text = LazyKt.lazy(new Function0(this) { // from class: com.google.firebase.ai.type.GenerateContentResponse$$ExternalSyntheticLambda2
            public final /* synthetic */ GenerateContentResponse f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2 = i;
                GenerateContentResponse generateContentResponse = this.f$0;
                switch (i2) {
                    case 0:
                        return GenerateContentResponse.text_delegate$lambda$1(generateContentResponse);
                    case 1:
                        return GenerateContentResponse.functionCalls_delegate$lambda$2(generateContentResponse);
                    case 2:
                        return GenerateContentResponse.thoughtSummary_delegate$lambda$4(generateContentResponse);
                    default:
                        return GenerateContentResponse.inlineDataParts_delegate$lambda$7(generateContentResponse);
                }
            }
        });
        final int i2 = 1;
        this.functionCalls = LazyKt.lazy(new Function0(this) { // from class: com.google.firebase.ai.type.GenerateContentResponse$$ExternalSyntheticLambda2
            public final /* synthetic */ GenerateContentResponse f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i2;
                GenerateContentResponse generateContentResponse = this.f$0;
                switch (i22) {
                    case 0:
                        return GenerateContentResponse.text_delegate$lambda$1(generateContentResponse);
                    case 1:
                        return GenerateContentResponse.functionCalls_delegate$lambda$2(generateContentResponse);
                    case 2:
                        return GenerateContentResponse.thoughtSummary_delegate$lambda$4(generateContentResponse);
                    default:
                        return GenerateContentResponse.inlineDataParts_delegate$lambda$7(generateContentResponse);
                }
            }
        });
        final int i3 = 2;
        this.thoughtSummary = LazyKt.lazy(new Function0(this) { // from class: com.google.firebase.ai.type.GenerateContentResponse$$ExternalSyntheticLambda2
            public final /* synthetic */ GenerateContentResponse f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i3;
                GenerateContentResponse generateContentResponse = this.f$0;
                switch (i22) {
                    case 0:
                        return GenerateContentResponse.text_delegate$lambda$1(generateContentResponse);
                    case 1:
                        return GenerateContentResponse.functionCalls_delegate$lambda$2(generateContentResponse);
                    case 2:
                        return GenerateContentResponse.thoughtSummary_delegate$lambda$4(generateContentResponse);
                    default:
                        return GenerateContentResponse.inlineDataParts_delegate$lambda$7(generateContentResponse);
                }
            }
        });
        final int i4 = 3;
        this.inlineDataParts = LazyKt.lazy(new Function0(this) { // from class: com.google.firebase.ai.type.GenerateContentResponse$$ExternalSyntheticLambda2
            public final /* synthetic */ GenerateContentResponse f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i4;
                GenerateContentResponse generateContentResponse = this.f$0;
                switch (i22) {
                    case 0:
                        return GenerateContentResponse.text_delegate$lambda$1(generateContentResponse);
                    case 1:
                        return GenerateContentResponse.functionCalls_delegate$lambda$2(generateContentResponse);
                    case 2:
                        return GenerateContentResponse.thoughtSummary_delegate$lambda$4(generateContentResponse);
                    default:
                        return GenerateContentResponse.inlineDataParts_delegate$lambda$7(generateContentResponse);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List functionCalls_delegate$lambda$2(GenerateContentResponse generateContentResponse) {
        ArrayList arrayList;
        List<Part> listNonThoughtParts;
        Candidate candidate = (Candidate) CollectionsKt.firstOrNull((List) generateContentResponse.candidates);
        if (candidate == null || (listNonThoughtParts = generateContentResponse.nonThoughtParts(candidate)) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object obj : listNonThoughtParts) {
                if (obj instanceof FunctionCallPart) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List inlineDataParts_delegate$lambda$7(GenerateContentResponse generateContentResponse) {
        List listPlus;
        List<Part> listNonThoughtParts;
        Candidate candidate = (Candidate) CollectionsKt.firstOrNull((List) generateContentResponse.candidates);
        if (candidate == null || (listNonThoughtParts = generateContentResponse.nonThoughtParts(candidate)) == null) {
            listPlus = null;
        } else {
            List<Part> list = listNonThoughtParts;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof ImagePart) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ImagePart) it.next()).toInlineDataPart$com_google_firebase_ai_logic_firebase_ai());
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : list) {
                if (obj2 instanceof InlineDataPart) {
                    arrayList3.add(obj2);
                }
            }
            listPlus = CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3);
        }
        return listPlus == null ? CollectionsKt.emptyList() : listPlus;
    }

    private final List<Part> nonThoughtParts(Candidate candidate) {
        List<Part> parts = candidate.getContent().getParts();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parts) {
            if (!((Part) obj).getIsThought()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String text_delegate$lambda$1(GenerateContentResponse generateContentResponse) {
        ArrayList arrayList;
        List<Part> listNonThoughtParts;
        Candidate candidate = (Candidate) CollectionsKt.firstOrNull((List) generateContentResponse.candidates);
        if (candidate == null || (listNonThoughtParts = generateContentResponse.nonThoughtParts(candidate)) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : listNonThoughtParts) {
                if (obj instanceof TextPart) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, new Data$$ExternalSyntheticLambda0(20), 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence text_delegate$lambda$1$lambda$0(TextPart textPart) {
        textPart.getClass();
        return textPart.getText();
    }

    private final List<Part> thoughtParts(Candidate candidate) {
        List<Part> parts = candidate.getContent().getParts();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parts) {
            if (((Part) obj).getIsThought()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String thoughtSummary_delegate$lambda$4(GenerateContentResponse generateContentResponse) {
        List<Part> listThoughtParts;
        Candidate candidate = (Candidate) CollectionsKt.firstOrNull((List) generateContentResponse.candidates);
        if (candidate == null || (listThoughtParts = generateContentResponse.thoughtParts(candidate)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listThoughtParts) {
            if (obj instanceof TextPart) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, new Data$$ExternalSyntheticLambda0(19), 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence thoughtSummary_delegate$lambda$4$lambda$3(TextPart textPart) {
        textPart.getClass();
        return textPart.getText();
    }

    public final List<Candidate> getCandidates() {
        return this.candidates;
    }

    public final List<FunctionCallPart> getFunctionCalls() {
        return (List) this.functionCalls.getValue();
    }

    public final InferenceSource getInferenceSource() {
        return this.inferenceSource;
    }

    public final List<InlineDataPart> getInlineDataParts() {
        return (List) this.inlineDataParts.getValue();
    }

    public final PromptFeedback getPromptFeedback() {
        return this.promptFeedback;
    }

    public final String getText() {
        return (String) this.text.getValue();
    }

    public final String getThoughtSummary() {
        return (String) this.thoughtSummary.getValue();
    }

    public final UsageMetadata getUsageMetadata() {
        return this.usageMetadata;
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 -2\u00020\u0001:\u0002,-B1\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\r\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\fHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006."}, d2 = {"Lcom/google/firebase/ai/type/GenerateContentResponse$Internal;", "Lcom/google/firebase/ai/type/Response;", "candidates", "", "Lcom/google/firebase/ai/type/Candidate$Internal;", "promptFeedback", "Lcom/google/firebase/ai/type/PromptFeedback$Internal;", "usageMetadata", "Lcom/google/firebase/ai/type/UsageMetadata$Internal;", "<init>", "(Ljava/util/List;Lcom/google/firebase/ai/type/PromptFeedback$Internal;Lcom/google/firebase/ai/type/UsageMetadata$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lcom/google/firebase/ai/type/PromptFeedback$Internal;Lcom/google/firebase/ai/type/UsageMetadata$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCandidates", "()Ljava/util/List;", "getPromptFeedback", "()Lcom/google/firebase/ai/type/PromptFeedback$Internal;", "getUsageMetadata", "()Lcom/google/firebase/ai/type/UsageMetadata$Internal;", "toPublic", "Lcom/google/firebase/ai/type/GenerateContentResponse;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal implements Response {
        private final List<Candidate.Internal> candidates;
        private final PromptFeedback.Internal promptFeedback;
        private final UsageMetadata.Internal usageMetadata;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(Candidate$Internal$$serializer.INSTANCE), null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/GenerateContentResponse$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/GenerateContentResponse$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return GenerateContentResponse$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, List list, PromptFeedback.Internal internal, UsageMetadata.Internal internal2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.candidates = null;
            } else {
                this.candidates = list;
            }
            if ((i & 2) == 0) {
                this.promptFeedback = null;
            } else {
                this.promptFeedback = internal;
            }
            if ((i & 4) == 0) {
                this.usageMetadata = null;
            } else {
                this.usageMetadata = internal2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, List list, PromptFeedback.Internal internal2, UsageMetadata.Internal internal3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = internal.candidates;
            }
            if ((i & 2) != 0) {
                internal2 = internal.promptFeedback;
            }
            if ((i & 4) != 0) {
                internal3 = internal.usageMetadata;
            }
            return internal.copy(list, internal2, internal3);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.candidates != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.candidates);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.promptFeedback != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, PromptFeedback$Internal$$serializer.INSTANCE, self.promptFeedback);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.usageMetadata == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, UsageMetadata$Internal$$serializer.INSTANCE, self.usageMetadata);
        }

        public final List<Candidate.Internal> component1() {
            return this.candidates;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PromptFeedback.Internal getPromptFeedback() {
            return this.promptFeedback;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final UsageMetadata.Internal getUsageMetadata() {
            return this.usageMetadata;
        }

        public final Internal copy(List<Candidate.Internal> candidates, PromptFeedback.Internal promptFeedback, UsageMetadata.Internal usageMetadata) {
            return new Internal(candidates, promptFeedback, usageMetadata);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.candidates, internal.candidates) && Intrinsics.areEqual(this.promptFeedback, internal.promptFeedback) && Intrinsics.areEqual(this.usageMetadata, internal.usageMetadata);
        }

        public final List<Candidate.Internal> getCandidates() {
            return this.candidates;
        }

        public final PromptFeedback.Internal getPromptFeedback() {
            return this.promptFeedback;
        }

        public final UsageMetadata.Internal getUsageMetadata() {
            return this.usageMetadata;
        }

        public int hashCode() {
            List<Candidate.Internal> list = this.candidates;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            PromptFeedback.Internal internal = this.promptFeedback;
            int iHashCode2 = (iHashCode + (internal == null ? 0 : internal.hashCode())) * 31;
            UsageMetadata.Internal internal2 = this.usageMetadata;
            return iHashCode2 + (internal2 != null ? internal2.hashCode() : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList] */
        public final GenerateContentResponse toPublic$com_google_firebase_ai_logic_firebase_ai() {
            List listEmptyList;
            List<Candidate.Internal> list = this.candidates;
            if (list != null) {
                List<Candidate.Internal> list2 = list;
                listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    listEmptyList.add(((Candidate.Internal) it.next()).toPublic$com_google_firebase_ai_logic_firebase_ai());
                }
            } else {
                listEmptyList = 0;
            }
            if (listEmptyList == 0) {
                listEmptyList = CollectionsKt.emptyList();
            }
            InferenceSource inferenceSource = InferenceSource.IN_CLOUD;
            PromptFeedback.Internal internal = this.promptFeedback;
            PromptFeedback public$com_google_firebase_ai_logic_firebase_ai = internal != null ? internal.toPublic$com_google_firebase_ai_logic_firebase_ai() : null;
            UsageMetadata.Internal internal2 = this.usageMetadata;
            return new GenerateContentResponse(listEmptyList, inferenceSource, public$com_google_firebase_ai_logic_firebase_ai, internal2 != null ? internal2.toPublic$com_google_firebase_ai_logic_firebase_ai() : null);
        }

        public String toString() {
            return "Internal(candidates=" + this.candidates + ", promptFeedback=" + this.promptFeedback + ", usageMetadata=" + this.usageMetadata + ')';
        }

        public Internal() {
            this((List) null, (PromptFeedback.Internal) null, (UsageMetadata.Internal) null, 7, (DefaultConstructorMarker) null);
        }

        public Internal(List<Candidate.Internal> list, PromptFeedback.Internal internal, UsageMetadata.Internal internal2) {
            this.candidates = list;
            this.promptFeedback = internal;
            this.usageMetadata = internal2;
        }

        public /* synthetic */ Internal(List list, PromptFeedback.Internal internal, UsageMetadata.Internal internal2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : internal, (i & 4) != 0 ? null : internal2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GenerateContentResponse(List<Candidate> list, PromptFeedback promptFeedback, UsageMetadata usageMetadata) {
        this(list, InferenceSource.IN_CLOUD, promptFeedback, usageMetadata);
        list.getClass();
    }
}
