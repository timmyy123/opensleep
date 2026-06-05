package com.google.firebase.ai.type;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.ai.type.WebGroundingChunk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\bB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/google/firebase/ai/type/GroundingChunk;", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB, "Lcom/google/firebase/ai/type/WebGroundingChunk;", "<init>", "(Lcom/google/firebase/ai/type/WebGroundingChunk;)V", "getWeb", "()Lcom/google/firebase/ai/type/WebGroundingChunk;", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GroundingChunk {
    private final WebGroundingChunk web;

    public GroundingChunk(WebGroundingChunk webGroundingChunk) {
        this.web = webGroundingChunk;
    }

    public final WebGroundingChunk getWeb() {
        return this.web;
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\r\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Lcom/google/firebase/ai/type/GroundingChunk$Internal;", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB, "Lcom/google/firebase/ai/type/WebGroundingChunk$Internal;", "<init>", "(Lcom/google/firebase/ai/type/WebGroundingChunk$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/WebGroundingChunk$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWeb", "()Lcom/google/firebase/ai/type/WebGroundingChunk$Internal;", "toPublic", "Lcom/google/firebase/ai/type/GroundingChunk;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final WebGroundingChunk.Internal web;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/GroundingChunk$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/GroundingChunk$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return GroundingChunk$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, WebGroundingChunk.Internal internal, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, GroundingChunk$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.web = internal;
        }

        public static /* synthetic */ Internal copy$default(Internal internal, WebGroundingChunk.Internal internal2, int i, Object obj) {
            if ((i & 1) != 0) {
                internal2 = internal.web;
            }
            return internal.copy(internal2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final WebGroundingChunk.Internal getWeb() {
            return this.web;
        }

        public final Internal copy(WebGroundingChunk.Internal web) {
            return new Internal(web);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Internal) && Intrinsics.areEqual(this.web, ((Internal) other).web);
        }

        public final WebGroundingChunk.Internal getWeb() {
            return this.web;
        }

        public int hashCode() {
            WebGroundingChunk.Internal internal = this.web;
            if (internal == null) {
                return 0;
            }
            return internal.hashCode();
        }

        public final GroundingChunk toPublic$com_google_firebase_ai_logic_firebase_ai() {
            WebGroundingChunk.Internal internal = this.web;
            return new GroundingChunk(internal != null ? internal.toPublic$com_google_firebase_ai_logic_firebase_ai() : null);
        }

        public String toString() {
            return "Internal(web=" + this.web + ')';
        }

        public Internal(WebGroundingChunk.Internal internal) {
            this.web = internal;
        }
    }
}
