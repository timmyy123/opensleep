package com.urbandroid.common.util;

import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DbEncodingUtils {
    public static float[] decodeFloatArrayFromByteArray(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        float[] fArr = new float[bArr.length / 4];
        ByteBuffer.wrap(bArr).asFloatBuffer().get(fArr);
        return fArr;
    }

    public static Serializable decodeSerializableIntoByteArray(byte[] bArr, final Map<String, Class> map) {
        if (bArr == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(bArr)) { // from class: com.urbandroid.common.util.DbEncodingUtils.1
                @Override // java.io.ObjectInputStream
                public ObjectStreamClass readClassDescriptor() throws ClassNotFoundException, IOException {
                    ObjectStreamClass classDescriptor = super.readClassDescriptor();
                    Class cls = (Class) map.get(classDescriptor.getName());
                    return cls != null ? ObjectStreamClass.lookup(cls) : classDescriptor;
                }
            }.readObject();
        } catch (Exception e) {
            Logger.logWarning("Failed to deserialize object.", e);
            ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "Failed to deserialize object.");
            return null;
        }
    }

    public static byte[] encodeFloatArrayIntoByteArray(float[] fArr) {
        byte[] bArr = new byte[fArr.length * 4];
        ByteBuffer.wrap(bArr).asFloatBuffer().put(fArr);
        return bArr;
    }

    public static byte[] encodeSerializableIntoByteArray(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception unused) {
            ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "Failed to serialize object.");
            return new byte[0];
        }
    }

    public static Serializable decodeSerializableIntoByteArray(byte[] bArr) {
        return decodeSerializableIntoByteArray(bArr, new HashMap());
    }
}
