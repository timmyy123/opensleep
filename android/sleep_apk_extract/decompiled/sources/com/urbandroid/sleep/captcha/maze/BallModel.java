package com.urbandroid.sleep.captcha.maze;

import android.graphics.RectF;
import android.os.Vibrator;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 @2\u00020\u0001:\u0001@B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\nR\u0016\u0010+\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b+\u0010%R\u0016\u0010,\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010%R\u0016\u0010-\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\u001fR\u0016\u0010.\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010\u001fR\u0016\u0010/\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010%R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010%R\u0016\u00101\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010%R\u0016\u00102\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010%R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\u0006088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00170=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/urbandroid/sleep/captcha/maze/BallModel;", "", "Lcom/urbandroid/sleep/captcha/maze/MazeCaptcha;", "captcha", "<init>", "(Lcom/urbandroid/sleep/captcha/maze/MazeCaptcha;)V", "Landroid/graphics/RectF;", "wall", "", "addWall", "(Landroid/graphics/RectF;)V", "", "ax", "ay", "setAccel", "(FF)V", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setSize", "(II)V", "updatePhysics", "()V", "Landroid/os/Vibrator;", "v", "setVibrator", "(Landroid/os/Vibrator;)V", "Lcom/urbandroid/sleep/captcha/maze/MazeCaptcha;", "getCaptcha", "()Lcom/urbandroid/sleep/captcha/maze/MazeCaptcha;", "ballRadius", "I", "getBallRadius", "()I", "setBallRadius", "(I)V", "pixelsPerMeter", "F", "goalRect", "Landroid/graphics/RectF;", "getGoalRect", "()Landroid/graphics/RectF;", "setGoalRect", "ballPixelX", "ballPixelY", "pixelWidth", "pixelHeight", "velocityX", "velocityY", "accelX", "accelY", "", "lastTimeMs", "J", "LOCK", "Ljava/lang/Object;", "", "walls", "Ljava/util/List;", "getWalls", "()Ljava/util/List;", "Ljava/util/concurrent/atomic/AtomicReference;", "vibratorRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BallModel {
    public final Object LOCK;
    private float accelX;
    private float accelY;
    public float ballPixelX;
    public float ballPixelY;
    private int ballRadius;
    private final MazeCaptcha captcha;
    private RectF goalRect;
    private volatile long lastTimeMs;
    private int pixelHeight;
    private int pixelWidth;
    private final float pixelsPerMeter;
    private float velocityX;
    private float velocityY;
    private final AtomicReference<Vibrator> vibratorRef;
    private final List<RectF> walls;

    public BallModel(MazeCaptcha mazeCaptcha) {
        mazeCaptcha.getClass();
        this.captcha = mazeCaptcha;
        this.ballRadius = 30;
        this.pixelsPerMeter = 10.0f;
        this.lastTimeMs = -1L;
        this.LOCK = new Object();
        this.walls = new ArrayList();
        this.vibratorRef = new AtomicReference<>();
    }

    public final void addWall(RectF wall) {
        wall.getClass();
        this.walls.add(wall);
    }

    public final RectF getGoalRect() {
        return this.goalRect;
    }

    public final List<RectF> getWalls() {
        return this.walls;
    }

    public final void setAccel(float ax, float ay) {
        synchronized (this.LOCK) {
            this.accelX = ax;
            this.accelY = ay;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setBallRadius(int i) {
        this.ballRadius = i;
    }

    public final void setGoalRect(RectF rectF) {
        this.goalRect = rectF;
    }

    public final void setSize(int width, int height) {
        synchronized (this.LOCK) {
            this.pixelWidth = width;
            this.pixelHeight = height;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setVibrator(Vibrator v) {
        v.getClass();
        this.vibratorRef.set(v);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updatePhysics() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        boolean z;
        int i;
        float f9;
        Vibrator vibrator;
        synchronized (this.LOCK) {
            f = this.pixelWidth;
            f2 = this.pixelHeight;
            f3 = this.ballPixelX;
            f4 = this.ballPixelY;
            f5 = this.velocityX;
            f6 = this.velocityY;
            f7 = this.accelX;
            f8 = -this.accelY;
            Unit unit = Unit.INSTANCE;
        }
        if (f <= 0.0f || f2 <= 0.0f) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.lastTimeMs < 0) {
            this.lastTimeMs = jCurrentTimeMillis;
            return;
        }
        long j = jCurrentTimeMillis - this.lastTimeMs;
        this.lastTimeMs = jCurrentTimeMillis;
        float f10 = j;
        float f11 = this.pixelsPerMeter;
        float f12 = (((f7 * f10) / 1000.0f) * f11) + f5;
        float f13 = (((f8 * f10) / 1000.0f) * f11) + f6;
        float f14 = (((f12 * f10) / 1000.0f) * f11) + f3;
        float f15 = (((f10 * f13) / 1000.0f) * f11) + f4;
        int i2 = this.ballRadius;
        RectF rectF = new RectF(f14 - i2, f15 - i2, i2 + f14, i2 + f15);
        RectF rectF2 = this.goalRect;
        if (rectF2 != null && RectF.intersects(rectF, rectF2)) {
            this.velocityX = 0.0f;
            this.velocityY = 0.0f;
            this.captcha.solve();
            f12 = 0.0f;
            f13 = 0.0f;
        }
        Iterator<T> it = this.walls.iterator();
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            RectF rectF3 = (RectF) next;
            if (RectF.intersects(rectF, rectF3)) {
                Logger.logInfo("Maze: intersect" + rectF3);
                f13 = (-f13) * 0.6f;
                f15 = Math.abs(f15 - rectF3.top) > Math.abs(f15 - rectF3.bottom) ? rectF3.bottom + this.ballRadius : rectF3.top - this.ballRadius;
                z3 = true;
            }
            i3 = i4;
        }
        int i5 = this.ballRadius;
        if (f15 - i5 < 0.0f) {
            f15 = i5;
        } else {
            if (i5 + f15 > f2) {
                f15 = f2 - i5;
            }
            if (z3 && Math.abs(f13) < 2.0d) {
                z3 = false;
                f13 = 0.0f;
            }
            i = this.ballRadius;
            if (f14 - i >= 0.0f) {
                f14 = i;
            } else {
                if (i + f14 <= f) {
                    z = false;
                    if (!z || Math.abs(f12) >= 2.0d) {
                        f9 = f12;
                        z2 = z;
                    } else {
                        f9 = 0.0f;
                    }
                    synchronized (this.LOCK) {
                        this.ballPixelX = f14;
                        this.ballPixelY = f15;
                        this.velocityX = f9;
                        this.velocityY = f13;
                        Unit unit2 = Unit.INSTANCE;
                    }
                    if ((z2 || z3) && (vibrator = this.vibratorRef.get()) != null) {
                        vibrator.vibrate(20L);
                        return;
                    }
                    return;
                }
                f14 = f - i;
            }
            f12 = (-f12) * 0.6f;
            if (z) {
                f9 = f12;
                z2 = z;
            }
            synchronized (this.LOCK) {
            }
        }
        f13 = (-f13) * 0.6f;
        z3 = true;
        if (z3) {
            z3 = false;
            f13 = 0.0f;
        }
        i = this.ballRadius;
        if (f14 - i >= 0.0f) {
        }
        f12 = (-f12) * 0.6f;
        if (z) {
        }
        synchronized (this.LOCK) {
        }
    }
}
