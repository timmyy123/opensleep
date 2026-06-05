package com.urbandroid.sleep.alarmclock;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/UnlockFlowFeaturesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UnlockFlowFeaturesActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_compare);
        View viewFindViewById = findViewById(R.id.help_button);
        final int i = 0;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.UnlockFlowFeaturesActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ UnlockFlowFeaturesActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i2 = i;
                    UnlockFlowFeaturesActivity unlockFlowFeaturesActivity = this.f$0;
                    switch (i2) {
                        case 0:
                            ViewIntent.url(unlockFlowFeaturesActivity, "https://sleep.urbandroid.org/docs//general/plan.html");
                            break;
                        default:
                            unlockFlowFeaturesActivity.finish();
                            break;
                    }
                }
            });
        }
        View viewFindViewById2 = findViewById(R.id.back_button);
        if (viewFindViewById2 != null) {
            final int i2 = 1;
            viewFindViewById2.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.UnlockFlowFeaturesActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ UnlockFlowFeaturesActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i22 = i2;
                    UnlockFlowFeaturesActivity unlockFlowFeaturesActivity = this.f$0;
                    switch (i22) {
                        case 0:
                            ViewIntent.url(unlockFlowFeaturesActivity, "https://sleep.urbandroid.org/docs//general/plan.html");
                            break;
                        default:
                            unlockFlowFeaturesActivity.finish();
                            break;
                    }
                }
            });
        }
        EdgeToEdgeUtil.Companion.insetsTop$default(EdgeToEdgeUtil.INSTANCE, findViewById(R.id.toolbar), 0, 2, null);
        getWindow().setStatusBarColor(ColorUtil.i(this, R.color.sunset));
        getWindow().setNavigationBarColor(ColorUtil.i(this, R.color.black));
    }
}
