package com.urbandroid.sleep.captcha;

import android.app.KeyguardManager;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.captcha.NFCScannerHelper;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class NFCScanner extends BaseActivity {
    private Handler handler;
    private final NFCScannerHelper scannerHelper = new NFCScannerHelper(this);
    private MenuItem fallbackMenu = null;

    /* JADX INFO: renamed from: com.urbandroid.sleep.captcha.NFCScanner$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$urbandroid$sleep$captcha$NFCScannerHelper$Result;

        static {
            int[] iArr = new int[NFCScannerHelper.Result.values().length];
            $SwitchMap$com$urbandroid$sleep$captcha$NFCScannerHelper$Result = iArr;
            try {
                iArr[NFCScannerHelper.Result.NFC_NOT_SUPPORTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$captcha$NFCScannerHelper$Result[NFCScannerHelper.Result.NFC_DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void initiateReadTag() {
        Logger.logInfo("NFCScanner: initiate read tag");
        int i = AnonymousClass3.$SwitchMap$com$urbandroid$sleep$captcha$NFCScannerHelper$Result[this.scannerHelper.initiateReadTag().ordinal()];
        if (i == 1) {
            setResult(35422399);
            finish();
        } else {
            if (i != 2) {
                return;
            }
            notifyNfcDisabled();
        }
    }

    private boolean isNfcDisabled() {
        try {
            if (NfcAdapter.getDefaultAdapter(this) != null) {
                return !r1.isEnabled();
            }
            Logger.logInfo("NFC adapter does not exist.");
            setResult(35422399);
            finish();
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private void notifyNfcDisabled() {
        setResult(35422400);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rerenderScreen() {
        Button button = (Button) findViewById(R.id.nfc_enable_button);
        View viewFindViewById = findViewById(R.id.nfc_scan_main);
        View viewFindViewById2 = findViewById(R.id.nfc_enable_warning);
        TextView textView = (TextView) findViewById(R.id.nfc_enable_warning_text);
        if (!isNfcDisabled()) {
            viewFindViewById.setVisibility(0);
            viewFindViewById2.setVisibility(8);
            initiateReadTag();
        } else {
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setVisibility(0);
            button.setVisibility(0);
            textView.setText(R.string.nfc_enable_required);
            Handler handler = this.handler;
            handler.sendMessageDelayed(handler.obtainMessage(1042), 1000L);
        }
    }

    private void terminateScan() {
        this.scannerHelper.terminateScan();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.captcha_nfc_scanner);
        this.handler = new Handler(getMainLooper()) { // from class: com.urbandroid.sleep.captcha.NFCScanner.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1042) {
                    return;
                }
                NFCScanner.this.rerenderScreen();
            }
        };
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
        if (keyguardManager.inKeyguardRestrictedInputMode()) {
            try {
                if (!((Boolean) keyguardManager.getClass().getMethod("isKeyguardSecure", null).invoke(keyguardManager, null)).booleanValue()) {
                    KeyguardUtil.disable(this);
                }
            } catch (NoSuchMethodException unused) {
            } catch (Throwable th) {
                Logger.logSevere("Failed to check keyguard secure state.", th);
            }
        }
        ((Button) findViewById(R.id.nfc_enable_button)).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.captcha.NFCScanner.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(Build.VERSION.SDK_INT >= 29 ? "android.settings.panel.action.NFC" : "android.settings.NFC_SETTINGS");
                    NFCScanner.this.startActivity(intent);
                } catch (Exception e) {
                    try {
                        Intent intent2 = new Intent();
                        intent2.setAction("android.settings.WIRELESS_SETTINGS");
                        NFCScanner.this.startActivity(intent2);
                    } catch (Exception unused2) {
                        Logger.logInfo("No activity to handle wireless mode", e);
                    }
                }
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nfc_menu, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_fallback);
        this.fallbackMenu = menuItemFindItem;
        if (menuItemFindItem == null) {
            return true;
        }
        menuItemFindItem.setVisible(SharedApplicationContext.getSettings().isCodeCaptchaFallback());
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setResult(-1, intent);
        finish();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        } else if (menuItem.getItemId() == R.id.menu_fallback) {
            Intent intent = new Intent(this, (Class<?>) NFCCaptcha.class);
            intent.putExtra("extra_fallback", true);
            intent.addFlags(872546304);
            startActivity(intent);
            finish();
        }
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.handler.removeMessages(1042);
        terminateScan();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        rerenderScreen();
    }
}
