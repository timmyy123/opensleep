package io.ktor.events;

import com.garmin.android.connectiq.ConnectIQ;
import com.google.android.gms.tasks.OnFailureListener;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.DefaultRingtoneResolveService;
import com.urbandroid.sleep.bluetoothle.BluetoothException;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordHypnogram;
import com.urbandroid.sleep.fragment.StatsFragmentNew;
import com.urbandroid.sleep.fragment.dashboard.card.BackupCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailPhasesCard;
import com.urbandroid.sleep.gui.SeekBarPreference;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.service.health.session.idresolver.IdResolver;
import com.urbandroid.sleep.service.matter.MatterManager;
import java.io.InvalidObjectException;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlinx.serialization.UnknownFieldException;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Events$$ExternalSyntheticBUOutline0 implements MediaListActivity.LoadAlbumListener, IdResolver, BackupCard.ImportFinishListener, SeekBarPreference.IFormatter, OnFailureListener, DefaultRingtoneResolveService.DefaultRingtoneCallback, ConnectIQ.IQDeviceEventListener {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Events$$ExternalSyntheticBUOutline0(int i) {
        this.$r8$classId = i;
    }

    public static /* synthetic */ void m(String str, int i, Object obj, int i2, Object obj2) {
        throw new IllegalArgumentException(str + i + obj + i2 + obj2);
    }

    public static /* synthetic */ void m$1(String str, Object obj, Object obj2, Object obj3) {
        throw new KotlinReflectionInternalError(str + obj + obj2 + obj3 + ')');
    }

    public static /* synthetic */ void m$2(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalStateException((str + obj + obj2 + obj3 + '\'').toString());
    }

    public static /* synthetic */ void m$3(String str, Object obj, Object obj2, Object obj3) {
        throw new KotlinReflectionInternalError(str + obj + obj2 + obj3 + ')');
    }

    public static /* synthetic */ void m$4(String str, Object obj, Object obj2, Object obj3) {
        throw new KotlinReflectionInternalError(str + obj + obj2 + obj3);
    }

    @Override // com.urbandroid.sleep.media.MediaListActivity.LoadAlbumListener
    public void finished() {
        Logger.logInfo("Spotify: albums loaded");
    }

    @Override // com.urbandroid.sleep.gui.SeekBarPreference.IFormatter
    public String format(int i) {
        return String.valueOf(i);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        switch (this.$r8$classId) {
            case 9:
                Logger.logSevere("Location failed:", exc);
                break;
            default:
                MatterManager.startCommissioning$lambda$2(exc);
                break;
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.BackupCard.ImportFinishListener
    public void onFinished() {
        StatsFragmentNew.Companion.showNoRecords$lambda$0$3$0();
    }

    @Override // com.urbandroid.sleep.service.health.session.idresolver.IdResolver
    public String resolveId(SleepRecord sleepRecord) {
        switch (this.$r8$classId) {
            case 4:
                return SleepGraphInitializer.lambda$populateHypnogramOrPhases$1(sleepRecord);
            case 5:
                return SleepRecordHypnogram.lambda$computeHypnogramFromImportedEvents$0(sleepRecord);
            default:
                return SleepDetailPhasesCard.bindSleepRecordToView$lambda$0(sleepRecord);
        }
    }

    public static /* synthetic */ void m(int i) {
        throw new UnknownFieldException(i);
    }

    public static /* synthetic */ void m$1(String str) {
        throw new NoSuchElementException(str);
    }

    public static /* synthetic */ void m$2(String str, Object obj) {
        throw new KotlinReflectionInternalError(str + obj);
    }

    public static /* synthetic */ void m$3(String str, Object obj) {
        throw new AssertionError(str + obj);
    }

    public static /* synthetic */ void m(int i, int i2, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(obj);
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void m$1(String str, Object obj) {
        throw new KotlinReflectionInternalError(str + obj);
    }

    public static /* synthetic */ void m$2(String str) {
        throw new IndexOutOfBoundsException(str);
    }

    public static /* synthetic */ void m(int i, String str) throws InvalidObjectException {
        throw new InvalidObjectException(str + i + '.');
    }

    public static /* synthetic */ void m$1(int i, int i2, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(obj);
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void m(String str) {
        throw new BluetoothException(str);
    }

    public static /* synthetic */ void m(String str, float f) {
        throw new IllegalArgumentException(str + f);
    }

    public static /* synthetic */ void m() {
        throw new ClassCastException();
    }

    public static /* synthetic */ void m(String str, Object obj) {
        throw new UnsupportedOperationException(str + obj);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalStateException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void m(Throwable th) {
        throw new IllegalStateException(th);
    }
}
