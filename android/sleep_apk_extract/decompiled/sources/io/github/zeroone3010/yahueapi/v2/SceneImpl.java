package io.github.zeroone3010.yahueapi.v2;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.UUID;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class SceneImpl implements Scene {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) SceneImpl.class);
    private UUID id;
    private String name;
    private Supplier<String> stateSetter;

    public SceneImpl(UUID uuid, String str, Supplier<String> supplier) {
        this.id = uuid;
        this.name = str;
        this.stateSetter = supplier;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Scene
    public void activate() {
        logger.info(this.stateSetter.get());
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Scene
    public UUID getId() {
        return this.id;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Scene
    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SceneImpl{id=");
        sb.append(this.id);
        sb.append(", name='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.name, "'}");
    }
}
