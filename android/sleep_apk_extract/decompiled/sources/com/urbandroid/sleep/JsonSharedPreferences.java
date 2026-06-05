package com.urbandroid.sleep;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u0007*\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/JsonSharedPreferences;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/SharedPreferences;", "prefs", "<init>", "(Landroid/content/SharedPreferences;)V", "", "", "delete", "(Ljava/lang/String;)V", "", "obj", "save", "(Ljava/lang/String;Ljava/lang/Object;)V", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonSharedPreferences implements FeatureLogger {
    private final Gson gson;
    private final SharedPreferences prefs;
    private final String tag;

    public JsonSharedPreferences(SharedPreferences sharedPreferences) {
        sharedPreferences.getClass();
        this.prefs = sharedPreferences;
        this.tag = "prefs-json";
        this.gson = new Gson();
    }

    public final void delete(String str) {
        str.getClass();
        SharedPreferences.Editor editorEdit = this.prefs.edit();
        editorEdit.remove(str);
        editorEdit.apply();
        String str2 = Logger.defaultTag;
        Logger.logDebug(str2, getTag() + ": " + (str + " deleted"), null);
    }

    public final Gson getGson() {
        return this.gson;
    }

    public final SharedPreferences getPrefs() {
        return this.prefs;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final void save(String str, Object obj) {
        str.getClass();
        SharedPreferences.Editor editorEdit = this.prefs.edit();
        if (obj != null) {
            editorEdit.putString(str, this.gson.toJson(obj));
            String str2 = Logger.defaultTag;
            Logger.logDebug(str2, getTag() + ": " + (str + " stored"), null);
        } else {
            editorEdit.remove(str);
            String str3 = Logger.defaultTag;
            Logger.logDebug(str3, getTag() + ": " + (str + " deleted"), null);
        }
        editorEdit.apply();
    }
}
