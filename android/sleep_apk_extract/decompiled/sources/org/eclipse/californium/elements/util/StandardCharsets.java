package org.eclipse.californium.elements.util;

import java.nio.charset.Charset;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes5.dex */
public interface StandardCharsets {
    public static final Charset UTF_8 = Charset.forName(OAuth.ENCODING);
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
}
