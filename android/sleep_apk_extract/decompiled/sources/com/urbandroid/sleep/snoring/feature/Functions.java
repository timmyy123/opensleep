package com.urbandroid.sleep.snoring.feature;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Functions {
    public static FloatFunction subtract(final FloatFunction floatFunction, final FloatFunction floatFunction2) {
        return new FloatFunction() { // from class: com.urbandroid.sleep.snoring.feature.Functions.2
            @Override // com.urbandroid.sleep.snoring.feature.FloatFunction
            public float apply(float f) {
                return floatFunction.apply(f) - floatFunction2.apply(f);
            }
        };
    }
}
