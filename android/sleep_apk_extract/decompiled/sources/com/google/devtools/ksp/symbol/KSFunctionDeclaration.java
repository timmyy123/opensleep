package com.google.devtools.ksp.symbol;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;", "Lcom/google/devtools/ksp/symbol/KSDeclaration;", "Lcom/google/devtools/ksp/symbol/KSDeclarationContainer;", "findOverridee", "()Lcom/google/devtools/ksp/symbol/KSDeclaration;", "", "Lcom/google/devtools/ksp/symbol/KSValueParameter;", "getParameters", "()Ljava/util/List;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "api"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface KSFunctionDeclaration extends KSDeclaration, KSDeclarationContainer {
    KSDeclaration findOverridee();

    List<KSValueParameter> getParameters();
}
