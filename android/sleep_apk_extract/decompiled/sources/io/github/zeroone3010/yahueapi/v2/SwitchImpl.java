package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda1;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class SwitchImpl implements Switch {
    private final Map<UUID, Button> buttons;
    private final UUID id;
    private final String name;

    public SwitchImpl(UUID uuid, Map<UUID, Button> map, String str) {
        this.id = uuid;
        this.buttons = map;
        this.name = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getLatestPressedButton$0(Button button) {
        return button.getLatestEvent().isPresent();
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Switch
    public Map<UUID, Button> getButtons() {
        return this.buttons;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Switch, io.github.zeroone3010.yahueapi.v2.Device
    public UUID getId() {
        return this.id;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Switch
    public Optional<Button> getLatestPressedButton() {
        return this.buttons.values().stream().filter(new Color$$ExternalSyntheticLambda1(26)).findFirst();
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Switch, io.github.zeroone3010.yahueapi.v2.Device
    public String getName() {
        return this.name;
    }

    public String toString() {
        return getId() + ": " + getName();
    }
}
