package co.touchlab.kermit;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Lco/touchlab/kermit/MessageStringFormatter;", "", "formatMessage", "", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lco/touchlab/kermit/Severity;", "tag", "Lco/touchlab/kermit/Tag;", "message", "Lco/touchlab/kermit/Message;", "formatMessage-SNKSsE8", "(Lco/touchlab/kermit/Severity;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "formatSeverity", "formatTag", "formatTag-ntQDErM", "(Ljava/lang/String;)Ljava/lang/String;", "kermit-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MessageStringFormatter {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: formatMessage-SNKSsE8, reason: not valid java name */
        public static String m237formatMessageSNKSsE8(MessageStringFormatter messageStringFormatter, Severity severity, String str, String str2) {
            str2.getClass();
            if (severity == null && str == null) {
                return str2;
            }
            StringBuilder sb = new StringBuilder();
            if (severity != null) {
                sb.append(messageStringFormatter.formatSeverity(severity));
                sb.append(" ");
            }
            if (str != null && str.length() > 0) {
                sb.append(messageStringFormatter.mo235formatTagntQDErM(str));
                sb.append(" ");
            }
            sb.append(str2);
            return sb.toString();
        }

        public static String formatSeverity(MessageStringFormatter messageStringFormatter, Severity severity) {
            severity.getClass();
            StringBuilder sb = new StringBuilder();
            sb.append(severity);
            sb.append(':');
            return sb.toString();
        }

        /* JADX INFO: renamed from: formatTag-ntQDErM, reason: not valid java name */
        public static String m238formatTagntQDErM(MessageStringFormatter messageStringFormatter, String str) {
            str.getClass();
            return "(" + str + ')';
        }
    }

    /* JADX INFO: renamed from: formatMessage-SNKSsE8 */
    String mo234formatMessageSNKSsE8(Severity severity, String tag, String message);

    String formatSeverity(Severity severity);

    /* JADX INFO: renamed from: formatTag-ntQDErM */
    String mo235formatTagntQDErM(String tag);
}
