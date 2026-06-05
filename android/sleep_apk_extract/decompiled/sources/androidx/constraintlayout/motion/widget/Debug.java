package androidx.constraintlayout.motion.widget;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Debug {
    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }
}
