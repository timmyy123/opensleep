package com.google.home.matter.serialization.codec.json;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.internal.serialization.zzvo;
import com.google.android.gms.internal.serialization.zzvr;
import com.google.android.gms.internal.serialization.zzvv;
import com.google.home.matter.serialization.Bitmap;
import com.google.home.matter.serialization.BitmapAdapter;
import com.google.home.matter.serialization.ClusterPayloadWriter;
import com.google.home.matter.serialization.FieldAdapter;
import com.google.home.matter.serialization.OptionalValue;
import com.google.home.matter.serialization.StructAdapter;
import com.google.home.matter.serialization.WireType;
import com.google.home.matter.serialization.codec.json.JsonClusterWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 S2\u00020\u0001:\u0004STUVB\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0016\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\"\b\b\u0000\u0010\u0012*\u00020\u001c2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\"\b\b\u0000\u0010\u0012*\u00020\u001c2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0016¢\u0006\u0004\b!\u0010\"J'\u0010#\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020%H\u0002¢\u0006\u0004\b\u0015\u0010&J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010&R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010+R \u0010,\u001a\b\u0012\u0004\u0012\u00020'0\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R \u00100\u001a\b\u0012\u0004\u0012\u00020%0\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u0010-\u001a\u0004\b1\u0010/R \u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/R \u00105\u001a\b\u0012\u0004\u0012\u0002040\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b5\u0010-\u001a\u0004\b6\u0010/R \u00108\u001a\b\u0012\u0004\u0012\u0002070\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b8\u0010-\u001a\u0004\b9\u0010/R \u0010:\u001a\b\u0012\u0004\u0012\u00020\b0\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b:\u0010-\u001a\u0004\b;\u0010/R \u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b=\u0010-\u001a\u0004\b>\u0010/R \u0010?\u001a\b\u0012\u0004\u0012\u00020\f0\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b?\u0010-\u001a\u0004\b@\u0010/R \u0010B\u001a\b\u0012\u0004\u0012\u00020A0\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bB\u0010-\u001a\u0004\bC\u0010/R \u0010E\u001a\b\u0012\u0004\u0012\u00020D0\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bE\u0010-\u001a\u0004\bF\u0010/R \u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bH\u0010-\u001a\u0004\bI\u0010/R \u0010K\u001a\b\u0012\u0004\u0012\u00020J0\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bK\u0010-\u001a\u0004\bL\u0010/R \u0010N\u001a\b\u0012\u0004\u0012\u00020M0\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bN\u0010-\u001a\u0004\bO\u0010/R \u0010!\u001a\b\u0012\u0004\u0012\u00020P0\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010-\u001a\u0004\bQ\u0010/R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010R¨\u0006W"}, d2 = {"Lcom/google/home/matter/serialization/codec/json/JsonClusterWriter;", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "Lcom/google/nest/platform/mesh/serialization/json/JsonWriter;", "out", "", "strictOperationValidation", "<init>", "(Lcom/google/nest/platform/mesh/serialization/json/JsonWriter;Z)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "tags", "", "wrapPayload", "(Ljava/util/List;)V", "T", "Lcom/google/home/matter/serialization/StructAdapter;", "adapter", SDKConstants.PARAM_VALUE, "write", "(Lcom/google/home/matter/serialization/StructAdapter;Ljava/lang/Object;)V", "Lcom/google/home/matter/serialization/codec/json/Tag;", "tag", "name", "(Lcom/google/home/matter/serialization/codec/json/Tag;)V", "", "Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "struct", "(Lcom/google/home/matter/serialization/StructAdapter;)Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "bitmap", "(Lcom/google/home/matter/serialization/BitmapAdapter;)Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "nameAndNull", "(Lcom/google/home/matter/serialization/codec/json/Tag;Ljava/lang/Object;)Z", "", "(J)V", "Lkotlin/ULong;", "value-VKZWuLQ", "Z", "getStrictOperationValidation", "()Z", "ulong", "Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "getUlong", "()Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "long", "getLong", "boolean", "getBoolean", "", "float", "getFloat", "", "double", "getDouble", "string", "getString", "", "bytearray", "getBytearray", "uint", "getUint", "", "int", "getInt", "Lkotlin/UShort;", "ushort", "getUshort", "", "short", "getShort", "", "byte", "getByte", "Lkotlin/UByte;", "ubyte", "getUbyte", "Lcom/google/home/matter/serialization/Bitmap;", "getBitmap", "Lcom/google/nest/platform/mesh/serialization/json/JsonWriter;", "Companion", "BaseWriter", "AdaptedWriter", "FieldWriterImpl", "java.com.google.home.matter.serialization.codec.json_json-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JsonClusterWriter implements ClusterPayloadWriter {
    private final ClusterPayloadWriter.FieldWriter<Bitmap> bitmap;
    private final ClusterPayloadWriter.FieldWriter<Boolean> boolean;
    private final ClusterPayloadWriter.FieldWriter<Byte> byte;
    private final ClusterPayloadWriter.FieldWriter<byte[]> bytearray;
    private final ClusterPayloadWriter.FieldWriter<Double> double;
    private final ClusterPayloadWriter.FieldWriter<Float> float;
    private final ClusterPayloadWriter.FieldWriter<Integer> int;
    private final ClusterPayloadWriter.FieldWriter<Long> long;
    private final zzvv out;
    private final ClusterPayloadWriter.FieldWriter<Short> short;
    private final boolean strictOperationValidation;
    private final ClusterPayloadWriter.FieldWriter<String> string;
    private final ClusterPayloadWriter.FieldWriter<UByte> ubyte;
    private final ClusterPayloadWriter.FieldWriter<UInt> uint;
    private final ClusterPayloadWriter.FieldWriter<ULong> ulong;
    private final ClusterPayloadWriter.FieldWriter<UShort> ushort;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\"\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0001\u0010\u0006*\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/google/home/matter/serialization/codec/json/JsonClusterWriter$BaseWriter;", "", "T", "Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "<init>", "()V", "NEWRUNTIME", "Lcom/google/home/matter/serialization/FieldAdapter;", "adapter", "adapt", "(Lcom/google/home/matter/serialization/FieldAdapter;)Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "java.com.google.home.matter.serialization.codec.json_json-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class BaseWriter<T> implements ClusterPayloadWriter.FieldWriter<T> {
        @Override // com.google.home.matter.serialization.ClusterPayloadWriter.FieldWriter
        public <NEWRUNTIME> ClusterPayloadWriter.FieldWriter<NEWRUNTIME> adapt(FieldAdapter<T, NEWRUNTIME> adapter) {
            adapter.getClass();
            return new AdaptedWriter(this, new JsonClusterWriter$BaseWriter$adapt$1(adapter));
        }
    }

    public JsonClusterWriter(zzvv zzvvVar, boolean z) {
        zzvvVar.getClass();
        this.out = zzvvVar;
        this.strictOperationValidation = z;
        this.ulong = new FieldWriterImpl(this, WireType.WireTypeUInt.INSTANCE, new JsonClusterWriter$ulong$1(this));
        this.long = new FieldWriterImpl(this, WireType.WireTypeInt.INSTANCE, new JsonClusterWriter$long$1(this));
        this.boolean = new FieldWriterImpl(this, WireType.WireTypeBool.INSTANCE, new JsonClusterWriter$boolean$1(zzvvVar));
        this.float = new FieldWriterImpl(this, WireType.WireTypeFloat.INSTANCE, new JsonClusterWriter$float$1(zzvvVar));
        this.double = new FieldWriterImpl(this, WireType.WireTypeDouble.INSTANCE, new JsonClusterWriter$double$1(zzvvVar));
        this.string = new FieldWriterImpl(this, WireType.WireTypeString.INSTANCE, new JsonClusterWriter$string$1(zzvvVar));
        this.bytearray = new FieldWriterImpl(this, WireType.WireTypeBytes.INSTANCE, new Function1<byte[], Unit>() { // from class: com.google.home.matter.serialization.codec.json.JsonClusterWriter$bytearray$1
            {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(byte[] bArr) {
                bArr.getClass();
                this.this$0.out.zzf(zzvo.zzb(bArr));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr) {
                invoke2(bArr);
                return Unit.INSTANCE;
            }
        });
        ClusterPayloadWriter.FieldWriter<ULong> ulong = getUlong();
        FieldAdapter.Companion companion = FieldAdapter.INSTANCE;
        this.uint = ulong.adapt(companion.getULONG_UINT());
        this.int = getLong().adapt(companion.getLONG_INT());
        this.ushort = getUlong().adapt(companion.getULONG_USHORT());
        this.short = getLong().adapt(companion.getLONG_SHORT());
        this.byte = getLong().adapt(companion.getLONG_BYTE());
        this.ubyte = getUlong().adapt(companion.getULONG_UBYTE());
        this.bitmap = getUlong().adapt(Bitmap.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> boolean nameAndNull(Tag tag, T value) {
        if (value != null) {
            name(tag);
            return true;
        }
        name(tag.asNull());
        this.out.zzg();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void value(long value) {
        long j = (int) value;
        zzvv zzvvVar = this.out;
        if (j != value) {
            zzvvVar.zzf(String.valueOf(value));
        } else {
            zzvvVar.zzk(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: value-VKZWuLQ, reason: not valid java name */
    public final void m576valueVKZWuLQ(long value) {
        String str;
        int i = (int) value;
        zzvv zzvvVar = this.out;
        if (i >= 0) {
            zzvvVar.zzk(value);
            return;
        }
        if (value == 0) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else if (value > 0) {
            str = Long.toString(value, 10);
        } else {
            char[] cArr = new char[64];
            long j = (value >>> 1) / 5;
            int i2 = 63;
            cArr[63] = Character.forDigit((int) (value - (j * 10)), 10);
            while (j > 0) {
                i2--;
                cArr[i2] = Character.forDigit((int) (j % 10), 10);
                j /= 10;
            }
            str = new String(cArr, i2, 64 - i2);
        }
        zzvvVar.zzf(str);
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public <T> ClusterPayloadWriter.FieldWriter<T> bitmap(BitmapAdapter<T> adapter) {
        adapter.getClass();
        return (ClusterPayloadWriter.FieldWriter<T>) getBitmap().adapt(adapter);
    }

    public ClusterPayloadWriter.FieldWriter<Bitmap> getBitmap() {
        return this.bitmap;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public ClusterPayloadWriter.FieldWriter<Boolean> getBoolean() {
        return this.boolean;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public ClusterPayloadWriter.FieldWriter<Byte> getByte() {
        return this.byte;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public ClusterPayloadWriter.FieldWriter<byte[]> getBytearray() {
        return this.bytearray;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public ClusterPayloadWriter.FieldWriter<Double> getDouble() {
        return this.double;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public ClusterPayloadWriter.FieldWriter<Float> getFloat() {
        return this.float;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public ClusterPayloadWriter.FieldWriter<Integer> getInt() {
        return this.int;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public ClusterPayloadWriter.FieldWriter<Long> getLong() {
        return this.long;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public ClusterPayloadWriter.FieldWriter<Short> getShort() {
        return this.short;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public boolean getStrictOperationValidation() {
        return this.strictOperationValidation;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public ClusterPayloadWriter.FieldWriter<String> getString() {
        return this.string;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public ClusterPayloadWriter.FieldWriter<UByte> getUbyte() {
        return this.ubyte;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public ClusterPayloadWriter.FieldWriter<UInt> getUint() {
        return this.uint;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public ClusterPayloadWriter.FieldWriter<ULong> getUlong() {
        return this.ulong;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public ClusterPayloadWriter.FieldWriter<UShort> getUshort() {
        return this.ushort;
    }

    public final void name(Tag tag) {
        tag.getClass();
        this.out.zze(tag.toString());
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public <T> ClusterPayloadWriter.FieldWriter<T> struct(final StructAdapter<T> adapter) {
        adapter.getClass();
        WireType.WireTypeStruct wireTypeStruct = WireType.WireTypeStruct.INSTANCE;
        wireTypeStruct.getClass();
        return new FieldWriterImpl(this, wireTypeStruct, new Function1() { // from class: com.google.home.matter.serialization.codec.json.JsonClusterWriter.struct.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m577invoke(Object obj) {
                obj.getClass();
                JsonClusterWriter.this.write(adapter, obj);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m577invoke(obj);
                return Unit.INSTANCE;
            }
        });
    }

    public String toString() {
        return this.out.toString();
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public void wrapPayload(List<UInt> tags) {
        tags.getClass();
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public <T> void write(StructAdapter<T> adapter, T value) {
        adapter.getClass();
        this.out.zzc();
        adapter.write(this, value);
        this.out.zzd();
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0004B)\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0012\u001a\u00020\u000f2\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0012\u001a\u00020\u000f2\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0010\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00010\u0013H\u0016¢\u0006\u0004\b\u0010\u0010\u0014J+\u0010\u0018\u001a\u00020\u000f2\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/google/home/matter/serialization/codec/json/JsonClusterWriter$AdaptedWriter;", "", "FROM", "TO", "Lcom/google/home/matter/serialization/codec/json/JsonClusterWriter$BaseWriter;", "Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "writer", "Lkotlin/Function1;", "adapter", "<init>", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "tag", SDKConstants.PARAM_VALUE, "", "write-qim9Vi0", "(ILjava/lang/Object;)V", "write", "Lcom/google/home/matter/serialization/OptionalValue;", "(ILcom/google/home/matter/serialization/OptionalValue;)V", "", "writeList-qim9Vi0", "(ILjava/util/List;)V", "writeList", "Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "getWriter", "()Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "Lkotlin/jvm/functions/Function1;", "getAdapter", "()Lkotlin/jvm/functions/Function1;", "java.com.google.home.matter.serialization.codec.json_json-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AdaptedWriter<FROM, TO> extends BaseWriter<TO> {
        private final Function1<TO, FROM> adapter;
        private final ClusterPayloadWriter.FieldWriter<FROM> writer;

        /* JADX WARN: Multi-variable type inference failed */
        public AdaptedWriter(ClusterPayloadWriter.FieldWriter<FROM> fieldWriter, Function1<? super TO, ? extends FROM> function1) {
            fieldWriter.getClass();
            function1.getClass();
            this.writer = fieldWriter;
            this.adapter = function1;
        }

        public final Function1<TO, FROM> getAdapter() {
            return this.adapter;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.home.matter.serialization.ClusterPayloadWriter.FieldWriter
        /* JADX INFO: renamed from: write-qim9Vi0 */
        public void mo553writeqim9Vi0(int tag, OptionalValue<? extends TO> value) {
            value.getClass();
            this.writer.mo553writeqim9Vi0(tag, (OptionalValue<? extends FROM>) value.map(new Function1<?, FROM>(this) { // from class: com.google.home.matter.serialization.codec.json.JsonClusterWriter$AdaptedWriter$write$1
                final /* synthetic */ JsonClusterWriter.AdaptedWriter<FROM, TO> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final FROM invoke(Object obj) {
                    Function1 adapter = this.this$0.getAdapter();
                    obj.getClass();
                    return (FROM) adapter.invoke(obj);
                }
            }));
        }

        @Override // com.google.home.matter.serialization.ClusterPayloadWriter.FieldWriter
        /* JADX INFO: renamed from: writeList-qim9Vi0 */
        public void mo555writeListqim9Vi0(int tag, List<? extends TO> value) {
            ArrayList arrayList;
            if (value != null) {
                Function1<TO, FROM> function1 = this.adapter;
                List<? extends TO> list = value;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(function1.invoke((TO) it.next()));
                }
            } else {
                arrayList = null;
            }
            this.writer.mo555writeListqim9Vi0(tag, arrayList);
        }

        @Override // com.google.home.matter.serialization.ClusterPayloadWriter.FieldWriter
        /* JADX INFO: renamed from: write-qim9Vi0 */
        public void mo554writeqim9Vi0(int tag, TO value) {
            this.writer.mo554writeqim9Vi0(tag, value == null ? null : this.adapter.invoke(value));
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\b\u0092\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0011\u001a\u00020\u00072\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0011\u001a\u00020\u00072\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0010\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0012H\u0016¢\u0006\u0004\b\u000f\u0010\u0013J+\u0010\u0017\u001a\u00020\u00072\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/google/home/matter/serialization/codec/json/JsonClusterWriter$FieldWriterImpl;", "", "T", "Lcom/google/home/matter/serialization/codec/json/JsonClusterWriter$BaseWriter;", "Lcom/google/home/matter/serialization/WireType;", "wireType", "Lkotlin/Function1;", "", "writerFn", "<init>", "(Lcom/google/home/matter/serialization/codec/json/JsonClusterWriter;Lcom/google/home/matter/serialization/WireType;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "tag", SDKConstants.PARAM_VALUE, "write-qim9Vi0", "(ILjava/lang/Object;)V", "write", "Lcom/google/home/matter/serialization/OptionalValue;", "(ILcom/google/home/matter/serialization/OptionalValue;)V", "", "writeList-qim9Vi0", "(ILjava/util/List;)V", "writeList", "Lcom/google/home/matter/serialization/WireType;", "getWireType", "()Lcom/google/home/matter/serialization/WireType;", "Lkotlin/jvm/functions/Function1;", "getWriterFn", "()Lkotlin/jvm/functions/Function1;", "java.com.google.home.matter.serialization.codec.json_json-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public class FieldWriterImpl<T> extends BaseWriter<T> {
        final /* synthetic */ JsonClusterWriter this$0;
        private final WireType<T> wireType;
        private final Function1<T, Unit> writerFn;

        /* JADX WARN: Multi-variable type inference failed */
        public FieldWriterImpl(JsonClusterWriter jsonClusterWriter, WireType<T> wireType, Function1<? super T, Unit> function1) {
            wireType.getClass();
            function1.getClass();
            this.this$0 = jsonClusterWriter;
            this.wireType = wireType;
            this.writerFn = function1;
            if (Intrinsics.areEqual(wireType, WireType.WireTypeNull.INSTANCE)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Failed requirement.");
                throw null;
            }
        }

        @Override // com.google.home.matter.serialization.ClusterPayloadWriter.FieldWriter
        /* JADX INFO: renamed from: write-qim9Vi0 */
        public void mo554writeqim9Vi0(int tag, T value) {
            if (this.this$0.nameAndNull(new Tag(tag, this.wireType, false, 4, null), value)) {
                Function1<T, Unit> function1 = this.writerFn;
                value.getClass();
                function1.invoke(value);
            }
        }

        @Override // com.google.home.matter.serialization.ClusterPayloadWriter.FieldWriter
        /* JADX INFO: renamed from: writeList-qim9Vi0 */
        public void mo555writeListqim9Vi0(int tag, List<? extends T> value) {
            if (this.this$0.nameAndNull(new Tag(tag, (value == null || !value.isEmpty()) ? this.wireType : WireType.WireTypeUnknown.INSTANCE, true, null), value)) {
                this.this$0.out.zza();
                if (value != null) {
                    List<? extends T> list = value;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            this.writerFn.invoke(it.next());
                        }
                    }
                }
                this.this$0.out.zzb();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.home.matter.serialization.ClusterPayloadWriter.FieldWriter
        /* JADX INFO: renamed from: write-qim9Vi0 */
        public void mo553writeqim9Vi0(final int tag, OptionalValue<? extends T> value) {
            value.getClass();
            value.doWhenPresent(new Function1<?, Unit>(this) { // from class: com.google.home.matter.serialization.codec.json.JsonClusterWriter$FieldWriterImpl$write$1
                final /* synthetic */ JsonClusterWriter.FieldWriterImpl<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(T t) {
                    this.this$0.mo554writeqim9Vi0(tag, t);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke2(obj);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public /* synthetic */ JsonClusterWriter(zzvv zzvvVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? zzvr.zzb() : zzvvVar, z | (!((i & 2) == 0)));
    }
}
