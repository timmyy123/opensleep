package co.touchlab.kermit;

import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lco/touchlab/kermit/LogcatWriter;", "Lco/touchlab/kermit/LogWriter;", "messageStringFormatter", "Lco/touchlab/kermit/MessageStringFormatter;", "(Lco/touchlab/kermit/MessageStringFormatter;)V", "testWriter", "Lco/touchlab/kermit/CommonWriter;", "log", "", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lco/touchlab/kermit/Severity;", "message", "", "tag", "throwable", "", "kermit-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LogcatWriter extends LogWriter {
    private final MessageStringFormatter messageStringFormatter;
    private final CommonWriter testWriter;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Severity.values().length];
            try {
                iArr[Severity.Verbose.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Severity.Debug.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Severity.Info.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Severity.Warn.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Severity.Error.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Severity.Assert.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LogcatWriter(MessageStringFormatter messageStringFormatter) {
        messageStringFormatter.getClass();
        this.messageStringFormatter = messageStringFormatter;
        this.testWriter = new CommonWriter(messageStringFormatter);
    }

    @Override // co.touchlab.kermit.LogWriter
    public void log(Severity severity, String message, String tag, Throwable throwable) {
        severity.getClass();
        message.getClass();
        tag.getClass();
        String strMo234formatMessageSNKSsE8 = this.messageStringFormatter.mo234formatMessageSNKSsE8(null, null, Message.m236constructorimpl(message));
        try {
            if (throwable == null) {
                switch (WhenMappings.$EnumSwitchMapping$0[severity.ordinal()]) {
                    case 1:
                        Log.v(tag, strMo234formatMessageSNKSsE8);
                        break;
                    case 2:
                        Log.d(tag, strMo234formatMessageSNKSsE8);
                        break;
                    case 3:
                        Log.i(tag, strMo234formatMessageSNKSsE8);
                        break;
                    case 4:
                        Log.w(tag, strMo234formatMessageSNKSsE8);
                        break;
                    case 5:
                        Log.e(tag, strMo234formatMessageSNKSsE8);
                        break;
                    case 6:
                        Log.wtf(tag, strMo234formatMessageSNKSsE8);
                        break;
                }
            }
            switch (WhenMappings.$EnumSwitchMapping$0[severity.ordinal()]) {
                case 1:
                    Log.v(tag, strMo234formatMessageSNKSsE8, throwable);
                    break;
                case 2:
                    Log.d(tag, strMo234formatMessageSNKSsE8, throwable);
                    break;
                case 3:
                    Log.i(tag, strMo234formatMessageSNKSsE8, throwable);
                    break;
                case 4:
                    Log.w(tag, strMo234formatMessageSNKSsE8, throwable);
                    break;
                case 5:
                    Log.e(tag, strMo234formatMessageSNKSsE8, throwable);
                    break;
                case 6:
                    Log.wtf(tag, strMo234formatMessageSNKSsE8, throwable);
                    break;
            }
        } catch (Exception unused) {
            this.testWriter.log(severity, message, tag, throwable);
        }
    }

    public /* synthetic */ LogcatWriter(MessageStringFormatter messageStringFormatter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DefaultFormatter.INSTANCE : messageStringFormatter);
    }
}
