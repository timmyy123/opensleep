package com.urbandroid.sleep.gui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.R;
import com.urbandroid.util.ColorUtil;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DialogUtil {
    private static void fixButton(AlertDialog alertDialog, int i, int i2) {
        if (alertDialog.getButton(i) != null) {
            alertDialog.getButton(i).setTextColor(ColorUtil.i(alertDialog.getContext(), i2));
        }
    }

    public static AlertDialog fixButtons(AlertDialog alertDialog, int i) {
        fixButton(alertDialog, -1, i);
        fixButton(alertDialog, -3, i);
        fixButton(alertDialog, -2, i);
        return alertDialog;
    }

    public static AlertDialog fixButtonsAndDivider(AlertDialog alertDialog, int i) {
        return fixButtons((AlertDialog) fixDivider(alertDialog), i);
    }

    public static <T extends Dialog> T fixDivider(T t) {
        int identifier;
        View viewFindViewById;
        try {
            try {
                if (Environment.isHoneycombOrGreater() && t != null && (identifier = t.getContext().getResources().getIdentifier("android:id/titleDivider", null, null)) > 0 && (viewFindViewById = t.findViewById(identifier)) != null) {
                    viewFindViewById.setBackgroundColor(t.getContext().getResources().getColor(R.color.transparent));
                    return t;
                }
            } catch (Exception e) {
                Logger.logSevere("Cannot fix divider ", e);
            }
        } catch (Throwable unused) {
        }
        return t;
    }

    public static View getImageDialogView(Activity activity, String str, int i) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.dialog_image, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.text)).setText(str);
        ((ImageView) viewInflate.findViewById(R.id.image)).setImageResource(i);
        return viewInflate;
    }

    public static View getImageDialogView(Activity activity, int i, int i2) {
        return getImageDialogView(activity, activity.getString(i), i2);
    }
}
