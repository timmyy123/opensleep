package com.urbandroid.common.error;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import com.urbandroid.common.error.ErrorReport;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.CollectionUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultErrorReportSerializer implements IErrorReportSerializer {

    /* JADX INFO: renamed from: com.urbandroid.common.error.DefaultErrorReportSerializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbandroid$common$error$ErrorReport$Type;

        static {
            int[] iArr = new int[ErrorReport.Type.values().length];
            $SwitchMap$com$urbandroid$common$error$ErrorReport$Type = iArr;
            try {
                iArr[ErrorReport.Type.EXCEPTION_THROWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbandroid$common$error$ErrorReport$Type[ErrorReport.Type.LOCK_UP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbandroid$common$error$ErrorReport$Type[ErrorReport.Type.ON_DEMAND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void serializeAdditionalLogs(OutputStream outputStream, Logger.LogConfig logConfig, List<Logger.LogRecord> list, File[] fileArr) throws IOException {
        outputStream.write(("*********************************** Log " + logConfig.logName + " BELOW *************************************\n").getBytes());
        serializeLogFiles(outputStream, fileArr);
        serializeInMemoryLogs(outputStream, list);
        outputStream.write(("*********************************** Log " + logConfig.logName + " ABOVE *************************************\n").getBytes());
    }

    public static String serializeException(Throwable th) {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace.length > 0) {
            sb.append("--------- Stack trace ---------\n");
            sb.append(th.toString());
            sb.append("\n");
            sb.append(Logger.appendStackTrace(stackTrace));
            sb.append("-------------------------------\n");
        }
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            sb.append("----------- Cause -----------\n");
            sb.append(cause.toString());
            sb.append("\n");
            sb.append(Logger.appendStackTrace(cause.getStackTrace()));
            sb.append("-----------------------------\n");
        }
        sb.append("-------------------------------\n");
        return sb.toString();
    }

    public static void serializeInMemoryLogs(OutputStream outputStream, List<Logger.LogRecord> list) throws IOException {
        Iterator<Logger.LogRecord> it = list.iterator();
        while (it.hasNext()) {
            outputStream.write(it.next().getFormattedRecord().getBytes());
            outputStream.write("\n".getBytes());
        }
    }

    public static void serializeLogFiles(OutputStream outputStream, File[] fileArr) throws IOException {
        byte[] bArr = new byte[32768];
        int length = fileArr.length - 1;
        int length2 = fileArr.length - 1;
        long j = 0;
        while (true) {
            int i = length2;
            int i2 = length;
            length = i;
            if (length < 0) {
                length = i2;
                break;
            }
            if (fileArr[length].exists()) {
                long length3 = fileArr[length].length() + j;
                if (length3 > 2097152) {
                    break;
                } else {
                    j = length3;
                }
            }
            length2 = length - 1;
        }
        while (length >= 0 && length < fileArr.length) {
            FileInputStream fileInputStream = new FileInputStream(fileArr[length]);
            while (true) {
                int i3 = fileInputStream.read(bArr);
                if (i3 >= 0) {
                    outputStream.write(bArr, 0, i3);
                }
            }
            fileInputStream.close();
            length++;
        }
    }

    private void serializePersistentLogFiles(OutputStream outputStream, File[] fileArr) throws IOException {
        if (fileArr == null || fileArr.length == 0) {
            return;
        }
        outputStream.write("*********************************** DISK LOGS BELOW THIS LINE *************************************\n".getBytes());
        serializeLogFiles(outputStream, fileArr);
        outputStream.write("*** DISK LOGS ABOVE THIS LINE ***".getBytes());
        outputStream.write("************************************************************************************\n".getBytes());
    }

    public static String serializeStackTraces(Map<Thread, StackTraceElement[]> map) {
        StringBuilder sb = new StringBuilder("********************************* Crash report ********************************************\n");
        for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
            sb.append(serializeThreadStackTrace(entry.getKey(), entry.getValue()));
            sb.append("\n");
        }
        sb.append("*******************************************************************************************\n");
        return sb.toString();
    }

    public static String serializeThreadStackTrace(Thread thread, StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        try {
            if (stackTraceElementArr.length > 0) {
                sb.append("--------- Stack trace of thread ");
                sb.append(thread.getName());
                sb.append(" State: " + thread.getState() + " ---------\n");
                sb.append(Logger.appendStackTrace(stackTraceElementArr));
                sb.append("--------------------------------------------------------\n\n");
            }
        } catch (Exception e) {
            sb.append("Failed to serialize thread with exception: " + e);
        }
        return sb.toString();
    }

    public String serializeAdditionalData(Map<String, String> map) {
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("*********************************** Additional data *************************************\n");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(":\t");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        sb.append("******************************************************************************************\n");
        return sb.toString();
    }

    public String serializeApplicationInfo(ErrorApplicationInfo errorApplicationInfo) {
        return "********************************* Application ********************************************\nName:\t\t\t" + errorApplicationInfo.getApplicationName() + "\nVersion:\t\t\t" + errorApplicationInfo.getVersionName() + MqttTopic.TOPIC_LEVEL_SEPARATOR + errorApplicationInfo.getVersionCode() + "\n******************************************************************************************\n";
    }

    public String serializeDeviceInfo(ErrorDeviceInfo errorDeviceInfo) {
        return "*********************************** Device ***********************************************\nManufacturer:\t\t\t" + errorDeviceInfo.getManufacturer() + "\nModel:\t\t\t" + errorDeviceInfo.getModel() + "\nProduct:\t\t\t" + errorDeviceInfo.getProduct() + " " + errorDeviceInfo.getRooted() + "\nFingerprint:\t\t\t" + errorDeviceInfo.getFingerprint() + "\nCPU:\t\t\t" + errorDeviceInfo.getCpuAbi() + "\n******************************************************************************************\n";
    }

    public String serializeEnvironmentInfo(ErrorEnvironmentInfo errorEnvironmentInfo) {
        return "********************************* Environment ********************************************\nLocale:\t\t\t" + errorEnvironmentInfo.getLocaleName() + "\nOrientation:\t\t\t" + errorEnvironmentInfo.getOrientation() + "\nKeyboard hidden:\t\t\t" + errorEnvironmentInfo.getKeyboardHidden() + "\nHard kb. hidden:\t\t\t" + errorEnvironmentInfo.getHardKeyboardHidden() + "\nMNC/MCC:\t\t\t" + errorEnvironmentInfo.getMnc() + MqttTopic.TOPIC_LEVEL_SEPARATOR + errorEnvironmentInfo.getMcc() + "\nEM:\t\t\t" + errorEnvironmentInfo.isEmulator() + "\n******************************************************************************************\n******************************** Message queue *******************************************\n" + errorEnvironmentInfo.getHandlerQueue() + "******************************************************************************************\n";
    }

    public String serializeHeader(ErrorReport errorReport) {
        StringBuilder sb = new StringBuilder("********************************* Crash report ********************************************\n");
        sb.append("Crash time:\t" + new Date(errorReport.getTimestamp()));
        sb.append("\n");
        int i = AnonymousClass1.$SwitchMap$com$urbandroid$common$error$ErrorReport$Type[errorReport.getType().ordinal()];
        if (i == 1) {
            sb.append("Application ");
            sb.append(errorReport.getApplicationInfo().getApplicationName());
            sb.append(" generated following error in '");
            sb.append(errorReport.getExceptionInfo().getExceptionThreadName());
            sb.append("' thread:\n");
            sb.append(serializeException(errorReport.getExceptionInfo().getThrowable()));
        } else if (i == 2) {
            sb.append("Application ");
            sb.append(errorReport.getApplicationInfo().getApplicationName());
            sb.append(" lockup detected\n");
        } else if (i == 3) {
            sb.append("Application ");
            sb.append(errorReport.getApplicationInfo().getApplicationName());
            sb.append(" on demand error in '");
            sb.append(errorReport.getExceptionInfo().getExceptionThreadName());
            sb.append("' thread:\n");
            if (errorReport.getExceptionInfo() == null) {
                sb.append(serializeException(errorReport.getExceptionInfo().getThrowable()));
            }
        }
        sb.append("******************************************************************************************\n");
        return sb.toString();
    }

    public String serializeLogcat(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        return "*********************************** Global log *************************************\n" + CollectionUtils.toString(list, "") + "************************************************************************************\n";
    }

    public String serializeLogs(List<Logger.LogRecord> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("*********************************** Application log *************************************\n");
        Iterator<Logger.LogRecord> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getFormattedRecord());
            sb.append("\n");
        }
        sb.append("*** LOGS_HEAD ***************************************************************************************\n");
        return sb.toString();
    }

    public String serializePastExceptions(Context context) {
        String strLoadPastExceptions = ErrorReporter.loadPastExceptions(context);
        if (strLoadPastExceptions.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder("*********************************** Past exceptions *****************************************\n");
        if (strLoadPastExceptions.length() > 0) {
            sb.append(strLoadPastExceptions);
            sb.append("\n");
        }
        sb.append("******************************************************************************************\n");
        return sb.toString();
    }

    public String serializeResourceUsage(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        return "*********************************** Resource usages *************************************\n" + CollectionUtils.toString(list, "\n") + "************************************************************************************\n";
    }

    public String serializeUserComment(String str) {
        return (str == null || str.length() == 0) ? "" : FileInsert$$ExternalSyntheticOutline0.m("*********************************** User comment *****************************************\n", str, "\n******************************************************************************************\n");
    }

    @Override // com.urbandroid.common.error.IErrorReportSerializer
    public void serzializeErrorReport(Context context, ErrorReport errorReport, OutputStream outputStream) throws IOException {
        outputStream.write(serializeHeader(errorReport).getBytes());
        outputStream.write(serializeHeader(errorReport).getBytes());
        outputStream.write(serializeStackTraces(errorReport.getExceptionInfo().getAllTraces()).getBytes());
        serializePersistentLogFiles(outputStream, errorReport.getPersistentLogFiles());
        outputStream.write(serializeLogs(errorReport.getLoggerOutput()).getBytes());
        if (errorReport.getAdditionalLoggerOutput() != null) {
            for (Logger.LogConfig logConfig : errorReport.getAdditionalLoggerOutput().keySet()) {
                serializeAdditionalLogs(outputStream, logConfig, errorReport.getAdditionalLoggerOutput().get(logConfig), errorReport.getAdditionalLogFiles().get(logConfig));
            }
        }
        outputStream.write(serializeLogcat(errorReport.getLogcatOutput()).getBytes());
        outputStream.write(serializeResourceUsage(errorReport.getResourceUsage()).getBytes());
        outputStream.write(serializeApplicationInfo(errorReport.getApplicationInfo()).getBytes());
        outputStream.write(serializeDeviceInfo(errorReport.getDeviceInfo()).getBytes());
        outputStream.write(serializeEnvironmentInfo(errorReport.getEnvironmentInfo()).getBytes());
        outputStream.write(serializeAdditionalData(errorReport.getAdditionalData()).getBytes());
        outputStream.write(serializeUserComment(errorReport.getUserComment()).getBytes());
        if (errorReport.getType() == ErrorReport.Type.ON_DEMAND) {
            outputStream.write(serializePastExceptions(context).getBytes());
        }
    }
}
