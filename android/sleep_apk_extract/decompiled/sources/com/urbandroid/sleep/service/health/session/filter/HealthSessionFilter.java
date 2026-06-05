package com.urbandroid.sleep.service.health.session.filter;

import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.HealthSessionOperation;

/* JADX INFO: loaded from: classes5.dex */
public interface HealthSessionFilter extends HealthSessionOperation {
    boolean accept(HealthSession healthSession);
}
