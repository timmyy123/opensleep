package com.google.android.gms.internal.serialization;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes3.dex */
final class zzws extends zzwv {
    private final byte[] zza;
    private int zzf;
    private int zzg;
    private int zzh;
    private final int zzi;
    private int zzj;
    private int zzk;

    public /* synthetic */ zzws(byte[] bArr, int i, int i2, boolean z, byte[] bArr2) {
        super(null);
        this.zzk = Integer.MAX_VALUE;
        this.zza = bArr;
        this.zzf = i2 + i;
        this.zzh = i;
        this.zzi = i;
    }

    private final void zzS() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = i - this.zzi;
        int i3 = this.zzk;
        if (i2 <= i3) {
            this.zzg = 0;
            return;
        }
        int i4 = i2 - i3;
        this.zzg = i4;
        this.zzf = i - i4;
    }

    public final int zzA() throws zzzv {
        int i = this.zzh;
        if (this.zzf - i < 4) {
            Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        byte[] bArr = this.zza;
        this.zzh = i + 4;
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }

    public final long zzB() throws zzzv {
        int i = this.zzh;
        if (this.zzf - i < 8) {
            Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0L;
        }
        byte[] bArr = this.zza;
        this.zzh = i + 8;
        long j = bArr[i];
        long j2 = (((long) bArr[i + 1]) & 255) << 8;
        long j3 = bArr[i + 2];
        long j4 = bArr[i + 3];
        return ((((long) bArr[i + 6]) & 255) << 48) | (j & 255) | j2 | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final int zzC(int i) throws zzzv {
        if (i < 0) {
            Gson$$ExternalSyntheticBUOutline0.m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        int i2 = (this.zzh - this.zzi) + i;
        if (i2 < 0) {
            Gson$$ExternalSyntheticBUOutline0.m("Failed to parse the message.");
            return 0;
        }
        int i3 = this.zzk;
        if (i2 > i3) {
            Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        this.zzk = i2;
        zzS();
        return i3;
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final void zzD(int i) {
        this.zzk = i;
        zzS();
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final int zzE() {
        int i = this.zzk;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.zzh - this.zzi);
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final boolean zzF() {
        return this.zzh == this.zzf;
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final int zzG() {
        return this.zzh - this.zzi;
    }

    public final byte zzH() throws zzzv {
        int i = this.zzh;
        if (i == this.zzf) {
            Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return (byte) 0;
        }
        byte[] bArr = this.zza;
        this.zzh = i + 1;
        return bArr[i];
    }

    public final byte[] zzI(int i) throws zzzv {
        if (i > 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (i <= i2 - i3) {
                int i4 = i + i3;
                this.zzh = i4;
                return Arrays.copyOfRange(this.zza, i3, i4);
            }
        }
        if (i > 0) {
            Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return null;
        }
        if (i == 0) {
            return zzzt.zzb;
        }
        Gson$$ExternalSyntheticBUOutline0.m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        return null;
    }

    public final void zzJ(int i) throws zzzv {
        if (i >= 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (i <= i2 - i3) {
                this.zzh = i3 + i;
                return;
            }
        }
        if (i < 0) {
            Gson$$ExternalSyntheticBUOutline0.m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else {
            Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final int zza() throws zzzv {
        if (zzF()) {
            this.zzj = 0;
            return 0;
        }
        int iZzx = zzx();
        this.zzj = iZzx;
        if ((iZzx >>> 3) != 0) {
            return iZzx;
        }
        Gson$$ExternalSyntheticBUOutline0.m("Protocol message contained an invalid tag (zero).");
        return 0;
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final void zzb(int i) throws zzzv {
        if (this.zzj == i) {
            return;
        }
        Gson$$ExternalSyntheticBUOutline0.m("Protocol message end-group tag did not match expected tag.");
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final boolean zzc(int i) throws zzzv {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzf - this.zzh < 10) {
                while (i3 < 10) {
                    if (zzH() < 0) {
                        i3++;
                    }
                }
                Gson$$ExternalSyntheticBUOutline0.m("CodedInputStream encountered a malformed varint.");
                return false;
            }
            while (i3 < 10) {
                byte[] bArr = this.zza;
                int i4 = this.zzh;
                this.zzh = i4 + 1;
                if (bArr[i4] < 0) {
                    i3++;
                }
            }
            Gson$$ExternalSyntheticBUOutline0.m("CodedInputStream encountered a malformed varint.");
            return false;
            return true;
        }
        if (i2 == 1) {
            zzJ(8);
            return true;
        }
        if (i2 == 2) {
            zzJ(zzx());
            return true;
        }
        if (i2 == 3) {
            zzO();
            zzb(((i >>> 3) << 3) | 4);
            return true;
        }
        if (i2 == 4) {
            return false;
        }
        if (i2 == 5) {
            zzJ(4);
            return true;
        }
        Gson$$ExternalSyntheticBUOutline0.m();
        return false;
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final double zzd() {
        return Double.longBitsToDouble(zzB());
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final float zze() {
        return Float.intBitsToFloat(zzA());
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final long zzf() {
        return zzy();
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final long zzg() {
        return zzy();
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final int zzh() {
        return zzx();
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final long zzi() {
        return zzB();
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final int zzj() {
        return zzA();
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final boolean zzk() {
        return zzy() != 0;
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final String zzl() throws zzzv {
        int iZzx = zzx();
        if (iZzx > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzx <= i - i2) {
                String str = new String(this.zza, i2, iZzx, zzzt.zza);
                this.zzh += iZzx;
                return str;
            }
        }
        if (iZzx == 0) {
            return "";
        }
        if (iZzx < 0) {
            Gson$$ExternalSyntheticBUOutline0.m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return null;
        }
        Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return null;
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final String zzm() throws zzzv {
        int iZzx = zzx();
        if (iZzx > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzx <= i - i2) {
                String strZze = zzacd.zze(this.zza, i2, iZzx);
                this.zzh += iZzx;
                return strZze;
            }
        }
        if (iZzx == 0) {
            return "";
        }
        if (iZzx <= 0) {
            Gson$$ExternalSyntheticBUOutline0.m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return null;
        }
        Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return null;
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final zzwr zzp() throws zzzv {
        int iZzx = zzx();
        if (iZzx > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzx <= i - i2) {
                zzwr zzwrVarZzl = zzwr.zzl(this.zza, i2, iZzx);
                this.zzh += iZzx;
                return zzwrVarZzl;
            }
        }
        if (iZzx == 0) {
            return zzwr.zzb;
        }
        byte[] bArrZzI = zzI(iZzx);
        zzwr zzwrVar = zzwr.zzb;
        return new zzwq(bArrZzI);
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final byte[] zzq() {
        return zzI(zzx());
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final int zzr() {
        return zzx();
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final int zzs() {
        return zzx();
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final int zzt() {
        return zzA();
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final long zzu() {
        return zzB();
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final int zzv() {
        return zzwv.zzP(zzx());
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final long zzw() {
        return zzwv.zzQ(zzy());
    }

    @Override // com.google.android.gms.internal.serialization.zzwv
    public final int zzx() {
        int i;
        int i2 = this.zzh;
        int i3 = this.zzf;
        if (i3 != i2) {
            byte[] bArr = this.zza;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzh = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << MqttWireMessage.MESSAGE_TYPE_DISCONNECT) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.zzh = i5;
                return i;
            }
        }
        return (int) zzz();
    }

    public final long zzy() {
        long j;
        long j2;
        int i = this.zzh;
        int i2 = this.zzf;
        if (i2 != i) {
            byte[] bArr = this.zza;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzh = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << MqttWireMessage.MESSAGE_TYPE_DISCONNECT) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            long j3 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j3;
                        } else {
                            i6 = i + 5;
                            long j4 = (((long) bArr[i8]) << 28) ^ ((long) i9);
                            if (j4 >= 0) {
                                j = j4 ^ 266354560;
                            } else {
                                i4 = i + 6;
                                long j5 = (((long) bArr[i6]) << 35) ^ j4;
                                if (j5 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    int i10 = i + 7;
                                    long j6 = j5 ^ (((long) bArr[i4]) << 42);
                                    if (j6 >= 0) {
                                        j = j6 ^ 4363953127296L;
                                    } else {
                                        i4 = i + 8;
                                        j5 = j6 ^ (((long) bArr[i10]) << 49);
                                        if (j5 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i10 = i + 9;
                                            long j7 = (j5 ^ (((long) bArr[i4]) << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                i4 = i + 10;
                                                if (bArr[i10] >= 0) {
                                                    j = j7;
                                                }
                                            } else {
                                                j = j7;
                                            }
                                        }
                                    }
                                    i4 = i10;
                                }
                                j = j5 ^ j2;
                            }
                        }
                    }
                    i4 = i6;
                }
                this.zzh = i4;
                return j;
            }
        }
        return zzz();
    }

    public final long zzz() throws zzzv {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzH = zzH();
            j |= ((long) (bZzH & 127)) << i;
            if ((bZzH & 128) == 0) {
                return j;
            }
        }
        Gson$$ExternalSyntheticBUOutline0.m("CodedInputStream encountered a malformed varint.");
        return 0L;
    }
}
