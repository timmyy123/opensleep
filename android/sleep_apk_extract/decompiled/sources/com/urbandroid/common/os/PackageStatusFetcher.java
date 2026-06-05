package com.urbandroid.common.os;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.urbandroid.common.logging.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class PackageStatusFetcher {
    private final Context context;
    private final Map<String, Status> statuses = new HashMap();

    public enum Status {
        NOT_INSTALLED,
        INSTALLED_NOT_RUNNING,
        RUNNING
    }

    public PackageStatusFetcher(Context context) {
        this.context = context;
    }

    private void loadInstalledApplications() {
        try {
            Iterator<PackageInfo> it = this.context.getPackageManager().getInstalledPackages(8).iterator();
            while (it.hasNext()) {
                this.statuses.put(it.next().packageName, Status.INSTALLED_NOT_RUNNING);
            }
        } catch (NullPointerException e) {
            Logger.logWarning("Failed to fetch installed apps", e);
        }
    }

    public Status getPackageStatus(String str) {
        Status status = this.statuses.get(str);
        return status != null ? status : Status.NOT_INSTALLED;
    }

    public PackageStatusFetcher refreshStatus() {
        this.statuses.clear();
        loadInstalledApplications();
        return this;
    }
}
