package com.urbandroid.common.error;

import com.urbandroid.common.logging.Logger;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface IAdditionalDataProvider {
    Map<String, String> getAdditionalData();

    Set<Logger.LogConfig> getAdditionalLogs();

    void logThrowable(Throwable th);
}
