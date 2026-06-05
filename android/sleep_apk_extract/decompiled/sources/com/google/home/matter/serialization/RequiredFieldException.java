package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/home/matter/serialization/RequiredFieldException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "tagName", "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Exception;)V", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RequiredFieldException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequiredFieldException(String str, Exception exc) {
        super(String.valueOf(str).concat(" is Required"), exc);
        str.getClass();
    }

    public /* synthetic */ RequiredFieldException(String str, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : exc);
    }
}
