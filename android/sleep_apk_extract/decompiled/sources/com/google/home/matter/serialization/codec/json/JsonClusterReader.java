package com.google.home.matter.serialization.codec.json;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import com.google.android.gms.internal.serialization.zzvo;
import com.google.android.gms.internal.serialization.zzvr;
import com.google.android.gms.internal.serialization.zzvs;
import com.google.home.matter.serialization.ClusterPayload;
import com.google.home.matter.serialization.ClusterPayloadReader;
import com.google.home.matter.serialization.StructAdapter;
import com.google.home.matter.serialization.WireType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 B2\u00020\u0001:\u0001BB%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\f2\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013JA\u0010\u0018\u001a\u0014\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00142\u001e\u0010\u0017\u001a\u001a\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e0\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\u001eJ\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u000bJ\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0002H\u0002¢\u0006\u0004\b,\u0010-J\u0011\u0010.\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b.\u0010/J#\u00101\u001a\u00028\u0000\"\u0004\b\u0000\u001002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H\u0002¢\u0006\u0004\b4\u00105J!\u00107\u001a\u0002032\u0010\u00106\u001a\f\u0012\b\u0012\u00060\u0015j\u0002`\u00160\u0011H\u0016¢\u0006\u0004\b7\u00108J/\u0010:\u001a\u0002092\u001e\u0010\u0017\u001a\u001a\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e0\u0014H\u0016¢\u0006\u0004\b:\u0010;J#\u0010<\u001a\u00028\u0000\"\u0004\b\u0000\u001002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016¢\u0006\u0004\b<\u00102R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010=\u001a\u0004\b>\u0010-R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010?\u001a\u0004\b@\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010A¨\u0006C"}, d2 = {"Lcom/google/home/matter/serialization/codec/json/JsonClusterReader;", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "", "json", "Lcom/google/nest/platform/mesh/serialization/json/JsonReader;", "reader", "", "strictOperationValidation", "<init>", "(Ljava/lang/String;Lcom/google/nest/platform/mesh/serialization/json/JsonReader;Z)V", "hasNext", "()Z", "Lcom/google/home/matter/serialization/codec/json/Tag;", "tag", "Lcom/google/home/matter/serialization/StructAdapter;", "", "adapter", "", "nextArray", "(Lcom/google/home/matter/serialization/codec/json/Tag;Lcom/google/home/matter/serialization/StructAdapter;)Ljava/util/List;", "", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "adapters", "readAll", "(Ljava/util/Map;)Ljava/util/Map;", "nextValue", "(Lcom/google/home/matter/serialization/codec/json/Tag;Lcom/google/home/matter/serialization/StructAdapter;)Ljava/lang/Object;", "Lkotlin/ULong;", "nextUInt-s-VKNKU", "()J", "nextUInt", "", "nextInt", "nextBoolean", "", "nextFloat", "()F", "", "nextDouble", "()D", "", "nextByteArray", "()[B", "nextString", "()Ljava/lang/String;", "nextNull", "()Ljava/lang/Object;", "T", "nextObject", "(Lcom/google/home/matter/serialization/StructAdapter;)Ljava/lang/Object;", "", "skipValue", "()V", "tags", "unwrapPayload", "(Ljava/util/List;)V", "Lcom/google/home/matter/serialization/ClusterPayload;", "readPayload", "(Ljava/util/Map;)Lcom/google/home/matter/serialization/ClusterPayload;", "read", "Ljava/lang/String;", "getJson", "Z", "getStrictOperationValidation", "Lcom/google/nest/platform/mesh/serialization/json/JsonReader;", "Companion", "java.com.google.home.matter.serialization.codec.json_json-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JsonClusterReader implements ClusterPayloadReader {
    private final String json;
    private zzvs reader;
    private final boolean strictOperationValidation;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ JsonClusterReader(String str, zzvs zzvsVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        str = 1 == (i & 1) ? "" : str;
        this(str, (i & 2) != 0 ? zzvr.zza(str) : zzvsVar, z | (!((i & 4) == 0)));
    }

    private final boolean hasNext() {
        return this.reader.zze();
    }

    private final List<?> nextArray(Tag tag, StructAdapter<? extends Object> adapter) {
        if (Intrinsics.areEqual(tag.getType(), WireType.WireTypeUnknown.INSTANCE)) {
            skipValue();
            return CollectionsKt.emptyList();
        }
        Tag tagAsElement = tag.asElement();
        this.reader.zza();
        ArrayList arrayList = new ArrayList();
        while (this.reader.zze()) {
            Object objNextValue = nextValue(tagAsElement, adapter);
            objNextValue.getClass();
            arrayList.add(objNextValue);
        }
        this.reader.zzb();
        return CollectionsKt.toList(arrayList);
    }

    private final boolean nextBoolean() {
        return this.reader.zzi();
    }

    private final byte[] nextByteArray() {
        return zzvo.zza(this.reader.zzh());
    }

    private final double nextDouble() {
        return Double.parseDouble(this.reader.zzh());
    }

    private final float nextFloat() {
        return Float.parseFloat(this.reader.zzh());
    }

    private final long nextInt() {
        return Long.parseLong(this.reader.zzh());
    }

    private final Object nextNull() {
        this.reader.zzj();
        return null;
    }

    private final <T> T nextObject(StructAdapter<T> adapter) {
        this.reader.zzc();
        T t = adapter.read(this);
        this.reader.zzd();
        return t;
    }

    private final String nextString() {
        return this.reader.zzh();
    }

    /* JADX INFO: renamed from: nextUInt-s-VKNKU, reason: not valid java name */
    private final long m574nextUIntsVKNKU() {
        return UStringsKt.toULong(this.reader.zzh());
    }

    private final Object nextValue(Tag tag, StructAdapter<? extends Object> adapter) {
        try {
            if (tag.getIsArray()) {
                return nextArray(tag, adapter);
            }
            WireType<?> type = tag.getType();
            if (Intrinsics.areEqual(type, WireType.WireTypeUInt.INSTANCE)) {
                return ULong.m2410boximpl(m574nextUIntsVKNKU());
            }
            if (Intrinsics.areEqual(type, WireType.WireTypeInt.INSTANCE)) {
                return Long.valueOf(nextInt());
            }
            if (Intrinsics.areEqual(type, WireType.WireTypeBool.INSTANCE)) {
                return Boolean.valueOf(nextBoolean());
            }
            if (Intrinsics.areEqual(type, WireType.WireTypeFloat.INSTANCE)) {
                return Float.valueOf(nextFloat());
            }
            if (Intrinsics.areEqual(type, WireType.WireTypeDouble.INSTANCE)) {
                return Double.valueOf(nextDouble());
            }
            if (Intrinsics.areEqual(type, WireType.WireTypeBytes.INSTANCE)) {
                return nextByteArray();
            }
            if (Intrinsics.areEqual(type, WireType.WireTypeString.INSTANCE)) {
                return nextString();
            }
            if (Intrinsics.areEqual(type, WireType.WireTypeStruct.INSTANCE)) {
                adapter.getClass();
                return nextObject(adapter);
            }
            if (Intrinsics.areEqual(type, WireType.WireTypeNull.INSTANCE)) {
                nextNull();
                return null;
            }
            if (Intrinsics.areEqual(type, WireType.WireTypeUnknown.INSTANCE)) {
                throw new IllegalStateException("Unknown wire type is not legal except in Arrays");
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            new StringBuilder(String.valueOf(tag).length() + 8);
            Objects.toString(tag);
            Types$$ExternalSyntheticBUOutline0.m("Bad Tag ".concat(String.valueOf(tag)), e);
            return null;
        }
    }

    private final Map<UInt, Object> readAll(Map<UInt, ? extends StructAdapter<? extends Object>> adapters) {
        Tag tag;
        StructAdapter<? extends Object> structAdapter;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (hasNext()) {
            try {
                tag = Tag.INSTANCE.parseTag(this.reader.zzg());
                structAdapter = adapters.get(UInt.m2388boximpl(tag.getTag()));
            } catch (IllegalArgumentException unused) {
                skipValue();
            }
            if (Intrinsics.areEqual(tag.getType(), WireType.WireTypeStruct.INSTANCE) && structAdapter == null) {
                skipValue();
            } else {
                linkedHashMap.put(UInt.m2388boximpl(tag.getTag()), nextValue(tag, structAdapter));
            }
        }
        return MapsKt.toMap(linkedHashMap);
    }

    private final void skipValue() {
        this.reader.zzk();
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadReader
    public <T> T read(StructAdapter<T> adapter) {
        adapter.getClass();
        return (T) nextObject(adapter);
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadReader
    public ClusterPayload readPayload(Map<UInt, ? extends StructAdapter<? extends Object>> adapters) {
        adapters.getClass();
        try {
            return new ClusterPayload(readAll(adapters));
        } catch (IllegalStateException e) {
            OggIO$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadReader
    public void unwrapPayload(List<UInt> tags) {
        tags.getClass();
    }

    public JsonClusterReader(String str, zzvs zzvsVar, boolean z) {
        str.getClass();
        zzvsVar.getClass();
        this.json = str;
        this.reader = zzvsVar;
        this.strictOperationValidation = z;
    }
}
