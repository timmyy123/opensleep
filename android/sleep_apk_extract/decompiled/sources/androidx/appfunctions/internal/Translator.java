package androidx.appfunctions.internal;

import androidx.appfunctions.AppFunctionData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/appfunctions/internal/Translator;", "", "upgradeRequest", "Landroidx/appfunctions/AppFunctionData;", "request", "upgradeResponse", "response", "downgradeRequest", "downgradeResponse", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Translator {
    AppFunctionData downgradeRequest(AppFunctionData request);

    AppFunctionData downgradeResponse(AppFunctionData response);

    AppFunctionData upgradeRequest(AppFunctionData request);

    AppFunctionData upgradeResponse(AppFunctionData response);
}
