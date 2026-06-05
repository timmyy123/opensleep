package com.urbandroid.util;

import com.urbandroid.common.logging.Logger;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/util/RadioUrlParser;", "", "<init>", "()V", "parse", "", "url", "Type", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RadioUrlParser {
    public static final RadioUrlParser INSTANCE = new RadioUrlParser();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000ej\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/util/RadioUrlParser$Type;", "", "<init>", "(Ljava/lang/String;I)V", "M3U", "PLS", "isApplicable", "", "url", "", "resolveUrl", "line", "parse", "stream", "Ljava/io/InputStream;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final Type M3U = new M3U("M3U", 0);
        public static final Type PLS = new PLS("PLS", 1);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/util/RadioUrlParser$Type$Companion;", "", "<init>", "()V", "findOrNull", "Lcom/urbandroid/util/RadioUrlParser$Type;", "url", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Type findOrNull(String url) {
                url.getClass();
                for (Type type : Type.values()) {
                    if (type.isApplicable(url)) {
                        return type;
                    }
                }
                return null;
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/urbandroid/util/RadioUrlParser.Type.M3U", "Lcom/urbandroid/util/RadioUrlParser$Type;", "resolveUrl", "", "line", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class M3U extends Type {
            public M3U(String str, int i) {
                super(str, i, null);
            }

            @Override // com.urbandroid.util.RadioUrlParser.Type
            public String resolveUrl(String line) {
                line.getClass();
                if (StringsKt.contains$default(line, "http")) {
                    return line;
                }
                return null;
            }
        }

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/urbandroid/util/RadioUrlParser.Type.PLS", "Lcom/urbandroid/util/RadioUrlParser$Type;", "resolveUrl", "", "line", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class PLS extends Type {
            public PLS(String str, int i) {
                super(str, i, null);
            }

            @Override // com.urbandroid.util.RadioUrlParser.Type
            public String resolveUrl(String line) {
                line.getClass();
                if (StringsKt.startsWith$default(line, "File1=")) {
                    return line.substring(6);
                }
                return null;
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{M3U, PLS};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
            INSTANCE = new Companion(null);
        }

        public /* synthetic */ Type(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String parse$lambda$0$0(Type type, String str) {
            str.getClass();
            return type.resolveUrl(str);
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final boolean isApplicable(String url) {
            url.getClass();
            return StringsKt__StringsJVMKt.endsWith(url, "." + name(), true);
        }

        public final String parse(InputStream stream) {
            stream.getClass();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
            try {
                String str = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(TextStreamsKt.lineSequence(bufferedReader), new CodecsKt$$ExternalSyntheticLambda2(this, 18)));
                CloseableKt.closeFinally(bufferedReader, null);
                return str;
            } finally {
            }
        }

        public abstract String resolveUrl(String line);

        private Type(String str, int i) {
        }
    }

    private RadioUrlParser() {
    }

    public static final String parse(String url) {
        url.getClass();
        Logger.logInfo("RadioUrlParser: parsing " + url);
        Type typeFindOrNull = Type.INSTANCE.findOrNull(url);
        if (typeFindOrNull == null) {
            return url;
        }
        Logger.logInfo("RadioUrlParser: type " + typeFindOrNull + " found for " + url);
        try {
            URLConnection uRLConnectionOpenConnection = new URL(url).openConnection();
            uRLConnectionOpenConnection.getClass();
            InputStream inputStream = ((HttpURLConnection) uRLConnectionOpenConnection).getInputStream();
            inputStream.getClass();
            String str = typeFindOrNull.parse(inputStream);
            if (str == null) {
                Logger.logInfo("RadioUrlParser: nothing found in " + url);
                return url;
            }
            Logger.logInfo("RadioUrlParser: found " + str + " in " + typeFindOrNull + " playlist " + url);
            return str;
        } catch (Exception e) {
            Logger.logSevere("RadioUrlParser: parsing failure", e);
            return url;
        }
    }
}
