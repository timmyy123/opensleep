package com.urbandroid.sleep.media.lullaby;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LullabyRadioItem$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ LullabyRadioItem$$ExternalSyntheticLambda1(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        Object obj = this.f$0;
        switch (i2) {
            case 0:
                LullabyRadioItem.bindView$lambda$0$0((LullabyRadioItem) obj, dialogInterface, i);
                break;
            default:
                ((MeditationDialogFragment) obj).lambda$onCreateDialog$1(dialogInterface, i);
                break;
        }
    }
}
