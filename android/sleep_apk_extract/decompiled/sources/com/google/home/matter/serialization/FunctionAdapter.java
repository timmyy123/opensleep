package com.google.home.matter.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B/\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\fR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/google/home/matter/serialization/FunctionAdapter;", "", "FROM", "TO", "Lcom/google/home/matter/serialization/FieldAdapter;", "Lkotlin/Function1;", "fromTo", "toFrom", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", SDKConstants.PARAM_VALUE, "toRaw", "(Ljava/lang/Object;)Ljava/lang/Object;", "toRuntime", "Lkotlin/jvm/functions/Function1;", "getFromTo", "()Lkotlin/jvm/functions/Function1;", "getToFrom", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FunctionAdapter<FROM, TO> implements FieldAdapter<FROM, TO> {
    private final Function1<FROM, TO> fromTo;
    private final Function1<TO, FROM> toFrom;

    /* JADX WARN: Multi-variable type inference failed */
    public FunctionAdapter(Function1<? super FROM, ? extends TO> function1, Function1<? super TO, ? extends FROM> function12) {
        function1.getClass();
        function12.getClass();
        this.fromTo = function1;
        this.toFrom = function12;
    }

    @Override // com.google.home.matter.serialization.FieldAdapter
    public FROM toRaw(TO value) {
        value.getClass();
        return this.toFrom.invoke(value);
    }

    @Override // com.google.home.matter.serialization.FieldAdapter
    public TO toRuntime(FROM value) {
        value.getClass();
        return this.fromTo.invoke(value);
    }
}
