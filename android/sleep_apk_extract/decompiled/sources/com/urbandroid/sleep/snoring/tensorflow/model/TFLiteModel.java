package com.urbandroid.sleep.snoring.tensorflow.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.logging.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import org.tensorflow.lite.Interpreter;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/urbandroid/sleep/snoring/tensorflow/model/TFLiteModel;", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/snoring/tensorflow/model/ModelMetadata;", "metadata", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/snoring/tensorflow/model/ModelMetadata;)V", "Ljava/nio/MappedByteBuffer;", "loadModelFile", "()Ljava/nio/MappedByteBuffer;", "", "inp", "process", "([F)[F", "", "close", "()V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/urbandroid/sleep/snoring/tensorflow/model/ModelMetadata;", "getMetadata", "()Lcom/urbandroid/sleep/snoring/tensorflow/model/ModelMetadata;", "Lorg/tensorflow/lite/Interpreter;", "tflite", "Lorg/tensorflow/lite/Interpreter;", "Ljava/nio/ByteBuffer;", "input", "Ljava/nio/ByteBuffer;", "", "output", "[[F", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TFLiteModel {
    private final Context context;
    private final ByteBuffer input;
    private final ModelMetadata metadata;
    private final float[][] output;
    private final Interpreter tflite;

    public TFLiteModel(Context context, ModelMetadata modelMetadata) {
        context.getClass();
        modelMetadata.getClass();
        this.context = context;
        this.metadata = modelMetadata;
        this.tflite = new Interpreter(loadModelFile());
        Logger.logDebug("TFLiteModel: model loaded.");
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(modelMetadata.getInputDimension().getTotalSize() * 4);
        byteBufferAllocateDirect.getClass();
        this.input = byteBufferAllocateDirect;
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        this.output = new float[][]{new float[modelMetadata.getOutputDimension()]};
        process(new float[modelMetadata.getInputDimension().getTotalSize()]);
        Logger.logInfo("TFLiteModel: seems to work fine.");
    }

    private final MappedByteBuffer loadModelFile() throws IOException {
        AssetFileDescriptor assetFileDescriptorOpenFd = this.context.getAssets().openFd(this.metadata.getModelAsset());
        assetFileDescriptorOpenFd.getClass();
        MappedByteBuffer map = new FileInputStream(assetFileDescriptorOpenFd.getFileDescriptor()).getChannel().map(FileChannel.MapMode.READ_ONLY, assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getDeclaredLength());
        map.getClass();
        return map;
    }

    public final void close() {
        Logger.logDebug("TFLiteModel: close");
        this.tflite.close();
    }

    public final float[] process(float[] inp) {
        inp.getClass();
        this.input.clear();
        for (float f : inp) {
            this.input.putFloat(f);
        }
        this.tflite.run(this.input, this.output);
        return this.output[0];
    }
}
