package org.eclipse.californium.core.network;

import org.eclipse.californium.core.coap.Token;

/* JADX INFO: loaded from: classes5.dex */
public interface TokenGenerator {

    public enum Scope {
        LONG_TERM,
        SHORT_TERM,
        SHORT_TERM_CLIENT_LOCAL
    }

    Token createToken(Scope scope);

    KeyToken getKeyToken(Token token, Object obj);
}
