package com.google.firebase.ai.type;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.ModalityTokenCount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001:\u0001 Bs\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000f\u0010\u0010BG\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001a¨\u0006!"}, d2 = {"Lcom/google/firebase/ai/type/UsageMetadata;", "", "promptTokenCount", "", "candidatesTokenCount", "totalTokenCount", "cachedContentTokenCount", "promptTokensDetails", "", "Lcom/google/firebase/ai/type/ModalityTokenCount;", "candidatesTokensDetails", "cacheTokensDetails", "thoughtsTokenCount", "toolUsePromptTokenCount", "toolUsePromptTokensDetails", "<init>", "(ILjava/lang/Integer;IILjava/util/List;Ljava/util/List;Ljava/util/List;IILjava/util/List;)V", "(ILjava/lang/Integer;ILjava/util/List;Ljava/util/List;I)V", "getPromptTokenCount", "()I", "getCandidatesTokenCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalTokenCount", "getCachedContentTokenCount", "getPromptTokensDetails", "()Ljava/util/List;", "getCandidatesTokensDetails", "getCacheTokensDetails", "getThoughtsTokenCount", "getToolUsePromptTokenCount", "getToolUsePromptTokensDetails", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UsageMetadata {
    private final List<ModalityTokenCount> cacheTokensDetails;
    private final int cachedContentTokenCount;
    private final Integer candidatesTokenCount;
    private final List<ModalityTokenCount> candidatesTokensDetails;
    private final int promptTokenCount;
    private final List<ModalityTokenCount> promptTokensDetails;
    private final int thoughtsTokenCount;
    private final int toolUsePromptTokenCount;
    private final List<ModalityTokenCount> toolUsePromptTokensDetails;
    private final int totalTokenCount;

    public UsageMetadata(int i, Integer num, int i2, int i3, List<ModalityTokenCount> list, List<ModalityTokenCount> list2, List<ModalityTokenCount> list3, int i4, int i5, List<ModalityTokenCount> list4) {
        list.getClass();
        list2.getClass();
        list3.getClass();
        list4.getClass();
        this.promptTokenCount = i;
        this.candidatesTokenCount = num;
        this.totalTokenCount = i2;
        this.cachedContentTokenCount = i3;
        this.promptTokensDetails = list;
        this.candidatesTokensDetails = list2;
        this.cacheTokensDetails = list3;
        this.thoughtsTokenCount = i4;
        this.toolUsePromptTokenCount = i5;
        this.toolUsePromptTokensDetails = list4;
    }

    public final List<ModalityTokenCount> getCacheTokensDetails() {
        return this.cacheTokensDetails;
    }

    public final int getCachedContentTokenCount() {
        return this.cachedContentTokenCount;
    }

    public final Integer getCandidatesTokenCount() {
        return this.candidatesTokenCount;
    }

    public final List<ModalityTokenCount> getCandidatesTokensDetails() {
        return this.candidatesTokensDetails;
    }

    public final int getPromptTokenCount() {
        return this.promptTokenCount;
    }

    public final List<ModalityTokenCount> getPromptTokensDetails() {
        return this.promptTokensDetails;
    }

    public final int getThoughtsTokenCount() {
        return this.thoughtsTokenCount;
    }

    public final int getToolUsePromptTokenCount() {
        return this.toolUsePromptTokenCount;
    }

    public final List<ModalityTokenCount> getToolUsePromptTokensDetails() {
        return this.toolUsePromptTokensDetails;
    }

    public final int getTotalTokenCount() {
        return this.totalTokenCount;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UsageMetadata(int i, Integer num, int i2, List<ModalityTokenCount> list, List<ModalityTokenCount> list2, int i3) {
        this(i, num, i2, 0, list, list2, CollectionsKt.emptyList(), i3, 0, CollectionsKt.emptyList());
        list.getClass();
        list2.getClass();
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 @2\u00020\u0001:\u0002?@B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010B\u0097\u0001\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\r\u0010\"\u001a\u00020#H\u0000¢\u0006\u0002\b$J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u009e\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001J%\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0001¢\u0006\u0002\b>R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0016R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001c¨\u0006A"}, d2 = {"Lcom/google/firebase/ai/type/UsageMetadata$Internal;", "", "promptTokenCount", "", "candidatesTokenCount", "totalTokenCount", "cachedContentTokenCount", "promptTokensDetails", "", "Lcom/google/firebase/ai/type/ModalityTokenCount$Internal;", "candidatesTokensDetails", "cacheTokensDetails", "thoughtsTokenCount", "toolUsePromptTokenCount", "toolUsePromptTokensDetails", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPromptTokenCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCandidatesTokenCount", "getTotalTokenCount", "getCachedContentTokenCount", "getPromptTokensDetails", "()Ljava/util/List;", "getCandidatesTokensDetails", "getCacheTokensDetails", "getThoughtsTokenCount", "getToolUsePromptTokenCount", "getToolUsePromptTokensDetails", "toPublic", "Lcom/google/firebase/ai/type/UsageMetadata;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/google/firebase/ai/type/UsageMetadata$Internal;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private static final KSerializer<Object>[] $childSerializers;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<ModalityTokenCount.Internal> cacheTokensDetails;
        private final Integer cachedContentTokenCount;
        private final Integer candidatesTokenCount;
        private final List<ModalityTokenCount.Internal> candidatesTokensDetails;
        private final Integer promptTokenCount;
        private final List<ModalityTokenCount.Internal> promptTokensDetails;
        private final Integer thoughtsTokenCount;
        private final Integer toolUsePromptTokenCount;
        private final List<ModalityTokenCount.Internal> toolUsePromptTokensDetails;
        private final Integer totalTokenCount;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/UsageMetadata$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/UsageMetadata$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return UsageMetadata$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            ModalityTokenCount$Internal$$serializer modalityTokenCount$Internal$$serializer = ModalityTokenCount$Internal$$serializer.INSTANCE;
            $childSerializers = new KSerializer[]{null, null, null, null, new ArrayListSerializer(modalityTokenCount$Internal$$serializer), new ArrayListSerializer(modalityTokenCount$Internal$$serializer), new ArrayListSerializer(modalityTokenCount$Internal$$serializer), null, null, new ArrayListSerializer(modalityTokenCount$Internal$$serializer)};
        }

        public /* synthetic */ Internal(int i, Integer num, Integer num2, Integer num3, Integer num4, List list, List list2, List list3, Integer num5, Integer num6, List list4, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.promptTokenCount = null;
            } else {
                this.promptTokenCount = num;
            }
            if ((i & 2) == 0) {
                this.candidatesTokenCount = null;
            } else {
                this.candidatesTokenCount = num2;
            }
            if ((i & 4) == 0) {
                this.totalTokenCount = null;
            } else {
                this.totalTokenCount = num3;
            }
            if ((i & 8) == 0) {
                this.cachedContentTokenCount = null;
            } else {
                this.cachedContentTokenCount = num4;
            }
            if ((i & 16) == 0) {
                this.promptTokensDetails = null;
            } else {
                this.promptTokensDetails = list;
            }
            if ((i & 32) == 0) {
                this.candidatesTokensDetails = null;
            } else {
                this.candidatesTokensDetails = list2;
            }
            if ((i & 64) == 0) {
                this.cacheTokensDetails = null;
            } else {
                this.cacheTokensDetails = list3;
            }
            if ((i & 128) == 0) {
                this.thoughtsTokenCount = null;
            } else {
                this.thoughtsTokenCount = num5;
            }
            if ((i & 256) == 0) {
                this.toolUsePromptTokenCount = null;
            } else {
                this.toolUsePromptTokenCount = num6;
            }
            if ((i & 512) == 0) {
                this.toolUsePromptTokensDetails = null;
            } else {
                this.toolUsePromptTokensDetails = list4;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, Integer num, Integer num2, Integer num3, Integer num4, List list, List list2, List list3, Integer num5, Integer num6, List list4, int i, Object obj) {
            if ((i & 1) != 0) {
                num = internal.promptTokenCount;
            }
            if ((i & 2) != 0) {
                num2 = internal.candidatesTokenCount;
            }
            if ((i & 4) != 0) {
                num3 = internal.totalTokenCount;
            }
            if ((i & 8) != 0) {
                num4 = internal.cachedContentTokenCount;
            }
            if ((i & 16) != 0) {
                list = internal.promptTokensDetails;
            }
            if ((i & 32) != 0) {
                list2 = internal.candidatesTokensDetails;
            }
            if ((i & 64) != 0) {
                list3 = internal.cacheTokensDetails;
            }
            if ((i & 128) != 0) {
                num5 = internal.thoughtsTokenCount;
            }
            if ((i & 256) != 0) {
                num6 = internal.toolUsePromptTokenCount;
            }
            if ((i & 512) != 0) {
                list4 = internal.toolUsePromptTokensDetails;
            }
            Integer num7 = num6;
            List list5 = list4;
            List list6 = list3;
            Integer num8 = num5;
            List list7 = list;
            List list8 = list2;
            return internal.copy(num, num2, num3, num4, list7, list8, list6, num8, num7, list5);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.promptTokenCount != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.promptTokenCount);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.candidatesTokenCount != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.candidatesTokenCount);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.totalTokenCount != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.totalTokenCount);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.cachedContentTokenCount != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.cachedContentTokenCount);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.promptTokensDetails != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.promptTokensDetails);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.candidatesTokensDetails != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, kSerializerArr[5], self.candidatesTokensDetails);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.cacheTokensDetails != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, kSerializerArr[6], self.cacheTokensDetails);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.thoughtsTokenCount != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, IntSerializer.INSTANCE, self.thoughtsTokenCount);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.toolUsePromptTokenCount != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.toolUsePromptTokenCount);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 9) && self.toolUsePromptTokensDetails == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 9, kSerializerArr[9], self.toolUsePromptTokensDetails);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getPromptTokenCount() {
            return this.promptTokenCount;
        }

        public final List<ModalityTokenCount.Internal> component10() {
            return this.toolUsePromptTokensDetails;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getCandidatesTokenCount() {
            return this.candidatesTokenCount;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getTotalTokenCount() {
            return this.totalTokenCount;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getCachedContentTokenCount() {
            return this.cachedContentTokenCount;
        }

        public final List<ModalityTokenCount.Internal> component5() {
            return this.promptTokensDetails;
        }

        public final List<ModalityTokenCount.Internal> component6() {
            return this.candidatesTokensDetails;
        }

        public final List<ModalityTokenCount.Internal> component7() {
            return this.cacheTokensDetails;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getThoughtsTokenCount() {
            return this.thoughtsTokenCount;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getToolUsePromptTokenCount() {
            return this.toolUsePromptTokenCount;
        }

        public final Internal copy(Integer promptTokenCount, Integer candidatesTokenCount, Integer totalTokenCount, Integer cachedContentTokenCount, List<ModalityTokenCount.Internal> promptTokensDetails, List<ModalityTokenCount.Internal> candidatesTokensDetails, List<ModalityTokenCount.Internal> cacheTokensDetails, Integer thoughtsTokenCount, Integer toolUsePromptTokenCount, List<ModalityTokenCount.Internal> toolUsePromptTokensDetails) {
            return new Internal(promptTokenCount, candidatesTokenCount, totalTokenCount, cachedContentTokenCount, promptTokensDetails, candidatesTokensDetails, cacheTokensDetails, thoughtsTokenCount, toolUsePromptTokenCount, toolUsePromptTokensDetails);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.promptTokenCount, internal.promptTokenCount) && Intrinsics.areEqual(this.candidatesTokenCount, internal.candidatesTokenCount) && Intrinsics.areEqual(this.totalTokenCount, internal.totalTokenCount) && Intrinsics.areEqual(this.cachedContentTokenCount, internal.cachedContentTokenCount) && Intrinsics.areEqual(this.promptTokensDetails, internal.promptTokensDetails) && Intrinsics.areEqual(this.candidatesTokensDetails, internal.candidatesTokensDetails) && Intrinsics.areEqual(this.cacheTokensDetails, internal.cacheTokensDetails) && Intrinsics.areEqual(this.thoughtsTokenCount, internal.thoughtsTokenCount) && Intrinsics.areEqual(this.toolUsePromptTokenCount, internal.toolUsePromptTokenCount) && Intrinsics.areEqual(this.toolUsePromptTokensDetails, internal.toolUsePromptTokensDetails);
        }

        public final List<ModalityTokenCount.Internal> getCacheTokensDetails() {
            return this.cacheTokensDetails;
        }

        public final Integer getCachedContentTokenCount() {
            return this.cachedContentTokenCount;
        }

        public final Integer getCandidatesTokenCount() {
            return this.candidatesTokenCount;
        }

        public final List<ModalityTokenCount.Internal> getCandidatesTokensDetails() {
            return this.candidatesTokensDetails;
        }

        public final Integer getPromptTokenCount() {
            return this.promptTokenCount;
        }

        public final List<ModalityTokenCount.Internal> getPromptTokensDetails() {
            return this.promptTokensDetails;
        }

        public final Integer getThoughtsTokenCount() {
            return this.thoughtsTokenCount;
        }

        public final Integer getToolUsePromptTokenCount() {
            return this.toolUsePromptTokenCount;
        }

        public final List<ModalityTokenCount.Internal> getToolUsePromptTokensDetails() {
            return this.toolUsePromptTokensDetails;
        }

        public final Integer getTotalTokenCount() {
            return this.totalTokenCount;
        }

        public int hashCode() {
            Integer num = this.promptTokenCount;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.candidatesTokenCount;
            int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.totalTokenCount;
            int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.cachedContentTokenCount;
            int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
            List<ModalityTokenCount.Internal> list = this.promptTokensDetails;
            int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
            List<ModalityTokenCount.Internal> list2 = this.candidatesTokensDetails;
            int iHashCode6 = (iHashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
            List<ModalityTokenCount.Internal> list3 = this.cacheTokensDetails;
            int iHashCode7 = (iHashCode6 + (list3 == null ? 0 : list3.hashCode())) * 31;
            Integer num5 = this.thoughtsTokenCount;
            int iHashCode8 = (iHashCode7 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.toolUsePromptTokenCount;
            int iHashCode9 = (iHashCode8 + (num6 == null ? 0 : num6.hashCode())) * 31;
            List<ModalityTokenCount.Internal> list4 = this.toolUsePromptTokensDetails;
            return iHashCode9 + (list4 != null ? list4.hashCode() : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r12v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r8v2, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r9v2, types: [java.util.ArrayList] */
        public final UsageMetadata toPublic$com_google_firebase_ai_logic_firebase_ai() {
            ?? EmptyList;
            ?? EmptyList2;
            ?? EmptyList3;
            ?? EmptyList4;
            Integer num = this.promptTokenCount;
            int iIntValue = num != null ? num.intValue() : 0;
            Integer num2 = this.candidatesTokenCount;
            Integer numValueOf = Integer.valueOf(num2 != null ? num2.intValue() : 0);
            Integer num3 = this.totalTokenCount;
            int iIntValue2 = num3 != null ? num3.intValue() : 0;
            Integer num4 = this.cachedContentTokenCount;
            int iIntValue3 = num4 != null ? num4.intValue() : 0;
            List<ModalityTokenCount.Internal> list = this.promptTokensDetails;
            if (list != null) {
                List<ModalityTokenCount.Internal> list2 = list;
                EmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    EmptyList.add(((ModalityTokenCount.Internal) it.next()).toPublic$com_google_firebase_ai_logic_firebase_ai());
                }
            } else {
                EmptyList = CollectionsKt.emptyList();
            }
            List<ModalityTokenCount.Internal> list3 = this.candidatesTokensDetails;
            if (list3 != null) {
                List<ModalityTokenCount.Internal> list4 = list3;
                EmptyList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                Iterator it2 = list4.iterator();
                while (it2.hasNext()) {
                    EmptyList2.add(((ModalityTokenCount.Internal) it2.next()).toPublic$com_google_firebase_ai_logic_firebase_ai());
                }
            } else {
                EmptyList2 = CollectionsKt.emptyList();
            }
            List<ModalityTokenCount.Internal> list5 = this.cacheTokensDetails;
            if (list5 != null) {
                List<ModalityTokenCount.Internal> list6 = list5;
                EmptyList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                Iterator it3 = list6.iterator();
                while (it3.hasNext()) {
                    EmptyList3.add(((ModalityTokenCount.Internal) it3.next()).toPublic$com_google_firebase_ai_logic_firebase_ai());
                }
            } else {
                EmptyList3 = CollectionsKt.emptyList();
            }
            Integer num5 = this.thoughtsTokenCount;
            int iIntValue4 = num5 != null ? num5.intValue() : 0;
            Integer num6 = this.toolUsePromptTokenCount;
            int iIntValue5 = num6 != null ? num6.intValue() : 0;
            List<ModalityTokenCount.Internal> list7 = this.toolUsePromptTokensDetails;
            if (list7 != null) {
                List<ModalityTokenCount.Internal> list8 = list7;
                EmptyList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
                Iterator it4 = list8.iterator();
                while (it4.hasNext()) {
                    EmptyList4.add(((ModalityTokenCount.Internal) it4.next()).toPublic$com_google_firebase_ai_logic_firebase_ai());
                }
            } else {
                EmptyList4 = CollectionsKt.emptyList();
            }
            return new UsageMetadata(iIntValue, numValueOf, iIntValue2, iIntValue3, EmptyList, EmptyList2, EmptyList3, iIntValue4, iIntValue5, EmptyList4);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(promptTokenCount=");
            sb.append(this.promptTokenCount);
            sb.append(", candidatesTokenCount=");
            sb.append(this.candidatesTokenCount);
            sb.append(", totalTokenCount=");
            sb.append(this.totalTokenCount);
            sb.append(", cachedContentTokenCount=");
            sb.append(this.cachedContentTokenCount);
            sb.append(", promptTokensDetails=");
            sb.append(this.promptTokensDetails);
            sb.append(", candidatesTokensDetails=");
            sb.append(this.candidatesTokensDetails);
            sb.append(", cacheTokensDetails=");
            sb.append(this.cacheTokensDetails);
            sb.append(", thoughtsTokenCount=");
            sb.append(this.thoughtsTokenCount);
            sb.append(", toolUsePromptTokenCount=");
            sb.append(this.toolUsePromptTokenCount);
            sb.append(", toolUsePromptTokensDetails=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.toolUsePromptTokensDetails, ')');
        }

        public Internal() {
            this((Integer) null, (Integer) null, (Integer) null, (Integer) null, (List) null, (List) null, (List) null, (Integer) null, (Integer) null, (List) null, 1023, (DefaultConstructorMarker) null);
        }

        public Internal(Integer num, Integer num2, Integer num3, Integer num4, List<ModalityTokenCount.Internal> list, List<ModalityTokenCount.Internal> list2, List<ModalityTokenCount.Internal> list3, Integer num5, Integer num6, List<ModalityTokenCount.Internal> list4) {
            this.promptTokenCount = num;
            this.candidatesTokenCount = num2;
            this.totalTokenCount = num3;
            this.cachedContentTokenCount = num4;
            this.promptTokensDetails = list;
            this.candidatesTokensDetails = list2;
            this.cacheTokensDetails = list3;
            this.thoughtsTokenCount = num5;
            this.toolUsePromptTokenCount = num6;
            this.toolUsePromptTokensDetails = list4;
        }

        public /* synthetic */ Internal(Integer num, Integer num2, Integer num3, Integer num4, List list, List list2, List list3, Integer num5, Integer num6, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : list2, (i & 64) != 0 ? null : list3, (i & 128) != 0 ? null : num5, (i & 256) != 0 ? null : num6, (i & 512) != 0 ? null : list4);
        }
    }
}
