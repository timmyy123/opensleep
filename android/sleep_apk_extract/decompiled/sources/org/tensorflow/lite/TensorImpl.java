package org.tensorflow.lite;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
final class TensorImpl {
    private final DataType dtype;
    private long nativeHandle;
    private final Tensor$QuantizationParams quantizationParamsCopy;
    private int[] shapeCopy;
    private final int[] shapeSignatureCopy;

    /* JADX WARN: Type inference failed for: r0v4, types: [org.tensorflow.lite.Tensor$QuantizationParams] */
    private TensorImpl(long j) {
        this.nativeHandle = j;
        this.dtype = DataTypeUtils.fromC(dtype(j));
        this.shapeCopy = shape(j);
        this.shapeSignatureCopy = shapeSignature(j);
        final float fQuantizationScale = quantizationScale(j);
        final int iQuantizationZeroPoint = quantizationZeroPoint(j);
        this.quantizationParamsCopy = new Object(fQuantizationScale, iQuantizationZeroPoint) { // from class: org.tensorflow.lite.Tensor$QuantizationParams
            private final float scale;
            private final int zeroPoint;

            {
                this.scale = fQuantizationScale;
                this.zeroPoint = iQuantizationZeroPoint;
            }
        };
    }

    private ByteBuffer buffer() {
        return buffer(this.nativeHandle).order(ByteOrder.nativeOrder());
    }

    private static native ByteBuffer buffer(long j);

    public static int computeNumDimensions(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            if (Array.getLength(obj) != 0) {
                return computeNumDimensions(Array.get(obj, 0)) + 1;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Array lengths cannot be 0.");
        }
        return 0;
    }

    private int[] computeShapeOf(Object obj) {
        int iComputeNumDimensions = computeNumDimensions(obj);
        if (this.dtype == DataType.STRING) {
            Class<?> componentType = obj.getClass();
            if (componentType.isArray()) {
                while (componentType.isArray()) {
                    componentType = componentType.getComponentType();
                }
                if (Byte.TYPE.equals(componentType)) {
                    iComputeNumDimensions--;
                }
            }
        }
        int[] iArr = new int[iComputeNumDimensions];
        fillShape(obj, 0, iArr);
        return iArr;
    }

