package io.github.zeroone3010.yahueapi.v2;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda0;
import io.github.zeroone3010.yahueapi.v2.domain.ButtonResource;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public class ButtonImpl implements Button {
    private final UUID id;
    private int number;
    private Switch owner;
    private final Supplier<ButtonResource> stateProvider;

    public ButtonImpl(Supplier<ButtonResource> supplier, ButtonResource buttonResource) {
        this.stateProvider = supplier;
        this.id = buttonResource.getId();
        this.number = buttonResource.getMetadata().getControlId();
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Button
    public UUID getId() {
        return this.id;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Button
    public Optional<ButtonEventType> getLatestEvent() {
        return Optional.ofNullable(this.stateProvider.get().getButton()).map(new Color$$ExternalSyntheticLambda0(8)).map(new Color$$ExternalSyntheticLambda0(9));
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Button
    public int getNumber() {
        return this.number;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Button
    public Switch getOwner() {
        return this.owner;
    }

    public void setOwner(Switch r1) {
        this.owner = r1;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("Button{"), this.number, '}');
    }
}
