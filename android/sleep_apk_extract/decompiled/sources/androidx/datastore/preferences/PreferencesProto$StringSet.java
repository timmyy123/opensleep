package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MessageLiteOrBuilder;
import androidx.datastore.preferences.protobuf.Parser;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PreferencesProto$StringSet extends GeneratedMessageLite<PreferencesProto$StringSet, Builder> implements MessageLiteOrBuilder {
    private static final PreferencesProto$StringSet DEFAULT_INSTANCE;
    private static volatile Parser<PreferencesProto$StringSet> PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<String> strings_ = GeneratedMessageLite.emptyProtobufList();

    static {
        PreferencesProto$StringSet preferencesProto$StringSet = new PreferencesProto$StringSet();
        DEFAULT_INSTANCE = preferencesProto$StringSet;
        GeneratedMessageLite.registerDefaultInstance(PreferencesProto$StringSet.class, preferencesProto$StringSet);
    }

    private PreferencesProto$StringSet() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllStrings(Iterable<String> iterable) {
        ensureStringsIsMutable();
        AbstractMessageLite.addAll(iterable, this.strings_);
    }

    private void ensureStringsIsMutable() {
        Internal.ProtobufList<String> protobufList = this.strings_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.strings_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static PreferencesProto$StringSet getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i = PreferencesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        PreferencesProto$1 preferencesProto$1 = null;
        switch (i) {
            case 1:
                return new PreferencesProto$StringSet();
            case 2:
                return new Builder(preferencesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PreferencesProto$StringSet> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PreferencesProto$StringSet.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            default:
                Home$$ExternalSyntheticBUOutline0.m$1();
            case 7:
                return null;
        }
    }

    public List<String> getStringsList() {
        return this.strings_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PreferencesProto$StringSet, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PreferencesProto$StringSet.DEFAULT_INSTANCE);
        }

        public Builder addAllStrings(Iterable<String> iterable) {
            copyOnWrite();
            ((PreferencesProto$StringSet) this.instance).addAllStrings(iterable);
            return this;
        }

        public /* synthetic */ Builder(PreferencesProto$1 preferencesProto$1) {
            this();
        }
    }
}
