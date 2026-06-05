package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PotentialCreators {
    private List<PotentialCreator> explicitDelegating;
    private List<PotentialCreator> implicitDelegatingConstructors;
    private List<PotentialCreator> implicitDelegatingFactories;
    public PotentialCreator propertiesBased;
    private boolean propertiesBasedExplicit;

    private void _setPropertiesBased(MapperConfig<?> mapperConfig, PotentialCreator potentialCreator, String str, boolean z) {
        PotentialCreator potentialCreator2 = this.propertiesBased;
        if (potentialCreator2 != null) {
            Home$$ExternalSyntheticBUOutline0.m("Conflicting property-based creators: already had %s creator %s, encountered another: %s", new Object[]{str, potentialCreator2.creator(), potentialCreator.creator()});
        } else {
            this.propertiesBased = potentialCreator.introspectParamNames(mapperConfig);
            this.propertiesBasedExplicit = z;
        }
    }

    public void addExplicitDelegating(PotentialCreator potentialCreator) {
        if (this.explicitDelegating == null) {
            this.explicitDelegating = new ArrayList();
        }
        this.explicitDelegating.add(potentialCreator);
    }

    public List<PotentialCreator> getExplicitDelegating() {
        List<PotentialCreator> list = this.explicitDelegating;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List<PotentialCreator> getImplicitDelegatingConstructors() {
        List<PotentialCreator> list = this.implicitDelegatingConstructors;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List<PotentialCreator> getImplicitDelegatingFactories() {
        List<PotentialCreator> list = this.implicitDelegatingFactories;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public boolean hasDelegating() {
        List<PotentialCreator> list = this.explicitDelegating;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean hasExplicitPropertiesBased() {
        return this.propertiesBasedExplicit;
    }

    public boolean hasPropertiesBased() {
        return this.propertiesBased != null;
    }

    public boolean hasPropertiesBasedOrDelegating() {
        if (this.propertiesBased != null) {
            return true;
        }
        List<PotentialCreator> list = this.explicitDelegating;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void setExplicitPropertiesBased(MapperConfig<?> mapperConfig, PotentialCreator potentialCreator) {
        _setPropertiesBased(mapperConfig, potentialCreator, "explicit", true);
    }

    public void setImplicitDelegating(List<PotentialCreator> list, List<PotentialCreator> list2) {
        this.implicitDelegatingConstructors = list;
        this.implicitDelegatingFactories = list2;
    }

    public void setPropertiesBased(MapperConfig<?> mapperConfig, PotentialCreator potentialCreator, String str) {
        _setPropertiesBased(mapperConfig, potentialCreator, str, false);
    }
}
