package org.eclipse.californium.core.network;

import java.security.SecureRandom;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.coap.Token;
import org.eclipse.californium.core.network.TokenGenerator;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class RandomTokenGenerator implements TokenGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) RandomTokenGenerator.class);
    private final SecureRandom rng;
    private final int tokenSize;

    /* JADX INFO: renamed from: org.eclipse.californium.core.network.RandomTokenGenerator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$core$network$TokenGenerator$Scope;

        static {
            int[] iArr = new int[TokenGenerator.Scope.values().length];
            $SwitchMap$org$eclipse$californium$core$network$TokenGenerator$Scope = iArr;
            try {
                iArr[TokenGenerator.Scope.LONG_TERM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$core$network$TokenGenerator$Scope[TokenGenerator.Scope.SHORT_TERM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$eclipse$californium$core$network$TokenGenerator$Scope[TokenGenerator.Scope.SHORT_TERM_CLIENT_LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public RandomTokenGenerator(NetworkConfig networkConfig) {
        if (networkConfig == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("NetworkConfig must not be null");
            throw null;
        }
        SecureRandom secureRandom = new SecureRandom();
        this.rng = secureRandom;
        secureRandom.nextInt(10);
        int i = networkConfig.getInt("TOKEN_SIZE_LIMIT", 8);
        this.tokenSize = i;
        LOGGER.info("using tokens of {} bytes in length", Integer.valueOf(i));
    }

    @Override // org.eclipse.californium.core.network.TokenGenerator
    public Token createToken(TokenGenerator.Scope scope) {
        byte[] bArr = new byte[this.tokenSize];
        this.rng.nextBytes(bArr);
        int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$core$network$TokenGenerator$Scope[scope.ordinal()];
        if (i == 1) {
            bArr[0] = (byte) (bArr[0] | 1);
        } else if (i == 2) {
            byte b = (byte) (bArr[0] & 252);
            bArr[0] = b;
            bArr[0] = (byte) (b | 2);
        } else if (i == 3) {
            bArr[0] = (byte) (bArr[0] & 252);
        }
        return Token.fromProvider(bArr);
    }

    @Override // org.eclipse.californium.core.network.TokenGenerator
    public KeyToken getKeyToken(Token token, Object obj) {
        if (getScope(token) != TokenGenerator.Scope.SHORT_TERM_CLIENT_LOCAL) {
            return new KeyToken(token, null);
        }
        if (obj != null) {
            return new KeyToken(token, obj);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("client-local token requires peer!");
        return null;
    }

    public TokenGenerator.Scope getScope(Token token) {
        if (token.length() != this.tokenSize) {
            return TokenGenerator.Scope.SHORT_TERM_CLIENT_LOCAL;
        }
        int i = token.getBytes()[0] & 3;
        return i != 0 ? i != 2 ? TokenGenerator.Scope.LONG_TERM : TokenGenerator.Scope.SHORT_TERM : TokenGenerator.Scope.SHORT_TERM_CLIENT_LOCAL;
    }
}
