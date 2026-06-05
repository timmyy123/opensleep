package com.airbnb.lottie.animation.content;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RoundedCornersContent implements ShapeModifierContent, BaseKeyframeAnimation.AnimationListener {
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Float, Float> roundedCorners;
    private ShapeData shapeData;

    public RoundedCornersContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RoundedCorners roundedCorners) {
        this.lottieDrawable = lottieDrawable;
        this.name = roundedCorners.getName();
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation = roundedCorners.getCornerRadius().createAnimation();
        this.roundedCorners = baseKeyframeAnimationCreateAnimation;
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation);
        baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
    }

    private static int floorDiv(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }

    private static int floorMod(int i, int i2) {
        return i - (floorDiv(i, i2) * i2);
    }

    private ShapeData getShapeData(ShapeData shapeData) {
        List<CubicCurveData> curves = shapeData.getCurves();
        boolean zIsClosed = shapeData.isClosed();
        int size = curves.size() - 1;
        int i = 0;
        while (size >= 0) {
            CubicCurveData cubicCurveData = curves.get(size);
            CubicCurveData cubicCurveData2 = curves.get(floorMod(size - 1, curves.size()));
            PointF vertex = (size != 0 || zIsClosed) ? cubicCurveData2.getVertex() : shapeData.getInitialPoint();
            i = (((size != 0 || zIsClosed) ? cubicCurveData2.getControlPoint2() : vertex).equals(vertex) && cubicCurveData.getControlPoint1().equals(vertex) && !(!shapeData.isClosed() && (size == 0 || size == curves.size() - 1))) ? i + 2 : i + 1;
            size--;
        }
        ShapeData shapeData2 = this.shapeData;
        if (shapeData2 == null || shapeData2.getCurves().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new CubicCurveData());
            }
            this.shapeData = new ShapeData(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.shapeData.setClosed(zIsClosed);
        return this.shapeData;
    }

    @Override // com.airbnb.lottie.animation.content.ShapeModifierContent
    public void addUpdateListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.roundedCorners.addUpdateListener(animationListener);
    }

    public BaseKeyframeAnimation<Float, Float> getRoundedCorners() {
        return this.roundedCorners;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009e  */
    @Override // com.airbnb.lottie.animation.content.ShapeModifierContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShapeData modifyShape(ShapeData shapeData) {
        boolean z;
        List<CubicCurveData> list;
        ShapeData shapeData2;
        List<CubicCurveData> curves = shapeData.getCurves();
        if (curves.size() > 2) {
            float fFloatValue = this.roundedCorners.getValue().floatValue();
            if (fFloatValue != 0.0f) {
                ShapeData shapeData3 = getShapeData(shapeData);
                shapeData3.setInitialPoint(shapeData.getInitialPoint().x, shapeData.getInitialPoint().y);
                List<CubicCurveData> curves2 = shapeData3.getCurves();
                boolean zIsClosed = shapeData.isClosed();
                int i = 0;
                int i2 = 0;
                while (i < curves.size()) {
                    CubicCurveData cubicCurveData = curves.get(i);
                    CubicCurveData cubicCurveData2 = curves.get(floorMod(i - 1, curves.size()));
                    CubicCurveData cubicCurveData3 = curves.get(floorMod(i - 2, curves.size()));
                    PointF vertex = (i != 0 || zIsClosed) ? cubicCurveData2.getVertex() : shapeData.getInitialPoint();
                    PointF controlPoint2 = (i != 0 || zIsClosed) ? cubicCurveData2.getControlPoint2() : vertex;
                    PointF controlPoint1 = cubicCurveData.getControlPoint1();
                    PointF vertex2 = cubicCurveData3.getVertex();
                    PointF vertex3 = cubicCurveData.getVertex();
                    if (!shapeData.isClosed()) {
                        z = true;
                        if (i != 0 && i != curves.size() - 1) {
                            z = false;
                        }
                    }
                    if (controlPoint2.equals(vertex) && controlPoint1.equals(vertex) && !z) {
                        float f = vertex.x;
                        float f2 = f - vertex2.x;
                        float f3 = vertex.y;
                        float f4 = f3 - vertex2.y;
                        float f5 = vertex3.x - f;
                        float f6 = vertex3.y - f3;
                        list = curves;
                        ShapeData shapeData4 = shapeData3;
                        float fHypot = (float) Math.hypot(f2, f4);
                        float fHypot2 = (float) Math.hypot(f5, f6);
                        float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                        float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                        float f7 = vertex.x;
                        float fM = FileInsert$$ExternalSyntheticOutline0.m(vertex2.x, f7, fMin, f7);
                        float f8 = vertex.y;
                        float fM2 = FileInsert$$ExternalSyntheticOutline0.m(vertex2.y, f8, fMin, f8);
                        float fM3 = FileInsert$$ExternalSyntheticOutline0.m(vertex3.x, f7, fMin2, f7);
                        float fM4 = FileInsert$$ExternalSyntheticOutline0.m(vertex3.y, f8, fMin2, f8);
                        float f9 = fM - ((fM - f7) * 0.5519f);
                        float f10 = fM2 - ((fM2 - f8) * 0.5519f);
                        float f11 = fM3 - ((fM3 - f7) * 0.5519f);
                        float f12 = fM4 - ((fM4 - f8) * 0.5519f);
                        CubicCurveData cubicCurveData4 = curves2.get(floorMod(i2 - 1, curves2.size()));
                        CubicCurveData cubicCurveData5 = curves2.get(i2);
                        cubicCurveData4.setControlPoint2(fM, fM2);
                        cubicCurveData4.setVertex(fM, fM2);
                        shapeData2 = shapeData4;
                        if (i == 0) {
                            shapeData2.setInitialPoint(fM, fM2);
                        }
                        cubicCurveData5.setControlPoint1(f9, f10);
                        CubicCurveData cubicCurveData6 = curves2.get(i2 + 1);
                        cubicCurveData5.setControlPoint2(f11, f12);
                        cubicCurveData5.setVertex(fM3, fM4);
                        cubicCurveData6.setControlPoint1(fM3, fM4);
                        i2 += 2;
                    } else {
                        list = curves;
                        shapeData2 = shapeData3;
                        CubicCurveData cubicCurveData7 = curves2.get(floorMod(i2 - 1, curves2.size()));
                        CubicCurveData cubicCurveData8 = curves2.get(i2);
                        cubicCurveData7.setControlPoint2(cubicCurveData2.getControlPoint2().x, cubicCurveData2.getControlPoint2().y);
                        cubicCurveData7.setVertex(cubicCurveData2.getVertex().x, cubicCurveData2.getVertex().y);
                        cubicCurveData8.setControlPoint1(cubicCurveData.getControlPoint1().x, cubicCurveData.getControlPoint1().y);
                        i2++;
                    }
                    i++;
                    shapeData3 = shapeData2;
                    curves = list;
                }
                return shapeData3;
            }
        }
        return shapeData;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
    }
}