    private void copyTo(Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            ((ByteBuffer) buffer).put(buffer());
            return;
        }
        if (buffer instanceof FloatBuffer) {
            ((FloatBuffer) buffer).put(buffer().asFloatBuffer());
            return;
        }
        if (buffer instanceof LongBuffer) {
            ((LongBuffer) buffer).put(buffer().asLongBuffer());
            return;
        }
        if (buffer instanceof IntBuffer) {
            ((IntBuffer) buffer).put(buffer().asIntBuffer());
        } else if (buffer instanceof ShortBuffer) {
            ((ShortBuffer) buffer).put(buffer().asShortBuffer());
        } else {
            Gson$$ExternalSyntheticBUOutline0.m("Unexpected output buffer type: ", buffer);
        }
    }

    private static native long create(long j, int i, int i2);

    private static native void delete(long j);

    private static native int dtype(long j);

    public static void fillShape(Object obj, int i, int[] iArr) {
        if (iArr == null || i == iArr.length) {
            return;
        }
        int length = Array.getLength(obj);
        int i2 = iArr[i];
        if (i2 == 0) {
            iArr[i] = length;
        } else if (i2 != length) {
            Home$$ExternalSyntheticBUOutline0.m("Mismatched lengths (%d and %d) in dimension %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(length), Integer.valueOf(i)});
            return;
        }
        int i3 = i + 1;
        if (i3 == iArr.length) {
            return;
        }
        for (int i4 = 0; i4 < length; i4++) {
            fillShape(Array.get(obj, i4), i3, iArr);
        }
    }

    public static TensorImpl fromIndex(long j, int i) {
        return new TensorImpl(create(j, i, 0));
    }

    private static native boolean hasDelegateBufferHandle(long j);

    private static boolean isBuffer(Object obj) {
        return obj instanceof Buffer;
    }

    private static boolean isByteBuffer(Object obj) {
        return obj instanceof ByteBuffer;
    }

    private static native String name(long j);

    private static native int numBytes(long j);

    private static native float quantizationScale(long j);

    private static native int quantizationZeroPoint(long j);

    private static native void readMultiDimensionalArray(long j, Object obj);

    private void setTo(Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) buffer;
            if (byteBuffer.isDirect() && byteBuffer.order() == ByteOrder.nativeOrder()) {
                writeDirectBuffer(this.nativeHandle, buffer);
                return;
            } else {
                buffer().put(byteBuffer);
                return;
            }
        }
        if (buffer instanceof LongBuffer) {
            LongBuffer longBuffer = (LongBuffer) buffer;
            if (longBuffer.isDirect() && longBuffer.order() == ByteOrder.nativeOrder()) {
                writeDirectBuffer(this.nativeHandle, buffer);
                return;
            } else {
                buffer().asLongBuffer().put(longBuffer);
                return;
            }
        }
        if (buffer instanceof FloatBuffer) {
            FloatBuffer floatBuffer = (FloatBuffer) buffer;
            if (floatBuffer.isDirect() && floatBuffer.order() == ByteOrder.nativeOrder()) {
                writeDirectBuffer(this.nativeHandle, buffer);
                return;
            } else {
                buffer().asFloatBuffer().put(floatBuffer);
                return;
            }
        }
        if (buffer instanceof IntBuffer) {
            IntBuffer intBuffer = (IntBuffer) buffer;
            if (intBuffer.isDirect() && intBuffer.order() == ByteOrder.nativeOrder()) {
                writeDirectBuffer(this.nativeHandle, buffer);
                return;
            } else {
                buffer().asIntBuffer().put(intBuffer);
                return;
            }
        }
        if (!(buffer instanceof ShortBuffer)) {
            Gson$$ExternalSyntheticBUOutline0.m("Unexpected input buffer type: ", buffer);
            return;
        }
        ShortBuffer shortBuffer = (ShortBuffer) buffer;
        if (shortBuffer.isDirect() && shortBuffer.order() == ByteOrder.nativeOrder()) {
            writeDirectBuffer(this.nativeHandle, buffer);
        } else {
            buffer().asShortBuffer().put(shortBuffer);
        }
    }

    private static native int[] shape(long j);

    private static native int[] shapeSignature(long j);

    private void throwIfDstShapeIsIncompatible(Object obj) {
        if (isBuffer(obj)) {
            Buffer buffer = (Buffer) obj;
            int iNumBytes = numBytes();
            int iCapacity = isByteBuffer(obj) ? buffer.capacity() : buffer.capacity() * this.dtype.byteSize();
            if (iNumBytes <= iCapacity) {
                return;
            }
            Home$$ExternalSyntheticBUOutline0.m("Cannot copy from a TensorFlowLite tensor (%s) with %d bytes to a Java Buffer with %d bytes.", new Object[]{name(), Integer.valueOf(iNumBytes), Integer.valueOf(iCapacity)});
            return;
        }
        int[] iArrComputeShapeOf = computeShapeOf(obj);
        if (Arrays.equals(iArrComputeShapeOf, this.shapeCopy)) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m6m("Cannot copy from a TensorFlowLite tensor (", name(), ") with shape ", Arrays.toString(this.shapeCopy), " to a Java object with shape "), Arrays.toString(iArrComputeShapeOf), "."));
    }

    private void throwIfSrcShapeIsIncompatible(Object obj) {
        if (isBuffer(obj)) {
            Buffer buffer = (Buffer) obj;
            int iNumBytes = numBytes();
            int iCapacity = isByteBuffer(obj) ? buffer.capacity() : buffer.capacity() * this.dtype.byteSize();
            if (iNumBytes == iCapacity) {
                return;
            }
            Home$$ExternalSyntheticBUOutline0.m("Cannot copy to a TensorFlowLite tensor (%s) with %d bytes from a Java Buffer with %d bytes.", new Object[]{name(), Integer.valueOf(iNumBytes), Integer.valueOf(iCapacity)});
            return;
        }
        int[] iArrComputeShapeOf = computeShapeOf(obj);
        if (Arrays.equals(iArrComputeShapeOf, this.shapeCopy)) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m6m("Cannot copy to a TensorFlowLite tensor (", name(), ") with shape ", Arrays.toString(this.shapeCopy), " from a Java object with shape "), Arrays.toString(iArrComputeShapeOf), "."));
    }

    private void throwIfTypeIsIncompatible(Object obj) {
        DataType dataTypeDataTypeOf;
        if (isByteBuffer(obj) || (dataTypeDataTypeOf = dataTypeOf(obj)) == this.dtype || DataTypeUtils.toStringName(dataTypeDataTypeOf).equals(DataTypeUtils.toStringName(this.dtype))) {
            return;
        }
        throw new IllegalArgumentException("Cannot convert between a TensorFlowLite tensor with type " + this.dtype + " and a Java object of type " + obj.getClass().getName() + " (which is compatible with the TensorFlowLite type " + dataTypeDataTypeOf + ").");
    }

    private static native void writeDirectBuffer(long j, Buffer buffer);

    private static native void writeMultiDimensionalArray(long j, Object obj);

    private static native void writeScalar(long j, Object obj);

    public void close() {
        delete(this.nativeHandle);
        this.nativeHandle = 0L;
    }

    public DataType dataTypeOf(Object obj) {
        Class<?> componentType = obj.getClass();
        if (componentType.isArray()) {
            while (componentType.isArray()) {
                componentType = componentType.getComponentType();
            }
            if (Float.TYPE.equals(componentType)) {
                return DataType.FLOAT32;
            }
            if (Integer.TYPE.equals(componentType)) {
                return DataType.INT32;
            }
            if (Short.TYPE.equals(componentType)) {
                return DataType.INT16;
            }
            if (Byte.TYPE.equals(componentType)) {
                DataType dataType = this.dtype;
                DataType dataType2 = DataType.STRING;
                return dataType == dataType2 ? dataType2 : DataType.UINT8;
            }
            if (Long.TYPE.equals(componentType)) {
                return DataType.INT64;
            }
            if (Boolean.TYPE.equals(componentType)) {
                return DataType.BOOL;
            }
            if (String.class.equals(componentType)) {
                return DataType.STRING;
            }
        } else {
            if (Float.class.equals(componentType) || (obj instanceof FloatBuffer)) {
                return DataType.FLOAT32;
            }
            if (Integer.class.equals(componentType) || (obj instanceof IntBuffer)) {
                return DataType.INT32;
            }
            if (Short.class.equals(componentType) || (obj instanceof ShortBuffer)) {
                return DataType.INT16;
            }
            if (Byte.class.equals(componentType)) {
                return DataType.UINT8;
            }
            if (Long.class.equals(componentType) || (obj instanceof LongBuffer)) {
                return DataType.INT64;
            }
            if (Boolean.class.equals(componentType)) {
                return DataType.BOOL;
            }
            if (String.class.equals(componentType)) {
                return DataType.STRING;
            }
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("DataType error: cannot resolve DataType of ".concat(obj.getClass().getName()));
        return null;
    }

    public int[] getInputShapeIfDifferent(Object obj) {
        if (obj == null || isBuffer(obj)) {
            return null;
        }
        throwIfTypeIsIncompatible(obj);
        int[] iArrComputeShapeOf = computeShapeOf(obj);
        if (Arrays.equals(this.shapeCopy, iArrComputeShapeOf)) {
            return null;
        }
        return iArrComputeShapeOf;
    }

    public String name() {
        return name(this.nativeHandle);
    }

    public int numBytes() {
        return numBytes(this.nativeHandle);
    }

    public void refreshShape() {
        this.shapeCopy = shape(this.nativeHandle);
    }

    public void copyTo(Object obj) {
        if (obj == null) {
            if (hasDelegateBufferHandle(this.nativeHandle)) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Null outputs are allowed only if the Tensor is bound to a buffer handle.");
        } else {
            throwIfTypeIsIncompatible(obj);
            throwIfDstShapeIsIncompatible(obj);
            if (isBuffer(obj)) {
                copyTo((Buffer) obj);
            } else {
                readMultiDimensionalArray(this.nativeHandle, obj);
            }
        }
    }

    public void setTo(Object obj) {
        if (obj == null) {
            if (hasDelegateBufferHandle(this.nativeHandle)) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Null inputs are allowed only if the Tensor is bound to a buffer handle.");
            return;
        }
        throwIfTypeIsIncompatible(obj);
        throwIfSrcShapeIsIncompatible(obj);
        if (isBuffer(obj)) {
            setTo((Buffer) obj);
            return;
        }
        if (this.dtype == DataType.STRING && this.shapeCopy.length == 0) {
            writeScalar(this.nativeHandle, obj);
            return;
        }
        boolean zIsArray = obj.getClass().isArray();
        long j = this.nativeHandle;
        if (zIsArray) {
            writeMultiDimensionalArray(j, obj);
        } else {
            writeScalar(j, obj);
        }
    }
}
