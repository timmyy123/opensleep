package com.spotify.protocol.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RequiredFeatures {
    public static final List<String> NONE = Collections.EMPTY_LIST;
    public static final List<String> FEATURES = Collections.unmodifiableList(Arrays.asList("com.spotify.features.v1", "com.spotify.features.v2", "com.spotify.features.v3"));
}
