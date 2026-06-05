package androidx.health.platform.client.proto;

/* JADX INFO: loaded from: classes.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = new MutabilityOracle() { // from class: androidx.health.platform.client.proto.MutabilityOracle.1
        @Override // androidx.health.platform.client.proto.MutabilityOracle
        public void ensureMutable() {
            throw new UnsupportedOperationException();
        }
    };

    void ensureMutable();
}
