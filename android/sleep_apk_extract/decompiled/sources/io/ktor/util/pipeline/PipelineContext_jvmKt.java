package io.ktor.util.pipeline;

import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001a\u0010\u0001\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "DISABLE_SFG", "Z", "getDISABLE_SFG", "()Z", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class PipelineContext_jvmKt {
    private static final boolean DISABLE_SFG = Intrinsics.areEqual(System.getProperty("io.ktor.internal.disable.sfg"), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);

    public static final boolean getDISABLE_SFG() {
        return DISABLE_SFG;
    }
}
