package com.urbandroid.sleep.nearby.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0010\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"serviceNamePrefix", "", "rendezvousServiceName", "getServiceName", "sharedSecret", "rendezvous", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "logger", "Lcom/urbandroid/sleep/nearby/core/MyLogger;", "timeoutMillis", "Ljava/util/concurrent/atomic/AtomicLong;", "generateToken", "length", "", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ServiceNamesKt {
    private static final String rendezvousServiceName = FileInsert$$ExternalSyntheticOutline0.m$1("com.urbandroid.sleep.nearby", ".rendezvous");
    private static final String serviceNamePrefix = "com.urbandroid.sleep.nearby";

    public static final String generateToken(int i) {
        Random random = new Random();
        IntRange intRange = new IntRange(1, i);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(Character.valueOf("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(62))));
        }
        return CollectionsKt.joinToString$default(arrayList, "", "", "", null, 56);
    }

    public static /* synthetic */ String generateToken$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 10;
        }
        return generateToken(i);
    }

    public static final String getServiceName(String str) {
        str.getClass();
        return FileInsert$$ExternalSyntheticOutline0.m$1(serviceNamePrefix, ".", str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [T, com.urbandroid.sleep.nearby.core.Endpoint, java.io.Closeable] */
    public static final String rendezvous(Context context, MyLogger myLogger, AtomicLong atomicLong) {
        context.getClass();
        myLogger.getClass();
        atomicLong.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        final String strGenerateToken$default = generateToken$default(0, 1, null);
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = "";
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ?? endpoint = new Endpoint(rendezvousServiceName, context, myLogger, new Function1() { // from class: com.urbandroid.sleep.nearby.core.ServiceNamesKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ServiceNamesKt.rendezvous$lambda$0(strGenerateToken$default, ref$BooleanRef, ref$ObjectRef, ref$ObjectRef2, (byte[]) obj);
            }
        }, null, 16, null);
        ref$ObjectRef2.element = endpoint;
        while (System.currentTimeMillis() - jCurrentTimeMillis < atomicLong.get() && (((CharSequence) ref$ObjectRef.element).length() == 0 || !ref$BooleanRef.element)) {
            try {
                Thread.sleep(500L);
                if (endpoint.isConnected()) {
                    byte[] bytes = strGenerateToken$default.getBytes(Charsets.UTF_8);
                    bytes.getClass();
                    endpoint.send(bytes);
                }
            } finally {
            }
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(endpoint, null);
        return (((CharSequence) ref$ObjectRef.element).length() != 0 && ref$BooleanRef.element) ? strGenerateToken$default.compareTo((String) ref$ObjectRef.element) < 0 ? strGenerateToken$default : (String) ref$ObjectRef.element : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object, java.lang.String] */
    public static final Unit rendezvous$lambda$0(String str, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, byte[] bArr) {
        bArr.getClass();
        Charset charset = Charsets.UTF_8;
        ?? str2 = new String(bArr, charset);
        if (Intrinsics.areEqual((Object) str2, str)) {
            ref$BooleanRef.element = true;
        } else {
            ref$ObjectRef.element = str2;
            T t = ref$ObjectRef2.element;
            t.getClass();
            byte[] bytes = str2.getBytes(charset);
            bytes.getClass();
            ((Endpoint) t).send(bytes);
        }
        return Unit.INSTANCE;
    }
}
