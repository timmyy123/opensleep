package com.urbandroid.sleep.domain.achievement;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\tJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\n\u0010 \u001a\u00020\tH\u0096\u0080\u0004J\u0014\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010#\u001a\u00020\u0005H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lcom/urbandroid/sleep/domain/achievement/Achievement;", "", "type", "Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "quantity", "", "<init>", "(Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;I)V", "ser", "", "(Ljava/lang/String;)V", "getType", "()Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "getQuantity", "()I", "setQuantity", "(I)V", "getLevel", "setFixedQuantity", "", "addQuantity", "earned", "fullyCompleted", "isLevel1", "isLevel2", "isLevel3", "getProgressString", "getProgress", "", "getColorRes", "getEarnedLevelIcon", "getNextLevelIcon", InAppPurchaseConstants.METHOD_TO_STRING, "equals", "other", "hashCode", "Companion", "Type", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Achievement {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SEPARATOR = ":";
    private int quantity;
    private final Type type;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005J2\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/domain/achievement/Achievement$Companion;", "", "<init>", "()V", "SEPARATOR", "", "getSEPARATOR", "()Ljava/lang/String;", "parseType", "Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "string", "parseQuantity", "", "bindView", "Landroid/view/ViewGroup;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "layoutRes", "badgesView", "achievement", "Lcom/urbandroid/sleep/domain/achievement/Achievement;", "title", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ViewGroup bindView$default(Companion companion, Context context, int i, ViewGroup viewGroup, Achievement achievement, String str, int i2, Object obj) {
            if ((i2 & 16) != 0) {
                str = null;
            }
            return companion.bindView(context, i, viewGroup, achievement, str);
        }

        public final ViewGroup bindView(Context context, int layoutRes, ViewGroup badgesView, Achievement achievement, String title) {
            TextView textView;
            context.getClass();
            badgesView.getClass();
            achievement.getClass();
            LayoutInflater layoutInflater = InflatorUtil.INSTANCE.get(context);
            View viewInflate = layoutInflater != null ? layoutInflater.inflate(layoutRes, badgesView, false) : null;
            viewInflate.getClass();
            ViewGroup viewGroup = (ViewGroup) viewInflate;
            ((ImageView) viewGroup.findViewById(R.id.icon)).setImageResource(achievement.getType().getIconRes());
            ((ImageView) viewGroup.findViewById(com.urbandroid.sleep.R.id.level)).setImageResource(achievement.getEarnedLevelIcon());
            if (title != null && (textView = (TextView) viewGroup.findViewById(com.urbandroid.sleep.R.id.progressText)) != null) {
                textView.setText(title);
            }
            viewGroup.setContentDescription(achievement.getType().getTitle(context));
            badgesView.addView(viewGroup);
            return viewGroup;
        }

        public final String getSEPARATOR() {
            return Achievement.SEPARATOR;
        }

        public final int parseQuantity(String string) {
            string.getClass();
            return Integer.parseInt((String) StringsKt.split$default(string, new String[]{getSEPARATOR()}, 0, 6).get(1));
        }

        public final Type parseType(String string) {
            string.getClass();
            return Type.valueOf((String) StringsKt.split$default(string, new String[]{getSEPARATOR()}, 0, 6).get(0));
        }

        private Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Achievement(String str) {
        str.getClass();
        Companion companion = INSTANCE;
        this(companion.parseType(str), companion.parseQuantity(str));
    }

    public final boolean addQuantity(int quantity) {
        int level = getLevel();
        this.quantity += quantity;
        return level != getLevel();
    }

    public final boolean earned() {
        return this.quantity >= this.type.getTh1();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Achievement) && this.type == ((Achievement) other).type;
    }

    public final boolean fullyCompleted() {
        return this.quantity >= this.type.getTh3();
    }

    public final int getColorRes() {
        return (isLevel3() || isLevel2()) ? com.urbandroid.sleep.R.color.achievement_level3 : isLevel1() ? com.urbandroid.sleep.R.color.achievement_level2 : com.urbandroid.sleep.R.color.achievement_level1;
    }

    public final int getEarnedLevelIcon() {
        return isLevel3() ? com.urbandroid.sleep.R.drawable.ic_achievement_level3 : isLevel2() ? com.urbandroid.sleep.R.drawable.ic_achievement_level2 : isLevel1() ? com.urbandroid.sleep.R.drawable.ic_achievement_level1 : com.urbandroid.sleep.R.drawable.empty;
    }

    public final int getLevel() {
        if (isLevel3()) {
            return 3;
        }
        if (isLevel2()) {
            return 2;
        }
        return isLevel1() ? 1 : 0;
    }

    public final int getNextLevelIcon() {
        return (isLevel3() || isLevel2()) ? com.urbandroid.sleep.R.drawable.ic_achievement_level3 : isLevel1() ? com.urbandroid.sleep.R.drawable.ic_achievement_level2 : com.urbandroid.sleep.R.drawable.ic_achievement_level1;
    }

    public final float getProgress() {
        float f;
        int th1;
        if (isLevel3()) {
            return 1.0f;
        }
        if (isLevel2()) {
            f = this.quantity;
            th1 = this.type.getTh3();
        } else {
            boolean zIsLevel1 = isLevel1();
            int i = this.quantity;
            if (zIsLevel1) {
                f = i;
                th1 = this.type.getTh2();
            } else {
                f = i;
                th1 = this.type.getTh1();
            }
        }
        return f / th1;
    }

    public final String getProgressString() {
        if (isLevel3()) {
            return String.valueOf(this.quantity);
        }
        if (isLevel2()) {
            return this.quantity + " / " + this.type.getTh3();
        }
        boolean zIsLevel1 = isLevel1();
        int i = this.quantity;
        if (zIsLevel1) {
            return i + " / " + this.type.getTh2();
        }
        return i + " / " + this.type.getTh1();
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public final boolean isLevel1() {
        return this.quantity >= this.type.getTh1();
    }

    public final boolean isLevel2() {
        return this.quantity >= this.type.getTh2();
    }

    public final boolean isLevel3() {
        return this.quantity >= this.type.getTh3();
    }

    public final boolean setFixedQuantity(int quantity) {
        int level = getLevel();
        this.quantity = quantity;
        return level != getLevel();
    }

    public final void setQuantity(int i) {
        this.quantity = i;
    }

    public String toString() {
        return this.type.name() + SEPARATOR + this.quantity;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B?\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/¨\u00060"}, d2 = {"Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "", "", "iconRes", "titleRes", "summaryRes", "th1", "th2", "th3", "<init>", "(Ljava/lang/String;IIIIIII)V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "getTitle", "(Landroid/content/Context;)Ljava/lang/String;", "getSummary", "I", "getIconRes", "()I", "getTitleRes", "getSummaryRes", "getTh1", "getTh2", "getTh3", "TRACK", "SCORE", "SMART_WAKE", "PREMIUM", "SONAR", "LULLABY", "SOUND_RECOGNITION", "GOAL_DURATION", "GOAL_BEDTIME", "GOAL_REGULARITY", "GOAL_AWAKE", "GOAL_DEEP", "GOAL_SNORING", "GOAL_SNOOZE", "WEARABLE", "SMARTLIGHT", "CLOUD", "WAKE_UP_CHECK", "CAPTCHA_MATH", "CAPTCHA_SHEEP", "CAPTCHA_CODE", "CAPTCHA_SMILE", "CAPTCHA_ZOMBIE", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        private final int iconRes;
        private final int summaryRes;
        private final int th1;
        private final int th2;
        private final int th3;
        private final int titleRes;
        public static final Type TRACK = new Type("TRACK", 0, com.urbandroid.sleep.R.drawable.ic_feature_track, com.urbandroid.sleep.R.string.settings_category_track, com.urbandroid.sleep.R.string.market_text_featured, 10, 200, 1000);
        public static final Type SCORE = new Type("SCORE", 1, com.urbandroid.sleep.R.drawable.ic_feature_score, com.urbandroid.sleep.R.string.score, com.urbandroid.sleep.R.string.featured_slogan, 85, 95, 98);
        public static final Type SMART_WAKE = new Type("SMART_WAKE", 2, com.urbandroid.sleep.R.drawable.ic_feature_smart_period, com.urbandroid.sleep.R.string.settings_category_smart, com.urbandroid.sleep.R.string.settings_category_smart_summary, 10, 50, 300);
        public static final Type PREMIUM = new Type("PREMIUM", 3, com.urbandroid.sleep.R.drawable.ic_feature_premium, com.urbandroid.sleep.R.string.upgrade_to_premium, com.urbandroid.sleep.R.string.premium_summary, 1, 1, 1);
        public static final Type SONAR = new Type("SONAR", 4, com.urbandroid.sleep.R.drawable.ic_lullaby_sub, com.urbandroid.sleep.R.string.sensor_sonar, com.urbandroid.sleep.R.string.sonar_explanation, 1, 30, 300);
        public static final Type LULLABY = new Type("LULLABY", 5, com.urbandroid.sleep.R.drawable.ic_lullaby_all, com.urbandroid.sleep.R.string.lullaby, com.urbandroid.sleep.R.string.settings_category_lullaby_summary, 10, 50, 200);
        public static final Type SOUND_RECOGNITION = new SOUND_RECOGNITION("SOUND_RECOGNITION", 6);
        public static final Type GOAL_DURATION = new GOAL_DURATION("GOAL_DURATION", 7);
        public static final Type GOAL_BEDTIME = new GOAL_BEDTIME("GOAL_BEDTIME", 8);
        public static final Type GOAL_REGULARITY = new GOAL_REGULARITY("GOAL_REGULARITY", 9);
        public static final Type GOAL_AWAKE = new GOAL_AWAKE("GOAL_AWAKE", 10);
        public static final Type GOAL_DEEP = new GOAL_DEEP("GOAL_DEEP", 11);
        public static final Type GOAL_SNORING = new GOAL_SNORING("GOAL_SNORING", 12);
        public static final Type GOAL_SNOOZE = new GOAL_SNOOZE("GOAL_SNOOZE", 13);
        public static final Type WEARABLE = new Type("WEARABLE", 14, com.urbandroid.sleep.R.drawable.ic_wearable_rect_watch, com.urbandroid.sleep.R.string.smartwatch_title, com.urbandroid.sleep.R.string.addons_wearables_desc, 1, 30, 300);
        public static final Type SMARTLIGHT = new Type("SMARTLIGHT", 15, com.urbandroid.sleep.R.drawable.ic_feature_smartlight, com.urbandroid.sleep.R.string.sunrise_wakeup, com.urbandroid.sleep.R.string.smartlight_all, 10, 30, 300);
        public static final Type CLOUD = new Type("CLOUD", 16, com.urbandroid.sleep.R.drawable.ic_unlock_cloud_backup, com.urbandroid.sleep.R.string.category_services, com.urbandroid.sleep.R.string.services_summary, 1, 2, 3);
        public static final Type WAKE_UP_CHECK = new Type("WAKE_UP_CHECK", 17, com.urbandroid.sleep.R.drawable.ic_feature_wake_up_check, com.urbandroid.sleep.R.string.settings_wake_up_check, com.urbandroid.sleep.R.string.wake_up_check_expl, 1, 10, 50);
        public static final Type CAPTCHA_MATH = new Type("CAPTCHA_MATH", 18, com.urbandroid.sleep.R.drawable.ic_captcha_simplemathcaptcha, com.urbandroid.sleep.R.string.captcha_simple_math_title, com.urbandroid.sleep.R.string.captcha_preference_summary, 1, 20, 100);
        public static final Type CAPTCHA_SHEEP = new Type("CAPTCHA_SHEEP", 19, com.urbandroid.sleep.R.drawable.ic_captcha_sleepingsheepscaptcha, com.urbandroid.sleep.R.string.captcha_sleeping_sheep_title, com.urbandroid.sleep.R.string.captcha_preference_summary, 1, 20, 100);
        public static final Type CAPTCHA_CODE = new CAPTCHA_CODE("CAPTCHA_CODE", 20);
        public static final Type CAPTCHA_SMILE = new Type("CAPTCHA_SMILE", 21, com.urbandroid.sleep.R.drawable.ic_captcha_smilecaptcha, com.urbandroid.sleep.R.string.captcha_smile_title, com.urbandroid.sleep.R.string.captcha_preference_summary, 1, 20, 100);
        public static final Type CAPTCHA_ZOMBIE = new Type("CAPTCHA_ZOMBIE", 22, com.urbandroid.sleep.R.drawable.ic_captcha_zombiewalkcaptcha, com.urbandroid.sleep.R.string.captcha_zombie, com.urbandroid.sleep.R.string.captcha_preference_summary, 1, 20, 100);

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/urbandroid/sleep/domain/achievement/Achievement.Type.CAPTCHA_CODE", "Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "getTitle", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class CAPTCHA_CODE extends Type {
            public CAPTCHA_CODE(String str, int i) {
                super(str, i, com.urbandroid.sleep.R.drawable.ic_captcha_qrcaptcha, com.urbandroid.sleep.R.string.captcha_qr_code_title, com.urbandroid.sleep.R.string.captcha_preference_summary, 1, 20, 100, null);
            }

            @Override // com.urbandroid.sleep.domain.achievement.Achievement.Type
            public String getTitle(Context context) {
                context.getClass();
                return FileInsert$$ExternalSyntheticOutline0.m$1(context.getString(com.urbandroid.sleep.R.string.captcha_scan), " ", context.getString(com.urbandroid.sleep.R.string.captcha_qr_code_title));
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/urbandroid/sleep/domain/achievement/Achievement.Type.GOAL_AWAKE", "Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "getSummary", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class GOAL_AWAKE extends Type {
            public GOAL_AWAKE(String str, int i) {
                super(str, i, com.urbandroid.sleep.R.drawable.ic_goal_awake, com.urbandroid.sleep.R.string.goal_awake, com.urbandroid.sleep.R.string.awake, 1, 2, 3, null);
            }

            @Override // com.urbandroid.sleep.domain.achievement.Achievement.Type
            public String getSummary(Context context) {
                context.getClass();
                String string = context.getString(com.urbandroid.sleep.R.string.improve);
                String string2 = context.getString(getSummaryRes());
                string2.getClass();
                String lowerCase = string2.toLowerCase(Locale.ROOT);
                return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/urbandroid/sleep/domain/achievement/Achievement.Type.GOAL_BEDTIME", "Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "getSummary", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class GOAL_BEDTIME extends Type {
            public GOAL_BEDTIME(String str, int i) {
                super(str, i, com.urbandroid.sleep.R.drawable.ic_goal_bedtime, com.urbandroid.sleep.R.string.goal_fall_asleep, com.urbandroid.sleep.R.string.time_to_bed_title, 1, 2, 3, null);
            }

            @Override // com.urbandroid.sleep.domain.achievement.Achievement.Type
            public String getSummary(Context context) {
                context.getClass();
                String string = context.getString(com.urbandroid.sleep.R.string.improve);
                String string2 = context.getString(getSummaryRes());
                string2.getClass();
                String lowerCase = string2.toLowerCase(Locale.ROOT);
                return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/urbandroid/sleep/domain/achievement/Achievement.Type.GOAL_DEEP", "Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "getSummary", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class GOAL_DEEP extends Type {
            public GOAL_DEEP(String str, int i) {
                super(str, i, com.urbandroid.sleep.R.drawable.ic_lullaby_whale, com.urbandroid.sleep.R.string.goal_deep_sleep, com.urbandroid.sleep.R.string.label_deep_sleep, 1, 2, 3, null);
            }

            @Override // com.urbandroid.sleep.domain.achievement.Achievement.Type
            public String getSummary(Context context) {
                context.getClass();
                String string = context.getString(com.urbandroid.sleep.R.string.improve);
                String string2 = context.getString(getSummaryRes());
                string2.getClass();
                String lowerCase = string2.toLowerCase(Locale.ROOT);
                return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/urbandroid/sleep/domain/achievement/Achievement.Type.GOAL_DURATION", "Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "getSummary", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class GOAL_DURATION extends Type {
            public GOAL_DURATION(String str, int i) {
                super(str, i, com.urbandroid.sleep.R.drawable.ic_goal_duration, com.urbandroid.sleep.R.string.goal_duration, com.urbandroid.sleep.R.string.stats_caption_sleep, 1, 3, 5, null);
            }

            @Override // com.urbandroid.sleep.domain.achievement.Achievement.Type
            public String getSummary(Context context) {
                context.getClass();
                String string = context.getString(com.urbandroid.sleep.R.string.improve);
                String string2 = context.getString(getSummaryRes());
                string2.getClass();
                String lowerCase = string2.toLowerCase(Locale.ROOT);
                return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/urbandroid/sleep/domain/achievement/Achievement.Type.GOAL_REGULARITY", "Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "getSummary", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class GOAL_REGULARITY extends Type {
            public GOAL_REGULARITY(String str, int i) {
                super(str, i, com.urbandroid.sleep.R.drawable.ic_goal_regularity, com.urbandroid.sleep.R.string.goal_regularity, com.urbandroid.sleep.R.string.sleep_variance, 1, 2, 3, null);
            }

            @Override // com.urbandroid.sleep.domain.achievement.Achievement.Type
            public String getSummary(Context context) {
                context.getClass();
                String string = context.getString(com.urbandroid.sleep.R.string.improve);
                String string2 = context.getString(getSummaryRes());
                string2.getClass();
                String lowerCase = string2.toLowerCase(Locale.ROOT);
                return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/urbandroid/sleep/domain/achievement/Achievement.Type.GOAL_SNOOZE", "Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "getSummary", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class GOAL_SNOOZE extends Type {
            public GOAL_SNOOZE(String str, int i) {
                super(str, i, com.urbandroid.sleep.R.drawable.ic_sound_cockoo, com.urbandroid.sleep.R.string.goal_snooze, com.urbandroid.sleep.R.string.alarm_alert_snooze_text, 1, 2, 3, null);
            }

            @Override // com.urbandroid.sleep.domain.achievement.Achievement.Type
            public String getSummary(Context context) {
                context.getClass();
                String string = context.getString(com.urbandroid.sleep.R.string.improve);
                String string2 = context.getString(getSummaryRes());
                string2.getClass();
                String lowerCase = string2.toLowerCase(Locale.ROOT);
                return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/urbandroid/sleep/domain/achievement/Achievement.Type.GOAL_SNORING", "Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "getSummary", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class GOAL_SNORING extends Type {
            public GOAL_SNORING(String str, int i) {
                super(str, i, com.urbandroid.sleep.R.drawable.ic_goal_snoring, com.urbandroid.sleep.R.string.goal_snoring, com.urbandroid.sleep.R.string.stats_caption_snore, 1, 2, 3, null);
            }

            @Override // com.urbandroid.sleep.domain.achievement.Achievement.Type
            public String getSummary(Context context) {
                context.getClass();
                String string = context.getString(com.urbandroid.sleep.R.string.improve);
                String string2 = context.getString(getSummaryRes());
                string2.getClass();
                String lowerCase = string2.toLowerCase(Locale.ROOT);
                return FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase, string, " ", lowerCase);
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/urbandroid/sleep/domain/achievement/Achievement.Type.SOUND_RECOGNITION", "Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "getSummary", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class SOUND_RECOGNITION extends Type {
            public SOUND_RECOGNITION(String str, int i) {
                super(str, i, com.urbandroid.sleep.R.drawable.ic_feature_sound_recognition, com.urbandroid.sleep.R.string.sound_recognition, com.urbandroid.sleep.R.string.sound_recognition, 10, 50, 200, null);
            }

            @Override // com.urbandroid.sleep.domain.achievement.Achievement.Type
            public String getSummary(Context context) {
                context.getClass();
                String string = context.getString(com.urbandroid.sleep.R.string.stats_caption_snore);
                String string2 = context.getString(com.urbandroid.sleep.R.string.sound_sick);
                String string3 = context.getString(com.urbandroid.sleep.R.string.sound_laughter);
                String string4 = context.getString(com.urbandroid.sleep.R.string.sound_baby_cry);
                String string5 = context.getString(com.urbandroid.sleep.R.string.sleep_talk);
                StringBuilder sbM66m = Fragment$$ExternalSyntheticOutline1.m66m(string, ", ", string2, ", ", string3);
                FileInsert$$ExternalSyntheticOutline0.m(sbM66m, ", ", string4, ", ", string5);
                sbM66m.append("...");
                return sbM66m.toString();
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{TRACK, SCORE, SMART_WAKE, PREMIUM, SONAR, LULLABY, SOUND_RECOGNITION, GOAL_DURATION, GOAL_BEDTIME, GOAL_REGULARITY, GOAL_AWAKE, GOAL_DEEP, GOAL_SNORING, GOAL_SNOOZE, WEARABLE, SMARTLIGHT, CLOUD, WAKE_UP_CHECK, CAPTCHA_MATH, CAPTCHA_SHEEP, CAPTCHA_CODE, CAPTCHA_SMILE, CAPTCHA_ZOMBIE};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        private Type(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.iconRes = i2;
            this.titleRes = i3;
            this.summaryRes = i4;
            this.th1 = i5;
            this.th2 = i6;
            this.th3 = i7;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public String getSummary(Context context) {
            context.getClass();
            String string = context.getString(this.summaryRes);
            string.getClass();
            return string;
        }

        public final int getSummaryRes() {
            return this.summaryRes;
        }

        public final int getTh1() {
            return this.th1;
        }

        public final int getTh2() {
            return this.th2;
        }

        public final int getTh3() {
            return this.th3;
        }

        public String getTitle(Context context) {
            context.getClass();
            String string = context.getString(this.titleRes);
            string.getClass();
            return string;
        }

        public /* synthetic */ Type(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, i2, i3, i4, i5, i6, i7);
        }
    }

    public Achievement(Type type, int i) {
        type.getClass();
        this.type = type;
        this.quantity = i;
    }
}
