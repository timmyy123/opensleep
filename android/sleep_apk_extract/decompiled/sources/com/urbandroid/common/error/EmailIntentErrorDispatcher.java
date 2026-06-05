package com.urbandroid.common.error;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import androidx.core.content.FileProvider;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import com.facebook.internal.NativeProtocol;
import com.urbandroid.common.error.ErrorReport;
import com.urbandroid.common.file.FileCopyUtils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.ThreadUtil;
import com.urbandroid.common.version.ApplicationVersionExtractor;
import com.urbandroid.common.version.ApplicationVersionInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class EmailIntentErrorDispatcher implements IErrorDispatcher {
    private final String applicationName;
    private final IErrorDispatcherConfiguration configuration;
    private final Context contextActivity;
    private Handler handler;

    /* JADX INFO: renamed from: com.urbandroid.common.error.EmailIntentErrorDispatcher$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbandroid$common$error$ErrorReport$Type;

        static {
            int[] iArr = new int[ErrorReport.Type.values().length];
            $SwitchMap$com$urbandroid$common$error$ErrorReport$Type = iArr;
            try {
                iArr[ErrorReport.Type.LOCK_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbandroid$common$error$ErrorReport$Type[ErrorReport.Type.EXCEPTION_THROWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbandroid$common$error$ErrorReport$Type[ErrorReport.Type.ON_DEMAND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$urbandroid$common$error$ErrorReport$Type[ErrorReport.Type.ASSERTION_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class Submitter implements Runnable {
        private final Throwable error;
        private final ErrorReport.Type errorType;
        private final String optionalTitleText;
        private final String userComment;

        public Submitter(String str, String str2, ErrorReport.Type type, Throwable th) {
            this.optionalTitleText = str;
            this.userComment = str2;
            this.errorType = type;
            this.error = th;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            EmailIntentErrorDispatcher.this.sendDebugViaEmailIntent(this.optionalTitleText, this.userComment, this.errorType, this.error);
        }
    }

    public EmailIntentErrorDispatcher(Context context, Handler handler, String str, IErrorDispatcherConfiguration iErrorDispatcherConfiguration) {
        this.contextActivity = context;
        this.applicationName = str;
        this.configuration = iErrorDispatcherConfiguration;
        this.handler = handler;
    }

    private File getSaveDebugFile(ErrorReport.Type type) {
        return this.contextActivity.getFileStreamPath(getTemporaryFileName(type));
    }

    public static Intent getSelectiveIntentChooser(Context context, Intent intent, Intent intent2) {
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        Intent intentCreateChooser = null;
        if (!listQueryIntentActivities.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                String str = activityInfo != null ? activityInfo.packageName : null;
                Intent intent3 = new Intent(intent2);
                intent3.setComponent(new ComponentName(str, resolveInfo.activityInfo.name));
                intent3.setPackage(str);
                arrayList.add(intent3);
            }
            if (!arrayList.isEmpty()) {
                intentCreateChooser = Intent.createChooser((Intent) arrayList.remove(0), "");
                intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
                intentCreateChooser.addFlags(1);
            }
        }
        return intentCreateChooser == null ? intent2 : intentCreateChooser;
    }

    private File getSubmitDebugFile(ErrorReport.Type type) {
        String str = this.configuration.getReportFilename() + "-" + type + ".txt";
        if (!Environment.isMOrGreater()) {
            return new File(Environment.getExternalPublicWriteableStorage(), str);
        }
        File file = new File(this.contextActivity.getCacheDir(), "reports");
        try {
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            Logger.logWarning("Failed to create reports dir.", e);
        }
        return new File(this.contextActivity.getCacheDir(), "reports/".concat(str));
    }

    private String getTemporaryFileName(ErrorReport.Type type) {
        return this.configuration.getReportFilename() + "-" + type + ".tmp";
    }

    private Uri getUri(File file) {
        if (!Environment.isMOrGreater()) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(this.contextActivity, this.contextActivity.getPackageName() + ".fileprovider", file);
    }

    private String getVersionString() {
        ApplicationVersionInfo currentVersion = new ApplicationVersionExtractor().getCurrentVersion(this.contextActivity);
        return currentVersion.getVersionName() + " (" + currentVersion.getVersionCode() + ") " + Build.VERSION.SDK_INT;
    }

    private String loadErrorReport(File file, int i) throws Throwable {
        StringBuilder sb = new StringBuilder();
        long jCurrentTimeMillis = System.currentTimeMillis();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)), 100000);
            do {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null || line.length() > 100000) {
                        break;
                    }
                    sb.append(line);
                    sb.append("\n");
                } catch (FileNotFoundException unused) {
                    bufferedReader = bufferedReader2;
                    Logger.logInfo("Error report load time " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms. Length: " + sb.length());
                    if (bufferedReader == null) {
                        return "";
                    }
                    try {
                        bufferedReader.close();
                        return "";
                    } catch (Exception unused2) {
                        return "";
                    }
                } catch (IOException unused3) {
                    bufferedReader = bufferedReader2;
                    Logger.logInfo("Error report load time " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms. Length: " + sb.length());
                    if (bufferedReader == null) {
                        return "";
                    }
                    bufferedReader.close();
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    Logger.logInfo("Error report load time " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms. Length: " + sb.length());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } while (sb.length() <= i);
            String string = sb.toString();
            Logger.logInfo("Error report load time " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms. Length: " + sb.length());
            try {
                bufferedReader2.close();
            } catch (Exception unused5) {
            }
            return string;
        } catch (FileNotFoundException unused6) {
        } catch (IOException unused7) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String shorten(String str) {
        return str.length() <= 100000 ? str : str.substring(str.length() - 100000);
    }

    private void submit(String str, String str2, ErrorReport.Type type, Throwable th) throws Throwable {
        if (ThreadUtil.isInUiThread()) {
            new Submitter(str, str2, type, th).run();
            return;
        }
        if (this.handler == null) {
            try {
                this.handler = new Handler();
            } catch (Exception unused) {
                Logger.logSevere("Cannot create handler");
            }
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.post(new Submitter(str, str2, type, th));
        } else {
            new Submitter(str, str2, type, th).run();
        }
    }

    @Override // com.urbandroid.common.error.IErrorDispatcher
    public void handleErrorReport(ErrorReport errorReport) throws Throwable {
        Logger.logDebug("Email intent dispatcher handling error of type: " + errorReport.getType());
        saveDebugReport(errorReport, errorReport.getApplicationInfo().getVersionName(), errorReport.getType());
        if (errorReport.getType() == ErrorReport.Type.ASSERTION_FAILED) {
            return;
        }
        submit(errorReport.getShortSummary(), errorReport.getUserComment(), errorReport.getType(), errorReport.getExceptionInfo().getThrowable());
    }

    @Override // com.urbandroid.common.error.IErrorDispatcher
    public void performStartupRecovery() throws Throwable {
        ErrorReport.Type type = ErrorReport.Type.LOCK_UP;
        if (getSaveDebugFile(type).exists()) {
            submit(null, null, type, null);
        }
        ErrorReport.Type type2 = ErrorReport.Type.ASSERTION_FAILED;
        if (getSaveDebugFile(type2).exists()) {
            submit("Assertion failed", null, type2, null);
        }
    }

    public void saveDebugReport(ErrorReport errorReport, String str, ErrorReport.Type type) {
        long jCurrentTimeMillis;
        StringBuilder sb;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        try {
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = this.contextActivity.openFileOutput(getTemporaryFileName(type), !Environment.isNOrGreater() ? 32769 : 32768);
                this.configuration.getSerializer().serzializeErrorReport(this.contextActivity, errorReport, fileOutputStreamOpenFileOutput);
                fileOutputStreamOpenFileOutput.write("----------------- END OF REPORT ---------------------------\n\n".getBytes());
                fileOutputStreamOpenFileOutput.close();
                jCurrentTimeMillis = System.currentTimeMillis();
                sb = new StringBuilder("Error report save time ");
            } catch (IOException e) {
                Logger.logSevere(e);
                jCurrentTimeMillis = System.currentTimeMillis();
                sb = new StringBuilder("Error report save time ");
            }
            sb.append(jCurrentTimeMillis - jCurrentTimeMillis2);
            sb.append(" ms.");
            Logger.logInfo(sb.toString());
        } catch (Throwable th) {
            Logger.logInfo("Error report save time " + (System.currentTimeMillis() - jCurrentTimeMillis2) + " ms.");
            throw th;
        }
    }

    public Boolean sendDebugViaEmailIntent(String str, String str2, ErrorReport.Type type, Throwable th) throws Throwable {
        String onRecoveryMessageBody;
        File file;
        String str3;
        int i = AnonymousClass1.$SwitchMap$com$urbandroid$common$error$ErrorReport$Type[type.ordinal()];
        if (i == 1) {
            onRecoveryMessageBody = this.configuration.getOnRecoveryMessageBody();
        } else if (i == 2) {
            onRecoveryMessageBody = this.configuration.getMessageBody();
        } else if (i == 3) {
            onRecoveryMessageBody = this.configuration.getOnDemandMessageBody();
        } else {
            if (i != 4) {
                FacebookSdk$$ExternalSyntheticLambda1.m("Unexpected report type: ", (Object) type);
                return null;
            }
            onRecoveryMessageBody = this.configuration.getOnAssertionFailedMessageBody();
        }
        File saveDebugFile = getSaveDebugFile(type);
        File submitDebugFile = getSubmitDebugFile(type);
        try {
            file = submitDebugFile;
        } catch (Exception e) {
            e = e;
            file = submitDebugFile;
        }
        try {
            FileCopyUtils.copyPrivateFileToSdCardFile(this.contextActivity, saveDebugFile.getName(), file.getAbsolutePath());
        } catch (Exception e2) {
            e = e2;
            Logger.logSevere(e);
        }
        try {
            boolean z = file.exists() && file.length() > 0 && file.canRead();
            Logger.logInfo("Can use SD Card for report: " + z);
            String strLoadErrorReport = loadErrorReport(saveDebugFile, 10000000);
            String str4 = this.applicationName + " " + this.configuration.getSubject() + " - " + getVersionString();
            if (str != null) {
                str4 = str4 + " [" + str + "]";
            }
            String strConcat = "\n" + onRecoveryMessageBody + "\n\n";
            if (str2 != null) {
                strConcat = strConcat + "Your comment:\n" + str2 + "\n\n";
            }
            String str5 = "";
            if (th != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(strConcat);
                sb.append(th.getClass().getSimpleName());
                if (th.getMessage() != null) {
                    str3 = ": " + th.getMessage();
                } else {
                    str3 = "";
                }
                sb.append(str3);
                strConcat = sb.toString().concat("\n\n");
            }
            String str6 = strConcat + Build.MANUFACTURER + " " + Build.MODEL + "\n\n";
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:"));
            Intent intent2 = new Intent("android.intent.action.SEND_MULTIPLE");
            intent2.putExtra("android.intent.extra.EMAIL", this.configuration.getMailTo());
            if (!z) {
                str5 = shorten(strLoadErrorReport) + "\n\n";
            }
            intent2.putExtra("android.intent.extra.TEXT", str6.concat(str5));
            intent2.putExtra("android.intent.extra.SUBJECT", str4);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (z) {
                arrayList.add(getUri(file));
            }
            Iterator<File> it = ExtraReportFilesKt.parseExtraFiles(strLoadErrorReport).iterator();
            while (it.hasNext()) {
                arrayList.add(getUri(it.next()));
            }
            if (!arrayList.isEmpty()) {
                intent2.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            }
            intent2.setType("message/rfc822");
            boolean z2 = this.contextActivity.getPackageManager().queryIntentActivities(intent2, 0).size() > 0;
            Boolean boolValueOf = Boolean.valueOf(z2);
            if (!z2) {
                intent2 = new Intent("android.intent.action.SEND");
                intent2.putExtra("android.intent.extra.EMAIL", this.configuration.getMailTo());
                intent2.putExtra("android.intent.extra.SUBJECT", str4);
                intent2.putExtra("android.intent.extra.TEXT", str6 + shorten(strLoadErrorReport) + "\n\n");
                intent2.setType("text/plain");
                boolValueOf = Boolean.valueOf(this.contextActivity.getPackageManager().queryIntentActivities(intent2, 0).size() > 0);
            }
            if (!boolValueOf.booleanValue()) {
                Logger.logSevere("No intent to handle sending of message!");
                Boolean bool = Boolean.FALSE;
                try {
                    if (saveDebugFile.exists()) {
                        saveDebugFile.delete();
                    }
                } catch (Exception e3) {
                    Logger.logSevere(e3);
                }
                return bool;
            }
            intent2.setFlags(268697600);
            Logger.logDebug("Email intent sent to " + Arrays.toString(this.configuration.getMailTo()));
            Intent selectiveIntentChooser = getSelectiveIntentChooser(this.contextActivity, intent, intent2);
            selectiveIntentChooser.setFlags(268697600);
            this.contextActivity.startActivity(selectiveIntentChooser);
            Boolean bool2 = Boolean.TRUE;
            try {
                if (saveDebugFile.exists()) {
                    saveDebugFile.delete();
                }
            } catch (Exception e4) {
                Logger.logSevere(e4);
            }
            return bool2;
        } finally {
        }
    }
}
