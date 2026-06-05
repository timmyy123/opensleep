package io.ktor.serialization.kotlinx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.SerialFormat;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/SerialFormat;", "format", "", "Lio/ktor/serialization/kotlinx/KotlinxSerializationExtension;", "extensions", "(Lkotlinx/serialization/SerialFormat;)Ljava/util/List;", "ktor-serialization-kotlinx"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ExtensionsKt {
    public static final List<KotlinxSerializationExtension> extensions(SerialFormat serialFormat) {
        serialFormat.getClass();
        List<KotlinxSerializationExtensionProvider> providers = ExtensionsJvmKt.getProviders();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = providers.iterator();
        while (it.hasNext()) {
            KotlinxSerializationExtension kotlinxSerializationExtensionExtension = ((KotlinxSerializationExtensionProvider) it.next()).extension(serialFormat);
            if (kotlinxSerializationExtensionExtension != null) {
                arrayList.add(kotlinxSerializationExtensionExtension);
            }
        }
        return arrayList;
    }
}
