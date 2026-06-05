package com.urbandroid.sleep.gui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.Preference;
import com.google.android.material.tabs.TabLayout;
import com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity;
import com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity;
import com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity;
import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.sleep.media.lullaby.MeditationDialogFragment;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartwatch.WearablesDialogFragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GraphListClickHandler$$ExternalSyntheticLambda2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ GraphListClickHandler$$ExternalSyntheticLambda2(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i2) {
            case 0:
                GraphListClickHandler.showItemOptionsDialog$lambda$0$0((GraphListClickHandler) obj2, (Activity) obj, dialogInterface, i);
                break;
            case 1:
                GoalCreateActivity.onCreate$lambda$1$1((GoalCreateActivity) obj2, (TabLayout.Tab) obj, dialogInterface, i);
                break;
            case 2:
                GoalDetailActivity.onCreateDialog$lambda$0((GoalDetailActivity) obj2, (Goal) obj, dialogInterface, i);
                break;
            case 3:
                NoiseSettingsActivity.lambda$refresh$8((Settings) obj2, (Preference) obj, dialogInterface, i);
                break;
            case 4:
                ServicesSettingsActivity.refresh$lambda$5$0$0((PreferenceActivity) obj2, (Context) obj, dialogInterface, i);
                break;
            case 5:
                ((MeditationDialogFragment) obj2).lambda$onCreateDialog$0((ArrayList) obj, dialogInterface, i);
                break;
            default:
                ((WearablesDialogFragment) obj2).lambda$onCreateDialog$0((ArrayList) obj, dialogInterface, i);
                break;
        }
    }
}
