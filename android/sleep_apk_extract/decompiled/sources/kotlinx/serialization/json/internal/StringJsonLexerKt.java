package kotlinx.serialization.json.internal;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlinx.serialization.json.Json;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"StringJsonLexer", "Lkotlinx/serialization/json/internal/StringJsonLexer;", "json", "Lkotlinx/serialization/json/Json;", ShareConstants.FEED_SOURCE_PARAM, "", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class StringJsonLexerKt {
    public static final StringJsonLexer StringJsonLexer(Json json, String str) {
        json.getClass();
        str.getClass();
        return !json.getConfiguration().getAllowComments() ? new StringJsonLexer(str) : new StringJsonLexerWithComments(str);
    }
}
