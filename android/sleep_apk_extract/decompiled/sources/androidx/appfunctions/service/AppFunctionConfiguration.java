package androidx.appfunctions.service;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\n\u000bB'\b\u0000\u0012\u001c\u0010\u0002\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007R'\u0010\u0002\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/appfunctions/service/AppFunctionConfiguration;", "", "enclosingClassFactories", "", "Ljava/lang/Class;", "Lkotlin/Function0;", "<init>", "(Ljava/util/Map;)V", "getEnclosingClassFactories", "()Ljava/util/Map;", "Provider", "Builder", "appfunctions-service"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionConfiguration {
    private final Map<Class<?>, Function0<Object>> enclosingClassFactories;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\b\u001a\u00020\u0000\"\b\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0007J\u0006\u0010\f\u001a\u00020\rR$\u0010\u0004\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/appfunctions/service/AppFunctionConfiguration$Builder;", "", "<init>", "()V", "enclosingClassFactories", "", "Ljava/lang/Class;", "Lkotlin/Function0;", "addEnclosingClassFactory", "T", "enclosingClass", "factory", InAppPurchaseConstants.METHOD_BUILD, "Landroidx/appfunctions/service/AppFunctionConfiguration;", "appfunctions-service"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private final Map<Class<?>, Function0<Object>> enclosingClassFactories = new LinkedHashMap();

        public final <T> Builder addEnclosingClassFactory(Class<T> enclosingClass, Function0<? extends T> factory) {
            enclosingClass.getClass();
            factory.getClass();
            this.enclosingClassFactories.put(enclosingClass, (Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(factory, 0));
            return this;
        }

        public final AppFunctionConfiguration build() {
            return new AppFunctionConfiguration(MapsKt.toMap(this.enclosingClassFactories));
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/appfunctions/service/AppFunctionConfiguration$Provider;", "", "appFunctionConfiguration", "Landroidx/appfunctions/service/AppFunctionConfiguration;", "getAppFunctionConfiguration", "()Landroidx/appfunctions/service/AppFunctionConfiguration;", "appfunctions-service"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Provider {
        AppFunctionConfiguration getAppFunctionConfiguration();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionConfiguration(Map<Class<?>, ? extends Function0<? extends Object>> map) {
        map.getClass();
        this.enclosingClassFactories = map;
    }

    public final Map<Class<?>, Function0<Object>> getEnclosingClassFactories() {
        return this.enclosingClassFactories;
    }
}
