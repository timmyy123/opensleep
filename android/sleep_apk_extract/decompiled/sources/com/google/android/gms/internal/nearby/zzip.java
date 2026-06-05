package com.google.android.gms.internal.nearby;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.ParcelUuid;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.util.Hex;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class zzip {
    private static final ParcelUuid zza = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private final int zzb;
    private final List zzc;
    private final SparseArray zzd;
    private final Map zze;
    private final int zzf;
    private final String zzg;
    private final byte[] zzh;

    private zzip(List list, SparseArray sparseArray, Map map, int i, int i2, String str, byte[] bArr) {
        this.zzc = list;
        this.zzd = sparseArray;
        this.zze = map;
        this.zzg = str;
        this.zzb = i;
        this.zzf = i2;
        this.zzh = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzip zza(byte[] bArr) {
        byte[] bArr2;
        if (bArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        HashMap map = new HashMap();
        int i = -1;
        int i2 = 0;
        String str = null;
        byte b = -2147483648;
        try {
            while (i2 < bArr.length) {
                try {
                    int i3 = i2 + 1;
                    int i4 = bArr[i2] & 255;
                    if (i4 == 0) {
                        bArr2 = bArr;
                        return new zzip(true == arrayList.isEmpty() ? arrayList : null, sparseArray, map, i, b, str, bArr2);
                    }
                    int i5 = i4 - 1;
                    int i6 = i2 + 2;
                    int i7 = bArr[i3] & 255;
                    if (i7 == 22) {
                        map.put(zzc(zzd(bArr, i6, 2)), zzd(bArr, i2 + 4, i4 - 3));
                    } else if (i7 != 255) {
                        switch (i7) {
                            case 1:
                                i = bArr[i6] & 255;
                                break;
                            case 2:
                            case 3:
                                zzb(bArr, i6, i5, 2, arrayList);
                                break;
                            case 4:
                            case 5:
                                zzb(bArr, i6, i5, 4, arrayList);
                                break;
                            case 6:
                            case 7:
                                zzb(bArr, i6, i5, 16, arrayList);
                                break;
                            case 8:
                            case 9:
                                str = new String(zzd(bArr, i6, i5));
                                break;
                            case 10:
                                b = bArr[i6];
                                break;
                        }
                    } else {
                        sparseArray.put(((bArr[i2 + 3] & 255) << 8) + (255 & bArr[i6]), zzd(bArr, i2 + 4, i4 - 3));
                    }
                    i2 = i6 + i5;
                } catch (Exception e) {
                    e = e;
                    bArr2 = bArr;
                }
            }
            return new zzip(true == arrayList.isEmpty() ? arrayList : null, sparseArray, map, i, b, str, bArr2);
        } catch (Exception e2) {
            e = e2;
            Log.w("BleRecord", "Unable to parse scan record: ".concat(String.valueOf(Arrays.toString(bArr2))), e);
            return null;
        }
        bArr2 = bArr;
    }

    private static int zzb(byte[] bArr, int i, int i2, int i3, List list) {
        while (i2 > 0) {
            list.add(zzc(zzd(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static ParcelUuid zzc(byte[] bArr) {
        long j;
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(length, "uuidBytes length invalid - "));
            return null;
        }
        if (length == 16) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(byteBufferOrder.getLong(8), byteBufferOrder.getLong(0)));
        }
        if (length == 2) {
            j = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
        } else {
            j = ((long) ((bArr[3] & 255) << 24)) + ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << 16));
        }
        ParcelUuid parcelUuid = zza;
        return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j << 32), parcelUuid.getUuid().getLeastSignificantBits()));
    }

    private static byte[] zzd(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzip) {
            return Arrays.equals(this.zzh, ((zzip) obj).zzh);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        String string;
        String strValueOf = String.valueOf(this.zzc);
        StringBuilder sb = new StringBuilder();
        SparseArray sparseArray = this.zzd;
        int i = 0;
        String string2 = "{}";
        if (sparseArray.size() <= 0) {
            string = "{}";
        } else {
            sb.append('{');
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                int iKeyAt = sparseArray.keyAt(i2);
                byte[] bArr = (byte[]) sparseArray.valueAt(i2);
                sb.append(iKeyAt);
                sb.append('=');
                sb.append(bArr == null ? null : Hex.bytesToStringUppercase(bArr));
            }
            sb.append('}');
            string = sb.toString();
        }
        Map map = this.zze;
        StringBuilder sb2 = new StringBuilder();
        if (!map.keySet().isEmpty()) {
            sb2.append('{');
            for (Map.Entry entry : map.entrySet()) {
                if (i > 0) {
                    sb2.append(", ");
                }
                sb2.append(entry.getKey());
                sb2.append('=');
                byte[] bArr2 = (byte[]) entry.getValue();
                sb2.append(bArr2 == null ? null : Hex.bytesToStringUppercase(bArr2));
                i++;
            }
            sb2.append('}');
            string2 = sb2.toString();
        }
        int i3 = this.zzb;
        int i4 = this.zzf;
        String str = this.zzg;
        StringBuilder sb3 = new StringBuilder("BleRecord [mAdvertiseFlags=");
        sb3.append(i3);
        sb3.append(", mServiceUuids=");
        sb3.append(strValueOf);
        sb3.append(", mManufacturerSpecificData=");
        FileInsert$$ExternalSyntheticOutline0.m(sb3, string, ", mServiceData=", string2, ", mTxPowerLevel=");
        sb3.append(i4);
        sb3.append(", mDeviceName=");
        sb3.append(str);
        sb3.append("]");
        return sb3.toString();
    }
}
