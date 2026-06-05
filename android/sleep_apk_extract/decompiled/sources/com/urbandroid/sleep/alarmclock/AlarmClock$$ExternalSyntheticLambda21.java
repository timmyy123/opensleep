package com.urbandroid.sleep.alarmclock;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
import com.urbandroid.sleep.alarmclock.EditActivity;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AlarmClock$$ExternalSyntheticLambda21 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ KeyEvent.Callback f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AlarmClock$$ExternalSyntheticLambda21(KeyEvent.Callback callback, Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = callback;
        this.f$1 = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        Object obj = this.f$1;
        KeyEvent.Callback callback = this.f$0;
        switch (i2) {
            case 0:
                ((AlarmClock) callback).lambda$showRatingDialog$28((Settings) obj, dialogInterface, i);
                break;
            case 1:
                EditActivity.AnonymousClass1.lambda$onPostExecute$0((EditText) callback, (EditText) obj, dialogInterface, i);
                break;
            default:
                ((AlarmAlertFullScreen) callback).lambda$showSnoozeChooser$2((String[]) obj, dialogInterface, i);
                break;
        }
    }
}
