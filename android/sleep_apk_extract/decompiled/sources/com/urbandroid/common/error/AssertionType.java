package com.urbandroid.common.error;

/* JADX INFO: loaded from: classes4.dex */
public enum AssertionType {
    RECORDER_FAILURE("rec_failed"),
    ALARM_SERIALIZATION_FAILED("alarm_serialization_failed"),
    MEDIA_LIST("media_list"),
    SERVICE_BIND("service_bind"),
    TEMPORARY_PERSISTER("temporary_persister"),
    NEW_RECORDER_FAILURE("new_rec_failed"),
    GENERIC_ASSERTION_FAILURE("generic_failure"),
    UNCAUGHT_EXCEPTION("uncaught_exception");

    private final String preferenceCode;

    AssertionType(String str) {
        this.preferenceCode = str;
    }

    public String getPreferenceCode() {
        return this.preferenceCode;
    }
}
