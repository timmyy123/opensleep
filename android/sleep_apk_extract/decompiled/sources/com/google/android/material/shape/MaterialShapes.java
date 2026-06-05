package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.graphics.shapes.CornerRounding;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.graphics.shapes.RoundedPolygonKt;
import androidx.graphics.shapes.ShapesKt;
import androidx.graphics.shapes.Shapes_androidKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MaterialShapes {
    private static final CornerRounding CORNER_ROUND_15 = new CornerRounding(0.15f, 0.0f);
    private static final CornerRounding CORNER_ROUND_20 = new CornerRounding(0.2f, 0.0f);
    private static final CornerRounding CORNER_ROUND_30 = new CornerRounding(0.3f, 0.0f);
    private static final CornerRounding CORNER_ROUND_50 = new CornerRounding(0.5f, 0.0f);
    private static final CornerRounding CORNER_ROUND_100 = new CornerRounding(1.0f, 0.0f);
    public static final RoundedPolygon CIRCLE = normalize(getCircle(), true);
    public static final RoundedPolygon SQUARE = normalize(getSquare(), true);
    public static final RoundedPolygon SLANTED_SQUARE = normalize(getSlantedSquare(), true);
    public static final RoundedPolygon ARCH = normalize(getArch(), true);
    public static final RoundedPolygon FAN = normalize(getFan(), true);
    public static final RoundedPolygon ARROW = normalize(getArrow(), true);
    public static final RoundedPolygon SEMI_CIRCLE = normalize(getSemiCircle(), true);
    public static final RoundedPolygon OVAL = normalize(getOval(-45.0f), true);
    public static final RoundedPolygon PILL = normalize(getPill(), true);
    public static final RoundedPolygon TRIANGLE = normalize(getTriangle(-90.0f), true);
    public static final RoundedPolygon DIAMOND = normalize(getDiamond(), true);
    public static final RoundedPolygon CLAM_SHELL = normalize(getClamShell(), true);
    public static final RoundedPolygon PENTAGON = normalize(getPentagon(), true);
    public static final RoundedPolygon GEM = normalize(getGem(-90.0f), true);
    public static final RoundedPolygon SUNNY = normalize(getSunny(), true);
    public static final RoundedPolygon VERY_SUNNY = normalize(getVerySunny(), true);
    public static final RoundedPolygon COOKIE_4 = normalize(getCookie4(), true);
    public static final RoundedPolygon COOKIE_6 = normalize(getCookie6(), true);
    public static final RoundedPolygon COOKIE_7 = normalize(getCookie7(), true);
    public static final RoundedPolygon COOKIE_9 = normalize(getCookie9(), true);
    public static final RoundedPolygon COOKIE_12 = normalize(getCookie12(), true);
    public static final RoundedPolygon GHOSTISH = normalize(getGhostish(), true);
    public static final RoundedPolygon CLOVER_4 = normalize(getClover4(), true);
    public static final RoundedPolygon CLOVER_8 = normalize(getClover8(), true);
    public static final RoundedPolygon BURST = normalize(getBurst(), true);
    public static final RoundedPolygon SOFT_BURST = normalize(getSoftBurst(), true);
    public static final RoundedPolygon BOOM = normalize(getBoom(), true);
    public static final RoundedPolygon SOFT_BOOM = normalize(getSoftBoom(), true);
    public static final RoundedPolygon FLOWER = normalize(getFlower(), true);
    public static final RoundedPolygon PUFFY = normalize(getPuffy(), true);
    public static final RoundedPolygon PUFFY_DIAMOND = normalize(getPuffyDiamond(), true);
    public static final RoundedPolygon PIXEL_CIRCLE = normalize(getPixelCircle(), true);
    public static final RoundedPolygon PIXEL_TRIANGLE = normalize(getPixelTriangle(), true);
    public static final RoundedPolygon BUN = normalize(getBun(), true);
    public static final RoundedPolygon HEART = normalize(getHeart(), true);

    public static Matrix createRotationMatrix(float f) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f);
        return matrix;
    }

    public static Matrix createScaleMatrix(float f, float f2) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2);
        return matrix;
    }

    private static RoundedPolygon customPolygon(List<VertexAndRounding> list, int i, float f, float f2, boolean z) {
        ArrayList arrayList = new ArrayList();
        repeatAroundCenter(list, arrayList, i, f, f2, z);
        return RoundedPolygonKt.RoundedPolygon(toVerticesXyArray(arrayList), CornerRounding.Unrounded, toRoundingsList(arrayList), f, f2);
    }

    private static RoundedPolygon getArch() {
        CornerRounding cornerRounding = CornerRounding.Unrounded;
        CornerRounding cornerRounding2 = CORNER_ROUND_100;
        CornerRounding cornerRounding3 = CORNER_ROUND_20;
        return Shapes_androidKt.transformed(RoundedPolygonKt.RoundedPolygon(4, 1.0f, 0.0f, 0.0f, cornerRounding, Arrays.asList(cornerRounding2, cornerRounding2, cornerRounding3, cornerRounding3)), createRotationMatrix(-135.0f));
    }

    private static RoundedPolygon getArrow() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.892f), new CornerRounding(0.313f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(-0.216f, 1.05f), new CornerRounding(0.207f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.499f, -0.16f), new CornerRounding(0.215f, 1.0f)));
        arrayList.add(new VertexAndRounding(new PointF(1.225f, 1.06f), new CornerRounding(0.211f, 0.0f)));
        return customPolygon(arrayList, 1, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon getBoom() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.457f, 0.296f), new CornerRounding(0.007f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.5f, -0.051f), new CornerRounding(0.007f, 0.0f)));
        return customPolygon(arrayList, 15, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon getBun() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.796f, 0.5f)));
        PointF pointF = new PointF(0.853f, 0.518f);
        CornerRounding cornerRounding = CORNER_ROUND_100;
        arrayList.add(new VertexAndRounding(pointF, cornerRounding));
        arrayList.add(new VertexAndRounding(new PointF(0.992f, 0.631f), cornerRounding));
        arrayList.add(new VertexAndRounding(new PointF(0.968f, 1.0f), cornerRounding));
        return customPolygon(arrayList, 2, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon getBurst() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.5f, -0.006f), new CornerRounding(0.006f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.592f, 0.158f), new CornerRounding(0.006f, 0.0f)));
        return customPolygon(arrayList, 12, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon getCircle() {
        return ShapesKt.circle(RoundedPolygon.INSTANCE, 10);
    }

    private static RoundedPolygon getClamShell() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.171f, 0.841f), new CornerRounding(0.159f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(-0.02f, 0.5f), new CornerRounding(0.14f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.17f, 0.159f), new CornerRounding(0.159f, 0.0f)));
        return customPolygon(arrayList, 2, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon getClover4() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.074f)));
        arrayList.add(new VertexAndRounding(new PointF(0.725f, -0.099f), new CornerRounding(0.476f, 0.0f)));
        return customPolygon(arrayList, 4, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon getClover8() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.036f)));
        arrayList.add(new VertexAndRounding(new PointF(0.758f, -0.101f), new CornerRounding(0.209f, 0.0f)));
        return customPolygon(arrayList, 8, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon getCookie12() {
        return Shapes_androidKt.transformed(ShapesKt.star(RoundedPolygon.INSTANCE, 12, 1.0f, 0.8f, CORNER_ROUND_50), createRotationMatrix(-90.0f));
    }

    private static RoundedPolygon getCookie4() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(1.237f, 1.236f), new CornerRounding(0.258f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.918f), new CornerRounding(0.233f, 0.0f)));
        return customPolygon(arrayList, 4, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon getCookie6() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.723f, 0.884f), new CornerRounding(0.394f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 1.099f), new CornerRounding(0.398f, 0.0f)));
        return customPolygon(arrayList, 6, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon getCookie7() {
        return Shapes_androidKt.transformed(ShapesKt.star(RoundedPolygon.INSTANCE, 7, 1.0f, 0.75f, CORNER_ROUND_50), createRotationMatrix(-90.0f));
    }

    private static RoundedPolygon getCookie9() {
        return Shapes_androidKt.transformed(ShapesKt.star(RoundedPolygon.INSTANCE, 9, 1.0f, 0.8f, CORNER_ROUND_50), createRotationMatrix(-90.0f));
    }

    private static RoundedPolygon getDiamond() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 1.096f), new CornerRounding(0.151f, 0.524f)));
        arrayList.add(new VertexAndRounding(new PointF(0.04f, 0.5f), new CornerRounding(0.159f, 0.0f)));
        return customPolygon(arrayList, 2, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon getFan() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(1.0f, 1.0f), new CornerRounding(0.148f, 0.417f)));
        arrayList.add(new VertexAndRounding(new PointF(0.0f, 1.0f), new CornerRounding(0.151f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.0f, 0.0f), new CornerRounding(0.148f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.978f, 0.02f), new CornerRounding(0.803f, 0.0f)));
        return customPolygon(arrayList, 1, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon getFlower() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.37f, 0.187f)));
        arrayList.add(new VertexAndRounding(new PointF(0.416f, 0.049f), new CornerRounding(0.381f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.479f, 0.0f), new CornerRounding(0.095f, 0.0f)));
        return customPolygon(arrayList, 8, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon getGem() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.499f, 1.023f), new CornerRounding(0.241f, 0.778f)));
        arrayList.add(new VertexAndRounding(new PointF(-0.005f, 0.792f), new CornerRounding(0.208f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.073f, 0.258f), new CornerRounding(0.228f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.433f, -0.0f), new CornerRounding(0.491f, 0.0f)));
        return customPolygon(arrayList, 1, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon getGhostish() {
        ArrayList arrayList = new ArrayList();
        PointF pointF = new PointF(0.5f, 0.0f);
        CornerRounding cornerRounding = CORNER_ROUND_100;
        arrayList.add(new VertexAndRounding(pointF, cornerRounding));
        arrayList.add(new VertexAndRounding(new PointF(1.0f, 0.0f), cornerRounding));
        arrayList.add(new VertexAndRounding(new PointF(1.0f, 1.14f), new CornerRounding(0.254f, 0.106f)));
        arrayList.add(new VertexAndRounding(new PointF(0.575f, 0.906f), new CornerRounding(0.253f, 0.0f)));
        return customPolygon(arrayList, 1, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon getHeart() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.268f), new CornerRounding(0.016f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.792f, -0.066f), new CornerRounding(0.958f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(1.064f, 0.276f), CORNER_ROUND_100));
        arrayList.add(new VertexAndRounding(new PointF(0.501f, 0.946f), new CornerRounding(0.129f, 0.0f)));
        return customPolygon(arrayList, 1, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon getOval() {
        return Shapes_androidKt.transformed(ShapesKt.circle(RoundedPolygon.INSTANCE), createScaleMatrix(1.0f, 0.64f));
    }

    private static RoundedPolygon getPentagon() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.5f, -0.009f), new CornerRounding(0.172f, 0.0f)));
        return customPolygon(arrayList, 5, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon getPill() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.961f, 0.039f), new CornerRounding(0.426f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(1.001f, 0.428f)));
        arrayList.add(new VertexAndRounding(new PointF(1.0f, 0.609f), CORNER_ROUND_100));
        return customPolygon(arrayList, 2, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon getPixelCircle() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.704f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.704f, 0.065f)));
        arrayList.add(new VertexAndRounding(new PointF(0.843f, 0.065f)));
        arrayList.add(new VertexAndRounding(new PointF(0.843f, 0.148f)));
        arrayList.add(new VertexAndRounding(new PointF(0.926f, 0.148f)));
        arrayList.add(new VertexAndRounding(new PointF(0.926f, 0.296f)));
        arrayList.add(new VertexAndRounding(new PointF(1.0f, 0.296f)));
        return customPolygon(arrayList, 2, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon getPixelTriangle() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.11f, 0.5f)));
        arrayList.add(new VertexAndRounding(new PointF(0.113f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.287f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.287f, 0.087f)));
        arrayList.add(new VertexAndRounding(new PointF(0.421f, 0.087f)));
        arrayList.add(new VertexAndRounding(new PointF(0.421f, 0.17f)));
        arrayList.add(new VertexAndRounding(new PointF(0.56f, 0.17f)));
        arrayList.add(new VertexAndRounding(new PointF(0.56f, 0.265f)));
        arrayList.add(new VertexAndRounding(new PointF(0.674f, 0.265f)));
        arrayList.add(new VertexAndRounding(new PointF(0.675f, 0.344f)));
        arrayList.add(new VertexAndRounding(new PointF(0.789f, 0.344f)));
        arrayList.add(new VertexAndRounding(new PointF(0.789f, 0.439f)));
        arrayList.add(new VertexAndRounding(new PointF(0.888f, 0.439f)));
        return customPolygon(arrayList, 1, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon getPuffy() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.053f)));
        arrayList.add(new VertexAndRounding(new PointF(0.545f, -0.04f), new CornerRounding(0.405f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.67f, -0.035f), new CornerRounding(0.426f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.717f, 0.066f), new CornerRounding(0.574f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.722f, 0.128f)));
        arrayList.add(new VertexAndRounding(new PointF(0.777f, 0.002f), new CornerRounding(0.36f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.914f, 0.149f), new CornerRounding(0.66f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.926f, 0.289f), new CornerRounding(0.66f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.881f, 0.346f)));
        arrayList.add(new VertexAndRounding(new PointF(0.94f, 0.344f), new CornerRounding(0.126f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(1.003f, 0.437f), new CornerRounding(0.255f, 0.0f)));
        return Shapes_androidKt.transformed(customPolygon(arrayList, 2, 0.5f, 0.5f, true), createScaleMatrix(1.0f, 0.742f));
    }

    private static RoundedPolygon getPuffyDiamond() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.87f, 0.13f), new CornerRounding(0.146f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.818f, 0.357f)));
        arrayList.add(new VertexAndRounding(new PointF(1.0f, 0.332f), new CornerRounding(0.853f, 0.0f)));
        return customPolygon(arrayList, 4, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon getSemiCircle() {
        RoundedPolygon.Companion companion = RoundedPolygon.INSTANCE;
        CornerRounding cornerRounding = CornerRounding.Unrounded;
        CornerRounding cornerRounding2 = CORNER_ROUND_20;
        CornerRounding cornerRounding3 = CORNER_ROUND_100;
        return ShapesKt.rectangle(companion, 1.6f, 1.0f, cornerRounding, Arrays.asList(cornerRounding2, cornerRounding2, cornerRounding3, cornerRounding3), 0.0f, 0.0f);
    }

    private static RoundedPolygon getSlantedSquare() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.926f, 0.97f), new CornerRounding(0.189f, 0.811f)));
        arrayList.add(new VertexAndRounding(new PointF(-0.021f, 0.967f), new CornerRounding(0.187f, 0.057f)));
        return customPolygon(arrayList, 2, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon getSoftBoom() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.733f, 0.454f)));
        arrayList.add(new VertexAndRounding(new PointF(0.839f, 0.437f), new CornerRounding(0.532f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.949f, 0.449f), new CornerRounding(0.439f, 1.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.998f, 0.478f), new CornerRounding(0.174f, 0.0f)));
        return customPolygon(arrayList, 16, 0.5f, 0.5f, true);
    }

    private static RoundedPolygon getSoftBurst() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.193f, 0.277f), new CornerRounding(0.053f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.176f, 0.055f), new CornerRounding(0.053f, 0.0f)));
        return customPolygon(arrayList, 10, 0.5f, 0.5f, false);
    }

    private static RoundedPolygon getSquare() {
        return ShapesKt.rectangle(RoundedPolygon.INSTANCE, 1.0f, 1.0f, CORNER_ROUND_30, null, 0.0f, 0.0f);
    }

    private static RoundedPolygon getSunny() {
        return ShapesKt.star(RoundedPolygon.INSTANCE, 8, 1.0f, 0.8f, CORNER_ROUND_15);
    }

    private static RoundedPolygon getTriangle(float f) {
        return Shapes_androidKt.transformed(getTriangle(), createRotationMatrix(f));
    }

    private static RoundedPolygon getVerySunny() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 1.08f), new CornerRounding(0.085f, 0.0f)));
        arrayList.add(new VertexAndRounding(new PointF(0.358f, 0.843f), new CornerRounding(0.085f, 0.0f)));
        return customPolygon(arrayList, 8, 0.5f, 0.5f, false);
    }

    public static RoundedPolygon normalize(RoundedPolygon roundedPolygon, boolean z, RectF rectF) {
        float[] fArr = new float[4];
        if (z) {
            roundedPolygon.calculateMaxBounds(fArr);
        } else {
            roundedPolygon.calculateBounds(fArr);
        }
        RectF rectF2 = new RectF(fArr[0], fArr[1], fArr[2], fArr[3]);
        float fMin = Math.min(rectF.width() / rectF2.width(), rectF.height() / rectF2.height());
        Matrix matrixCreateScaleMatrix = createScaleMatrix(fMin, fMin);
        matrixCreateScaleMatrix.preTranslate(-rectF2.centerX(), -rectF2.centerY());
        matrixCreateScaleMatrix.postTranslate(rectF.centerX(), rectF.centerY());
        return Shapes_androidKt.transformed(roundedPolygon, matrixCreateScaleMatrix);
    }

    private static void repeatAroundCenter(List<VertexAndRounding> list, List<VertexAndRounding> list2, int i, float f, float f2, boolean z) {
        list2.clear();
        toRadial(list, f, f2);
        float f3 = (float) (6.283185307179586d / ((double) i));
        if (z) {
            int i2 = i * 2;
            float f4 = f3 / 2.0f;
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < list.size(); i4++) {
                    boolean z2 = i3 % 2 != 0;
                    int size = z2 ? (list.size() - 1) - i4 : i4;
                    VertexAndRounding vertexAndRounding = list.get(size);
                    if (size > 0 || !z2) {
                        list2.add(new VertexAndRounding(new PointF((i3 * f4) + (z2 ? (list.get(0).vertex.x * 2.0f) + (f4 - vertexAndRounding.vertex.x) : vertexAndRounding.vertex.x), vertexAndRounding.vertex.y), vertexAndRounding.rounding));
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < i; i5++) {
                for (VertexAndRounding vertexAndRounding2 : list) {
                    list2.add(new VertexAndRounding(new PointF((i5 * f3) + vertexAndRounding2.vertex.x, vertexAndRounding2.vertex.y), vertexAndRounding2.rounding));
                }
            }
        }
        toCartesian(list2, f, f2);
    }

    private static void toCartesian(List<VertexAndRounding> list, float f, float f2) {
        Iterator<VertexAndRounding> it = list.iterator();
        while (it.hasNext()) {
            it.next().toCartesian(f, f2);
        }
    }

    private static void toRadial(List<VertexAndRounding> list, float f, float f2) {
        Iterator<VertexAndRounding> it = list.iterator();
        while (it.hasNext()) {
            it.next().toRadial(f, f2);
        }
    }

    private static List<CornerRounding> toRoundingsList(List<VertexAndRounding> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(list.get(i).rounding);
        }
        return arrayList;
    }

    private static float[] toVerticesXyArray(List<VertexAndRounding> list) {
        float[] fArr = new float[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            int i2 = i * 2;
            fArr[i2] = list.get(i).vertex.x;
            fArr[i2 + 1] = list.get(i).vertex.y;
        }
        return fArr;
    }

    public static class VertexAndRounding {
        private CornerRounding rounding;
        private PointF vertex;

        private VertexAndRounding(PointF pointF, CornerRounding cornerRounding) {
            this.vertex = pointF;
            this.rounding = cornerRounding;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void toCartesian(float f, float f2) {
            float fCos = (float) ((Math.cos(r0.x) * ((double) this.vertex.y)) + ((double) f));
            float fSin = (float) ((Math.sin(r0.x) * ((double) this.vertex.y)) + ((double) f2));
            PointF pointF = this.vertex;
            pointF.x = fCos;
            pointF.y = fSin;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void toRadial(float f, float f2) {
            this.vertex.offset(-f, -f2);
            PointF pointF = this.vertex;
            float fAtan2 = (float) Math.atan2(pointF.y, pointF.x);
            PointF pointF2 = this.vertex;
            float fHypot = (float) Math.hypot(pointF2.x, pointF2.y);
            PointF pointF3 = this.vertex;
            pointF3.x = fAtan2;
            pointF3.y = fHypot;
        }

        private VertexAndRounding(PointF pointF) {
            this(pointF, CornerRounding.Unrounded);
        }
    }

    private static RoundedPolygon getTriangle() {
        return RoundedPolygonKt.RoundedPolygon(3, 1.0f, 0.0f, 0.0f, CORNER_ROUND_20);
    }

    private static RoundedPolygon getOval(float f) {
        return Shapes_androidKt.transformed(getOval(), createRotationMatrix(f));
    }

    public static RoundedPolygon normalize(RoundedPolygon roundedPolygon, boolean z) {
        return normalize(roundedPolygon, z, new RectF(0.0f, 0.0f, 1.0f, 1.0f));
    }

    private static RoundedPolygon getGem(float f) {
        return Shapes_androidKt.transformed(getGem(), createRotationMatrix(f));
    }
}
