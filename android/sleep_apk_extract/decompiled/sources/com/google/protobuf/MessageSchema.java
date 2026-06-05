package com.google.protobuf;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes4.dex */
final class MessageSchema<T> implements Schema<T> {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;

    /* JADX INFO: renamed from: com.google.protobuf.MessageSchema$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i3, int i4, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z2;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t, T t2, int i) {
        return isFieldPresent(t, i) == isFieldPresent(t2, i);
    }

    private static <T> boolean booleanAt(T t, long j) {
        return UnsafeUtil.getBoolean(t, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
        int i3 = registers.int1;
        if (i3 < 0 || i3 > i2 - iDecodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i4 = iDecodeVarint32 + i3;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint32 < i4) {
            int iDecodeVarint322 = iDecodeVarint32 + 1;
            int i5 = bArr[iDecodeVarint32];
            if (i5 < 0) {
                iDecodeVarint322 = ArrayDecoders.decodeVarint32(i5, bArr, iDecodeVarint322, registers);
                i5 = registers.int1;
            }
            int i6 = iDecodeVarint322;
            int i7 = i5 >>> 3;
            int i8 = i5 & 7;
            if (i7 != 1) {
                if (i7 == 2 && i8 == metadata.valueType.getWireType()) {
                    iDecodeVarint32 = decodeMapEntryValue(bArr, i6, i2, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                } else {
                    iDecodeVarint32 = ArrayDecoders.skipField(i5, bArr, i6, i2, registers);
                }
            } else if (i8 == metadata.keyType.getWireType()) {
                iDecodeVarint32 = decodeMapEntryValue(bArr, i6, i2, metadata.keyType, null, registers);
                obj = registers.object1;
            } else {
                iDecodeVarint32 = ArrayDecoders.skipField(i5, bArr, i6, i2, registers);
            }
        }
        if (iDecodeVarint32 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i4;
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i2, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i2, registers);
            case 15:
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint322;
            case 16:
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                Types$$ExternalSyntheticBUOutline0.m$2("unsupported field type.");
                return 0;
        }
    }

    private static <T> double doubleAt(T t, long j) {
        return UnsafeUtil.getDouble(t, j);
    }

    private boolean equals(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (!arePresentForEquals(t, t2, i) || Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)) != Double.doubleToLongBits(UnsafeUtil.getDouble(t2, jOffset))) {
                }
                break;
            case 1:
                if (!arePresentForEquals(t, t2, i) || Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset)) != Float.floatToIntBits(UnsafeUtil.getFloat(t2, jOffset))) {
                }
                break;
            case 2:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 3:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 4:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 5:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 6:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 7:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getBoolean(t, jOffset) != UnsafeUtil.getBoolean(t2, jOffset)) {
                }
                break;
            case 8:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
            case 9:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
            case 10:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
            case 11:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 12:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 13:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 14:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 15:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 16:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 17:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!isOneofCaseEqual(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
        }
        return true;
    }

    private final <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema);
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.newBuilder();
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i2, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
                    return null;
                }
            }
        }
        return ub;
    }

    private static <T> float floatAt(T t, long j) {
        return UnsafeUtil.getFloat(t, j);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[Fragment$$ExternalSyntheticOutline1.m(i, 3, 2, 1)];
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i2 + 1]);
        this.objects[i2] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getSerializedSizeProto2(T t) {
        int i;
        int i2;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeBytesSize;
        int iComputeSizeMessage;
        boolean z;
        int iComputeSizeFixed32List;
        Unsafe unsafe = UNSAFE;
        int i3 = 1048575;
        int i4 = 1048575;
        int i5 = 0;
        int iM$4 = 0;
        int i6 = 0;
        while (i5 < this.buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i5);
            int iNumberAt = numberAt(i5);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                i = this.buffer[i5 + 2];
                int i7 = i & i3;
                i2 = 1 << (i >>> 20);
                if (i7 != i4) {
                    i6 = unsafe.getInt(t, i7);
                    i4 = i7;
                }
            } else {
                i = (!this.useCachedSizeField || iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i5 + 2] & i3;
                i2 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 8:
                    if ((i6 & i2) != 0) {
                        Object object = unsafe.getObject(t, jOffset);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        iM$4 = iComputeBytesSize + iM$4;
                    }
                    break;
                case 9:
                    if ((i6 & i2) != 0) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                        iM$4 += iComputeSizeMessage;
                    }
                    break;
                case 10:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 11:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 12:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t, jOffset));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 13:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 14:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 15:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 16:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 17:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 19:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeFixed32List;
                    break;
                case 20:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeFixed32List;
                    break;
                case 21:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeFixed32List;
                    break;
                case 22:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeFixed32List;
                    break;
                case 23:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeFixed32List;
                    break;
                case 24:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeFixed32List;
                    break;
                case 25:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeFixed32List;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    iM$4 += iComputeSizeMessage;
                    break;
                case 27:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                    iM$4 += iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    iM$4 += iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 30:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeFixed32List;
                    break;
                case 31:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeFixed32List;
                    break;
                case 32:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeFixed32List;
                    break;
                case 33:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeFixed32List;
                    break;
                case 34:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM$4 += iComputeSizeFixed32List;
                    break;
                case 35:
                    int iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeFixed64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag, iM$4);
                    }
                    break;
                case 36:
                    int iComputeSizeFixed32ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed32ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeFixed32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag, iM$4);
                    }
                    break;
                case 37:
                    int iComputeSizeInt64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeInt64ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt64ListNoTag, iM$4);
                    }
                    break;
                case 38:
                    int iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeUInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeUInt64ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeUInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt64ListNoTag, iM$4);
                    }
                    break;
                case 39:
                    int iComputeSizeInt32ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeInt32ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt32ListNoTag, iM$4);
                    }
                    break;
                case 40:
                    int iComputeSizeFixed64ListNoTag2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag2);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeFixed64ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag2, iM$4);
                    }
                    break;
                case 41:
                    int iComputeSizeFixed32ListNoTag2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed32ListNoTag2);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeFixed32ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag2, iM$4);
                    }
                    break;
                case 42:
                    int iComputeSizeBoolListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeBoolListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeBoolListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeBoolListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeBoolListNoTag, iM$4);
                    }
                    break;
                case 43:
                    int iComputeSizeUInt32ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeUInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeUInt32ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeUInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt32ListNoTag, iM$4);
                    }
                    break;
                case 44:
                    int iComputeSizeEnumListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeEnumListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeEnumListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeEnumListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeEnumListNoTag, iM$4);
                    }
                    break;
                case 45:
                    int iComputeSizeFixed32ListNoTag3 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed32ListNoTag3);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeFixed32ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag3, iM$4);
                    }
                    break;
                case 46:
                    int iComputeSizeFixed64ListNoTag3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag3);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeFixed64ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag3, iM$4);
                    }
                    break;
                case 47:
                    int iComputeSizeSInt32ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeSInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeSInt32ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeSInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt32ListNoTag, iM$4);
                    }
                    break;
                case 48:
                    int iComputeSizeSInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeSInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeSInt64ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeSInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt64ListNoTag, iM$4);
                    }
                    break;
                case 49:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                    iM$4 += iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t, jOffset), getMapFieldDefaultEntry(i5));
                    iM$4 += iComputeSizeMessage;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        Object object2 = unsafe.getObject(t, jOffset);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        iM$4 = iComputeBytesSize + iM$4;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                        iM$4 += iComputeSizeMessage;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                        iM$4 += iComputeBoolSize;
                    }
                    break;
            }
            i5 += 3;
            i3 = 1048575;
        }
        int unknownFieldsSerializedSize = iM$4 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T t) {
        int iComputeDoubleSize;
        int iComputeBytesSize;
        int iComputeSizeMessage;
        Unsafe unsafe = UNSAFE;
        int iM$4 = 0;
        for (int i = 0; i < this.buffer.length; i += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i);
            long jOffset = offset(iTypeAndOffsetAt);
            int i2 = (iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i + 2] & 1048575;
            switch (iType) {
                case 0:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 8:
                    if (isFieldPresent(t, i)) {
                        Object object = UnsafeUtil.getObject(t, jOffset);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        iM$4 = iComputeBytesSize + iM$4;
                    }
                    break;
                case 9:
                    if (isFieldPresent(t, i)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i));
                        iM$4 += iComputeSizeMessage;
                    }
                    break;
                case 10:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 11:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 12:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 13:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 14:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 15:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 16:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 17:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 19:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 20:
                    iComputeSizeMessage = SchemaUtil.computeSizeInt64List(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 21:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt64List(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 22:
                    iComputeSizeMessage = SchemaUtil.computeSizeInt32List(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 23:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 24:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 25:
                    iComputeSizeMessage = SchemaUtil.computeSizeBoolList(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, listAt(t, jOffset));
                    iM$4 += iComputeSizeMessage;
                    break;
                case 27:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, listAt(t, jOffset), getMessageFieldSchema(i));
                    iM$4 += iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, listAt(t, jOffset));
                    iM$4 += iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 30:
                    iComputeSizeMessage = SchemaUtil.computeSizeEnumList(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 31:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 32:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 33:
                    iComputeSizeMessage = SchemaUtil.computeSizeSInt32List(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 34:
                    iComputeSizeMessage = SchemaUtil.computeSizeSInt64List(iNumberAt, listAt(t, jOffset), false);
                    iM$4 += iComputeSizeMessage;
                    break;
                case 35:
                    int iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed64ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeFixed64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag, iM$4);
                    }
                    break;
                case 36:
                    int iComputeSizeFixed32ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed32ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeFixed32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag, iM$4);
                    }
                    break;
                case 37:
                    int iComputeSizeInt64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeInt64ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt64ListNoTag, iM$4);
                    }
                    break;
                case 38:
                    int iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeUInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeUInt64ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeUInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt64ListNoTag, iM$4);
                    }
                    break;
                case 39:
                    int iComputeSizeInt32ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeInt32ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt32ListNoTag, iM$4);
                    }
                    break;
                case 40:
                    int iComputeSizeFixed64ListNoTag2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed64ListNoTag2);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeFixed64ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag2, iM$4);
                    }
                    break;
                case 41:
                    int iComputeSizeFixed32ListNoTag2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed32ListNoTag2);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeFixed32ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag2, iM$4);
                    }
                    break;
                case 42:
                    int iComputeSizeBoolListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeBoolListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeBoolListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeBoolListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeBoolListNoTag, iM$4);
                    }
                    break;
                case 43:
                    int iComputeSizeUInt32ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeUInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeUInt32ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeUInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt32ListNoTag, iM$4);
                    }
                    break;
                case 44:
                    int iComputeSizeEnumListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeEnumListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeEnumListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeEnumListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeEnumListNoTag, iM$4);
                    }
                    break;
                case 45:
                    int iComputeSizeFixed32ListNoTag3 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed32ListNoTag3);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeFixed32ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag3, iM$4);
                    }
                    break;
                case 46:
                    int iComputeSizeFixed64ListNoTag3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed64ListNoTag3);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeFixed64ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag3, iM$4);
                    }
                    break;
                case 47:
                    int iComputeSizeSInt32ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeSInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeSInt32ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeSInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt32ListNoTag, iM$4);
                    }
                    break;
                case 48:
                    int iComputeSizeSInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeSInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeSInt64ListNoTag);
                        }
                        iM$4 = zza$$ExternalSyntheticOutline0.m$4(iComputeSizeSInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt64ListNoTag, iM$4);
                    }
                    break;
                case 49:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, listAt(t, jOffset), getMessageFieldSchema(i));
                    iM$4 += iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = this.mapFieldSchema.getSerializedSize(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMapFieldDefaultEntry(i));
                    iM$4 += iComputeSizeMessage;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        Object object2 = UnsafeUtil.getObject(t, jOffset);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        iM$4 = iComputeBytesSize + iM$4;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i));
                        iM$4 += iComputeSizeMessage;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i));
                        iM$4 += iComputeDoubleSize;
                    }
                    break;
            }
        }
        return iM$4 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t));
    }

    private static <T> int intAt(T t, long j) {
        return UnsafeUtil.getInt(t, j);
    }

    private static boolean isEnforceUtf8(int i) {
        return (i & 536870912) != 0;
    }

    private boolean isFieldPresent(T t, int i) {
        boolean zEquals;
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & iPresenceMaskAndOffsetAt;
        if (j != 1048575) {
            return ((1 << (iPresenceMaskAndOffsetAt >>> 20)) & UnsafeUtil.getInt(t, j)) != 0;
        }
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(t, jOffset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(t, jOffset)) != 0;
            case 2:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 3:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 4:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 5:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 6:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(t, jOffset);
            case 8:
                Object object = UnsafeUtil.getObject(t, jOffset);
                if (object instanceof String) {
                    zEquals = ((String) object).isEmpty();
                } else {
                    if (!(object instanceof ByteString)) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3();
                        return false;
                    }
                    zEquals = ByteString.EMPTY.equals(object);
                }
                break;
            case 9:
                return UnsafeUtil.getObject(t, jOffset) != null;
            case 10:
                zEquals = ByteString.EMPTY.equals(UnsafeUtil.getObject(t, jOffset));
                break;
            case 11:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 12:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 13:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 14:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 15:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 16:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 17:
                return UnsafeUtil.getObject(t, jOffset) != null;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$3();
                return false;
        }
        return !zEquals;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!messageFieldSchema.isInitialized(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.protobuf.Schema] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, offset(i)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            SchemaFor = SchemaFor;
            if (SchemaFor == 0) {
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i) & 1048575;
        return UnsafeUtil.getInt(t, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t2, jPresenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        return UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt(i2) & 1048575)) == i;
    }

    private static boolean isRequired(int i) {
        return (i & ClientDefaults.MAX_MSG_SIZE) != 0;
    }

    private static List<?> listAt(Object obj, long j) {
        return (List) UnsafeUtil.getObject(obj, j);
    }

    private static <T> long longAt(T t, long j) {
        return UnsafeUtil.getLong(t, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:334:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
    
        r0 = r14.checkInitializedCount;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0087, code lost:
    
        if (r0 >= r14.repeatedFieldOffsetStart) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0089, code lost:
    
        r7 = filterMapUnknownEnumValues(r9, r14.intArray[r0], r7, r15);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0094, code lost:
    
        if (r7 == null) goto L334;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0639 A[LOOP:3: B:197:0x0635->B:199:0x0639, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0646  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0610 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05f5 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.google.protobuf.UnknownFieldSchema, com.google.protobuf.UnknownFieldSchema<UT, UB>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        int i;
        ExtensionSchema<ET> extensionSchema2;
        Object objFindExtensionByNumber;
        Object obj;
        T t2 = t;
        ExtensionRegistryLite extensionRegistryLite2 = extensionRegistryLite;
        Object objFilterMapUnknownEnumValues = null;
        FieldSet mutableExtensions = null;
        while (true) {
            try {
                int fieldNumber = reader.getFieldNumber();
                int iPositionForFieldNumber = positionForFieldNumber(fieldNumber);
                if (iPositionForFieldNumber >= 0) {
                    Reader reader2 = reader;
                    obj = objFilterMapUnknownEnumValues;
                    int iTypeAndOffsetAt = typeAndOffsetAt(iPositionForFieldNumber);
                    switch (type(iTypeAndOffsetAt)) {
                        case 0:
                            UnsafeUtil.putDouble(t2, offset(iTypeAndOffsetAt), reader2.readDouble());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 1:
                            UnsafeUtil.putFloat(t2, offset(iTypeAndOffsetAt), reader2.readFloat());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 2:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readInt64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 3:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readUInt64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 4:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readInt32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 5:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readFixed64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 6:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readFixed32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 7:
                            UnsafeUtil.putBoolean(t2, offset(iTypeAndOffsetAt), reader2.readBool());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 8:
                            readString(t2, iTypeAndOffsetAt, reader2);
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 9:
                            if (isFieldPresent(t2, iPositionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(iTypeAndOffsetAt)), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, iPositionForFieldNumber);
                            }
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 10:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readBytes());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 11:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readUInt32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 12:
                            int i2 = reader2.readEnum();
                            Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(iPositionForFieldNumber);
                            if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(i2)) {
                                objFilterMapUnknownEnumValues = SchemaUtil.storeUnknownEnum(fieldNumber, i2, obj, unknownFieldSchema);
                            }
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), i2);
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 13:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readSFixed32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 14:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readSFixed64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 15:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readSInt32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 16:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readSInt64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 17:
                            if (isFieldPresent(t2, iPositionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(iTypeAndOffsetAt)), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, iPositionForFieldNumber);
                            }
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 18:
                            reader2.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 19:
                            reader2.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 20:
                            reader2.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 21:
                            reader2.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 22:
                            reader2.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 23:
                            reader2.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 24:
                            reader2.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 25:
                            reader2.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 26:
                            readStringList(t2, iTypeAndOffsetAt, reader2);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 27:
                            T t3 = t2;
                            try {
                                readMessageList(t3, iTypeAndOffsetAt, reader2, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                t2 = t3;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                t2 = t3;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                    if (objFilterMapUnknownEnumValues == null) {
                                        objFilterMapUnknownEnumValues = unknownFieldSchema.getBuilderFromMessage(t2);
                                    }
                                    if (!unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader2)) {
                                        for (int i3 = this.checkInitializedCount; i3 < this.repeatedFieldOffsetStart; i3++) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i3], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                        }
                                        if (objFilterMapUnknownEnumValues == null) {
                                            return;
                                        }
                                        unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                        return;
                                    }
                                } else if (!reader2.skipField()) {
                                    for (int i4 = this.checkInitializedCount; i4 < this.repeatedFieldOffsetStart; i4++) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i4], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                    }
                                    if (objFilterMapUnknownEnumValues == null) {
                                        return;
                                    }
                                    unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    return;
                                }
                            }
                            break;
                        case 28:
                            reader2.readBytesList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 29:
                            reader2.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 30:
                            List<Integer> listMutableListAt = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                            reader2.readEnumList(listMutableListAt);
                            objFilterMapUnknownEnumValues = SchemaUtil.filterUnknownEnumList(fieldNumber, listMutableListAt, getEnumFieldVerifier(iPositionForFieldNumber), obj, (UnknownFieldSchema<UT, Object>) unknownFieldSchema);
                            extensionRegistryLite2 = extensionRegistryLite;
                            break;
                        case 31:
                            reader2.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 32:
                            reader2.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 33:
                            reader2.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 34:
                            reader2.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 35:
                            reader2.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 36:
                            reader2.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 37:
                            reader2.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 38:
                            reader2.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 39:
                            reader2.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 40:
                            reader2.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 41:
                            reader2.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 42:
                            reader2.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 43:
                            reader2.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 44:
                            List<Integer> listMutableListAt2 = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                            reader2.readEnumList(listMutableListAt2);
                            objFilterMapUnknownEnumValues = SchemaUtil.filterUnknownEnumList(fieldNumber, listMutableListAt2, getEnumFieldVerifier(iPositionForFieldNumber), obj, (UnknownFieldSchema<UT, Object>) unknownFieldSchema);
                            extensionRegistryLite2 = extensionRegistryLite;
                            break;
                        case 45:
                            reader2.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 46:
                            reader2.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 47:
                            reader2.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 48:
                            try {
                                reader2.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            }
                            break;
                        case 49:
                            try {
                                try {
                                    readGroupList(t, offset(iTypeAndOffsetAt), reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                    t2 = t;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    objFilterMapUnknownEnumValues = obj;
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                    t2 = t;
                                    reader2 = reader;
                                    objFilterMapUnknownEnumValues = obj;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                t2 = t;
                                objFilterMapUnknownEnumValues = obj;
                                for (i = this.checkInitializedCount; i < this.repeatedFieldOffsetStart; i++) {
                                    objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                    unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                }
                                throw th;
                            }
                            break;
                        case 50:
                            try {
                                mergeMap(t2, iPositionForFieldNumber, getMapFieldDefaultEntry(iPositionForFieldNumber), extensionRegistryLite2, reader);
                                t2 = t;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused4) {
                                t2 = t;
                                reader2 = reader;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                t2 = t;
                                objFilterMapUnknownEnumValues = obj;
                                while (i < this.repeatedFieldOffsetStart) {
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                }
                                throw th;
                            }
                            break;
                        case 51:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Double.valueOf(reader2.readDouble()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 52:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Float.valueOf(reader2.readFloat()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 53:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readInt64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 54:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readUInt64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 55:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readInt32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 56:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readFixed64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 57:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readFixed32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 58:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Boolean.valueOf(reader2.readBool()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 59:
                            readString(t2, iTypeAndOffsetAt, reader2);
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 60:
                            if (isOneofPresent(t2, fieldNumber, iPositionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(iTypeAndOffsetAt)), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, iPositionForFieldNumber);
                            }
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 61:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readBytes());
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 62:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readUInt32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 63:
                            int i5 = reader2.readEnum();
                            Internal.EnumVerifier enumFieldVerifier2 = getEnumFieldVerifier(iPositionForFieldNumber);
                            if (enumFieldVerifier2 != null && !enumFieldVerifier2.isInRange(i5)) {
                                objFilterMapUnknownEnumValues = SchemaUtil.storeUnknownEnum(fieldNumber, i5, obj, unknownFieldSchema);
                            }
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(i5));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 64:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readSFixed32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 65:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readSFixed64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 66:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readSInt32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 67:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readSInt64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 68:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        default:
                            objFilterMapUnknownEnumValues = obj == null ? unknownFieldSchema.newBuilder() : obj;
                            try {
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused5) {
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            }
                            if (!unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader2)) {
                                for (int i6 = this.checkInitializedCount; i6 < this.repeatedFieldOffsetStart; i6++) {
                                    objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i6], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                }
                                if (objFilterMapUnknownEnumValues == null) {
                                    return;
                                }
                            }
                            break;
                    }
                } else if (fieldNumber == Integer.MAX_VALUE) {
                    for (int i7 = this.checkInitializedCount; i7 < this.repeatedFieldOffsetStart; i7++) {
                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i7], objFilterMapUnknownEnumValues, unknownFieldSchema);
                    }
                    if (objFilterMapUnknownEnumValues == null) {
                        return;
                    }
                } else {
                    if (this.hasExtensions) {
                        extensionSchema2 = extensionSchema;
                        objFindExtensionByNumber = extensionSchema2.findExtensionByNumber(extensionRegistryLite2, this.defaultInstance, fieldNumber);
                    } else {
                        extensionSchema2 = extensionSchema;
                        objFindExtensionByNumber = null;
                    }
                    if (objFindExtensionByNumber != null) {
                        if (mutableExtensions == null) {
                            try {
                                mutableExtensions = extensionSchema.getMutableExtensions(t);
                            } catch (Throwable th3) {
                                th = th3;
                                while (i < this.repeatedFieldOffsetStart) {
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                }
                                throw th;
                            }
                        }
                        FieldSet fieldSet = mutableExtensions;
                        objFilterMapUnknownEnumValues = extensionSchema2.parseExtension(reader, objFindExtensionByNumber, extensionRegistryLite2, fieldSet, objFilterMapUnknownEnumValues, unknownFieldSchema);
                        mutableExtensions = fieldSet;
                    } else {
                        obj = objFilterMapUnknownEnumValues;
                        try {
                            if (unknownFieldSchema.shouldDiscardUnknownFields(reader)) {
                                if (!reader.skipField()) {
                                    objFilterMapUnknownEnumValues = obj;
                                }
                                objFilterMapUnknownEnumValues = obj;
                            } else {
                                objFilterMapUnknownEnumValues = obj == null ? unknownFieldSchema.getBuilderFromMessage(t2) : obj;
                                if (unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader)) {
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            objFilterMapUnknownEnumValues = obj;
                            while (i < this.repeatedFieldOffsetStart) {
                            }
                            if (objFilterMapUnknownEnumValues != null) {
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) {
        long jOffset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, jOffset);
        MapFieldSchema mapFieldSchema = this.mapFieldSchema;
        if (object == null) {
            object = mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, jOffset, object);
        } else if (mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(obj, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private void mergeMessage(T t, T t2, int i) {
        long jOffset = offset(typeAndOffsetAt(i));
        if (isFieldPresent(t2, i)) {
            Object object = UnsafeUtil.getObject(t, jOffset);
            Object object2 = UnsafeUtil.getObject(t2, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, jOffset, Internal.mergeMessage(object, object2));
                setFieldPresent(t, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, jOffset, object2);
                setFieldPresent(t, i);
            }
        }
    }

    private void mergeOneofMessage(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        int iNumberAt = numberAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        if (isOneofPresent(t2, iNumberAt, i)) {
            Object object = isOneofPresent(t, iNumberAt, i) ? UnsafeUtil.getObject(t, jOffset) : null;
            Object object2 = UnsafeUtil.getObject(t2, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, jOffset, Internal.mergeMessage(object, object2));
                setOneofPresent(t, iNumberAt, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, jOffset, object2);
                setOneofPresent(t, iNumberAt, i);
            }
        }
    }

    private void mergeSingleField(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putDouble(t, jOffset, UnsafeUtil.getDouble(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 1:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putFloat(t, jOffset, UnsafeUtil.getFloat(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 2:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 3:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 4:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 5:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 6:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 7:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putBoolean(t, jOffset, UnsafeUtil.getBoolean(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 8:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 9:
                mergeMessage(t, t2, i);
                break;
            case 10:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 11:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 12:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 13:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 14:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 15:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 16:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 17:
                mergeMessage(t, t2, i);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t, t2, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, jOffset);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, i);
                }
                break;
            case 60:
                mergeOneofMessage(t, t2, i);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, i);
                }
                break;
            case 68:
                mergeOneofMessage(t, t2, i);
                break;
        }
    }

    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        if (messageInfo == null) {
            return newSchemaForMessageInfo(null, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        char cCharAt;
        int i6;
        char cCharAt2;
        int i7;
        char cCharAt3;
        int i8;
        char cCharAt4;
        int i9;
        char cCharAt5;
        int i10;
        char cCharAt6;
        int i11;
        char cCharAt7;
        int i12;
        char cCharAt8;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i18;
        int i19;
        int i20;
        int i21;
        java.lang.reflect.Field fieldReflectField;
        char cCharAt9;
        int i22;
        int i23;
        java.lang.reflect.Field fieldReflectField2;
        java.lang.reflect.Field fieldReflectField3;
        int i24;
        char cCharAt10;
        int i25;
        char cCharAt11;
        int i26;
        char cCharAt12;
        int i27;
        char cCharAt13;
        boolean z = rawMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        int i28 = 55296;
        if (stringInfo.charAt(0) >= 55296) {
            int i29 = 1;
            while (true) {
                i = i29 + 1;
                if (stringInfo.charAt(i29) < 55296) {
                    break;
                }
                i29 = i;
            }
        } else {
            i = 1;
        }
        int i30 = i + 1;
        int iCharAt5 = stringInfo.charAt(i);
        if (iCharAt5 >= 55296) {
            int i31 = iCharAt5 & 8191;
            int i32 = 13;
            while (true) {
                i27 = i30 + 1;
                cCharAt13 = stringInfo.charAt(i30);
                if (cCharAt13 < 55296) {
                    break;
                }
                i31 |= (cCharAt13 & 8191) << i32;
                i32 += 13;
                i30 = i27;
            }
            iCharAt5 = i31 | (cCharAt13 << i32);
            i30 = i27;
        }
        if (iCharAt5 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            i3 = 0;
            iCharAt4 = 0;
            i2 = 0;
            iArr = EMPTY_INT_ARRAY;
            i4 = 0;
        } else {
            int i33 = i30 + 1;
            int iCharAt6 = stringInfo.charAt(i30);
            if (iCharAt6 >= 55296) {
                int i34 = iCharAt6 & 8191;
                int i35 = 13;
                while (true) {
                    i12 = i33 + 1;
                    cCharAt8 = stringInfo.charAt(i33);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i34 |= (cCharAt8 & 8191) << i35;
                    i35 += 13;
                    i33 = i12;
                }
                iCharAt6 = i34 | (cCharAt8 << i35);
                i33 = i12;
            }
            int i36 = i33 + 1;
            int iCharAt7 = stringInfo.charAt(i33);
            if (iCharAt7 >= 55296) {
                int i37 = iCharAt7 & 8191;
                int i38 = 13;
                while (true) {
                    i11 = i36 + 1;
                    cCharAt7 = stringInfo.charAt(i36);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt7 & 8191) << i38;
                    i38 += 13;
                    i36 = i11;
                }
                iCharAt7 = i37 | (cCharAt7 << i38);
                i36 = i11;
            }
            int i39 = i36 + 1;
            iCharAt = stringInfo.charAt(i36);
            if (iCharAt >= 55296) {
                int i40 = iCharAt & 8191;
                int i41 = 13;
                while (true) {
                    i10 = i39 + 1;
                    cCharAt6 = stringInfo.charAt(i39);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt6 & 8191) << i41;
                    i41 += 13;
                    i39 = i10;
                }
                iCharAt = i40 | (cCharAt6 << i41);
                i39 = i10;
            }
            int i42 = i39 + 1;
            iCharAt2 = stringInfo.charAt(i39);
            if (iCharAt2 >= 55296) {
                int i43 = iCharAt2 & 8191;
                int i44 = 13;
                while (true) {
                    i9 = i42 + 1;
                    cCharAt5 = stringInfo.charAt(i42);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt5 & 8191) << i44;
                    i44 += 13;
                    i42 = i9;
                }
                iCharAt2 = i43 | (cCharAt5 << i44);
                i42 = i9;
            }
            int i45 = i42 + 1;
            iCharAt3 = stringInfo.charAt(i42);
            if (iCharAt3 >= 55296) {
                int i46 = iCharAt3 & 8191;
                int i47 = 13;
                while (true) {
                    i8 = i45 + 1;
                    cCharAt4 = stringInfo.charAt(i45);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt4 & 8191) << i47;
                    i47 += 13;
                    i45 = i8;
                }
                iCharAt3 = i46 | (cCharAt4 << i47);
                i45 = i8;
            }
            int i48 = i45 + 1;
            int iCharAt8 = stringInfo.charAt(i45);
            if (iCharAt8 >= 55296) {
                int i49 = iCharAt8 & 8191;
                int i50 = 13;
                while (true) {
                    i7 = i48 + 1;
                    cCharAt3 = stringInfo.charAt(i48);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt3 & 8191) << i50;
                    i50 += 13;
                    i48 = i7;
                }
                iCharAt8 = i49 | (cCharAt3 << i50);
                i48 = i7;
            }
            int i51 = i48 + 1;
            int iCharAt9 = stringInfo.charAt(i48);
            if (iCharAt9 >= 55296) {
                int i52 = iCharAt9 & 8191;
                int i53 = 13;
                while (true) {
                    i6 = i51 + 1;
                    cCharAt2 = stringInfo.charAt(i51);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt2 & 8191) << i53;
                    i53 += 13;
                    i51 = i6;
                }
                iCharAt9 = i52 | (cCharAt2 << i53);
                i51 = i6;
            }
            int i54 = i51 + 1;
            iCharAt4 = stringInfo.charAt(i51);
            if (iCharAt4 >= 55296) {
                int i55 = iCharAt4 & 8191;
                int i56 = 13;
                while (true) {
                    i5 = i54 + 1;
                    cCharAt = stringInfo.charAt(i54);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i55 |= (cCharAt & 8191) << i56;
                    i56 += 13;
                    i54 = i5;
                }
                iCharAt4 = i55 | (cCharAt << i56);
                i54 = i5;
            }
            int[] iArr2 = new int[iCharAt4 + iCharAt8 + iCharAt9];
            i2 = (iCharAt6 * 2) + iCharAt7;
            i3 = iCharAt8;
            iArr = iArr2;
            i4 = iCharAt6;
            i30 = i54;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = rawMessageInfo.getObjects();
        Class<?> cls = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr3 = new int[iCharAt3 * 3];
        Object[] objArr = new Object[iCharAt3 * 2];
        int i57 = i3 + iCharAt4;
        int i58 = i57;
        int i59 = iCharAt4;
        int i60 = 0;
        int i61 = 0;
        while (i30 < length) {
            int i62 = i30 + 1;
            int iCharAt10 = stringInfo.charAt(i30);
            if (iCharAt10 >= i28) {
                int i63 = iCharAt10 & 8191;
                int i64 = i62;
                int i65 = 13;
                while (true) {
                    i26 = i64 + 1;
                    cCharAt12 = stringInfo.charAt(i64);
                    i13 = length;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i63 |= (cCharAt12 & 8191) << i65;
                    i65 += 13;
                    i64 = i26;
                    length = i13;
                }
                iCharAt10 = i63 | (cCharAt12 << i65);
                i14 = i26;
            } else {
                i13 = length;
                i14 = i62;
            }
            int i66 = i14 + 1;
            int iCharAt11 = stringInfo.charAt(i14);
            int i67 = iCharAt10;
            char c = 55296;
            if (iCharAt11 >= 55296) {
                int i68 = iCharAt11 & 8191;
                int i69 = 13;
                while (true) {
                    i25 = i66 + 1;
                    cCharAt11 = stringInfo.charAt(i66);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i68 |= (cCharAt11 & 8191) << i69;
                    i69 += 13;
                    i66 = i25;
                    c = 55296;
                }
                iCharAt11 = i68 | (cCharAt11 << i69);
                i66 = i25;
            }
            int i70 = iCharAt11 & PHIpAddressSearchManager.END_IP_SCAN;
            int i71 = i4;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i61] = i60;
                i61++;
            }
            int[] iArr4 = iArr3;
            if (i70 >= 51) {
                int i72 = i66 + 1;
                int iCharAt12 = stringInfo.charAt(i66);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i73 = iCharAt12 & 8191;
                    int i74 = 13;
                    while (true) {
                        i24 = i72 + 1;
                        cCharAt10 = stringInfo.charAt(i72);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i73 |= (cCharAt10 & 8191) << i74;
                        i74 += 13;
                        i72 = i24;
                        c2 = 55296;
                    }
                    iCharAt12 = i73 | (cCharAt10 << i74);
                    i72 = i24;
                }
                int i75 = i70 - 51;
                int i76 = iCharAt12;
                if (i75 == 9 || i75 == 17) {
                    i23 = i72;
                    objArr[Fragment$$ExternalSyntheticOutline1.m(i60, 3, 2, 1)] = objects[i2];
                    i2++;
                } else if (i75 != 12 || z) {
                    i23 = i72;
                } else {
                    i23 = i72;
                    objArr[Fragment$$ExternalSyntheticOutline1.m(i60, 3, 2, 1)] = objects[i2];
                    i2++;
                }
                int i77 = i76 * 2;
                Object obj = objects[i77];
                if (obj instanceof java.lang.reflect.Field) {
                    fieldReflectField2 = (java.lang.reflect.Field) obj;
                } else {
                    fieldReflectField2 = reflectField(cls, (String) obj);
                    objects[i77] = fieldReflectField2;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                int i78 = i77 + 1;
                Object obj2 = objects[i78];
                if (obj2 instanceof java.lang.reflect.Field) {
                    fieldReflectField3 = (java.lang.reflect.Field) obj2;
                } else {
                    fieldReflectField3 = reflectField(cls, (String) obj2);
                    objects[i78] = fieldReflectField3;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                i15 = iCharAt;
                i20 = i2;
                i21 = iObjectFieldOffset3;
                iObjectFieldOffset2 = iObjectFieldOffset4;
                i18 = i23;
                i19 = 0;
                i16 = iCharAt2;
            } else {
                int i79 = i2 + 1;
                java.lang.reflect.Field fieldReflectField4 = reflectField(cls, (String) objects[i2]);
                if (i70 == 9 || i70 == 17) {
                    i15 = iCharAt;
                    i16 = iCharAt2;
                    objArr[Fragment$$ExternalSyntheticOutline1.m(i60, 3, 2, 1)] = fieldReflectField4.getType();
                } else {
                    if (i70 == 27 || i70 == 49) {
                        i15 = iCharAt;
                        i16 = iCharAt2;
                        i22 = i2 + 2;
                        objArr[Fragment$$ExternalSyntheticOutline1.m(i60, 3, 2, 1)] = objects[i79];
                    } else {
                        if (i70 == 12 || i70 == 30 || i70 == 44) {
                            if (!z) {
                                i15 = iCharAt;
                                i16 = iCharAt2;
                                i22 = i2 + 2;
                                objArr[Fragment$$ExternalSyntheticOutline1.m(i60, 3, 2, 1)] = objects[i79];
                            }
                        } else if (i70 == 50) {
                            int i80 = i59 + 1;
                            iArr[i59] = i60;
                            int i81 = (i60 / 3) * 2;
                            int i82 = i2 + 2;
                            objArr[i81] = objects[i79];
                            if ((iCharAt11 & 2048) != 0) {
                                i17 = i2 + 3;
                                objArr[i81 + 1] = objects[i82];
                                i15 = iCharAt;
                                i16 = iCharAt2;
                                i59 = i80;
                            } else {
                                i15 = iCharAt;
                                i17 = i82;
                                i59 = i80;
                                i16 = iCharAt2;
                            }
                            iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                            if ((iCharAt11 & 4096) != 4096 || i70 > 17) {
                                iObjectFieldOffset2 = 1048575;
                                i18 = i66;
                                i19 = 0;
                            } else {
                                int i83 = i66 + 1;
                                int iCharAt13 = stringInfo.charAt(i66);
                                if (iCharAt13 >= 55296) {
                                    int i84 = iCharAt13 & 8191;
                                    int i85 = 13;
                                    while (true) {
                                        i18 = i83 + 1;
                                        cCharAt9 = stringInfo.charAt(i83);
                                        if (cCharAt9 < 55296) {
                                            break;
                                        }
                                        i84 |= (cCharAt9 & 8191) << i85;
                                        i85 += 13;
                                        i83 = i18;
                                    }
                                    iCharAt13 = i84 | (cCharAt9 << i85);
                                } else {
                                    i18 = i83;
                                }
                                int i86 = (iCharAt13 / 32) + (i71 * 2);
                                Object obj3 = objects[i86];
                                if (obj3 instanceof java.lang.reflect.Field) {
                                    fieldReflectField = (java.lang.reflect.Field) obj3;
                                } else {
                                    fieldReflectField = reflectField(cls, (String) obj3);
                                    objects[i86] = fieldReflectField;
                                }
                                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField);
                                i19 = iCharAt13 % 32;
                            }
                            if (i70 >= 18 || i70 > 49) {
                                i20 = i17;
                                i21 = iObjectFieldOffset;
                            } else {
                                iArr[i58] = iObjectFieldOffset;
                                i20 = i17;
                                i21 = iObjectFieldOffset;
                                i58++;
                            }
                        }
                        i15 = iCharAt;
                        i16 = iCharAt2;
                    }
                    i17 = i22;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                    if ((iCharAt11 & 4096) != 4096) {
                        iObjectFieldOffset2 = 1048575;
                        i18 = i66;
                        i19 = 0;
                        if (i70 >= 18) {
                            i20 = i17;
                            i21 = iObjectFieldOffset;
                        }
                    }
                }
                i17 = i79;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                if ((iCharAt11 & 4096) != 4096) {
                }
            }
            int i87 = i60 + 1;
            iArr4[i60] = i67;
            int i88 = i60 + 2;
            String str = stringInfo;
            iArr4[i87] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? ClientDefaults.MAX_MSG_SIZE : 0) | (i70 << 20) | i21;
            i60 += 3;
            iArr4[i88] = (i19 << 20) | iObjectFieldOffset2;
            i2 = i20;
            iCharAt = i15;
            stringInfo = str;
            i4 = i71;
            length = i13;
            iCharAt2 = i16;
            i30 = i18;
            iArr3 = iArr4;
            i28 = 55296;
        }
        return new MessageSchema<>(iArr3, objArr, iCharAt, iCharAt2, rawMessageInfo.getDefaultInstance(), z, false, iArr, iCharAt4, i57, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private static long offset(int i) {
        return i & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T t, long j) {
        return ((Boolean) UnsafeUtil.getObject(t, j)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t, long j) {
        return ((Double) UnsafeUtil.getObject(t, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long j) {
        return ((Float) UnsafeUtil.getObject(t, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long j) {
        return ((Integer) UnsafeUtil.getObject(t, j)).intValue();
    }

    private static <T> long oneofLongAt(T t, long j) {
        return ((Long) UnsafeUtil.getObject(t, j)).longValue();
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int i, int i2, int i3, long j, ArrayDecoders.Registers registers) {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        Object object = unsafe.getObject(t, j);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t, j, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(bArr, i, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        Object object;
        Unsafe unsafe = UNSAFE;
        long j2 = this.buffer[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                int i9 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i9;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                int i10 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i10;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(registers.long1));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint64;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(registers.int1));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint32;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                int i11 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i11;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                int i12 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i12;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint642;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i13 = registers.int1;
                if (i13 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !Utf8.isValidUtf8(bArr, iDecodeVarint322, iDecodeVarint322 + i13)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t, j, new String(bArr, iDecodeVarint322, i13, Internal.UTF_8));
                    iDecodeVarint322 += i13;
                }
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint322;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iDecodeMessageField = ArrayDecoders.decodeMessageField(getMessageFieldSchema(i8), bArr, i, i2, registers);
                object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, registers.object1);
                } else {
                    unsafe.putObject(t, j, Internal.mergeMessage(object, registers.object1));
                }
                unsafe.putInt(t, j2, i4);
                return iDecodeMessageField;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, i, registers);
                unsafe.putObject(t, j, registers.object1);
                unsafe.putInt(t, j2, i4);
                return iDecodeBytes;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i14 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i8);
                if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(i14)) {
                    getMutableUnknownFields(t).storeField(i3, Long.valueOf(i14));
                    return iDecodeVarint323;
                }
                unsafe.putObject(t, j, Integer.valueOf(i14));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint323;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint324;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint643;
            case 68:
                if (i5 == 3) {
                    int iDecodeGroupField = ArrayDecoders.decodeGroupField(getMessageFieldSchema(i8), bArr, i, i2, (i3 & (-8)) | 4, registers);
                    object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, registers.object1);
                    } else {
                        unsafe.putObject(t, j, Internal.mergeMessage(object, registers.object1));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iDecodeGroupField;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x008f. Please report as an issue. */
    private int parseProto3Message(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        T t2;
        Unsafe unsafe;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int iDecodeVarint32;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        MessageSchema<T> messageSchema = this;
        T t3 = t;
        byte[] bArr2 = bArr;
        int i15 = i2;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe2 = UNSAFE;
        int i16 = -1;
        int i17 = i;
        int i18 = -1;
        int i19 = 0;
        int i20 = 0;
        int i21 = 1048575;
        while (i17 < i15) {
            int iDecodeVarint322 = i17 + 1;
            int i22 = bArr2[i17];
            if (i22 < 0) {
                iDecodeVarint322 = ArrayDecoders.decodeVarint32(i22, bArr2, iDecodeVarint322, registers2);
                i22 = registers2.int1;
            }
            int i23 = iDecodeVarint322;
            int i24 = i22 >>> 3;
            int i25 = i22 & 7;
            int iPositionForFieldNumber = i24 > i18 ? messageSchema.positionForFieldNumber(i24, i19 / 3) : messageSchema.positionForFieldNumber(i24);
            if (iPositionForFieldNumber == i16) {
                t2 = t3;
                unsafe = unsafe2;
                i3 = i22;
                i4 = i16;
                i5 = i23;
                i6 = i24;
                i7 = 0;
            } else {
                int i26 = messageSchema.buffer[iPositionForFieldNumber + 1];
                int iType = type(i26);
                i3 = i22;
                int i27 = iPositionForFieldNumber;
                long jOffset = offset(i26);
                if (iType <= 17) {
                    int i28 = messageSchema.buffer[i27 + 2];
                    int i29 = 1 << (i28 >>> 20);
                    int i30 = i28 & 1048575;
                    if (i30 != i21) {
                        if (i21 != 1048575) {
                            unsafe2.putInt(t3, i21, i20);
                            i10 = i30;
                            i9 = 1048575;
                        } else {
                            i9 = 1048575;
                            i10 = i30;
                        }
                        if (i10 != i9) {
                            i20 = unsafe2.getInt(t3, i10);
                        }
                        i21 = i10;
                    }
                    switch (iType) {
                        case 0:
                            i8 = i27;
                            if (i25 != 1) {
                                i27 = i8;
                                int i31 = i27;
                                unsafe = unsafe2;
                                i5 = i23;
                                i7 = i31;
                                t2 = t3;
                                i6 = i24;
                                i4 = -1;
                            } else {
                                UnsafeUtil.putDouble(t3, jOffset, ArrayDecoders.decodeDouble(bArr2, i23));
                                i17 = i23 + 8;
                                i20 |= i29;
                                i15 = i2;
                                i18 = i24;
                                i19 = i8;
                                i16 = -1;
                            }
                            break;
                        case 1:
                            i8 = i27;
                            if (i25 != 5) {
                                i27 = i8;
                                int i312 = i27;
                                unsafe = unsafe2;
                                i5 = i23;
                                i7 = i312;
                                t2 = t3;
                                i6 = i24;
                                i4 = -1;
                            } else {
                                UnsafeUtil.putFloat(t3, jOffset, ArrayDecoders.decodeFloat(bArr2, i23));
                                i17 = i23 + 4;
                                i20 |= i29;
                                i15 = i2;
                                i19 = i8;
                                i18 = i24;
                                i16 = -1;
                            }
                            break;
                        case 2:
                        case 3:
                            i8 = i27;
                            if (i25 != 0) {
                                i27 = i8;
                                int i3122 = i27;
                                unsafe = unsafe2;
                                i5 = i23;
                                i7 = i3122;
                                t2 = t3;
                                i6 = i24;
                                i4 = -1;
                            } else {
                                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i23, registers2);
                                Unsafe unsafe3 = unsafe2;
                                T t4 = t3;
                                unsafe3.putLong(t4, jOffset, registers2.long1);
                                unsafe2 = unsafe3;
                                t3 = t4;
                                i20 |= i29;
                                i17 = iDecodeVarint64;
                                i19 = i8;
                                i18 = i24;
                                i16 = -1;
                                i15 = i2;
                            }
                            break;
                        case 4:
                        case 11:
                            i8 = i27;
                            if (i25 != 0) {
                                i27 = i8;
                                int i31222 = i27;
                                unsafe = unsafe2;
                                i5 = i23;
                                i7 = i31222;
                                t2 = t3;
                                i6 = i24;
                                i4 = -1;
                            } else {
                                iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i23, registers2);
                                unsafe2.putInt(t3, jOffset, registers2.int1);
                                i20 |= i29;
                                i15 = i2;
                                i17 = iDecodeVarint32;
                                i19 = i8;
                                i18 = i24;
                                i16 = -1;
                            }
                            break;
                        case 5:
                        case 14:
                            i8 = i27;
                            if (i25 != 1) {
                                i27 = i8;
                                int i312222 = i27;
                                unsafe = unsafe2;
                                i5 = i23;
                                i7 = i312222;
                                t2 = t3;
                                i6 = i24;
                                i4 = -1;
                            } else {
                                Unsafe unsafe4 = unsafe2;
                                T t5 = t3;
                                unsafe4.putLong(t5, jOffset, ArrayDecoders.decodeFixed64(bArr2, i23));
                                unsafe2 = unsafe4;
                                t3 = t5;
                                i17 = i23 + 8;
                                i20 |= i29;
                                i15 = i2;
                                i19 = i8;
                                i18 = i24;
                                i16 = -1;
                            }
                            break;
                        case 6:
                        case 13:
                            i8 = i27;
                            if (i25 != 5) {
                                i27 = i8;
                                int i3122222 = i27;
                                unsafe = unsafe2;
                                i5 = i23;
                                i7 = i3122222;
                                t2 = t3;
                                i6 = i24;
                                i4 = -1;
                            } else {
                                unsafe2.putInt(t3, jOffset, ArrayDecoders.decodeFixed32(bArr2, i23));
                                i17 = i23 + 4;
                                i20 |= i29;
                                i15 = i2;
                                i19 = i8;
                                i18 = i24;
                                i16 = -1;
                            }
                            break;
                        case 7:
                            i8 = i27;
                            if (i25 != 0) {
                                i27 = i8;
                                int i31222222 = i27;
                                unsafe = unsafe2;
                                i5 = i23;
                                i7 = i31222222;
                                t2 = t3;
                                i6 = i24;
                                i4 = -1;
                            } else {
                                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr2, i23, registers2);
                                UnsafeUtil.putBoolean(t3, jOffset, registers2.long1 != 0);
                                i20 |= i29;
                                i17 = iDecodeVarint642;
                                i15 = i2;
                                i19 = i8;
                                i18 = i24;
                                i16 = -1;
                            }
                            break;
                        case 8:
                            i8 = i27;
                            if (i25 != 2) {
                                i27 = i8;
                                int i312222222 = i27;
                                unsafe = unsafe2;
                                i5 = i23;
                                i7 = i312222222;
                                t2 = t3;
                                i6 = i24;
                                i4 = -1;
                            } else {
                                iDecodeVarint32 = (i26 & 536870912) == 0 ? ArrayDecoders.decodeString(bArr2, i23, registers2) : ArrayDecoders.decodeStringRequireUtf8(bArr2, i23, registers2);
                                unsafe2.putObject(t3, jOffset, registers2.object1);
                                i20 |= i29;
                                i15 = i2;
                                i17 = iDecodeVarint32;
                                i19 = i8;
                                i18 = i24;
                                i16 = -1;
                            }
                            break;
                        case 9:
                            i8 = i27;
                            if (i25 != 2) {
                                i27 = i8;
                                int i3122222222 = i27;
                                unsafe = unsafe2;
                                i5 = i23;
                                i7 = i3122222222;
                                t2 = t3;
                                i6 = i24;
                                i4 = -1;
                            } else {
                                iDecodeVarint32 = ArrayDecoders.decodeMessageField(messageSchema.getMessageFieldSchema(i8), bArr2, i23, i15, registers2);
                                Object object = unsafe2.getObject(t3, jOffset);
                                if (object == null) {
                                    unsafe2.putObject(t3, jOffset, registers2.object1);
                                } else {
                                    unsafe2.putObject(t3, jOffset, Internal.mergeMessage(object, registers2.object1));
                                }
                                i20 |= i29;
                                i17 = iDecodeVarint32;
                                i19 = i8;
                                i18 = i24;
                                i16 = -1;
                            }
                            break;
                        case 10:
                            i8 = i27;
                            if (i25 != 2) {
                                i27 = i8;
                                int i31222222222 = i27;
                                unsafe = unsafe2;
                                i5 = i23;
                                i7 = i31222222222;
                                t2 = t3;
                                i6 = i24;
                                i4 = -1;
                            } else {
                                iDecodeVarint32 = ArrayDecoders.decodeBytes(bArr2, i23, registers2);
                                unsafe2.putObject(t3, jOffset, registers2.object1);
                                i20 |= i29;
                                i17 = iDecodeVarint32;
                                i19 = i8;
                                i18 = i24;
                                i16 = -1;
                            }
                            break;
                        case 12:
                            i8 = i27;
                            if (i25 != 0) {
                                i27 = i8;
                                int i312222222222 = i27;
                                unsafe = unsafe2;
                                i5 = i23;
                                i7 = i312222222222;
                                t2 = t3;
                                i6 = i24;
                                i4 = -1;
                            } else {
                                iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i23, registers2);
                                unsafe2.putInt(t3, jOffset, registers2.int1);
                                i20 |= i29;
                                i17 = iDecodeVarint32;
                                i19 = i8;
                                i18 = i24;
                                i16 = -1;
                            }
                            break;
                        case 15:
                            i8 = i27;
                            if (i25 != 0) {
                                i27 = i8;
                                int i3122222222222 = i27;
                                unsafe = unsafe2;
                                i5 = i23;
                                i7 = i3122222222222;
                                t2 = t3;
                                i6 = i24;
                                i4 = -1;
                            } else {
                                iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i23, registers2);
                                unsafe2.putInt(t3, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                i20 |= i29;
                                i17 = iDecodeVarint32;
                                i19 = i8;
                                i18 = i24;
                                i16 = -1;
                            }
                            break;
                        case 16:
                            if (i25 != 0) {
                                int i31222222222222 = i27;
                                unsafe = unsafe2;
                                i5 = i23;
                                i7 = i31222222222222;
                                t2 = t3;
                                i6 = i24;
                                i4 = -1;
                            } else {
                                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr2, i23, registers2);
                                Unsafe unsafe5 = unsafe2;
                                T t6 = t3;
                                unsafe5.putLong(t6, jOffset, CodedInputStream.decodeZigZag64(registers2.long1));
                                unsafe2 = unsafe5;
                                t3 = t6;
                                i20 |= i29;
                                i17 = iDecodeVarint643;
                                i19 = i27;
                                i18 = i24;
                                i16 = -1;
                            }
                            break;
                        default:
                            int i312222222222222 = i27;
                            unsafe = unsafe2;
                            i5 = i23;
                            i7 = i312222222222222;
                            t2 = t3;
                            i6 = i24;
                            i4 = -1;
                            break;
                    }
                } else {
                    if (iType != 27) {
                        Unsafe unsafe6 = unsafe2;
                        if (iType <= 49) {
                            i12 = i20;
                            unsafe = unsafe6;
                            i4 = -1;
                            i11 = i21;
                            int repeatedField = messageSchema.parseRepeatedField(t, bArr, i23, i2, i3 == true ? 1 : 0, i24, i25, i27, i26, iType, jOffset, registers);
                            i14 = i24;
                            i7 = i27;
                            if (repeatedField != i23) {
                                messageSchema = this;
                                t3 = t;
                                i15 = i2;
                                registers2 = registers;
                                i17 = repeatedField;
                                i18 = i14;
                                i19 = i7;
                                i21 = i11;
                                i16 = -1;
                                unsafe2 = unsafe;
                                i20 = i12;
                                bArr2 = bArr;
                            } else {
                                t2 = t;
                                i5 = repeatedField;
                                i6 = i14;
                            }
                        } else {
                            i7 = i27;
                            i12 = i20;
                            unsafe = unsafe6;
                            i4 = -1;
                            i13 = i23;
                            i11 = i21;
                            i14 = i24;
                            if (iType != 50) {
                                i6 = i14;
                                int oneofField = parseOneofField(t, bArr, i13, i2, i3 == true ? 1 : 0, i6, i25, i26, iType, jOffset, i7, registers);
                                t2 = t;
                                if (oneofField != i13) {
                                    messageSchema = this;
                                    registers2 = registers;
                                    i18 = i6;
                                    i17 = oneofField;
                                    t3 = t2;
                                    i19 = i7;
                                    i21 = i11;
                                    i16 = -1;
                                    unsafe2 = unsafe;
                                    i20 = i12;
                                    bArr2 = bArr;
                                    i15 = i2;
                                } else {
                                    i5 = oneofField;
                                }
                            } else if (i25 == 2) {
                                int mapField = parseMapField(t, bArr, i13, i2, i7, jOffset, registers);
                                if (mapField != i13) {
                                    messageSchema = this;
                                    t3 = t;
                                    bArr2 = bArr;
                                    i15 = i2;
                                    registers2 = registers;
                                    i17 = mapField;
                                    i18 = i14;
                                    i19 = i7;
                                    i21 = i11;
                                    i16 = -1;
                                    unsafe2 = unsafe;
                                    i20 = i12;
                                } else {
                                    t2 = t;
                                    i5 = mapField;
                                    i6 = i14;
                                }
                            } else {
                                t2 = t;
                                i5 = i13;
                                i6 = i14;
                            }
                        }
                    } else if (i25 == 2) {
                        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe2.getObject(t3, jOffset);
                        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                            int size = protobufListMutableCopyWithCapacity2.size();
                            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                            unsafe2.putObject(t3, jOffset, protobufListMutableCopyWithCapacity2);
                        }
                        int iDecodeMessageList = ArrayDecoders.decodeMessageList(messageSchema.getMessageFieldSchema(i27), i3 == true ? 1 : 0, bArr2, i23, i2, protobufListMutableCopyWithCapacity2, registers2);
                        bArr2 = bArr;
                        registers2 = registers;
                        i17 = iDecodeMessageList;
                        i19 = i27;
                        i18 = i24;
                        unsafe2 = unsafe2;
                        i16 = -1;
                        t3 = t;
                        i15 = i2;
                    } else {
                        unsafe = unsafe2;
                        i11 = i21;
                        i12 = i20;
                        i13 = i23;
                        i14 = i24;
                        i4 = -1;
                        i7 = i27;
                        t2 = t;
                        i5 = i13;
                        i6 = i14;
                    }
                    i21 = i11;
                    i20 = i12;
                }
            }
            int iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i3 == true ? 1 : 0, bArr, i5, i2, getMutableUnknownFields(t2), registers);
            bArr2 = bArr;
            registers2 = registers;
            i18 = i6;
            t3 = t2;
            i19 = i7;
            i16 = i4;
            unsafe2 = unsafe;
            i15 = i2;
            i17 = iDecodeUnknownField;
            messageSchema = this;
        }
        Unsafe unsafe7 = unsafe2;
        int i32 = i15;
        int i33 = i21;
        int i34 = i20;
        T t7 = t3;
        if (i33 != 1048575) {
            unsafe7.putInt(t7, i33, i34);
        }
        if (i17 == i32) {
            return i17;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private int parseRepeatedField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(t, j2);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t, j2, protobufListMutableCopyWithCapacity2);
        }
        Internal.ProtobufList protobufList = protobufListMutableCopyWithCapacity2;
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufList, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeDoubleList(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 19:
            case 36:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufList, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFloatList(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint64List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufList, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeFixed64List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufList, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFixed32List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 25:
            case 42:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeBoolList(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 26:
                if (i5 == 2) {
                    return (j & 536870912) == 0 ? ArrayDecoders.decodeStringList(i3, bArr, i, i2, protobufList, registers) : ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 27:
                if (i5 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 28:
                if (i5 == 2) {
                    return ArrayDecoders.decodeBytesList(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList, registers);
                    }
                    return i;
                }
                iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(i4, (List<Integer>) protobufList, getEnumFieldVerifier(i6), unknownFieldSetLite, (UnknownFieldSchema<UT, UnknownFieldSetLite>) this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt32List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 34:
            case 48:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufList, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt64List(i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 49:
                if (i5 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufList, registers);
                }
                return i;
            default:
                return i;
        }
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i, Reader reader) {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) {
        boolean zIsEnforceUtf8 = isEnforceUtf8(i);
        ListFieldSchema listFieldSchema = this.listFieldSchema;
        if (zIsEnforceUtf8) {
            reader.readStringListRequireUtf8(listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Field ", str, " for ");
            Fragment$$ExternalSyntheticOutline1.m(cls, sbM5m, " not found. Known fields are ");
            sbM5m.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbM5m.toString());
        }
    }

    private void setFieldPresent(T t, int i) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & iPresenceMaskAndOffsetAt;
        if (j == 1048575) {
            return;
        }
        UnsafeUtil.putInt(t, j, (1 << (iPresenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(t, j));
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.putInt(t, presenceMaskAndOffsetAt(i2) & 1048575, i);
    }

    private int slowPositionForFieldNumber(int i, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int iNumberAt = numberAt(i4);
            if (i == iNumberAt) {
                return i4;
            }
            if (i < iNumberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int type(int i) {
        return (i & 267386880) >>> 20;
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInAscendingOrderProto2(T t, Writer writer) {
        Iterator it;
        Map.Entry<?, ?> entry;
        int i;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length = this.buffer.length;
        Unsafe unsafe = UNSAFE;
        int i2 = 1048575;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i4);
            int iNumberAt = numberAt(i4);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                int i5 = this.buffer[i4 + 2];
                int i6 = i5 & 1048575;
                if (i6 != i2) {
                    i3 = unsafe.getInt(t, i6);
                    i2 = i6;
                }
                i = 1 << (i5 >>> 20);
            } else {
                i = 0;
            }
            while (entry != null && this.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    if ((i & i3) != 0) {
                        writer.writeDouble(iNumberAt, doubleAt(t, jOffset));
                        continue;
                    }
                    break;
                case 1:
                    if ((i & i3) != 0) {
                        writer.writeFloat(iNumberAt, floatAt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 2:
                    if ((i & i3) != 0) {
                        writer.writeInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 3:
                    if ((i & i3) != 0) {
                        writer.writeUInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 4:
                    if ((i & i3) != 0) {
                        writer.writeInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 5:
                    if ((i & i3) != 0) {
                        writer.writeFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 6:
                    if ((i & i3) != 0) {
                        writer.writeFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 7:
                    if ((i & i3) != 0) {
                        writer.writeBool(iNumberAt, booleanAt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 8:
                    if ((i & i3) != 0) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                    } else {
                        continue;
                    }
                    break;
                case 9:
                    if ((i & i3) != 0) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                    } else {
                        continue;
                    }
                    break;
                case 10:
                    if ((i & i3) != 0) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 11:
                    if ((i & i3) != 0) {
                        writer.writeUInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 12:
                    if ((i & i3) != 0) {
                        writer.writeEnum(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 13:
                    if ((i & i3) != 0) {
                        writer.writeSFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 14:
                    if ((i & i3) != 0) {
                        writer.writeSFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 15:
                    if ((i & i3) != 0) {
                        writer.writeSInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 16:
                    if ((i & i3) != 0) {
                        writer.writeSInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 17:
                    if ((i & i3) != 0) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                    } else {
                        continue;
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i4));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i4));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, unsafe.getObject(t, jOffset), i4);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, jOffset));
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, jOffset));
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, jOffset));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInAscendingOrderProto3(T t, Writer writer) {
        Iterator it;
        Map.Entry<?, ?> entry;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            int iNumberAt = numberAt(i);
            while (entry != null && this.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(t, i)) {
                        writer.writeDouble(iNumberAt, doubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 1:
                    if (isFieldPresent(t, i)) {
                        writer.writeFloat(iNumberAt, floatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 2:
                    if (isFieldPresent(t, i)) {
                        writer.writeInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 3:
                    if (isFieldPresent(t, i)) {
                        writer.writeUInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 4:
                    if (isFieldPresent(t, i)) {
                        writer.writeInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 5:
                    if (isFieldPresent(t, i)) {
                        writer.writeFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 6:
                    if (isFieldPresent(t, i)) {
                        writer.writeFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, i)) {
                        writer.writeBool(iNumberAt, booleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 8:
                    if (isFieldPresent(t, i)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 9:
                    if (isFieldPresent(t, i)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
                case 10:
                    if (isFieldPresent(t, i)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 11:
                    if (isFieldPresent(t, i)) {
                        writer.writeUInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 12:
                    if (isFieldPresent(t, i)) {
                        writer.writeEnum(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 13:
                    if (isFieldPresent(t, i)) {
                        writer.writeSFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 14:
                    if (isFieldPresent(t, i)) {
                        writer.writeSFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 15:
                    if (isFieldPresent(t, i)) {
                        writer.writeSInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 16:
                    if (isFieldPresent(t, i)) {
                        writer.writeSInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 17:
                    if (isFieldPresent(t, i)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(i));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(i));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), i);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInDescendingOrder(T t, Writer writer) {
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry;
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                itDescendingIterator = null;
                entry = null;
            } else {
                itDescendingIterator = extensions.descendingIterator();
                entry = (Map.Entry) itDescendingIterator.next();
            }
        }
        for (int length = this.buffer.length - 3; length >= 0; length -= 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(length);
            int iNumberAt = numberAt(length);
            while (entry != null && this.extensionSchema.extensionNumber(entry) > iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(t, length)) {
                        writer.writeDouble(iNumberAt, doubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 1:
                    if (isFieldPresent(t, length)) {
                        writer.writeFloat(iNumberAt, floatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 2:
                    if (isFieldPresent(t, length)) {
                        writer.writeInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 3:
                    if (isFieldPresent(t, length)) {
                        writer.writeUInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 4:
                    if (isFieldPresent(t, length)) {
                        writer.writeInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 5:
                    if (isFieldPresent(t, length)) {
                        writer.writeFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 6:
                    if (isFieldPresent(t, length)) {
                        writer.writeFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, length)) {
                        writer.writeBool(iNumberAt, booleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 8:
                    if (isFieldPresent(t, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 9:
                    if (isFieldPresent(t, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 10:
                    if (isFieldPresent(t, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 11:
                    if (isFieldPresent(t, length)) {
                        writer.writeUInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 12:
                    if (isFieldPresent(t, length)) {
                        writer.writeEnum(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 13:
                    if (isFieldPresent(t, length)) {
                        writer.writeSFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 14:
                    if (isFieldPresent(t, length)) {
                        writer.writeSFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 15:
                    if (isFieldPresent(t, length)) {
                        writer.writeSInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 16:
                    if (isFieldPresent(t, length)) {
                        writer.writeSInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 17:
                    if (isFieldPresent(t, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), length);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i2) {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i, Object obj, Writer writer) {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, Writer writer) {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t), writer);
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T t) {
        return this.proto3 ? getSerializedSizeProto3(t) : getSerializedSizeProto2(t);
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t) {
        int i;
        int iHashLong;
        int i2;
        int iOneofIntAt;
        int length = this.buffer.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i4);
            int iNumberAt = numberAt(i4);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)));
                    i3 = iHashLong + i;
                    break;
                case 1:
                    i = i3 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 2:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 3:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i3 = i2 + iOneofIntAt;
                    break;
                case 5:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i3 = i2 + iOneofIntAt;
                    break;
                case 7:
                    i = i3 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 8:
                    i = i3 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                    i3 = iHashLong + i;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i3 = iHashLong + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i3 = i2 + iOneofIntAt;
                    break;
                case 12:
                    i2 = i3 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i3 = i2 + iOneofIntAt;
                    break;
                case 13:
                    i2 = i3 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i3 = i2 + iOneofIntAt;
                    break;
                case 14:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i3 = i2 + iOneofIntAt;
                    break;
                case 16:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i3 = iHashLong + i;
                    break;
                case 50:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i3 = iHashLong + i;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t, jOffset)));
                        i3 = iHashLong + i;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i2 = i3 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i3 = i2 + iOneofIntAt;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i2 = i3 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i3 = i2 + iOneofIntAt;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                        i3 = iHashLong + i;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i3 = iHashLong + i;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i3 = iHashLong + i;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i2 = i3 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i3 = i2 + iOneofIntAt;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i2 = i3 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i3 = i2 + iOneofIntAt;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i2 = i3 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i3 = i2 + iOneofIntAt;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i2 = i3 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i3 = i2 + iOneofIntAt;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i3 = iHashLong + i;
                    }
                    break;
            }
        }
        int iHashCode2 = this.unknownFieldSchema.getFromMessage(t).hashCode() + (i3 * 53);
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t).hashCode() : iHashCode2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007c  */
    @Override // com.google.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isInitialized(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.checkInitializedCount) {
            int i6 = this.intArray[i4];
            int iNumberAt = this.numberAt(i6);
            int iTypeAndOffsetAt = this.typeAndOffsetAt(i6);
            int i7 = this.buffer[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i3) {
                if (i8 != 1048575) {
                    i5 = UNSAFE.getInt(t, i8);
                }
                i2 = i5;
                i = i8;
            } else {
                i = i3;
                i2 = i5;
            }
            MessageSchema<T> messageSchema = this;
            T t2 = t;
            if (isRequired(iTypeAndOffsetAt) && !messageSchema.isFieldPresent(t2, i6, i, i2, i9)) {
                return false;
            }
            int iType = type(iTypeAndOffsetAt);
            if (iType == 9 || iType == 17) {
                if (messageSchema.isFieldPresent(t2, i6, i, i2, i9) && !isInitialized(t2, iTypeAndOffsetAt, messageSchema.getMessageFieldSchema(i6))) {
                    return false;
                }
            } else if (iType == 27) {
                if (!messageSchema.isListInitialized(t2, iTypeAndOffsetAt, i6)) {
                    return false;
                }
            } else if (iType == 60 || iType == 68) {
                if (messageSchema.isOneofPresent(t2, iNumberAt, i6) && !isInitialized(t2, iTypeAndOffsetAt, messageSchema.getMessageFieldSchema(i6))) {
                    return false;
                }
            } else if (iType != 49) {
                if (iType == 50 && !messageSchema.isMapInitialized(t2, iTypeAndOffsetAt, i6)) {
                    return false;
                }
            }
            i4++;
            this = messageSchema;
            t = t2;
            i3 = i;
            i5 = i2;
        }
        MessageSchema<T> messageSchema2 = this;
        return !messageSchema2.hasExtensions || messageSchema2.extensionSchema.getExtensions(t).isInitialized();
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T t) {
        int i;
        int[] iArr;
        int i2 = this.checkInitializedCount;
        while (true) {
            i = this.repeatedFieldOffsetStart;
            iArr = this.intArray;
            if (i2 >= i) {
                break;
            }
            long jOffset = offset(typeAndOffsetAt(iArr[i2]));
            Object object = UnsafeUtil.getObject(t, jOffset);
            if (object != null) {
                UnsafeUtil.putObject(t, jOffset, this.mapFieldSchema.toImmutable(object));
            }
            i2++;
        }
        int length = iArr.length;
        while (i < length) {
            this.listFieldSchema.makeImmutableListAt(t, this.intArray[i]);
            i++;
        }
        this.unknownFieldSchema.makeImmutable(t);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t);
        }
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t, t2, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0092. Please report as an issue. */
    public int parseProto2Message(T t, byte[] bArr, int i, int i2, int i3, ArrayDecoders.Registers registers) {
        int i4;
        T t2;
        Unsafe unsafe;
        int i5;
        MessageSchema<T> messageSchema;
        ArrayDecoders.Registers registers2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        T t3;
        int i12;
        int iDecodeUnknownField;
        byte[] bArr2;
        int i13;
        Unsafe unsafe2;
        int i14;
        int i15;
        int i16;
        int iDecodeVarint32;
        int i17;
        int i18;
        Unsafe unsafe3;
        int i19;
        byte[] bArr3;
        int i20;
        int i21;
        MessageSchema<T> messageSchema2 = this;
        T t4 = t;
        byte[] bArr4 = bArr;
        int i22 = i2;
        ArrayDecoders.Registers registers3 = registers;
        Unsafe unsafe4 = UNSAFE;
        int i23 = -1;
        int i24 = i;
        int i25 = -1;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 1048575;
        while (true) {
            if (i24 < i22) {
                int iDecodeVarint322 = i24 + 1;
                int i30 = bArr4[i24];
                if (i30 < 0) {
                    iDecodeVarint322 = ArrayDecoders.decodeVarint32(i30, bArr4, iDecodeVarint322, registers3);
                    i30 = registers3.int1;
                }
                int i31 = iDecodeVarint322;
                i28 = i30;
                int i32 = (i28 == true ? 1 : 0) >>> 3;
                int i33 = (i28 == true ? 1 : 0) & 7;
                int iPositionForFieldNumber = i32 > i25 ? messageSchema2.positionForFieldNumber(i32, i26 / 3) : messageSchema2.positionForFieldNumber(i32);
                if (iPositionForFieldNumber == i23) {
                    registers2 = registers;
                    i6 = i31;
                    unsafe = unsafe4;
                    i7 = i23;
                    i8 = i27;
                    i9 = i28 == true ? 1 : 0;
                    i10 = i32;
                    i11 = 0;
                    i5 = 1048575;
                    i4 = i3;
                    messageSchema = messageSchema2;
                } else {
                    int i34 = messageSchema2.buffer[iPositionForFieldNumber + 1];
                    int iType = type(i34);
                    long jOffset = offset(i34);
                    if (iType <= 17) {
                        int i35 = messageSchema2.buffer[iPositionForFieldNumber + 2];
                        int i36 = 1 << (i35 >>> 20);
                        int i37 = i35 & 1048575;
                        i10 = i32;
                        if (i37 != i29) {
                            if (i29 != 1048575) {
                                unsafe4.putInt(t4, i29, i27);
                            }
                            i27 = unsafe4.getInt(t4, i37);
                            i29 = i37;
                        }
                        switch (iType) {
                            case 0:
                                Unsafe unsafe5 = unsafe4;
                                i19 = i22;
                                unsafe3 = unsafe5;
                                bArr3 = bArr;
                                i13 = iPositionForFieldNumber;
                                i14 = i29;
                                i15 = i31;
                                registers2 = registers;
                                if (i33 == 1) {
                                    UnsafeUtil.putDouble(t4, jOffset, ArrayDecoders.decodeDouble(bArr3, i15));
                                    i24 = i15 + 8;
                                    i27 |= i36;
                                    int i38 = i19;
                                    unsafe4 = unsafe3;
                                    i22 = i38;
                                    i29 = i14;
                                    registers3 = registers2;
                                    i26 = i13;
                                    bArr4 = bArr3;
                                    i25 = i10;
                                    i23 = -1;
                                } else {
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            case 1:
                                Unsafe unsafe6 = unsafe4;
                                i19 = i22;
                                unsafe3 = unsafe6;
                                bArr3 = bArr;
                                i13 = iPositionForFieldNumber;
                                i14 = i29;
                                i15 = i31;
                                registers2 = registers;
                                if (i33 == 5) {
                                    UnsafeUtil.putFloat(t4, jOffset, ArrayDecoders.decodeFloat(bArr3, i15));
                                    i24 = i15 + 4;
                                    i27 |= i36;
                                    int i382 = i19;
                                    unsafe4 = unsafe3;
                                    i22 = i382;
                                    i29 = i14;
                                    registers3 = registers2;
                                    i26 = i13;
                                    bArr4 = bArr3;
                                    i25 = i10;
                                    i23 = -1;
                                } else {
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            case 2:
                            case 3:
                                bArr3 = bArr;
                                i13 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                i14 = i29;
                                i15 = i31;
                                registers2 = registers;
                                int i39 = i22;
                                if (i33 == 0) {
                                    int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr3, i15, registers2);
                                    T t5 = t4;
                                    unsafe2.putLong(t5, jOffset, registers2.long1);
                                    t4 = t5;
                                    i27 |= i36;
                                    unsafe4 = unsafe2;
                                    i22 = i39;
                                    i29 = i14;
                                    i24 = iDecodeVarint64;
                                    registers3 = registers2;
                                    i26 = i13;
                                    bArr4 = bArr3;
                                    i25 = i10;
                                    i23 = -1;
                                } else {
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i13 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                i14 = i29;
                                i15 = i31;
                                registers2 = registers;
                                i16 = i22;
                                if (i33 == 0) {
                                    iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i15, registers2);
                                    unsafe2.putInt(t4, jOffset, registers2.int1);
                                    i27 |= i36;
                                    i29 = i14;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = iDecodeVarint32;
                                    bArr4 = bArr2;
                                } else {
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i13 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                i14 = i29;
                                i16 = i22;
                                i17 = i31;
                                registers2 = registers;
                                if (i33 == 1) {
                                    T t6 = t4;
                                    unsafe2.putLong(t6, jOffset, ArrayDecoders.decodeFixed64(bArr2, i17));
                                    unsafe2 = unsafe2;
                                    t4 = t6;
                                    iDecodeVarint32 = i17 + 8;
                                    i27 |= i36;
                                    i29 = i14;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = iDecodeVarint32;
                                    bArr4 = bArr2;
                                } else {
                                    i15 = i17;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i13 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                i14 = i29;
                                i16 = i22;
                                i17 = i31;
                                registers2 = registers;
                                if (i33 == 5) {
                                    unsafe2.putInt(t4, jOffset, ArrayDecoders.decodeFixed32(bArr2, i17));
                                    iDecodeVarint32 = i17 + 4;
                                    i27 |= i36;
                                    i29 = i14;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = iDecodeVarint32;
                                    bArr4 = bArr2;
                                } else {
                                    i15 = i17;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            case 7:
                                bArr2 = bArr;
                                i13 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                i14 = i29;
                                i16 = i22;
                                i17 = i31;
                                registers2 = registers;
                                if (i33 == 0) {
                                    iDecodeVarint32 = ArrayDecoders.decodeVarint64(bArr2, i17, registers2);
                                    UnsafeUtil.putBoolean(t4, jOffset, registers2.long1 != 0);
                                    i27 |= i36;
                                    i29 = i14;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = iDecodeVarint32;
                                    bArr4 = bArr2;
                                } else {
                                    i15 = i17;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            case 8:
                                bArr2 = bArr;
                                i13 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                i14 = i29;
                                i16 = i22;
                                i17 = i31;
                                registers2 = registers;
                                if (i33 == 2) {
                                    iDecodeVarint32 = (536870912 & i34) == 0 ? ArrayDecoders.decodeString(bArr2, i17, registers2) : ArrayDecoders.decodeStringRequireUtf8(bArr2, i17, registers2);
                                    unsafe2.putObject(t4, jOffset, registers2.object1);
                                    i27 |= i36;
                                    i29 = i14;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = iDecodeVarint32;
                                    bArr4 = bArr2;
                                } else {
                                    i15 = i17;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            case 9:
                                bArr2 = bArr;
                                i13 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                registers2 = registers;
                                i16 = i22;
                                i18 = i31;
                                if (i33 == 2) {
                                    iDecodeVarint32 = ArrayDecoders.decodeMessageField(messageSchema2.getMessageFieldSchema(i13), bArr2, i18, i16, registers2);
                                    if ((i27 & i36) == 0) {
                                        unsafe2.putObject(t4, jOffset, registers2.object1);
                                    } else {
                                        unsafe2.putObject(t4, jOffset, Internal.mergeMessage(unsafe2.getObject(t4, jOffset), registers2.object1));
                                    }
                                    i27 |= i36;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = iDecodeVarint32;
                                    bArr4 = bArr2;
                                } else {
                                    i15 = i18;
                                    i14 = i29;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            case 10:
                                bArr2 = bArr;
                                i13 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                registers2 = registers;
                                i16 = i22;
                                i18 = i31;
                                if (i33 == 2) {
                                    iDecodeVarint32 = ArrayDecoders.decodeBytes(bArr2, i18, registers2);
                                    unsafe2.putObject(t4, jOffset, registers2.object1);
                                    i27 |= i36;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = iDecodeVarint32;
                                    bArr4 = bArr2;
                                } else {
                                    i15 = i18;
                                    i14 = i29;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            case 12:
                                bArr2 = bArr;
                                i13 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                registers2 = registers;
                                i16 = i22;
                                i18 = i31;
                                if (i33 == 0) {
                                    iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i18, registers2);
                                    int i40 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i13);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i40)) {
                                        unsafe2.putInt(t4, jOffset, i40);
                                        i27 |= i36;
                                        i22 = i16;
                                        registers3 = registers2;
                                        i26 = i13;
                                        i25 = i10;
                                        i23 = -1;
                                        unsafe4 = unsafe2;
                                        i24 = iDecodeVarint32;
                                        bArr4 = bArr2;
                                    } else {
                                        getMutableUnknownFields(t4).storeField(i28 == true ? 1 : 0, Long.valueOf(i40));
                                        i22 = i16;
                                        registers3 = registers2;
                                        i26 = i13;
                                        i25 = i10;
                                        i23 = -1;
                                        unsafe4 = unsafe2;
                                        i24 = iDecodeVarint32;
                                        bArr4 = bArr2;
                                    }
                                } else {
                                    i15 = i18;
                                    i14 = i29;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i13 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                registers2 = registers;
                                i16 = i22;
                                i18 = i31;
                                if (i33 == 0) {
                                    iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i18, registers2);
                                    unsafe2.putInt(t4, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                    i27 |= i36;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = iDecodeVarint32;
                                    bArr4 = bArr2;
                                } else {
                                    i15 = i18;
                                    i14 = i29;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            case 16:
                                i13 = iPositionForFieldNumber;
                                i18 = i31;
                                if (i33 == 0) {
                                    int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i18, registers);
                                    T t7 = t4;
                                    Unsafe unsafe7 = unsafe4;
                                    unsafe7.putLong(t7, jOffset, CodedInputStream.decodeZigZag64(registers.long1));
                                    t4 = t7;
                                    i27 |= i36;
                                    i22 = i2;
                                    i26 = i13;
                                    bArr4 = bArr;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe7;
                                    i24 = iDecodeVarint642;
                                    registers3 = registers;
                                } else {
                                    registers2 = registers;
                                    unsafe2 = unsafe4;
                                    i15 = i18;
                                    i14 = i29;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            case 17:
                                if (i33 == 3) {
                                    int i41 = iPositionForFieldNumber;
                                    iDecodeVarint32 = ArrayDecoders.decodeGroupField(messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), bArr, i31, i22, (i10 << 3) | 4, registers);
                                    bArr2 = bArr;
                                    if ((i27 & i36) == 0) {
                                        unsafe4.putObject(t4, jOffset, registers.object1);
                                    } else {
                                        unsafe4.putObject(t4, jOffset, Internal.mergeMessage(unsafe4.getObject(t4, jOffset), registers.object1));
                                    }
                                    i27 |= i36;
                                    i22 = i2;
                                    registers3 = registers;
                                    i26 = i41;
                                    i25 = i10;
                                    i23 = -1;
                                    i24 = iDecodeVarint32;
                                    bArr4 = bArr2;
                                } else {
                                    i13 = iPositionForFieldNumber;
                                    registers2 = registers;
                                    unsafe3 = unsafe4;
                                    i14 = i29;
                                    i15 = i31;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28 == true ? 1 : 0;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                }
                                break;
                            default:
                                unsafe3 = unsafe4;
                                registers2 = registers;
                                i13 = iPositionForFieldNumber;
                                i14 = i29;
                                i15 = i31;
                                i29 = i14;
                                messageSchema = messageSchema2;
                                unsafe = unsafe3;
                                i6 = i15;
                                i8 = i27;
                                i9 = i28 == true ? 1 : 0;
                                i11 = i13;
                                i5 = 1048575;
                                i7 = -1;
                                i4 = i3;
                                break;
                        }
                    } else {
                        Unsafe unsafe8 = unsafe4;
                        i10 = i32;
                        int i42 = iPositionForFieldNumber;
                        if (iType != 27) {
                            i20 = i31;
                            if (iType <= 49) {
                                i8 = i27;
                                i21 = i29;
                                unsafe = unsafe8;
                                i5 = 1048575;
                                i7 = -1;
                                int repeatedField = messageSchema2.parseRepeatedField(t, bArr, i20, i2, i28 == true ? 1 : 0, i10, i33, i42, i34, iType, jOffset, registers);
                                i28 = i28 == true ? 1 : 0;
                                i11 = i42;
                                if (repeatedField != i20) {
                                    messageSchema2 = this;
                                    t4 = t;
                                    bArr4 = bArr;
                                    i22 = i2;
                                    i24 = repeatedField;
                                    i26 = i11;
                                    i29 = i21;
                                    i27 = i8;
                                    unsafe4 = unsafe;
                                    i23 = -1;
                                    i25 = i10;
                                    registers3 = registers;
                                } else {
                                    messageSchema = this;
                                    i4 = i3;
                                    registers2 = registers;
                                    i6 = repeatedField;
                                }
                            } else {
                                i28 = i28 == true ? 1 : 0;
                                i21 = i29;
                                i8 = i27;
                                i11 = i42;
                                unsafe = unsafe8;
                                i5 = 1048575;
                                i7 = -1;
                                if (iType != 50) {
                                    i9 = i28 == true ? 1 : 0;
                                    int oneofField = parseOneofField(t, bArr, i20, i2, i9 == true ? 1 : 0, i10, i33, i34, iType, jOffset, i11, registers);
                                    messageSchema = this;
                                    registers2 = registers;
                                    if (oneofField != i20) {
                                        t4 = t;
                                        bArr4 = bArr;
                                        i22 = i2;
                                        i28 = i9 == true ? 1 : 0;
                                        i24 = oneofField;
                                        messageSchema2 = messageSchema;
                                        registers3 = registers2;
                                    } else {
                                        i4 = i3;
                                        i6 = oneofField;
                                        i29 = i21;
                                    }
                                } else if (i33 == 2) {
                                    int mapField = parseMapField(t, bArr, i20, i2, i11, jOffset, registers);
                                    if (mapField != i20) {
                                        messageSchema2 = this;
                                        t4 = t;
                                        bArr4 = bArr;
                                        i22 = i2;
                                        registers3 = registers;
                                        i24 = mapField;
                                    } else {
                                        messageSchema = this;
                                        i4 = i3;
                                        registers2 = registers;
                                        i6 = mapField;
                                    }
                                } else {
                                    messageSchema = this;
                                    i4 = i3;
                                    registers2 = registers;
                                    i6 = i20;
                                }
                                i26 = i11;
                                i29 = i21;
                                i27 = i8;
                                unsafe4 = unsafe;
                                i23 = i7;
                                i25 = i10;
                            }
                        } else if (i33 == 2) {
                            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe8.getObject(t4, jOffset);
                            if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                int size = protobufListMutableCopyWithCapacity2.size();
                                protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                unsafe8.putObject(t4, jOffset, protobufListMutableCopyWithCapacity2);
                            }
                            registers3 = registers;
                            int iDecodeMessageList = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(i42), i28 == true ? 1 : 0, bArr, i31, i2, protobufListMutableCopyWithCapacity2, registers3);
                            bArr4 = bArr;
                            i22 = i2;
                            i24 = iDecodeMessageList;
                            i28 = i28 == true ? 1 : 0;
                            i26 = i42;
                            unsafe4 = unsafe8;
                            i25 = i10;
                            i23 = -1;
                            t4 = t;
                        } else {
                            i20 = i31;
                            i21 = i29;
                            i8 = i27;
                            i11 = i42;
                            unsafe = unsafe8;
                            i5 = 1048575;
                            i7 = -1;
                            messageSchema = this;
                            i4 = i3;
                            registers2 = registers;
                            i6 = i20;
                        }
                        i9 = i28;
                        i29 = i21;
                    }
                }
                if (i9 != i4 || i4 == 0) {
                    if (!messageSchema.hasExtensions || registers2.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) {
                        t3 = t;
                        i12 = i9;
                        iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i12 == true ? 1 : 0, bArr, i6, i2, getMutableUnknownFields(t3), registers);
                        i22 = i2;
                    } else {
                        i12 = i9;
                        iDecodeUnknownField = ArrayDecoders.decodeExtensionOrUnknownField(i12 == true ? 1 : 0, bArr, i6, i2, t, messageSchema.defaultInstance, messageSchema.unknownFieldSchema, registers2);
                        t3 = t;
                        i22 = i2;
                    }
                    i24 = iDecodeUnknownField;
                    bArr4 = bArr;
                    registers3 = registers;
                    i28 = i12 == true ? 1 : 0;
                    t4 = t3;
                    messageSchema2 = messageSchema;
                    i26 = i11;
                    i27 = i8;
                    unsafe4 = unsafe;
                    i23 = i7;
                    i25 = i10;
                } else {
                    t2 = t;
                    i22 = i2;
                    i24 = i6;
                    i28 = i9;
                    i27 = i8;
                }
            } else {
                i4 = i3;
                t2 = t4;
                unsafe = unsafe4;
                i5 = 1048575;
                messageSchema = messageSchema2;
            }
        }
        if (i29 != i5) {
            unsafe.putInt(t2, i29, i27);
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i43 = messageSchema.checkInitializedCount; i43 < messageSchema.repeatedFieldOffsetStart; i43++) {
            unknownFieldSetLite = (UnknownFieldSetLite) messageSchema.filterMapUnknownEnumValues(t2, messageSchema.intArray[i43], unknownFieldSetLite, messageSchema.unknownFieldSchema);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t2, unknownFieldSetLite);
        }
        if (i4 == 0) {
            if (i24 != i22) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i24 > i22 || i28 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i24;
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T t, Writer writer) {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t, writer);
        }
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        extensionRegistryLite.getClass();
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        if (this.proto3) {
            parseProto3Message(t, bArr, i, i2, registers);
        } else {
            parseProto2Message(t, bArr, i, i2, 0, registers);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }

    private boolean isFieldPresent(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return isFieldPresent(t, i);
        }
        return (i3 & i4) != 0;
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t, T t2) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t, t2, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }
}
