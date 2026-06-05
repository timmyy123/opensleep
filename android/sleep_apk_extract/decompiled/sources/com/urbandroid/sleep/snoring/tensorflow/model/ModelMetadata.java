package com.urbandroid.sleep.snoring.tensorflow.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001a\u0010\rR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/sleep/snoring/tensorflow/model/ModelMetadata;", "", "", "modelAsset", "inputNodeName", "Lcom/urbandroid/sleep/snoring/tensorflow/model/TensorShape;", "inputDimension", "outputNodeName", "", "outputDimension", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbandroid/sleep/snoring/tensorflow/model/TensorShape;Ljava/lang/String;I)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getModelAsset", "getInputNodeName", "Lcom/urbandroid/sleep/snoring/tensorflow/model/TensorShape;", "getInputDimension", "()Lcom/urbandroid/sleep/snoring/tensorflow/model/TensorShape;", "getOutputNodeName", "I", "getOutputDimension", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ModelMetadata {
    private final TensorShape inputDimension;
    private final String inputNodeName;
    private final String modelAsset;
    private final int outputDimension;
    private final String outputNodeName;

    public ModelMetadata(String str, String str2, TensorShape tensorShape, String str3, int i) {
        str.getClass();
        str2.getClass();
        tensorShape.getClass();
        str3.getClass();
        this.modelAsset = str;
        this.inputNodeName = str2;
        this.inputDimension = tensorShape;
        this.outputNodeName = str3;
        this.outputDimension = i;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelMetadata)) {
            return false;
        }
        ModelMetadata modelMetadata = (ModelMetadata) other;
        return Intrinsics.areEqual(this.modelAsset, modelMetadata.modelAsset) && Intrinsics.areEqual(this.inputNodeName, modelMetadata.inputNodeName) && Intrinsics.areEqual(this.inputDimension, modelMetadata.inputDimension) && Intrinsics.areEqual(this.outputNodeName, modelMetadata.outputNodeName) && this.outputDimension == modelMetadata.outputDimension;
    }

    public final TensorShape getInputDimension() {
        return this.inputDimension;
    }

    public final String getModelAsset() {
        return this.modelAsset;
    }

    public final int getOutputDimension() {
        return this.outputDimension;
    }

    public int hashCode() {
        return Integer.hashCode(this.outputDimension) + FileInsert$$ExternalSyntheticOutline0.m((this.inputDimension.hashCode() + FileInsert$$ExternalSyntheticOutline0.m(this.modelAsset.hashCode() * 31, 31, this.inputNodeName)) * 31, 31, this.outputNodeName);
    }

    public String toString() {
        String str = this.modelAsset;
        String str2 = this.inputNodeName;
        TensorShape tensorShape = this.inputDimension;
        String str3 = this.outputNodeName;
        int i = this.outputDimension;
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("ModelMetadata(modelAsset=", str, ", inputNodeName=", str2, ", inputDimension=");
        sbM6m.append(tensorShape);
        sbM6m.append(", outputNodeName=");
        sbM6m.append(str3);
        sbM6m.append(", outputDimension=");
        return FileInsert$$ExternalSyntheticOutline0.m(i, ")", sbM6m);
    }
}
