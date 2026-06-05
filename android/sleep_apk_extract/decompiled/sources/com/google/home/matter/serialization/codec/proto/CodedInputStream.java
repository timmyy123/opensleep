package com.google.home.matter.serialization.codec.proto;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.internal.serialization.zzwv;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\rJ\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0011J\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\rJ\r\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u0018J\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\r\u0010(\u001a\u00020'¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+¨\u0006-"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/CodedInputStream;", "", "", "bytes", "Lcom/google/protobuf/CodedInputStream;", "impl", "<init>", "([BLcom/google/protobuf/CodedInputStream;)V", "", "byteLimit", "pushLimit", "(I)I", "readRawVarint32", "()I", SDKConstants.PARAM_VALUE, "", "checkLastTagWas", "(I)V", "getBytesUntilLimit", "oldLimit", "popLimit", "readTag", "Lkotlin/ULong;", "readUInt64-s-VKNKU", "()J", "readUInt64", "", "readSInt64", "", "readBool", "()Z", "", "readString", "()Ljava/lang/String;", "readByteArray", "()[B", "", "readFloat", "()F", "", "readDouble", "()D", "[B", "Lcom/google/protobuf/CodedInputStream;", "Companion", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CodedInputStream {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final byte[] bytes;
    private final zzwv impl;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/CodedInputStream$Companion;", "", "<init>", "()V", "newInstance", "Lcom/google/home/matter/serialization/codec/proto/CodedInputStream;", "bytes", "", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CodedInputStream newInstance(byte[] bytes) {
            bytes.getClass();
            return new CodedInputStream(bytes, null, 2, 0 == true ? 1 : 0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CodedInputStream(byte[] bArr, zzwv zzwvVar) {
        bArr.getClass();
        zzwvVar.getClass();
        this.bytes = bArr;
        this.impl = zzwvVar;
    }

    public final void checkLastTagWas(int value) {
        this.impl.zzb(value);
    }

    public final int getBytesUntilLimit() {
        return this.impl.zzE();
    }

    public final void popLimit(int oldLimit) {
        this.impl.zzD(oldLimit);
    }

    public final int pushLimit(int byteLimit) {
        return this.impl.zzC(byteLimit);
    }

    public final boolean readBool() {
        return this.impl.zzk();
    }

    public final byte[] readByteArray() {
        byte[] bArrZzq = this.impl.zzq();
        bArrZzq.getClass();
        return bArrZzq;
    }

    public final double readDouble() {
        return this.impl.zzd();
    }

    public final float readFloat() {
        return this.impl.zze();
    }

    public final int readRawVarint32() {
        return this.impl.zzx();
    }

    public final long readSInt64() {
        return this.impl.zzw();
    }

    public final String readString() {
        String strZzl = this.impl.zzl();
        strZzl.getClass();
        return strZzl;
    }

    public final int readTag() {
        return this.impl.zza();
    }

    /* JADX INFO: renamed from: readUInt64-s-VKNKU, reason: not valid java name */
    public final long m580readUInt64sVKNKU() {
        return ULong.m2411constructorimpl(this.impl.zzf());
    }

    public /* synthetic */ CodedInputStream(byte[] bArr, zzwv zzwvVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i & 2) != 0 ? zzwv.zzL(bArr, 0, bArr.length) : zzwvVar);
    }
}
