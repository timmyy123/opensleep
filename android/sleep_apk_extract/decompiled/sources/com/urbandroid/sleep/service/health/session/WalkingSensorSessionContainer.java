package com.urbandroid.sleep.service.health.session;

import com.urbandroid.sleep.service.health.session.WalkingSensorSession;
import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
public interface WalkingSensorSessionContainer<S extends WalkingSensorSession> {
    Collection<S> getWalkingSessions();
}
