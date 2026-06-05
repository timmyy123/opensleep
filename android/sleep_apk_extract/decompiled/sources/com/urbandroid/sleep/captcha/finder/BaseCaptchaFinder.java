package com.urbandroid.sleep.captcha.finder;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.urbandroid.sleep.captcha.domain.BaseCaptchaGroup;
import com.urbandroid.sleep.captcha.domain.BaseCaptchaInfo;
import com.urbandroid.sleep.captcha.domain.CaptchaGroup;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.captcha.finder.filter.IdCaptchaInfoFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class BaseCaptchaFinder implements CaptchaFinder {
    private final Context context;

    public BaseCaptchaFinder(Context context) {
        this.context = context;
    }

    private CaptchaGroup findGroup(PackageManager packageManager, Map<String, CaptchaGroup> map, List<ApplicationInfo> list, String str) {
        CaptchaGroup captchaGroup = map != null ? map.get(str) : null;
        if (captchaGroup != null) {
            return captchaGroup;
        }
        for (ApplicationInfo applicationInfo : list) {
            if (str.equals(applicationInfo.packageName)) {
                boolean z = (applicationInfo.flags & 262144) == 262144;
                CharSequence charSequenceLoadLabel = applicationInfo.loadLabel(packageManager);
                BaseCaptchaGroup baseCaptchaGroup = new BaseCaptchaGroup(str, charSequenceLoadLabel == null ? str : charSequenceLoadLabel.toString(), z);
                if (map != null && !map.containsKey(str)) {
                    map.put(str, baseCaptchaGroup);
                }
                return baseCaptchaGroup;
            }
        }
        return null;
    }

    public BaseCaptchaInfo findById(List<CaptchaInfo> list, int i) {
        for (CaptchaInfo captchaInfo : list) {
            if (captchaInfo.getId() == i) {
                return (BaseCaptchaInfo) captchaInfo;
            }
        }
        return null;
    }

    public BaseCaptchaInfo findByName(List<CaptchaInfo> list, String str, String str2) {
        for (CaptchaInfo captchaInfo : list) {
            if (captchaInfo.getPackageName().equals(str2)) {
                if (!captchaInfo.getActivityName().equals(str)) {
                    if (captchaInfo.getActivityName().equals(str2 + str)) {
                    }
                }
                return (BaseCaptchaInfo) captchaInfo;
            }
        }
        return null;
    }

    @Override // com.urbandroid.sleep.captcha.finder.CaptchaFinder
    public List<CaptchaGroup> findGroups(CaptchaInfoFilter captchaInfoFilter) {
        PackageManager packageManager = this.context.getPackageManager();
        HashMap map = new HashMap();
        List<ApplicationInfo> installedApps = getInstalledApps(packageManager);
        for (CaptchaInfo captchaInfo : lookup(captchaInfoFilter)) {
            CaptchaGroup captchaGroupFindGroup = findGroup(packageManager, map, installedApps, captchaInfo.getPackageName());
            if (captchaGroupFindGroup != null) {
                captchaGroupFindGroup.add(captchaInfo);
            }
        }
        return new ArrayList(map.values());
    }

    public List<ApplicationInfo> getInstalledApps(PackageManager packageManager) {
        return packageManager.getInstalledApplications(128);
    }

    @Override // com.urbandroid.sleep.captcha.finder.CaptchaFinder
    public List<CaptchaInfo> lookup(CaptchaInfoFilter captchaInfoFilter) {
        ArrayList<CaptchaInfo> arrayList = new ArrayList();
        PackageManager packageManager = this.context.getPackageManager();
        List<ApplicationInfo> installedApps = getInstalledApps(packageManager);
        for (ResolveInfo resolveInfo : queryIntent(packageManager, new Intent("com.urbandroid.sleep.captcha.intent.action.OPEN"))) {
            Context context = this.context;
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            BaseCaptchaInfo baseCaptchaInfoBuild = BaseCaptchaInfo.build(context, activityInfo, activityInfo.loadLabel(packageManager).toString());
            CaptchaGroup captchaGroupFindGroup = findGroup(packageManager, null, installedApps, baseCaptchaInfoBuild.getPackageName());
            if (captchaInfoFilter == null || captchaInfoFilter.apply(captchaGroupFindGroup, baseCaptchaInfoBuild)) {
                arrayList.add(baseCaptchaInfoBuild);
            }
        }
        for (ResolveInfo resolveInfo2 : queryIntent(packageManager, new Intent("com.urbandroid.sleep.captcha.intent.action.CONFIG"))) {
            Context context2 = this.context;
            ActivityInfo activityInfo2 = resolveInfo2.activityInfo;
            BaseCaptchaInfo baseCaptchaInfoBuild2 = BaseCaptchaInfo.build(context2, activityInfo2, activityInfo2.loadLabel(packageManager).toString());
            BaseCaptchaInfo baseCaptchaInfoFindById = findById(arrayList, baseCaptchaInfoBuild2.getId());
            if (baseCaptchaInfoFindById == null) {
                baseCaptchaInfoFindById = findByName(arrayList, baseCaptchaInfoBuild2.getForCaptcha(), baseCaptchaInfoBuild2.getPackageName());
            }
            if (baseCaptchaInfoFindById != null) {
                baseCaptchaInfoFindById.setConfigActivityName(baseCaptchaInfoBuild2.getActivityName());
            }
        }
        Collections.sort(arrayList, CaptchaInfo.ORDER_COMPARATOR);
        if (arrayList.isEmpty()) {
            Log.w("captcha-support", "No captcha found");
            return arrayList;
        }
        Log.d("captcha-support", "Found Captchas:");
        for (CaptchaInfo captchaInfo : arrayList) {
            if (!captchaInfo.getPackageName().equals(this.context.getPackageName())) {
                Log.d("captcha-support", captchaInfo.toString());
            }
        }
        return arrayList;
    }

    public List<ResolveInfo> queryIntent(PackageManager packageManager, Intent intent) {
        return packageManager.queryIntentActivities(intent, 128);
    }

    @Override // com.urbandroid.sleep.captcha.finder.CaptchaFinder
    public CaptchaInfo findById(int i) {
        List<CaptchaInfo> listLookup = lookup(new IdCaptchaInfoFilter(i));
        if (listLookup.isEmpty()) {
            return null;
        }
        return listLookup.get(0);
    }
}
