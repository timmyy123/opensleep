package com.urbandroid.sleep.captcha.maze;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.captcha.AbstractCaptchaActivity;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.ResourceUtil;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001;B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0014J\b\u0010\u001f\u001a\u00020\u001bH\u0014J(\u0010 \u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0014H\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010%\u001a\u00020\u001bH\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0002J2\u0010)\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010\rH\u0002J*\u0010/\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00162\u0006\u00100\u001a\u0002012\b\u0010.\u001a\u0004\u0018\u00010\rH\u0002J \u00102\u001a\u0002012\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J\u0010\u00103\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u00104\u001a\u00020\u001bJ\u0018\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0014H\u0016J\u0018\u00108\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u00142\u0006\u00109\u001a\u00020:H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0018\u00010\u000bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/urbandroid/sleep/captcha/maze/MazeCaptcha;", "Lcom/urbandroid/sleep/captcha/AbstractCaptchaActivity;", "Landroid/view/SurfaceHolder$Callback;", "Landroid/hardware/SensorListener;", "<init>", "()V", "surface", "Landroid/view/SurfaceView;", "holder", "Landroid/view/SurfaceHolder;", "gameLoop", "Lcom/urbandroid/sleep/captcha/maze/MazeCaptcha$GameLoop;", "ballPaint", "Landroid/graphics/Paint;", "linePaint", "sensorMgr", "Landroid/hardware/SensorManager;", "lastSensorUpdate", "", "wallThink", "", "ball", "Landroid/graphics/Bitmap;", "goal", DeviceRequestsHelper.DEVICE_INFO_MODEL, "Lcom/urbandroid/sleep/captcha/maze/BallModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "surfaceChanged", "format", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "surfaceCreated", "draw", "doDraw", "c", "Landroid/graphics/Canvas;", "drawBitmapCenter", "b", "x", "", "y", "p", "drawBitmapRec", "r", "Landroid/graphics/RectF;", "getBitmapRect", "surfaceDestroyed", "solve", "onAccuracyChanged", "sensor", "accuracy", "onSensorChanged", "values", "", "GameLoop", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MazeCaptcha extends AbstractCaptchaActivity implements SurfaceHolder.Callback, SensorListener {
    private Bitmap ball;
    private final Paint ballPaint;
    private GameLoop gameLoop;
    private Bitmap goal;
    private SurfaceHolder holder;
    private Paint linePaint;
    private BallModel model;
    private SensorManager sensorMgr;
    private SurfaceView surface;
    private long lastSensorUpdate = -1;
    private int wallThink = 5;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/captcha/maze/MazeCaptcha$GameLoop;", "Ljava/lang/Thread;", "<init>", "(Lcom/urbandroid/sleep/captcha/maze/MazeCaptcha;)V", "running", "", "run", "", "safeStop", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class GameLoop extends Thread {
        private volatile boolean running = true;

        public GameLoop() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.running) {
                try {
                    TimeUnit.MILLISECONDS.sleep(5L);
                    MazeCaptcha.this.draw();
                    BallModel ballModel = MazeCaptcha.this.model;
                    ballModel.getClass();
                    ballModel.updatePhysics();
                } catch (InterruptedException unused) {
                    this.running = false;
                }
            }
        }

        public final void safeStop() {
            this.running = false;
            interrupt();
        }
    }

    public MazeCaptcha() {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, config);
        bitmapCreateBitmap.getClass();
        this.ball = bitmapCreateBitmap;
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(1, 1, config);
        bitmapCreateBitmap2.getClass();
        this.goal = bitmapCreateBitmap2;
        this.model = new BallModel(this);
    }

    private final void doDraw(Canvas c) {
        float f;
        float f2;
        BallModel ballModel;
        int width = c.getWidth();
        int height = c.getHeight();
        c.drawColor(ColorUtil.i(this, R.color.bg_main_dark));
        BallModel ballModel2 = this.model;
        if ((ballModel2 != null ? ballModel2.getGoalRect() : null) == null && (ballModel = this.model) != null) {
            ballModel.setGoalRect(getBitmapRect(this.goal, width / 2.0f, height - r5.getHeight()));
        }
        float f3 = this.wallThink;
        Paint paint = this.linePaint;
        if (paint != null) {
            paint.setStyle(Paint.Style.STROKE);
        }
        float f4 = width;
        float f5 = height;
        Paint paint2 = this.linePaint;
        paint2.getClass();
        c.drawRoundRect(f3, f3, f4 - f3, f5 - f3, f3, f3, paint2);
        Paint paint3 = this.linePaint;
        if (paint3 != null) {
            paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        RectF goalRect = this.model.getGoalRect();
        if (goalRect != null) {
            drawBitmapRec(c, this.goal, goalRect, this.ballPaint);
        }
        synchronized (this.model.LOCK) {
            BallModel ballModel3 = this.model;
            f = ballModel3.ballPixelX;
            f2 = ballModel3.ballPixelY;
            Unit unit = Unit.INSTANCE;
        }
        drawBitmapCenter(c, this.ball, f, f2, this.ballPaint);
        if (this.model.getWalls().size() == 0) {
            int difficulty = getCaptchaSupport().getDifficulty();
            float f6 = f4 / 3.0f;
            float f7 = f6 * 2.0f;
            float f8 = f5 / 2.0f;
            int height2 = this.ball.getHeight() * 2;
            if (difficulty > 1) {
                BallModel ballModel4 = this.model;
                float f9 = height2;
                int i = this.wallThink;
                ballModel4.addWall(new RectF(f3, (f8 - f9) - i, f7, (i + f8) - f9));
            }
            if (difficulty > 2) {
                BallModel ballModel5 = this.model;
                int i2 = this.wallThink;
                ballModel5.addWall(new RectF(f6 - f3, f8 - i2, f4, i2 + f8));
            }
            if (difficulty > 3) {
                BallModel ballModel6 = this.model;
                float f10 = height2;
                int i3 = this.wallThink;
                ballModel6.addWall(new RectF(f3, (f8 + f10) - i3, f7, f8 + i3 + f10));
            }
        }
        for (RectF rectF : this.model.getWalls()) {
            Paint paint4 = this.linePaint;
            paint4.getClass();
            c.drawRoundRect(rectF, f3, f3, paint4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void draw() {
        Canvas canvasLockCanvas = null;
        try {
            SurfaceHolder surfaceHolder = this.holder;
            surfaceHolder.getClass();
            canvasLockCanvas = surfaceHolder.lockCanvas();
            if (canvasLockCanvas != null) {
                doDraw(canvasLockCanvas);
            }
            if (canvasLockCanvas != null) {
                try {
                    SurfaceHolder surfaceHolder2 = this.holder;
                    surfaceHolder2.getClass();
                    surfaceHolder2.unlockCanvasAndPost(canvasLockCanvas);
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
            }
        } catch (Throwable th) {
            if (canvasLockCanvas != null) {
                try {
                    SurfaceHolder surfaceHolder3 = this.holder;
                    surfaceHolder3.getClass();
                    surfaceHolder3.unlockCanvasAndPost(canvasLockCanvas);
                } catch (Exception e2) {
                    Logger.logSevere(e2);
                }
            }
            throw th;
        }
    }

    private final void drawBitmapCenter(Canvas c, Bitmap b, float x, float y, Paint p) {
        c.drawBitmap(b, x - (b.getWidth() / 2.0f), y - (b.getHeight() / 2.0f), p);
    }

    private final void drawBitmapRec(Canvas c, Bitmap b, RectF r, Paint p) {
        c.drawBitmap(b, (Rect) null, r, p);
    }

    private final RectF getBitmapRect(Bitmap b, float x, float y) {
        return new RectF(x - (b.getWidth() / 2.0f), y - (b.getHeight() / 2.0f), (b.getWidth() / 2.0f) + x, (b.getHeight() / 2.0f) + y);
    }

    @Override // android.hardware.SensorListener
    public void onAccuracyChanged(int sensor, int accuracy) {
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.captcha_maze);
        Bitmap bitmap = ResourceUtil.getBitmap(this, R.drawable.captcha_maze_ball);
        bitmap.getClass();
        this.ball = bitmap;
        Bitmap bitmap2 = ResourceUtil.getBitmap(this, R.drawable.captcha_maze_goal);
        bitmap2.getClass();
        this.goal = bitmap2;
        this.model.setBallRadius(this.ball.getWidth() / 2);
        this.wallThink = ActivityUtils.getDip(this, 4);
        View viewFindViewById = findViewById(R.id.bouncing_ball_surface);
        viewFindViewById.getClass();
        SurfaceView surfaceView = (SurfaceView) viewFindViewById;
        this.surface = surfaceView;
        surfaceView.getClass();
        this.holder = surfaceView.getHolder();
        SurfaceView surfaceView2 = this.surface;
        surfaceView2.getClass();
        surfaceView2.getHolder().addCallback(this);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(ActivityUtils.getDip(this, 4));
        paint.setColor(ColorUtil.i(this, R.color.tint_background_light_1));
        paint.setAntiAlias(true);
        this.linePaint = paint;
        setTitle(R.string.maze_captcha_summary);
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        SensorManager sensorManager = this.sensorMgr;
        sensorManager.getClass();
        sensorManager.unregisterListener(this, 2);
        this.sensorMgr = null;
        BallModel ballModel = this.model;
        ballModel.getClass();
        ballModel.setAccel(0.0f, 0.0f);
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Object systemService = getSystemService("sensor");
        systemService.getClass();
        SensorManager sensorManager = (SensorManager) systemService;
        this.sensorMgr = sensorManager;
        sensorManager.getClass();
        if (!sensorManager.registerListener(this, 2, 1)) {
            SensorManager sensorManager2 = this.sensorMgr;
            sensorManager2.getClass();
            sensorManager2.unregisterListener(this, 2);
        }
        Object systemService2 = getSystemService("vibrator");
        systemService2.getClass();
        BallModel ballModel = this.model;
        ballModel.getClass();
        ballModel.setVibrator((Vibrator) systemService2);
    }

    @Override // android.hardware.SensorListener
    public void onSensorChanged(int sensor, float[] values) {
        values.getClass();
        if (sensor == 2) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.lastSensorUpdate;
            if (j == -1 || jCurrentTimeMillis - j > 50) {
                this.lastSensorUpdate = jCurrentTimeMillis;
                BallModel ballModel = this.model;
                ballModel.getClass();
                ballModel.setAccel(values[0], values[1]);
            }
        }
    }

    public final void solve() {
        solved();
        finish();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        holder.getClass();
        BallModel ballModel = this.model;
        ballModel.getClass();
        ballModel.setSize(width, height);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        holder.getClass();
        GameLoop gameLoop = new GameLoop();
        this.gameLoop = gameLoop;
        gameLoop.start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        holder.getClass();
        try {
            BallModel ballModel = this.model;
            ballModel.getClass();
            ballModel.setSize(0, 0);
            GameLoop gameLoop = this.gameLoop;
            gameLoop.getClass();
            gameLoop.safeStop();
        } finally {
            this.gameLoop = null;
        }
    }
}
