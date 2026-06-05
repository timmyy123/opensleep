package com.urbandroid.sleep.ai;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.StatsRepoLoader;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.service.Settings;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/ai/ScoreAiPrompt;", "Lcom/urbandroid/sleep/ai/AiPrompt;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "days", "<init>", "(Landroid/content/Context;I)V", "", "doLoad", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "I", "getDays", "()I", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ScoreAiPrompt extends AiPrompt {
    private final int days;

    /* JADX INFO: renamed from: com.urbandroid.sleep.ai.ScoreAiPrompt$doLoad$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.ai.ScoreAiPrompt", f = "ScoreAiPrompt.kt", l = {24}, m = "doLoad", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScoreAiPrompt.this.doLoad(this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ScoreAiPrompt(Context context, int i) {
        String strM = zza$$ExternalSyntheticOutline0.m(context, R.string.score);
        String string = context.getString(R.string.sleep_assistant_score);
        string.getClass();
        super(context, strM, string);
        this.days = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbandroid.sleep.ai.AiPrompt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doLoad(Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        Settings settings;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Settings settings2 = ContextExtKt.getSettings(getContext());
            StatsRepoLoader statsRepoLoader = StatsRepoLoader.INSTANCE;
            Context context = getContext();
            int i3 = this.days;
            StatRepo.Mode mode = StatRepo.Mode.SCORE;
            anonymousClass1.L$0 = settings2;
            anonymousClass1.label = 1;
            Object objLoad = statsRepoLoader.load(context, i3, mode, anonymousClass1);
            if (objLoad == coroutine_suspended) {
                return coroutine_suspended;
            }
            settings = settings2;
            obj = objLoad;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            settings = (Settings) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        StatRepo statRepo = (StatRepo) obj;
        SleepScore sleepScore = new SleepScore();
        sleepScore.setAge(settings.getAge());
        StringBuilder sb = new StringBuilder();
        List<StatRecord> mergedStatRecords = statRepo != null ? statRepo.getMergedStatRecords() : null;
        if (mergedStatRecords == null) {
            return "There are not enough sleep records to tell about your sleep score.";
        }
        sb.append("Below is a detailed description on my measured average sleep parameters from last " + this.days + " days and " + Boxing.boxInt(mergedStatRecords.size()) + " sleep records. ");
        AiPrompt.buildPromptFromRecords$default(this, getContext(), mergedStatRecords, sleepScore, sb, (String) null, 16, (Object) null);
        if (sleepScore.getScore() != -1) {
            sb.append("Your overall sleep score is " + RangesKt.coerceAtLeast(MathKt.roundToInt(sleepScore.getScorePercentage() * 100.0f), 0) + "%. ");
        }
        sb.append("Can you please summarize in " + Locale.getDefault().getDisplayLanguage(Locale.ENGLISH) + " language how I'm doing regarding my sleep, what are my weak and strong points and what needs to be improved most? ");
        return sb.toString();
    }

    public /* synthetic */ ScoreAiPrompt(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 14 : i);
    }
}
