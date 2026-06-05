package com.getpebble.android.kit.util;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes3.dex */
public class PebbleTuple {
    static final Map<Integer, Width> WIDTH_MAP;
    public final int key;
    public final int length;
    public final TupleType type;
    public final Object value;
    public final Width width;
    private static final Charset UTF8 = Charset.forName(OAuth.ENCODING);
    static final Map<String, TupleType> TYPE_NAMES = new HashMap();

    public enum TupleType {
        BYTES(0),
        STRING(1),
        UINT(2),
        INT(3);

        public final byte ord;

        TupleType(int i) {
            this.ord = (byte) i;
        }

        public String getName() {
            return name().toLowerCase(Locale.US);
        }
    }

    public static class ValueOverflowException extends RuntimeException {
        public ValueOverflowException() {
            super("Value exceeds tuple capacity");
        }
    }

    public enum Width {
        NONE(0),
        BYTE(1),
        SHORT(2),
        WORD(4);

        public final int value;

        Width(int i) {
            this.value = i;
        }
    }

    static {
        for (TupleType tupleType : TupleType.values()) {
            TYPE_NAMES.put(tupleType.getName(), tupleType);
        }
        WIDTH_MAP = new HashMap();
        for (Width width : Width.values()) {
            WIDTH_MAP.put(Integer.valueOf(width.value), width);
        }
    }

    private PebbleTuple(int i, TupleType tupleType, Width width, int i2, Object obj) {
        this.key = i;
        this.type = tupleType;
        this.width = width;
        this.length = i2;
        this.value = obj;
    }

    public static PebbleTuple create(int i, TupleType tupleType, Width width, Object obj) {
        int length = width != Width.NONE ? width.value : tupleType == TupleType.BYTES ? ((byte[]) obj).length : tupleType == TupleType.STRING ? ((String) obj).getBytes(UTF8).length : Integer.MAX_VALUE;
        if (length <= 65535) {
            return new PebbleTuple(i, tupleType, width, length, obj);
        }
        throw new ValueOverflowException();
    }

    public static PebbleTuple create(int i, TupleType tupleType, Width width, int i2) {
        return new PebbleTuple(i, tupleType, width, width.value, Long.valueOf(i2));
    }
}
