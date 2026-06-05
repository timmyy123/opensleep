package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zztg extends zzcp {
    private zzhaf zzd;
    private zzhaf zze;

    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011b  */
    @Override // com.google.android.gms.internal.ads.zzco
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd(ByteBuffer byteBuffer) {
        zzhaf zzhafVar = this.zze;
        zzhafVar.getClass();
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferZzk = zzk(((iLimit - iPosition) / this.zzb.zze) * this.zzc.zze);
        while (iPosition < iLimit) {
            for (int i = 0; i < zzhafVar.zzh(); i++) {
                int iZzG = (zzfl.zzG(this.zzb.zzd) * zzhafVar.zzi(i)) + iPosition;
                int i2 = this.zzb.zzd;
                if (i2 == 2) {
                    byteBufferZzk.putShort(byteBuffer.getShort(iZzG));
                } else if (i2 == 3) {
                    byteBufferZzk.put(byteBuffer.get(iZzG));
                } else if (i2 == 4) {
                    byteBufferZzk.putFloat(byteBuffer.getFloat(iZzG));
                } else if (i2 == 21) {
                    ByteOrder byteOrderOrder = byteBuffer.order();
                    ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                    byte b = byteBuffer.get(byteOrderOrder == byteOrder ? iZzG : iZzG + 2);
                    byte b2 = byteBuffer.get(iZzG + 1);
                    if (byteBuffer.order() == byteOrder) {
                        iZzG += 2;
                    }
                    int i3 = ((b << 24) & Color.BLACK) | ((b2 << 16) & 16711680) | ((byteBuffer.get(iZzG) << 8) & 65280);
                    int i4 = i3 >> 8;
                    zzgtj.zzf((i4 & Color.BLACK) == 0 || (i4 & (-8388608)) == -8388608, "Value out of range of 24-bit integer: %s", Integer.toHexString(i4));
                    zzgtj.zza(byteBufferZzk.remaining() >= 3);
                    byteBufferZzk.put((byte) (byteBufferZzk.order() == byteOrder ? (i3 >> 24) & PHIpAddressSearchManager.END_IP_SCAN : i4 & PHIpAddressSearchManager.END_IP_SCAN)).put((byte) ((i3 >> 16) & PHIpAddressSearchManager.END_IP_SCAN)).put((byte) (byteBufferZzk.order() == byteOrder ? i4 & PHIpAddressSearchManager.END_IP_SCAN : (i3 >> 24) & PHIpAddressSearchManager.END_IP_SCAN));
                } else if (i2 == 22) {
                    byteBufferZzk.putInt(byteBuffer.getInt(iZzG));
                } else if (i2 != 268435456) {
                    if (i2 != 1342177280) {
                        if (i2 != 1610612736) {
                            if (i2 != 1879048192) {
                                Utf8$$ExternalSyntheticBUOutline0.m$3(zzba$$ExternalSyntheticOutline0.m(i2, "Unexpected encoding: ", new StringBuilder(String.valueOf(i2).length() + 21)));
                                return;
                            }
                            byteBufferZzk.putDouble(byteBuffer.getDouble(iZzG));
                        }
                    }
                }
            }
            iPosition += this.zzb.zze;
        }
        byteBuffer.position(iLimit);
        byteBufferZzk.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcl zzm(zzcl zzclVar) throws zzcn {
        zzhaf zzhafVar = this.zzd;
        if (zzhafVar == null) {
            return zzcl.zza;
        }
        int i = zzclVar.zzd;
        if (!zzfl.zzD(i)) {
            throw new zzcn("Unhandled input format:", zzclVar);
        }
        int iZzh = zzhafVar.zzh();
        int i2 = zzclVar.zzc;
        boolean z = i2 != iZzh;
        int i3 = 0;
        while (i3 < iZzh) {
            int iZzi = zzhafVar.zzi(i3);
            if (iZzi >= i2) {
                String string = zzhafVar.toString();
                throw new zzcn(Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 59), "Channel map (", string, ") trying to access non-existent input channel."), zzclVar);
            }
            z |= iZzi != i3;
            i3++;
        }
        return z ? new zzcl(zzclVar.zzb, iZzh, i) : zzcl.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void zzo(zzcm zzcmVar) {
        this.zze = this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void zzp() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzq(zzhaf zzhafVar) {
        this.zzd = zzhafVar;
    }
}
