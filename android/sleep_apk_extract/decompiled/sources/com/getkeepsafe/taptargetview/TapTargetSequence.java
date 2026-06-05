package com.getkeepsafe.taptargetview;

import android.app.Activity;
import android.app.Dialog;
import com.getkeepsafe.taptargetview.TapTargetView;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public class TapTargetSequence {
    private boolean active;
    private final Activity activity;
    boolean considerOuterCircleCanceled;
    boolean continueOnCancel;
    private TapTargetView currentView;
    private final Dialog dialog;
    Listener listener;
    private final TapTargetView.Listener tapTargetListener = new TapTargetView.Listener() { // from class: com.getkeepsafe.taptargetview.TapTargetSequence.1
        @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
        public void onOuterCircleClick(TapTargetView tapTargetView) {
            if (TapTargetSequence.this.considerOuterCircleCanceled) {
                onTargetCancel(tapTargetView);
            }
        }

        @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
        public void onTargetCancel(TapTargetView tapTargetView) {
            super.onTargetCancel(tapTargetView);
            TapTargetSequence tapTargetSequence = TapTargetSequence.this;
            if (tapTargetSequence.continueOnCancel) {
                Listener listener = tapTargetSequence.listener;
                if (listener != null) {
                    listener.onSequenceStep(tapTargetView.target, false);
                }
                TapTargetSequence.this.showNext();
                return;
            }
            Listener listener2 = tapTargetSequence.listener;
            if (listener2 != null) {
                listener2.onSequenceCanceled(tapTargetView.target);
            }
        }

        @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
        public void onTargetClick(TapTargetView tapTargetView) {
            super.onTargetClick(tapTargetView);
            Listener listener = TapTargetSequence.this.listener;
            if (listener != null) {
                listener.onSequenceStep(tapTargetView.target, true);
            }
            TapTargetSequence.this.showNext();
        }
    };
    private final Queue<TapTarget> targets;

    public interface Listener {
        void onSequenceCanceled(TapTarget tapTarget);

        void onSequenceFinish();

        void onSequenceStep(TapTarget tapTarget, boolean z);
    }

    public TapTargetSequence(Activity activity) {
        if (activity == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Activity is null");
            throw null;
        }
        this.activity = activity;
        this.dialog = null;
        this.targets = new LinkedList();
    }

    public TapTargetSequence listener(Listener listener) {
        this.listener = listener;
        return this;
    }

    public void showNext() {
        try {
            TapTarget tapTargetRemove = this.targets.remove();
            Activity activity = this.activity;
            if (activity != null) {
                this.currentView = TapTargetView.showFor(activity, tapTargetRemove, this.tapTargetListener);
            } else {
                this.currentView = TapTargetView.showFor(this.dialog, tapTargetRemove, this.tapTargetListener);
            }
        } catch (NoSuchElementException unused) {
            this.currentView = null;
            Listener listener = this.listener;
            if (listener != null) {
                listener.onSequenceFinish();
            }
        }
    }

    public void start() {
        if (this.targets.isEmpty() || this.active) {
            return;
        }
        this.active = true;
        showNext();
    }

    public TapTargetSequence targets(TapTarget... tapTargetArr) {
        Collections.addAll(this.targets, tapTargetArr);
        return this;
    }
}
