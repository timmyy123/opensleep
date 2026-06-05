package com.urbandroid.sleep.service;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.FixedJobIntentService;
import androidx.core.app.JobIntentService;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.media.NoiseDirectory;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0006H\u0003R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/service/DeleteObsoleteNoisesService;", "Landroidx/core/app/FixedJobIntentService;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "onHandleWork", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "deleteNoises", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "repo", "Lcom/urbandroid/sleep/persistence/DbSleepRecordRepository;", "from", "Ljava/util/Date;", "to", "deleteAudio", "Lcom/urbandroid/sleep/media/NoiseDirectory$State;", "noiseUri", "deleteAudioViaDocumentProvider", "noisePath", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DeleteObsoleteNoisesService extends FixedJobIntentService implements FeatureLogger {
    private final String tag = "DeleteObsoleteNoises";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Date TO_BE_DELETED_DATE = new Date(0);
    private static long LAST_EXECUTION = -1;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/service/DeleteObsoleteNoisesService$Companion;", "", "<init>", "()V", "DELETE_AFTER_DAYS", "", "TO_BE_DELETED_DATE", "Ljava/util/Date;", "LAST_EXECUTION", "", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "from", "to", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(Context context) {
            context.getClass();
            if (DeleteObsoleteNoisesService.LAST_EXECUTION == -1 || System.currentTimeMillis() - DeleteObsoleteNoisesService.LAST_EXECUTION > Utils.getHoursInMillis(4)) {
                JobIntentService.enqueueWork(context, (Class<?>) DeleteObsoleteNoisesService.class, 1010, new Intent());
                DeleteObsoleteNoisesService.LAST_EXECUTION = System.currentTimeMillis();
            }
        }

        private Companion() {
        }

        public final void start(Context context, long from, long to) {
            context.getClass();
            Intent intent = new Intent();
            intent.putExtra("deleteFrom", from);
            intent.putExtra("deleteTo", to);
            JobIntentService.enqueueWork(context, (Class<?>) DeleteObsoleteNoisesService.class, 1010, intent);
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NoiseDirectory.State.values().length];
            try {
                iArr[NoiseDirectory.State.DELETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NoiseDirectory.State.NOT_DELETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NoiseDirectory.State.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final NoiseDirectory.State deleteAudio(String noiseUri) {
        if (noiseUri == null) {
            return NoiseDirectory.State.NOT_FOUND;
        }
        File file = new File(noiseUri);
        return !file.exists() ? NoiseDirectory.State.NOT_FOUND : file.delete() ? NoiseDirectory.State.DELETED : NoiseDirectory.State.NOT_DELETED;
    }

    private final NoiseDirectory.State deleteAudioViaDocumentProvider(Context context, String noisePath) {
        NoiseDirectory noiseDirectory = new NoiseDirectory(context);
        if (!noiseDirectory.exists(noisePath)) {
            return NoiseDirectory.State.NOT_FOUND;
        }
        NoiseDirectory.State stateDelete = noiseDirectory.delete(noisePath);
        stateDelete.getClass();
        return stateDelete;
    }

    public static final void start(Context context, long j, long j2) {
        INSTANCE.start(context, j, j2);
    }

    public final void deleteNoises(Context context, DbSleepRecordRepository repo, Date from, Date to) {
        int i;
        Noise next;
        NoiseDirectory.State stateDeleteAudio;
        context.getClass();
        repo.getClass();
        to.getClass();
        List<Noise> noisesForDeletion = repo.getNoisesForDeletion(from, to);
        String strM = FileInsert$$ExternalSyntheticOutline0.m(noisesForDeletion.size(), "Deleting noises, count: ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        Iterator<Noise> it = noisesForDeletion.iterator();
        loop0: while (true) {
            i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                next = it.next();
                String uriFix = next.getUriFix(context);
                if (NoiseDirectory.isContentUri(uriFix) && Environment.isLollipopOrGreater()) {
                    Context applicationContext = getApplicationContext();
                    applicationContext.getClass();
                    uriFix.getClass();
                    stateDeleteAudio = deleteAudioViaDocumentProvider(applicationContext, uriFix);
                } else {
                    stateDeleteAudio = deleteAudio(uriFix);
                }
                int i2 = WhenMappings.$EnumSwitchMapping$0[stateDeleteAudio.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        i++;
                        String strM2 = FileInsert$$ExternalSyntheticOutline0.m("Cannot delete noise ", next.getUri());
                        Logger.logSevere(Logger.defaultTag, getTag() + ": " + strM2, null);
                        if (i >= 30) {
                            Logger.logSevere(Logger.defaultTag, getTag() + ": Too many failure for delete noise files", null);
                            break loop0;
                        }
                    } else if (i2 != 3) {
                        Home$$ExternalSyntheticBUOutline0.m();
                        return;
                    }
                }
            }
            repo.deleteNoise(next);
        }
        String strM3 = FileInsert$$ExternalSyntheticOutline0.m(i, "Finished - failed deletions = ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM3, null);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(Intent intent) {
        intent.getClass();
        GlobalInitializator.initializeIfRequired(this);
        Context applicationContext = getApplicationContext();
        if (!intent.hasExtra("deleteFrom") || !intent.hasExtra("deleteTo")) {
            Context applicationContext2 = getApplicationContext();
            applicationContext2.getClass();
            if (ContextExtKt.getSettings(applicationContext2).isAutoDeleteNoise()) {
                int intExtra = intent.getIntExtra("deleteAfterDays", 7);
                Calendar calendar = Calendar.getInstance();
                calendar.add(5, -intExtra);
                String str = "Delete noises service: " + intExtra + " days after. Older than " + calendar.getTime();
                Logger.logDebug(Logger.defaultTag, getTag() + ": " + str, null);
                DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
                applicationContext.getClass();
                sleepRecordRepository.getClass();
                Date time = calendar.getTime();
                time.getClass();
                deleteNoises(applicationContext, sleepRecordRepository, null, time);
                return;
            }
            return;
        }
        long longExtra = intent.getLongExtra("deleteFrom", -1L);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(longExtra);
        long longExtra2 = intent.getLongExtra("deleteTo", -1L);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTimeInMillis(longExtra2);
        if (longExtra == -1 || longExtra2 == -1) {
            return;
        }
        String str2 = Logger.defaultTag;
        Logger.logDebug(str2, getTag() + ": " + ("Delete noises service: " + calendar2 + " - " + calendar3), null);
        DbSleepRecordRepository sleepRecordRepository2 = SharedApplicationContext.getInstance().getSleepRecordRepository();
        applicationContext.getClass();
        sleepRecordRepository2.getClass();
        Date time2 = calendar2.getTime();
        Date time3 = calendar3.getTime();
        time3.getClass();
        deleteNoises(applicationContext, sleepRecordRepository2, time2, time3);
    }

    public static final void start(Context context) {
        INSTANCE.start(context);
    }
}
