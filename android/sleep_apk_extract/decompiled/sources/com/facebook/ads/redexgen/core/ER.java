package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization(type = {"NEW_CLASS"}, value = "Encapsulate error info from subtitle decoder")
public class ER {

    @Nullable
    public final C1981qI A00;
    public final Throwable A01;

    public ER(@Nullable C1981qI c1981qI, Throwable th) {
        this.A00 = c1981qI;
        this.A01 = th;
    }
}
