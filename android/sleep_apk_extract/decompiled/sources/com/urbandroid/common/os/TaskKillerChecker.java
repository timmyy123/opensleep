package com.urbandroid.common.os;

import android.content.Context;
import com.urbandroid.common.os.PackageStatusFetcher;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class TaskKillerChecker {
    private final PackageStatusFetcher fetcher;

    public interface KillerCondition {
    }

    public TaskKillerChecker(Context context) {
        this.fetcher = new PackageStatusFetcher(context);
    }

    public Set<TaskKillerPackage> getInstalledTaskKiller() {
        PackageStatusFetcher.Status packageStatus;
        HashSet hashSet = new HashSet();
        for (TaskKillerPackage taskKillerPackage : TaskKillerPackage.values()) {
            if (taskKillerPackage.allConditionsMet() && ((packageStatus = this.fetcher.getPackageStatus(taskKillerPackage.packageName)) == PackageStatusFetcher.Status.INSTALLED_NOT_RUNNING || packageStatus == PackageStatusFetcher.Status.RUNNING)) {
                hashSet.add(taskKillerPackage);
            }
        }
        return hashSet;
    }

    public void refreshStatus() {
        this.fetcher.refreshStatus();
    }

    public enum TaskKillerPackage {
        ADV_TASK_KILLER("com.rechild.advancedtaskkiller", "Advanced Task Killer"),
        ADV_TASK_KILLER_PRO("com.rechild.advancedtaskkillerpro", "Advanced Task Killer Pro"),
        ADV_TASK_KILLER_FROYO("com.rechild.advancedtaskkillerfroyo", "Advanced Task Killer"),
        TASK_KILLER("com.rechild.cleaner", "Task Killer"),
        TNI_TASK_KILLER("com.tni.TasKiller", "Task Killer"),
        TNI_TASK_KILLER_FULL("com.tni.TasKillerFull", "Task Killer Full"),
        WATCHDOG_LITE("com.zomut.watchdoglite", "Watchdog Lite"),
        WATCHDOG("com.zomut.watchdog", "Watchdog"),
        AUTO_TASK_KILLER("biz.stachibana.TaskKiller", "Automatic Task Killer"),
        DU_BATTERY_SAVER("com.dianxinos.dxbs", "DU Battery Saver"),
        JUICE_DEFENDER("com.latedroid.juicedefender", "Juice Defender"),
        JUICE_DEFENDER_ULTIMATE("com.latedroid.ultimatejuice", "Juice Defender Ultimate"),
        GO_LOCKER("com.jiubang.goscreenlock", "GO Locker"),
        LBE_PRIVACY_GUARD("com.lbe.security", "LBE Privacy Guard"),
        LBE_PRIVACY_GUARD_LITE("com.lbe.security.lite", "LBE Privacy Guard"),
        TITANIUM("com.keramidas.TitaniumBackup", "Titanium Backup"),
        VERIZON_BACKUP("com.vcast.mediamanager", "Verizon Backup Assistant"),
        GO_TASK_MANAGER("com.gau.go.launcherex.gowidget.taskmanagerex", "Go Task Manager"),
        GREENIFY("com.oasisfeng.greenify", "Greenify"),
        AUTO_HAPTIC("com.immersion.android.autohaptic", "Auto Haptic");

        private final String packageName;
        private final String userName;

        TaskKillerPackage(String str, String str2) {
            this(str, str2, null);
        }

        public boolean allConditionsMet() {
            return true;
        }

        public String getUserName() {
            return this.userName;
        }

        TaskKillerPackage(String str, String str2, KillerCondition killerCondition) {
            this.packageName = str;
            this.userName = str2;
        }
    }
}
