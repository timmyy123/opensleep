package com.urbandroid.common.releasenotes;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.InputStreamUtil;
import com.urbandroid.common.version.ApplicationVersionExtractor;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class ReleaseNotes {
    private final Activity context;
    private final ApplicationVersionExtractor versionExtractor = new ApplicationVersionExtractor();

    public ReleaseNotes(Activity activity) {
        this.context = activity;
    }

    private synchronized String getLastSeenVersion() {
        return PreferenceManager.getDefaultSharedPreferences(this.context).getString("last_seen_version", "");
    }

    private synchronized void setLastSeenVersion(String str) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString("last_seen_version", str);
        editorEdit.apply();
    }

    public boolean isNewVersion() {
        String lastSeenVersion = getLastSeenVersion();
        String versionName = this.versionExtractor.getCurrentVersion(this.context).getVersionName();
        if (lastSeenVersion == null || lastSeenVersion.equals("") || versionName.equals(lastSeenVersion)) {
            return false;
        }
        Logger.logInfo("Dashboard: Version update from " + lastSeenVersion + " to " + versionName);
        return true;
    }

    public MaterialAlertDialogBuilder showReleaseNotes() {
        Logger.logInfo("Showing release notes ");
        View viewInflate = this.context.getLayoutInflater().inflate(R.layout.release_notes, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.release_notes_text);
        try {
            textView.setText(InputStreamUtil.read(this.context.getAssets().open("release-notes")));
        } catch (IOException unused) {
            textView.setText(this.context.getResources().getString(R.string.general_unspecified_error));
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.release_notes_version);
        StringBuilder sb = new StringBuilder("Version 20260519 (231055) ");
        sb.append(TrialFilter.getInstance().isTrial() ? "Free" : "Premium");
        sb.append("");
        textView2.setText(sb.toString());
        MaterialAlertDialogBuilder positiveButton = new MaterialAlertDialogBuilder(this.context).setTitle((CharSequence) this.context.getString(R.string.release)).setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.urbandroid.common.releasenotes.ReleaseNotes.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        positiveButton.setView(viewInflate);
        return positiveButton;
    }

    public MaterialAlertDialogBuilder showReleaseNotesIfUpdated() {
        try {
            if (isNewVersion()) {
                return showReleaseNotes();
            }
            updateLastSeenVersionToCurrent();
            return null;
        } finally {
            updateLastSeenVersionToCurrent();
        }
    }

    public synchronized void updateLastSeenVersionToCurrent() {
        setLastSeenVersion(this.versionExtractor.getCurrentVersion(this.context).getVersionName());
    }
}
