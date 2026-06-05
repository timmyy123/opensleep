package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Module {

    public interface SetupContext {
        void addDeserializers(Deserializers deserializers);

        void registerSubtypes(NamedType... namedTypeArr);

        void setMixInAnnotations(Class<?> cls, Class<?> cls2);
    }

    public Iterable<? extends Module> getDependencies() {
        return Collections.EMPTY_LIST;
    }

    public abstract String getModuleName();

    public Object getTypeId() {
        return getClass().getName();
    }

    public abstract void setupModule(SetupContext setupContext);

    public abstract Version version();
}
