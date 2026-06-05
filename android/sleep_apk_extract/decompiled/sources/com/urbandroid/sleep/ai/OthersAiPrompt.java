package com.urbandroid.sleep.ai;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.StatsRepoLoader;
import com.urbandroid.sleep.addon.stats.advice.CountrySleepRecordProvider;
import com.urbandroid.sleep.addon.stats.model.MeasureRecord;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
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
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/ai/OthersAiPrompt;", "Lcom/urbandroid/sleep/ai/AiPrompt;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "doLoad", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OthersAiPrompt extends AiPrompt {

    /* JADX INFO: renamed from: com.urbandroid.sleep.ai.OthersAiPrompt$doLoad$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.ai.OthersAiPrompt", f = "OthersAiPrompt.kt", l = {18}, m = "doLoad", v = 2)
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
            return OthersAiPrompt.this.doLoad(this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public OthersAiPrompt(Context context) {
        String strM = zza$$ExternalSyntheticOutline0.m(context, R.string.stats_caption_others);
        String string = context.getString(R.string.sleep_assistant_others);
        string.getClass();
        super(context, strM, string);
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
            StatRepo.Mode mode = StatRepo.Mode.SCORE;
            anonymousClass1.L$0 = settings2;
            anonymousClass1.label = 1;
            Object objLoad = statsRepoLoader.load(context, 90, mode, anonymousClass1);
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
            return "There are not enough sleep records to compare your sleep to other people in your country.";
        }
        sb.append("Below is a detailed description on my measured long term average sleep parameters: ");
        AiPrompt.buildPromptFromRecords$default(this, getContext(), mergedStatRecords, sleepScore, sb, (String) null, 16, (Object) null);
        String countryCode = Environment.getCountryCode(getContext());
        getContext().getString(R.string.stats_caption_others_world).getClass();
        if (!CountrySleepRecordProvider.hasMeasureRecord(countryCode)) {
            countryCode = Locale.getDefault().getCountry();
        }
        if (countryCode == null || !CountrySleepRecordProvider.hasMeasureRecord(countryCode) || CountrySleepRecordProvider.getMeasureRecord(countryCode).getEvidence() <= 15000) {
            return "There are not enough sleep records to compare your sleep to other people in your country.";
        }
        MeasureRecord measureRecord = CountrySleepRecordProvider.getMeasureRecord(countryCode);
        String displayCountry = new Locale(Locale.getDefault().getLanguage(), countryCode).getDisplayCountry();
        displayCountry.getClass();
        if (StringsKt.startsWith$default(displayCountry, "United") || StringsKt.startsWith$default(displayCountry, "Great")) {
            String country = new Locale(Locale.getDefault().getLanguage(), countryCode).getCountry();
            country.getClass();
            displayCountry = country.toUpperCase(Locale.ROOT);
            displayCountry.getClass();
        }
        sb.append("Now this is how people sleep in my country - " + displayCountry + ": ");
        Context context2 = getContext();
        measureRecord.getClass();
        buildPromptFromRecords(context2, measureRecord, sleepScore, sb, "Other people's ");
        sb.append(FileInsert$$ExternalSyntheticOutline0.m("Please summarize in ", Locale.getDefault().getDisplayLanguage(Locale.ENGLISH), " language any significant divergences between my long term sleep parameters and the average sleep parameters in my country - ", displayCountry, "."));
        return sb.toString();
    }
}
