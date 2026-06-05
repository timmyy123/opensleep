package androidx.appfunctions.service.internal;

import android.content.Context;
import android.util.Log;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.internal.Constants;
import androidx.appfunctions.service.AppFunctionConfiguration;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u000eB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0002\u0010\fJ\u001b\u0010\r\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/appfunctions/service/internal/ConfigurableAppFunctionFactory;", "T", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "defaultFactory", "Lkotlin/Function0;", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", IntrospectionHelper.ConfigurableAppFunctionFactoryClass.CreateEnclosingClassMethod.METHOD_NAME, "enclosingClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "createFromDefault", "AppFunctionInstantiationException", "appfunctions-service"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfigurableAppFunctionFactory<T> {
    private final Context context;
    private final Function0<T> defaultFactory;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/appfunctions/service/internal/ConfigurableAppFunctionFactory$AppFunctionInstantiationException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errorMessage", "", "<init>", "(Ljava/lang/String;)V", "appfunctions-service"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppFunctionInstantiationException extends RuntimeException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppFunctionInstantiationException(String str) {
            super(str);
            str.getClass();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConfigurableAppFunctionFactory(Context context, Function0<? extends T> function0) {
        context.getClass();
        this.context = context;
        this.defaultFactory = function0;
    }

    private final T createFromDefault(Class<T> enclosingClass) {
        Function0<T> function0 = this.defaultFactory;
        if (function0 != null) {
            return function0.invoke();
        }
        throw new AppFunctionInstantiationException("Unable to instantiate " + enclosingClass + ". Either setup a custom factory with AppFunctionConfiguration or provide a public no-arg constructor.");
    }

    public final T createEnclosingClass(Class<T> enclosingClass) {
        AppFunctionConfiguration appFunctionConfiguration;
        Map<Class<?>, Function0<Object>> enclosingClassFactories;
        enclosingClass.getClass();
        Object applicationContext = this.context.getApplicationContext();
        Function0<Object> function0 = null;
        AppFunctionConfiguration.Provider provider = applicationContext instanceof AppFunctionConfiguration.Provider ? (AppFunctionConfiguration.Provider) applicationContext : null;
        if (provider != null && (appFunctionConfiguration = provider.getAppFunctionConfiguration()) != null && (enclosingClassFactories = appFunctionConfiguration.getEnclosingClassFactories()) != null) {
            function0 = enclosingClassFactories.get(enclosingClass);
        }
        if (function0 != null) {
            T t = (T) function0.invoke();
            t.getClass();
            return t;
        }
        Log.d(Constants.APP_FUNCTIONS_TAG, "Unable to find custom factory for [" + enclosingClass + ']');
        return createFromDefault(enclosingClass);
    }

    public /* synthetic */ ConfigurableAppFunctionFactory(Context context, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function0);
    }
}
