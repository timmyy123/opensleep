package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import javax.inject.Named;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EventStoreModule {
    @Named("SQLITE_DB_NAME")
    public static String dbName() {
        return "com.google.android.datatransport.events";
    }

    @Singleton
    @Named("PACKAGE_NAME")
    public static String packageName(Context context) {
        return context.getPackageName();
    }

    @Named("SCHEMA_VERSION")
    public static int schemaVersion() {
        return SchemaManager.SCHEMA_VERSION;
    }

    public static EventStoreConfig storeConfig() {
        return EventStoreConfig.DEFAULT;
    }
}
