package com.urbandroid.sleep.fragment.preview;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.res.Resources;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.fragment.app.FragmentActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.UnlockReviewProvider;
import com.urbandroid.sleep.fragment.preview.TinderPreviewPage;
import com.urbandroid.sleep.service.PrefStore;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/fragment/preview/FirstUsePreviewFragment;", "Lcom/urbandroid/sleep/fragment/preview/AbstractPreviewFragment;", "<init>", "()V", "getLayout", "", "getPages", "", "Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "c", "Landroid/content/Context;", "r", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "resource", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FirstUsePreviewFragment extends AbstractPreviewFragment {
    private final String r(Context context, int resource) {
        String string = context.getString(resource);
        string.getClass();
        return string;
    }

    @Override // com.urbandroid.sleep.fragment.preview.AbstractPreviewFragment
    public int getLayout() {
        return R.layout.fragment_preview;
    }

    @Override // com.urbandroid.sleep.fragment.preview.AbstractPreviewFragment
    public List<PreviewPage> getPages(final Context c) {
        List listEmptyList;
        c.getClass();
        ArrayList arrayList = new ArrayList();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return arrayList;
        }
        arrayList.add(new FirstPreviewPage(activity));
        PreviewPage imageBottom = new PreviewPage("bad", r(c, R.string.what_bad_habits), r(c, R.string.tutorial_check), R.color.black, R.color.sunset, R.drawable.preview_improve_moon, R.anim.slide_up_sunrise).setLayout(R.layout.fragment_preview_improve_check).setImageBottom(R.drawable.preview_improve_bye);
        String strR = r(c, R.string.improve_late);
        String strR2 = r(c, R.string.stop_oversleeping);
        String strR3 = r(c, R.string.stop_snoring);
        String strR4 = r(c, R.string.slogan_part2);
        String strR5 = r(c, R.string.slogan_part4);
        Locale locale = Locale.getDefault();
        locale.getClass();
        String lowerCase = strR5.toLowerCase(locale);
        lowerCase.getClass();
        arrayList.add(imageBottom.addPoints(new String[]{strR, strR2, strR3, FileInsert$$ExternalSyntheticOutline0.m$1(strR4, ", ", lowerCase)}));
        PreviewPage imageBottom2 = new PreviewPage("good", r(c, R.string.what_to_improve), r(c, R.string.tutorial_check), R.color.sunrise, R.color.sunset, R.drawable.preview_improve_sun, R.anim.slide_up_sunrise).setLayout(R.layout.fragment_preview_improve_check).setImageBottom(R.drawable.preview_improve);
        String strR6 = r(c, R.string.fast_fall_asleep);
        String strR7 = r(c, R.string.slogan_part1);
        String strR8 = r(c, R.string.label_deep_sleep);
        Locale locale2 = Locale.getDefault();
        locale2.getClass();
        String lowerCase2 = strR8.toLowerCase(locale2);
        lowerCase2.getClass();
        arrayList.add(imageBottom2.addPoints(new String[]{strR6, FileInsert$$ExternalSyntheticOutline0.m$1(strR7, " + ", lowerCase2), r(c, R.string.wake_up_refreshed), r(c, R.string.goal_regularity)}));
        PreviewPage previewPage = new PreviewPage("swake", r(c, R.string.settings_category_smart), r(c, R.string.settings_category_smart_summary), R.color.t3, R.color.t3a, R.drawable.preview_smart2, R.anim.wave);
        String string = c.getString(R.string.non_deep_sleep_window_title);
        String string2 = getString(R.string.minutes, "30");
        String string3 = c.getString(R.string.step_alarm_wake_at_range, "7:00", "7:30");
        string3.getClass();
        Locale locale3 = Locale.getDefault();
        locale3.getClass();
        String lowerCase3 = string3.toLowerCase(locale3);
        lowerCase3.getClass();
        arrayList.add(previewPage.addPoints(new String[]{Fragment$$ExternalSyntheticOutline1.m(string, " ", string2, ": ", lowerCase3)}));
        PreviewPage previewPage2 = new PreviewPage("bedtime", r(c, R.string.target_sleep_time_notify_title), r(c, R.string.advice_issues_schedule), R.color.t1a, R.color.t1, R.drawable.preview_bedtime, R.anim.unfade_slow);
        String string4 = getString(R.string.goal_duration_ideal);
        string4.getClass();
        arrayList.add(previewPage2.addPoints(new String[]{string4}).setRequiresPermission("android.permission.POST_NOTIFICATIONS"));
        arrayList.add(new TinderPreviewPage("lullaby", new TinderPreviewPage.EmptyLikeCallback(), r(c, R.string.fast_fall_asleep), r(c, R.string.settings_category_lullaby_summary), R.color.t0, R.color.t4, R.drawable.preview_lullaby, R.anim.rock).addPoints(new String[]{r(c, R.string.lullaby_name_WHALE), r(c, R.string.ringtone_nature_STORM), FileInsert$$ExternalSyntheticOutline0.m$1(r(c, R.string.lullaby_name_FORREST), "…")}));
        PreviewPage previewPage3 = new PreviewPage("track", getString(R.string.start_sleep_tracking), r(c, R.string.step_bed), R.color.t4a, R.color.t4, R.drawable.preview_track, R.anim.shake_left_show);
        String[] stringArray = getResources().getStringArray(R.array.advice_issues_deep_sleep_more);
        stringArray.getClass();
        arrayList.add(previewPage3.addPoints(stringArray).setRequiresPermission("android.permission.ACTIVITY_RECOGNITION"));
        try {
            arrayList.add(new TinderPreviewPage("sonar", new TinderPreviewPage.EmptyLikeCallback(), r(c, R.string.sonar_advantage), c.getResources().getStringArray(R.array.non_deep_sleep_method_entries)[1] + " — " + r(c, R.string.sonar_explanation), R.color.t1, R.color.t2a, R.drawable.preview_sonar, R.anim.shake_left_show).addPoints(new String[]{r(c, R.string.step_sonar)}));
        } catch (Resources.NotFoundException unused) {
        }
        PreviewPage layout = new PreviewPage("wear", r(c, R.string.smartwatch_title), r(c, R.string.smart_watch_summary), R.color.t4a, R.color.t2a, R.drawable.preview_wearable, R.anim.shake_left_show).setLayout(R.layout.fragment_preview_page_radio);
        String string5 = getString(R.string.smartwatch_support);
        string5.getClass();
        List<String> listSplit = new Regex(", ").split(string5, 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        arrayList.add(layout.addPoints((String[]) CollectionsKt.take(listEmptyList, 5).toArray(new String[0])));
        PreviewPage previewPage4 = new PreviewPage("score", r(c, R.string.sleep_importance_title), r(c, R.string.sleep_importance_summary), R.color.t4, R.color.t4a, R.drawable.preview_score, R.anim.wave);
        String string6 = getString(R.string.score);
        String string7 = getString(R.string.charts_summary);
        string7.getClass();
        Locale locale4 = Locale.ROOT;
        String lowerCase4 = string7.toLowerCase(locale4);
        arrayList.add(previewPage4.addPoints(new String[]{FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase4, string6, " — ", lowerCase4)}));
        TinderPreviewPage tinderPreviewPage = new TinderPreviewPage("noise", new TinderPreviewPage.EmptyLikeCallback() { // from class: com.urbandroid.sleep.fragment.preview.FirstUsePreviewFragment.getPages.2
            @Override // com.urbandroid.sleep.fragment.preview.TinderPreviewPage.EmptyLikeCallback, com.urbandroid.sleep.fragment.preview.TinderPreviewPage.LikeCallback
            public void like() {
                SharedApplicationContext.getSettings().setRecordingMasterSwitchEnabled(true);
            }
        }, r(c, R.string.sleep_recording_title), "", R.color.t1a, R.color.t7, R.drawable.preview_noise, R.anim.wave);
        String strR9 = r(c, R.string.snoring_detection);
        String strR10 = r(c, R.string.sleep_talk);
        String strR11 = r(c, R.string.sound_sick);
        String strR12 = r(c, R.string.sound_baby_cry);
        String lowerCase5 = r(c, R.string.sound_laughter).toLowerCase(locale4);
        arrayList.add(tinderPreviewPage.addPoints(new String[]{strR9, strR10, strR11, FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase5, strR12, ", ", lowerCase5)}).setRequiresPermission("android.permission.RECORD_AUDIO"));
        TinderPreviewPage.EmptyLikeCallback emptyLikeCallback = new TinderPreviewPage.EmptyLikeCallback();
        String strR13 = r(c, R.string.stop_snoring);
        String strR14 = r(c, R.string.anti_snoring_title);
        String strR15 = r(c, R.string.anti_snoring_summary);
        Locale locale5 = Locale.getDefault();
        locale5.getClass();
        String lowerCase6 = strR15.toLowerCase(locale5);
        lowerCase6.getClass();
        arrayList.add(new TinderPreviewPage("asnore", emptyLikeCallback, strR13, FileInsert$$ExternalSyntheticOutline0.m$1(strR14, ": ", lowerCase6), R.color.t2, R.color.t7, R.drawable.preview_snore, R.anim.buzz));
        PreviewPage previewPage5 = new PreviewPage("gentle", r(c, R.string.gentle_wake_up), r(c, R.string.natural_wake_up), R.color.t3a, R.color.t0, R.drawable.preview_ring, R.anim.unfade_slow);
        String strR16 = r(c, R.string.alarm_increasing_volume_title);
        String lowerCase7 = r(c, R.string.alarm_increasing_volume_duration_summary_2).toLowerCase(locale4);
        arrayList.add(previewPage5.addPoints(new String[]{FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase7, strR16, " — ", lowerCase7)}).setRequiresPermission("android.permission.POST_NOTIFICATIONS"));
        arrayList.add(new TinderPreviewPage("captcha", new TinderPreviewPage.EmptyLikeCallback(), r(c, R.string.captcha_preferene_title), r(c, R.string.captcha_preference_summary), R.color.t2a, R.color.t1a, R.drawable.preview_captcha2, R.anim.click).addPoints(new String[]{r(c, R.string.captcha_qr_code_title), r(c, R.string.lullaby_name_SHEEP), FileInsert$$ExternalSyntheticOutline0.m$1(r(c, R.string.captcha_dream_diary_title), "…")}));
        arrayList.add(new TinderPreviewPage("goal", new TinderPreviewPage.EmptyLikeCallback(), r(c, R.string.goal), getString(R.string.goal_summary), R.color.t3, R.color.t3a, R.drawable.preview_goal, R.anim.slide_up_slow));
        TinderPreviewPage tinderPreviewPage2 = new TinderPreviewPage("slight", new TinderPreviewPage.EmptyLikeCallback(), r(c, R.string.smartlight_title), r(c, R.string.sunrise_wakeup), R.color.t3, R.color.t3a, R.drawable.preview_smartlight, R.anim.unfade_slow);
        String string8 = getString(R.string.smartlight_support);
        string8.getClass();
        String string9 = getString(R.string.service_google_home);
        string9.getClass();
        arrayList.add(tinderPreviewPage2.addPoints(new String[]{string8, string9}));
        arrayList.add(new TinderPreviewPage("service", new TinderPreviewPage.EmptyLikeCallback() { // from class: com.urbandroid.sleep.fragment.preview.FirstUsePreviewFragment.getPages.3
            @Override // com.urbandroid.sleep.fragment.preview.TinderPreviewPage.EmptyLikeCallback, com.urbandroid.sleep.fragment.preview.TinderPreviewPage.LikeCallback
            public void dislike() {
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("Tutorial_prefs", new PrefStore(c, "onboarding_prefs").toBundle());
            }

            @Override // com.urbandroid.sleep.fragment.preview.TinderPreviewPage.EmptyLikeCallback, com.urbandroid.sleep.fragment.preview.TinderPreviewPage.LikeCallback
            public void like() {
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("Tutorial_prefs", new PrefStore(c, "onboarding_prefs").toBundle());
            }
        }, r(c, R.string.integrated_title), r(c, R.string.integrations_summary), R.color.t4, R.color.t3, R.drawable.preview_integration, R.anim.zoom_max).addPoints(new String[]{Fragment$$ExternalSyntheticOutline1.m(getString(R.string.google_fit), ", ", getString(R.string.samsung_shealth), ", ", getString(R.string.health_connect)), FileInsert$$ExternalSyntheticOutline0.m$1(getString(R.string.spotify), ", ", getString(R.string.online_radio)), Fragment$$ExternalSyntheticOutline1.m(Fragment$$ExternalSyntheticOutline1.m66m(getString(R.string.settings_category_backup), ", Google Drive, Dropbox, ", getString(R.string.google_calendar), ", ", getString(R.string.ifttt)), ", ", getString(R.string.tasker), ", ", getString(R.string.mqtt))}));
        PreviewPage previewPage6 = new PreviewPage("help", r(c, R.string.support), r(c, R.string.support_summary), R.color.t1a, R.color.t2a, R.drawable.preview_help, R.anim.float_away);
        String string10 = getString(R.string.documentation);
        string10.getClass();
        String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(getString(R.string.forum), " + ", getString(R.string.faq));
        String string11 = getString(R.string.get_support);
        string11.getClass();
        arrayList.add(previewPage6.addPoints(new String[]{string10, strM$1, string11}));
        arrayList.add(new PreviewPage("review", getString(R.string.help_users, Integer.valueOf(TrialFilter.APP_TOTAL_USERS_IN_MILLIONS)), getString(R.string.user_love), R.color.t3, R.color.t2, R.drawable.lovedroid, R.anim.rock_logo).setLayout(R.layout.fragment_preview_review).addPoints(new UnlockReviewProvider(c).getRandomReviews()));
        arrayList.add(new TermsPreviewPage(activity));
        arrayList.add(new AnalyticsConsentPreviewPage(activity));
        arrayList.add(new PremiumPreviewPage(activity, 0, 0, 0, 14, null));
        return arrayList;
    }
}
