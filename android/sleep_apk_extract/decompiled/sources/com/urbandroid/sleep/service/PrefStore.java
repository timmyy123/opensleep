package com.urbandroid.sleep.service;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/urbandroid/sleep/service/PrefStore;", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "prefName", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", SDKConstants.PARAM_KEY, SDKConstants.PARAM_VALUE, "", "save", "(Ljava/lang/String;Ljava/lang/Object;)V", "append", "(Ljava/lang/String;Ljava/lang/String;)V", "", "defaultValue", "getInt", "(Ljava/lang/String;I)I", "pageId", "", "noneChecked", "(Ljava/lang/String;)Z", "index", "checked", "(Ljava/lang/String;I)Z", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/lang/String;", "getPrefName", "()Ljava/lang/String;", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PrefStore {
    private final Context context;
    private final String prefName;
    private final SharedPreferences sharedPreferences;

    public PrefStore(Context context, String str) {
        context.getClass();
        str.getClass();
        this.context = context;
        this.prefName = str;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        sharedPreferences.getClass();
        this.sharedPreferences = sharedPreferences;
    }

    public static /* synthetic */ int getInt$default(PrefStore prefStore, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return prefStore.getInt(str, i);
    }

    public final void append(String key, String value) {
        key.getClass();
        value.getClass();
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Preview: ", this.prefName, " save ", key, " = ");
        sbM6m.append(value);
        Logger.logInfo(sbM6m.toString());
        editorEdit.putString(key, this.sharedPreferences.getString(key, "") + value);
        editorEdit.apply();
    }

    public final boolean checked(String pageId, int index) {
        pageId.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(pageId);
        sb.append("_check_");
        sb.append(index);
        return getInt$default(this, sb.toString(), 0, 2, null) == 1;
    }

    public final int getInt(String key, int defaultValue) {
        key.getClass();
        return this.sharedPreferences.getInt(key, defaultValue);
    }

    public final boolean noneChecked(String pageId) {
        pageId.getClass();
        IntRange intRange = new IntRange(0, 10);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(getInt$default(this, pageId + "_check_" + ((IntIterator) it).nextInt(), 0, 2, null)));
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (((Number) it2.next()).intValue() >= 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void save(String key, Object value) {
        key.getClass();
        value.getClass();
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Preview: ", this.prefName, " save ", key, " = ");
        sbM6m.append(value);
        Logger.logInfo(sbM6m.toString());
        if (value instanceof String) {
            editorEdit.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editorEdit.putInt(key, ((Number) value).intValue());
        } else if (value instanceof Boolean) {
            editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
        } else if (value instanceof Float) {
            editorEdit.putFloat(key, ((Number) value).floatValue());
        } else {
            if (!(value instanceof Long)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Unsupported type");
                return;
            }
            editorEdit.putLong(key, ((Number) value).longValue());
        }
        editorEdit.apply();
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        Map<String, ?> all = this.sharedPreferences.getAll();
        all.getClass();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String) {
                String key = entry.getKey();
                Object value2 = entry.getValue();
                value2.getClass();
                bundle.putString(key, (String) value2);
            } else if (value instanceof Integer) {
                String key2 = entry.getKey();
                Object value3 = entry.getValue();
                value3.getClass();
                bundle.putInt(key2, ((Integer) value3).intValue());
            } else if (value instanceof Boolean) {
                String key3 = entry.getKey();
                Object value4 = entry.getValue();
                value4.getClass();
                bundle.putBoolean(key3, ((Boolean) value4).booleanValue());
            } else if (value instanceof Float) {
                String key4 = entry.getKey();
                Object value5 = entry.getValue();
                value5.getClass();
                bundle.putFloat(key4, ((Float) value5).floatValue());
            } else {
                if (!(value instanceof Long)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Unsupported type");
                    return null;
                }
                String key5 = entry.getKey();
                Object value6 = entry.getValue();
                value6.getClass();
                bundle.putLong(key5, ((Long) value6).longValue());
            }
        }
        return bundle;
    }
}
