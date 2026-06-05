package com.getpebble.android.kit.util;

import android.util.Base64;
import com.getpebble.android.kit.util.PebbleTuple;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PebbleDictionary implements Iterable<PebbleTuple> {
    private static final String KEY = "key";
    private static final String LENGTH = "length";
    private static final String TYPE = "type";
    private static final String VALUE = "value";
    protected final Map<Integer, PebbleTuple> tuples = new HashMap();

    /* JADX INFO: renamed from: com.getpebble.android.kit.util.PebbleDictionary$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$getpebble$android$kit$util$PebbleTuple$TupleType;

        static {
            int[] iArr = new int[PebbleTuple.TupleType.values().length];
            $SwitchMap$com$getpebble$android$kit$util$PebbleTuple$TupleType = iArr;
            try {
                iArr[PebbleTuple.TupleType.BYTES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$getpebble$android$kit$util$PebbleTuple$TupleType[PebbleTuple.TupleType.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$getpebble$android$kit$util$PebbleTuple$TupleType[PebbleTuple.TupleType.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$getpebble$android$kit$util$PebbleTuple$TupleType[PebbleTuple.TupleType.UINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class PebbleDictTypeException extends RuntimeException {
        public PebbleDictTypeException(long j, PebbleTuple.TupleType tupleType, PebbleTuple.TupleType tupleType2) {
            super(String.format("Expected type '%s', but got '%s' for key 0x%08x", tupleType.name(), tupleType2.name(), Long.valueOf(j)));
        }
    }

    public static class TupleOverflowException extends RuntimeException {
        public TupleOverflowException() {
            super("Too many tuples in dict");
        }
    }

    public static PebbleDictionary fromJson(String str) throws JSONException {
        PebbleDictionary pebbleDictionary = new PebbleDictionary();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            int i2 = jSONObject.getInt("key");
            PebbleTuple.TupleType tupleType = PebbleTuple.TYPE_NAMES.get(jSONObject.getString("type"));
            PebbleTuple.Width width = PebbleTuple.WIDTH_MAP.get(Integer.valueOf(jSONObject.getInt(LENGTH)));
            int i3 = AnonymousClass1.$SwitchMap$com$getpebble$android$kit$util$PebbleTuple$TupleType[tupleType.ordinal()];
            if (i3 == 1) {
                pebbleDictionary.addBytes(i2, Base64.decode(jSONObject.getString("value"), 2));
            } else if (i3 == 2) {
                pebbleDictionary.addString(i2, jSONObject.getString("value"));
            } else if (i3 != 3) {
                if (i3 == 4) {
                    if (width == PebbleTuple.Width.BYTE) {
                        pebbleDictionary.addUint8(i2, (byte) jSONObject.getInt("value"));
                    } else if (width == PebbleTuple.Width.SHORT) {
                        pebbleDictionary.addUint16(i2, (short) jSONObject.getInt("value"));
                    } else if (width == PebbleTuple.Width.WORD) {
                        pebbleDictionary.addUint32(i2, jSONObject.getInt("value"));
                    }
                }
            } else if (width == PebbleTuple.Width.BYTE) {
                pebbleDictionary.addInt8(i2, (byte) jSONObject.getInt("value"));
            } else if (width == PebbleTuple.Width.SHORT) {
                pebbleDictionary.addInt16(i2, (short) jSONObject.getInt("value"));
            } else if (width == PebbleTuple.Width.WORD) {
                pebbleDictionary.addInt32(i2, jSONObject.getInt("value"));
            }
        }
        return pebbleDictionary;
    }

    private PebbleTuple getTuple(int i, PebbleTuple.TupleType tupleType) {
        if (!this.tuples.containsKey(Integer.valueOf(i)) || this.tuples.get(Integer.valueOf(i)) == null) {
            return null;
        }
        PebbleTuple pebbleTuple = this.tuples.get(Integer.valueOf(i));
        PebbleTuple.TupleType tupleType2 = pebbleTuple.type;
        if (tupleType2 == tupleType) {
            return pebbleTuple;
        }
        throw new PebbleDictTypeException(i, tupleType, tupleType2);
    }

    private static JSONObject serializeTuple(PebbleTuple pebbleTuple) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", pebbleTuple.key);
        jSONObject.put("type", pebbleTuple.type.getName());
        jSONObject.put(LENGTH, pebbleTuple.width.value);
        int i = AnonymousClass1.$SwitchMap$com$getpebble$android$kit$util$PebbleTuple$TupleType[pebbleTuple.type.ordinal()];
        if (i == 1) {
            jSONObject.put("value", Base64.encodeToString((byte[]) pebbleTuple.value, 2));
            return jSONObject;
        }
        if (i != 2 && i != 3 && i != 4) {
            return jSONObject;
        }
        jSONObject.put("value", pebbleTuple.value);
        return jSONObject;
    }

    public void addBytes(int i, byte[] bArr) {
        addTuple(PebbleTuple.create(i, PebbleTuple.TupleType.BYTES, PebbleTuple.Width.NONE, bArr));
    }

    public void addInt16(int i, short s) {
        addTuple(PebbleTuple.create(i, PebbleTuple.TupleType.INT, PebbleTuple.Width.SHORT, s));
    }

    public void addInt32(int i, int i2) {
        addTuple(PebbleTuple.create(i, PebbleTuple.TupleType.INT, PebbleTuple.Width.WORD, i2));
    }

    public void addInt8(int i, byte b) {
        addTuple(PebbleTuple.create(i, PebbleTuple.TupleType.INT, PebbleTuple.Width.BYTE, b));
    }

    public void addString(int i, String str) {
        addTuple(PebbleTuple.create(i, PebbleTuple.TupleType.STRING, PebbleTuple.Width.NONE, str));
    }

    public void addTuple(PebbleTuple pebbleTuple) {
        if (this.tuples.size() > 255) {
            throw new TupleOverflowException();
        }
        this.tuples.put(Integer.valueOf(pebbleTuple.key), pebbleTuple);
    }

    public void addUint16(int i, short s) {
        addTuple(PebbleTuple.create(i, PebbleTuple.TupleType.UINT, PebbleTuple.Width.SHORT, s));
    }

    public void addUint32(int i, int i2) {
        addTuple(PebbleTuple.create(i, PebbleTuple.TupleType.UINT, PebbleTuple.Width.WORD, i2));
    }

    public void addUint8(int i, byte b) {
        addTuple(PebbleTuple.create(i, PebbleTuple.TupleType.UINT, PebbleTuple.Width.BYTE, b));
    }

    public boolean contains(int i) {
        return this.tuples.containsKey(Integer.valueOf(i));
    }

    public byte[] getBytes(int i) {
        PebbleTuple tuple = getTuple(i, PebbleTuple.TupleType.BYTES);
        if (tuple == null) {
            return null;
        }
        return (byte[]) tuple.value;
    }

    public Long getInteger(int i) {
        PebbleTuple tuple = getTuple(i, PebbleTuple.TupleType.INT);
        if (tuple == null) {
            return null;
        }
        return (Long) tuple.value;
    }

    public String getString(int i) {
        PebbleTuple tuple = getTuple(i, PebbleTuple.TupleType.STRING);
        if (tuple == null) {
            return null;
        }
        return (String) tuple.value;
    }

    public Long getUnsignedIntegerAsLong(int i) {
        PebbleTuple tuple = getTuple(i, PebbleTuple.TupleType.UINT);
        if (tuple == null) {
            return null;
        }
        return (Long) tuple.value;
    }

    @Override // java.lang.Iterable
    public Iterator<PebbleTuple> iterator() {
        return this.tuples.values().iterator();
    }

    public void remove(int i) {
        this.tuples.remove(Integer.valueOf(i));
    }

    public int size() {
        return this.tuples.size();
    }

    public String toJsonString() {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<PebbleTuple> it = this.tuples.values().iterator();
            while (it.hasNext()) {
                jSONArray.put(serializeTuple(it.next()));
            }
            return jSONArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
