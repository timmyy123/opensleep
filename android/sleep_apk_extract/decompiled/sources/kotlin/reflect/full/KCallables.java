package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\"(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\"$\u0010\u000b\u001a\u0004\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\b\u0010\t\"(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\f\u0010\u0004¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/KCallable;", "", "Lkotlin/reflect/KParameter;", "getContextParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "getContextParameters$annotations", "(Lkotlin/reflect/KCallable;)V", "contextParameters", "getExtensionReceiverParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "getExtensionReceiverParameter$annotations", "extensionReceiverParameter", "getValueParameters", "getValueParameters$annotations", "valueParameters", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class KCallables {
    public static final List<KParameter> getContextParameters(KCallable<?> kCallable) {
        kCallable.getClass();
        List<KParameter> parameters = kCallable.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((KParameter) obj).getKind() == KParameter.Kind.CONTEXT) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final KParameter getExtensionReceiverParameter(KCallable<?> kCallable) {
        kCallable.getClass();
        Iterator<T> it = kCallable.getParameters().iterator();
        Object obj = null;
        boolean z = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                    if (z) {
                        break;
                    }
                    z = true;
                    obj2 = next;
                }
            } else if (z) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    public static final List<KParameter> getValueParameters(KCallable<?> kCallable) {
        kCallable.getClass();
        List<KParameter> parameters = kCallable.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((KParameter) obj).getKind() == KParameter.Kind.VALUE) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
