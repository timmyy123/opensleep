package com.google.firebase.ai.type;

import android.graphics.Bitmap;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.ai.type.UnknownPart;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B#\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\r\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\r\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/google/firebase/ai/type/Content;", "", "role", "", "parts", "", "Lcom/google/firebase/ai/type/Part;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getRole", "()Ljava/lang/String;", "getParts", "()Ljava/util/List;", "copy", "toInternal", "Lcom/google/firebase/ai/type/Content$Internal;", "toInternal$com_google_firebase_ai_logic_firebase_ai", "toTemplateInternal", "toTemplateInternal$com_google_firebase_ai_logic_firebase_ai", "Builder", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Content {
    private final List<Part> parts;
    private final String role;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0014\u0010\n\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J!\u0010\u000b\u001a\u00020\u0000\"\b\b\u0000\u0010\f*\u00020\b2\u0006\u0010\r\u001a\u0002H\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0011J\u001d\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0016J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\b\u0019J\u001d\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/google/firebase/ai/type/Content$Builder;", "", "<init>", "()V", "role", "", "parts", "", "Lcom/google/firebase/ai/type/Part;", "setRole", "setParts", "part", "T", "data", "addPart", "(Lcom/google/firebase/ai/type/Part;)Lcom/google/firebase/ai/type/Content$Builder;", "text", "addText", "inlineData", "bytes", "", "mimeType", "addInlineData", "image", "Landroid/graphics/Bitmap;", "addImage", "fileData", ShareConstants.MEDIA_URI, "addFileData", InAppPurchaseConstants.METHOD_BUILD, "Lcom/google/firebase/ai/type/Content;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        public String role = "user";
        public List<Part> parts = new ArrayList();

        public final Builder addFileData(String uri, String mimeType) {
            uri.getClass();
            mimeType.getClass();
            return addPart(new FileDataPart(uri, mimeType));
        }

        public final Builder addImage(Bitmap image) {
            image.getClass();
            return addPart(new ImagePart(image));
        }

        public final Builder addInlineData(byte[] bytes, String mimeType) {
            bytes.getClass();
            mimeType.getClass();
            return addPart(new InlineDataPart(bytes, mimeType));
        }

        public final <T extends Part> Builder addPart(T data2) {
            data2.getClass();
            this.parts.add(data2);
            return this;
        }

        public final Builder addText(String text) {
            text.getClass();
            return addPart(new TextPart(text));
        }

        public final Content build() {
            return new Content(this.role, this.parts);
        }

        public final Builder setParts(List<Part> parts) {
            parts.getClass();
            this.parts = parts;
            return this;
        }

        public final Builder setRole(String role) {
            this.role = role;
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Content(String str, List<? extends Part> list) {
        list.getClass();
        this.role = str;
        this.parts = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Content copy$default(Content content, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = content.role;
        }
        if ((i & 2) != 0) {
            list = content.parts;
        }
        return content.copy(str, list);
    }

    public final Content copy(String role, List<? extends Part> parts) {
        parts.getClass();
        return new Content(role, parts);
    }

    public final List<Part> getParts() {
        return this.parts;
    }

    public final String getRole() {
        return this.role;
    }

    public final Internal toInternal$com_google_firebase_ai_logic_firebase_ai() {
        String str = this.role;
        if (str == null) {
            str = "user";
        }
        List<Part> list = this.parts;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(PartKt.toInternal$default((Part) it.next(), false, 1, null));
        }
        return new Internal(str, arrayList);
    }

    public final Internal toTemplateInternal$com_google_firebase_ai_logic_firebase_ai() {
        String str = this.role;
        if (str == null) {
            str = "user";
        }
        List<Part> list = this.parts;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(PartKt.toInternal((Part) it.next(), true));
        }
        return new Internal(str, arrayList);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Content(List<? extends Part> list) {
        this(null, list, 1, 0 == true ? 1 : 0);
        list.getClass();
    }

    public /* synthetic */ Content(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "user" : str, list);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 (2\u00020\u0001:\u0002'(B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lcom/google/firebase/ai/type/Content$Internal;", "", "role", "", "parts", "", "Lcom/google/firebase/ai/type/InternalPart;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRole$annotations", "()V", "getRole", "()Ljava/lang/String;", "getParts", "()Ljava/util/List;", "toPublic", "Lcom/google/firebase/ai/type/Content;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {
        private final List<InternalPart> parts;
        private final String role;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(PartSerializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/Content$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/Content$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return Content$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
            this.role = (i & 1) == 0 ? "user" : str;
            if ((i & 2) == 0) {
                this.parts = null;
            } else {
                this.parts = list;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Internal copy$default(Internal internal, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = internal.role;
            }
            if ((i & 2) != 0) {
                list = internal.parts;
            }
            return internal.copy(str, list);
        }

        public static /* synthetic */ void getRole$annotations() {
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.role);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.parts == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.parts);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getRole() {
            return this.role;
        }

        public final List<InternalPart> component2() {
            return this.parts;
        }

        public final Internal copy(String role, List<? extends InternalPart> parts) {
            return new Internal(role, parts);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.role, internal.role) && Intrinsics.areEqual(this.parts, internal.parts);
        }

        public final List<InternalPart> getParts() {
            return this.parts;
        }

        public final String getRole() {
            return this.role;
        }

        public int hashCode() {
            String str = this.role;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            List<InternalPart> list = this.parts;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public final Content toPublic$com_google_firebase_ai_logic_firebase_ai() {
            List<InternalPart> list = this.parts;
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!(((InternalPart) obj) instanceof UnknownPart.Internal)) {
                        arrayList.add(obj);
                    }
                }
                if (!arrayList.isEmpty()) {
                    List<InternalPart> list2 = this.parts;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : list2) {
                        if (!(((InternalPart) obj2) instanceof UnknownPart.Internal)) {
                            arrayList2.add(obj2);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(PartKt.toPublic((InternalPart) it.next()));
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj3 : arrayList3) {
                        Part part = (Part) obj3;
                        if (!(part instanceof TextPart) || ((TextPart) part).getText().length() != 0) {
                            arrayList4.add(obj3);
                        }
                    }
                    String str = this.role;
                    boolean zIsEmpty = arrayList4.isEmpty();
                    List listListOf = arrayList4;
                    if (zIsEmpty) {
                        listListOf = CollectionsKt.listOf(new TextPart(" "));
                    }
                    return new Content(str, listListOf);
                }
            }
            return new Content(this.role, CollectionsKt.emptyList());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Internal(role=");
            sb.append(this.role);
            sb.append(", parts=");
            return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.parts, ')');
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Internal() {
            this((String) null, (List) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Internal(String str, List<? extends InternalPart> list) {
            this.role = str;
            this.parts = list;
        }

        public /* synthetic */ Internal(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "user" : str, (i & 2) != 0 ? null : list);
        }
    }
}
