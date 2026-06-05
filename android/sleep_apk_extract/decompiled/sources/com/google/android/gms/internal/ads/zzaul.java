package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzaul implements zzaum {
    private static final Logger zzb = Logger.getLogger(zzaul.class.getName());
    final ThreadLocal zza = new zzauk(this);

    public abstract zzaup zza(String str, byte[] bArr, String str2);

    @Override // com.google.android.gms.internal.ads.zzaum
    public final zzaup zzb(zzimg zzimgVar, zzauq zzauqVar) throws EOFException {
        int iZza;
        long jZzb;
        long jZzc = zzimgVar.zzc();
        ThreadLocal threadLocal = this.zza;
        ((ByteBuffer) threadLocal.get()).rewind().limit(8);
        do {
            iZza = zzimgVar.zza((ByteBuffer) threadLocal.get());
            byte[] bArr = null;
            if (iZza == 8) {
                ((ByteBuffer) threadLocal.get()).rewind();
                long jZza = zzauo.zza((ByteBuffer) threadLocal.get());
                if (jZza < 8 && jZza > 1) {
                    Logger logger = zzb;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(jZza);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                byte[] bArr2 = new byte[4];
                ((ByteBuffer) threadLocal.get()).get(bArr2);
                try {
                    String str = new String(bArr2, "ISO-8859-1");
                    if (jZza == 1) {
                        ThreadLocal threadLocal2 = this.zza;
                        ((ByteBuffer) threadLocal2.get()).limit(16);
                        zzimgVar.zza((ByteBuffer) threadLocal2.get());
                        ((ByteBuffer) threadLocal2.get()).position(8);
                        jZzb = zzauo.zzd((ByteBuffer) threadLocal2.get()) - 16;
                    } else {
                        jZzb = jZza == 0 ? zzimgVar.zzb() - zzimgVar.zzc() : jZza - 8;
                    }
                    if ("uuid".equals(str)) {
                        ThreadLocal threadLocal3 = this.zza;
                        ((ByteBuffer) threadLocal3.get()).limit(((ByteBuffer) threadLocal3.get()).limit() + 16);
                        zzimgVar.zza((ByteBuffer) threadLocal3.get());
                        bArr = new byte[16];
                        for (int iPosition = ((ByteBuffer) threadLocal3.get()).position() - 16; iPosition < ((ByteBuffer) threadLocal3.get()).position(); iPosition++) {
                            bArr[iPosition - (((ByteBuffer) threadLocal3.get()).position() - 16)] = ((ByteBuffer) threadLocal3.get()).get(iPosition);
                        }
                        jZzb -= 16;
                    }
                    long j = jZzb;
                    zzaup zzaupVarZza = zza(str, bArr, zzauqVar instanceof zzaup ? ((zzaup) zzauqVar).zza() : "");
                    ThreadLocal threadLocal4 = this.zza;
                    ((ByteBuffer) threadLocal4.get()).rewind();
                    zzaupVarZza.zzb(zzimgVar, (ByteBuffer) threadLocal4.get(), j, this);
                    return zzaupVarZza;
                } catch (UnsupportedEncodingException e) {
                    Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
                    return null;
                }
            }
        } while (iZza >= 0);
        zzimgVar.zzd(jZzc);
        Utf8$$ExternalSyntheticBUOutline0.m$2();
        return null;
    }
}
