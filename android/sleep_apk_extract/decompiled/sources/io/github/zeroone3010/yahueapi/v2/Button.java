package io.github.zeroone3010.yahueapi.v2;

import java.util.Optional;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public interface Button {
    UUID getId();

    Optional<ButtonEventType> getLatestEvent();

    int getNumber();

    Switch getOwner();
}
