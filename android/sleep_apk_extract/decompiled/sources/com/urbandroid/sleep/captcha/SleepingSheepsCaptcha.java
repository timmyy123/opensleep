package com.urbandroid.sleep.captcha;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.ResourceUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0003/0.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\r\u0010\u0004J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001dR\u001c\u0010 \u001a\b\u0018\u00010\u001fR\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010&\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010#R\u001c\u0010(\u001a\b\u0018\u00010'R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010#R\u0016\u0010+\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010#R\u0016\u0010,\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010#R\u0016\u0010-\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010#¨\u00061"}, d2 = {"Lcom/urbandroid/sleep/captcha/SleepingSheepsCaptcha;", "Lcom/urbandroid/sleep/captcha/AbstractCaptchaActivity;", "Landroid/view/View$OnTouchListener;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onStart", "onStop", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/MotionEvent;", "motionEvent", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Landroid/graphics/PointF;", "p1", "p2", "", "dist", "(Landroid/graphics/PointF;Landroid/graphics/PointF;)F", "", "difficultyWhenFallback", "()I", "difficultyWhenFallbackTimes", "Lcom/urbandroid/sleep/captcha/SleepingSheepsCaptcha$SheepView;", "sheepView", "Lcom/urbandroid/sleep/captcha/SleepingSheepsCaptcha$SheepView;", "imageWidth", "I", "imageHeight", "TOLERANCE", "tries", "Lcom/urbandroid/sleep/captcha/SleepingSheepsCaptcha$RedrawThread;", "redrawThread", "Lcom/urbandroid/sleep/captcha/SleepingSheepsCaptcha$RedrawThread;", "redrawTimeout", "sleepResPos", "sleepX", "sleepY", "Companion", "RedrawThread", "SheepView", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepingSheepsCaptcha extends AbstractCaptchaActivity implements View.OnTouchListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int TOLERANCE = 10;
    private int imageHeight;
    private int imageWidth;
    private RedrawThread redrawThread;
    private int redrawTimeout;
    private SheepView sheepView;
    private int sleepResPos;
    private int sleepX;
    private int sleepY;
    private int tries;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/captcha/SleepingSheepsCaptcha$Companion;", "", "<init>", "()V", "random", "", "min", "max", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int random(int min, int max) {
            return ((int) (Math.random() * ((double) ((max - min) + 1)))) + min;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/captcha/SleepingSheepsCaptcha$RedrawThread;", "Ljava/lang/Runnable;", "<init>", "(Lcom/urbandroid/sleep/captcha/SleepingSheepsCaptcha;)V", "run", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class RedrawThread implements Runnable {
        public RedrawThread() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(SleepingSheepsCaptcha sleepingSheepsCaptcha) {
            SheepView sheepView = sleepingSheepsCaptcha.sheepView;
            sheepView.getClass();
            sheepView.invalidate();
            SheepView sheepView2 = sleepingSheepsCaptcha.sheepView;
            sheepView2.getClass();
            sheepView2.refreshDrawableState();
        }

        @Override // java.lang.Runnable
        public void run() {
            SleepingSheepsCaptcha sleepingSheepsCaptcha = SleepingSheepsCaptcha.this;
            sleepingSheepsCaptcha.runOnUiThread(new SleepingSheepsCaptcha$$ExternalSyntheticLambda0(sleepingSheepsCaptcha, 1));
            ((BaseActivity) SleepingSheepsCaptcha.this).h.removeCallbacks(this);
            ((BaseActivity) SleepingSheepsCaptcha.this).h.postDelayed(this, SleepingSheepsCaptcha.this.redrawTimeout);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/urbandroid/sleep/captcha/SleepingSheepsCaptcha$SheepView;", "Landroid/view/View;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Lcom/urbandroid/sleep/captcha/SleepingSheepsCaptcha;Landroid/content/Context;)V", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "", "foundState", "I", "getFoundState", "()I", "setFoundState", "(I)V", "", "canTouch", "Z", "getCanTouch", "()Z", "setCanTouch", "(Z)V", "", "sleepRes", "[I", "wakeRes", "", "Landroid/graphics/Bitmap;", "wakeBitmap", "Ljava/util/List;", "sleepBitmap", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class SheepView extends View {
        private boolean canTouch;
        private int foundState;
        private List<Bitmap> sleepBitmap;
        private final int[] sleepRes;
        private List<Bitmap> wakeBitmap;
        private final int[] wakeRes;

        public SheepView(Context context) {
            super(context);
            this.canTouch = true;
            this.sleepRes = new int[]{R.drawable.captcha_sheep_sleep_1_f, R.drawable.captcha_sheep_sleep_2_f, R.drawable.captcha_sheep_sleep_b_2_f, R.drawable.captcha_sheep_sleep_b_1_f, R.drawable.captcha_sheep_sleep_1, R.drawable.captcha_sheep_sleep_2, R.drawable.captcha_sheep_sleep_b_2, R.drawable.captcha_sheep_sleep_b_1};
            int[] iArr = {R.drawable.captcha_sheep_wake_1, R.drawable.captcha_sheep_wake_2, R.drawable.captcha_sheep_wake_b_1, R.drawable.captcha_sheep_wake_b_2, R.drawable.captcha_sheep_wake_1_f, R.drawable.captcha_sheep_wake_2_f, R.drawable.captcha_sheep_wake_b_1_f, R.drawable.captcha_sheep_wake_b_2_f};
            this.wakeRes = iArr;
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int i : iArr) {
                arrayList.add(ResourceUtil.getBitmap(context, i));
            }
            this.wakeBitmap = arrayList;
            int[] iArr2 = this.sleepRes;
            ArrayList arrayList2 = new ArrayList(iArr2.length);
            for (int i2 : iArr2) {
                arrayList2.add(ResourceUtil.getBitmap(context, i2));
            }
            this.sleepBitmap = arrayList2;
        }

        public final boolean getCanTouch() {
            return this.canTouch;
        }

        public final int getFoundState() {
            return this.foundState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v2 */
        /* JADX WARN: Type inference failed for: r14v3 */
        /* JADX WARN: Type inference failed for: r14v4 */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r14v7 */
        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            boolean z;
            canvas.getClass();
            double d = 1.5d;
            boolean z2 = true;
            int i = 0;
            if (this.foundState > 0) {
                this.canTouch = false;
                float f = (SleepingSheepsCaptcha.this.imageWidth / 2) + SleepingSheepsCaptcha.this.sleepX;
                float f2 = (SleepingSheepsCaptcha.this.imageHeight / 2) + SleepingSheepsCaptcha.this.sleepY;
                RadialGradient radialGradient = new RadialGradient(f, f2, (float) (((double) SleepingSheepsCaptcha.this.imageWidth) * 1.5d), ColorUtil.i(getContext(), R.color.black), ColorUtil.i(getContext(), R.color.bg_main_dark), Shader.TileMode.CLAMP);
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setDither(true);
                paint.setShader(radialGradient);
                canvas.drawCircle(f, f2, (float) (((double) SleepingSheepsCaptcha.this.imageWidth) * 1.5d), paint);
                Bitmap bitmap = ResourceUtil.getBitmap(getContext(), R.drawable.captcha_sheep_spotlight);
                float width = (bitmap.getWidth() / 2) - (SleepingSheepsCaptcha.this.imageWidth / 2);
                canvas.drawBitmap(bitmap, SleepingSheepsCaptcha.this.sleepX - width, SleepingSheepsCaptcha.this.sleepY - width, (Paint) null);
                if (this.foundState > 1) {
                    canvas.drawBitmap(ResourceUtil.getBitmap(getContext(), this.wakeRes[SleepingSheepsCaptcha.this.sleepResPos]), SleepingSheepsCaptcha.this.sleepX, SleepingSheepsCaptcha.this.sleepY, (Paint) null);
                } else {
                    canvas.drawBitmap(ResourceUtil.getBitmap(getContext(), this.sleepRes[SleepingSheepsCaptcha.this.sleepResPos]), SleepingSheepsCaptcha.this.sleepX, SleepingSheepsCaptcha.this.sleepY, (Paint) null);
                }
                int i2 = this.foundState + 1;
                this.foundState = i2;
                if (i2 > 2) {
                    this.foundState = 0;
                }
                zza$$ExternalSyntheticOutline0.m(this.foundState, "Sheep: found state ");
                return;
            }
            ArrayList arrayList = new ArrayList();
            int iDifficultyWhenFallback = (SleepingSheepsCaptcha.this.difficultyWhenFallback() * 5) + 5;
            int i3 = 0;
            while (true) {
                Companion companion = SleepingSheepsCaptcha.INSTANCE;
                PointF pointF = new PointF(companion.random(i, getWidth() - SleepingSheepsCaptcha.this.imageWidth), companion.random(i, getHeight() - SleepingSheepsCaptcha.this.imageHeight));
                SleepingSheepsCaptcha sleepingSheepsCaptcha = SleepingSheepsCaptcha.this;
                Iterator it = arrayList.iterator();
                ?? r14 = i;
                while (it.hasNext()) {
                    double d2 = d;
                    boolean z3 = z2;
                    if (sleepingSheepsCaptcha.dist((PointF) it.next(), pointF) < ((double) sleepingSheepsCaptcha.imageWidth) / d2) {
                        r14 = z3;
                    }
                    d = d2;
                    z2 = z3;
                    r14 = r14;
                }
                double d3 = d;
                z = z2;
                if (r14 == 0) {
                    arrayList.add(pointF);
                }
                i3++;
                if (i3 > 200 || arrayList.size() >= iDifficultyWhenFallback) {
                    break;
                }
                d = d3;
                z2 = z;
                i = 0;
            }
            List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.urbandroid.sleep.captcha.SleepingSheepsCaptcha$SheepView$onDraw$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    PointF pointF2 = (PointF) t;
                    PointF pointF3 = (PointF) t2;
                    return ComparisonsKt.compareValues(Float.valueOf((pointF2.y * this.this$0.getWidth()) + pointF2.x), Float.valueOf((pointF3.y * this.this$0.getWidth()) + pointF3.x));
                }
            });
            int iRandom = SleepingSheepsCaptcha.INSTANCE.random(2, arrayList.size() - 3);
            SleepingSheepsCaptcha sleepingSheepsCaptcha2 = SleepingSheepsCaptcha.this;
            int i4 = 0;
            for (Object obj : listSortedWith) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                PointF pointF2 = (PointF) obj;
                if (i4 == iRandom && this.foundState == 0) {
                    sleepingSheepsCaptcha2.sleepResPos = SleepingSheepsCaptcha.INSTANCE.random(0, this.sleepBitmap.size() - 1);
                    canvas.drawBitmap(this.sleepBitmap.get(sleepingSheepsCaptcha2.sleepResPos), pointF2.x, pointF2.y, (Paint) null);
                    sleepingSheepsCaptcha2.sleepX = (int) pointF2.x;
                    sleepingSheepsCaptcha2.sleepY = (int) pointF2.y;
                } else {
                    canvas.drawBitmap(this.wakeBitmap.get(SleepingSheepsCaptcha.INSTANCE.random(0, r6.size() - 1)), pointF2.x, pointF2.y, (Paint) null);
                }
                i4 = i5;
            }
            this.canTouch = z;
        }

        public final void setFoundState(int i) {
            this.foundState = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouch$lambda$1(SleepingSheepsCaptcha sleepingSheepsCaptcha) {
        SheepView sheepView = sleepingSheepsCaptcha.sheepView;
        if (sheepView != null) {
            sheepView.setFoundState(2);
        }
        SheepView sheepView2 = sleepingSheepsCaptcha.sheepView;
        sheepView2.getClass();
        sheepView2.invalidate();
        SheepView sheepView3 = sleepingSheepsCaptcha.sheepView;
        sheepView3.getClass();
        sheepView3.refreshDrawableState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouch$lambda$2(SleepingSheepsCaptcha sleepingSheepsCaptcha) {
        SheepView sheepView = sleepingSheepsCaptcha.sheepView;
        if (sheepView != null) {
            sheepView.setFoundState(0);
        }
        SheepView sheepView2 = sleepingSheepsCaptcha.sheepView;
        sheepView2.getClass();
        sheepView2.invalidate();
        SheepView sheepView3 = sleepingSheepsCaptcha.sheepView;
        sheepView3.getClass();
        sheepView3.refreshDrawableState();
    }

    public final int difficultyWhenFallback() {
        if (getDifficulty() >= 100) {
            return 3;
        }
        return getDifficulty();
    }

    public final int difficultyWhenFallbackTimes() {
        int difficulty = getDifficulty();
        int difficulty2 = getDifficulty();
        return difficulty >= 100 ? difficulty2 / 2 : difficulty2;
    }

    public final float dist(PointF p1, PointF p2) {
        p1.getClass();
        p2.getClass();
        return (float) Math.sqrt(((float) Math.pow(p2.x - p1.x, 2.0d)) + ((float) Math.pow(p2.y - p1.y, 2.0d)));
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capctha_sheep);
        SheepView sheepView = new SheepView(this);
        this.sheepView = sheepView;
        sheepView.setOnTouchListener(this);
        View viewFindViewById = findViewById(R.id.main);
        viewFindViewById.getClass();
        ((ViewGroup) viewFindViewById).addView(this.sheepView);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.getClass();
        supportActionBar.setTitle(difficultyWhenFallbackTimes() + "x " + getResources().getString(R.string.captcha_sheep));
        Bitmap bitmap = ResourceUtil.getBitmap(this, R.drawable.captcha_sheep_sleep_1);
        this.imageWidth = bitmap.getWidth();
        this.imageHeight = bitmap.getHeight();
        if (savedInstanceState != null) {
            this.tries = savedInstanceState.getInt("tries");
        }
        Logger.logInfo("Sheep: Created sheep captcha: " + this);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        outState.getClass();
        super.onSaveInstanceState(outState);
        outState.putInt("tries", this.tries);
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.redrawTimeout = (int) Math.max((6 - difficultyWhenFallback()) * 1250, 1500.0d);
        RedrawThread redrawThread = new RedrawThread();
        this.redrawThread = redrawThread;
        this.h.removeCallbacks(redrawThread);
        Handler handler = this.h;
        RedrawThread redrawThread2 = this.redrawThread;
        redrawThread2.getClass();
        handler.postDelayed(redrawThread2, this.redrawTimeout);
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Handler handler = this.h;
        RedrawThread redrawThread = this.redrawThread;
        redrawThread.getClass();
        handler.removeCallbacks(redrawThread);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0030, code lost:
    
        if (r10.getCanTouch() == false) goto L9;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        view.getClass();
        motionEvent.getClass();
        if (!isSolved()) {
            SheepView sheepView = this.sheepView;
            if (sheepView != null) {
                Logger.logInfo("Sheep: foundState " + sheepView.getFoundState() + " ");
            }
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int iDifficultyWhenFallbackTimes = difficultyWhenFallbackTimes();
            int i = this.sleepX;
            int i2 = this.TOLERANCE;
            int i3 = 0;
            int i4 = 2;
            if (x >= i - i2 && x <= i + this.imageWidth + i2) {
                int i5 = this.sleepY;
                if (y >= i5 - i2 && y <= i5 + this.imageHeight + i2) {
                    Logger.logInfo("Sheep: Correct sheep found.");
                    userInteraction();
                    SheepView sheepView2 = this.sheepView;
                    if (sheepView2 != null) {
                        sheepView2.setFoundState(1);
                    }
                    SheepView sheepView3 = this.sheepView;
                    sheepView3.getClass();
                    sheepView3.invalidate();
                    SheepView sheepView4 = this.sheepView;
                    sheepView4.getClass();
                    sheepView4.refreshDrawableState();
                    this.h.postDelayed(new SleepingSheepsCaptcha$$ExternalSyntheticLambda0(this, i3), 200L);
                    this.h.postDelayed(new SleepingSheepsCaptcha$$ExternalSyntheticLambda0(this, i4), 400L);
                    Handler handler = this.h;
                    RedrawThread redrawThread = this.redrawThread;
                    redrawThread.getClass();
                    handler.removeCallbacks(redrawThread);
                    Handler handler2 = this.h;
                    RedrawThread redrawThread2 = this.redrawThread;
                    redrawThread2.getClass();
                    handler2.postDelayed(redrawThread2, this.redrawTimeout);
                    int i6 = this.tries + 1;
                    this.tries = i6;
                    if (i6 >= iDifficultyWhenFallbackTimes) {
                        Handler handler3 = this.h;
                        RedrawThread redrawThread3 = this.redrawThread;
                        redrawThread3.getClass();
                        handler3.removeCallbacks(redrawThread3);
                        setResult(2);
                        solved();
                        return true;
                    }
                    ActionBar supportActionBar = getSupportActionBar();
                    supportActionBar.getClass();
                    supportActionBar.setTitle((iDifficultyWhenFallbackTimes - this.tries) + "x " + getResources().getString(R.string.captcha_sheep));
                    SheepView sheepView5 = this.sheepView;
                    sheepView5.getClass();
                    sheepView5.invalidate();
                    SheepView sheepView6 = this.sheepView;
                    sheepView6.getClass();
                    sheepView6.refreshDrawableState();
                    return false;
                }
            }
            if (iDifficultyWhenFallbackTimes > 2 && this.tries > 0) {
                Toast.makeText(this, "Oops +1x", 0).show();
                this.tries--;
                ActionBar supportActionBar2 = getSupportActionBar();
                supportActionBar2.getClass();
                supportActionBar2.setTitle((iDifficultyWhenFallbackTimes - this.tries) + "x " + getResources().getString(R.string.captcha_sheep));
            }
            return false;
        }
        return true;
    }
}
