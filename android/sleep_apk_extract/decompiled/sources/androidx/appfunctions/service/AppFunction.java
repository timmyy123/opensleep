package androidx.appfunctions.service;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005R\u000f\u0010\u0004\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/appfunctions/service/AppFunction;", "", IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "", "isDescribedByKDoc", "()Z", "appfunctions-service"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface AppFunction {
    boolean isDescribedByKDoc() default false;

    boolean isEnabled() default true;
}
