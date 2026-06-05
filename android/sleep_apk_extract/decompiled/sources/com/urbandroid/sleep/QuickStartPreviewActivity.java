package com.urbandroid.sleep;

import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class QuickStartPreviewActivity extends PreviewActivity implements Serializable {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$0() {
        View viewFindViewById = findViewById(R.id.image);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
            viewFindViewById.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rock_logo));
        }
    }

    @Override // com.urbandroid.sleep.PreviewActivity
    public int getLayoutRes() {
        return R.layout.activity_preview_quick_start;
    }

    @Override // com.urbandroid.sleep.PreviewActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        new Handler().postDelayed(new PreviewActivity$$ExternalSyntheticLambda1(this, 3), 500L);
    }
}
