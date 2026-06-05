package com.google.devtools.ksp.symbol;

import kotlin.Metadata;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H&¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0014\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "Lcom/google/devtools/ksp/symbol/KSDeclaration;", "Lcom/google/devtools/ksp/symbol/KSDeclarationContainer;", "Lkotlin/sequences/Sequence;", "getSealedSubclasses", "()Lkotlin/sequences/Sequence;", "Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;", "getAllFunctions", "Lcom/google/devtools/ksp/symbol/KSPropertyDeclaration;", "getAllProperties", "Lcom/google/devtools/ksp/symbol/KSType;", "asStarProjectedType", "()Lcom/google/devtools/ksp/symbol/KSType;", "getPrimaryConstructor", "()Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;", "primaryConstructor", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "getSuperTypes", "superTypes", "", "isCompanionObject", "()Z", "api"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface KSClassDeclaration extends KSDeclaration, KSDeclarationContainer {
    KSType asStarProjectedType();

    Sequence<KSFunctionDeclaration> getAllFunctions();

    Sequence<KSPropertyDeclaration> getAllProperties();

    KSFunctionDeclaration getPrimaryConstructor();

    Sequence<KSClassDeclaration> getSealedSubclasses();

    Sequence<KSTypeReference> getSuperTypes();

    boolean isCompanionObject();
}
