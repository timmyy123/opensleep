package org.eclipse.californium.elements.auth;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class AdditionalInfo {
    private static final Map<String, Object> EMPTY_MAP = new HashMap(0);
    private final Map<String, Object> info;

    private AdditionalInfo(Map<String, Object> map) {
        if (map == null) {
            this.info = EMPTY_MAP;
        } else {
            this.info = new HashMap(map);
        }
    }

    public static AdditionalInfo empty() {
        return new AdditionalInfo(null);
    }
}
