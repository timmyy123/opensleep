package com.urbandroid.sleep.captcha;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.gms.vision.face.Face;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import com.urbandroid.sleep.captcha.camera.GraphicOverlay;

/* JADX INFO: loaded from: classes4.dex */
class SmileGraphic extends GraphicOverlay.Graphic {
    private static final int[] COLOR_CHOICES = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED, -1, Color.YELLOW};
    private static int mCurrentColorIndex = 0;
    private int faceId;
    private Paint mBoxPaint;
    private volatile Face mFace;
    private Paint mFacePositionPaint;
    private Paint mIdPaint;
    private float targetHapiness;

    public SmileGraphic(GraphicOverlay graphicOverlay) {
        super(graphicOverlay);
        this.targetHapiness = 0.6f;
        int i = mCurrentColorIndex + 1;
        int[] iArr = COLOR_CHOICES;
        int length = i % iArr.length;
        mCurrentColorIndex = length;
        int i2 = iArr[length];
        Paint paint = new Paint();
        this.mFacePositionPaint = paint;
        paint.setColor(i2);
        Paint paint2 = new Paint();
        this.mIdPaint = paint2;
        paint2.setColor(i2);
        this.mIdPaint.setTextSize(80.0f);
        Paint paint3 = new Paint();
        this.mBoxPaint = paint3;
        paint3.setColor(i2);
        this.mBoxPaint.setStyle(Paint.Style.STROKE);
        this.mBoxPaint.setStrokeWidth(5.0f);
    }

    @Override // com.urbandroid.sleep.captcha.camera.GraphicOverlay.Graphic
    public void draw(Canvas canvas) {
        Face face = this.mFace;
        if (face == null) {
            return;
        }
        float fTranslateX = translateX((face.getWidth() / 2.0f) + face.getPosition().x);
        float fTranslateY = translateY((face.getHeight() / 2.0f) + face.getPosition().y);
        canvas.drawCircle(fTranslateX, fTranslateY, 10.0f, this.mFacePositionPaint);
        canvas.drawText(Math.round(Math.min(1.0f, Math.max(0.0f, face.getIsSmilingProbability()) / this.targetHapiness) * 100.0f) + "%", fTranslateX - (-50.0f), fTranslateY - 50.0f, this.mIdPaint);
        float fScaleX = scaleX(face.getWidth() / 2.0f);
        float fScaleY = scaleY(face.getHeight() / 2.0f);
        canvas.drawRect(fTranslateX - fScaleX, fTranslateY - fScaleY, fTranslateX + fScaleX, fTranslateY + fScaleY, this.mBoxPaint);
    }

    public void setId(int i) {
        this.faceId = i;
    }

    public void setTargetHapiness(float f) {
        this.targetHapiness = f;
    }

    public void updateFace(Face face) {
        this.mFace = face;
        postInvalidate();
    }
}
