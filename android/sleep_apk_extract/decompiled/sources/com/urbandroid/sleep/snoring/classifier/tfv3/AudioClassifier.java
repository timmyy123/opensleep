package com.urbandroid.sleep.snoring.classifier.tfv3;

import com.urbandroid.sleep.snoring.record.MonoSample;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;", "T", "", "classify", "sample", "Lcom/urbandroid/sleep/snoring/record/MonoSample;", "(Lcom/urbandroid/sleep/snoring/record/MonoSample;)Ljava/lang/Object;", "getInputSampleRate", "", "getInputLengthSeconds", "", "close", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface AudioClassifier<T> {
    T classify(MonoSample sample);

    default void close() {
    }

    double getInputLengthSeconds();

    int getInputSampleRate();
}
