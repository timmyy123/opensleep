package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzidb extends zzide {
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private final int zzj;
    private int zzk;
    private int zzl;

    public /* synthetic */ zzidb(byte[] bArr, int i, int i2, boolean z, byte[] bArr2) {
        super(null);
        this.zzl = Integer.MAX_VALUE;
        this.zzf = bArr;
        this.zzg = i2 + i;
        this.zzi = i;
        this.zzj = i;
    }

    private final void zzP() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = i - this.zzj;
        int i3 = this.zzl;
        if (i2 <= i3) {
            this.zzh = 0;
            return;
        }
        int i4 = i2 - i3;
        this.zzh = i4;
        this.zzg = i - i4;
    }

    public final long zzA() throws zziet {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0L;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        long j = bArr[i];
        long j2 = (((long) bArr[i + 1]) & 255) << 8;
        long j3 = bArr[i + 2];
        long j4 = bArr[i + 3];
        return ((((long) bArr[i + 6]) & 255) << 48) | (j & 255) | j2 | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzB(int i) {
        if (i < 0) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        int i2 = (this.zzi - this.zzj) + i;
        if (i2 < 0) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
            return 0;
        }
        int i3 = this.zzl;
        if (i2 > i3) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        this.zzl = i2;
        zzP();
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final void zzC(int i) {
        this.zzl = i;
        zzP();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final boolean zzD() {
        return this.zzi == this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzE() {
        return this.zzi - this.zzj;
    }

    public final byte zzF() throws zziet {
        int i = this.zzi;
        if (i == this.zzg) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return (byte) 0;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 1;
        return bArr[i];
    }

    public final void zzG(int i) throws zziet {
        if (i >= 0) {
            int i2 = this.zzg;
            int i3 = this.zzi;
            if (i <= i2 - i3) {
                this.zzi = i3 + i;
                return;
            }
        }
        if (i < 0) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else {
            zzbuy$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zza() throws zziet {
        if (zzD()) {
            this.zzk = 0;
            return 0;
        }
        int iZzu = zzu();
        this.zzk = iZzu;
        if ((iZzu >>> 3) != 0) {
            return iZzu;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$1("Protocol message contained an invalid tag (zero).");
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final void zzb(int i) throws zziet {
        if (this.zzk == i) {
            return;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$1("Protocol message end-group tag did not match expected tag.");
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final boolean zzc(int i) throws zziet {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzg - this.zzi < 10) {
                while (i3 < 10) {
                    if (zzF() < 0) {
                        i3++;
                    }
                }
                zzbuy$$ExternalSyntheticBUOutline0.m$1("CodedInputStream encountered a malformed varint.");
                return false;
            }
            while (i3 < 10) {
                byte[] bArr = this.zzf;
                int i4 = this.zzi;
                this.zzi = i4 + 1;
                if (bArr[i4] < 0) {
                    i3++;
                }
            }
            zzbuy$$ExternalSyntheticBUOutline0.m$1("CodedInputStream encountered a malformed varint.");
            return false;
            return true;
        }
        if (i2 == 1) {
            zzG(8);
            return true;
        }
        if (i2 == 2) {
            zzG(zzu());
            return true;
        }
        if (i2 == 3) {
            zzL();
            zzb(((i >>> 3) << 3) | 4);
            return true;
        }
        if (i2 == 4) {
            zzK();
            return false;
        }
        if (i2 == 5) {
            zzG(4);
            return true;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$1();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final double zzd() {
        return Double.longBitsToDouble(zzA());
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final float zze() {
        return Float.intBitsToFloat(zzz());
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzf() {
        return zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzg() {
        return zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzh() {
        return zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzi() {
        return zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzj() {
        return zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final boolean zzk() {
        return zzx() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final String zzl() throws zziet {
        int iZzu = zzu();
        if (iZzu > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (iZzu <= i - i2) {
                String str = new String(this.zzf, i2, iZzu, StandardCharsets.UTF_8);
                this.zzi += iZzu;
                return str;
            }
        }
        if (iZzu == 0) {
            return "";
        }
        if (iZzu < 0) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return null;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final String zzm() throws zziet {
        int iZzu = zzu();
        if (iZzu > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (iZzu <= i - i2) {
                String strZze = zzihf.zze(this.zzf, i2, iZzu);
                this.zzi += iZzu;
                return strZze;
            }
        }
        if (iZzu == 0) {
            return "";
        }
        if (iZzu <= 0) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return null;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final zzida zzn() throws zziet {
        int iZzu = zzu();
        if (iZzu > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (iZzu <= i - i2) {
                zzida zzidaVarZzu = zzida.zzu(this.zzf, i2, iZzu, false);
                this.zzi += iZzu;
                return zzidaVarZzu;
            }
        }
        if (iZzu == 0) {
            return zzida.zza;
        }
        if (iZzu > 0) {
            int i3 = this.zzg;
            int i4 = this.zzi;
            if (iZzu <= i3 - i4) {
                int i5 = iZzu + i4;
                this.zzi = i5;
                return zzida.zzw(Arrays.copyOfRange(this.zzf, i4, i5), false);
            }
        }
        if (iZzu <= 0) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return null;
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzo() {
        return zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzp() {
        return zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzq() {
        return zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzr() {
        return zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final int zzs() {
        return zzide.zzM(zzu());
    }

    @Override // com.google.android.gms.internal.ads.zzide
    public final long zzt() {
        return zzide.zzN(zzx());
    }

    public abstract int zzu();

    public abstract int zzv();

    public final int zzw() {
        int i;
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (i3 != i2) {
            byte[] bArr = this.zzf;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzi = i4;
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
                this.zzi = i5;
                return i;
            }
        }
        return (int) zzy();
    }

    public final long zzx() {
        long j;
        long j2;
        long j3;
        int i = this.zzi;
        int i2 = this.zzg;
        if (i2 != i) {
            byte[] bArr = this.zzf;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzi = i3;
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
                            long j4 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j4;
                        } else {
                            i6 = i + 5;
                            long j5 = (((long) bArr[i8]) << 28) ^ ((long) i9);
                            if (j5 >= 0) {
                                j = j5 ^ 266354560;
                            } else {
                                i4 = i + 6;
                                long j6 = (((long) bArr[i6]) << 35) ^ j5;
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    int i10 = i + 7;
                                    long j7 = j6 ^ (((long) bArr[i4]) << 42);
                                    if (j7 >= 0) {
                                        j2 = 4363953127296L;
                                    } else {
                                        i4 = i + 8;
                                        j6 = j7 ^ (((long) bArr[i10]) << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i10 = i + 9;
                                            j7 = j6 ^ (((long) bArr[i4]) << 56);
                                            if (j7 >= 0) {
                                                j2 = 71499008037633920L;
                                            } else {
                                                i4 = i + 10;
                                                long j8 = j7 ^ (((long) bArr[i10]) << 63);
                                                if (j8 >= 0) {
                                                    j = j8 ^ (-9151873028817141888L);
                                                }
                                            }
                                        }
                                    }
                                    j = j7 ^ j2;
                                    i4 = i10;
                                }
                                j = j6 ^ j3;
                            }
                        }
                    }
                    i4 = i6;
                }
                this.zzi = i4;
                return j;
            }
        }
        return zzy();
    }

    public final long zzy() throws zziet {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzF = zzF();
            j |= ((long) (bZzF & 127)) << i;
            if ((bZzF & 128) == 0) {
                return j;
            }
        }
        zzbuy$$ExternalSyntheticBUOutline0.m$1("CodedInputStream encountered a malformed varint.");
        return 0L;
    }

    public final int zzz() throws zziet {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }
}
