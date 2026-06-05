package com.google.firebase.ai.type;

import com.google.firebase.ai.type.Content;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "role", "Lkotlin/Function1;", "Lcom/google/firebase/ai/type/Content$Builder;", "", "init", "Lcom/google/firebase/ai/type/Content;", "content", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/google/firebase/ai/type/Content;", "com.google.firebase-ai-logic-firebase-ai"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContentKt {
    public static final Content content(String str, Function1<? super Content.Builder, Unit> function1) {
        function1.getClass();
        Content.Builder builder = new Content.Builder();
        builder.role = str;
        function1.invoke(builder);
        return builder.build();
    }

    public static /* synthetic */ Content content$default(String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "user";
        }
        return content(str, function1);
    }
}
