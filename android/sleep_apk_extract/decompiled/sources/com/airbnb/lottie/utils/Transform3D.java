package com.airbnb.lottie.utils;

import android.graphics.Matrix;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transform3D {
    public static void apply3DRotations(Matrix matrix, float f, float f2, float f3, float f4, float f5) {
        if (f3 != 0.0f) {
            matrix.preRotate(f3);
        }
        if (f2 != 0.0f) {
            applyYRotation(matrix, f5);
        }
        if (f != 0.0f) {
            applyXRotation(matrix, f4);
        }
    }

    public static void applyTransform(Matrix matrix, PointF pointF, PointF pointF2, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        matrix.reset();
        if (pointF2 != null) {
            float f8 = pointF2.x;
            if (f8 != 0.0f || pointF2.y != 0.0f) {
                matrix.preTranslate(f8, pointF2.y);
            }
        }
        if (f5 != 0.0f) {
            matrix.preRotate(f5);
        }
        if (f4 != 0.0f) {
            applyYRotation(matrix, f7);
        }
        if (f3 != 0.0f) {
            applyXRotation(matrix, f6);
        }
        if (f != 1.0f || f2 != 1.0f) {
            matrix.preScale(f, f2);
        }
        if (pointF != null) {
            float f9 = pointF.x;
            if (f9 == 0.0f && pointF.y == 0.0f) {
                return;
            }
            matrix.preTranslate(-f9, -pointF.y);
        }
    }

    private static void applyXRotation(Matrix matrix, float f) {
        matrix.preScale(1.0f, f);
    }

    private static void applyYRotation(Matrix matrix, float f) {
        matrix.preScale(f, 1.0f);
    }
}
