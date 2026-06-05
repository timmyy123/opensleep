package com.google.home.matter.serialization.codec.json;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.matter.serialization.WireType;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.UStringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB)\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u001b\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\b\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/google/home/matter/serialization/codec/json/Tag;", "", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "tag", "Lcom/google/home/matter/serialization/WireType;", "type", "", "isArray", "<init>", "(ILcom/google/home/matter/serialization/WireType;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "asNull", "()Lcom/google/home/matter/serialization/codec/json/Tag;", "asElement", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "I", "getTag-pVg5ArA", "Lcom/google/home/matter/serialization/WireType;", "getType", "()Lcom/google/home/matter/serialization/WireType;", "Z", "()Z", "Companion", "java.com.google.home.matter.serialization.codec.json_json-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Tag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean isArray;
    private final int tag;
    private final WireType<?> type;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/google/home/matter/serialization/codec/json/Tag$Companion;", "", "<init>", "()V", "parseTag", "Lcom/google/home/matter/serialization/codec/json/Tag;", "str", "", "java.com.google.home.matter.serialization.codec.json_json-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final Tag parseTag(String str) {
            WireType<? extends Object> wireTypeValueOf;
            str.getClass();
            List listSplit$default = StringsKt__StringsKt.split$default(str, new char[]{':', '-'}, false, 3, 2, (Object) null);
            boolean z = false;
            int uInt = UStringsKt.toUInt((String) listSplit$default.get(0));
            int size = listSplit$default.size();
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (size == 2) {
                wireTypeValueOf = WireType.INSTANCE.valueOf((String) listSplit$default.get(1));
                if (Intrinsics.areEqual(wireTypeValueOf, WireType.WireTypeUnknown.INSTANCE)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid Tag: ".concat(str));
                    return null;
                }
            } else {
                if (size != 3) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid Tag: ".concat(str));
                    return null;
                }
                wireTypeValueOf = WireType.INSTANCE.valueOf((String) listSplit$default.get(2));
                if (Intrinsics.areEqual(wireTypeValueOf, WireType.WireTypeNull.INSTANCE)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid Tag: ".concat(str));
                    return null;
                }
                if (!Intrinsics.areEqual(listSplit$default.get(1), "ARRAY")) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid Tag: ".concat(str));
                    return null;
                }
                z = true;
            }
            return new Tag(uInt, wireTypeValueOf, z, defaultConstructorMarker);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private Tag(int i, WireType<?> wireType, boolean z) {
        wireType.getClass();
        this.tag = i;
        this.type = wireType;
        boolean z2 = true;
        if ((!z || Intrinsics.areEqual(wireType, WireType.WireTypeNull.INSTANCE)) && !Intrinsics.areEqual(wireType, WireType.WireTypeUnknown.INSTANCE)) {
            z2 = false;
        }
        this.isArray = z2;
    }

    public final Tag asElement() {
        return new Tag(this.tag, this.type, false, null);
    }

    public final Tag asNull() {
        return new Tag(this.tag, WireType.WireTypeNull.INSTANCE, this.isArray, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) other;
        return this.tag == tag.tag && Intrinsics.areEqual(this.type, tag.type) && this.isArray == tag.isArray;
    }

    /* JADX INFO: renamed from: getTag-pVg5ArA, reason: not valid java name and from getter */
    public final int getTag() {
        return this.tag;
    }

    public final WireType<?> getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() + (UInt.m2391hashCodeimpl(this.tag) * 31);
        return Boolean.hashCode(this.isArray) + (iHashCode * 31);
    }

    /* JADX INFO: renamed from: isArray, reason: from getter */
    public final boolean getIsArray() {
        return this.isArray;
    }

    public String toString() {
        String strM2392toStringimpl;
        String name;
        StringBuilder sb;
        String str;
        boolean z = this.isArray;
        int i = this.tag;
        WireType<?> wireType = this.type;
        if (z) {
            strM2392toStringimpl = UInt.m2392toStringimpl(i);
            name = wireType.getName();
            sb = new StringBuilder(String.valueOf(strM2392toStringimpl).length() + 7 + String.valueOf(name).length());
            str = ":ARRAY-";
        } else {
            strM2392toStringimpl = UInt.m2392toStringimpl(i);
            name = wireType.getName();
            sb = new StringBuilder(String.valueOf(strM2392toStringimpl).length() + 1 + String.valueOf(name).length());
            str = ":";
        }
        return Fragment$$ExternalSyntheticOutline1.m(sb, strM2392toStringimpl, str, name);
    }

    public /* synthetic */ Tag(int i, WireType wireType, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, wireType, z);
    }

    public /* synthetic */ Tag(int i, WireType wireType, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, wireType, z & ((i2 & 4) == 0), null);
    }
}
