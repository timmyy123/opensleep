package com.google.home.matter.serialization.codec.json;

import com.google.home.matter.serialization.FieldAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class JsonClusterWriter$BaseWriter$adapt$1 extends FunctionReferenceImpl implements Function1 {
    public JsonClusterWriter$BaseWriter$adapt$1(Object obj) {
        super(1, obj, FieldAdapter.class, "toRaw", "toRaw(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final T invoke(Object obj) {
        obj.getClass();
        return ((FieldAdapter) this.receiver).toRaw(obj);
    }
}
