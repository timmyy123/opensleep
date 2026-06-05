package io.ktor.sse;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a/\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\b\" \u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"T", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "name", SDKConstants.PARAM_VALUE, "", "appendField", "(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/Object;)V", "Lkotlin/text/Regex;", "END_OF_LINE_VARIANTS", "Lkotlin/text/Regex;", "getEND_OF_LINE_VARIANTS", "()Lkotlin/text/Regex;", "getEND_OF_LINE_VARIANTS$annotations", "()V", "ktor-sse"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ServerSentEventKt {
    private static final Regex END_OF_LINE_VARIANTS = new Regex("\r\n|\r|\n");

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> void appendField(StringBuilder sb, String str, T t) {
        if (t != null) {
            Iterator<T> it = END_OF_LINE_VARIANTS.split(t.toString(), 0).iterator();
            while (it.hasNext()) {
                sb.append(str + ": " + ((String) it.next()) + "\r\n");
            }
        }
    }
}
