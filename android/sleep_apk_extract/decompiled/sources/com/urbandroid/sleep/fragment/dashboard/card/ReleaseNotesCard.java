package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.releasenotes.ReleaseNotes;
import com.urbandroid.common.version.ApplicationVersionExtractor;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class ReleaseNotesCard extends DashboardCard<ReleaseNotesViewHolder> {

    public class ReleaseNotesViewHolder extends LayeredViewHolder {
        public ReleaseNotesViewHolder(View view) {
            super(view);
        }
    }

    public ReleaseNotesCard(Activity activity) {
        super(activity, DashboardCard.Type.RELEASE_NOTES, R.layout.card_release_notes);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(ReleaseNotesViewHolder releaseNotesViewHolder) {
        ApplicationVersionExtractor applicationVersionExtractor = new ApplicationVersionExtractor();
        ((TextView) releaseNotesViewHolder.itemView.findViewById(R.id.text)).setText(getContext().getString(R.string.app_name_long) + " " + applicationVersionExtractor.getCurrentVersion(getContext()).getVersionName());
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public ReleaseNotesViewHolder createViewHolder(View view) {
        return new ReleaseNotesViewHolder(view);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.release;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        try {
            new ReleaseNotes(getContext()).updateLastSeenVersionToCurrent();
            MaterialAlertDialogBuilder materialAlertDialogBuilderShowReleaseNotes = new ReleaseNotes(getContext()).showReleaseNotes();
            materialAlertDialogBuilderShowReleaseNotes.setIcon(R.drawable.ic_gift);
            materialAlertDialogBuilderShowReleaseNotes.setNeutralButton(R.string.never_rate, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.ReleaseNotesCard.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SharedApplicationContext.getSettings().setShowReleaseNotes(false);
                }
            });
            DialogUtil.fixDivider(materialAlertDialogBuilderShowReleaseNotes.show());
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        removeForNow();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void setRemoved(boolean z) {
        new ReleaseNotes(getContext()).updateLastSeenVersionToCurrent();
        new Settings(getContext()).setShowReleaseNotes(!z);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void setRemovedBySwipe() {
        new ReleaseNotes(getContext()).updateLastSeenVersionToCurrent();
    }
}
