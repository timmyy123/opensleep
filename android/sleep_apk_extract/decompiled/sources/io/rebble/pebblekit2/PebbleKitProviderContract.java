package io.rebble.pebblekit2;

import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lio/rebble/pebblekit2/PebbleKitProviderContract;", "", "<init>", "()V", "", "packageName", "getAuthority", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/net/Uri;", "getAuthorityUri", "(Ljava/lang/String;)Landroid/net/Uri;", "ConnectedWatch", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PebbleKitProviderContract {
    public static final PebbleKitProviderContract INSTANCE = new PebbleKitProviderContract();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lio/rebble/pebblekit2/PebbleKitProviderContract$ConnectedWatch;", "", "<init>", "()V", "", "packageName", "Landroid/net/Uri;", "getContentUri", "(Ljava/lang/String;)Landroid/net/Uri;", "", "ALL_COLUMNS", "Ljava/util/List;", "getALL_COLUMNS", "()Ljava/util/List;", "getALL_COLUMNS$annotations", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ConnectedWatch {
        public static final ConnectedWatch INSTANCE = new ConnectedWatch();
        private static final List<String> ALL_COLUMNS = CollectionsKt.listOf((Object[]) new String[]{"ID", "NAME", "PLATFORM", "REVISION", "FIRMWARE_VERSION_MAJOR", "FIRMWARE_VERSION_MINOR", "FIRMWARE_VERSION_PATCH", "FIRMWARE_VERSION_TAG"});

        private ConnectedWatch() {
        }

        public static final List<String> getALL_COLUMNS() {
            return ALL_COLUMNS;
        }

        public static final Uri getContentUri(String packageName) {
            packageName.getClass();
            Uri uriWithAppendedPath = Uri.withAppendedPath(PebbleKitProviderContract.getAuthorityUri(packageName), "connectedWatches");
            uriWithAppendedPath.getClass();
            return uriWithAppendedPath;
        }
    }

    private PebbleKitProviderContract() {
    }

    public static final String getAuthority(String packageName) {
        packageName.getClass();
        return packageName + ".pebblekit";
    }

    public static final Uri getAuthorityUri(String packageName) {
        packageName.getClass();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(getAuthority(packageName)).build();
        uriBuild.getClass();
        return uriBuild;
    }
}
