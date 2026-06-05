package com.google.firebase.ai.type;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"makeMissingCaseException", "Lcom/google/firebase/ai/type/SerializationException;", ShareConstants.FEED_SOURCE_PARAM, "", "ordinal", "", "com.google.firebase-ai-logic-firebase-ai"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExceptionsKt {
    public static final SerializationException makeMissingCaseException(String str, int i) {
        str.getClass();
        return new SerializationException(StringsKt__IndentKt.trimMargin$default("\n    |Missing case for a " + str + ": " + i + "\n    |This error indicates that one of the `toInternal` conversions needs updating.\n    |If you're a developer seeing this exception, please file an issue on our GitHub repo:\n    |https://github.com/firebase/firebase-android-sdk\n  ", null, 1, null), null, 2, null);
    }
}
