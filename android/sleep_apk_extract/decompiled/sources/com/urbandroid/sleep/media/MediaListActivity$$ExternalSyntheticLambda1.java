package com.urbandroid.sleep.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.urbandroid.sleep.alarmclock.settings.AlarmSettingsActivity;
import com.urbandroid.sleep.fragment.MeasureOrderDialogFragment;
import com.urbandroid.sleep.gui.GraphListClickHandler;
import com.urbandroid.sleep.media.lullaby.LullabyDialogFragment;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.google.home.GoogleHomeAutomationListDialogFragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MediaListActivity$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ MediaListActivity$$ExternalSyntheticLambda1(Activity activity, Class cls, Settings settings) {
        this.$r8$classId = 2;
        this.f$0 = activity;
        this.f$2 = cls;
        this.f$1 = settings;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        Object obj = this.f$2;
        Object obj2 = this.f$0;
        Object obj3 = this.f$1;
        switch (i2) {
            case 0:
                ((MediaListActivity) obj2).lambda$onItemClick$1((Settings) obj3, (Song) obj, dialogInterface, i);
                break;
            case 1:
                AlarmSettingsActivity.lambda$onboardFullscreen$13((Activity) obj2, (Settings) obj3, (String) obj, dialogInterface, i);
                break;
            case 2:
                AlarmSettingsActivity.lambda$askOverlay$11((Activity) obj2, (Class) obj, (Settings) obj3, dialogInterface, i);
                break;
            case 3:
                MeasureOrderDialogFragment.onCreateDialog$lambda$0$0$1((FragmentActivity) obj2, (MeasureOrderDialogFragment.SortAdapter) obj3, (MeasureOrderDialogFragment) obj, dialogInterface, i);
                break;
            case 4:
                GraphListClickHandler.showItemOptionsDialog$lambda$0$1((EditText) obj2, (EditText) obj3, (GraphListClickHandler) obj, dialogInterface, i);
                break;
            case 5:
                GraphListClickHandler.showItemOptionsDialog$lambda$0$1$0((GraphListClickHandler) obj2, (String) obj3, (String) obj, dialogInterface, i);
                break;
            case 6:
                ((LullabyDialogFragment) obj2).lambda$onCreateDialog$0((ArrayList) obj3, (Context) obj, dialogInterface, i);
                break;
            default:
                GoogleHomeAutomationListDialogFragment.onCreateDialog$lambda$2((Settings) obj3, (String) obj2, (GoogleHomeAutomationListDialogFragment) obj, dialogInterface, i);
                break;
        }
    }

    public /* synthetic */ MediaListActivity$$ExternalSyntheticLambda1(Settings settings, String str, GoogleHomeAutomationListDialogFragment googleHomeAutomationListDialogFragment) {
        this.$r8$classId = 7;
        this.f$1 = settings;
        this.f$0 = str;
        this.f$2 = googleHomeAutomationListDialogFragment;
    }

    public /* synthetic */ MediaListActivity$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
