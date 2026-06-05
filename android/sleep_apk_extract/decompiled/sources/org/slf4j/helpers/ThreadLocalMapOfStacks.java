package org.slf4j.helpers;

import java.util.Deque;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ThreadLocalMapOfStacks {
    final ThreadLocal<Map<String, Deque<String>>> tlMapOfStacks = new ThreadLocal<>();
}
