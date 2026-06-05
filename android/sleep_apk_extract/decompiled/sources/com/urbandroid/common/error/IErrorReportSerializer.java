package com.urbandroid.common.error;

import android.content.Context;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public interface IErrorReportSerializer {
    void serzializeErrorReport(Context context, ErrorReport errorReport, OutputStream outputStream);
}
