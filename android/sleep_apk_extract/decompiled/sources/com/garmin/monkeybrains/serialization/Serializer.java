package com.garmin.monkeybrains.serialization;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Serializer {
    private SerializedObject mSerializedObject;

    public Serializer() {
        this.mSerializedObject = new SerializedObject();
    }

    public static List<MonkeyType<?>> deserialize(byte[] bArr) {
        return new SerializedObject(bArr).getValues();
    }

    public static <T> byte[] serialize(T t) {
        return new Serializer(t).serialize();
    }

    public <T> void addObject(T t) {
        this.mSerializedObject.addObject(MonkeyType.fromJava(t));
    }

    public byte[] serialize() {
        return this.mSerializedObject.serialize();
    }

    public Serializer(Object obj) {
        this();
        addObject(obj);
    }
}
