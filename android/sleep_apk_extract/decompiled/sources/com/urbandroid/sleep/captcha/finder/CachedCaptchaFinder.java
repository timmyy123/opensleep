package com.urbandroid.sleep.captcha.finder;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class CachedCaptchaFinder extends BaseCaptchaFinder {
    private static final long EXPIRATION = 180000;
    private final Map<Intent, Record> cache;
    private List<ApplicationInfo> cachedApps;
    private long expirationInMillis;
    private long lastUpdated;

    public class Record {
        List<ResolveInfo> infos;
        long lastUpdated;

        public Record(long j, List<ResolveInfo> list) {
            this.lastUpdated = j;
            this.infos = list;
        }
    }

    public CachedCaptchaFinder(Context context, long j) {
        super(context);
        this.cache = new HashMap();
        this.lastUpdated = -1L;
        this.expirationInMillis = j;
    }

    @Override // com.urbandroid.sleep.captcha.finder.BaseCaptchaFinder
    public List<ApplicationInfo> getInstalledApps(PackageManager packageManager) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.cachedApps == null || jCurrentTimeMillis - this.lastUpdated > this.expirationInMillis) {
            this.lastUpdated = jCurrentTimeMillis;
            this.cachedApps = super.getInstalledApps(packageManager);
        }
        return this.cachedApps;
    }

    @Override // com.urbandroid.sleep.captcha.finder.BaseCaptchaFinder
    public List<ResolveInfo> queryIntent(PackageManager packageManager, Intent intent) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Record record = this.cache.get(intent);
        if (record == null || jCurrentTimeMillis - record.lastUpdated > this.expirationInMillis) {
            record = new Record(jCurrentTimeMillis, super.queryIntent(packageManager, intent));
            this.cache.put(intent, record);
        }
        return record.infos;
    }

    public CachedCaptchaFinder(Context context) {
        this(context, EXPIRATION);
    }
}
