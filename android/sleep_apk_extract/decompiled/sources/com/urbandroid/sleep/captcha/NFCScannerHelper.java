package com.urbandroid.sleep.captcha;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.CryptoUtil;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.captcha.NFCCaptcha;

/* JADX INFO: loaded from: classes4.dex */
public class NFCScannerHelper {
    private final Activity activity;
    private NfcAdapter nfcAdapter;

    public enum Result {
        SUCCESS,
        NFC_NOT_SUPPORTED,
        NFC_DISABLED
    }

    public NFCScannerHelper(Activity activity) {
        this.activity = activity;
    }

    public static NFCCaptcha.TagStringRepresentation convertTagToString(Tag tag, byte[] bArr) {
        byte b;
        if (bArr != null) {
            try {
                boolean z = false;
                if (bArr.length == 4 && ((b = bArr[0]) == 8 || b == 128)) {
                    z = true;
                }
                Logger.logDebug("NFCScannerHelper: Is random: " + z);
                if (!z) {
                    NFCCaptcha.TagStringRepresentation tagStringRepresentation = new NFCCaptcha.TagStringRepresentation(new String(bArr), tag.toString());
                    Logger.logInfo("NFCScannerHelper: TAG string: " + tagStringRepresentation);
                    return tagStringRepresentation;
                }
            } catch (Exception e) {
                Logger.logWarning("NFCScannerHelper: Failed to process NFC tag.", e);
            }
        }
        Logger.logDebug("NFCScannerHelper: Returning basic tag representation.");
        return new NFCCaptcha.TagStringRepresentation(tag.toString(), null);
    }

    public static boolean isNfcIntent(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return false;
        }
        return intent.getAction().equals("android.nfc.action.TAG_DISCOVERED") || intent.getAction().equals("android.nfc.action.NDEF_DISCOVERED");
    }

    public static boolean isValueEqual(NFCCaptcha.TagStringRepresentation tagStringRepresentation, String str) {
        StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("NFCScannerHelper: isEq ", str, " ");
        sbM5m.append(CryptoUtil.md5(tagStringRepresentation.value));
        Logger.logInfo(sbM5m.toString());
        if (str.equals(CryptoUtil.md5(tagStringRepresentation.value))) {
            return true;
        }
        String str2 = tagStringRepresentation.fallbackValue;
        return str2 != null && str.equals(CryptoUtil.md5(str2.replaceAll("\\s", "")));
    }

    public static NFCCaptcha.TagStringRepresentation parseScannedValue(Intent intent) {
        StringBuilder sb = new StringBuilder();
        BaseActivity.traceIntent(sb, intent);
        Logger.logInfo("NFCScanner: Tag intent ".concat(sb.toString()));
        if (!isNfcIntent(intent)) {
            return null;
        }
        Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
        Logger.logInfo("NFCScanner: Tag intent " + tag);
        if (tag != null) {
            return convertTagToString(tag, intent.getByteArrayExtra("android.nfc.extra.ID"));
        }
        return null;
    }

    public Result initiateReadTag() {
        try {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.activity);
            this.nfcAdapter = defaultAdapter;
            if (defaultAdapter == null) {
                Logger.logInfo("NFCScannerHelper: NFC adapter does not exist.");
                return Result.NFC_NOT_SUPPORTED;
            }
            if (!defaultAdapter.isEnabled()) {
                return Result.NFC_DISABLED;
            }
            Activity activity = this.activity;
            Activity activity2 = this.activity;
            PendingIntent activity3 = PendingIntentBuilder.get(activity, 0, new Intent(activity2, activity2.getClass()).addFlags(536870912), 33554432).getActivity();
            IntentFilter[] intentFilterArr = {new IntentFilter("android.nfc.action.NDEF_DISCOVERED"), new IntentFilter("android.nfc.action.TAG_DISCOVERED")};
            Logger.logInfo("NFCScanner: enableForegroundDispatch");
            this.nfcAdapter.enableForegroundDispatch(this.activity, activity3, intentFilterArr, null);
            return Result.SUCCESS;
        } catch (Exception e) {
            this.nfcAdapter = null;
            Logger.logWarning("NFCScannerHelper: NFC failure.", e);
            return Result.NFC_NOT_SUPPORTED;
        }
    }

    public void terminateScan() {
        NfcAdapter nfcAdapter = this.nfcAdapter;
        if (nfcAdapter != null) {
            try {
                nfcAdapter.disableForegroundDispatch(this.activity);
                Logger.logInfo("NFCScannerHelper: NFC scanning terminated.");
            } catch (Exception e) {
                Logger.logWarning("NFCScannerHelper: NFC failure.", e);
            }
            this.nfcAdapter = null;
        }
    }
}
