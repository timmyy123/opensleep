package com.urbandroid.common.error;

import com.urbandroid.common.logging.Logger;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorReport {
    private final HashMap<String, String> additionalData = new LinkedHashMap();
    private final Map<Logger.LogConfig, File[]> additionalLogFiles;
    private final Map<Logger.LogConfig, List<Logger.LogRecord>> additionalLoggerOutput;
    private final ErrorApplicationInfo applicationInfo;
    private final ErrorDeviceInfo deviceInfo;
    private final ErrorEnvironmentInfo environmentInfo;
    private final ErrorExceptionInfo exceptionInfo;
    private final List<String> logcatOutput;
    private final List<Logger.LogRecord> loggerOutput;
    private final File[] persistentLogFiles;
    private final List<String> resourceUsage;
    private final String shortSummary;
    private final long timestamp;
    private final Type type;
    private final String userComment;

    public enum Type {
        EXCEPTION_THROWN,
        LOCK_UP,
        ON_DEMAND,
        ASSERTION_FAILED
    }

    public ErrorReport(long j, Type type, String str, String str2, ErrorExceptionInfo errorExceptionInfo, ErrorEnvironmentInfo errorEnvironmentInfo, ErrorApplicationInfo errorApplicationInfo, ErrorDeviceInfo errorDeviceInfo, List<Logger.LogRecord> list, File[] fileArr, List<String> list2, Collection<String> collection) {
        LinkedList linkedList = new LinkedList();
        this.loggerOutput = linkedList;
        LinkedList linkedList2 = new LinkedList();
        this.logcatOutput = linkedList2;
        LinkedList linkedList3 = new LinkedList();
        this.resourceUsage = linkedList3;
        this.additionalLogFiles = new HashMap();
        this.additionalLoggerOutput = new HashMap();
        this.timestamp = j;
        this.type = type;
        this.shortSummary = str;
        this.userComment = str2;
        this.applicationInfo = errorApplicationInfo;
        this.deviceInfo = errorDeviceInfo;
        this.environmentInfo = errorEnvironmentInfo;
        this.exceptionInfo = errorExceptionInfo;
        linkedList.addAll(list);
        linkedList2.addAll(list2);
        linkedList3.addAll(collection);
        this.persistentLogFiles = fileArr;
    }

    public void addAdditionalData(Map<String, String> map) {
        this.additionalData.putAll(map);
    }

    public void addAdditionalLogData(Logger.LogConfig logConfig, List<Logger.LogRecord> list, File[] fileArr) {
        this.additionalLoggerOutput.put(logConfig, list);
        this.additionalLogFiles.put(logConfig, fileArr);
    }

    public Map<String, String> getAdditionalData() {
        return new LinkedHashMap(this.additionalData);
    }

    public Map<Logger.LogConfig, File[]> getAdditionalLogFiles() {
        return this.additionalLogFiles;
    }

    public Map<Logger.LogConfig, List<Logger.LogRecord>> getAdditionalLoggerOutput() {
        return this.additionalLoggerOutput;
    }

    public ErrorApplicationInfo getApplicationInfo() {
        return this.applicationInfo;
    }

    public ErrorDeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public ErrorEnvironmentInfo getEnvironmentInfo() {
        return this.environmentInfo;
    }

    public ErrorExceptionInfo getExceptionInfo() {
        return this.exceptionInfo;
    }

    public List<String> getLogcatOutput() {
        return Collections.unmodifiableList(this.logcatOutput);
    }

    public List<Logger.LogRecord> getLoggerOutput() {
        return Collections.unmodifiableList(this.loggerOutput);
    }

    public File[] getPersistentLogFiles() {
        return this.persistentLogFiles;
    }

    public List<String> getResourceUsage() {
        return Collections.unmodifiableList(this.resourceUsage);
    }

    public String getShortSummary() {
        return this.shortSummary;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public Type getType() {
        return this.type;
    }

    public String getUserComment() {
        return this.userComment;
    }
}
