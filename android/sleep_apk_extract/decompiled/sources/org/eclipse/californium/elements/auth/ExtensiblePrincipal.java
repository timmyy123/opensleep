package org.eclipse.californium.elements.auth;

import java.security.Principal;

/* JADX INFO: loaded from: classes5.dex */
public interface ExtensiblePrincipal<T extends Principal> extends Principal {
    T amend(AdditionalInfo additionalInfo);
}
