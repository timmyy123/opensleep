package com.urbandroid.sleep.addon.stats;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.addon.stats.model.NoRecordsException;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.mp4parser.boxes.apple.TrackLoadSettingsAtom;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/StatsRepoLoader;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", TrackLoadSettingsAtom.TYPE, "Lcom/urbandroid/sleep/addon/stats/model/StatRepo;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "period", "", "mode", "Lcom/urbandroid/sleep/addon/stats/model/StatRepo$Mode;", "(Landroid/content/Context;ILcom/urbandroid/sleep/addon/stats/model/StatRepo$Mode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatsRepoLoader implements FeatureLogger {
    public static final StatsRepoLoader INSTANCE = new StatsRepoLoader();
    private static final String tag = "StatRepoLoader";

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.StatsRepoLoader$load$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/addon/stats/model/StatRepo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.StatsRepoLoader$load$2", f = "StatsRepoLoader.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super StatRepo>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ StatRepo.Mode $mode;
        final /* synthetic */ int $period;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, int i, StatRepo.Mode mode, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$period = i;
            this.$mode = mode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, this.$period, this.$mode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super StatRepo> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    int dayCutOffHour = ContextExtKt.getSettings(this.$context).getDayCutOffHour();
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(5, -(this.$period - 1));
                    calendar.setTime(DateUtil.getCutOffDate(calendar.getTime(), dayCutOffHour));
                    StatRepo statRepo = new StatRepo();
                    try {
                        statRepo.initialize(this.$context, calendar.getTime(), this.$mode);
                    } catch (NoRecordsException unused) {
                    }
                    return statRepo;
                } catch (Exception e) {
                    StatsRepoLoader statsRepoLoader = StatsRepoLoader.INSTANCE;
                    Logger.logSevere(Logger.defaultTag, statsRepoLoader.getTag(), e);
                    String strM = zzba$$ExternalSyntheticOutline0.m("data loaded - ", " ms", System.currentTimeMillis() - jCurrentTimeMillis);
                    Logger.logInfo(Logger.defaultTag, statsRepoLoader.getTag() + ": " + strM, null);
                    return null;
                }
            } finally {
                StatsRepoLoader statsRepoLoader2 = StatsRepoLoader.INSTANCE;
                String strM2 = zzba$$ExternalSyntheticOutline0.m("data loaded - ", " ms", System.currentTimeMillis() - jCurrentTimeMillis);
                Logger.logInfo(Logger.defaultTag, statsRepoLoader2.getTag() + ": " + strM2, null);
            }
        }
    }

    private StatsRepoLoader() {
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return tag;
    }

    public final Object load(Context context, int i, StatRepo.Mode mode, Continuation<? super StatRepo> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(context, i, mode, null), continuation);
    }
}
