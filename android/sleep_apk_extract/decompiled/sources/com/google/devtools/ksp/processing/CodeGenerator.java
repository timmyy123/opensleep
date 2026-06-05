package com.google.devtools.ksp.processing;

import java.io.OutputStream;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/google/devtools/ksp/processing/CodeGenerator;", "", "Lcom/google/devtools/ksp/processing/Dependencies;", "dependencies", "", "packageName", "fileName", "extensionName", "Ljava/io/OutputStream;", "createNewFile", "(Lcom/google/devtools/ksp/processing/Dependencies;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/io/OutputStream;", "api"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface CodeGenerator {
    static /* synthetic */ OutputStream createNewFile$default(CodeGenerator codeGenerator, Dependencies dependencies, String str, String str2, String str3, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: createNewFile");
            return null;
        }
        if ((i & 8) != 0) {
            str3 = "kt";
        }
        return codeGenerator.createNewFile(dependencies, str, str2, str3);
    }

    OutputStream createNewFile(Dependencies dependencies, String packageName, String fileName, String extensionName);
}
