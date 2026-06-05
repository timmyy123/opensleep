package com.urbandroid.sleep.snoring.classifier.old;

/* JADX INFO: loaded from: classes4.dex */
public class RequireTwoSubsequentPositives implements SnoringClassifier {
    private final SnoringClassifier delegate;
    private volatile boolean prevResponse = false;

    public RequireTwoSubsequentPositives(SnoringClassifier snoringClassifier) {
        this.delegate = snoringClassifier;
    }

    @Override // com.urbandroid.sleep.snoring.classifier.old.SnoringClassifier
    public boolean isSnoring(float[] fArr, int i) {
        boolean zIsSnoring = this.delegate.isSnoring(fArr, i);
        boolean z = zIsSnoring && this.prevResponse;
        this.prevResponse = zIsSnoring;
        return z;
    }
}
