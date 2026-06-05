package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhg> CREATOR = new zzhd();
    private byte[] zza;
    private ParcelFileDescriptor zzb;

    public zzhg(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza = new byte[0];
        this.zzb = parcelFileDescriptor;
    }

    public static byte[] zzd(ParcelFileDescriptor parcelFileDescriptor) {
        DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
        try {
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.read(bArr);
                return bArr;
            } catch (IOException e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            }
        } finally {
            zze(dataInputStream);
        }
    }

    private static void zze(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("ParcelByteArray", "Could not close stream", e);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhg) {
            return Arrays.equals(this.zza, ((zzhg) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0064: MOVE (r4 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:101), block:B:20:0x0064 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c A[PHI: r7
      0x009c: PHI (r7v4 java.io.DataOutputStream) = (r7v3 java.io.DataOutputStream), (r7v5 java.io.DataOutputStream) binds: [B:42:0x00b5, B:37:0x009a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.os.Parcelable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void writeToParcel(Parcel parcel, int i) throws Throwable {
        Closeable closeable;
        DataOutputStream dataOutputStream;
        ParcelFileDescriptor parcelFileDescriptor;
        File fileZzb;
        byte[] bArr = this.zza;
        Closeable closeable2 = null;
        if (bArr != null) {
            try {
                if (this.zzb == null) {
                    try {
                        try {
                            fileZzb = zzhm.zzb();
                        } catch (IOException e) {
                            e = e;
                            dataOutputStream = null;
                        }
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dataOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (closeable2 != null) {
                            zze(closeable2);
                        }
                        throw th;
                    }
                    if (fileZzb == null) {
                        throw new IllegalStateException("Must set temp dir before writing this object to a parcel");
                    }
                    try {
                        File fileCreateTempFile = File.createTempFile("teleporter" + SystemClock.elapsedRealtime(), ".tmp", fileZzb);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(fileCreateTempFile, ClientDefaults.MAX_MSG_SIZE);
                            fileCreateTempFile.delete();
                            Pair pairCreate = Pair.create(fileOutputStream, parcelFileDescriptorOpen);
                            dataOutputStream = new DataOutputStream(new BufferedOutputStream((OutputStream) pairCreate.first));
                            try {
                                dataOutputStream.writeInt(bArr.length);
                                dataOutputStream.write(bArr);
                                parcelFileDescriptor = (ParcelFileDescriptor) pairCreate.second;
                                zze(dataOutputStream);
                            } catch (IOException e3) {
                                e = e3;
                                Log.e("ParcelByteArray", "Could not write into unlinked file. " + e.toString());
                                if (dataOutputStream != null) {
                                    zze(dataOutputStream);
                                }
                                parcelFileDescriptor = null;
                            } catch (IllegalStateException e4) {
                                e = e4;
                                Log.e("ParcelByteArray", "Could not create unlinked file. " + e.toString());
                                if (dataOutputStream != null) {
                                }
                                parcelFileDescriptor = null;
                            }
                            this.zzb = parcelFileDescriptor;
                        } catch (FileNotFoundException e5) {
                            throw new IllegalStateException("Temporary file is somehow already deleted", e5);
                        }
                    } catch (IOException e6) {
                        throw new IllegalStateException("Could not create temporary file", e6);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                closeable2 = closeable;
            }
        }
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzb, i | 1, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        this.zzb = null;
    }

    public final byte[] zzc() {
        return this.zza;
    }
}
