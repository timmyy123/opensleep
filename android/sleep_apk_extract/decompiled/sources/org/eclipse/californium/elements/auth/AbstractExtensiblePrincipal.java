package org.eclipse.californium.elements.auth;

import java.security.Principal;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractExtensiblePrincipal<T extends Principal> implements ExtensiblePrincipal<T> {
    private final AdditionalInfo additionalInfo;

    public AbstractExtensiblePrincipal(AdditionalInfo additionalInfo) {
        if (additionalInfo == null) {
            this.additionalInfo = AdditionalInfo.empty();
        } else {
            this.additionalInfo = additionalInfo;
        }
    }
}
