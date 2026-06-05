package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u0010B+\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/google/firebase/ai/type/FileDataPart;", "Lcom/google/firebase/ai/type/Part;", ShareConstants.MEDIA_URI, "", "mimeType", "isThought", "", "thoughtSignature", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "getMimeType", "()Z", "getThoughtSignature$com_google_firebase_ai_logic_firebase_ai", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileDataPart implements Part {
    private final boolean isThought;
    private final String mimeType;
    private final String thoughtSignature;
    private final String uri;

    public FileDataPart(String str, String str2, boolean z, String str3) {
        str.getClass();
        str2.getClass();
        this.uri = str;
        this.mimeType = str2;
        this.isThought = z;
        this.thoughtSignature = str3;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    /* JADX INFO: renamed from: getThoughtSignature$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getThoughtSignature() {
        return this.thoughtSignature;
    }

    public final String getUri() {
        return this.uri;
    }

    @Override // com.google.firebase.ai.type.Part
    /* JADX INFO: renamed from: isThought, reason: from getter */
    public boolean getIsThought() {
        return this.isThought;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileDataPart(String str, String str2) {
        this(str, str2, false, null);
        str.getClass();
        str2.getClass();
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 ,2\u00020\u0001:\u0003*+,B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006-"}, d2 = {"Lcom/google/firebase/ai/type/FileDataPart$Internal;", "Lcom/google/firebase/ai/type/InternalPart;", "fileData", "Lcom/google/firebase/ai/type/FileDataPart$Internal$FileData;", "thought", "", "thoughtSignature", "", "<init>", "(Lcom/google/firebase/ai/type/FileDataPart$Internal$FileData;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/FileDataPart$Internal$FileData;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFileData$annotations", "()V", "getFileData", "()Lcom/google/firebase/ai/type/FileDataPart$Internal$FileData;", "getThought", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getThoughtSignature", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Lcom/google/firebase/ai/type/FileDataPart$Internal$FileData;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/google/firebase/ai/type/FileDataPart$Internal;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "FileData", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal implements InternalPart {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final FileData fileData;
        private final Boolean thought;
        private final String thoughtSignature;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/FileDataPart$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/FileDataPart$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return FileDataPart$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, FileData fileData, Boolean bool, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, FileDataPart$Internal$$serializer.INSTANCE.getDescriptor());
            }
            this.fileData = fileData;
            if ((i & 2) == 0) {
                this.thought = null;
            } else {
                this.thought = bool;
            }
            if ((i & 4) == 0) {
                this.thoughtSignature = null;
            } else {
                this.thoughtSignature = str;
            }
        }

        public static /* synthetic */ Internal copy$default(Internal internal, FileData fileData, Boolean bool, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                fileData = internal.fileData;
            }
            if ((i & 2) != 0) {
                bool = internal.thought;
            }
            if ((i & 4) != 0) {
                str = internal.thoughtSignature;
            }
            return internal.copy(fileData, bool, str);
        }

        @SerialName("file_data")
        public static /* synthetic */ void getFileData$annotations() {
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, FileDataPart$Internal$FileData$$serializer.INSTANCE, self.fileData);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.thought != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.thought);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.thoughtSignature == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.thoughtSignature);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileData getFileData() {
            return this.fileData;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getThought() {
            return this.thought;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getThoughtSignature() {
            return this.thoughtSignature;
        }

        public final Internal copy(FileData fileData, Boolean thought, String thoughtSignature) {
            fileData.getClass();
            return new Internal(fileData, thought, thoughtSignature);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.fileData, internal.fileData) && Intrinsics.areEqual(this.thought, internal.thought) && Intrinsics.areEqual(this.thoughtSignature, internal.thoughtSignature);
        }

        public final FileData getFileData() {
            return this.fileData;
        }

        public final Boolean getThought() {
            return this.thought;
        }

        public final String getThoughtSignature() {
            return this.thoughtSignature;
        }

        public int hashCode() {
            int iHashCode = this.fileData.hashCode() * 31;
            Boolean bool = this.thought;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            String str = this.thoughtSignature;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(fileData=");
            sb.append(this.fileData);
            sb.append(", thought=");
            sb.append(this.thought);
            sb.append(", thoughtSignature=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.thoughtSignature, ')');
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006$"}, d2 = {"Lcom/google/firebase/ai/type/FileDataPart$Internal$FileData;", "", "mimeType", "", "fileUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMimeType$annotations", "()V", "getMimeType", "()Ljava/lang/String;", "getFileUri$annotations", "getFileUri", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        @Serializable
        public static final /* data */ class FileData {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String fileUri;
            private final String mimeType;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/FileDataPart$Internal$FileData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/FileDataPart$Internal$FileData;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<FileData> serializer() {
                    return FileDataPart$Internal$FileData$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ FileData(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, FileDataPart$Internal$FileData$$serializer.INSTANCE.getDescriptor());
                }
                this.mimeType = str;
                this.fileUri = str2;
            }

            public static /* synthetic */ FileData copy$default(FileData fileData, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = fileData.mimeType;
                }
                if ((i & 2) != 0) {
                    str2 = fileData.fileUri;
                }
                return fileData.copy(str, str2);
            }

            @SerialName("file_uri")
            public static /* synthetic */ void getFileUri$annotations() {
            }

            @SerialName("mime_type")
            public static /* synthetic */ void getMimeType$annotations() {
            }

            public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(FileData self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeStringElement(serialDesc, 0, self.mimeType);
                output.encodeStringElement(serialDesc, 1, self.fileUri);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getMimeType() {
                return this.mimeType;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getFileUri() {
                return this.fileUri;
            }

            public final FileData copy(String mimeType, String fileUri) {
                mimeType.getClass();
                fileUri.getClass();
                return new FileData(mimeType, fileUri);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FileData)) {
                    return false;
                }
                FileData fileData = (FileData) other;
                return Intrinsics.areEqual(this.mimeType, fileData.mimeType) && Intrinsics.areEqual(this.fileUri, fileData.fileUri);
            }

            public final String getFileUri() {
                return this.fileUri;
            }

            public final String getMimeType() {
                return this.mimeType;
            }

            public int hashCode() {
                return this.fileUri.hashCode() + (this.mimeType.hashCode() * 31);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("FileData(mimeType=");
                sb.append(this.mimeType);
                sb.append(", fileUri=");
                return FileInsert$$ExternalSyntheticOutline0.m(sb, this.fileUri, ')');
            }

            public FileData(String str, String str2) {
                str.getClass();
                str2.getClass();
                this.mimeType = str;
                this.fileUri = str2;
            }
        }

        public Internal(FileData fileData, Boolean bool, String str) {
            fileData.getClass();
            this.fileData = fileData;
            this.thought = bool;
            this.thoughtSignature = str;
        }

        public /* synthetic */ Internal(FileData fileData, Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileData, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str);
        }
    }
}
