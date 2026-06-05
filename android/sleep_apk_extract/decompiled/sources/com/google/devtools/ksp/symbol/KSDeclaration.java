package com.google.devtools.ksp.symbol;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003R\u0014\u0010\u0007\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lcom/google/devtools/ksp/symbol/KSDeclaration;", "Lcom/google/devtools/ksp/symbol/KSModifierListOwner;", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "", "Lcom/google/devtools/ksp/symbol/KSName;", "getSimpleName", "()Lcom/google/devtools/ksp/symbol/KSName;", "simpleName", "getQualifiedName", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "", "Lcom/google/devtools/ksp/symbol/KSTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "typeParameters", "getPackageName", "packageName", "getParentDeclaration", "()Lcom/google/devtools/ksp/symbol/KSDeclaration;", "parentDeclaration", "Lcom/google/devtools/ksp/symbol/KSFile;", "getContainingFile", "()Lcom/google/devtools/ksp/symbol/KSFile;", "containingFile", "", "getDocString", "()Ljava/lang/String;", "docString", "api"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface KSDeclaration extends KSModifierListOwner, KSAnnotated {
    KSFile getContainingFile();

    String getDocString();

    KSName getPackageName();

    KSDeclaration getParentDeclaration();

    KSName getQualifiedName();

    KSName getSimpleName();

    List<KSTypeParameter> getTypeParameters();
}
