package com.urbandroid.sleep.domain.shortcut;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.Sleep;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.SleepStarter;
import com.urbandroid.sleep.domain.shortcut.Shortcut;
import com.urbandroid.sleep.media.lullaby.LullabyDialogFragment;
import com.urbandroid.sleep.media.lullaby.LullabyPlayer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H\u0016J\u0006\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020,J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010.\u001a\u00020/H\u0016J\u0006\u00100\u001a\u00020\u000eJ\u0006\u00101\u001a\u00020\u000eJ\u0006\u00102\u001a\u00020\u0005J\u0006\u00103\u001a\u00020\u0005J\u0010\u00104\u001a\u0002052\u0006\u0010&\u001a\u00020'H\u0016J\n\u00106\u001a\u00020\u001aH\u0096\u0080\u0004J\u0014\u00107\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u000109H\u0096\u0082\u0004J\n\u0010:\u001a\u00020\u000eH\u0096\u0080\u0004R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012¨\u0006<"}, d2 = {"Lcom/urbandroid/sleep/domain/shortcut/ShortcutSleep;", "Lcom/urbandroid/sleep/domain/shortcut/Shortcut;", "<init>", "()V", "startTracking", "", "getStartTracking", "()Z", "setStartTracking", "(Z)V", "saveBattery", "getSaveBattery", "setSaveBattery", "alarmInMin", "", "getAlarmInMin", "()I", "setAlarmInMin", "(I)V", "idealAdjust", "getIdealAdjust", "setIdealAdjust", "useIdeal", "getUseIdeal", "setUseIdeal", "lullaby", "", "getLullaby", "()Ljava/lang/String;", "setLullaby", "(Ljava/lang/String;)V", "meditation", "getMeditation", "setMeditation", "lullabyTurnOff", "getLullabyTurnOff", "setLullabyTurnOff", "getIcon", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "getIconSmall", "doesAnything", "hasAlarm", "hasLullaby", "Lcom/urbandroid/sleep/media/lullaby/LullabyPlayer$Lullaby;", "getDisplayName", "getType", "Lcom/urbandroid/sleep/domain/shortcut/Shortcut$Type;", "getIdealPeriodMin", "getPeriod", "isNap", "isSleep", "execute", "", InAppPurchaseConstants.METHOD_TO_STRING, "equals", "other", "", "hashCode", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ShortcutSleep extends Shortcut {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String lullaby;
    private boolean meditation;
    private boolean saveBattery;
    private boolean startTracking;
    private boolean useIdeal;
    private int alarmInMin = -1;
    private int idealAdjust = -1;
    private int lullabyTurnOff = -1;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/domain/shortcut/ShortcutSleep$Companion;", "", "<init>", "()V", "fromString", "Lcom/urbandroid/sleep/domain/shortcut/ShortcutSleep;", "serialized", "", "getDefaults", "", "Lcom/urbandroid/sleep/domain/shortcut/Shortcut;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortcutSleep fromString(String serialized) {
            serialized.getClass();
            try {
                List listSplit$default = StringsKt.split$default(serialized, new String[]{";;;"}, 0, 6);
                ShortcutSleep shortcutSleep = new ShortcutSleep();
                shortcutSleep.setName((String) listSplit$default.get(1));
                shortcutSleep.setStarred(Boolean.parseBoolean((String) listSplit$default.get(2)));
                shortcutSleep.setStartTracking(Boolean.parseBoolean((String) listSplit$default.get(3)));
                shortcutSleep.setSaveBattery(Boolean.parseBoolean((String) listSplit$default.get(4)));
                shortcutSleep.setAlarmInMin(Integer.parseInt((String) listSplit$default.get(5)));
                shortcutSleep.setUseIdeal(Boolean.parseBoolean((String) listSplit$default.get(6)));
                shortcutSleep.setIdealAdjust(Integer.parseInt((String) listSplit$default.get(7)));
                shortcutSleep.setLullaby((String) listSplit$default.get(8));
                if ("null".equals(shortcutSleep.getLullaby())) {
                    shortcutSleep.setLullaby(null);
                }
                shortcutSleep.setMeditation(Boolean.parseBoolean((String) listSplit$default.get(9)));
                shortcutSleep.setLullabyTurnOff(Integer.parseInt((String) listSplit$default.get(10)));
                return shortcutSleep;
            } catch (Exception e) {
                Logger.logSevere(e);
                return null;
            }
        }

        public final List<Shortcut> getDefaults(Context context) {
            context.getClass();
            ShortcutSleep shortcutSleep = new ShortcutSleep();
            shortcutSleep.setStartTracking(true);
            shortcutSleep.setAlarmInMin(90);
            Unit unit = Unit.INSTANCE;
            ShortcutSleep shortcutSleep2 = new ShortcutSleep();
            shortcutSleep2.setStartTracking(true);
            shortcutSleep2.setStarred(true);
            shortcutSleep2.setAlarmInMin(60);
            ShortcutSleep shortcutSleep3 = new ShortcutSleep();
            shortcutSleep3.setStartTracking(true);
            shortcutSleep3.setAlarmInMin(30);
            ShortcutSleep shortcutSleep4 = new ShortcutSleep();
            shortcutSleep4.setStartTracking(true);
            shortcutSleep4.setStarred(true);
            shortcutSleep4.setUseIdeal(true);
            shortcutSleep4.setIdealAdjust(15);
            ShortcutSleep shortcutSleep5 = new ShortcutSleep();
            shortcutSleep5.setStartTracking(true);
            shortcutSleep5.setStarred(true);
            shortcutSleep5.setUseIdeal(true);
            return CollectionsKt.listOf((Object[]) new Shortcut[]{shortcutSleep, shortcutSleep2, shortcutSleep3, shortcutSleep4, shortcutSleep5});
        }

        private Companion() {
        }
    }

    public final boolean doesAnything() {
        return hasAlarm() || hasLullaby() || this.startTracking;
    }

    @Override // com.urbandroid.sleep.domain.shortcut.Shortcut
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShortcutSleep) || !super.equals(other)) {
            return false;
        }
        ShortcutSleep shortcutSleep = (ShortcutSleep) other;
        return this.startTracking == shortcutSleep.startTracking && this.saveBattery == shortcutSleep.saveBattery && this.alarmInMin == shortcutSleep.alarmInMin && this.idealAdjust == shortcutSleep.idealAdjust && this.useIdeal == shortcutSleep.useIdeal && Intrinsics.areEqual(this.lullaby, shortcutSleep.lullaby) && this.meditation == shortcutSleep.meditation && this.lullabyTurnOff == shortcutSleep.lullabyTurnOff;
    }

    @Override // com.urbandroid.sleep.domain.shortcut.Shortcut
    public void execute(Context context) {
        context.getClass();
        Settings settings = new Settings(context);
        if (this.alarmInMin > 0 || this.useIdeal) {
            Alarms.addQuickAlarm(context, getPeriod(), FileInsert$$ExternalSyntheticOutline0.m$1(context.getString(R.string.shortcut), " ", !Intrinsics.areEqual(Shortcut.INSTANCE.getDEFAULT_NAME(), getName()) ? FileInsert$$ExternalSyntheticOutline0.m(": ", getName()) : ""), isNap());
        }
        if (!this.startTracking) {
            if (getLullaby() != LullabyPlayer.Lullaby.NONE) {
                LullabyDialogFragment.startPlayingLullaby(context, getLullaby().toString());
                return;
            }
            return;
        }
        Intent intent = new Intent(context, (Class<?>) Sleep.class);
        intent.setFlags(872415232);
        intent.putExtra("MANUALY_STARTED", true);
        if (this.saveBattery) {
            intent.putExtra("start_in_battery_saving", true);
            intent.putExtra("START_IN_BATTERY_SAVING_MODE", true);
        }
        if (this.meditation && getLullaby() == LullabyPlayer.Lullaby.NONE) {
            this.lullaby = "STORM";
        }
        String str = this.lullaby;
        if (str != null) {
            settings.setMeditationOneTime(this.meditation ? 1 : 0);
            int i = this.lullabyTurnOff;
            if (i != -1) {
                settings.setLullabyVolumeDownAfter(i);
            }
            intent.putExtra("START_LULLABY", str);
        }
        new SleepStarter().startSleep(context, intent, null);
    }

    public final int getAlarmInMin() {
        return this.alarmInMin;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    @Override // com.urbandroid.sleep.domain.shortcut.Shortcut
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getDisplayName(Context context) {
        int i;
        String name;
        context.getClass();
        if (isNap()) {
            i = R.string.button_nap;
        } else {
            if (!isSleep()) {
                String str = this.lullaby;
                if (str != null) {
                    name = LullabyPlayer.Lullaby.valueOf(String.valueOf(str)).getDisplayName(context);
                } else if (Intrinsics.areEqual(getName(), Shortcut.INSTANCE.getDEFAULT_NAME())) {
                    i = R.string.shortcut;
                } else {
                    name = getName();
                }
                return FileInsert$$ExternalSyntheticOutline0.m$1(name, " ", getPeriod() <= 0 ? DateUtil.formatMinutesInHumanLanguage(context, Integer.valueOf(getPeriod())) : "");
            }
            i = R.string.sleep;
        }
        name = context.getString(i);
        return FileInsert$$ExternalSyntheticOutline0.m$1(name, " ", getPeriod() <= 0 ? DateUtil.formatMinutesInHumanLanguage(context, Integer.valueOf(getPeriod())) : "");
    }

    @Override // com.urbandroid.sleep.domain.shortcut.Shortcut
    public int getIcon(Context context) {
        context.getClass();
        return isNap() ? R.drawable.ic_lullaby_clock : isSleep() ? R.drawable.ic_feature_track : this.lullaby != null ? R.drawable.ic_lullaby_all : R.drawable.ic_feature_automagic;
    }

    @Override // com.urbandroid.sleep.domain.shortcut.Shortcut
    public int getIconSmall(Context context) {
        context.getClass();
        return isNap() ? R.drawable.ic_action_snooze : isSleep() ? R.drawable.ic_action_track : this.lullaby != null ? R.drawable.ic_action_lullaby : R.drawable.ic_automagic;
    }

    public final int getIdealAdjust() {
        return this.idealAdjust;
    }

    public final int getIdealPeriodMin() {
        int idealSleepMinutes = SharedApplicationContext.getSettings().getIdealSleepMinutes();
        int smartWakeupMinutes = SharedApplicationContext.getSettings().getSmartWakeupMinutes() != 59 ? SharedApplicationContext.getSettings().getSmartWakeupMinutes() / 2 : 0;
        int trackingDelay = SharedApplicationContext.getSettings().getTrackingDelay();
        int i = idealSleepMinutes + smartWakeupMinutes + (trackingDelay > 60000 ? trackingDelay / 60000 : 0);
        int i2 = this.idealAdjust;
        return i + (i2 != -1 ? i2 : 0);
    }

    public final LullabyPlayer.Lullaby getLullaby() {
        String str = this.lullaby;
        return (str == null || "null".equals(str) || "NONE".equals(this.lullaby)) ? LullabyPlayer.Lullaby.NONE : LullabyPlayer.Lullaby.valueOf(String.valueOf(this.lullaby));
    }

    public final int getLullabyTurnOff() {
        return this.lullabyTurnOff;
    }

    public final boolean getMeditation() {
        return this.meditation;
    }

    public final int getPeriod() {
        return this.useIdeal ? getIdealPeriodMin() : this.alarmInMin;
    }

    public final boolean getSaveBattery() {
        return this.saveBattery;
    }

    public final boolean getStartTracking() {
        return this.startTracking;
    }

    @Override // com.urbandroid.sleep.domain.shortcut.Shortcut
    public Shortcut.Type getType() {
        return Shortcut.Type.SLEEP;
    }

    public final boolean getUseIdeal() {
        return this.useIdeal;
    }

    public final boolean hasAlarm() {
        return this.alarmInMin != -1 || this.useIdeal;
    }

    public final boolean hasLullaby() {
        return getLullaby() != LullabyPlayer.Lullaby.NONE;
    }

    @Override // com.urbandroid.sleep.domain.shortcut.Shortcut
    public int hashCode() {
        int iM = FileInsert$$ExternalSyntheticOutline0.m(this.useIdeal, (((FileInsert$$ExternalSyntheticOutline0.m(this.saveBattery, FileInsert$$ExternalSyntheticOutline0.m(this.startTracking, super.hashCode() * 31, 31), 31) + this.alarmInMin) * 31) + this.idealAdjust) * 31, 31);
        String str = this.lullaby;
        return Integer.hashCode(this.lullabyTurnOff) + FileInsert$$ExternalSyntheticOutline0.m(this.meditation, (iM + (str != null ? str.hashCode() : 0)) * 31, 31);
    }

    public final boolean isNap() {
        int i;
        return (this.useIdeal || (i = this.alarmInMin) > 240 || i == -1) ? false : true;
    }

    public final boolean isSleep() {
        return this.useIdeal || this.alarmInMin > 240 || this.startTracking;
    }

    public final void setAlarmInMin(int i) {
        this.alarmInMin = i;
    }

    public final void setIdealAdjust(int i) {
        this.idealAdjust = i;
    }

    public final void setLullaby(String str) {
        this.lullaby = str;
    }

    public final void setLullabyTurnOff(int i) {
        this.lullabyTurnOff = i;
    }

    public final void setMeditation(boolean z) {
        this.meditation = z;
    }

    public final void setSaveBattery(boolean z) {
        this.saveBattery = z;
    }

    public final void setStartTracking(boolean z) {
        this.startTracking = z;
    }

    public final void setUseIdeal(boolean z) {
        this.useIdeal = z;
    }

    @Override // com.urbandroid.sleep.domain.shortcut.Shortcut
    public String toString() {
        String string = super.toString();
        boolean z = this.startTracking;
        boolean z2 = this.saveBattery;
        int i = this.alarmInMin;
        boolean z3 = this.useIdeal;
        int i2 = this.idealAdjust;
        String str = this.lullaby;
        boolean z4 = this.meditation;
        int i3 = this.lullabyTurnOff;
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append(";;;");
        sb.append(z);
        sb.append(";;;");
        sb.append(z2);
        sb.append(";;;");
        sb.append(i);
        sb.append(";;;");
        sb.append(z3);
        zzba$$ExternalSyntheticOutline0.m(sb, ";;;", i2, ";;;", str);
        sb.append(";;;");
        sb.append(z4);
        sb.append(";;;");
        sb.append(i3);
        return sb.toString();
    }

    public final String getLullaby() {
        return this.lullaby;
    }
}
