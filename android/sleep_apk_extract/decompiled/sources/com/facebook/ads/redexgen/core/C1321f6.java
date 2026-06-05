package com.facebook.ads.redexgen.core;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.f6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1321f6 implements AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ C01983r A00;

    public C1321f6(C01983r c01983r) {
        this.A00 = c01983r;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        new Handler(Looper.getMainLooper()).post(new C0433Dl(this, i));
    }
}
