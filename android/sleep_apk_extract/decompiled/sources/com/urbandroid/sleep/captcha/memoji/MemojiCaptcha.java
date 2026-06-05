package com.urbandroid.sleep.captcha.memoji;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.RandUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.captcha.AbstractCaptchaActivity;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0003J\r\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0003R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001bR\"\u0010#\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/urbandroid/sleep/captcha/memoji/MemojiCaptcha;", "Lcom/urbandroid/sleep/captcha/AbstractCaptchaActivity;", "<init>", "()V", "", "", "list", "listToString", "(Ljava/util/List;)Ljava/lang/String;", "q", "a", "", "check", "(Ljava/util/List;Ljava/util/List;)Z", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "generateTask", "startCountdown", "", "question", "Ljava/util/List;", "answer", "", "difficulty", "I", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "Landroid/view/animation/Animation;", "anim", "Landroid/view/animation/Animation;", "solved", "count", "getCount", "()I", "setCount", "(I)V", "answerTime", "Z", "getAnswerTime", "()Z", "setAnswerTime", "(Z)V", "Ljava/lang/Runnable;", "countdown", "Ljava/lang/Runnable;", "getCountdown", "()Ljava/lang/Runnable;", "setCountdown", "(Ljava/lang/Runnable;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MemojiCaptcha extends AbstractCaptchaActivity {
    private Animation anim;
    private boolean answerTime;
    private int count;
    private int solved;
    private List<String> question = new ArrayList();
    private final List<String> answer = new ArrayList();
    private int difficulty = 1;
    private Handler h = new Handler();
    private Runnable countdown = new Runnable() { // from class: com.urbandroid.sleep.captcha.memoji.MemojiCaptcha$countdown$1
        @Override // java.lang.Runnable
        public void run() {
            ((TextView) this.this$0.findViewById(R.id.countdown)).startAnimation(this.this$0.anim);
            TextView textView = (TextView) this.this$0.findViewById(R.id.countdown);
            int count = this.this$0.getCount();
            this.this$0.setCount(count - 1);
            textView.setText(String.valueOf(count));
            int count2 = this.this$0.getCount();
            MemojiCaptcha memojiCaptcha = this.this$0;
            if (count2 > 0) {
                memojiCaptcha.setAnswerTime(false);
                this.this$0.h.postDelayed(this, 1000L);
            } else {
                ((TextView) memojiCaptcha.findViewById(R.id.countdown)).setText("");
                ((TextView) this.this$0.findViewById(R.id.display)).setText("");
                this.this$0.findViewById(R.id.keyboard).setVisibility(0);
                this.this$0.setAnswerTime(true);
            }
        }
    };

    private final boolean check(List<String> q, List<String> a) {
        String strListToString = listToString(q);
        String strListToString2 = listToString(a);
        Logger.logInfo("Memoji: Check " + strListToString + " = " + strListToString2);
        final int i = 0;
        if (q.size() > a.size()) {
            Logger.logInfo("Memoji: lenght !=");
            return false;
        }
        if (Intrinsics.areEqual(strListToString, strListToString2)) {
            this.answerTime = false;
            Logger.logInfo("Memoji: =");
            ((TextView) findViewById(R.id.display)).setText("💪💪💪💪💪");
            findViewById(R.id.keyboard).setVisibility(8);
            this.h.postDelayed(new Runnable(this) { // from class: com.urbandroid.sleep.captcha.memoji.MemojiCaptcha$$ExternalSyntheticLambda2
                public final /* synthetic */ MemojiCaptcha f$0;

                {
                    this.f$0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = i;
                    MemojiCaptcha memojiCaptcha = this.f$0;
                    switch (i2) {
                        case 0:
                            MemojiCaptcha.check$lambda$0(memojiCaptcha);
                            break;
                        case 1:
                            MemojiCaptcha.check$lambda$1(memojiCaptcha);
                            break;
                        case 2:
                            MemojiCaptcha.check$lambda$2(memojiCaptcha);
                            break;
                        case 3:
                            MemojiCaptcha.check$lambda$3(memojiCaptcha);
                            break;
                        default:
                            memojiCaptcha.generateTask();
                            break;
                    }
                }
            }, 10L);
            findViewById(R.id.keyboard).setVisibility(8);
            final int i2 = 1;
            this.h.postDelayed(new Runnable(this) { // from class: com.urbandroid.sleep.captcha.memoji.MemojiCaptcha$$ExternalSyntheticLambda2
                public final /* synthetic */ MemojiCaptcha f$0;

                {
                    this.f$0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i22 = i2;
                    MemojiCaptcha memojiCaptcha = this.f$0;
                    switch (i22) {
                        case 0:
                            MemojiCaptcha.check$lambda$0(memojiCaptcha);
                            break;
                        case 1:
                            MemojiCaptcha.check$lambda$1(memojiCaptcha);
                            break;
                        case 2:
                            MemojiCaptcha.check$lambda$2(memojiCaptcha);
                            break;
                        case 3:
                            MemojiCaptcha.check$lambda$3(memojiCaptcha);
                            break;
                        default:
                            memojiCaptcha.generateTask();
                            break;
                    }
                }
            }, 1500L);
            return true;
        }
        Logger.logInfo("Memoji: !=");
        findViewById(R.id.keyboard).setVisibility(8);
        final int i3 = 2;
        this.h.postDelayed(new Runnable(this) { // from class: com.urbandroid.sleep.captcha.memoji.MemojiCaptcha$$ExternalSyntheticLambda2
            public final /* synthetic */ MemojiCaptcha f$0;

            {
                this.f$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i22 = i3;
                MemojiCaptcha memojiCaptcha = this.f$0;
                switch (i22) {
                    case 0:
                        MemojiCaptcha.check$lambda$0(memojiCaptcha);
                        break;
                    case 1:
                        MemojiCaptcha.check$lambda$1(memojiCaptcha);
                        break;
                    case 2:
                        MemojiCaptcha.check$lambda$2(memojiCaptcha);
                        break;
                    case 3:
                        MemojiCaptcha.check$lambda$3(memojiCaptcha);
                        break;
                    default:
                        memojiCaptcha.generateTask();
                        break;
                }
            }
        }, 100L);
        final int i4 = 3;
        this.h.postDelayed(new Runnable(this) { // from class: com.urbandroid.sleep.captcha.memoji.MemojiCaptcha$$ExternalSyntheticLambda2
            public final /* synthetic */ MemojiCaptcha f$0;

            {
                this.f$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i22 = i4;
                MemojiCaptcha memojiCaptcha = this.f$0;
                switch (i22) {
                    case 0:
                        MemojiCaptcha.check$lambda$0(memojiCaptcha);
                        break;
                    case 1:
                        MemojiCaptcha.check$lambda$1(memojiCaptcha);
                        break;
                    case 2:
                        MemojiCaptcha.check$lambda$2(memojiCaptcha);
                        break;
                    case 3:
                        MemojiCaptcha.check$lambda$3(memojiCaptcha);
                        break;
                    default:
                        memojiCaptcha.generateTask();
                        break;
                }
            }
        }, 1500L);
        final int i5 = 4;
        this.h.postDelayed(new Runnable(this) { // from class: com.urbandroid.sleep.captcha.memoji.MemojiCaptcha$$ExternalSyntheticLambda2
            public final /* synthetic */ MemojiCaptcha f$0;

            {
                this.f$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i22 = i5;
                MemojiCaptcha memojiCaptcha = this.f$0;
                switch (i22) {
                    case 0:
                        MemojiCaptcha.check$lambda$0(memojiCaptcha);
                        break;
                    case 1:
                        MemojiCaptcha.check$lambda$1(memojiCaptcha);
                        break;
                    case 2:
                        MemojiCaptcha.check$lambda$2(memojiCaptcha);
                        break;
                    case 3:
                        MemojiCaptcha.check$lambda$3(memojiCaptcha);
                        break;
                    default:
                        memojiCaptcha.generateTask();
                        break;
                }
            }
        }, 2500L);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void check$lambda$0(MemojiCaptcha memojiCaptcha) {
        ((TextView) memojiCaptcha.findViewById(R.id.display)).setText("💪💪💪💪💪");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void check$lambda$1(MemojiCaptcha memojiCaptcha) {
        int i = memojiCaptcha.solved;
        int i2 = memojiCaptcha.difficulty;
        if (i >= i2 - 1) {
            memojiCaptcha.getCaptchaSupport().solved();
            memojiCaptcha.finish();
            return;
        }
        int i3 = i + 1;
        memojiCaptcha.solved = i3;
        Logger.logInfo("Memoji: " + i3 + "  > " + i2);
        memojiCaptcha.generateTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void check$lambda$2(MemojiCaptcha memojiCaptcha) {
        ((TextView) memojiCaptcha.findViewById(R.id.display)).setText(memojiCaptcha.listToString(memojiCaptcha.answer) + "\n" + memojiCaptcha.listToString(memojiCaptcha.question));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void check$lambda$3(MemojiCaptcha memojiCaptcha) {
        ((TextView) memojiCaptcha.findViewById(R.id.display)).setText("🦙🦙🦙🦙🦙");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void generateTask$lambda$0(MemojiCaptcha memojiCaptcha, View view) {
        if (memojiCaptcha.answer.size() <= 0 || !memojiCaptcha.answerTime) {
            return;
        }
        memojiCaptcha.answer.remove(r2.size() - 1);
        ((TextView) memojiCaptcha.findViewById(R.id.display)).setText(memojiCaptcha.listToString(memojiCaptcha.answer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void generateTask$lambda$2$0(MemojiCaptcha memojiCaptcha, View view) {
        view.getClass();
        String string = ((TextView) view).getText().toString();
        zza$$ExternalSyntheticOutline0.m("Memoji: selected ", string);
        memojiCaptcha.answer.add(string);
        memojiCaptcha.check(memojiCaptcha.question, memojiCaptcha.answer);
        ((TextView) memojiCaptcha.findViewById(R.id.display)).setText(memojiCaptcha.listToString(memojiCaptcha.answer));
    }

    private final String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        return sb.toString();
    }

    public final void generateTask() {
        Logger.logInfo("Memoji: generateTask()");
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(getString(R.string.captcha_memoji_title) + " " + (this.difficulty - this.solved) + "x");
        }
        final int i = 0;
        this.answerTime = false;
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.keyboard);
        ((TextView) findViewById(R.id.display)).setText("");
        this.answer.clear();
        this.question.clear();
        viewGroup.removeAllViews();
        EmojiGenerator emojiGenerator = new EmojiGenerator();
        this.question = emojiGenerator.getRandomList(RangesKt.coerceAtMost(this.difficulty + 2, 6));
        findViewById(R.id.keyboard).setVisibility(8);
        findViewById(R.id.keyboard).setVisibility(8);
        ((TextView) findViewById(R.id.display)).setText(listToString(this.question));
        ((TextView) findViewById(R.id.display)).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.captcha.memoji.MemojiCaptcha$$ExternalSyntheticLambda0
            public final /* synthetic */ MemojiCaptcha f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2 = i;
                MemojiCaptcha memojiCaptcha = this.f$0;
                switch (i2) {
                    case 0:
                        MemojiCaptcha.generateTask$lambda$0(memojiCaptcha, view);
                        break;
                    default:
                        MemojiCaptcha.generateTask$lambda$2$0(memojiCaptcha, view);
                        break;
                }
            }
        });
        List<String> randomList = emojiGenerator.getRandomList(this.difficulty + 15);
        Iterator<T> it = this.question.iterator();
        while (it.hasNext()) {
            randomList.add(RandUtil.range(0, randomList.size()), (String) it.next());
        }
        for (String str : randomList) {
            View viewInflate = InflatorUtil.INSTANCE.get(this).inflate(R.layout.captcha_memoji_button, (ViewGroup) null);
            viewInflate.getClass();
            TextView textView = (TextView) viewInflate;
            textView.setText(str);
            final int i2 = 1;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.captcha.memoji.MemojiCaptcha$$ExternalSyntheticLambda0
                public final /* synthetic */ MemojiCaptcha f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i22 = i2;
                    MemojiCaptcha memojiCaptcha = this.f$0;
                    switch (i22) {
                        case 0:
                            MemojiCaptcha.generateTask$lambda$0(memojiCaptcha, view);
                            break;
                        default:
                            MemojiCaptcha.generateTask$lambda$2$0(memojiCaptcha, view);
                            break;
                    }
                }
            });
            viewGroup.addView(textView);
        }
        this.count = RangesKt.coerceAtLeast(8 - this.difficulty, 5);
        startCountdown();
    }

    public final int getCount() {
        return this.count;
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.captcha_memoji);
        this.difficulty = getCaptchaSupport().getDifficulty();
        this.anim = AnimationUtils.loadAnimation(this, R.anim.fade);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(getString(R.string.captcha_memoji_title));
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setSubtitle(getString(R.string.captcha_memoji_summary));
        }
        generateTask();
    }

    public final void setAnswerTime(boolean z) {
        this.answerTime = z;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void startCountdown() {
        this.h.postDelayed(this.countdown, 1000L);
    }
}
