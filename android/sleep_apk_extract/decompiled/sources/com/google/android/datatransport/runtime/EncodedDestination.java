package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface EncodedDestination extends Destination {
    Set<Encoding> getSupportedEncodings();
}
