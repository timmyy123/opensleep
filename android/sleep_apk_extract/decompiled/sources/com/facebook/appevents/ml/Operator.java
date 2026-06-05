package com.facebook.appevents.ml;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001b\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J+\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0013H\u0007J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0013H\u0007J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u001e"}, d2 = {"Lcom/facebook/appevents/ml/Operator;", "", "()V", "addmv", "", "x", "Lcom/facebook/appevents/ml/MTensor;", "b", "concatenate", "tensors", "", "([Lcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "conv1D", "w", "dense", "embedding", "texts", "", "seqLength", "", "([Ljava/lang/String;ILcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "flatten", "startDim", "maxPool1D", "poolSize", "mul", "relu", "softmax", "transpose2D", "transpose3D", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Operator {
    public static final Operator INSTANCE = new Operator();

    private Operator() {
    }

    public static final void addmv(MTensor x, MTensor b) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            x.getClass();
            b.getClass();
            int shape = x.getShape(0);
            int shape2 = x.getShape(1);
            int shape3 = x.getShape(2);
            float[] data2 = x.getData();
            float[] data3 = b.getData();
            for (int i = 0; i < shape; i++) {
                for (int i2 = 0; i2 < shape2; i2++) {
                    for (int i3 = 0; i3 < shape3; i3++) {
                        int i4 = (i2 * shape3) + (i * shape2 * shape3) + i3;
                        data2[i4] = data2[i4] + data3[i3];
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    public static final MTensor concatenate(MTensor[] tensors) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            tensors.getClass();
            int shape = tensors[0].getShape(0);
            int shape2 = 0;
            for (MTensor mTensor : tensors) {
                shape2 += mTensor.getShape(1);
            }
            MTensor mTensor2 = new MTensor(new int[]{shape, shape2});
            float[] data2 = mTensor2.getData();
            for (int i = 0; i < shape; i++) {
                int i2 = i * shape2;
                int length = tensors.length;
                for (int i3 = 0; i3 < length; i3++) {
                    float[] data3 = tensors[i3].getData();
                    int shape3 = tensors[i3].getShape(1);
                    System.arraycopy(data3, i * shape3, data2, i2, shape3);
                    i2 += shape3;
                }
            }
            return mTensor2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    public static final MTensor conv1D(MTensor x, MTensor w) {
        MTensor mTensor;
        MTensor mTensor2 = null;
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            x.getClass();
            w.getClass();
            int i = 0;
            int shape = x.getShape(0);
            int shape2 = x.getShape(1);
            int shape3 = x.getShape(2);
            int shape4 = w.getShape(0);
            int i2 = (shape2 - shape4) + 1;
            int shape5 = w.getShape(2);
            MTensor mTensor3 = new MTensor(new int[]{shape, i2, shape5});
            float[] data2 = x.getData();
            float[] data3 = mTensor3.getData();
            float[] data4 = w.getData();
            int i3 = 0;
            while (i3 < shape) {
                int i4 = i;
                while (i4 < shape5) {
                    int i5 = i;
                    while (i5 < i2) {
                        float f = 0.0f;
                        while (i < shape4) {
                            mTensor = mTensor2;
                            for (int i6 = 0; i6 < shape3; i6++) {
                                try {
                                    f = (data2[((i + i5) * shape3) + (shape2 * shape3 * i3) + i6] * data4[(((i * shape3) + i6) * shape5) + i4]) + f;
                                } catch (Throwable th) {
                                    th = th;
                                    CrashShieldHandler.handleThrowable(th, Operator.class);
                                    return mTensor;
                                }
                            }
                            i++;
                            mTensor2 = mTensor;
                        }
                        MTensor mTensor4 = mTensor2;
                        data3[(i5 * shape5) + (i2 * shape5 * i3) + i4] = f;
                        i5++;
                        mTensor2 = mTensor4;
                        i = 0;
                    }
                    i4++;
                    i = 0;
                }
                i3++;
                i = 0;
            }
            return mTensor3;
        } catch (Throwable th2) {
            th = th2;
            mTensor = null;
        }
    }

    public static final MTensor dense(MTensor x, MTensor w, MTensor b) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            x.getClass();
            w.getClass();
            b.getClass();
            int shape = x.getShape(0);
            int shape2 = b.getShape(0);
            MTensor mTensorMul = mul(x, w);
            float[] data2 = b.getData();
            float[] data3 = mTensorMul.getData();
            for (int i = 0; i < shape; i++) {
                for (int i2 = 0; i2 < shape2; i2++) {
                    int i3 = (i * shape2) + i2;
                    data3[i3] = data3[i3] + data2[i2];
                }
            }
            return mTensorMul;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    public static final MTensor embedding(String[] texts, int seqLength, MTensor w) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            texts.getClass();
            w.getClass();
            int length = texts.length;
            int shape = w.getShape(1);
            MTensor mTensor = new MTensor(new int[]{length, seqLength, shape});
            float[] data2 = mTensor.getData();
            float[] data3 = w.getData();
            for (int i = 0; i < length; i++) {
                int[] iArrVectorize = Utils.INSTANCE.vectorize(texts[i], seqLength);
                for (int i2 = 0; i2 < seqLength; i2++) {
                    System.arraycopy(data3, iArrVectorize[i2] * shape, data2, (shape * i2) + (shape * seqLength * i), shape);
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    public static final void flatten(MTensor x, int startDim) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            x.getClass();
            if (startDim >= x.getShapeSize()) {
                return;
            }
            int shapeSize = x.getShapeSize();
            int shape = 1;
            for (int i = startDim; i < shapeSize; i++) {
                shape *= x.getShape(i);
            }
            int[] iArr = new int[startDim + 1];
            for (int i2 = 0; i2 < startDim; i2++) {
                iArr[i2] = x.getShape(i2);
            }
            iArr[startDim] = shape;
            x.reshape(iArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    public static final MTensor maxPool1D(MTensor x, int poolSize) {
        MTensor mTensor;
        MTensor mTensor2 = null;
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            x.getClass();
            int i = 0;
            int shape = x.getShape(0);
            int shape2 = x.getShape(1);
            int shape3 = x.getShape(2);
            int i2 = (shape2 - poolSize) + 1;
            MTensor mTensor3 = new MTensor(new int[]{shape, i2, shape3});
            float[] data2 = x.getData();
            float[] data3 = mTensor3.getData();
            int i3 = 0;
            while (i3 < shape) {
                int i4 = i;
                while (i4 < shape3) {
                    int i5 = i;
                    while (i5 < i2) {
                        int i6 = i5 * shape3;
                        int i7 = (i3 * i2 * shape3) + i6 + i4;
                        int i8 = (i3 * shape2 * shape3) + i6 + i4;
                        data3[i7] = Float.MIN_VALUE;
                        int i9 = i;
                        while (i9 < poolSize) {
                            mTensor = mTensor2;
                            try {
                                data3[i7] = Math.max(data3[i7], data2[(i9 * shape3) + i8]);
                                i9++;
                                mTensor2 = mTensor;
                            } catch (Throwable th) {
                                th = th;
                                CrashShieldHandler.handleThrowable(th, Operator.class);
                                return mTensor;
                            }
                        }
                        i5++;
                        i = 0;
                    }
                    i4++;
                    i = 0;
                }
                i3++;
                i = 0;
            }
            return mTensor3;
        } catch (Throwable th2) {
            th = th2;
            mTensor = mTensor2;
        }
    }

    public static final MTensor mul(MTensor x, MTensor w) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            x.getClass();
            w.getClass();
            int shape = x.getShape(0);
            int shape2 = w.getShape(0);
            int shape3 = w.getShape(1);
            MTensor mTensor = new MTensor(new int[]{shape, shape3});
            float[] data2 = x.getData();
            float[] data3 = w.getData();
            float[] data4 = mTensor.getData();
            for (int i = 0; i < shape; i++) {
                for (int i2 = 0; i2 < shape3; i2++) {
                    int i3 = (i * shape3) + i2;
                    data4[i3] = 0.0f;
                    for (int i4 = 0; i4 < shape2; i4++) {
                        data4[i3] = (data2[(i * shape2) + i4] * data3[(i4 * shape3) + i2]) + data4[i3];
                    }
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    public static final void relu(MTensor x) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            x.getClass();
            float[] data2 = x.getData();
            int length = data2.length;
            for (int i = 0; i < length; i++) {
                if (data2[i] < 0.0f) {
                    data2[i] = 0.0f;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    public static final void softmax(MTensor x) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            x.getClass();
            int shape = x.getShape(0);
            int shape2 = x.getShape(1);
            float[] data2 = x.getData();
            for (int i = 0; i < shape; i++) {
                int i2 = i * shape2;
                int i3 = i2 + shape2;
                float f = Float.MIN_VALUE;
                for (int i4 = i2; i4 < i3; i4++) {
                    float f2 = data2[i4];
                    if (f2 > f) {
                        f = f2;
                    }
                }
                float f3 = 0.0f;
                for (int i5 = i2; i5 < i3; i5++) {
                    float fExp = (float) Math.exp(data2[i5] - f);
                    data2[i5] = fExp;
                    f3 += fExp;
                }
                while (i2 < i3) {
                    data2[i2] = data2[i2] / f3;
                    i2++;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    public static final MTensor transpose2D(MTensor x) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            x.getClass();
            int shape = x.getShape(0);
            int shape2 = x.getShape(1);
            MTensor mTensor = new MTensor(new int[]{shape2, shape});
            float[] data2 = x.getData();
            float[] data3 = mTensor.getData();
            for (int i = 0; i < shape; i++) {
                for (int i2 = 0; i2 < shape2; i2++) {
                    data3[(i2 * shape) + i] = data2[(i * shape2) + i2];
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    public static final MTensor transpose3D(MTensor x) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            x.getClass();
            int shape = x.getShape(0);
            int shape2 = x.getShape(1);
            int shape3 = x.getShape(2);
            MTensor mTensor = new MTensor(new int[]{shape3, shape2, shape});
            float[] data2 = x.getData();
            float[] data3 = mTensor.getData();
            for (int i = 0; i < shape; i++) {
                for (int i2 = 0; i2 < shape2; i2++) {
                    for (int i3 = 0; i3 < shape3; i3++) {
                        data3[(i2 * shape) + (i3 * shape * shape2) + i] = data2[(i2 * shape3) + (i * shape2 * shape3) + i3];
                    }
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }
}
