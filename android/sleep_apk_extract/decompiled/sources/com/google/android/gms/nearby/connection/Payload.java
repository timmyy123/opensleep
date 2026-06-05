package com.google.android.gms.nearby.connection;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zzpo;
import com.google.android.gms.internal.nearby.zzpt;
import java.io.InputStream;
import java.util.UUID;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes3.dex */
public class Payload {
    public static final zzpt zza = zzpt.zzn(MqttTopic.TOPIC_LEVEL_SEPARATOR, "\\", "../");
    public static final zzpt zzb = zzpt.zzq("../", MqttTopic.TOPIC_LEVEL_SEPARATOR, "\\", "?", "*", "\"", "<", ">", "|", ":", "\u0000", "\n", "\r", "\t", "\f");
    public static final zzpt zzc = zzpt.zzo("..", ".", "\\", MqttTopic.TOPIC_LEVEL_SEPARATOR);
    public static final zzpt zzd = zzpt.zzl("\\");
    public static final zzpt zze = zzpt.zzm("../", "..\\");
    public static final zzpt zzf = zzpt.zzq("?", "*", "\"", "|", ":", "\u0000", "\n", "\r", "\t", "\f", "../", "..", new String[0]);
    public static final zzpt zzg = zzpt.zzl("\\");
    public static final zzpt zzh = zzpt.zzm("\\", MqttTopic.TOPIC_LEVEL_SEPARATOR);
    private final long zzi;
    private final int zzj;
    private final byte[] zzk;
    private final File zzl;
    private final Stream zzm;
    private long zzn;
    private boolean zzo;
    private long zzp;
    private String zzq;
    private String zzr;

    public static class File {
        private final java.io.File zza;
        private final ParcelFileDescriptor zzb;
        private final long zzc;
        private final Uri zzd;

        private File(java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j, Uri uri) {
            this.zza = file;
            this.zzb = parcelFileDescriptor;
            this.zzc = j;
            this.zzd = uri;
        }

        public static File zzb(java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j, Uri uri) {
            return new File((java.io.File) Preconditions.checkNotNull(file, "Cannot create Payload.File from null java.io.File."), (ParcelFileDescriptor) Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), j, (Uri) Preconditions.checkNotNull(uri, "Cannot create Payload.File from null Uri"));
        }

        public static File zzc(ParcelFileDescriptor parcelFileDescriptor) {
            return new File(null, (ParcelFileDescriptor) Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), parcelFileDescriptor.getStatSize(), null);
        }

        @Deprecated
        public java.io.File asJavaFile() {
            return this.zza;
        }

        public Uri asUri() {
            return this.zzd;
        }

        public long getSize() {
            return this.zzc;
        }

        public final ParcelFileDescriptor zza() {
            return this.zzb;
        }
    }

    public static class Stream {
        private final ParcelFileDescriptor zza;
        private InputStream zzb;

        private Stream(ParcelFileDescriptor parcelFileDescriptor, InputStream inputStream) {
            this.zza = parcelFileDescriptor;
            this.zzb = inputStream;
        }

        public static Stream zzb(ParcelFileDescriptor parcelFileDescriptor) {
            Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.Stream from null ParcelFileDescriptor.");
            return new Stream(parcelFileDescriptor, null);
        }

        public InputStream asInputStream() {
            if (this.zzb == null) {
                this.zzb = new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor) Preconditions.checkNotNull(this.zza));
            }
            return this.zzb;
        }
    }

    private Payload(long j, int i, byte[] bArr, File file, Stream stream) {
        this.zzi = j;
        this.zzj = i;
        this.zzk = bArr;
        this.zzl = file;
        this.zzm = stream;
    }

    public static Payload fromBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr, "Cannot create a Payload from null bytes.");
        return zzb(bArr, UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload zzb(byte[] bArr, long j) {
        return new Payload(j, 1, bArr, null, null);
    }

    public static Payload zzc(File file, long j) {
        Payload payload = new Payload(j, 2, null, file, null);
        if (file.getSize() <= 0) {
            return payload;
        }
        long size = file.getSize();
        if (size < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Payload size must be positive.");
            return null;
        }
        if (payload.getType() != 3 && payload.getType() != 2) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Payload type must be FILE or STREAM.");
            return null;
        }
        if (size >= payload.zzn) {
            payload.zzp = size;
            return payload;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Payload stream size must be larger than the offset.");
        return null;
    }

    public static Payload zzd(Uri uri, long j, long j2) {
        return zzc(new File(j, (Uri) Preconditions.checkNotNull(uri, "Cannot create Payload.File from null Uri")), j2);
    }

    public static Payload zze(Stream stream, long j) {
        return new Payload(j, 3, null, null, stream);
    }

    public byte[] asBytes() {
        return this.zzk;
    }

    public File asFile() {
        return this.zzl;
    }

    public Stream asStream() {
        return this.zzm;
    }

    public long getId() {
        return this.zzi;
    }

    public long getOffset() {
        return this.zzn;
    }

    public int getType() {
        return this.zzj;
    }

    public void setFileName(String str) {
        if (zzpo.zzb(str)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Payload file name should not be null or empty.");
            return;
        }
        if (getType() != 2) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Payload type must be FILE.");
            return;
        }
        zzpt zzptVar = zza;
        int size = zzptVar.size();
        int i = 0;
        while (i < size) {
            String str2 = (String) zzptVar.get(i);
            i++;
            if (str.contains(str2)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("File name ", str, " contains illegal string ", str2, "."));
                return;
            }
        }
        this.zzq = str;
    }

    public void setParentFolder(String str) {
        if (zzpo.zzb(str)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Payload parent folder should not be null or empty.");
            return;
        }
        if (getType() != 2) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Payload type must be FILE.");
            return;
        }
        zzpt zzptVar = zze;
        int size = zzptVar.size();
        int i = 0;
        while (i < size) {
            boolean zContains = str.contains((String) zzptVar.get(i));
            i++;
            if (zContains) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Folder name contains illegal string.");
                return;
            }
        }
        this.zzr = str;
    }

    public final long zza() {
        return this.zzp;
    }

    public final String zzf() {
        return this.zzq;
    }

    public final String zzg() {
        return this.zzr;
    }

    public final boolean zzh() {
        return this.zzo;
    }
}
