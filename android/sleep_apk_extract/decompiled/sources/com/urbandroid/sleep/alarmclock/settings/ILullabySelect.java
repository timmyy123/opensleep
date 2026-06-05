package com.urbandroid.sleep.alarmclock.settings;

import android.app.Activity;
import com.urbandroid.sleep.media.lullaby.LullabyPlayer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/ILullabySelect;", "", "onLullabySelected", "", "preferenceActivity", "Landroid/app/Activity;", "lullabyValue", "Lcom/urbandroid/sleep/media/lullaby/LullabyPlayer$Lullaby;", "lullabyName", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ILullabySelect {
    void onLullabySelected(Activity preferenceActivity, LullabyPlayer.Lullaby lullabyValue, String lullabyName);
}
