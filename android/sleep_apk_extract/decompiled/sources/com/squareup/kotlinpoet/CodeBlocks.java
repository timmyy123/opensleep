package com.squareup.kotlinpoet;

import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0006\u001a7\u0010\u0006\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Lcom/squareup/kotlinpoet/CodeBlock;", "", "separator", "prefix", "suffix", "joinToCode", "(Ljava/util/Collection;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Lcom/squareup/kotlinpoet/CodeBlock;", "kotlinpoet"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class CodeBlocks {
    public static final CodeBlock joinToCode(Collection<CodeBlock> collection, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        collection.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        CodeBlock[] codeBlockArr = (CodeBlock[]) collection.toArray(new CodeBlock[0]);
        int length = codeBlockArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = "%L";
        }
        return CodeBlock.INSTANCE.of(ArraysKt___ArraysKt.joinToString$default(strArr, charSequence, charSequence2, charSequence3, 0, (CharSequence) null, (Function1) null, 56, (Object) null), Arrays.copyOf(codeBlockArr, codeBlockArr.length));
    }

    public static /* synthetic */ CodeBlock joinToCode$default(Collection collection, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = ", ";
        }
        if ((i & 2) != 0) {
            charSequence2 = "";
        }
        if ((i & 4) != 0) {
            charSequence3 = "";
        }
        return joinToCode(collection, charSequence, charSequence2, charSequence3);
    }
}
