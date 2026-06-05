package com.google.common.collect;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.common.base.Preconditions;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
abstract class CollectPreconditions {
    public static void checkEntryNotNull(Object obj, Object obj2) {
        if (obj == null) {
            Types$$ExternalSyntheticBUOutline0.m$1(Fragment$$ExternalSyntheticOutline1.m("null key in entry: null=", obj2));
        } else {
            if (obj2 != null) {
                return;
            }
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    public static int checkNonnegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        Gson$$ExternalSyntheticBUOutline0.m(str, " cannot be negative but was: ", i);
        return 0;
    }

    public static void checkRemove(boolean z) {
        Preconditions.checkState(z, "no calls to next() since the last call to remove()");
    }
}
