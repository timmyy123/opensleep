package com.google.home.matter.serialization.codec.proto;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.internal.serialization.zzxb;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 C2\u00020\u0001:\u0001CB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\rJ\u001d\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\rJ\u001d\u0010\u001a\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0012¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b*\u0010'J\u0015\u0010+\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\b+\u0010)J\u0015\u0010,\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u001b¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u001e¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b2\u00101J\u0015\u00103\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\b5\u00104J\u0015\u00106\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001b¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001e¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0012¢\u0006\u0004\b:\u0010;R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006D"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/CodedOutputStream;", "", "Lcom/google/home/matter/serialization/codec/proto/ByteArrayOutputStream;", "byteStream", "<init>", "(Lcom/google/home/matter/serialization/codec/proto/ByteArrayOutputStream;)V", "", "flush", "()V", "", "fieldNumber", "wireType", "writeTag", "(II)V", "", SDKConstants.PARAM_VALUE, "writeByteArray", "(I[B)V", "", "writeBool", "(IZ)V", "writeSInt32", "", "writeSInt64", "(IJ)V", "writeUInt32", "writeUInt64", "", "writeFloat", "(IF)V", "", "writeDouble", "(ID)V", "", "writeString", "(ILjava/lang/String;)V", "writeBoolNoTag", "(Z)V", "writeSInt32NoTag", "(I)V", "writeSInt64NoTag", "(J)V", "writeUInt32NoTag", "writeUInt64NoTag", "writeFloatNoTag", "(F)V", "writeDoubleNoTag", "(D)V", "computeUInt32SizeNoTag", "(I)I", "computeSInt32SizeNoTag", "computeUInt64SizeNoTag", "(J)I", "computeSInt64SizeNoTag", "computeFloatSizeNoTag", "(F)I", "computeDoubleSizeNoTag", "(D)I", "computeBoolSizeNoTag", "(Z)I", "Lcom/google/home/matter/serialization/codec/proto/ByteArrayOutputStream;", "Ljava/io/ByteArrayOutputStream;", "byteStreamImpl", "Ljava/io/ByteArrayOutputStream;", "Lcom/google/protobuf/CodedOutputStream;", "codedStreamImpl", "Lcom/google/protobuf/CodedOutputStream;", "Companion", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CodedOutputStream {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ByteArrayOutputStream byteStream;
    private final java.io.ByteArrayOutputStream byteStreamImpl;
    private final zzxb codedStreamImpl;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/CodedOutputStream$Companion;", "", "<init>", "()V", "newInstance", "Lcom/google/home/matter/serialization/codec/proto/CodedOutputStream;", "output", "Lcom/google/home/matter/serialization/codec/proto/ByteArrayOutputStream;", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final CodedOutputStream newInstance(ByteArrayOutputStream output) {
            output.getClass();
            return new CodedOutputStream(output);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CodedOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.getClass();
        this.byteStream = byteArrayOutputStream;
        java.io.ByteArrayOutputStream impl = byteArrayOutputStream.getImpl();
        this.byteStreamImpl = impl;
        zzxb zzxbVarZzC = zzxb.zzC(impl, 4096);
        zzxbVarZzC.getClass();
        this.codedStreamImpl = zzxbVarZzC;
    }

    public final int computeBoolSizeNoTag(boolean value) {
        int i = zzxb.$r8$clinit;
        return 1;
    }

    public final int computeDoubleSizeNoTag(double value) {
        int i = zzxb.$r8$clinit;
        return 8;
    }

    public final int computeFloatSizeNoTag(float value) {
        int i = zzxb.$r8$clinit;
        return 4;
    }

    public final int computeSInt32SizeNoTag(int value) {
        return zzxb.zzD((value + value) ^ (value >> 31));
    }

    public final int computeSInt64SizeNoTag(long value) {
        return zzxb.zzE((value >> 63) ^ (value + value));
    }

    public final int computeUInt32SizeNoTag(int value) {
        return zzxb.zzD(value);
    }

    public final int computeUInt64SizeNoTag(long value) {
        return zzxb.zzE(value);
    }

    public final void flush() {
        this.codedStreamImpl.zzA();
    }

    public final void writeBool(int fieldNumber, boolean value) {
        this.codedStreamImpl.zzi(fieldNumber, value);
    }

    public final void writeBoolNoTag(boolean value) {
        this.codedStreamImpl.zzs(value ? (byte) 1 : (byte) 0);
    }

    public final void writeByteArray(int fieldNumber, byte[] value) {
        value.getClass();
        this.codedStreamImpl.zzl(fieldNumber, value);
    }

    public final void writeDouble(int fieldNumber, double value) {
        this.codedStreamImpl.zzh(fieldNumber, Double.doubleToRawLongBits(value));
    }

    public final void writeDoubleNoTag(double value) {
        this.codedStreamImpl.zzx(Double.doubleToRawLongBits(value));
    }

    public final void writeFloat(int fieldNumber, float value) {
        this.codedStreamImpl.zzR(fieldNumber, Float.floatToRawIntBits(value));
    }

    public final void writeFloatNoTag(float value) {
        this.codedStreamImpl.zzv(Float.floatToRawIntBits(value));
    }

    public final void writeSInt32(int fieldNumber, int value) {
        zzxb zzxbVar = this.codedStreamImpl;
        zzxbVar.zzQ(fieldNumber, (value >> 31) ^ (value + value));
    }

    public final void writeSInt32NoTag(int value) {
        this.codedStreamImpl.zzu((value >> 31) ^ (value + value));
    }

    public final void writeSInt64(int fieldNumber, long value) {
        zzxb zzxbVar = this.codedStreamImpl;
        zzxbVar.zzS(fieldNumber, (value >> 63) ^ (value + value));
    }

    public final void writeSInt64NoTag(long value) {
        this.codedStreamImpl.zzw((value >> 63) ^ (value + value));
    }

    public final void writeString(int fieldNumber, String value) {
        value.getClass();
        this.codedStreamImpl.zzj(fieldNumber, value);
    }

    public final void writeTag(int fieldNumber, int wireType) {
        this.codedStreamImpl.zzO(fieldNumber, wireType);
    }

    public final void writeUInt32(int fieldNumber, int value) {
        this.codedStreamImpl.zzQ(fieldNumber, value);
    }

    public final void writeUInt32NoTag(int value) {
        this.codedStreamImpl.zzu(value);
    }

    public final void writeUInt64(int fieldNumber, long value) {
        this.codedStreamImpl.zzS(fieldNumber, value);
    }

    public final void writeUInt64NoTag(long value) {
        this.codedStreamImpl.zzw(value);
    }
}
