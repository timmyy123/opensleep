package com.urbandroid.sleep.ai;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.StatsRepoLoader;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.service.Settings;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Ref$ObjectRef;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/ai/TrendsAiPrompt;", "Lcom/urbandroid/sleep/ai/AiPrompt;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "doLoad", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TrendsAiPrompt extends AiPrompt {

    /* JADX INFO: renamed from: com.urbandroid.sleep.ai.TrendsAiPrompt$doLoad$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.ai.TrendsAiPrompt", f = "TrendsAiPrompt.kt", l = {18, 32}, m = "doLoad", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TrendsAiPrompt.this.doLoad(this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TrendsAiPrompt(Context context) {
        String strM = zza$$ExternalSyntheticOutline0.m(context, R.string.trend);
        String string = context.getString(R.string.sleep_assistant_advice);
        string.getClass();
        super(context, strM, string);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, com.urbandroid.sleep.addon.stats.SleepScore] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, com.urbandroid.sleep.addon.stats.SleepScore] */
    @Override // com.urbandroid.sleep.ai.AiPrompt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doLoad(Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        TrendsAiPrompt trendsAiPrompt;
        Settings settings;
        StringBuilder sb;
        Settings settings2;
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        T mergedStatRecords;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
                trendsAiPrompt = this;
            } else {
                trendsAiPrompt = this;
                anonymousClass1 = trendsAiPrompt.new AnonymousClass1(continuation);
            }
        }
        Object objLoad = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objLoad);
            Settings settings3 = ContextExtKt.getSettings(trendsAiPrompt.getContext());
            StatsRepoLoader statsRepoLoader = StatsRepoLoader.INSTANCE;
            Context context = trendsAiPrompt.getContext();
            StatRepo.Mode mode = StatRepo.Mode.SCORE;
            anonymousClass1.L$0 = settings3;
            anonymousClass1.label = 1;
            Object objLoad2 = statsRepoLoader.load(context, 90, mode, anonymousClass1);
            if (objLoad2 != coroutine_suspended) {
                settings = settings3;
                objLoad = objLoad2;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$ObjectRef2 = (Ref$ObjectRef) anonymousClass1.L$4;
            StringBuilder sb2 = (StringBuilder) anonymousClass1.L$3;
            ref$ObjectRef = (Ref$ObjectRef) anonymousClass1.L$2;
            settings2 = (Settings) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objLoad);
            sb = sb2;
            StatRepo statRepo = (StatRepo) objLoad;
            ?? sleepScore = new SleepScore();
            ref$ObjectRef.element = sleepScore;
            sleepScore.setAge(settings2.getAge());
            mergedStatRecords = statRepo != null ? statRepo.getMergedStatRecords() : 0;
            ref$ObjectRef2.element = mergedStatRecords;
            if (((List) mergedStatRecords) != null) {
                return "There isn't enough data to compare long term and short term sleep stats. ";
            }
            sb.append("Now here are recent detailed average sleep parameters from only the last 14 days.");
            AiPrompt.buildPromptFromRecords$default(this, getContext(), (List) ref$ObjectRef2.element, (SleepScore) ref$ObjectRef.element, sb, (String) null, 16, (Object) null);
            sb.append("Please tell me in " + Locale.getDefault().getDisplayLanguage(Locale.ENGLISH) + " language which parameters of my sleep did significantly improve or worsen in short term over long term. ");
            return sb.toString();
        }
        Settings settings4 = (Settings) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objLoad);
        settings = settings4;
        StatRepo statRepo2 = (StatRepo) objLoad;
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        ?? sleepScore2 = new SleepScore();
        ref$ObjectRef3.element = sleepScore2;
        sleepScore2.setAge(settings.getAge());
        sb = new StringBuilder();
        Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
        T mergedStatRecords2 = statRepo2 != null ? statRepo2.getMergedStatRecords() : 0;
        ref$ObjectRef4.element = mergedStatRecords2;
        List list = (List) mergedStatRecords2;
        if (list != null) {
            sb.append("Below is a detailed description on my long term measured average sleep parameters from last 3 months. ");
            AiPrompt.buildPromptFromRecords$default(trendsAiPrompt, trendsAiPrompt.getContext(), list, (SleepScore) ref$ObjectRef3.element, sb, (String) null, 16, (Object) null);
        }
        StatsRepoLoader statsRepoLoader2 = StatsRepoLoader.INSTANCE;
        Context context2 = getContext();
        StatRepo.Mode mode2 = StatRepo.Mode.SCORE;
        anonymousClass1.L$0 = settings;
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(statRepo2);
        anonymousClass1.L$2 = ref$ObjectRef3;
        anonymousClass1.L$3 = sb;
        anonymousClass1.L$4 = ref$ObjectRef4;
        anonymousClass1.label = 2;
        objLoad = statsRepoLoader2.load(context2, 14, mode2, anonymousClass1);
        if (objLoad != coroutine_suspended) {
            settings2 = settings;
            ref$ObjectRef = ref$ObjectRef3;
            ref$ObjectRef2 = ref$ObjectRef4;
            StatRepo statRepo3 = (StatRepo) objLoad;
            ?? sleepScore3 = new SleepScore();
            ref$ObjectRef.element = sleepScore3;
            sleepScore3.setAge(settings2.getAge());
            if (statRepo3 != null) {
            }
            ref$ObjectRef2.element = mergedStatRecords;
            if (((List) mergedStatRecords) != null) {
            }
        }
        return coroutine_suspended;
    }
}
