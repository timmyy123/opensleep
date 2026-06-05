package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractTypePreparator {

    public static final class Default extends AbstractTypePreparator {
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
        public KotlinTypeMarker prepareType(KotlinTypeMarker kotlinTypeMarker) {
            kotlinTypeMarker.getClass();
            return kotlinTypeMarker;
        }
    }

    public RigidTypeMarker clearTypeFromUnnecessaryAttributes(RigidTypeMarker rigidTypeMarker) {
        rigidTypeMarker.getClass();
        return rigidTypeMarker;
    }

    public abstract KotlinTypeMarker prepareType(KotlinTypeMarker kotlinTypeMarker);
}
