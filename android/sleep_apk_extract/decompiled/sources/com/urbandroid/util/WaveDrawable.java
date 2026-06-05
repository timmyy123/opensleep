package com.urbandroid.util;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class WaveDrawable extends Drawable implements Runnable, Animatable {
    static final float[] sSinTable = {0.0f, 0.024541229f, 0.049067676f, 0.07356457f, 0.09801714f, 0.12241068f, 0.14673047f, 0.17096189f, 0.19509032f, 0.21910124f, 0.24298018f, 0.26671275f, 0.29028466f, 0.31368175f, 0.33688986f, 0.35989505f, 0.38268343f, 0.4052413f, 0.42755508f, 0.44961134f, 0.47139674f, 0.4928982f, 0.51410276f, 0.53499764f, 0.55557024f, 0.57580817f, 0.5956993f, 0.6152316f, 0.6343933f, 0.65317285f, 0.671559f, 0.68954057f, 0.70710677f, 0.7242471f, 0.7409511f, 0.7572088f, 0.77301043f, 0.7883464f, 0.8032075f, 0.8175848f, 0.8314696f, 0.8448536f, 0.8577286f, 0.87008697f, 0.8819213f, 0.8932243f, 0.9039893f, 0.9142098f, 0.9238795f, 0.9329928f, 0.94154406f, 0.94952816f, 0.95694035f, 0.96377605f, 0.97003126f, 0.9757021f, 0.98078525f, 0.98527765f, 0.9891765f, 0.99247956f, 0.9951847f, 0.99729043f, 0.99879545f, 0.9996988f, 1.0f, 0.9996988f, 0.99879545f, 0.99729043f, 0.9951847f, 0.99247956f, 0.9891765f, 0.98527765f, 0.98078525f, 0.9757021f, 0.97003126f, 0.96377605f, 0.95694035f, 0.94952816f, 0.94154406f, 0.9329928f, 0.9238795f, 0.9142098f, 0.9039893f, 0.8932243f, 0.8819213f, 0.87008697f, 0.8577286f, 0.8448536f, 0.8314696f, 0.8175848f, 0.8032075f, 0.7883464f, 0.77301043f, 0.7572088f, 0.7409511f, 0.7242471f, 0.70710677f, 0.68954057f, 0.671559f, 0.65317285f, 0.6343933f, 0.6152316f, 0.5956993f, 0.57580817f, 0.55557024f, 0.53499764f, 0.51410276f, 0.4928982f, 0.47139674f, 0.44961134f, 0.42755508f, 0.4052413f, 0.38268343f, 0.35989505f, 0.33688986f, 0.31368175f, 0.29028466f, 0.26671275f, 0.24298018f, 0.21910124f, 0.19509032f, 0.17096189f, 0.14673047f, 0.12241068f, 0.09801714f, 0.07356457f, 0.049067676f, 0.024541229f, 1.2246469E-16f, -0.024541229f, -0.049067676f, -0.07356457f, -0.09801714f, -0.12241068f, -0.14673047f, -0.17096189f, -0.19509032f, -0.21910124f, -0.24298018f, -0.26671275f, -0.29028466f, -0.31368175f, -0.33688986f, -0.35989505f, -0.38268343f, -0.4052413f, -0.42755508f, -0.44961134f, -0.47139674f, -0.4928982f, -0.51410276f, -0.53499764f, -0.55557024f, -0.57580817f, -0.5956993f, -0.6152316f, -0.6343933f, -0.65317285f, -0.671559f, -0.68954057f, -0.70710677f, -0.7242471f, -0.7409511f, -0.7572088f, -0.77301043f, -0.7883464f, -0.8032075f, -0.8175848f, -0.8314696f, -0.8448536f, -0.8577286f, -0.87008697f, -0.8819213f, -0.8932243f, -0.9039893f, -0.9142098f, -0.9238795f, -0.9329928f, -0.94154406f, -0.94952816f, -0.95694035f, -0.96377605f, -0.97003126f, -0.9757021f, -0.98078525f, -0.98527765f, -0.9891765f, -0.99247956f, -0.9951847f, -0.99729043f, -0.99879545f, -0.9996988f, -1.0f, -0.9996988f, -0.99879545f, -0.99729043f, -0.9951847f, -0.99247956f, -0.9891765f, -0.98527765f, -0.98078525f, -0.9757021f, -0.97003126f, -0.96377605f, -0.95694035f, -0.94952816f, -0.94154406f, -0.9329928f, -0.9238795f, -0.9142098f, -0.9039893f, -0.8932243f, -0.8819213f, -0.87008697f, -0.8577286f, -0.8448536f, -0.8314696f, -0.8175848f, -0.8032075f, -0.7883464f, -0.77301043f, -0.7572088f, -0.7409511f, -0.7242471f, -0.70710677f, -0.68954057f, -0.671559f, -0.65317285f, -0.6343933f, -0.6152316f, -0.5956993f, -0.57580817f, -0.55557024f, -0.53499764f, -0.51410276f, -0.4928982f, -0.47139674f, -0.44961134f, -0.42755508f, -0.4052413f, -0.38268343f, -0.35989505f, -0.33688986f, -0.31368175f, -0.29028466f, -0.26671275f, -0.24298018f, -0.21910124f, -0.19509032f, -0.17096189f, -0.14673047f, -0.12241068f, -0.09801714f, -0.07356457f, -0.049067676f, -0.024541229f};
    private boolean mFastMode;
    private long mInterval;
    private final Paint mPaint;
    private boolean mRunning;
    private WaveState mState;

    public WaveDrawable(WaveState waveState) {
        this.mFastMode = true;
        this.mInterval = 60L;
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mState = new WaveState(waveState);
        paint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float clamp(float f, float f2) {
        return f >= f2 ? f - f2 : f;
    }

    private void drawWave(Canvas canvas, Wave wave) {
        this.mPaint.setColor(wave.mColor);
        if (wave.mPath == null) {
            wave.mPath = new Path();
        }
        float[] fArrInitWaveHeightIfNeed = initWaveHeightIfNeed(canvas, wave);
        int width = (canvas.getWidth() / wave.mLoopCount) + 1;
        int iClamp = (int) clamp(wave.mPhase, fArrInitWaveHeightIfNeed.length);
        wave.mPath.moveTo(0.0f, fArrInitWaveHeightIfNeed[iClamp]);
        int i = width;
        int i2 = 1;
        while (i2 <= wave.mLoopCount) {
            iClamp = clamp(iClamp + 1, fArrInitWaveHeightIfNeed.length);
            wave.mPath.lineTo(i, fArrInitWaveHeightIfNeed[iClamp]);
            i2++;
            i += width;
        }
        wave.mPath.lineTo(canvas.getWidth(), canvas.getHeight());
        wave.mPath.lineTo(0.0f, canvas.getHeight());
        wave.mPath.close();
        wave.mPath.setFillType(Path.FillType.WINDING);
        canvas.drawPath(wave.mPath, this.mPaint);
        wave.mPath.reset();
        increasePhase(wave);
    }

    private void drawWaveRough(Canvas canvas, Wave wave) {
        this.mPaint.setColor(wave.mColor);
        float[] fArrInitWaveHeightIfNeed = initWaveHeightIfNeed(canvas, wave);
        int width = (canvas.getWidth() / wave.mLoopCount) + 1;
        int iClamp = (int) clamp(wave.mPhase, fArrInitWaveHeightIfNeed.length);
        int i = 0;
        int i2 = 0;
        while (i <= wave.mLoopCount) {
            i2 += width;
            Canvas canvas2 = canvas;
            canvas2.drawRect(i2, fArrInitWaveHeightIfNeed[iClamp], i2, canvas.getHeight(), this.mPaint);
            iClamp = clamp(iClamp + 1, fArrInitWaveHeightIfNeed.length);
            i++;
            canvas = canvas2;
        }
        increasePhase(wave);
    }

    private void increasePhase(Wave wave) {
        wave.mPhase += wave.mShiftSpeed;
        wave.mPhase = clamp(wave.mPhase, wave.mHeights.length);
    }

    private float[] initWaveHeightIfNeed(Canvas canvas, Wave wave) {
        if (wave.mHeights == null || canvas.getHeight() != wave.mCanvasHeight) {
            wave.mHeights = new float[sSinTable.length];
            float height = (1.0f - wave.mWaterLevel) * canvas.getHeight();
            int i = 0;
            while (true) {
                float[] fArr = sSinTable;
                if (i >= fArr.length) {
                    break;
                }
                wave.mHeights[i] = (wave.mAmplitude * fArr[i]) + height;
                i++;
            }
            wave.mCanvasHeight = canvas.getHeight();
        }
        return wave.mHeights;
    }

    private void nextFrame() {
        unscheduleSelf(this);
        scheduleSelf(this, SystemClock.uptimeMillis() + this.mInterval);
    }

    public void addWave(int i, int i2, int i3, float f, float f2, float f3) {
        this.mState.mWaves.add(new Wave(i, i2, i3, f, f2, f3));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        for (Wave wave : this.mState.mWaves) {
            if (this.mFastMode) {
                drawWaveRough(canvas, wave);
            } else {
                drawWave(canvas, wave);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.mState.mChangingConfigurations | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        this.mState.mChangingConfigurations = getChangingConfigurations();
        return this.mState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Iterator<Wave> it = this.mState.mWaves.iterator();
        int i = -2;
        while (it.hasNext()) {
            int i2 = it.next().mColor >>> 24;
            if (i2 != 0) {
                if (i2 == 255) {
                    return -1;
                }
                i = -3;
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mRunning;
    }

    @Override // java.lang.Runnable
    public void run() {
        invalidateSelf();
        nextFrame();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setFastMode(boolean z) {
        this.mFastMode = z;
        invalidateSelf();
    }

    public void setInterval(int i) {
        this.mInterval = i;
        unscheduleSelf(this);
        if (isRunning()) {
            nextFrame();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!z) {
            stop();
            return visible;
        }
        if (this.mRunning) {
            start();
            return visible;
        }
        invalidateSelf();
        return visible;
    }

    public void setWaterLevel(int i, float f) {
        Wave wave = this.mState.mWaves.get(i);
        wave.mWaterLevel = f;
        wave.mHeights = null;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            return;
        }
        run();
        this.mRunning = true;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.mRunning = false;
            unscheduleSelf(this);
        }
    }

    private static int clamp(int i, int i2) {
        return i >= i2 ? i - i2 : i;
    }

    public static final class WaveState extends Drawable.ConstantState {
        int mChangingConfigurations;
        List<Wave> mWaves = new ArrayList();

        public WaveState(WaveState waveState) {
            if (waveState != null) {
                Iterator<Wave> it = waveState.mWaves.iterator();
                while (it.hasNext()) {
                    this.mWaves.add(new Wave(it.next()));
                }
                this.mChangingConfigurations = waveState.mChangingConfigurations;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new WaveDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new WaveDrawable(this);
        }
    }

    public WaveDrawable() {
        this(null);
    }

    public static final class Wave {
        private int mAmplitude;
        private int mCanvasHeight;
        private int mColor;
        private float[] mHeights;
        private int mLoopCount;
        private Path mPath;
        private float mPhase;
        private float mShiftSpeed;
        private float mWaterLevel;

        public Wave(int i, float f, int i2, float f2, float f3, float f4) {
            this.mAmplitude = i;
            float[] fArr = WaveDrawable.sSinTable;
            this.mPhase = WaveDrawable.clamp(f, fArr.length);
            this.mColor = i2;
            this.mShiftSpeed = f2;
            this.mWaterLevel = f3;
            this.mLoopCount = ((int) ((fArr.length - 1) * f4)) + 1;
        }

        public Wave(Wave wave) {
            this.mAmplitude = wave.mAmplitude;
            this.mColor = wave.mColor;
            this.mLoopCount = wave.mLoopCount;
            this.mPhase = wave.mPhase;
            this.mShiftSpeed = wave.mShiftSpeed;
            this.mWaterLevel = wave.mWaterLevel;
        }
    }
}
