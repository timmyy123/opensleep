package io.rebble.pebblekit2.client;

import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0003"}, d2 = {"SELECTED_APP_KEY", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "client_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class DefaultPebbleAndroidAppPickerKt {
    private static final Preferences.Key<String> SELECTED_APP_KEY = PreferencesKeys.stringKey("selected_app");
}
