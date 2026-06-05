package com.urbandroid.sleep.persistence;

import android.content.DialogInterface;
import com.urbandroid.sleep.fragment.dashboard.card.LastCard;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ExportUtilKt$$ExternalSyntheticLambda0 implements DialogInterface.OnMultiChoiceClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ExportUtilKt$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.content.DialogInterface.OnMultiChoiceClickListener
    public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
        int i2 = this.$r8$classId;
        Object obj = this.f$0;
        switch (i2) {
            case 0:
                ExportUtilKt.showImportDialogUri$lambda$3$2((boolean[]) obj, dialogInterface, i, z);
                break;
            default:
                ((LastCard) obj).lambda$bindView$0(dialogInterface, i, z);
                break;
        }
    }
}
