package com.urbandroid.common.error;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.urbandroid.common.R$id;
import com.urbandroid.common.R$layout;
import com.urbandroid.common.R$string;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.os.ResourceUsageMonitor;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.version.ApplicationVersionExtractor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorReporter {
    private static ErrorReporter instance;
    private final AssertionFailureCounter assertionFailureCounter;
    private ErrorReporterConfiguration configuration;
    private Context contextActivity;
    private ErrorReportingExceptionHandler exceptionHandler;
    private AtomicBoolean unhandledExceptionReceived = new AtomicBoolean(false);

    private ErrorReporter(Context context, ErrorReporterConfiguration errorReporterConfiguration, ResourceUsageMonitor resourceUsageMonitor) {
        this.contextActivity = null;
        this.contextActivity = context;
        this.configuration = errorReporterConfiguration;
        this.assertionFailureCounter = new AssertionFailureCounter(context);
    }

    public static ErrorReporter getInstance() {
        ErrorReporter errorReporter;
        synchronized (ErrorReporter.class) {
            try {
                errorReporter = instance;
                if (errorReporter == null) {
                    throw new RuntimeException("Cannot access error reporter. Initialize it first!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return errorReporter;
    }

    public static synchronized void initialize(Context context, ErrorReporterConfiguration errorReporterConfiguration) {
        ErrorReporter errorReporter = new ErrorReporter(context, errorReporterConfiguration, errorReporterConfiguration.getResourceUsageMonitor());
        instance = errorReporter;
        errorReporter.exceptionHandler = new ErrorReportingExceptionHandler(errorReporter);
        Thread.setDefaultUncaughtExceptionHandler(instance.exceptionHandler);
        instance.configuration.getDispatcher().performStartupRecovery();
    }

    public static String loadPastExceptions(Context context) {
        try {
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput("EXCEPTIONS_ALL");
            StringBuilder sb = new StringBuilder("");
            byte[] bArr = new byte[1024];
            do {
                int i = fileInputStreamOpenFileInput.read(bArr);
                if (i == -1) {
                    break;
                }
                sb.append(new String(bArr, 0, i));
            } while (sb.length() < 50000);
            fileInputStreamOpenFileInput.close();
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private void serializeException(Thread thread, Throwable th) {
        String strLoadPastExceptions = loadPastExceptions(this.contextActivity);
        if (strLoadPastExceptions.length() >= 50000) {
            strLoadPastExceptions = strLoadPastExceptions.substring(25000);
        }
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = this.contextActivity.openFileOutput("EXCEPTIONS_ALL", 0);
            fileOutputStreamOpenFileOutput.write(("************ PAST EXCEPTION [" + new Date() + "] Version: " + new ApplicationVersionExtractor().getCurrentVersion(this.contextActivity) + " Thread: " + thread.getName() + " **************\n").getBytes());
            fileOutputStreamOpenFileOutput.write(DefaultErrorReportSerializer.serializeException(th).getBytes());
            fileOutputStreamOpenFileOutput.write(strLoadPastExceptions.getBytes());
            fileOutputStreamOpenFileOutput.close();
        } catch (IOException e) {
            Logger.logSevere(e);
        }
    }

    public void generateAssertionError(AssertionType assertionType, String str) {
        Integer numAssertionFailed = this.assertionFailureCounter.assertionFailed(assertionType);
        if (numAssertionFailed != null) {
            this.configuration.getDispatcher().handleErrorReport(this.configuration.getGenerator().generateAssertionErrorReport(str + " (" + numAssertionFailed + ")"));
        }
    }

    public void generateOnDemandReport(Throwable th, String str, String str2) {
        this.configuration.getDispatcher().handleErrorReport(this.configuration.getGenerator().generateOnDemandErrorReport(str, str2, Thread.currentThread(), th));
    }

    public ErrorReportingExceptionHandler getExceptionHandler() {
        return this.exceptionHandler;
    }

    public void handleUncaughtException(Thread thread, Throwable th) {
        Logger.logSevere("Got uncaught error.", th);
        serializeException(thread, th);
        this.unhandledExceptionReceived.set(true);
        this.configuration.getDispatcher().handleErrorReport(this.configuration.getGenerator().generateUncaughtErrorReport(thread, th));
    }

    public Dialog provideOnDemandDialog(final Activity activity, final IErrorDialogAction iErrorDialogAction) {
        View viewInflate = activity.getLayoutInflater().inflate(R$layout.on_demand_report, (ViewGroup) null);
        final EditText editText = (EditText) viewInflate.findViewById(R$id.on_demand_report_text);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R$string.on_demand_report_title);
        builder.setView(viewInflate);
        builder.setNegativeButton(R$string.button_cancel, new DialogInterface.OnClickListener() { // from class: com.urbandroid.common.error.ErrorReporter.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setPositiveButton(R$string.on_demand_report_send, new DialogInterface.OnClickListener() { // from class: com.urbandroid.common.error.ErrorReporter.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IErrorDialogAction iErrorDialogAction2 = iErrorDialogAction;
                if (iErrorDialogAction2 != null) {
                    iErrorDialogAction2.execute(dialogInterface, editText.getText().toString());
                    return;
                }
                ErrorReporter.this.generateOnDemandReport(null, "Manual error", editText.getText().toString());
                Activity activity2 = activity;
                if (activity2 != null) {
                    Toast.makeText(activity2, R$string.generate_bug_report, 1).show();
                }
            }
        });
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.urbandroid.common.error.ErrorReporter.3
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button button;
                EditText editText2 = editText;
                if (editText2 == null || editText2.getText().length() != 0 || (button = alertDialogCreate.getButton(-1)) == null) {
                    return;
                }
                button.setEnabled(false);
                int currentTextColor = button.getCurrentTextColor();
                button.setTextColor(Color.argb(100, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: com.urbandroid.common.error.ErrorReporter.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Button button = alertDialogCreate.getButton(-1);
                if (button != null) {
                    if (charSequence == null || charSequence.length() < 1) {
                        button.setEnabled(false);
                        int currentTextColor = button.getCurrentTextColor();
                        button.setTextColor(Color.argb(100, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
                    } else {
                        button.setEnabled(true);
                        int currentTextColor2 = button.getCurrentTextColor();
                        button.setTextColor(Color.argb(PHIpAddressSearchManager.END_IP_SCAN, Color.red(currentTextColor2), Color.green(currentTextColor2), Color.blue(currentTextColor2)));
                    }
                }
            }
        });
        return alertDialogCreate;
    }

    public void generateAssertionError(AssertionType assertionType, String str, int i) {
        String imei;
        if (i < 1 || i > 100) {
            Logger.logWarning("Assertion percent should be in range from 1 to 100");
        }
        if (i >= 100 || ((imei = Environment.getImei(this.contextActivity)) != null && (Math.abs(imei.hashCode()) + 42) % 100 < i)) {
            generateAssertionError(assertionType, str);
        }
    }

    public Dialog provideOnDemandDialog(Activity activity) {
        return provideOnDemandDialog(activity, null);
    }
}
