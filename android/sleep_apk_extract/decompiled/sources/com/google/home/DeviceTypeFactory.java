package com.google.home;

import com.google.home.DeviceType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/google/home/DeviceTypeFactory;", "T", "Lcom/google/home/DeviceType;", "Lcom/google/home/TypeFactory;", "factory", "Lcom/google/home/InternalDeviceTypeFactory;", "<init>", "(Lcom/google/home/InternalDeviceTypeFactory;)V", "getFactory", "()Lcom/google/home/InternalDeviceTypeFactory;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class DeviceTypeFactory<T extends DeviceType> extends TypeFactory<T> {
    private final InternalDeviceTypeFactory<T> factory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceTypeFactory(InternalDeviceTypeFactory<T> internalDeviceTypeFactory) {
        super(internalDeviceTypeFactory);
        internalDeviceTypeFactory.getClass();
        this.factory = internalDeviceTypeFactory;
    }

    public InternalDeviceTypeFactory<T> getFactory() {
        return this.factory;
    }
}
