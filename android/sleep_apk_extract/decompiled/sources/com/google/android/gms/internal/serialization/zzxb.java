package com.google.android.gms.internal.serialization;

import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzxb extends zzwj {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final Logger zza = Logger.getLogger(zzxb.class.getName());
    private static final boolean zzb = zzaby.zza();
    zzxc zze;

    public /* synthetic */ zzxb(byte[] bArr) {
    }

    public static zzxb zzC(OutputStream outputStream, int i) {
        return new zzxa(outputStream, 4096);
    }

    public static int zzD(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzE(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int zzF(String str) {
        int length;
        try {
            length = zzacd.zzb(str);
        } catch (zzacc unused) {
            length = str.getBytes(zzzt.zza).length;
        }
        return zzD(length) + length;
    }

    public static int zzG(zzaaq zzaaqVar) {
        int serializedSize = zzaaqVar.getSerializedSize();
        return zzD(serializedSize) + serializedSize;
    }

    public static int zzH(zzaaq zzaaqVar, zzabe zzabeVar) {
        int serializedSize = ((zzvy) zzaaqVar).getSerializedSize(zzabeVar);
        return zzD(serializedSize) + serializedSize;
    }

    @Deprecated
    public static int zzK(int i, zzaaq zzaaqVar, zzabe zzabeVar) {
        int iZzD = zzD(i << 3);
        return ((zzvy) zzaaqVar).getSerializedSize(zzabeVar) + iZzD + iZzD;
    }

    public abstract void zzA();

    public final void zzI() {
        if (zzb() == 0) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Did not write as much data as expected.");
    }

    public final void zzJ(String str, zzacc zzaccVar) throws zzwz {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzaccVar);
        byte[] bytes = str.getBytes(zzzt.zza);
        try {
            int length = bytes.length;
            zzu(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzwz(e);
        }
    }

    public abstract void zzO(int i, int i2);

    public abstract void zzP(int i, int i2);

    public abstract void zzQ(int i, int i2);

    public abstract void zzR(int i, int i2);

    public abstract void zzS(int i, long j);

    @Override // com.google.android.gms.internal.serialization.zzwj
    public abstract void zza(byte[] bArr, int i, int i2);

    public abstract int zzb();

    public abstract void zzh(int i, long j);

    public abstract void zzi(int i, boolean z);

    public abstract void zzj(int i, String str);

    public abstract void zzk(int i, zzwr zzwrVar);

    public abstract void zzl(int i, byte[] bArr);

    public abstract void zzm(zzwr zzwrVar);

    public abstract void zzn(byte[] bArr, int i, int i2);

    public abstract void zzo(int i, zzaaq zzaaqVar, zzabe zzabeVar);

    public abstract void zzp(int i, zzaaq zzaaqVar);

    public abstract void zzq(int i, zzwr zzwrVar);

    public abstract void zzr(zzaaq zzaaqVar);

    public abstract void zzs(byte b);

    public abstract void zzt(int i);

    public abstract void zzu(int i);

    public abstract void zzv(int i);

    public abstract void zzw(long j);

    public abstract void zzx(long j);

    public abstract void zzz(String str);
}
