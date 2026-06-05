package com.urbandroid.sleep.service.health.session;

import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.filter.HealthSessionFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class HealthSessionTransformer<S extends HealthSession> {
    private Set<HealthSessionOperation> operations = new LinkedHashSet();
    private final Collection<S> sessions;

    public interface Action {
        void next(HealthSession healthSession);
    }

    public HealthSessionTransformer(Collection<S> collection) {
        this.sessions = collection;
    }

    public HealthSessionTransformer filter(HealthSessionFilter healthSessionFilter) {
        this.operations.add(healthSessionFilter);
        return this;
    }

    public HealthSessionTransformer map(HealthSessionMapper healthSessionMapper) {
        this.operations.add(healthSessionMapper);
        return this;
    }

    public void subscribe(Action action) {
        Iterator<S> it = this.sessions.iterator();
        while (it.hasNext()) {
            S next = it.next();
            Iterator<HealthSessionOperation> it2 = this.operations.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                HealthSessionOperation next2 = it2.next();
                if ((next2 instanceof HealthSessionFilter) && !((HealthSessionFilter) next2).accept(next)) {
                    next = null;
                    break;
                } else if (next2 instanceof HealthSessionMapper) {
                    next = ((HealthSessionMapper) next2).map(next);
                }
            }
            if (next != null) {
                action.next(next);
            }
        }
    }

    public List<HealthSession> toCollection() {
        final ArrayList arrayList = new ArrayList();
        subscribe(new Action() { // from class: com.urbandroid.sleep.service.health.session.HealthSessionTransformer.1
            @Override // com.urbandroid.sleep.service.health.session.HealthSessionTransformer.Action
            public void next(HealthSession healthSession) {
                arrayList.add(healthSession);
            }
        });
        return arrayList;
    }
}
