package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Frame;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Detector<T> {
    private final Object zza = new Object();

    @Nullable
    private Processor<T> zzb;

    public static class Detections<T> {
        private final SparseArray<T> zza;
        private final Frame.Metadata zzb;
        private final boolean zzc;

        public Detections(SparseArray<T> sparseArray, Frame.Metadata metadata, boolean z) {
            this.zza = sparseArray;
            this.zzb = metadata;
            this.zzc = z;
        }

        public SparseArray<T> getDetectedItems() {
            return this.zza;
        }
    }

    public interface Processor<T> {
        void receiveDetections(Detections<T> detections);

        void release();
    }

    public abstract SparseArray<T> detect(Frame frame);

    public abstract boolean isOperational();

    public void receiveFrame(Frame frame) {
        Frame.Metadata metadata = new Frame.Metadata(frame.getMetadata());
        metadata.zza();
        Detections<T> detections = new Detections<>(detect(frame), metadata, isOperational());
        synchronized (this.zza) {
            try {
                Processor<T> processor = this.zzb;
                if (processor == null) {
                    throw new IllegalStateException("Detector processor must first be set with setProcessor in order to receive detection results.");
                }
                processor.receiveDetections(detections);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void release() {
        synchronized (this.zza) {
            try {
                Processor<T> processor = this.zzb;
                if (processor != null) {
                    processor.release();
                    this.zzb = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setProcessor(Processor<T> processor) {
        synchronized (this.zza) {
            try {
                Processor<T> processor2 = this.zzb;
                if (processor2 != null) {
                    processor2.release();
                }
                this.zzb = processor;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
