package com.google.gson.internal.sql;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SqlTypesSupport {
    public static final DefaultDateTypeAdapter.DateType<? extends Date> DATE_DATE_TYPE;
    public static final TypeAdapterFactory DATE_FACTORY;
    public static final List<TypeAdapterFactory> SQL_TYPE_FACTORIES;
    public static final boolean SUPPORTS_SQL_TYPES;
    public static final DefaultDateTypeAdapter.DateType<? extends Date> TIMESTAMP_DATE_TYPE;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final TypeAdapterFactory TIME_FACTORY;

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        SUPPORTS_SQL_TYPES = z;
        if (!z) {
            DATE_DATE_TYPE = null;
            TIMESTAMP_DATE_TYPE = null;
            DATE_FACTORY = null;
            TIME_FACTORY = null;
            TIMESTAMP_FACTORY = null;
            SQL_TYPE_FACTORIES = Collections.EMPTY_LIST;
            return;
        }
        DATE_DATE_TYPE = new DefaultDateTypeAdapter.DateType<java.sql.Date>(java.sql.Date.class) { // from class: com.google.gson.internal.sql.SqlTypesSupport.1
            @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
            public java.sql.Date deserialize(Date date) {
                return new java.sql.Date(date.getTime());
            }
        };
        TIMESTAMP_DATE_TYPE = new DefaultDateTypeAdapter.DateType<Timestamp>(Timestamp.class) { // from class: com.google.gson.internal.sql.SqlTypesSupport.2
            @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
            public Timestamp deserialize(Date date) {
                return new Timestamp(date.getTime());
            }
        };
        TypeAdapterFactory typeAdapterFactory = SqlDateTypeAdapter.FACTORY;
        DATE_FACTORY = typeAdapterFactory;
        TypeAdapterFactory typeAdapterFactory2 = SqlTimeTypeAdapter.FACTORY;
        TIME_FACTORY = typeAdapterFactory2;
        TypeAdapterFactory typeAdapterFactory3 = SqlTimestampTypeAdapter.FACTORY;
        TIMESTAMP_FACTORY = typeAdapterFactory3;
        SQL_TYPE_FACTORIES = Collections.unmodifiableList(Arrays.asList(typeAdapterFactory2, typeAdapterFactory, typeAdapterFactory3));
    }
}
