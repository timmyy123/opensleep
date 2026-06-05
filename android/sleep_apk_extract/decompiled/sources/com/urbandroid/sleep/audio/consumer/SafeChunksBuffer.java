package com.urbandroid.sleep.audio.consumer;

import com.urbandroid.util.ArrayUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/audio/consumer/SafeChunksBuffer;", "", "", "fullSize", "<init>", "(I)V", "", "chunk", "", "add", "([F)V", "clear", "()V", "size", "joinChunks", "(I)[F", "joinAllChunks", "()[F", "()I", "I", "", "chunks", "Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SafeChunksBuffer {
    private final List<float[]> chunks = new ArrayList();
    private final int fullSize;

    public SafeChunksBuffer(int i) {
        this.fullSize = i;
    }

    public final synchronized void add(float[] chunk) {
        chunk.getClass();
        this.chunks.add(chunk);
        while (this.chunks.size() > this.fullSize) {
            this.chunks.remove(0);
        }
    }

    public final synchronized void clear() {
        this.chunks.clear();
    }

    public final synchronized float[] joinAllChunks() {
        return joinChunks(this.chunks.size());
    }

    public final synchronized float[] joinChunks(int size) {
        float[] fArrJoin;
        List<float[]> list = this.chunks;
        fArrJoin = ArrayUtil.join(list.subList(Math.max(0, list.size() - size), this.chunks.size()));
        fArrJoin.getClass();
        return fArrJoin;
    }

    public final synchronized int size() {
        return this.chunks.size();
    }
}
