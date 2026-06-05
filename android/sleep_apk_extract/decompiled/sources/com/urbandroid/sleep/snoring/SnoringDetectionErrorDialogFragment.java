package com.urbandroid.sleep.snoring;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepUtils;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.gui.dialog.FixedDialogFragment;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SnoringDetectionErrorDialogFragment extends FixedDialogFragment {
    public static boolean hasInterestingTag(Set<String> set) {
        return set.contains(Tag.SNORE.getTagName()) || set.contains(Tag.TALK.getTagName()) || set.contains(Tag.BABY.getTagName()) || set.contains(Tag.LAUGH.getTagName()) || set.contains(Tag.SICK.getTagName());
    }

    public static SnoringDetectionErrorDialogFragment newInstance(long j, String str) {
        SnoringDetectionErrorDialogFragment snoringDetectionErrorDialogFragment = new SnoringDetectionErrorDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("noise_id", j);
        bundle.putString("title", str);
        snoringDetectionErrorDialogFragment.setArguments(bundle);
        return snoringDetectionErrorDialogFragment;
    }

    public static String setToString(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(" ");
        }
        if (sb.length() == 0) {
            sb.append("nothing ");
        }
        return sb.toString();
    }

    @Override // com.urbandroid.sleep.gui.dialog.FixedDialogFragment
    public Dialog createDialog() {
        if (getArguments() == null) {
            return null;
        }
        long j = getArguments().getLong("noise_id");
        final String string = getArguments().getString("title");
        final Noise noise = SharedApplicationContext.getInstance().getSleepRecordRepository().getNoise(Long.valueOf(j));
        Logger.logInfo("Noise: " + noise);
        if (noise == null) {
            return null;
        }
        return new MaterialAlertDialogBuilder(getActivity()).setTitle(R.string.snoring_detection).setMessage(R.string.snoring_detection_error).setPositiveButton(R.string.share_android, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.snoring.SnoringDetectionErrorDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setFlags(1);
                String str = string;
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"snoring@urbandroid.org"});
                intent.putExtra("android.intent.extra.TEXT", "We will respect your privacy and only use your recording to improve snoring detection in Sleep as Android.");
                intent.putExtra("android.intent.extra.SUBJECT", str);
                intent.setType("message/rfc822");
                String uri = noise.getUri();
                Logger.logInfo("Attached noise uri: " + uri);
                if (uri.startsWith("content://")) {
                    intent.addFlags(1);
                    intent.putExtra("android.intent.extra.STREAM", Uri.parse(uri));
                } else {
                    intent.putExtra("android.intent.extra.STREAM", SleepUtils.toUri(new File(noise.getUriFix(SnoringDetectionErrorDialogFragment.this.getActivity())), SnoringDetectionErrorDialogFragment.this.getActivity().getApplicationContext()));
                }
                SnoringDetectionErrorDialogFragment.this.getActivity().startActivity(Intent.createChooser(intent, SnoringDetectionErrorDialogFragment.this.getActivity().getResources().getString(R.string.share_android)));
            }
        }).setNeutralButton(R.string.never, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.snoring.SnoringDetectionErrorDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedApplicationContext.getSettings().setShareSnoringDetectionErrors(false);
            }
        }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).create();
    }
}
