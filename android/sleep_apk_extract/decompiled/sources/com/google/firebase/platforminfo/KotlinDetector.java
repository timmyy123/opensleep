package com.google.firebase.platforminfo;

import kotlin.KotlinVersion;

/* JADX INFO: loaded from: classes4.dex */
public abstract class KotlinDetector {
    public static String detectVersion() {
        try {
            return KotlinVersion.CURRENT.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
