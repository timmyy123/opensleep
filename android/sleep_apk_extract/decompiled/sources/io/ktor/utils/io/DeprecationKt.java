package io.ktor.utils.io;

import kotlin.Metadata;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/io/Source;", "", "readText", "(Lkotlinx/io/Source;)Ljava/lang/String;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class DeprecationKt {
    public static final String readText(Source source) {
        source.getClass();
        return Utf8Kt.readString(source);
    }
}
