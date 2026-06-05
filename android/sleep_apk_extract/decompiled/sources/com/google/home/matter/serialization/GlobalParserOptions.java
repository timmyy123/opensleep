package com.google.home.matter.serialization;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/google/home/matter/serialization/GlobalParserOptions;", "", "<init>", "()V", "", "lenient", "Z", "getLenient", "()Z", "setLenient", "(Z)V", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalParserOptions {
    public static final GlobalParserOptions INSTANCE = new GlobalParserOptions();
    private static boolean lenient = true;

    private GlobalParserOptions() {
    }

    public final boolean getLenient() {
        return lenient;
    }
}
