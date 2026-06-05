package androidx.health.platform.client.utils;

import android.content.Intent;
import android.os.Bundle;
import androidx.health.platform.client.proto.AbstractMessageLite;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u0005\u001a \u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u001a@\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u000b\"\u0010\b\u0000\u0010\f*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\f0\u000e\u001a\u001a\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0010"}, d2 = {"putProtoMessages", "Landroid/content/Intent;", "name", "", "messages", "", "Landroidx/health/platform/client/proto/AbstractMessageLite;", "putByteArraysExtra", "byteArrays", "", "getProtoMessages", "", "T", "parser", "Lkotlin/Function1;", "getByteArraysExtra", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IntentExtKt {
    public static final List<byte[]> getByteArraysExtra(Intent intent, String str) {
        intent.getClass();
        str.getClass();
        Bundle bundleExtra = intent.getBundleExtra(str);
        if (bundleExtra == null) {
            return null;
        }
        int size = bundleExtra.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            byte[] byteArray = bundleExtra.getByteArray(String.valueOf(i));
            if (byteArray == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Required value was null.");
                return null;
            }
            arrayList.add(byteArray);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends AbstractMessageLite<?, ?>> List<T> getProtoMessages(Intent intent, String str, Function1<? super byte[], ? extends T> function1) {
        intent.getClass();
        str.getClass();
        function1.getClass();
        List<byte[]> byteArraysExtra = getByteArraysExtra(intent, str);
        if (byteArraysExtra == null) {
            return null;
        }
        List<byte[]> list = byteArraysExtra;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke(it.next()));
        }
        return arrayList;
    }

    public static final Intent putByteArraysExtra(Intent intent, String str, Collection<byte[]> collection) {
        intent.getClass();
        str.getClass();
        collection.getClass();
        Bundle bundle = new Bundle(collection.size());
        int i = 0;
        for (Object obj : collection) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            bundle.putByteArray(String.valueOf(i), (byte[]) obj);
            i = i2;
        }
        Unit unit = Unit.INSTANCE;
        Intent intentPutExtra = intent.putExtra(str, bundle);
        intentPutExtra.getClass();
        return intentPutExtra;
    }

    public static final Intent putProtoMessages(Intent intent, String str, Collection<? extends AbstractMessageLite<?, ?>> collection) {
        intent.getClass();
        str.getClass();
        collection.getClass();
        Collection<? extends AbstractMessageLite<?, ?>> collection2 = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(((AbstractMessageLite) it.next()).toByteArray());
        }
        return putByteArraysExtra(intent, str, arrayList);
    }
}
