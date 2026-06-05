package com.urbandroid.sleep.ai;

import android.view.KeyEvent;
import android.view.View;
import com.google.android.material.button.MaterialButton;
import com.urbandroid.sleep.ai.AiMessageRecyclerAdapter;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AiActivity$$ExternalSyntheticLambda8 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ KeyEvent.Callback f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ AiActivity$$ExternalSyntheticLambda8(KeyEvent.Callback callback, Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = callback;
        this.f$1 = obj;
        this.f$2 = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$2;
        Object obj2 = this.f$1;
        KeyEvent.Callback callback = this.f$0;
        switch (i) {
            case 0:
                AiActivity.addPromptsToView$lambda$0$1((AiActivity) callback, (AiPrompt) obj2, (AiActivity$$ExternalSyntheticLambda2) obj, view);
                break;
            default:
                AiMessageRecyclerAdapter.MessageHolder.bind$lambda$0$0((MaterialButton) callback, (AiMessageRecyclerAdapter.MessageHolder) obj2, (AiMessageRecyclerAdapter.Message) obj, view);
                break;
        }
    }
}
