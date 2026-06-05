package com.google.home.matter.serialization.codec.proto;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.internal.serialization.zzvo;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.google.home.matter.serialization.Bitmap;
import com.google.home.matter.serialization.BitmapAdapter;
import com.google.home.matter.serialization.ClusterPayloadWriter;
import com.google.home.matter.serialization.FieldAdapter;
import com.google.home.matter.serialization.OptionalValue;
import com.google.home.matter.serialization.StructAdapter;
import com.google.home.matter.serialization.TagIdKt;
import com.google.home.matter.serialization.codec.proto.ProtoClusterWriter;
import com.google.home.matter.serialization.codec.proto.ProtoFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 e2\u00020\u0001:\u0004efghB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0007*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0007*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0015\u001a\u00020\u00142\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0018\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00142\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0014H\u0002¢\u0006\u0004\b'\u0010(J\u001b\u0010,\u001a\u00020\u00022\n\u0010)\u001a\u00060\u0011j\u0002`\u0012H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u0002H\u0002¢\u0006\u0004\b.\u0010\u0005J\u000f\u0010/\u001a\u00020\u001dH\u0002¢\u0006\u0004\b/\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u00100\u001a\u0004\b1\u00102R\u001a\u00105\u001a\b\u0012\u0004\u0012\u000204038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00107\u001a\b\u0012\u0004\u0012\u000204038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00106R$\u00109\u001a\f\u0012\u0004\u0012\u00020\u000208R\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R$\u0010>\u001a\f\u0012\u0004\u0012\u00020=08R\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b>\u0010:\u001a\u0004\b?\u0010<R$\u0010A\u001a\f\u0012\u0004\u0012\u00020@08R\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bA\u0010:\u001a\u0004\bB\u0010<R$\u0010C\u001a\f\u0012\u0004\u0012\u00020#08R\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bC\u0010:\u001a\u0004\bD\u0010<R$\u0010F\u001a\f\u0012\u0004\u0012\u00020E08R\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bF\u0010:\u001a\u0004\bG\u0010<R$\u0010I\u001a\f\u0012\u0004\u0012\u00020H08R\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bI\u0010:\u001a\u0004\bJ\u0010<R$\u0010L\u001a\f\u0012\u0004\u0012\u00020K08R\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bL\u0010:\u001a\u0004\bM\u0010<R$\u0010N\u001a\f\u0012\u0004\u0012\u00020\u001108R\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bN\u0010:\u001a\u0004\bO\u0010<R$\u0010Q\u001a\f\u0012\u0004\u0012\u00020P08R\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bQ\u0010:\u001a\u0004\bR\u0010<R$\u0010T\u001a\f\u0012\u0004\u0012\u00020S08R\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bT\u0010:\u001a\u0004\bU\u0010<R$\u0010W\u001a\f\u0012\u0004\u0012\u00020V08R\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bW\u0010:\u001a\u0004\bX\u0010<R$\u0010Z\u001a\f\u0012\u0004\u0012\u00020\u001a0YR\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R$\u0010_\u001a\f\u0012\u0004\u0012\u00020^0YR\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b_\u0010[\u001a\u0004\b`\u0010]R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020a0\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010b\u001a\u0004\bc\u0010d¨\u0006i"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter;", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "", "strictOperationValidation", "<init>", "(Z)V", "", "T", "Lcom/google/home/matter/serialization/BitmapAdapter;", "adapter", "Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "bitmap", "(Lcom/google/home/matter/serialization/BitmapAdapter;)Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "Lcom/google/home/matter/serialization/StructAdapter;", "struct", "(Lcom/google/home/matter/serialization/StructAdapter;)Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "tags", "", "wrapPayload", "(Ljava/util/List;)V", SDKConstants.PARAM_VALUE, "write", "(Lcom/google/home/matter/serialization/StructAdapter;Ljava/lang/Object;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/matter/serialization/codec/proto/ByteArrayOutputStream;", "underlying", "()Lcom/google/home/matter/serialization/codec/proto/ByteArrayOutputStream;", "Lcom/google/home/matter/serialization/codec/proto/CodedOutputStream;", "output", "()Lcom/google/home/matter/serialization/codec/proto/CodedOutputStream;", "", "fieldNumber", "pushLevel", "(I)V", "popLevel", "()V", "tag", "maybePushLevel-WZ4Q5Ns", "(I)Z", "maybePushLevel", "maybe", "maybePopLevel", "primaryOutputStream", "Z", "getStrictOperationValidation", "()Z", "", "Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter$Level;", "levels", "Ljava/util/List;", "wrapperLevels", "Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter$PackedFieldWriter;", "boolean", "Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter$PackedFieldWriter;", "getBoolean", "()Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter$PackedFieldWriter;", "", "byte", "getByte", "", "short", "getShort", "int", "getInt", "", "long", "getLong", "Lkotlin/UByte;", "ubyte", "getUbyte", "Lkotlin/UShort;", "ushort", "getUshort", "uint", "getUint", "Lkotlin/ULong;", "ulong", "getUlong", "", "float", "getFloat", "", "double", "getDouble", "Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter$SimpleFieldWriter;", "string", "Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter$SimpleFieldWriter;", "getString", "()Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter$SimpleFieldWriter;", "", "bytearray", "getBytearray", "Lcom/google/home/matter/serialization/Bitmap;", "Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "getBitmap", "()Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "Companion", "Level", "SimpleFieldWriter", "PackedFieldWriter", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProtoClusterWriter implements ClusterPayloadWriter {
    private final boolean strictOperationValidation;
    private final List<Level> levels = CollectionsKt.mutableListOf(new Level(0));
    private final List<Level> wrapperLevels = CollectionsKt.mutableListOf(new Level(0));
    private final PackedFieldWriter<Boolean> boolean = new PackedFieldWriter<>(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$boolean$1
        {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
            m589invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
        public final void m589invokeOzbTUA(int i, Object obj, boolean z) {
            int iComputeUInt64SizeNoTag;
            obj.getClass();
            if (!z || !(obj instanceof List)) {
                this.this$0.output().writeBool(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.BOOL, z & ((8 & 4) == 0), false & ((8 & 8) == 0)), ((Boolean) obj).booleanValue());
                return;
            }
            List list = (List) obj;
            CodedOutputStream codedOutputStreamOutput = this.this$0.output();
            Class<Object> cls = Object.class;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
            Class cls2 = Boolean.TYPE;
            boolean zAreEqual = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2));
            Class cls3 = Double.TYPE;
            Class cls4 = Float.TYPE;
            Class cls5 = Long.TYPE;
            Class cls6 = Integer.TYPE;
            Class cls7 = Short.TYPE;
            Class cls8 = Byte.TYPE;
            if (zAreEqual) {
                ProtoFormat protoFormat = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.BOOL, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls8)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls7)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls6)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls5))) {
                ProtoFormat protoFormat2 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat2.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat2.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UByte.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UShort.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                ProtoFormat protoFormat3 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat3.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat3.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                ProtoFormat protoFormat4 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat4.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.FLOAT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat4.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                ProtoFormat protoFormat5 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat5.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.DOUBLE, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat5.getWIRETYPE_LENGTH_DELIMITED());
            }
            Iterator it = list.iterator();
            int i2 = 0;
            while (true) {
                List list2 = list;
                if (!it.hasNext()) {
                    Class<Object> cls9 = cls;
                    codedOutputStreamOutput.writeUInt32NoTag(i2);
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(cls9);
                        Iterator it3 = it2;
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                            next.getClass();
                            codedOutputStreamOutput.writeBoolNoTag(((Boolean) next).booleanValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls8))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Byte) next).byteValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls7))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Short) next).shortValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls6))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Integer) next).intValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls5))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt64NoTag(((Long) next).longValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UByte.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UByte) next).getData() & 255);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UShort.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag((char) ((UShort) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UInt) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt64NoTag(((ULong) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                            next.getClass();
                            codedOutputStreamOutput.writeFloatNoTag(((Float) next).floatValue());
                        } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(cls9);
                            Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass3, 41), orCreateKotlinClass3, orCreateKotlinClass3, "Attempting to write an unsupported type: "));
                            return;
                        } else {
                            next.getClass();
                            codedOutputStreamOutput.writeDoubleNoTag(((Double) next).doubleValue());
                        }
                        it2 = it3;
                    }
                    return;
                }
                Object next2 = it.next();
                Class<Object> cls10 = cls;
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(cls10);
                Iterator it4 = it;
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeBoolSizeNoTag(((Boolean) next2).booleanValue());
                    iComputeUInt64SizeNoTag = 1;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls8))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Byte) next2).byteValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls7))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Short) next2).shortValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls6))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Integer) next2).intValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls5))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt64SizeNoTag(((Long) next2).longValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UByte.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UByte) next2).getData() & 255);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UShort.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag((char) ((UShort) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UInt) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt64SizeNoTag(((ULong) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeFloatSizeNoTag(((Float) next2).floatValue());
                    iComputeUInt64SizeNoTag = 4;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls3))) {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(cls10);
                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass5, 41), orCreateKotlinClass5, orCreateKotlinClass5, "Attempting to write an unsupported type: "));
                    return;
                } else {
                    next2.getClass();
                    codedOutputStreamOutput.computeDoubleSizeNoTag(((Double) next2).doubleValue());
                    iComputeUInt64SizeNoTag = 8;
                }
                i2 += iComputeUInt64SizeNoTag;
                it = it4;
                list = list2;
                cls = cls10;
            }
        }
    });
    private final PackedFieldWriter<Byte> byte = new PackedFieldWriter<>(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$byte$1
        {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
            m590invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
        public final void m590invokeOzbTUA(int i, Object obj, boolean z) {
            int iComputeUInt64SizeNoTag;
            obj.getClass();
            if (!z || !(obj instanceof List)) {
                this.this$0.output().writeSInt32(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, false & ((8 & 4) == 0), false & ((8 & 8) == 0)), ((Byte) obj).byteValue());
                return;
            }
            List list = (List) obj;
            CodedOutputStream codedOutputStreamOutput = this.this$0.output();
            Class<Object> cls = Object.class;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
            Class cls2 = Boolean.TYPE;
            boolean zAreEqual = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2));
            Class cls3 = Double.TYPE;
            Class cls4 = Float.TYPE;
            Class cls5 = Long.TYPE;
            Class cls6 = Integer.TYPE;
            Class cls7 = Short.TYPE;
            Class cls8 = Byte.TYPE;
            if (zAreEqual) {
                ProtoFormat protoFormat = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.BOOL, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls8)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls7)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls6)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls5))) {
                ProtoFormat protoFormat2 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat2.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat2.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UByte.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UShort.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                ProtoFormat protoFormat3 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat3.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat3.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                ProtoFormat protoFormat4 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat4.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.FLOAT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat4.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                ProtoFormat protoFormat5 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat5.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.DOUBLE, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat5.getWIRETYPE_LENGTH_DELIMITED());
            }
            Iterator it = list.iterator();
            int i2 = 0;
            while (true) {
                List list2 = list;
                if (!it.hasNext()) {
                    Class<Object> cls9 = cls;
                    codedOutputStreamOutput.writeUInt32NoTag(i2);
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(cls9);
                        Iterator it3 = it2;
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                            next.getClass();
                            codedOutputStreamOutput.writeBoolNoTag(((Boolean) next).booleanValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls8))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Byte) next).byteValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls7))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Short) next).shortValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls6))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Integer) next).intValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls5))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt64NoTag(((Long) next).longValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UByte.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UByte) next).getData() & 255);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UShort.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag((char) ((UShort) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UInt) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt64NoTag(((ULong) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                            next.getClass();
                            codedOutputStreamOutput.writeFloatNoTag(((Float) next).floatValue());
                        } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(cls9);
                            Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass3, 41), orCreateKotlinClass3, orCreateKotlinClass3, "Attempting to write an unsupported type: "));
                            return;
                        } else {
                            next.getClass();
                            codedOutputStreamOutput.writeDoubleNoTag(((Double) next).doubleValue());
                        }
                        it2 = it3;
                    }
                    return;
                }
                Object next2 = it.next();
                Class<Object> cls10 = cls;
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(cls10);
                Iterator it4 = it;
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeBoolSizeNoTag(((Boolean) next2).booleanValue());
                    iComputeUInt64SizeNoTag = 1;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls8))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Byte) next2).byteValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls7))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Short) next2).shortValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls6))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Integer) next2).intValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls5))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt64SizeNoTag(((Long) next2).longValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UByte.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UByte) next2).getData() & 255);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UShort.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag((char) ((UShort) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UInt) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt64SizeNoTag(((ULong) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeFloatSizeNoTag(((Float) next2).floatValue());
                    iComputeUInt64SizeNoTag = 4;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls3))) {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(cls10);
                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass5, 41), orCreateKotlinClass5, orCreateKotlinClass5, "Attempting to write an unsupported type: "));
                    return;
                } else {
                    next2.getClass();
                    codedOutputStreamOutput.computeDoubleSizeNoTag(((Double) next2).doubleValue());
                    iComputeUInt64SizeNoTag = 8;
                }
                i2 += iComputeUInt64SizeNoTag;
                it = it4;
                list = list2;
                cls = cls10;
            }
        }
    });
    private final PackedFieldWriter<Short> short = new PackedFieldWriter<>(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$short$1
        {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
            m596invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
        public final void m596invokeOzbTUA(int i, Object obj, boolean z) {
            int iComputeUInt64SizeNoTag;
            obj.getClass();
            if (!z || !(obj instanceof List)) {
                this.this$0.output().writeSInt32(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, false & ((8 & 4) == 0), false & ((8 & 8) == 0)), ((Short) obj).shortValue());
                return;
            }
            List list = (List) obj;
            CodedOutputStream codedOutputStreamOutput = this.this$0.output();
            Class<Object> cls = Object.class;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
            Class cls2 = Boolean.TYPE;
            boolean zAreEqual = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2));
            Class cls3 = Double.TYPE;
            Class cls4 = Float.TYPE;
            Class cls5 = Long.TYPE;
            Class cls6 = Integer.TYPE;
            Class cls7 = Short.TYPE;
            Class cls8 = Byte.TYPE;
            if (zAreEqual) {
                ProtoFormat protoFormat = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.BOOL, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls8)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls7)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls6)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls5))) {
                ProtoFormat protoFormat2 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat2.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat2.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UByte.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UShort.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                ProtoFormat protoFormat3 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat3.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat3.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                ProtoFormat protoFormat4 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat4.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.FLOAT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat4.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                ProtoFormat protoFormat5 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat5.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.DOUBLE, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat5.getWIRETYPE_LENGTH_DELIMITED());
            }
            Iterator it = list.iterator();
            int i2 = 0;
            while (true) {
                List list2 = list;
                if (!it.hasNext()) {
                    Class<Object> cls9 = cls;
                    codedOutputStreamOutput.writeUInt32NoTag(i2);
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(cls9);
                        Iterator it3 = it2;
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                            next.getClass();
                            codedOutputStreamOutput.writeBoolNoTag(((Boolean) next).booleanValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls8))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Byte) next).byteValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls7))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Short) next).shortValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls6))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Integer) next).intValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls5))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt64NoTag(((Long) next).longValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UByte.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UByte) next).getData() & 255);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UShort.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag((char) ((UShort) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UInt) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt64NoTag(((ULong) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                            next.getClass();
                            codedOutputStreamOutput.writeFloatNoTag(((Float) next).floatValue());
                        } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(cls9);
                            Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass3, 41), orCreateKotlinClass3, orCreateKotlinClass3, "Attempting to write an unsupported type: "));
                            return;
                        } else {
                            next.getClass();
                            codedOutputStreamOutput.writeDoubleNoTag(((Double) next).doubleValue());
                        }
                        it2 = it3;
                    }
                    return;
                }
                Object next2 = it.next();
                Class<Object> cls10 = cls;
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(cls10);
                Iterator it4 = it;
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeBoolSizeNoTag(((Boolean) next2).booleanValue());
                    iComputeUInt64SizeNoTag = 1;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls8))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Byte) next2).byteValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls7))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Short) next2).shortValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls6))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Integer) next2).intValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls5))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt64SizeNoTag(((Long) next2).longValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UByte.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UByte) next2).getData() & 255);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UShort.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag((char) ((UShort) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UInt) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt64SizeNoTag(((ULong) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeFloatSizeNoTag(((Float) next2).floatValue());
                    iComputeUInt64SizeNoTag = 4;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls3))) {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(cls10);
                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass5, 41), orCreateKotlinClass5, orCreateKotlinClass5, "Attempting to write an unsupported type: "));
                    return;
                } else {
                    next2.getClass();
                    codedOutputStreamOutput.computeDoubleSizeNoTag(((Double) next2).doubleValue());
                    iComputeUInt64SizeNoTag = 8;
                }
                i2 += iComputeUInt64SizeNoTag;
                it = it4;
                list = list2;
                cls = cls10;
            }
        }
    });
    private final PackedFieldWriter<Integer> int = new PackedFieldWriter<>(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$int$1
        {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
            m594invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
        public final void m594invokeOzbTUA(int i, Object obj, boolean z) {
            int iComputeUInt64SizeNoTag;
            obj.getClass();
            if (!z || !(obj instanceof List)) {
                this.this$0.output().writeSInt32(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, false & ((8 & 4) == 0), false & ((8 & 8) == 0)), ((Integer) obj).intValue());
                return;
            }
            List list = (List) obj;
            CodedOutputStream codedOutputStreamOutput = this.this$0.output();
            Class<Integer> cls = Integer.class;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
            Class cls2 = Boolean.TYPE;
            boolean zAreEqual = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2));
            Class cls3 = Double.TYPE;
            Class cls4 = Float.TYPE;
            Class cls5 = Long.TYPE;
            Class cls6 = Integer.TYPE;
            Class cls7 = Short.TYPE;
            Class cls8 = Byte.TYPE;
            if (zAreEqual) {
                ProtoFormat protoFormat = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.BOOL, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls8)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls7)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls6)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls5))) {
                ProtoFormat protoFormat2 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat2.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat2.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UByte.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UShort.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                ProtoFormat protoFormat3 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat3.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat3.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                ProtoFormat protoFormat4 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat4.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.FLOAT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat4.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                ProtoFormat protoFormat5 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat5.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.DOUBLE, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat5.getWIRETYPE_LENGTH_DELIMITED());
            }
            Iterator it = list.iterator();
            int i2 = 0;
            while (true) {
                List list2 = list;
                if (!it.hasNext()) {
                    Class<Integer> cls9 = cls;
                    codedOutputStreamOutput.writeUInt32NoTag(i2);
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(cls9);
                        Iterator it3 = it2;
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                            next.getClass();
                            codedOutputStreamOutput.writeBoolNoTag(((Boolean) next).booleanValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls8))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Byte) next).byteValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls7))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Short) next).shortValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls6))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Integer) next).intValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls5))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt64NoTag(((Long) next).longValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UByte.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UByte) next).getData() & 255);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UShort.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag((char) ((UShort) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UInt) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt64NoTag(((ULong) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                            next.getClass();
                            codedOutputStreamOutput.writeFloatNoTag(((Float) next).floatValue());
                        } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(cls9);
                            Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass3, 41), orCreateKotlinClass3, orCreateKotlinClass3, "Attempting to write an unsupported type: "));
                            return;
                        } else {
                            next.getClass();
                            codedOutputStreamOutput.writeDoubleNoTag(((Double) next).doubleValue());
                        }
                        it2 = it3;
                    }
                    return;
                }
                Object next2 = it.next();
                Class<Integer> cls10 = cls;
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(cls10);
                Iterator it4 = it;
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeBoolSizeNoTag(((Boolean) next2).booleanValue());
                    iComputeUInt64SizeNoTag = 1;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls8))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Byte) next2).byteValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls7))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Short) next2).shortValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls6))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Integer) next2).intValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls5))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt64SizeNoTag(((Long) next2).longValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UByte.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UByte) next2).getData() & 255);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UShort.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag((char) ((UShort) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UInt) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt64SizeNoTag(((ULong) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeFloatSizeNoTag(((Float) next2).floatValue());
                    iComputeUInt64SizeNoTag = 4;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls3))) {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(cls10);
                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass5, 41), orCreateKotlinClass5, orCreateKotlinClass5, "Attempting to write an unsupported type: "));
                    return;
                } else {
                    next2.getClass();
                    codedOutputStreamOutput.computeDoubleSizeNoTag(((Double) next2).doubleValue());
                    iComputeUInt64SizeNoTag = 8;
                }
                i2 += iComputeUInt64SizeNoTag;
                it = it4;
                list = list2;
                cls = cls10;
            }
        }
    });
    private final PackedFieldWriter<Long> long = new PackedFieldWriter<>(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$long$1
        {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
            m595invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
        public final void m595invokeOzbTUA(int i, Object obj, boolean z) {
            int iComputeUInt64SizeNoTag;
            obj.getClass();
            if (!z || !(obj instanceof List)) {
                this.this$0.output().writeSInt64(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, z & ((8 & 4) == 0), false & ((8 & 8) == 0)), ((Long) obj).longValue());
                return;
            }
            List list = (List) obj;
            CodedOutputStream codedOutputStreamOutput = this.this$0.output();
            Class<Long> cls = Long.class;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
            Class cls2 = Boolean.TYPE;
            boolean zAreEqual = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2));
            Class cls3 = Double.TYPE;
            Class cls4 = Float.TYPE;
            Class cls5 = Long.TYPE;
            Class cls6 = Integer.TYPE;
            Class cls7 = Short.TYPE;
            Class cls8 = Byte.TYPE;
            if (zAreEqual) {
                ProtoFormat protoFormat = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.BOOL, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls8)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls7)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls6)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls5))) {
                ProtoFormat protoFormat2 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat2.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat2.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UByte.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UShort.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                ProtoFormat protoFormat3 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat3.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat3.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                ProtoFormat protoFormat4 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat4.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.FLOAT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat4.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                ProtoFormat protoFormat5 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat5.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.DOUBLE, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat5.getWIRETYPE_LENGTH_DELIMITED());
            }
            Iterator it = list.iterator();
            int i2 = 0;
            while (true) {
                List list2 = list;
                if (!it.hasNext()) {
                    Class<Long> cls9 = cls;
                    codedOutputStreamOutput.writeUInt32NoTag(i2);
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(cls9);
                        Iterator it3 = it2;
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                            next.getClass();
                            codedOutputStreamOutput.writeBoolNoTag(((Boolean) next).booleanValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls8))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Byte) next).byteValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls7))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Short) next).shortValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls6))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Integer) next).intValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls5))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt64NoTag(((Long) next).longValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UByte.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UByte) next).getData() & 255);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UShort.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag((char) ((UShort) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UInt) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt64NoTag(((ULong) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                            next.getClass();
                            codedOutputStreamOutput.writeFloatNoTag(((Float) next).floatValue());
                        } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(cls9);
                            Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass3, 41), orCreateKotlinClass3, orCreateKotlinClass3, "Attempting to write an unsupported type: "));
                            return;
                        } else {
                            next.getClass();
                            codedOutputStreamOutput.writeDoubleNoTag(((Double) next).doubleValue());
                        }
                        it2 = it3;
                    }
                    return;
                }
                Object next2 = it.next();
                Class<Long> cls10 = cls;
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(cls10);
                Iterator it4 = it;
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeBoolSizeNoTag(((Boolean) next2).booleanValue());
                    iComputeUInt64SizeNoTag = 1;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls8))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Byte) next2).byteValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls7))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Short) next2).shortValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls6))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Integer) next2).intValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls5))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt64SizeNoTag(((Long) next2).longValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UByte.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UByte) next2).getData() & 255);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UShort.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag((char) ((UShort) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UInt) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt64SizeNoTag(((ULong) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeFloatSizeNoTag(((Float) next2).floatValue());
                    iComputeUInt64SizeNoTag = 4;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls3))) {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(cls10);
                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass5, 41), orCreateKotlinClass5, orCreateKotlinClass5, "Attempting to write an unsupported type: "));
                    return;
                } else {
                    next2.getClass();
                    codedOutputStreamOutput.computeDoubleSizeNoTag(((Double) next2).doubleValue());
                    iComputeUInt64SizeNoTag = 8;
                }
                i2 += iComputeUInt64SizeNoTag;
                it = it4;
                list = list2;
                cls = cls10;
            }
        }
    });
    private final PackedFieldWriter<UByte> ubyte = new PackedFieldWriter<>(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$ubyte$1
        {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
            m599invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
        public final void m599invokeOzbTUA(int i, Object obj, boolean z) {
            Iterator it;
            int iComputeUInt64SizeNoTag;
            obj.getClass();
            if (!z || !(obj instanceof List)) {
                this.this$0.output().writeUInt32(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, z & ((8 & 4) == 0), false & ((8 & 8) == 0)), ((UByte) obj).getData() & 255);
                return;
            }
            List list = (List) obj;
            CodedOutputStream codedOutputStreamOutput = this.this$0.output();
            Class<UByte> cls = UByte.class;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
            Class cls2 = Boolean.TYPE;
            boolean zAreEqual = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2));
            Class cls3 = Double.TYPE;
            Class cls4 = Float.TYPE;
            Class cls5 = Long.TYPE;
            Class cls6 = Integer.TYPE;
            Class cls7 = Short.TYPE;
            Class cls8 = Byte.TYPE;
            if (zAreEqual) {
                ProtoFormat protoFormat = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.BOOL, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls8)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls7)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls6)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls5))) {
                ProtoFormat protoFormat2 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat2.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat2.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UShort.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                ProtoFormat protoFormat3 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat3.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat3.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                ProtoFormat protoFormat4 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat4.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.FLOAT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat4.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                ProtoFormat protoFormat5 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat5.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.DOUBLE, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat5.getWIRETYPE_LENGTH_DELIMITED());
            }
            Iterator it2 = list.iterator();
            int i2 = 0;
            while (true) {
                List list2 = list;
                if (!it2.hasNext()) {
                    Class<UByte> cls9 = cls;
                    codedOutputStreamOutput.writeUInt32NoTag(i2);
                    Iterator it3 = list2.iterator();
                    while (it3.hasNext()) {
                        Object next = it3.next();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(cls9);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                            next.getClass();
                            codedOutputStreamOutput.writeBoolNoTag(((Boolean) next).booleanValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls8))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Byte) next).byteValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls7))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Short) next).shortValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls6))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Integer) next).intValue());
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls5))) {
                                next.getClass();
                                it = it3;
                                codedOutputStreamOutput.writeSInt64NoTag(((Long) next).longValue());
                            } else {
                                it = it3;
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls9))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt32NoTag(((UByte) next).getData() & 255);
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UShort.class))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt32NoTag((char) ((UShort) next).getData());
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt32NoTag(((UInt) next).getData());
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt64NoTag(((ULong) next).getData());
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeFloatNoTag(((Float) next).floatValue());
                                } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(cls9);
                                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass3, 41), orCreateKotlinClass3, orCreateKotlinClass3, "Attempting to write an unsupported type: "));
                                    return;
                                } else {
                                    next.getClass();
                                    codedOutputStreamOutput.writeDoubleNoTag(((Double) next).doubleValue());
                                }
                            }
                            it3 = it;
                        }
                    }
                    return;
                }
                Object next2 = it2.next();
                Class<UByte> cls10 = cls;
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(cls10);
                Iterator it4 = it2;
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeBoolSizeNoTag(((Boolean) next2).booleanValue());
                    iComputeUInt64SizeNoTag = 1;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls8))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Byte) next2).byteValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls7))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Short) next2).shortValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls6))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Integer) next2).intValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls5))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt64SizeNoTag(((Long) next2).longValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls10))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UByte) next2).getData() & 255);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UShort.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag((char) ((UShort) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UInt) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt64SizeNoTag(((ULong) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeFloatSizeNoTag(((Float) next2).floatValue());
                    iComputeUInt64SizeNoTag = 4;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls3))) {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(cls10);
                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass5, 41), orCreateKotlinClass5, orCreateKotlinClass5, "Attempting to write an unsupported type: "));
                    return;
                } else {
                    next2.getClass();
                    codedOutputStreamOutput.computeDoubleSizeNoTag(((Double) next2).doubleValue());
                    iComputeUInt64SizeNoTag = 8;
                }
                i2 += iComputeUInt64SizeNoTag;
                it2 = it4;
                list = list2;
                cls = cls10;
            }
        }
    });
    private final PackedFieldWriter<UShort> ushort = new PackedFieldWriter<>(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$ushort$1
        {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
            m602invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
        public final void m602invokeOzbTUA(int i, Object obj, boolean z) {
            Iterator it;
            int iComputeUInt64SizeNoTag;
            obj.getClass();
            if (!z || !(obj instanceof List)) {
                this.this$0.output().writeUInt32(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, z & ((8 & 4) == 0), false & ((8 & 8) == 0)), (char) ((UShort) obj).getData());
                return;
            }
            List list = (List) obj;
            CodedOutputStream codedOutputStreamOutput = this.this$0.output();
            Class<UShort> cls = UShort.class;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
            Class cls2 = Boolean.TYPE;
            boolean zAreEqual = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2));
            Class cls3 = Double.TYPE;
            Class cls4 = Float.TYPE;
            Class cls5 = Long.TYPE;
            Class cls6 = Integer.TYPE;
            Class cls7 = Short.TYPE;
            Class cls8 = Byte.TYPE;
            if (zAreEqual) {
                ProtoFormat protoFormat = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.BOOL, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls8)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls7)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls6)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls5))) {
                ProtoFormat protoFormat2 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat2.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat2.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UByte.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                ProtoFormat protoFormat3 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat3.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat3.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                ProtoFormat protoFormat4 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat4.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.FLOAT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat4.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                ProtoFormat protoFormat5 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat5.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.DOUBLE, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat5.getWIRETYPE_LENGTH_DELIMITED());
            }
            Iterator it2 = list.iterator();
            int i2 = 0;
            while (true) {
                List list2 = list;
                if (!it2.hasNext()) {
                    Class<UShort> cls9 = cls;
                    codedOutputStreamOutput.writeUInt32NoTag(i2);
                    Iterator it3 = list2.iterator();
                    while (it3.hasNext()) {
                        Object next = it3.next();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(cls9);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                            next.getClass();
                            codedOutputStreamOutput.writeBoolNoTag(((Boolean) next).booleanValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls8))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Byte) next).byteValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls7))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Short) next).shortValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls6))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Integer) next).intValue());
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls5))) {
                                next.getClass();
                                it = it3;
                                codedOutputStreamOutput.writeSInt64NoTag(((Long) next).longValue());
                            } else {
                                it = it3;
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UByte.class))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt32NoTag(((UByte) next).getData() & 255);
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls9))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt32NoTag((char) ((UShort) next).getData());
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt32NoTag(((UInt) next).getData());
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt64NoTag(((ULong) next).getData());
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeFloatNoTag(((Float) next).floatValue());
                                } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(cls9);
                                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass3, 41), orCreateKotlinClass3, orCreateKotlinClass3, "Attempting to write an unsupported type: "));
                                    return;
                                } else {
                                    next.getClass();
                                    codedOutputStreamOutput.writeDoubleNoTag(((Double) next).doubleValue());
                                }
                            }
                            it3 = it;
                        }
                    }
                    return;
                }
                Object next2 = it2.next();
                Class<UShort> cls10 = cls;
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(cls10);
                Iterator it4 = it2;
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeBoolSizeNoTag(((Boolean) next2).booleanValue());
                    iComputeUInt64SizeNoTag = 1;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls8))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Byte) next2).byteValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls7))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Short) next2).shortValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls6))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Integer) next2).intValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls5))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt64SizeNoTag(((Long) next2).longValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UByte.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UByte) next2).getData() & 255);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls10))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag((char) ((UShort) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UInt) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt64SizeNoTag(((ULong) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeFloatSizeNoTag(((Float) next2).floatValue());
                    iComputeUInt64SizeNoTag = 4;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls3))) {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(cls10);
                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass5, 41), orCreateKotlinClass5, orCreateKotlinClass5, "Attempting to write an unsupported type: "));
                    return;
                } else {
                    next2.getClass();
                    codedOutputStreamOutput.computeDoubleSizeNoTag(((Double) next2).doubleValue());
                    iComputeUInt64SizeNoTag = 8;
                }
                i2 += iComputeUInt64SizeNoTag;
                it2 = it4;
                list = list2;
                cls = cls10;
            }
        }
    });
    private final PackedFieldWriter<UInt> uint = new PackedFieldWriter<>(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$uint$1
        {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
            m600invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
        public final void m600invokeOzbTUA(int i, Object obj, boolean z) {
            Iterator it;
            int iComputeUInt64SizeNoTag;
            obj.getClass();
            if (!z || !(obj instanceof List)) {
                this.this$0.output().writeUInt32(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, z & ((8 & 4) == 0), false & ((8 & 8) == 0)), ((UInt) obj).getData());
                return;
            }
            List list = (List) obj;
            CodedOutputStream codedOutputStreamOutput = this.this$0.output();
            Class<UInt> cls = UInt.class;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
            Class cls2 = Boolean.TYPE;
            boolean zAreEqual = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2));
            Class cls3 = Double.TYPE;
            Class cls4 = Float.TYPE;
            Class cls5 = Long.TYPE;
            Class cls6 = Integer.TYPE;
            Class cls7 = Short.TYPE;
            Class cls8 = Byte.TYPE;
            if (zAreEqual) {
                ProtoFormat protoFormat = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.BOOL, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls8)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls7)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls6)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls5))) {
                ProtoFormat protoFormat2 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat2.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat2.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UByte.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UShort.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                ProtoFormat protoFormat3 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat3.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat3.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                ProtoFormat protoFormat4 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat4.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.FLOAT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat4.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                ProtoFormat protoFormat5 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat5.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.DOUBLE, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat5.getWIRETYPE_LENGTH_DELIMITED());
            }
            Iterator it2 = list.iterator();
            int i2 = 0;
            while (true) {
                List list2 = list;
                if (!it2.hasNext()) {
                    Class<UInt> cls9 = cls;
                    codedOutputStreamOutput.writeUInt32NoTag(i2);
                    Iterator it3 = list2.iterator();
                    while (it3.hasNext()) {
                        Object next = it3.next();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(cls9);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                            next.getClass();
                            codedOutputStreamOutput.writeBoolNoTag(((Boolean) next).booleanValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls8))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Byte) next).byteValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls7))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Short) next).shortValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls6))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Integer) next).intValue());
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls5))) {
                                next.getClass();
                                it = it3;
                                codedOutputStreamOutput.writeSInt64NoTag(((Long) next).longValue());
                            } else {
                                it = it3;
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UByte.class))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt32NoTag(((UByte) next).getData() & 255);
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UShort.class))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt32NoTag((char) ((UShort) next).getData());
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls9))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt32NoTag(((UInt) next).getData());
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt64NoTag(((ULong) next).getData());
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeFloatNoTag(((Float) next).floatValue());
                                } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(cls9);
                                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass3, 41), orCreateKotlinClass3, orCreateKotlinClass3, "Attempting to write an unsupported type: "));
                                    return;
                                } else {
                                    next.getClass();
                                    codedOutputStreamOutput.writeDoubleNoTag(((Double) next).doubleValue());
                                }
                            }
                            it3 = it;
                        }
                    }
                    return;
                }
                Object next2 = it2.next();
                Class<UInt> cls10 = cls;
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(cls10);
                Iterator it4 = it2;
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeBoolSizeNoTag(((Boolean) next2).booleanValue());
                    iComputeUInt64SizeNoTag = 1;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls8))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Byte) next2).byteValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls7))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Short) next2).shortValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls6))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Integer) next2).intValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls5))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt64SizeNoTag(((Long) next2).longValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UByte.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UByte) next2).getData() & 255);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UShort.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag((char) ((UShort) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls10))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UInt) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt64SizeNoTag(((ULong) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeFloatSizeNoTag(((Float) next2).floatValue());
                    iComputeUInt64SizeNoTag = 4;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls3))) {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(cls10);
                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass5, 41), orCreateKotlinClass5, orCreateKotlinClass5, "Attempting to write an unsupported type: "));
                    return;
                } else {
                    next2.getClass();
                    codedOutputStreamOutput.computeDoubleSizeNoTag(((Double) next2).doubleValue());
                    iComputeUInt64SizeNoTag = 8;
                }
                i2 += iComputeUInt64SizeNoTag;
                it2 = it4;
                list = list2;
                cls = cls10;
            }
        }
    });
    private final PackedFieldWriter<ULong> ulong = new PackedFieldWriter<>(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$ulong$1
        {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
            m601invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
        public final void m601invokeOzbTUA(int i, Object obj, boolean z) {
            Iterator it;
            int iComputeUInt64SizeNoTag;
            obj.getClass();
            if (!z || !(obj instanceof List)) {
                this.this$0.output().writeUInt64(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, z & ((8 & 4) == 0), false & ((8 & 8) == 0)), ((ULong) obj).getData());
                return;
            }
            List list = (List) obj;
            CodedOutputStream codedOutputStreamOutput = this.this$0.output();
            Class<ULong> cls = ULong.class;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
            Class cls2 = Boolean.TYPE;
            boolean zAreEqual = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2));
            Class cls3 = Double.TYPE;
            Class cls4 = Float.TYPE;
            Class cls5 = Long.TYPE;
            Class cls6 = Integer.TYPE;
            Class cls7 = Short.TYPE;
            Class cls8 = Byte.TYPE;
            if (zAreEqual) {
                ProtoFormat protoFormat = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.BOOL, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls8)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls7)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls6)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls5))) {
                ProtoFormat protoFormat2 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat2.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat2.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UByte.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UShort.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                ProtoFormat protoFormat3 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat3.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat3.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                ProtoFormat protoFormat4 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat4.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.FLOAT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat4.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                ProtoFormat protoFormat5 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat5.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.DOUBLE, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat5.getWIRETYPE_LENGTH_DELIMITED());
            }
            Iterator it2 = list.iterator();
            int i2 = 0;
            while (true) {
                List list2 = list;
                if (!it2.hasNext()) {
                    Class<ULong> cls9 = cls;
                    codedOutputStreamOutput.writeUInt32NoTag(i2);
                    Iterator it3 = list2.iterator();
                    while (it3.hasNext()) {
                        Object next = it3.next();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(cls9);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                            next.getClass();
                            codedOutputStreamOutput.writeBoolNoTag(((Boolean) next).booleanValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls8))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Byte) next).byteValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls7))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Short) next).shortValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls6))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Integer) next).intValue());
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls5))) {
                                next.getClass();
                                it = it3;
                                codedOutputStreamOutput.writeSInt64NoTag(((Long) next).longValue());
                            } else {
                                it = it3;
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UByte.class))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt32NoTag(((UByte) next).getData() & 255);
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UShort.class))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt32NoTag((char) ((UShort) next).getData());
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt32NoTag(((UInt) next).getData());
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls9))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeUInt64NoTag(((ULong) next).getData());
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                                    next.getClass();
                                    codedOutputStreamOutput.writeFloatNoTag(((Float) next).floatValue());
                                } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(cls9);
                                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass3, 41), orCreateKotlinClass3, orCreateKotlinClass3, "Attempting to write an unsupported type: "));
                                    return;
                                } else {
                                    next.getClass();
                                    codedOutputStreamOutput.writeDoubleNoTag(((Double) next).doubleValue());
                                }
                            }
                            it3 = it;
                        }
                    }
                    return;
                }
                Object next2 = it2.next();
                Class<ULong> cls10 = cls;
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(cls10);
                Iterator it4 = it2;
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeBoolSizeNoTag(((Boolean) next2).booleanValue());
                    iComputeUInt64SizeNoTag = 1;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls8))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Byte) next2).byteValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls7))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Short) next2).shortValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls6))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Integer) next2).intValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls5))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt64SizeNoTag(((Long) next2).longValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UByte.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UByte) next2).getData() & 255);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UShort.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag((char) ((UShort) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UInt) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls10))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt64SizeNoTag(((ULong) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeFloatSizeNoTag(((Float) next2).floatValue());
                    iComputeUInt64SizeNoTag = 4;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls3))) {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(cls10);
                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass5, 41), orCreateKotlinClass5, orCreateKotlinClass5, "Attempting to write an unsupported type: "));
                    return;
                } else {
                    next2.getClass();
                    codedOutputStreamOutput.computeDoubleSizeNoTag(((Double) next2).doubleValue());
                    iComputeUInt64SizeNoTag = 8;
                }
                i2 += iComputeUInt64SizeNoTag;
                it2 = it4;
                list = list2;
                cls = cls10;
            }
        }
    });
    private final PackedFieldWriter<Float> float = new PackedFieldWriter<>(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$float$1
        {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
            m593invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
        public final void m593invokeOzbTUA(int i, Object obj, boolean z) {
            int iComputeUInt64SizeNoTag;
            obj.getClass();
            if (!z || !(obj instanceof List)) {
                this.this$0.output().writeFloat(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.FLOAT, z & ((8 & 4) == 0), false & ((8 & 8) == 0)), ((Float) obj).floatValue());
                return;
            }
            List list = (List) obj;
            CodedOutputStream codedOutputStreamOutput = this.this$0.output();
            Class<Float> cls = Float.class;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
            Class cls2 = Boolean.TYPE;
            boolean zAreEqual = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2));
            Class cls3 = Double.TYPE;
            Class cls4 = Float.TYPE;
            Class cls5 = Long.TYPE;
            Class cls6 = Integer.TYPE;
            Class cls7 = Short.TYPE;
            Class cls8 = Byte.TYPE;
            if (zAreEqual) {
                ProtoFormat protoFormat = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.BOOL, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls8)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls7)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls6)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls5))) {
                ProtoFormat protoFormat2 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat2.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat2.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UByte.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UShort.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                ProtoFormat protoFormat3 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat3.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat3.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                ProtoFormat protoFormat4 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat4.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.FLOAT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat4.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                ProtoFormat protoFormat5 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat5.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.DOUBLE, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat5.getWIRETYPE_LENGTH_DELIMITED());
            }
            Iterator it = list.iterator();
            int i2 = 0;
            while (true) {
                List list2 = list;
                if (!it.hasNext()) {
                    Class<Float> cls9 = cls;
                    codedOutputStreamOutput.writeUInt32NoTag(i2);
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(cls9);
                        Iterator it3 = it2;
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                            next.getClass();
                            codedOutputStreamOutput.writeBoolNoTag(((Boolean) next).booleanValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls8))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Byte) next).byteValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls7))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Short) next).shortValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls6))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Integer) next).intValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls5))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt64NoTag(((Long) next).longValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UByte.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UByte) next).getData() & 255);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UShort.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag((char) ((UShort) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UInt) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt64NoTag(((ULong) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                            next.getClass();
                            codedOutputStreamOutput.writeFloatNoTag(((Float) next).floatValue());
                        } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(cls9);
                            Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass3, 41), orCreateKotlinClass3, orCreateKotlinClass3, "Attempting to write an unsupported type: "));
                            return;
                        } else {
                            next.getClass();
                            codedOutputStreamOutput.writeDoubleNoTag(((Double) next).doubleValue());
                        }
                        it2 = it3;
                    }
                    return;
                }
                Object next2 = it.next();
                Class<Float> cls10 = cls;
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(cls10);
                Iterator it4 = it;
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeBoolSizeNoTag(((Boolean) next2).booleanValue());
                    iComputeUInt64SizeNoTag = 1;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls8))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Byte) next2).byteValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls7))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Short) next2).shortValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls6))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Integer) next2).intValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls5))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt64SizeNoTag(((Long) next2).longValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UByte.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UByte) next2).getData() & 255);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UShort.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag((char) ((UShort) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UInt) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt64SizeNoTag(((ULong) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeFloatSizeNoTag(((Float) next2).floatValue());
                    iComputeUInt64SizeNoTag = 4;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls3))) {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(cls10);
                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass5, 41), orCreateKotlinClass5, orCreateKotlinClass5, "Attempting to write an unsupported type: "));
                    return;
                } else {
                    next2.getClass();
                    codedOutputStreamOutput.computeDoubleSizeNoTag(((Double) next2).doubleValue());
                    iComputeUInt64SizeNoTag = 8;
                }
                i2 += iComputeUInt64SizeNoTag;
                it = it4;
                list = list2;
                cls = cls10;
            }
        }
    });
    private final PackedFieldWriter<Double> double = new PackedFieldWriter<>(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$double$1
        {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
            m592invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
        public final void m592invokeOzbTUA(int i, Object obj, boolean z) {
            int iComputeUInt64SizeNoTag;
            obj.getClass();
            if (!z || !(obj instanceof List)) {
                this.this$0.output().writeDouble(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.DOUBLE, z & ((8 & 4) == 0), false & ((8 & 8) == 0)), ((Double) obj).doubleValue());
                return;
            }
            List list = (List) obj;
            CodedOutputStream codedOutputStreamOutput = this.this$0.output();
            Class<Double> cls = Double.class;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
            Class cls2 = Boolean.TYPE;
            boolean zAreEqual = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2));
            Class cls3 = Double.TYPE;
            Class cls4 = Float.TYPE;
            Class cls5 = Long.TYPE;
            Class cls6 = Integer.TYPE;
            Class cls7 = Short.TYPE;
            Class cls8 = Byte.TYPE;
            if (zAreEqual) {
                ProtoFormat protoFormat = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.BOOL, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls8)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls7)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls6)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls5))) {
                ProtoFormat protoFormat2 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat2.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.INT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat2.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UByte.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UShort.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                ProtoFormat protoFormat3 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat3.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.UINT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat3.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                ProtoFormat protoFormat4 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat4.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.FLOAT, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat4.getWIRETYPE_LENGTH_DELIMITED());
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                ProtoFormat protoFormat5 = ProtoFormat.INSTANCE;
                codedOutputStreamOutput.writeTag(protoFormat5.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.DOUBLE, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), protoFormat5.getWIRETYPE_LENGTH_DELIMITED());
            }
            Iterator it = list.iterator();
            int i2 = 0;
            while (true) {
                List list2 = list;
                if (!it.hasNext()) {
                    Class<Double> cls9 = cls;
                    codedOutputStreamOutput.writeUInt32NoTag(i2);
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(cls9);
                        Iterator it3 = it2;
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                            next.getClass();
                            codedOutputStreamOutput.writeBoolNoTag(((Boolean) next).booleanValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls8))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Byte) next).byteValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls7))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Short) next).shortValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls6))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt32NoTag(((Integer) next).intValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls5))) {
                            next.getClass();
                            codedOutputStreamOutput.writeSInt64NoTag(((Long) next).longValue());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UByte.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UByte) next).getData() & 255);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UShort.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag((char) ((UShort) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt32NoTag(((UInt) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            next.getClass();
                            codedOutputStreamOutput.writeUInt64NoTag(((ULong) next).getData());
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                            next.getClass();
                            codedOutputStreamOutput.writeFloatNoTag(((Float) next).floatValue());
                        } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(cls9);
                            Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass3, 41), orCreateKotlinClass3, orCreateKotlinClass3, "Attempting to write an unsupported type: "));
                            return;
                        } else {
                            next.getClass();
                            codedOutputStreamOutput.writeDoubleNoTag(((Double) next).doubleValue());
                        }
                        it2 = it3;
                    }
                    return;
                }
                Object next2 = it.next();
                Class<Double> cls10 = cls;
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(cls10);
                Iterator it4 = it;
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeBoolSizeNoTag(((Boolean) next2).booleanValue());
                    iComputeUInt64SizeNoTag = 1;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls8))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Byte) next2).byteValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls7))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Short) next2).shortValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls6))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt32SizeNoTag(((Integer) next2).intValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls5))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeSInt64SizeNoTag(((Long) next2).longValue());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UByte.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UByte) next2).getData() & 255);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UShort.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag((char) ((UShort) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt32SizeNoTag(((UInt) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    next2.getClass();
                    iComputeUInt64SizeNoTag = codedOutputStreamOutput.computeUInt64SizeNoTag(((ULong) next2).getData());
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                    next2.getClass();
                    codedOutputStreamOutput.computeFloatSizeNoTag(((Float) next2).floatValue());
                    iComputeUInt64SizeNoTag = 4;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls3))) {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(cls10);
                    Utf8$$ExternalSyntheticBUOutline0.m$2(zza$$ExternalSyntheticOutline0.m(zza$$ExternalSyntheticOutline0.m(orCreateKotlinClass5, 41), orCreateKotlinClass5, orCreateKotlinClass5, "Attempting to write an unsupported type: "));
                    return;
                } else {
                    next2.getClass();
                    codedOutputStreamOutput.computeDoubleSizeNoTag(((Double) next2).doubleValue());
                    iComputeUInt64SizeNoTag = 8;
                }
                i2 += iComputeUInt64SizeNoTag;
                it = it4;
                list = list2;
                cls = cls10;
            }
        }
    });
    private final SimpleFieldWriter<String> string = new SimpleFieldWriter<>(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$string$1
        {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
            m597invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
        public final void m597invokeOzbTUA(int i, Object obj, boolean z) {
            obj.getClass();
            this.this$0.output().writeString(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.CHAR_STRING, z & ((8 & 4) == 0), false & ((8 & 8) == 0)), (String) obj);
        }
    });
    private final SimpleFieldWriter<byte[]> bytearray = new SimpleFieldWriter<>(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$bytearray$1
        {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
            m591invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
        public final void m591invokeOzbTUA(int i, Object obj, boolean z) {
            obj.getClass();
            this.this$0.output().writeByteArray(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.BYTE_STRING, z & ((8 & 4) == 0), false & ((8 & 8) == 0)), (byte[]) obj);
        }
    });
    private final ClusterPayloadWriter.FieldWriter<Bitmap> bitmap = getUlong().adapt(Bitmap.INSTANCE);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter$Level;", "", "fieldNumber", "", "<init>", "(I)V", "getFieldNumber", "()I", "byteArrayOutputStream", "Lcom/google/home/matter/serialization/codec/proto/ByteArrayOutputStream;", "getByteArrayOutputStream", "()Lcom/google/home/matter/serialization/codec/proto/ByteArrayOutputStream;", "codedOutputStream", "Lcom/google/home/matter/serialization/codec/proto/CodedOutputStream;", "getCodedOutputStream", "()Lcom/google/home/matter/serialization/codec/proto/CodedOutputStream;", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Level {
        private final ByteArrayOutputStream byteArrayOutputStream;
        private final CodedOutputStream codedOutputStream;
        private final int fieldNumber;

        public Level(int i) {
            this.fieldNumber = i;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.byteArrayOutputStream = byteArrayOutputStream;
            this.codedOutputStream = CodedOutputStream.INSTANCE.newInstance(byteArrayOutputStream);
        }

        public final ByteArrayOutputStream getByteArrayOutputStream() {
            return this.byteArrayOutputStream;
        }

        public final CodedOutputStream getCodedOutputStream() {
            return this.codedOutputStream;
        }

        public final int getFieldNumber() {
            return this.fieldNumber;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0012\u0004\u0012\u00028\u00000\u0003R\u00020\u0004B+\u0012\"\u0010\n\u001a\u001e\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0012\u001a\u00020\t2\n\u0010\r\u001a\u00060\u0006j\u0002`\u00072\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016\"\b\b\u0001\u0010\u0013*\u00020\u00012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R0\u0010\n\u001a\u001e\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter$PackedFieldWriter;", "", "T", "Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter$SimpleFieldWriter;", "Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter;", "Lkotlin/Function3;", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "", "", "impl", "<init>", "(Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter;Lkotlin/jvm/functions/Function3;)V", "tag", "", SDKConstants.PARAM_VALUE, "writeList-qim9Vi0", "(ILjava/util/List;)V", "writeList", "NEWTYPE", "Lcom/google/home/matter/serialization/FieldAdapter;", "adapter", "Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "adapt", "(Lcom/google/home/matter/serialization/FieldAdapter;)Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "Lkotlin/jvm/functions/Function3;", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class PackedFieldWriter<T> extends SimpleFieldWriter<T> {
        private final Function3<UInt, Object, Boolean, Unit> impl;
        final /* synthetic */ ProtoClusterWriter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public PackedFieldWriter(ProtoClusterWriter protoClusterWriter, Function3<? super UInt, Object, ? super Boolean, Unit> function3) {
            super(protoClusterWriter, function3);
            function3.getClass();
            this.this$0 = protoClusterWriter;
            this.impl = function3;
        }

        @Override // com.google.home.matter.serialization.codec.proto.ProtoClusterWriter.SimpleFieldWriter, com.google.home.matter.serialization.ClusterPayloadWriter.FieldWriter
        public <NEWTYPE> ClusterPayloadWriter.FieldWriter<NEWTYPE> adapt(final FieldAdapter<T, NEWTYPE> adapter) {
            adapter.getClass();
            return new PackedFieldWriter(this.this$0, new Function3<UInt, Object, Boolean, Unit>(this) { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$PackedFieldWriter$adapt$1
                final /* synthetic */ ProtoClusterWriter.PackedFieldWriter<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
                    m587invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
                public final void m587invokeOzbTUA(int i, Object obj, boolean z) {
                    obj.getClass();
                    if (!z || !(obj instanceof List)) {
                        ((ProtoClusterWriter.PackedFieldWriter) this.this$0).impl.invoke(UInt.m2388boximpl(i), adapter.toRaw(obj), Boolean.FALSE);
                        return;
                    }
                    Function3 function3 = ((ProtoClusterWriter.PackedFieldWriter) this.this$0).impl;
                    UInt uIntM2388boximpl = UInt.m2388boximpl(i);
                    List list = (List) obj;
                    FieldAdapter fieldAdapter = adapter;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (Object obj2 : list) {
                        obj2.getClass();
                        arrayList.add(fieldAdapter.toRaw(obj2));
                    }
                    function3.invoke(uIntM2388boximpl, arrayList, Boolean.TRUE);
                }
            });
        }

        @Override // com.google.home.matter.serialization.codec.proto.ProtoClusterWriter.SimpleFieldWriter, com.google.home.matter.serialization.ClusterPayloadWriter.FieldWriter
        /* JADX INFO: renamed from: writeList-qim9Vi0 */
        public void mo555writeListqim9Vi0(int tag, List<? extends T> value) {
            boolean zM586maybePushLevelWZ4Q5Ns = this.this$0.m586maybePushLevelWZ4Q5Ns(tag);
            if (value == null) {
                this.this$0.output().writeBool(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(TagIdKt.m567idWZ4Q5Ns(tag), ProtoFormat.Type.NULL, false & ((8 & 4) == 0), false & ((8 & 8) == 0)), true);
            } else if (value.isEmpty()) {
                this.this$0.output().writeBool(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(TagIdKt.m567idWZ4Q5Ns(tag), ProtoFormat.Type.NULL, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), true);
            } else {
                this.impl.invoke(UInt.m2388boximpl(TagIdKt.m567idWZ4Q5Ns(tag)), value, Boolean.TRUE);
            }
            this.this$0.maybePopLevel(zM586maybePushLevelWZ4Q5Ns);
        }
    }

    public ProtoClusterWriter(boolean z) {
        this.strictOperationValidation = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybePopLevel(boolean maybe) {
        if (maybe) {
            popLevel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: maybePushLevel-WZ4Q5Ns, reason: not valid java name */
    public final boolean m586maybePushLevelWZ4Q5Ns(int tag) {
        int iM569vendorWZ4Q5Ns = TagIdKt.m569vendorWZ4Q5Ns(tag);
        if (iM569vendorWZ4Q5Ns == 0) {
            return false;
        }
        pushLevel(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(iM569vendorWZ4Q5Ns, ProtoFormat.Type.NULL, false & ((8 & 4) == 0), true & ((8 & 8) == 0)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CodedOutputStream output() {
        return ((Level) CollectionsKt.last((List) this.levels)).getCodedOutputStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void popLevel() {
        if (this.levels.size() <= 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Cannot pop last level");
            return;
        }
        output().flush();
        byte[] byteArray = underlying().toByteArray();
        int fieldNumber = ((Level) CollectionsKt.last((List) this.levels)).getFieldNumber();
        CollectionsKt.removeLast(this.levels);
        output().writeByteArray(fieldNumber, byteArray);
    }

    private final ByteArrayOutputStream primaryOutputStream() throws IOException {
        Level level;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ((Level) CollectionsKt.first((List) this.levels)).getCodedOutputStream().flush();
        Level level2 = (Level) CollectionsKt.lastOrNull((List) this.wrapperLevels);
        if (level2 != null && (byteArrayOutputStream2 = level2.getByteArrayOutputStream()) != null) {
            byteArrayOutputStream2.write(((Level) CollectionsKt.first((List) this.levels)).getByteArrayOutputStream().toByteArray());
        }
        List<Level> list = this.wrapperLevels;
        ListIterator<Level> listIterator = list.listIterator(list.size());
        if (listIterator.hasPrevious()) {
            Level levelPrevious = listIterator.previous();
            while (listIterator.hasPrevious()) {
                Level level3 = levelPrevious;
                Level levelPrevious2 = listIterator.previous();
                levelPrevious2.getByteArrayOutputStream().reset();
                level3.getCodedOutputStream().flush();
                levelPrevious2.getCodedOutputStream().writeByteArray(level3.getFieldNumber(), level3.getByteArrayOutputStream().toByteArray());
                levelPrevious2.getCodedOutputStream().flush();
                levelPrevious = levelPrevious2;
            }
            level = levelPrevious;
        } else {
            level = null;
        }
        Level level4 = level;
        return (level4 == null || (byteArrayOutputStream = level4.getByteArrayOutputStream()) == null) ? ((Level) CollectionsKt.first((List) this.levels)).getByteArrayOutputStream() : byteArrayOutputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pushLevel(int fieldNumber) {
        if (this.levels.size() < 100) {
            this.levels.add(new Level(fieldNumber));
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Cannot push too many levels");
        }
    }

    private final ByteArrayOutputStream underlying() {
        return ((Level) CollectionsKt.last((List) this.levels)).getByteArrayOutputStream();
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
    public boolean getStrictOperationValidation() {
        return this.strictOperationValidation;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public <T> ClusterPayloadWriter.FieldWriter<T> struct(final StructAdapter<T> adapter) {
        adapter.getClass();
        return new SimpleFieldWriter(this, new Function3<UInt, Object, Boolean, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter.struct.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
                m598invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
            public final void m598invokeOzbTUA(int i, Object obj, boolean z) {
                obj.getClass();
                ProtoClusterWriter.this.pushLevel(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(i, ProtoFormat.Type.STRUCT, z & ((8 & 4) == 0), false & ((8 & 8) == 0)));
                adapter.write(ProtoClusterWriter.this, obj);
                ProtoClusterWriter.this.popLevel();
            }
        });
    }

    public String toString() {
        return zzvo.zzb(primaryOutputStream().toByteArray());
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public void wrapPayload(List<UInt> tags) {
        tags.getClass();
        Iterator<UInt> it = tags.iterator();
        while (it.hasNext()) {
            this.wrapperLevels.add(new Level(ProtoFormat.INSTANCE.m606makeContainerFieldNumberWZ4Q5Ns(it.next().getData())));
        }
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public <T> void write(StructAdapter<T> adapter, T value) {
        adapter.getClass();
        adapter.write(this, value);
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public PackedFieldWriter<Boolean> getBoolean() {
        return this.boolean;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public PackedFieldWriter<Byte> getByte() {
        return this.byte;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public SimpleFieldWriter<byte[]> getBytearray() {
        return this.bytearray;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public PackedFieldWriter<Double> getDouble() {
        return this.double;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public PackedFieldWriter<Float> getFloat() {
        return this.float;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public PackedFieldWriter<Integer> getInt() {
        return this.int;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public PackedFieldWriter<Long> getLong() {
        return this.long;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public PackedFieldWriter<Short> getShort() {
        return this.short;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public SimpleFieldWriter<String> getString() {
        return this.string;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public PackedFieldWriter<UByte> getUbyte() {
        return this.ubyte;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public PackedFieldWriter<UInt> getUint() {
        return this.uint;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public PackedFieldWriter<ULong> getUlong() {
        return this.ulong;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadWriter
    public PackedFieldWriter<UShort> getUshort() {
        return this.ushort;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0096\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B+\u0012\"\u0010\t\u001a\u001e\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0010\u001a\u00020\b2\n\u0010\f\u001a\u00060\u0005j\u0002`\u00062\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0010\u001a\u00020\b2\n\u0010\f\u001a\u00060\u0005j\u0002`\u00062\u0010\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0011H\u0016¢\u0006\u0004\b\u000e\u0010\u0012J+\u0010\u0016\u001a\u00020\b2\n\u0010\f\u001a\u00060\u0005j\u0002`\u00062\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0001\u0010\u0017*\u00020\u00012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR0\u0010\t\u001a\u001e\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter$SimpleFieldWriter;", "", "T", "Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "Lkotlin/Function3;", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "", "", "impl", "<init>", "(Lcom/google/home/matter/serialization/codec/proto/ProtoClusterWriter;Lkotlin/jvm/functions/Function3;)V", "tag", SDKConstants.PARAM_VALUE, "write-qim9Vi0", "(ILjava/lang/Object;)V", "write", "Lcom/google/home/matter/serialization/OptionalValue;", "(ILcom/google/home/matter/serialization/OptionalValue;)V", "", "writeList-qim9Vi0", "(ILjava/util/List;)V", "writeList", "NEWTYPE", "Lcom/google/home/matter/serialization/FieldAdapter;", "adapter", "adapt", "(Lcom/google/home/matter/serialization/FieldAdapter;)Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "Lkotlin/jvm/functions/Function3;", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public class SimpleFieldWriter<T> implements ClusterPayloadWriter.FieldWriter<T> {
        private final Function3<UInt, Object, Boolean, Unit> impl;
        final /* synthetic */ ProtoClusterWriter this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public SimpleFieldWriter(ProtoClusterWriter protoClusterWriter, Function3<? super UInt, Object, ? super Boolean, Unit> function3) {
            function3.getClass();
            this.this$0 = protoClusterWriter;
            this.impl = function3;
        }

        @Override // com.google.home.matter.serialization.ClusterPayloadWriter.FieldWriter
        public <NEWTYPE> ClusterPayloadWriter.FieldWriter<NEWTYPE> adapt(final FieldAdapter<T, NEWTYPE> adapter) {
            adapter.getClass();
            return new SimpleFieldWriter(this.this$0, new Function3<UInt, Object, Boolean, Unit>(this) { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$SimpleFieldWriter$adapt$1
                final /* synthetic */ ProtoClusterWriter.SimpleFieldWriter<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(UInt uInt, Object obj, Boolean bool) {
                    m588invokeOzbTUA(uInt.getData(), obj, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-OzbTU-A, reason: not valid java name */
                public final void m588invokeOzbTUA(int i, Object obj, boolean z) {
                    obj.getClass();
                    ((ProtoClusterWriter.SimpleFieldWriter) this.this$0).impl.invoke(UInt.m2388boximpl(i), adapter.toRaw(obj), Boolean.valueOf(z));
                }
            });
        }

        @Override // com.google.home.matter.serialization.ClusterPayloadWriter.FieldWriter
        /* JADX INFO: renamed from: write-qim9Vi0 */
        public void mo554writeqim9Vi0(int tag, T value) {
            boolean zM586maybePushLevelWZ4Q5Ns = this.this$0.m586maybePushLevelWZ4Q5Ns(tag);
            if (value == null) {
                this.this$0.output().writeBool(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(TagIdKt.m567idWZ4Q5Ns(tag), ProtoFormat.Type.NULL, false & ((8 & 4) == 0), false & ((8 & 8) == 0)), true);
            } else {
                this.impl.invoke(UInt.m2388boximpl(TagIdKt.m567idWZ4Q5Ns(tag)), value, Boolean.FALSE);
            }
            this.this$0.maybePopLevel(zM586maybePushLevelWZ4Q5Ns);
        }

        @Override // com.google.home.matter.serialization.ClusterPayloadWriter.FieldWriter
        /* JADX INFO: renamed from: writeList-qim9Vi0 */
        public void mo555writeListqim9Vi0(int tag, List<? extends T> value) {
            boolean zM586maybePushLevelWZ4Q5Ns = this.this$0.m586maybePushLevelWZ4Q5Ns(tag);
            if (value == null) {
                this.this$0.output().writeBool(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(TagIdKt.m567idWZ4Q5Ns(tag), ProtoFormat.Type.NULL, false & ((8 & 4) == 0), false & ((8 & 8) == 0)), true);
            } else if (value.isEmpty()) {
                this.this$0.output().writeBool(ProtoFormat.INSTANCE.m607makeFieldNumberSGjrQA4(TagIdKt.m567idWZ4Q5Ns(tag), ProtoFormat.Type.NULL, true & ((8 & 4) == 0), false & ((8 & 8) == 0)), true);
            } else {
                List<? extends T> list = value;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        this.impl.invoke(UInt.m2388boximpl(TagIdKt.m567idWZ4Q5Ns(tag)), it.next(), Boolean.TRUE);
                    }
                }
            }
            this.this$0.maybePopLevel(zM586maybePushLevelWZ4Q5Ns);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.home.matter.serialization.ClusterPayloadWriter.FieldWriter
        /* JADX INFO: renamed from: write-qim9Vi0 */
        public void mo553writeqim9Vi0(final int tag, OptionalValue<? extends T> value) {
            value.getClass();
            value.doWhenPresent(new Function1<?, Unit>(this) { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterWriter$SimpleFieldWriter$write$1
                final /* synthetic */ ProtoClusterWriter.SimpleFieldWriter<T> this$0;

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
}
