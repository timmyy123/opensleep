package com.facebook.internal;

import com.facebook.internal.FileLruCache;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Utility$$ExternalSyntheticLambda3 implements FilenameFilter {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Utility$$ExternalSyntheticLambda3(int i) {
        this.$r8$classId = i;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.$r8$classId) {
            case 0:
                return Utility.refreshBestGuessNumberOfCPUCores$lambda$6(file, str);
            case 1:
                return FileLruCache.BufferFile.filterExcludeBufferFiles$lambda$0(file, str);
            default:
                return FileLruCache.BufferFile.filterExcludeNonBufferFiles$lambda$1(file, str);
        }
    }
}
