package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlinx.serialization.json.Json;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "reader", "", "buffer", "Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "ReaderJsonLexer", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/InternalJsonReader;[C)Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ReaderJsonLexerKt {
    public static final ReaderJsonLexer ReaderJsonLexer(Json json, InternalJsonReader internalJsonReader, char[] cArr) {
        json.getClass();
        internalJsonReader.getClass();
        cArr.getClass();
        return !json.getConfiguration().getAllowComments() ? new ReaderJsonLexer(internalJsonReader, cArr) : new ReaderJsonLexerWithComments(internalJsonReader, cArr);
    }
}
