package com.urbandroid.sleep.alarmclock;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.squareup.kotlinpoet.TypeSpec$$ExternalSyntheticLambda0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.string.StringUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.media.MediaListAdapter$$ExternalSyntheticLambda3;
import com.urbandroid.sleep.prefs.NonDialogPreference;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001MB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001d\u0010\u0012J\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b)\u0010%J\u0019\u0010*\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b*\u0010%J!\u0010-\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\n2\b\b\u0001\u0010,\u001a\u00020\u001eH\u0002¢\u0006\u0004\b-\u0010.J\u0019\u00101\u001a\u0004\u0018\u00010\u00132\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00103R\u0016\u00104\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u001e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b6\u00105R\u001a\u00108\u001a\u0002078\u0006X\u0086D¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0017\u0010A\u001a\u00020@8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR*\u0010\u0018\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010\u001a¨\u0006N"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/RepeatChipPreference;", "Lcom/urbandroid/sleep/prefs/NonDialogPreference;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "onCreateView", "(Landroid/view/ViewGroup;)Landroid/view/View;", "", "isRepeating", "()Z", "", "callChangeListenerWithDebounce", "()V", "Lcom/urbandroid/sleep/alarmclock/RepeatChipPreference$RepeatMode;", "mode", "changeMode", "(Lcom/urbandroid/sleep/alarmclock/RepeatChipPreference$RepeatMode;)V", "Lcom/urbandroid/sleep/alarmclock/Alarm$DaysOfWeek;", "daysOfWeek", "updateUIControls", "(Lcom/urbandroid/sleep/alarmclock/Alarm$DaysOfWeek;)V", "updateChipsUI", "updateNonweeklyDayCountUI", "setMinNonweeklyDayCount", "", "getMinNonweeklyDays", "(Lcom/urbandroid/sleep/alarmclock/Alarm$DaysOfWeek;)I", "getRepeatMode", "(Lcom/urbandroid/sleep/alarmclock/Alarm$DaysOfWeek;)Lcom/urbandroid/sleep/alarmclock/RepeatChipPreference$RepeatMode;", ViewHierarchyConstants.VIEW_KEY, "initNonweeklyControl", "(Landroid/view/View;)V", "", "getNonWeeklyFromDayTime", "()J", "initDayOfWeekChips", "initModeSelectChip", "v", "menuRes", "showModeMenu", "(Landroid/view/View;I)V", "Landroid/view/MenuItem;", "menuItem", "menuItemToMode", "(Landroid/view/MenuItem;)Lcom/urbandroid/sleep/alarmclock/RepeatChipPreference$RepeatMode;", "Landroid/content/Context;", "minNonweeklyDays", "I", "maxNonweeklyDays", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lcom/google/android/material/button/MaterialButton;", "dayOfWeekChips", "Ljava/util/ArrayList;", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "getH", "()Landroid/os/Handler;", "Ljava/lang/Runnable;", "preferenceChangeRunnable", "Ljava/lang/Runnable;", SDKConstants.PARAM_VALUE, "Lcom/urbandroid/sleep/alarmclock/Alarm$DaysOfWeek;", "getDaysOfWeek", "()Lcom/urbandroid/sleep/alarmclock/Alarm$DaysOfWeek;", "setDaysOfWeek", "RepeatMode", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RepeatChipPreference extends NonDialogPreference {
    private final Context context;
    private ArrayList<MaterialButton> dayOfWeekChips;
    private Alarm.DaysOfWeek daysOfWeek;
    private final Handler h;
    private final int maxNonweeklyDays;
    private int minNonweeklyDays;
    private final Runnable preferenceChangeRunnable;
    private final String tag;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/RepeatChipPreference$RepeatMode;", "", "", "titleRes", "<init>", "(Ljava/lang/String;II)V", "Landroid/content/Context;", "ctx", "", "getTitleWithBiweeklyHint", "(Landroid/content/Context;)Ljava/lang/String;", "I", "getTitleRes", "()I", "NO_REPEAT", "WEEKLY", "ODD_WEEKS", "EVEN_WEEKS", "NON_WEEKLY", "DAY_OF_MONTH", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class RepeatMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RepeatMode[] $VALUES;
        private final int titleRes;
        public static final RepeatMode NO_REPEAT = new RepeatMode("NO_REPEAT", 0, R.string.one_time);
        public static final RepeatMode WEEKLY = new RepeatMode("WEEKLY", 1, R.string.weekly);
        public static final RepeatMode ODD_WEEKS = new RepeatMode("ODD_WEEKS", 2, R.string.odd);
        public static final RepeatMode EVEN_WEEKS = new RepeatMode("EVEN_WEEKS", 3, R.string.even);
        public static final RepeatMode NON_WEEKLY = new RepeatMode("NON_WEEKLY", 4, R.string.non_weekly);
        public static final RepeatMode DAY_OF_MONTH = new RepeatMode("DAY_OF_MONTH", 5, R.string.day_of_month);

        private static final /* synthetic */ RepeatMode[] $values() {
            return new RepeatMode[]{NO_REPEAT, WEEKLY, ODD_WEEKS, EVEN_WEEKS, NON_WEEKLY, DAY_OF_MONTH};
        }

        static {
            RepeatMode[] repeatModeArr$values = $values();
            $VALUES = repeatModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(repeatModeArr$values);
        }

        private RepeatMode(String str, int i, int i2) {
            this.titleRes = i2;
        }

        public static RepeatMode valueOf(String str) {
            return (RepeatMode) Enum.valueOf(RepeatMode.class, str);
        }

        public static RepeatMode[] values() {
            return (RepeatMode[]) $VALUES.clone();
        }

        public final String getTitleWithBiweeklyHint(Context ctx) {
            ctx.getClass();
            if (this == ODD_WEEKS) {
                boolean zIsWeekOdd = Alarm.DaysOfWeek.isWeekOdd(ctx, Calendar.getInstance());
                int i = this.titleRes;
                return zIsWeekOdd ? FileInsert$$ExternalSyntheticOutline0.m(ctx.getString(i), " (", ctx.getString(R.string.this_week), ")") : FileInsert$$ExternalSyntheticOutline0.m(ctx.getString(i), " (", ctx.getString(R.string.next_week), ")");
            }
            if (this == EVEN_WEEKS) {
                boolean zIsWeekOdd2 = Alarm.DaysOfWeek.isWeekOdd(ctx, Calendar.getInstance());
                int i2 = this.titleRes;
                return zIsWeekOdd2 ? FileInsert$$ExternalSyntheticOutline0.m(ctx.getString(i2), " (", ctx.getString(R.string.next_week), ")") : FileInsert$$ExternalSyntheticOutline0.m(ctx.getString(i2), " (", ctx.getString(R.string.this_week), ")");
            }
            String string = ctx.getString(this.titleRes);
            string.getClass();
            return string;
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RepeatMode.values().length];
            try {
                iArr[RepeatMode.NO_REPEAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RepeatMode.NON_WEEKLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RepeatMode.DAY_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RepeatMode.WEEKLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RepeatMode.ODD_WEEKS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RepeatMode.EVEN_WEEKS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepeatChipPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
        this.context = context;
        setPersistent(false);
        setLayoutResource(R.layout.preference_repeat_chip_group);
        this.minNonweeklyDays = 2;
        this.maxNonweeklyDays = 31;
        this.tag = "RepeatChipPreference";
        this.dayOfWeekChips = new ArrayList<>();
        this.h = new Handler();
        this.preferenceChangeRunnable = new AlarmActivity$$ExternalSyntheticLambda0(this, 3);
        this.daysOfWeek = new Alarm.DaysOfWeek(0);
    }

    private final void callChangeListenerWithDebounce() {
        this.h.removeCallbacks(this.preferenceChangeRunnable);
        this.h.postDelayed(this.preferenceChangeRunnable, 500L);
    }

    private final void changeMode(RepeatMode mode) {
        Logger.logInfo("Repeat: MODE change mode " + mode);
        View view = getView();
        Button button = view != null ? (Button) view.findViewById(R.id.from) : null;
        switch (WhenMappings.$EnumSwitchMapping$0[mode.ordinal()]) {
            case 1:
                this.daysOfWeek.resetNonWeekly();
                this.daysOfWeek.setWeekRepeat(0);
                this.daysOfWeek.clearDays();
                break;
            case 2:
                long nonWeeklyFromDayTime = getNonWeeklyFromDayTime();
                this.daysOfWeek.setNonWeekly(nonWeeklyFromDayTime, this.minNonweeklyDays);
                if (button != null) {
                    button.setText(DateUtil.getDayHumanReadable(this.context, new Date(nonWeeklyFromDayTime)));
                }
                break;
            case 3:
                Calendar calendar = Calendar.getInstance();
                calendar.add(5, 1);
                this.daysOfWeek.setNonWeekly(Alarm.DaysOfWeek.NON_WEEKLY_START_OF_MONTH, calendar.get(5));
                break;
            case 4:
                this.daysOfWeek.resetNonWeekly();
                this.daysOfWeek.setWeekRepeat(0);
                break;
            case 5:
                this.daysOfWeek.resetNonWeekly();
                this.daysOfWeek.setWeekRepeat(1);
                break;
            case 6:
                this.daysOfWeek.resetNonWeekly();
                this.daysOfWeek.setWeekRepeat(2);
                break;
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return;
        }
        updateUIControls(this.daysOfWeek);
    }

    private final int getMinNonweeklyDays(Alarm.DaysOfWeek daysOfWeek) {
        if (daysOfWeek.isNonWeeklyDayOfMonth()) {
            return 1;
        }
        return this.minNonweeklyDays;
    }

    private final long getNonWeeklyFromDayTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 2);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.set(14, -1);
        return calendar.getTimeInMillis();
    }

    private final RepeatMode getRepeatMode(Alarm.DaysOfWeek daysOfWeek) {
        if (!daysOfWeek.isRepeatSet()) {
            return RepeatMode.NO_REPEAT;
        }
        if (daysOfWeek.isNonWeekly()) {
            return daysOfWeek.getNonWeeklyFrom() == Alarm.DaysOfWeek.NON_WEEKLY_START_OF_MONTH ? RepeatMode.DAY_OF_MONTH : RepeatMode.NON_WEEKLY;
        }
        int weekRepeat = daysOfWeek.getWeekRepeat();
        return weekRepeat != 0 ? weekRepeat != 1 ? weekRepeat != 2 ? RepeatMode.WEEKLY : RepeatMode.EVEN_WEEKS : RepeatMode.ODD_WEEKS : RepeatMode.WEEKLY;
    }

    private final void initDayOfWeekChips(View view) {
        if (view != null) {
        }
        ViewGroup viewGroup = view != null ? (ViewGroup) view.findViewById(R.id.daysGroupContainer) : null;
        LayoutInflater layoutInflater = InflatorUtil.INSTANCE.get(this.context);
        ArrayList<Pair<String, Integer>> calendarWeekdaysWithShorterNamesStartingWithSystemFirstDayOfWeek = DateUtil.getCalendarWeekdaysWithShorterNamesStartingWithSystemFirstDayOfWeek();
        calendarWeekdaysWithShorterNamesStartingWithSystemFirstDayOfWeek.getClass();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(calendarWeekdaysWithShorterNamesStartingWithSystemFirstDayOfWeek, 10));
        Iterator<T> it = calendarWeekdaysWithShorterNamesStartingWithSystemFirstDayOfWeek.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            View viewInflate = layoutInflater.inflate(R.layout.preference_repeat_chip, (ViewGroup) null);
            viewInflate.getClass();
            ViewGroup viewGroup2 = (ViewGroup) viewInflate;
            viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            View childAt = viewGroup2.getChildAt(0);
            childAt.getClass();
            MaterialButton materialButton = (MaterialButton) childAt;
            materialButton.setText((CharSequence) pair.first);
            Object obj = pair.second;
            obj.getClass();
            materialButton.setId(((Number) obj).intValue());
            if (viewGroup != null) {
                viewGroup.addView(viewGroup2);
            }
            this.dayOfWeekChips.add(materialButton);
            materialButton.setOnClickListener(new RepeatChipPreference$$ExternalSyntheticLambda1(this, 1));
            arrayList.add(Unit.INSTANCE);
        }
        updateChipsUI(this.daysOfWeek);
        this.daysOfWeek.stashDays();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDayOfWeekChips$lambda$0$0(RepeatChipPreference repeatChipPreference, View view) {
        RepeatMode repeatMode = repeatChipPreference.getRepeatMode(repeatChipPreference.daysOfWeek);
        int id = view.getId();
        boolean zIsChecked = ((MaterialButton) view).isChecked();
        repeatChipPreference.daysOfWeek.setCalendarDay(id, zIsChecked);
        Logger.logInfo("Repeat: MODE click " + zIsChecked + " " + repeatChipPreference.getRepeatMode(repeatChipPreference.daysOfWeek));
        if (zIsChecked && repeatMode == RepeatMode.NO_REPEAT) {
            repeatChipPreference.changeMode(RepeatMode.WEEKLY);
        } else if (!zIsChecked && !repeatChipPreference.daysOfWeek.isRepeatSet()) {
            repeatChipPreference.changeMode(RepeatMode.NO_REPEAT);
        }
        repeatChipPreference.daysOfWeek.stashDays();
        repeatChipPreference.callChangeListenerWithDebounce();
    }

    private final void initModeSelectChip(View view) {
        Chip chip = view != null ? (Chip) view.findViewById(R.id.modeSelectChip) : null;
        if (chip != null) {
            chip.setOnClickListener(new RepeatChipPreference$$ExternalSyntheticLambda1(this, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initModeSelectChip$lambda$0(RepeatChipPreference repeatChipPreference, View view) {
        view.getClass();
        repeatChipPreference.showModeMenu(view, R.menu.preference_repeat_chip_menu);
    }

    private final void initNonweeklyControl(View view) {
        final MaterialButton materialButton = view != null ? (MaterialButton) view.findViewById(R.id.nonweeklyMinusBtn) : null;
        final MaterialButton materialButton2 = view != null ? (MaterialButton) view.findViewById(R.id.nonweeklyPlusBtn) : null;
        if (materialButton != null) {
            final int i = 0;
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.RepeatChipPreference$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i2 = i;
                    RepeatChipPreference repeatChipPreference = this;
                    MaterialButton materialButton3 = materialButton;
                    switch (i2) {
                        case 0:
                            RepeatChipPreference.initNonweeklyControl$lambda$0(materialButton3, repeatChipPreference, view2);
                            break;
                        default:
                            RepeatChipPreference.initNonweeklyControl$lambda$1(materialButton3, repeatChipPreference, view2);
                            break;
                    }
                }
            });
        }
        if (materialButton2 != null) {
            final int i2 = 1;
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.RepeatChipPreference$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i22 = i2;
                    RepeatChipPreference repeatChipPreference = this;
                    MaterialButton materialButton3 = materialButton2;
                    switch (i22) {
                        case 0:
                            RepeatChipPreference.initNonweeklyControl$lambda$0(materialButton3, repeatChipPreference, view2);
                            break;
                        default:
                            RepeatChipPreference.initNonweeklyControl$lambda$1(materialButton3, repeatChipPreference, view2);
                            break;
                    }
                }
            });
        }
        updateNonweeklyDayCountUI(this.daysOfWeek);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNonweeklyControl$lambda$0(MaterialButton materialButton, RepeatChipPreference repeatChipPreference, View view) {
        materialButton.setChecked(false);
        repeatChipPreference.daysOfWeek.setNonWeeklyRepeat(Math.max(r1.getNonWeeklyRepeat() - 1, repeatChipPreference.getMinNonweeklyDays(repeatChipPreference.daysOfWeek)));
        repeatChipPreference.callChangeListenerWithDebounce();
        repeatChipPreference.updateNonweeklyDayCountUI(repeatChipPreference.daysOfWeek);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNonweeklyControl$lambda$1(MaterialButton materialButton, RepeatChipPreference repeatChipPreference, View view) {
        materialButton.setChecked(false);
        Alarm.DaysOfWeek daysOfWeek = repeatChipPreference.daysOfWeek;
        daysOfWeek.setNonWeeklyRepeat(Integer.min(daysOfWeek.getNonWeeklyRepeat() + 1, repeatChipPreference.maxNonweeklyDays));
        repeatChipPreference.callChangeListenerWithDebounce();
        repeatChipPreference.updateNonweeklyDayCountUI(repeatChipPreference.daysOfWeek);
    }

    private final RepeatMode menuItemToMode(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.day_of_month /* 2131362147 */:
                return RepeatMode.DAY_OF_MONTH;
            case R.id.none /* 2131362669 */:
                return RepeatMode.NO_REPEAT;
            case R.id.nonweekly /* 2131362670 */:
                return RepeatMode.NON_WEEKLY;
            case R.id.week_all /* 2131363299 */:
                return RepeatMode.WEEKLY;
            case R.id.week_even /* 2131363300 */:
                return RepeatMode.EVEN_WEEKS;
            case R.id.week_odd /* 2131363301 */:
                return RepeatMode.ODD_WEEKS;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preferenceChangeRunnable$lambda$0(RepeatChipPreference repeatChipPreference) {
        repeatChipPreference.callChangeListener(repeatChipPreference.daysOfWeek);
    }

    private final void setMinNonweeklyDayCount() {
        if (!this.daysOfWeek.isNonWeekly() || this.daysOfWeek.getNonWeeklyRepeat() >= getMinNonweeklyDays(this.daysOfWeek)) {
            return;
        }
        this.daysOfWeek.setNonWeekly(getNonWeeklyFromDayTime(), getMinNonweeklyDays(this.daysOfWeek));
    }

    private final void showModeMenu(View v, int menuRes) {
        PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
        popupMenu.getMenuInflater().inflate(menuRes, popupMenu.getMenu());
        popupMenu.getMenu().findItem(R.id.week_odd).setTitle(RepeatMode.ODD_WEEKS.getTitleWithBiweeklyHint(this.context));
        popupMenu.getMenu().findItem(R.id.week_even).setTitle(RepeatMode.EVEN_WEEKS.getTitleWithBiweeklyHint(this.context));
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.urbandroid.sleep.alarmclock.RepeatChipPreference$$ExternalSyntheticLambda8
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return RepeatChipPreference.showModeMenu$lambda$0(this.f$0, menuItem);
            }
        });
        popupMenu.setOnDismissListener(new RepeatChipPreference$$ExternalSyntheticLambda9());
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showModeMenu$lambda$0(RepeatChipPreference repeatChipPreference, MenuItem menuItem) {
        menuItem.getClass();
        RepeatMode repeatModeMenuItemToMode = repeatChipPreference.menuItemToMode(menuItem);
        if (repeatModeMenuItemToMode == null) {
            return true;
        }
        if (repeatModeMenuItemToMode == RepeatMode.NO_REPEAT || repeatModeMenuItemToMode == RepeatMode.NON_WEEKLY || repeatModeMenuItemToMode == RepeatMode.DAY_OF_MONTH) {
            repeatChipPreference.daysOfWeek.stashDays();
        } else {
            repeatChipPreference.daysOfWeek.unstashDays();
        }
        repeatChipPreference.changeMode(repeatModeMenuItemToMode);
        repeatChipPreference.updateUIControls(repeatChipPreference.daysOfWeek);
        repeatChipPreference.callChangeListenerWithDebounce();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showModeMenu$lambda$1(PopupMenu popupMenu) {
    }

    private final void updateChipsUI(Alarm.DaysOfWeek daysOfWeek) {
        ArrayList<MaterialButton> arrayList = this.dayOfWeekChips;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (MaterialButton materialButton : arrayList) {
            materialButton.setChecked(daysOfWeek.isCalendarDaySet(materialButton.getId()));
            arrayList2.add(Unit.INSTANCE);
        }
    }

    private final void updateNonweeklyDayCountUI(Alarm.DaysOfWeek daysOfWeek) {
        setMinNonweeklyDayCount();
        View view = getView();
        Button button = view != null ? (Button) view.findViewById(R.id.nonweeklyValueBtn) : null;
        if (button != null) {
            String strCountOrder = StringUtil.countOrder(button.getContext(), daysOfWeek.getNonWeeklyRepeat());
            String string = this.context.getString(R.string.stats_caption_day);
            string.getClass();
            String lowerCase = string.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            button.setText(strCountOrder + " " + lowerCase);
        }
        View view2 = getView();
        Button button2 = view2 != null ? (Button) view2.findViewById(R.id.nonweeklyMinusBtn) : null;
        View view3 = getView();
        Button button3 = view3 != null ? (Button) view3.findViewById(R.id.nonweeklyPlusBtn) : null;
        if (daysOfWeek.getNonWeeklyRepeat() <= getMinNonweeklyDays(daysOfWeek)) {
            if (button2 != null) {
                button2.setEnabled(false);
            }
            if (button3 != null) {
                button3.setEnabled(true);
                return;
            }
            return;
        }
        if (daysOfWeek.getNonWeeklyRepeat() >= this.maxNonweeklyDays) {
            if (button2 != null) {
                button2.setEnabled(true);
            }
            if (button3 != null) {
                button3.setEnabled(false);
                return;
            }
            return;
        }
        if (button2 != null) {
            button2.setEnabled(true);
        }
        if (button3 != null) {
            button3.setEnabled(true);
        }
    }

    private final void updateUIControls(Alarm.DaysOfWeek daysOfWeek) {
        RepeatMode repeatMode = getRepeatMode(daysOfWeek);
        Logger.logInfo("Repeat: update UI '" + repeatMode.getTitleWithBiweeklyHint(this.context) + "' '" + daysOfWeek.toString(this.context, true) + "'");
        View view = getView();
        Chip chip = view != null ? (Chip) view.findViewById(R.id.modeSelectChip) : null;
        if (chip != null) {
            chip.setText(repeatMode.getTitleWithBiweeklyHint(this.context));
        }
        View view2 = getView();
        ChipGroup chipGroup = view2 != null ? (ChipGroup) view2.findViewById(R.id.daysGroup) : null;
        View view3 = getView();
        ViewGroup viewGroup = view3 != null ? (ViewGroup) view3.findViewById(R.id.nonweeklyGroup) : null;
        View view4 = getView();
        MaterialButton materialButton = view4 != null ? (MaterialButton) view4.findViewById(R.id.from) : null;
        if (daysOfWeek.getNonWeeklyFrom() != -1) {
            if (materialButton != null) {
                materialButton.setText(DateUtil.getDayHumanReadable(this.context, new Date(daysOfWeek.getNonWeeklyFrom())));
            }
        } else if (materialButton != null) {
            materialButton.setText(this.context.getText(R.string.tomorrow));
        }
        if (materialButton != null) {
            materialButton.setOnClickListener(new MediaListAdapter$$ExternalSyntheticLambda3(materialButton, this, daysOfWeek, 2));
        }
        View view5 = getView();
        TextView textView = view5 != null ? (TextView) view5.findViewById(R.id.textBefore) : null;
        switch (WhenMappings.$EnumSwitchMapping$0[repeatMode.ordinal()]) {
            case 1:
                if (chipGroup != null) {
                    chipGroup.setVisibility(0);
                }
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                }
                updateChipsUI(daysOfWeek);
                break;
            case 2:
                updateNonweeklyDayCountUI(daysOfWeek);
                if (materialButton != null) {
                    materialButton.setVisibility(0);
                }
                if (textView != null) {
                    textView.setVisibility(0);
                }
                if (textView != null) {
                    String string = textView.getContext().getString(R.string.every);
                    string.getClass();
                    String lowerCase = string.toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                    textView.setText("+ ".concat(lowerCase));
                }
                if (chipGroup != null) {
                    chipGroup.setVisibility(8);
                }
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                break;
            case 3:
                updateNonweeklyDayCountUI(daysOfWeek);
                if (textView != null) {
                    textView.setVisibility(8);
                }
                if (materialButton != null) {
                    materialButton.setVisibility(8);
                }
                if (materialButton != null) {
                    materialButton.setVisibility(8);
                }
                if (chipGroup != null) {
                    chipGroup.setVisibility(8);
                }
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                break;
            case 4:
            case 5:
            case 6:
                if (chipGroup != null) {
                    chipGroup.setVisibility(0);
                }
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                }
                updateChipsUI(daysOfWeek);
                break;
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateUIControls$lambda$0(MaterialButton materialButton, RepeatChipPreference repeatChipPreference, Alarm.DaysOfWeek daysOfWeek, View view) {
        materialButton.setChecked(false);
        MaterialDatePicker.Builder<Long> builderDatePicker = MaterialDatePicker.Builder.datePicker();
        builderDatePicker.getClass();
        String string = repeatChipPreference.context.getString(R.string.every);
        String strCountOrder = StringUtil.countOrder(repeatChipPreference.context, daysOfWeek.getNonWeeklyRepeat());
        String string2 = repeatChipPreference.context.getString(R.string.stats_caption_day);
        string2.getClass();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        lowerCase.getClass();
        String string3 = repeatChipPreference.context.getString(R.string.before);
        string3.getClass();
        String lowerCase2 = string3.toLowerCase(locale);
        lowerCase2.getClass();
        String string4 = repeatChipPreference.context.getString(R.string.after_time, "");
        string4.getClass();
        String lowerCase3 = string4.toLowerCase(locale);
        lowerCase3.getClass();
        builderDatePicker.setTitleText(Fragment$$ExternalSyntheticOutline1.m(Fragment$$ExternalSyntheticOutline1.m66m(string, " ", strCountOrder, " ", lowerCase), " ", lowerCase2, " / ", lowerCase3));
        MaterialDatePicker<Long> materialDatePickerBuild = builderDatePicker.build();
        materialDatePickerBuild.getClass();
        int i = 1;
        materialDatePickerBuild.addOnPositiveButtonClickListener(new SetAlarm$$ExternalSyntheticLambda22(new TypeSpec$$ExternalSyntheticLambda0(daysOfWeek, materialButton, repeatChipPreference, i), i));
        Context context = repeatChipPreference.context;
        context.getClass();
        materialDatePickerBuild.show(((AppCompatActivity) context).getSupportFragmentManager(), builderDatePicker.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUIControls$lambda$0$0(Alarm.DaysOfWeek daysOfWeek, MaterialButton materialButton, RepeatChipPreference repeatChipPreference, Long l) {
        if (l != null) {
            long jLongValue = l.longValue();
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTF"));
            calendar2.setTimeInMillis(jLongValue);
            calendar.set(1, calendar2.get(1));
            calendar.set(2, calendar2.get(2));
            calendar.set(5, calendar2.get(5));
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(14, 0);
            long timeInMillis = calendar.getTimeInMillis();
            daysOfWeek.setNonWeeklyFrom(timeInMillis);
            materialButton.setText(DateUtil.getDayHumanReadable(repeatChipPreference.context, new Date(timeInMillis)));
            repeatChipPreference.callChangeListenerWithDebounce();
            repeatChipPreference.updateNonweeklyDayCountUI(daysOfWeek);
        }
        return Unit.INSTANCE;
    }

    public final Alarm.DaysOfWeek getDaysOfWeek() {
        return this.daysOfWeek;
    }

    public final boolean isRepeating() {
        return this.daysOfWeek.isRepeatSet();
    }

    @Override // com.urbandroid.sleep.prefs.NonDialogPreference, android.preference.Preference
    public View onCreateView(ViewGroup parent) {
        setView(super.onCreateView(parent));
        initDayOfWeekChips(getView());
        initNonweeklyControl(getView());
        initModeSelectChip(getView());
        updateUIControls(this.daysOfWeek);
        View view = getView();
        view.getClass();
        return view;
    }

    public final void setDaysOfWeek(Alarm.DaysOfWeek daysOfWeek) {
        daysOfWeek.getClass();
        Alarm.DaysOfWeek daysOfWeek2 = new Alarm.DaysOfWeek(daysOfWeek);
        this.daysOfWeek = daysOfWeek2;
        zza$$ExternalSyntheticOutline0.m("Repeat: SET daysOfWeek ", daysOfWeek2.toString(this.context, true));
        updateUIControls(daysOfWeek);
    }
}
