package io.github.zeroone3010.yahueapi.v2;

import j$.time.ZonedDateTime;
import java.util.Collection;
import java.util.Optional;

/* JADX INFO: loaded from: classes5.dex */
public final class NewLightsResult {
    private final ZonedDateTime lastSearchTime;
    private final Collection<Light> newLights;
    private final NewLightsSearchStatus status;

    public NewLightsResult(Collection<Light> collection, NewLightsSearchStatus newLightsSearchStatus, ZonedDateTime zonedDateTime) {
        this.newLights = collection;
        this.status = newLightsSearchStatus;
        this.lastSearchTime = zonedDateTime;
    }

    public Optional<ZonedDateTime> getLastSearchTime() {
        return Optional.ofNullable(this.lastSearchTime);
    }

    public Collection<Light> getNewLights() {
        return this.newLights;
    }

    public NewLightsSearchStatus getStatus() {
        return this.status;
    }

    public String toString() {
        return "NewLightsResult{newLights=" + this.newLights + ", status=" + this.status + ", lastSearchTime=" + this.lastSearchTime + '}';
    }
}
