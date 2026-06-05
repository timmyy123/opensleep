package com.google.home;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/google/home/HasConnectivityState;", "", "Companion", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface HasConnectivityState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0000¢\u0006\u0002\b\bJ\u001b\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0000¢\u0006\u0002\b\fJ\u001b\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0000¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/google/home/HasConnectivityState$Companion;", "", "<init>", "()V", "computeSourceConnectivity", "Lcom/google/home/SourceConnectivity;", "sourceConnectivityList", "", "computeSourceConnectivity$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android", "computeConnectivityAggregate", "Lcom/google/home/ConnectivityState;", "connectivityStateList", "computeConnectivityAggregate$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android", "computeDataSourceLocalityForDevice", "Lcom/google/home/LocalityType;", "localityTypeList", "computeDataSourceLocalityForDevice$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final ConnectivityState computeConnectivityAggregate$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android(List<? extends ConnectivityState> connectivityStateList) {
            connectivityStateList.getClass();
            if (connectivityStateList.isEmpty()) {
                return ConnectivityState.UNKNOWN;
            }
            Set<ConnectivityState> set = CollectionsKt.toSet(connectivityStateList);
            if (set.size() == 1) {
                return (ConnectivityState) CollectionsKt.first(set);
            }
            if (!set.isEmpty()) {
                for (ConnectivityState connectivityState : set) {
                    ConnectivityState connectivityState2 = ConnectivityState.PARTIALLY_ONLINE;
                    if (connectivityState == connectivityState2 || connectivityState == ConnectivityState.ONLINE) {
                        return connectivityState2;
                    }
                }
            }
            return ConnectivityState.UNKNOWN;
        }

        public final LocalityType computeDataSourceLocalityForDevice$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android(List<? extends LocalityType> localityTypeList) {
            localityTypeList.getClass();
            ArrayList arrayList = new ArrayList();
            for (Object obj : localityTypeList) {
                if (((LocalityType) obj) != LocalityType.UNSPECIFIED) {
                    arrayList.add(obj);
                }
            }
            Set set = CollectionsKt.toSet(arrayList);
            int size = set.size();
            return size != 0 ? size != 1 ? LocalityType.MIXED : (LocalityType) CollectionsKt.first(set) : LocalityType.UNSPECIFIED;
        }

        public final SourceConnectivity computeSourceConnectivity$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android(List<SourceConnectivity> sourceConnectivityList) {
            sourceConnectivityList.getClass();
            List<SourceConnectivity> list = sourceConnectivityList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((SourceConnectivity) it.next()).getConnectivityState());
            }
            ConnectivityState connectivityStateComputeConnectivityAggregate$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android = computeConnectivityAggregate$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android(arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((SourceConnectivity) it2.next()).getDataSourceLocality());
            }
            LocalityType localityTypeComputeDataSourceLocalityForDevice$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android = computeDataSourceLocalityForDevice$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it3 = list.iterator();
            while (it3.hasNext()) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList3, ((SourceConnectivity) it3.next()).getBackingHubs());
            }
            return new SourceConnectivity(connectivityStateComputeConnectivityAggregate$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android, localityTypeComputeDataSourceLocalityForDevice$java_com_google_nest_platform_mesh_semantic_src_com_google_home_public_api_android, CollectionsKt.toSet(arrayList3));
        }
    }
}
