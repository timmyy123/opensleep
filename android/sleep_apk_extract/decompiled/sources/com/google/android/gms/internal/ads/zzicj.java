package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.ads.zzici;
import com.google.android.gms.internal.ads.zzicj;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzicj<MessageType extends zzicj<MessageType, BuilderType>, BuilderType extends zzici<MessageType, BuilderType>> implements zzifp {
    protected transient int zzq = 0;

    public static <T> void zzaW(Iterable<T> iterable, List<? super T> list) {
        zzici.zzaT(iterable, list);
    }

    private String zzdV(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(name.length() + 18 + String.valueOf(str).length() + 44);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Serializing ", name, " to a ", str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    public zzida zzaM() {
        try {
            int iZzbr = zzbr();
            zzida zzidaVar = zzida.zza;
            byte[] bArr = new byte[iZzbr];
            int i = zzidj.$r8$clinit;
            zzidg zzidgVar = new zzidg(bArr, 0, iZzbr);
            zzcX(zzidgVar);
            return zzicw.zza(zzidgVar, bArr);
        } catch (IOException e) {
            Utf8$$ExternalSyntheticBUOutline0.m(this.zzdV("ByteString"), (Throwable) e);
            return null;
        }
    }

    public byte[] zzaN() {
        try {
            int iZzbr = zzbr();
            byte[] bArr = new byte[iZzbr];
            int i = zzidj.$r8$clinit;
            zzidg zzidgVar = new zzidg(bArr, 0, iZzbr);
            zzcX(zzidgVar);
            zzidgVar.zzI();
            return bArr;
        } catch (IOException e) {
            Utf8$$ExternalSyntheticBUOutline0.m(zzdV("byte array"), (Throwable) e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzifp
    public void zzaO(OutputStream outputStream) {
        zzidi zzidiVar = new zzidi(outputStream, zzidj.zzE(zzbr()));
        zzcX(zzidiVar);
        zzidiVar.zzx();
    }

    public abstract int zzaT(zzigh zzighVar);

    public zzigs zzaU() {
        return new zzigs(this);
    }
}
