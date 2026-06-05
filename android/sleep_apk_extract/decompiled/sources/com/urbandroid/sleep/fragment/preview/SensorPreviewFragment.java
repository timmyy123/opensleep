package com.urbandroid.sleep.fragment.preview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SensorPreviewFragment extends AbstractPreviewFragment {
    private void addPageAccel(Context context, List<PreviewPage> list) {
        String str = r(context, R.string.non_deep_sleep_method_title) + " — " + context.getResources().getStringArray(R.array.non_deep_sleep_method_entries)[0];
        list.add(new PreviewPage(str, context.getResources().getStringArray(R.array.advice_issues_deep_sleep_more)[0], R.color.t4, R.color.black, R.drawable.preview_sensor_accel, -1));
        list.add(new PreviewPage(str, r(context, R.string.step_bed), R.color.t4, R.color.black, R.drawable.preview_track, R.anim.shake_left_show));
    }

    private void addPageSonar(Context context, List<PreviewPage> list) {
        String str = r(context, R.string.non_deep_sleep_method_title) + " — " + context.getResources().getStringArray(R.array.non_deep_sleep_method_entries)[1];
        list.add(new PreviewPage(str, r(context, R.string.sonar_advantage) + " " + r(context, R.string.sonar_explanation), R.color.t2a, R.color.black, R.drawable.preview_sensor_sonar, -1));
        list.add(new PreviewPage(str, r(context, R.string.step_sonar), R.color.t2a, R.color.black, R.drawable.preview_sonar, R.anim.shake_right_show));
        list.add(new PreviewPage(str, r(context, R.string.sonar_sensitivity), R.color.t2a, R.color.black, R.drawable.preview_sonar_breath, R.anim.fly_in));
    }

    private void addPageWearable(Context context, List<PreviewPage> list) {
        list.add(new PreviewPage(r(context, R.string.non_deep_sleep_method_title) + " — " + context.getResources().getString(R.string.smartwatch), r(context, R.string.sonar_advantage) + " " + r(context, R.string.addons_pebble_desc), R.color.t4, R.color.black, R.drawable.preview_wearable, R.anim.shake_left_show));
    }

    private String r(Context context, int i) {
        return context.getString(i);
    }

    @Override // com.urbandroid.sleep.fragment.preview.AbstractPreviewFragment
    public int getLayout() {
        return R.layout.fragment_preview;
    }

    @Override // com.urbandroid.sleep.fragment.preview.AbstractPreviewFragment
    public List<PreviewPage> getPages(Context context) {
        ArrayList arrayList = new ArrayList();
        if (SharedApplicationContext.getSettings().isUltrasonicTracking()) {
            addPageSonar(context, arrayList);
            if (new Settings(getContext()).showShowCaseIfNotShown("sonar_video")) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=cjXExBj6VcY")));
            }
            return arrayList;
        }
        addPageAccel(context, arrayList);
        addPageSonar(context, arrayList);
        addPageWearable(context, arrayList);
        return arrayList;
    }
}
