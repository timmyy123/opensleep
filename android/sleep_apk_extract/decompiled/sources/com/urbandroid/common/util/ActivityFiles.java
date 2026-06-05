package com.urbandroid.common.util;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.util.Experiments;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/common/util/ActivityFiles;", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "activityFileRegex", "Lkotlin/text/Regex;", "dataDir", "Ljava/io/File;", "getDataDir", "getLastFiles", "", "count", "", "getSortedFiles", "deleteOldFiles", "", "keepCount", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ActivityFiles {
    private final Regex activityFileRegex;
    private final Context context;
    private final File dataDir;

    public ActivityFiles(Context context) {
        context.getClass();
        this.context = context;
        this.activityFileRegex = new Regex("Activity_\\d{13}.*");
        this.dataDir = getDataDir();
    }

    private final File getDataDir() {
        try {
            File externalFilesDir = this.context.getExternalFilesDir(null);
            return new File(externalFilesDir != null ? externalFilesDir.getAbsoluteFile() : null, "/sleep-data/");
        } catch (Exception e) {
            Logger.logSevere("ActivityFiles.getDataDir()", e);
            return null;
        }
    }

    private final List<File> getSortedFiles() {
        File[] fileArrListFiles;
        File file = this.dataDir;
        if (file != null) {
            if (!file.isDirectory()) {
                file = null;
            }
            if (file != null && (fileArrListFiles = file.listFiles()) != null) {
                ArrayList arrayList = new ArrayList();
                for (File file2 : fileArrListFiles) {
                    Regex regex = this.activityFileRegex;
                    String name = file2.getName();
                    name.getClass();
                    if (regex.matches(name)) {
                        arrayList.add(file2);
                    }
                }
                List<File> listSorted = CollectionsKt.sorted(arrayList);
                if (listSorted != null) {
                    return listSorted;
                }
            }
        }
        return CollectionsKt.emptyList();
    }

    public final void deleteOldFiles(int keepCount) {
        try {
            if (Experiments.getInstance().isActivityPersistentExperiment()) {
                return;
            }
            List<File> sortedFiles = getSortedFiles();
            int iMax = Math.max(0, sortedFiles.size() - keepCount);
            for (int i = 0; i < iMax; i++) {
                sortedFiles.get(i).delete();
            }
        } catch (Exception e) {
            Logger.logSevere("ActivityFiles.deleteOldFiles(" + keepCount + ")", e);
        }
    }

    public final List<File> getLastFiles(int count) {
        try {
            List<File> sortedFiles = getSortedFiles();
            return sortedFiles.isEmpty() ? CollectionsKt.emptyList() : sortedFiles.subList(Math.max(0, sortedFiles.size() - count), sortedFiles.size());
        } catch (Exception e) {
            Logger.logSevere("ActivityFiles.getLastFiles(" + count + ")", e);
            return CollectionsKt.emptyList();
        }
    }
}
