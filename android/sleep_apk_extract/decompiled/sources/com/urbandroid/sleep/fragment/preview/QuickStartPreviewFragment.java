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
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/fragment/preview/QuickStartPreviewFragment;", "Lcom/urbandroid/sleep/fragment/preview/AbstractPreviewFragment;", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "resource", "", "r", "(Landroid/content/Context;I)Ljava/lang/String;", "getLayout", "()I", "c", "", "Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "getPages", "(Landroid/content/Context;)Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class QuickStartPreviewFragment extends AbstractPreviewFragment {
    private final String r(Context context, int resource) {
        String string = context.getString(resource);
        string.getClass();
        return string;
    }

    @Override // com.urbandroid.sleep.fragment.preview.AbstractPreviewFragment
    public int getLayout() {
        return R.layout.fragment_preview;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x067d  */
    @Override // com.urbandroid.sleep.fragment.preview.AbstractPreviewFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<PreviewPage> getPages(Context c) {
        List listEmptyList;
        c.getClass();
        ArrayList arrayList = new ArrayList();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            arrayList.add(new FirstPreviewPage(activity));
            arrayList.add(new PreviewPage(r(c, R.string.improve_bad_habits), "", R.color.black, R.color.sunset, R.drawable.preview_improve_moon, R.anim.slide_up_sunrise).setLayout(R.layout.fragment_preview_improve).setImageBottom(R.drawable.preview_improve_bye).addPoints(new String[]{r(c, R.string.improve_late), r(c, R.string.stop_oversleeping), r(c, R.string.stop_snoring), r(c, R.string.slogan_part2), r(c, R.string.slogan_part4)}));
            PreviewPage imageBottom = new PreviewPage(r(c, R.string.slogan_improve_life), r(c, R.string.do_for_you), R.color.sunrise, R.color.sunset, R.drawable.preview_improve_sun, R.anim.slide_up_sunrise).setLayout(R.layout.fragment_preview_improve).setImageBottom(R.drawable.preview_improve);
            String strR = r(c, R.string.fast_fall_asleep);
            String strR2 = r(c, R.string.slogan_part1);
            String strR3 = r(c, R.string.label_deep_sleep);
            Locale locale = Locale.getDefault();
            locale.getClass();
            String lowerCase = strR3.toLowerCase(locale);
            lowerCase.getClass();
            arrayList.add(imageBottom.addPoints(new String[]{strR, FileInsert$$ExternalSyntheticOutline0.m$1(strR2, ", ", lowerCase), r(c, R.string.goal_regularity), r(c, R.string.wake_up_refreshed), r(c, R.string.slogan_part3)}));
            PreviewPage previewPage = new PreviewPage(r(c, R.string.settings_category_smart), r(c, R.string.settings_category_smart_summary), R.color.t3, R.color.t3a, R.drawable.preview_smart2, R.anim.wave);
            String string = c.getString(R.string.non_deep_sleep_window_title);
            String string2 = getString(R.string.minutes, "30");
            String string3 = c.getString(R.string.step_alarm_wake_at_range, "7:00", "7:30");
            string3.getClass();
            Locale locale2 = Locale.getDefault();
            locale2.getClass();
            String lowerCase2 = string3.toLowerCase(locale2);
            lowerCase2.getClass();
            arrayList.add(previewPage.addPoints(new String[]{Fragment$$ExternalSyntheticOutline1.m(string, " ", string2, " – ", lowerCase2)}));
            PreviewPage previewPage2 = new PreviewPage(r(c, R.string.target_sleep_time_notify_title), r(c, R.string.advice_issues_schedule), R.color.t1a, R.color.t1, R.drawable.preview_bedtime, R.anim.unfade_slow);
            String string4 = getString(R.string.goal_duration_ideal);
            string4.getClass();
            arrayList.add(previewPage2.addPoints(new String[]{string4}).setRequiresPermission("android.permission.POST_NOTIFICATIONS"));
            PreviewPage previewPage3 = new PreviewPage(getString(R.string.start_sleep_tracking), r(c, R.string.step_bed), R.color.t4a, R.color.t4, R.drawable.preview_track, R.anim.shake_left_show);
            String[] stringArray = getResources().getStringArray(R.array.advice_issues_deep_sleep_more);
            stringArray.getClass();
            arrayList.add(previewPage3.addPoints(stringArray));
            try {
                arrayList.add(new PreviewPage(r(c, R.string.sonar_advantage), c.getResources().getStringArray(R.array.non_deep_sleep_method_entries)[1] + " — " + r(c, R.string.sonar_explanation), R.color.t1, R.color.t2a, R.drawable.preview_sonar, R.anim.shake_left_show).addPoints(new String[]{r(c, R.string.step_sonar)}));
            } catch (Resources.NotFoundException unused) {
            }
            PreviewPage previewPage4 = new PreviewPage(r(c, R.string.smartwatch_title), r(c, R.string.smart_watch_summary), R.color.t4a, R.color.t2a, R.drawable.preview_wearable, R.anim.shake_left_show);
            String string5 = getString(R.string.smartwatch_support);
            string5.getClass();
            List<String> listSplit = new Regex(", ").split(string5, 0);
            if (listSplit.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
                arrayList.add(previewPage4.addPoints((String[]) listEmptyList.toArray(new String[0])));
                arrayList.add(new PreviewPage(r(c, R.string.sleep_recording_title), "", R.color.t1a, R.color.t7, R.drawable.preview_noise, R.anim.wave).addPoints(new String[]{r(c, R.string.snoring_detection), r(c, R.string.sleep_talk), r(c, R.string.sound_sick), r(c, R.string.sound_baby_cry), r(c, R.string.sound_laughter)}));
                String strR4 = r(c, R.string.stop_snoring);
                String strR5 = r(c, R.string.anti_snoring_title);
                String strR6 = r(c, R.string.anti_snoring_summary);
                Locale locale3 = Locale.getDefault();
                locale3.getClass();
                String lowerCase3 = strR6.toLowerCase(locale3);
                lowerCase3.getClass();
                arrayList.add(new PreviewPage(strR4, FileInsert$$ExternalSyntheticOutline0.m$1(strR5, " – ", lowerCase3), R.color.t2, R.color.t7, R.drawable.preview_snore, R.anim.buzz));
                arrayList.add(new PreviewPage(r(c, R.string.lullaby), r(c, R.string.settings_category_lullaby_summary), R.color.t0, R.color.t4, R.drawable.preview_lullaby, R.anim.rock).addPoints(new String[]{r(c, R.string.lullaby_name_WHALE), r(c, R.string.ringtone_nature_STORM), FileInsert$$ExternalSyntheticOutline0.m$1(r(c, R.string.lullaby_name_FORREST), "…")}));
                PreviewPage previewPage5 = new PreviewPage(r(c, R.string.gentle_wake_up), r(c, R.string.natural_wake_up), R.color.t3a, R.color.t0, R.drawable.preview_ring, R.anim.unfade_slow);
                String strR7 = r(c, R.string.alarm_increasing_volume_title);
                String lowerCase4 = r(c, R.string.alarm_increasing_volume_duration_summary_2).toLowerCase(Locale.ROOT);
                arrayList.add(previewPage5.addPoints(new String[]{FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase4, strR7, " — ", lowerCase4)}).setRequiresPermission("android.permission.POST_NOTIFICATIONS"));
                arrayList.add(new PreviewPage(r(c, R.string.stop_oversleeping), r(c, R.string.captcha_preference_summary), R.color.t2a, R.color.t1a, R.drawable.preview_captcha2, R.anim.click).addPoints(new String[]{r(c, R.string.captcha_qr_code_title), r(c, R.string.lullaby_name_SHEEP), r(c, R.string.captcha_zombie), r(c, R.string.captcha_light), FileInsert$$ExternalSyntheticOutline0.m$1(r(c, R.string.captcha_dream_diary_title), "…")}));
                PreviewPage previewPage6 = new PreviewPage(r(c, R.string.feature_detailed_stats), r(c, R.string.charts_summary), R.color.t4, R.color.t4a, R.drawable.preview_score, R.anim.wave);
                String string6 = getString(R.string.score);
                string6.getClass();
                String string7 = getResources().getString(R.string.stats);
                string7.getClass();
                String string8 = getResources().getString(R.string.advanced_stats);
                string8.getClass();
                String string9 = getResources().getString(R.string.advice);
                string9.getClass();
                arrayList.add(previewPage6.addPoints(new String[]{string6, string7, string8, string9, FileInsert$$ExternalSyntheticOutline0.m$1(getResources().getString(R.string.trend), "…")}));
                arrayList.add(new PreviewPage(r(c, R.string.goal), getString(R.string.goal_summary), R.color.t3, R.color.t3a, R.drawable.preview_goal, R.anim.slide_up_slow));
                arrayList.add(new PreviewPage(r(c, R.string.chronotype), r(c, R.string.chronotype_promo), R.color.t3a, R.color.t1a, R.drawable.preview_theme, R.anim.rotate_more));
                PreviewPage previewPage7 = new PreviewPage(r(c, R.string.automatic_sleep_tracking), FileInsert$$ExternalSyntheticOutline0.m("+ ", getString(R.string.sleep_time_suggestion)), R.color.t4a, R.color.t2a, R.drawable.preview_automagic, R.anim.shake_left_show);
                String string10 = getString(R.string.auto_start_track_title);
                String string11 = getString(R.string.when_asleep);
                string11.getClass();
                Locale locale4 = Locale.getDefault();
                locale4.getClass();
                String lowerCase5 = string11.toLowerCase(locale4);
                lowerCase5.getClass();
                String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(string10, ": ", lowerCase5);
                String string12 = getString(R.string.sleep_time_suggestion_description);
                string12.getClass();
                arrayList.add(previewPage7.addPoints(new String[]{strM$1, string12}).setRequiresPermission("android.permission.ACTIVITY_RECOGNITION"));
                arrayList.add(new PreviewPage(r(c, R.string.apnea_category), r(c, R.string.apnea_category_summary), R.color.t4a, R.color.t2a, R.drawable.preview_oximetry, R.anim.zoom_max));
                arrayList.add(new PreviewPage(r(c, R.string.integrated_title), r(c, R.string.integrations_summary), R.color.t4, R.color.t3a, R.drawable.preview_integration, R.anim.slide_up_sunrise).addPoints(new String[]{Fragment$$ExternalSyntheticOutline1.m(getString(R.string.google_fit), ", ", getString(R.string.samsung_shealth), ", ", getString(R.string.health_connect)), FileInsert$$ExternalSyntheticOutline0.m$1(getString(R.string.spotify), ", ", getString(R.string.online_radio)), Fragment$$ExternalSyntheticOutline1.m(Fragment$$ExternalSyntheticOutline1.m66m(getString(R.string.settings_category_backup), ", Google Drive, Dropbox, ", getString(R.string.google_calendar), ", ", getString(R.string.ifttt)), ", ", getString(R.string.tasker), ", ", getString(R.string.mqtt))}));
                PreviewPage previewPage8 = new PreviewPage(r(c, R.string.smartlight_title), r(c, R.string.sunrise_wakeup), R.color.t3, R.color.t3a, R.drawable.preview_smartlight, R.anim.unfade_slow);
                String string13 = getString(R.string.smartlight_philips_hue_new);
                string13.getClass();
                String string14 = getString(R.string.smartlight_ikea_tradfri);
                string14.getClass();
                String string15 = getString(R.string.alarm_with_flashlight_title);
                string15.getClass();
                String string16 = getString(R.string.service_google_home);
                string16.getClass();
                arrayList.add(previewPage8.addPoints(new String[]{string13, string14, string15, string16}));
                PreviewPage previewPage9 = new PreviewPage(r(c, R.string.support), r(c, R.string.support_summary), R.color.t1a, R.color.t2a, R.drawable.preview_help, R.anim.float_away);
                String string17 = getString(R.string.documentation);
                string17.getClass();
                String strM$12 = FileInsert$$ExternalSyntheticOutline0.m$1(getString(R.string.forum), " + ", getString(R.string.faq));
                String string18 = getString(R.string.get_support);
                string18.getClass();
                arrayList.add(previewPage9.addPoints(new String[]{string17, strM$12, string18}));
                arrayList.add(new PreviewPage(getString(R.string.help_users, Integer.valueOf(TrialFilter.APP_TOTAL_USERS_IN_MILLIONS)), getString(R.string.user_love), R.color.t3, R.color.t2, R.drawable.lovedroid, R.anim.rock_logo).setLayout(R.layout.fragment_preview_review).addPoints(new UnlockReviewProvider(c).getRandomReviews()));
                if (TrialFilter.getInstance().isTrial()) {
                }
            } else {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
                arrayList.add(previewPage4.addPoints((String[]) listEmptyList.toArray(new String[0])));
                arrayList.add(new PreviewPage(r(c, R.string.sleep_recording_title), "", R.color.t1a, R.color.t7, R.drawable.preview_noise, R.anim.wave).addPoints(new String[]{r(c, R.string.snoring_detection), r(c, R.string.sleep_talk), r(c, R.string.sound_sick), r(c, R.string.sound_baby_cry), r(c, R.string.sound_laughter)}));
                String strR42 = r(c, R.string.stop_snoring);
                String strR52 = r(c, R.string.anti_snoring_title);
                String strR62 = r(c, R.string.anti_snoring_summary);
                Locale locale32 = Locale.getDefault();
                locale32.getClass();
                String lowerCase32 = strR62.toLowerCase(locale32);
                lowerCase32.getClass();
                arrayList.add(new PreviewPage(strR42, FileInsert$$ExternalSyntheticOutline0.m$1(strR52, " – ", lowerCase32), R.color.t2, R.color.t7, R.drawable.preview_snore, R.anim.buzz));
                arrayList.add(new PreviewPage(r(c, R.string.lullaby), r(c, R.string.settings_category_lullaby_summary), R.color.t0, R.color.t4, R.drawable.preview_lullaby, R.anim.rock).addPoints(new String[]{r(c, R.string.lullaby_name_WHALE), r(c, R.string.ringtone_nature_STORM), FileInsert$$ExternalSyntheticOutline0.m$1(r(c, R.string.lullaby_name_FORREST), "…")}));
                PreviewPage previewPage52 = new PreviewPage(r(c, R.string.gentle_wake_up), r(c, R.string.natural_wake_up), R.color.t3a, R.color.t0, R.drawable.preview_ring, R.anim.unfade_slow);
                String strR72 = r(c, R.string.alarm_increasing_volume_title);
                String lowerCase42 = r(c, R.string.alarm_increasing_volume_duration_summary_2).toLowerCase(Locale.ROOT);
                arrayList.add(previewPage52.addPoints(new String[]{FileInsert$$ExternalSyntheticOutline0.m$1(lowerCase42, strR72, " — ", lowerCase42)}).setRequiresPermission("android.permission.POST_NOTIFICATIONS"));
                arrayList.add(new PreviewPage(r(c, R.string.stop_oversleeping), r(c, R.string.captcha_preference_summary), R.color.t2a, R.color.t1a, R.drawable.preview_captcha2, R.anim.click).addPoints(new String[]{r(c, R.string.captcha_qr_code_title), r(c, R.string.lullaby_name_SHEEP), r(c, R.string.captcha_zombie), r(c, R.string.captcha_light), FileInsert$$ExternalSyntheticOutline0.m$1(r(c, R.string.captcha_dream_diary_title), "…")}));
                PreviewPage previewPage62 = new PreviewPage(r(c, R.string.feature_detailed_stats), r(c, R.string.charts_summary), R.color.t4, R.color.t4a, R.drawable.preview_score, R.anim.wave);
                String string62 = getString(R.string.score);
                string62.getClass();
                String string72 = getResources().getString(R.string.stats);
                string72.getClass();
                String string82 = getResources().getString(R.string.advanced_stats);
                string82.getClass();
                String string92 = getResources().getString(R.string.advice);
                string92.getClass();
                arrayList.add(previewPage62.addPoints(new String[]{string62, string72, string82, string92, FileInsert$$ExternalSyntheticOutline0.m$1(getResources().getString(R.string.trend), "…")}));
                arrayList.add(new PreviewPage(r(c, R.string.goal), getString(R.string.goal_summary), R.color.t3, R.color.t3a, R.drawable.preview_goal, R.anim.slide_up_slow));
                arrayList.add(new PreviewPage(r(c, R.string.chronotype), r(c, R.string.chronotype_promo), R.color.t3a, R.color.t1a, R.drawable.preview_theme, R.anim.rotate_more));
                PreviewPage previewPage72 = new PreviewPage(r(c, R.string.automatic_sleep_tracking), FileInsert$$ExternalSyntheticOutline0.m("+ ", getString(R.string.sleep_time_suggestion)), R.color.t4a, R.color.t2a, R.drawable.preview_automagic, R.anim.shake_left_show);
                String string102 = getString(R.string.auto_start_track_title);
                String string112 = getString(R.string.when_asleep);
                string112.getClass();
                Locale locale42 = Locale.getDefault();
                locale42.getClass();
                String lowerCase52 = string112.toLowerCase(locale42);
                lowerCase52.getClass();
                String strM$13 = FileInsert$$ExternalSyntheticOutline0.m$1(string102, ": ", lowerCase52);
                String string122 = getString(R.string.sleep_time_suggestion_description);
                string122.getClass();
                arrayList.add(previewPage72.addPoints(new String[]{strM$13, string122}).setRequiresPermission("android.permission.ACTIVITY_RECOGNITION"));
                arrayList.add(new PreviewPage(r(c, R.string.apnea_category), r(c, R.string.apnea_category_summary), R.color.t4a, R.color.t2a, R.drawable.preview_oximetry, R.anim.zoom_max));
                arrayList.add(new PreviewPage(r(c, R.string.integrated_title), r(c, R.string.integrations_summary), R.color.t4, R.color.t3a, R.drawable.preview_integration, R.anim.slide_up_sunrise).addPoints(new String[]{Fragment$$ExternalSyntheticOutline1.m(getString(R.string.google_fit), ", ", getString(R.string.samsung_shealth), ", ", getString(R.string.health_connect)), FileInsert$$ExternalSyntheticOutline0.m$1(getString(R.string.spotify), ", ", getString(R.string.online_radio)), Fragment$$ExternalSyntheticOutline1.m(Fragment$$ExternalSyntheticOutline1.m66m(getString(R.string.settings_category_backup), ", Google Drive, Dropbox, ", getString(R.string.google_calendar), ", ", getString(R.string.ifttt)), ", ", getString(R.string.tasker), ", ", getString(R.string.mqtt))}));
                PreviewPage previewPage82 = new PreviewPage(r(c, R.string.smartlight_title), r(c, R.string.sunrise_wakeup), R.color.t3, R.color.t3a, R.drawable.preview_smartlight, R.anim.unfade_slow);
                String string132 = getString(R.string.smartlight_philips_hue_new);
                string132.getClass();
                String string142 = getString(R.string.smartlight_ikea_tradfri);
                string142.getClass();
                String string152 = getString(R.string.alarm_with_flashlight_title);
                string152.getClass();
                String string162 = getString(R.string.service_google_home);
                string162.getClass();
                arrayList.add(previewPage82.addPoints(new String[]{string132, string142, string152, string162}));
                PreviewPage previewPage92 = new PreviewPage(r(c, R.string.support), r(c, R.string.support_summary), R.color.t1a, R.color.t2a, R.drawable.preview_help, R.anim.float_away);
                String string172 = getString(R.string.documentation);
                string172.getClass();
                String strM$122 = FileInsert$$ExternalSyntheticOutline0.m$1(getString(R.string.forum), " + ", getString(R.string.faq));
                String string182 = getString(R.string.get_support);
                string182.getClass();
                arrayList.add(previewPage92.addPoints(new String[]{string172, strM$122, string182}));
                arrayList.add(new PreviewPage(getString(R.string.help_users, Integer.valueOf(TrialFilter.APP_TOTAL_USERS_IN_MILLIONS)), getString(R.string.user_love), R.color.t3, R.color.t2, R.drawable.lovedroid, R.anim.rock_logo).setLayout(R.layout.fragment_preview_review).addPoints(new UnlockReviewProvider(c).getRandomReviews()));
                if (TrialFilter.getInstance().isTrial()) {
                    arrayList.add(new PremiumPreviewPage(activity, R.string.upgrade_to_premium, R.string.premium_summary, R.drawable.preview_premium));
                }
            }
        }
        return arrayList;
    }
}
