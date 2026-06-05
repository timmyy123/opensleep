package com.google.android.gms.internal.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.serialization.zzvx;
import com.google.android.gms.internal.serialization.zzvy;
import java.io.IOException;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzvy<MessageType extends zzvy<MessageType, BuilderType>, BuilderType extends zzvx<MessageType, BuilderType>> implements zzaaq {
    protected int memoizedHashCode = 0;

    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        zzvx.addAll(iterable, list);
    }

    private String getSerializingExceptionMessage(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(name.length() + 18 + String.valueOf(str).length() + 44);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Serializing ", name, " to a ", str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    public abstract int getSerializedSize(zzabe zzabeVar);

    public zzabq newUninitializedMessageException() {
        return new zzabq(this);
    }

    public byte[] toByteArray() {
        try {
            int serializedSize = getSerializedSize();
            byte[] bArr = new byte[serializedSize];
            int i = zzxb.$r8$clinit;
            zzwy zzwyVar = new zzwy(bArr, 0, serializedSize);
            writeTo(zzwyVar);
            zzwyVar.zzI();
            return bArr;
        } catch (IOException e) {
            Utf8$$ExternalSyntheticBUOutline0.m(getSerializingExceptionMessage("byte array"), (Throwable) e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzaaq
    public zzwr toByteString() {
        try {
            int serializedSize = getSerializedSize();
            zzwr zzwrVar = zzwr.zzb;
            byte[] bArr = new byte[serializedSize];
            int i = zzxb.$r8$clinit;
            zzwy zzwyVar = new zzwy(bArr, 0, serializedSize);
            writeTo(zzwyVar);
            return zzwo.zza(zzwyVar, bArr);
        } catch (IOException e) {
            Utf8$$ExternalSyntheticBUOutline0.m(this.getSerializingExceptionMessage("ByteString"), (Throwable) e);
            return null;
        }
    }
}
