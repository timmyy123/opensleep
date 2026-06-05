package com.squareup.kotlinpoet;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\bÀ\u0002\u0018\u00002\u00060\u0002j\u0002`\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/squareup/kotlinpoet/NullAppendable;", "Lkotlin/text/Appendable;", "Ljava/lang/Appendable;", "<init>", "()V", "append", "charSequence", "", "start", "", "end", "c", "", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NullAppendable implements Appendable {
    public static final NullAppendable INSTANCE = new NullAppendable();

    private NullAppendable() {
    }

    @Override // java.lang.Appendable
    public NullAppendable append(CharSequence charSequence) {
        charSequence.getClass();
        return this;
    }

    @Override // java.lang.Appendable
    public NullAppendable append(CharSequence charSequence, int start, int end) {
        charSequence.getClass();
        return this;
    }

    @Override // java.lang.Appendable
    public NullAppendable append(char c) {
        return this;
    }
}
