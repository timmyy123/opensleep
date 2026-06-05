package com.fasterxml.jackson.databind.module;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleModule extends Module implements Serializable {
    private static final AtomicInteger MODULE_ID_SEQ = new AtomicInteger(1);
    private static final long serialVersionUID = 1;
    protected SimpleDeserializers _deserializers = null;
    protected HashMap<Class<?>, Class<?>> _mixins = null;
    protected LinkedHashSet<NamedType> _subtypes = null;
    protected final String _name = _generateName(getClass());
    protected final Version _version = Version.unknownVersion();
    protected final boolean _hasExplicitName = false;

    private static String _generateName(Class<?> cls) {
        if (cls != SimpleModule.class) {
            return cls.getName();
        }
        return "SimpleModule-" + MODULE_ID_SEQ.getAndIncrement();
    }

    public void _checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Cannot pass `null` as ", str));
    }

    public <T> SimpleModule addDeserializer(Class<T> cls, JsonDeserializer<? extends T> jsonDeserializer) {
        _checkNotNull(cls, "type to register deserializer for");
        _checkNotNull(jsonDeserializer, "deserializer");
        if (this._deserializers == null) {
            this._deserializers = new SimpleDeserializers();
        }
        this._deserializers.addDeserializer(cls, jsonDeserializer);
        return this;
    }

    @Override // com.fasterxml.jackson.databind.Module
    public String getModuleName() {
        return this._name;
    }

    @Override // com.fasterxml.jackson.databind.Module
    public Object getTypeId() {
        return this._hasExplicitName ? this._name : getClass() == SimpleModule.class ? this._name : super.getTypeId();
    }

    @Override // com.fasterxml.jackson.databind.Module
    public void setupModule(Module.SetupContext setupContext) {
        SimpleDeserializers simpleDeserializers = this._deserializers;
        if (simpleDeserializers != null) {
            setupContext.addDeserializers(simpleDeserializers);
        }
        LinkedHashSet<NamedType> linkedHashSet = this._subtypes;
        if (linkedHashSet != null && linkedHashSet.size() > 0) {
            LinkedHashSet<NamedType> linkedHashSet2 = this._subtypes;
            setupContext.registerSubtypes((NamedType[]) linkedHashSet2.toArray(new NamedType[linkedHashSet2.size()]));
        }
        HashMap<Class<?>, Class<?>> map = this._mixins;
        if (map != null) {
            for (Map.Entry<Class<?>, Class<?>> entry : map.entrySet()) {
                setupContext.setMixInAnnotations(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.Module
    public Version version() {
        return this._version;
    }
}
