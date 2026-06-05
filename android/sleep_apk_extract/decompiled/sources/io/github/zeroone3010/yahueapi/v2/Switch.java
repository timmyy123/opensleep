package io.github.zeroone3010.yahueapi.v2;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public interface Switch extends Device {
    Map<UUID, Button> getButtons();

    @Override // io.github.zeroone3010.yahueapi.v2.Device
    UUID getId();

    Optional<Button> getLatestPressedButton();

    @Override // io.github.zeroone3010.yahueapi.v2.Device
    String getName();
}
