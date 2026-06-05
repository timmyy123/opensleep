package com.urbandroid.sleep.mic;

import com.urbandroid.sleep.mic.NaiveBayesClassifier;

/* JADX INFO: loaded from: classes.dex */
public class NaiveBayesClassifierFactory {
    public NaiveBayesClassifier build() {
        return new NaiveBayesClassifier(new NaiveBayesClassifier.ClassDistribution(1.0d, new double[]{1.351d, 6.4768d, 2299625.1206d, 3661773.399d, 3188827.87d, 3588510.5661d, 2178178.0532d}, new double[]{1.5406d, 3.5544d, 3817294.5153d, 4959571.3087d, 3850814.5545d, 5083167.2519d, 3198715.7396d}), new NaiveBayesClassifier.ClassDistribution(0.02d, new double[]{5.0755d, 6.5324d, 2826650.8681d, 2819753.375d, 1863254.9572d, 1699902.2728d, 917708.6282d}, new double[]{1.461d, 1.3613d, 2473689.558d, 2312075.395d, 1459210.2957d, 1168830.0303d, 563490.6311d}));
    }
}
