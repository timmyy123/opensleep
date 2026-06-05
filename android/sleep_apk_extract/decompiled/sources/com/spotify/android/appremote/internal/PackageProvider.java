package com.spotify.android.appremote.internal;

import android.content.Context;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface PackageProvider {
    @Nullable
    String getPackageName(@Nonnull Context context);
}
