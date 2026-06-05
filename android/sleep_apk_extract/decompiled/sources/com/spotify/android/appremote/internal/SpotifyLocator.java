package com.spotify.android.appremote.internal;

import android.content.Context;
import com.spotify.android.appremote.api.error.CouldNotFindSpotifyApp;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class SpotifyLocator {
    @Nullable
    private static PackageProvider getDebug() {
        return instantiatePackageProvider("com.spotify.android.appremote.internal.DebugSpotifyLocator");
    }

    @Nullable
    private static PackageProvider getRelease() {
        return instantiatePackageProvider("com.spotify.android.appremote.internal.ReleaseSpotifyLocator");
    }

    @Nullable
    private static PackageProvider instantiatePackageProvider(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (PackageProvider.class.isAssignableFrom(cls)) {
                return (PackageProvider) cls.getConstructor(null).newInstance(null);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return null;
    }

    @Nullable
    public String getSpotifyBestPackageName(@Nonnull Context context) throws CouldNotFindSpotifyApp {
        PackageProvider debug = getDebug();
        if (debug != null) {
            return debug.getPackageName(context);
        }
        PackageProvider release = getRelease();
        if (release != null) {
            return release.getPackageName(context);
        }
        throw new CouldNotFindSpotifyApp();
    }

    public boolean isSpotifyInstalled(@Nonnull Context context) {
        return getSpotifyBestPackageName(context) != null;
    }
}
