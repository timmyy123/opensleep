package com.urbandroid.sleep.service.health.session;

import com.urbandroid.sleep.service.health.session.WalkingSensorSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class WalkingSensorSessionMerger<S extends WalkingSensorSession> implements WalkingSensorSessionContainer<S> {
    public static final long MAX_MERGE_DISTANCE_IN_SECONDS = 300;
    private final WalkingSensorSessionFactory<S> factory;
    private final long maxMergeDistanceInSeconds;
    private final List<S> sessions;

    public interface WalkingSensorSessionFactory<W extends WalkingSensorSession> {
        W create(long j, long j2, int i);
    }

    private WalkingSensorSessionMerger(WalkingSensorSessionFactory<S> walkingSensorSessionFactory, long j, List<S> list) {
        this.factory = walkingSensorSessionFactory;
        this.maxMergeDistanceInSeconds = j;
        this.sessions = list;
    }

    public WalkingSensorSessionMerger<S> add(S s) {
        this.sessions.add(s);
        return this;
    }

    @Override // com.urbandroid.sleep.service.health.session.WalkingSensorSessionContainer
    public Collection<S> getWalkingSessions() {
        return this.sessions;
    }

    public WalkingSensorSessionMerger<S> merge() {
        if (this.sessions.isEmpty()) {
            return this;
        }
        Collections.sort(this.sessions, new Comparator<S>() { // from class: com.urbandroid.sleep.service.health.session.WalkingSensorSessionMerger.1
            @Override // java.util.Comparator
            public int compare(S s, S s2) {
                return Long.valueOf(s.getFromInMillis()).compareTo(Long.valueOf(s2.getFromInMillis()));
            }
        });
        ArrayList arrayList = new ArrayList();
        Long l = null;
        int i = 0;
        Long l2 = null;
        for (S s : this.sessions) {
            long fromInMillis = s.getFromInMillis();
            Long lValueOf = Long.valueOf(fromInMillis);
            Long lValueOf2 = Long.valueOf(s.getToInMillis());
            int steps = s.getSteps();
            if (l != null) {
                if (l2.longValue() >= fromInMillis - (this.maxMergeDistanceInSeconds * 1000)) {
                    i += steps;
                    l2 = lValueOf2;
                } else {
                    arrayList.add(this.factory.create(l.longValue(), l2.longValue(), i));
                }
            }
            l = lValueOf;
            l2 = lValueOf2;
            i = steps;
        }
        if (l != null) {
            arrayList.add(this.factory.create(l.longValue(), l2.longValue(), i));
        }
        return new WalkingSensorSessionMerger<>(this.factory, this.maxMergeDistanceInSeconds, arrayList);
    }

    public WalkingSensorSessionMerger(WalkingSensorSessionFactory<S> walkingSensorSessionFactory, long j) {
        this(walkingSensorSessionFactory, j, new ArrayList());
    }

    public WalkingSensorSessionMerger(WalkingSensorSessionFactory<S> walkingSensorSessionFactory) {
        this(walkingSensorSessionFactory, MAX_MERGE_DISTANCE_IN_SECONDS);
    }
}
