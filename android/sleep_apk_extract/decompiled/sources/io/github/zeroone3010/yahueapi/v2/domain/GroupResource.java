package io.github.zeroone3010.yahueapi.v2.domain;

import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public interface GroupResource {
    List<ResourceIdentifier> getChildren();

    UUID getId();

    String getIdV1();

    Metadata getMetadata();

    List<ResourceIdentifier> getServices();

    ResourceType getType();
}
