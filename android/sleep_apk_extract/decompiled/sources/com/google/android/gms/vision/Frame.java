package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class Frame {
    private final Metadata zza;

    @Nullable
    private ByteBuffer zzb;

    @Nullable
    private Bitmap zzd;

    public static class Builder {
        private final Frame zza = new Frame();

        public Frame build() {
            if (this.zza.zzb != null || this.zza.zzd != null) {
                return this.zza;
            }
            Frame.zzc(this.zza);
            Utf8$$ExternalSyntheticBUOutline0.m$3("Missing image data.  Call either setBitmap or setImageData to specify the image");
            return null;
        }

        public Builder setId(int i) {
            this.zza.getMetadata().zzc = i;
            return this;
        }

        public Builder setImageData(ByteBuffer byteBuffer, int i, int i2, int i3) {
            if (byteBuffer == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Null image data supplied.");
                return null;
            }
            if (byteBuffer.capacity() < i * i2) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid image data size.");
                return null;
            }
            if (i3 != 16 && i3 != 17 && i3 != 842094169) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m256m(37, i3, "Unsupported image format: "));
                return null;
            }
            this.zza.zzb = byteBuffer;
            Metadata metadata = this.zza.getMetadata();
            metadata.zza = i;
            metadata.zzb = i2;
            metadata.zzf = i3;
            return this;
        }

        public Builder setRotation(int i) {
            this.zza.getMetadata().zze = i;
            return this;
        }

        public Builder setTimestampMillis(long j) {
            this.zza.getMetadata().zzd = j;
            return this;
        }
    }

    public static class zza {
    }

    private Frame() {
        this.zza = new Metadata();
        this.zzb = null;
        this.zzd = null;
    }

    public static /* synthetic */ zza zzc(Frame frame) {
        frame.getClass();
        return null;
    }

    public Bitmap getBitmap() {
        return this.zzd;
    }

    public ByteBuffer getGrayscaleImageData() {
        Bitmap bitmap = this.zzd;
        if (bitmap == null) {
            return this.zzb;
        }
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = this.zzd.getHeight();
        int i = width * height;
        this.zzd.getPixels(new int[i], 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((Color.blue(r1[i2]) * 0.114f) + (Color.green(r1[i2]) * 0.587f) + (Color.red(r1[i2]) * 0.299f));
        }
        return ByteBuffer.wrap(bArr);
    }

    public Metadata getMetadata() {
        return this.zza;
    }

    public Image.Plane[] getPlanes() {
        return null;
    }

    public static class Metadata {
        private int zza;
        private int zzb;
        private int zzc;
        private long zzd;
        private int zze;
        private int zzf;

        public Metadata(Metadata metadata) {
            this.zzf = -1;
            this.zza = metadata.getWidth();
            this.zzb = metadata.getHeight();
            this.zzc = metadata.getId();
            this.zzd = metadata.getTimestampMillis();
            this.zze = metadata.getRotation();
            this.zzf = metadata.getFormat();
        }

        public int getFormat() {
            return this.zzf;
        }

        public int getHeight() {
            return this.zzb;
        }

        public int getId() {
            return this.zzc;
        }

        public int getRotation() {
            return this.zze;
        }

        public long getTimestampMillis() {
            return this.zzd;
        }

        public int getWidth() {
            return this.zza;
        }

        public final void zza() {
            if (this.zze % 2 != 0) {
                int i = this.zza;
                this.zza = this.zzb;
                this.zzb = i;
            }
            this.zze = 0;
        }

        public Metadata() {
            this.zzf = -1;
        }
    }
}
