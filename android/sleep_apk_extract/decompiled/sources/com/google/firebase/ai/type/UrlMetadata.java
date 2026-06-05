package com.google.firebase.ai.type;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.UrlRetrievalStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\fB\u001b\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/google/firebase/ai/type/UrlMetadata;", "", "retrievedUrl", "", "urlRetrievalStatus", "Lcom/google/firebase/ai/type/UrlRetrievalStatus;", "<init>", "(Ljava/lang/String;Lcom/google/firebase/ai/type/UrlRetrievalStatus;)V", "getRetrievedUrl", "()Ljava/lang/String;", "getUrlRetrievalStatus", "()Lcom/google/firebase/ai/type/UrlRetrievalStatus;", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UrlMetadata {
    private final String retrievedUrl;
    private final UrlRetrievalStatus urlRetrievalStatus;

    public UrlMetadata(String str, UrlRetrievalStatus urlRetrievalStatus) {
        urlRetrievalStatus.getClass();
        this.retrievedUrl = str;
        this.urlRetrievalStatus = urlRetrievalStatus;
    }

    public final String getRetrievedUrl() {
        return this.retrievedUrl;
    }

    public final UrlRetrievalStatus getUrlRetrievalStatus() {
        return this.urlRetrievalStatus;
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lcom/google/firebase/ai/type/UrlMetadata$Internal;", "", "retrievedUrl", "", "urlRetrievalStatus", "Lcom/google/firebase/ai/type/UrlRetrievalStatus$Internal;", "<init>", "(Ljava/lang/String;Lcom/google/firebase/ai/type/UrlRetrievalStatus$Internal;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/google/firebase/ai/type/UrlRetrievalStatus$Internal;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRetrievedUrl", "()Ljava/lang/String;", "getUrlRetrievalStatus", "()Lcom/google/firebase/ai/type/UrlRetrievalStatus$Internal;", "toPublic", "Lcom/google/firebase/ai/type/UrlMetadata;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String retrievedUrl;
        private final UrlRetrievalStatus.Internal urlRetrievalStatus;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/UrlMetadata$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/UrlMetadata$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return UrlMetadata$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, String str, UrlRetrievalStatus.Internal internal, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, UrlMetadata$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.retrievedUrl = str;
            this.urlRetrievalStatus = internal;
        }

        public static /* synthetic */ Internal copy$default(Internal internal, String str, UrlRetrievalStatus.Internal internal2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = internal.retrievedUrl;
            }
            if ((i & 2) != 0) {
                internal2 = internal.urlRetrievalStatus;
            }
            return internal.copy(str, internal2);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.retrievedUrl);
            output.encodeSerializableElement(serialDesc, 1, UrlRetrievalStatus.Internal.Serializer.INSTANCE, self.urlRetrievalStatus);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getRetrievedUrl() {
            return this.retrievedUrl;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final UrlRetrievalStatus.Internal getUrlRetrievalStatus() {
            return this.urlRetrievalStatus;
        }

        public final Internal copy(String retrievedUrl, UrlRetrievalStatus.Internal urlRetrievalStatus) {
            urlRetrievalStatus.getClass();
            return new Internal(retrievedUrl, urlRetrievalStatus);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.retrievedUrl, internal.retrievedUrl) && this.urlRetrievalStatus == internal.urlRetrievalStatus;
        }

        public final String getRetrievedUrl() {
            return this.retrievedUrl;
        }

        public final UrlRetrievalStatus.Internal getUrlRetrievalStatus() {
            return this.urlRetrievalStatus;
        }

        public int hashCode() {
            String str = this.retrievedUrl;
            return this.urlRetrievalStatus.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
        }

        public final UrlMetadata toPublic$com_google_firebase_ai_logic_firebase_ai() {
            return new UrlMetadata(this.retrievedUrl, this.urlRetrievalStatus.toPublic$com_google_firebase_ai_logic_firebase_ai());
        }

        public String toString() {
            return "Internal(retrievedUrl=" + this.retrievedUrl + ", urlRetrievalStatus=" + this.urlRetrievalStatus + ')';
        }

        public Internal(String str, UrlRetrievalStatus.Internal internal) {
            internal.getClass();
            this.retrievedUrl = str;
            this.urlRetrievalStatus = internal;
        }
    }
}
