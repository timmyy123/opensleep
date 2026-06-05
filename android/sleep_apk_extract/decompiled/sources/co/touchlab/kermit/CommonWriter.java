package co.touchlab.kermit;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lco/touchlab/kermit/CommonWriter;", "Lco/touchlab/kermit/LogWriter;", "messageStringFormatter", "Lco/touchlab/kermit/MessageStringFormatter;", "(Lco/touchlab/kermit/MessageStringFormatter;)V", "log", "", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lco/touchlab/kermit/Severity;", "message", "", "tag", "throwable", "", "kermit-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class CommonWriter extends LogWriter {
    private final MessageStringFormatter messageStringFormatter;

    public CommonWriter(MessageStringFormatter messageStringFormatter) {
        messageStringFormatter.getClass();
        this.messageStringFormatter = messageStringFormatter;
    }

    @Override // co.touchlab.kermit.LogWriter
    public void log(Severity severity, String message, String tag, Throwable throwable) {
        severity.getClass();
        message.getClass();
        tag.getClass();
        System.out.println((Object) this.messageStringFormatter.mo234formatMessageSNKSsE8(severity, Tag.m239constructorimpl(tag), Message.m236constructorimpl(message)));
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }
}
