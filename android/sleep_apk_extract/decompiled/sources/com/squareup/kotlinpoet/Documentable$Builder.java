package com.squareup.kotlinpoet;

import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.Documentable$Builder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0010\b\u0000\u0010\u0002 \u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"com/squareup/kotlinpoet/Documentable$Builder", "Lcom/squareup/kotlinpoet/Documentable$Builder;", "T", "", "Lcom/squareup/kotlinpoet/CodeBlock;", "block", "addKdoc", "(Lcom/squareup/kotlinpoet/CodeBlock;)Lcom/squareup/kotlinpoet/Documentable$Builder;", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "getKdoc", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "kdoc", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Documentable$Builder<T extends Documentable$Builder<? extends T>> {
    /* JADX WARN: Multi-variable type inference failed */
    default T addKdoc(CodeBlock block) {
        block.getClass();
        getKdoc().add(block);
        return this;
    }

    CodeBlock.Builder getKdoc();
}
