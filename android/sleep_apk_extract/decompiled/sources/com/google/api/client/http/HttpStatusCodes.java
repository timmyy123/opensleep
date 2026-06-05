package com.google.api.client.http;

import com.google.home.platform.traits.ValidationIssue;

/* JADX INFO: loaded from: classes4.dex */
public abstract class HttpStatusCodes {
    public static boolean isRedirect(int i) {
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case ValidationIssue.BLOCKED_ACTION_FIELD_NUMBER /* 301 */:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public static boolean isSuccess(int i) {
        return i >= 200 && i < 300;
    }
}
