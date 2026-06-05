package com.urbandroid.sleep.captcha.util;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.GraphResponse;
import com.urbandroid.sleep.captcha.domain.CaptchaChildResult;

/* JADX INFO: loaded from: classes4.dex */
public abstract class IntentUtil {
    public static CaptchaChildResult getChildResult(final Intent intent) {
        if (intent == null || !"com.urbandroid.sleep.captcha.intent.action.SOLVED".equals(intent.getAction())) {
            return null;
        }
        return new CaptchaChildResult() { // from class: com.urbandroid.sleep.captcha.util.IntentUtil.1
            @Override // com.urbandroid.sleep.captcha.domain.CaptchaChildResult
            public boolean isSolved() {
                return intent.getBooleanExtra(GraphResponse.SUCCESS_KEY, true);
            }
        };
    }

    public static int resolveTimeout(Intent intent) {
        int intExtra;
        if (intent != null && intent.hasExtra("originIntent")) {
            intent = (Intent) intent.getParcelableExtra("originIntent");
        }
        if (intent == null || !intent.hasExtra("aliveTimeout") || (intExtra = intent.getIntExtra("aliveTimeout", -1)) == -1) {
            return 60;
        }
        return intExtra;
    }

    public static StringBuilder traceBundle(StringBuilder sb, Bundle bundle, String str) {
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                sb.append("\n" + str + "\t\t" + str2);
                sb.append("=");
                Object obj = bundle.get(str2);
                if (obj instanceof String) {
                    String str3 = (String) obj;
                    if (str3.length() > 0) {
                        Fragment$$ExternalSyntheticOutline1.m67m(sb, "\"", str3, "\" ");
                    }
                } else if (obj instanceof Boolean) {
                    sb.append(obj);
                } else if (obj instanceof Number) {
                    sb.append(obj);
                } else if (obj instanceof Intent) {
                    traceIntent(sb, (Intent) obj, str + "\t\t\t");
                } else {
                    String string = obj != null ? obj.toString() : "NULL";
                    if (string.length() > 0 && string.length() < 100) {
                        Fragment$$ExternalSyntheticOutline1.m67m(sb, "(", string, ") ");
                    }
                }
            }
        }
        return sb;
    }

    public static StringBuilder traceIntent(StringBuilder sb, Intent intent, String str) {
        sb.append("\n" + str + "I: ");
        if (intent == null) {
            sb.append("null");
            return sb;
        }
        if (intent.getAction() != null) {
            sb.append("action: ");
            sb.append(intent.getAction());
            sb.append(" ");
        }
        if (intent.getComponent() != null) {
            sb.append("class: ");
            sb.append(intent.getComponent().getClassName());
            sb.append(" ");
        }
        sb.append("package: ");
        sb.append(intent.getPackage());
        sb.append(" ");
        traceBundle(sb, intent.getExtras(), str);
        return sb;
    }

    public static StringBuilder traceIntent(StringBuilder sb, Intent intent) {
        return traceIntent(sb, intent, "");
    }

    public static String traceIntent(Intent intent) {
        StringBuilder sb = new StringBuilder();
        traceIntent(sb, intent);
        return sb.toString();
    }
}
