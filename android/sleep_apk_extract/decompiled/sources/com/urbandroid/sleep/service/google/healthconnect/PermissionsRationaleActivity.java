package com.urbandroid.sleep.service.google.healthconnect;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00148\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/service/google/healthconnect/PermissionsRationaleActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "showRationaleUrl", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "permissionString", "getPermissionString", "setPermissionString", "(Ljava/lang/String;)V", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PermissionsRationaleActivity extends BaseActivity implements FeatureLogger {
    private static final String HEALTH_CONNECT_PERMISION = "android.permission-group.HEALTH";
    private static final String HEALTH_CONNECT_RATIONALE_URL = "https://team.urbandroid.org/privacy-policy/#hc";
    private String permissionString;
    private final String tag = "HealthConnect";

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(getApplicationContext());
        setContentView(R.layout.activity_permission_rationale);
        setContentView(R.layout.activity_permission_rationale);
        ActionBar supportActionBar = getSupportActionBar();
        final int i = 1;
        if (supportActionBar != null) {
            supportActionBar.setTitle(R.string.permissions);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ToolbarUtil.apply(this);
        EdgeToEdgeUtil.Companion.insetsBottom$default(EdgeToEdgeUtil.INSTANCE, findViewById(R.id.buttons), 0, false, 6, null);
        Logger.logInfo("Permission Rationale: " + getIntent().getStringExtra("android.intent.extra.PERMISSION_GROUP_NAME"));
        TextView textView = (TextView) findViewById(R.id.rationale);
        if (getIntent().hasExtra("android.intent.extra.PERMISSION_GROUP_NAME")) {
            String stringExtra = getIntent().getStringExtra("android.intent.extra.PERMISSION_GROUP_NAME");
            this.permissionString = stringExtra;
            if (stringExtra != null) {
                StringsKt__StringsKt.substringAfterLast$default(stringExtra, '.', (String) null, 2, (Object) null);
            }
            PackageManager packageManager = getPackageManager();
            packageManager.getClass();
            String str = this.permissionString;
            str.getClass();
            final int i2 = 0;
            CharSequence charSequenceLoadLabel = packageManager.getPermissionGroupInfo(str, 0).loadLabel(packageManager);
            charSequenceLoadLabel.getClass();
            setTitle(charSequenceLoadLabel);
            String stringExtra2 = getIntent().getStringExtra("android.intent.extra.PERMISSION_GROUP_NAME");
            if (stringExtra2 != null) {
                switch (stringExtra2.hashCode()) {
                    case -1410061184:
                        if (stringExtra2.equals("android.permission-group.PHONE")) {
                            textView.setText(R.string.phone_call_summary);
                        }
                        break;
                    case -1140935117:
                        if (stringExtra2.equals("android.permission-group.CAMERA")) {
                            textView.setText(R.string.alarm_with_flashlight_summary);
                        }
                        break;
                    case -994445974:
                        if (stringExtra2.equals("android.permission-group.HEALTH")) {
                            textView.setText(R.string.health_connect_permission_rationale);
                        }
                        break;
                    case -43134093:
                        if (stringExtra2.equals("android.permission-group.READ_MEDIA_AURAL")) {
                            textView.setText(getString(R.string.no_permission_general, getString(R.string.alert), charSequenceLoadLabel));
                        }
                        break;
                    case 225035509:
                        if (stringExtra2.equals("android.permission-group.ACTIVITY_RECOGNITION")) {
                            textView.setText(getString(R.string.no_permission_general, getString(R.string.sleep_analysis), charSequenceLoadLabel));
                        }
                        break;
                    case 828638019:
                        if (stringExtra2.equals("android.permission-group.LOCATION")) {
                            textView.setText(R.string.warning_location_bt);
                        }
                        break;
                    case 1485193722:
                        if (stringExtra2.equals("android.permission-group.NOTIFICATIONS")) {
                            textView.setText(getString(R.string.no_permission_general, getString(R.string.alarm_fullscreen), charSequenceLoadLabel));
                        }
                        break;
                    case 1581272376:
                        if (stringExtra2.equals("android.permission-group.MICROPHONE")) {
                            textView.setText(R.string.deny_permission_recording);
                        }
                        break;
                }
            }
            findViewById(R.id.read_more).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.service.google.healthconnect.PermissionsRationaleActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ PermissionsRationaleActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i3 = i2;
                    PermissionsRationaleActivity permissionsRationaleActivity = this.f$0;
                    switch (i3) {
                        case 0:
                            permissionsRationaleActivity.showRationaleUrl();
                            break;
                        case 1:
                            permissionsRationaleActivity.finish();
                            break;
                        default:
                            permissionsRationaleActivity.finish();
                            break;
                    }
                }
            });
        }
        findViewById(R.id.button_ok).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.service.google.healthconnect.PermissionsRationaleActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ PermissionsRationaleActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                PermissionsRationaleActivity permissionsRationaleActivity = this.f$0;
                switch (i3) {
                    case 0:
                        permissionsRationaleActivity.showRationaleUrl();
                        break;
                    case 1:
                        permissionsRationaleActivity.finish();
                        break;
                    default:
                        permissionsRationaleActivity.finish();
                        break;
                }
            }
        });
        final int i3 = 2;
        findViewById(R.id.button_cancel).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.service.google.healthconnect.PermissionsRationaleActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ PermissionsRationaleActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32 = i3;
                PermissionsRationaleActivity permissionsRationaleActivity = this.f$0;
                switch (i32) {
                    case 0:
                        permissionsRationaleActivity.showRationaleUrl();
                        break;
                    case 1:
                        permissionsRationaleActivity.finish();
                        break;
                    default:
                        permissionsRationaleActivity.finish();
                        break;
                }
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.doc_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getClass();
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.menu_doc) {
            return true;
        }
        showRationaleUrl();
        return true;
    }

    public final void showRationaleUrl() {
        if (Intrinsics.areEqual(HEALTH_CONNECT_PERMISION, this.permissionString)) {
            ViewIntent.urlCustomTab(this, HEALTH_CONNECT_RATIONALE_URL);
        } else {
            ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//general/permissions.html");
        }
    }
}
