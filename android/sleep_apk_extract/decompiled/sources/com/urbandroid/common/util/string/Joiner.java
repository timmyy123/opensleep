package com.urbandroid.common.util.string;

import java.io.IOException;
import java.util.Iterator;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class Joiner {
    public static final ItemMapper PREPEND_SIZE_ITEM_MAPPER = new ItemMapper<Object>() { // from class: com.urbandroid.common.util.string.Joiner.5
        @Override // com.urbandroid.common.util.string.Joiner.ItemMapper
        public CharSequence map(Object obj) {
            CharSequence string = obj == null ? "" : obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
            return String.format("%04X", Integer.valueOf(string.length())) + ((Object) string);
        }
    };
    private ItemMapper itemMapper = new ItemMapper<Object>() { // from class: com.urbandroid.common.util.string.Joiner.4
        @Override // com.urbandroid.common.util.string.Joiner.ItemMapper
        public CharSequence map(Object obj) {
            if (obj == null) {
                return null;
            }
            return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
        }
    };
    private final String separator;

    public interface ItemMapper<T> {
        CharSequence map(T t);
    }

    private Joiner(String str) {
        this.separator = str;
    }

    public static Joiner on(String str) {
        return new Joiner(str);
    }

    public <A extends Appendable> A appendTo(A a, Iterator<?> it) throws IOException {
        if (it.hasNext()) {
            a.append(toString(it.next()));
            while (it.hasNext()) {
                a.append(this.separator);
                a.append(toString(it.next()));
            }
        }
        return a;
    }

    public final String join(Iterator<?> it) {
        return appendTo(new StringBuilder(), it).toString();
    }

    public Joiner map(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
        return this;
    }

    public CharSequence toString(Object obj) {
        return this.itemMapper.map(obj);
    }

    public final String join(Iterable<?> iterable) {
        return join(iterable.iterator());
    }

    public final StringBuilder appendTo(StringBuilder sb, Iterator<?> it) {
        try {
            appendTo(sb, it);
            return sb;
        } catch (IOException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e);
            return null;
        }
    }
}
