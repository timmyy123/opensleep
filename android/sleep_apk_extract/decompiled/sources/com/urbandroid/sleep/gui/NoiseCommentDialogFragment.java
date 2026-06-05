package com.urbandroid.sleep.gui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.SleepRecords;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.gui.dialog.FixedDialogFragment;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.snoring.SnoringDetectionErrorDialogFragment;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class NoiseCommentDialogFragment extends FixedDialogFragment {
    private ICallback callback;

    public interface ICallback {
        void after();
    }

    public static NoiseCommentDialogFragment newInstance(long j) {
        NoiseCommentDialogFragment noiseCommentDialogFragment = new NoiseCommentDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("noise_id", j);
        noiseCommentDialogFragment.setArguments(bundle);
        return noiseCommentDialogFragment;
    }

    @Override // com.urbandroid.sleep.gui.dialog.FixedDialogFragment
    public Dialog createDialog() {
        if (getArguments() == null) {
            return null;
        }
        long j = getArguments().getLong("noise_id");
        Logger.logInfo("Noise id " + j);
        final Noise noise = SharedApplicationContext.getInstance().getSleepRecordRepository().getNoise(Long.valueOf(j));
        if (noise == null) {
            return null;
        }
        View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_rating, (ViewGroup) null);
        viewInflate.findViewById(R.id.fullscreen).setVisibility(8);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.sleep_rating_comment);
        viewInflate.findViewById(R.id.sleep_rating_bar).setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.tags);
        Tag.handleTag(getActivity(), Tag.SNORE.getTagName(), editText, viewGroup, false);
        Tag.handleTag(getActivity(), Tag.TALK.getTagName(), editText, viewGroup, false);
        Tag.handleTag(getActivity(), Tag.LAUGH.getTagName(), editText, viewGroup, false);
        Tag.handleTag(getActivity(), Tag.SICK.getTagName(), editText, viewGroup, false);
        Tag.handleTag(getActivity(), Tag.BABY.getTagName(), editText, viewGroup, false);
        Tag.handleTag(getActivity(), Tag.NOTE.getTagName(), editText, viewGroup, false);
        editText.setText(noise.getComment());
        MaterialAlertDialogBuilder negativeButton = new MaterialAlertDialogBuilder(getActivity()).setTitle(R.string.rating_comment_label).setPositiveButton(R.string.done, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.gui.NoiseCommentDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String string = editText.getText().toString();
                new SleepRecords().adjustSnoring(NoiseCommentDialogFragment.this.getActivity().getApplicationContext(), noise, string);
                Set<String> removedTags = Tag.getRemovedTags(noise.getComment(), string);
                Set<String> removedTags2 = Tag.getRemovedTags(string, noise.getComment());
                if (noise.getLength() > 30000 && SharedApplicationContext.getSettings().isShareSnoringDetectionErrors() && (SnoringDetectionErrorDialogFragment.hasInterestingTag(removedTags) || SnoringDetectionErrorDialogFragment.hasInterestingTag(removedTags2))) {
                    SnoringDetectionErrorDialogFragment.newInstance(noise.getId().longValue(), "Noise detection improvement V4b, removed " + SnoringDetectionErrorDialogFragment.setToString(removedTags) + ", added " + SnoringDetectionErrorDialogFragment.setToString(removedTags2)).show(NoiseCommentDialogFragment.this.getActivity().getSupportFragmentManager(), "snoring_error");
                }
                if (string != null && !"".equals(string) && !string.equals(noise.getComment())) {
                    noise.setStarred(true);
                }
                noise.setComment(string);
                SharedApplicationContext.getInstance().getSleepRecordRepository().updateNoise(noise);
                if (NoiseCommentDialogFragment.this.callback != null) {
                    NoiseCommentDialogFragment.this.callback.after();
                }
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.gui.NoiseCommentDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        negativeButton.setView(viewInflate);
        return negativeButton.create();
    }

    public void setCallback(ICallback iCallback) {
        this.callback = iCallback;
    }
}
