package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
class FragmentLifecycleCallbacksDispatcher {
    private final FragmentManager mFragmentManager;
    private final CopyOnWriteArrayList<Object> mLifecycleCallbacks = new CopyOnWriteArrayList<>();

    public FragmentLifecycleCallbacksDispatcher(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    public void dispatchOnFragmentActivityCreated(Fragment fragment, Bundle bundle, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentActivityCreated(fragment, bundle, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentAttached(Fragment fragment, boolean z) {
        this.mFragmentManager.getHost().getContext();
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentAttached(fragment, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentCreated(Fragment fragment, Bundle bundle, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentCreated(fragment, bundle, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentDestroyed(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDestroyed(fragment, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentDetached(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDetached(fragment, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentPaused(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPaused(fragment, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentPreAttached(Fragment fragment, boolean z) {
        this.mFragmentManager.getHost().getContext();
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreAttached(fragment, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentPreCreated(Fragment fragment, Bundle bundle, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreCreated(fragment, bundle, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentResumed(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentResumed(fragment, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentSaveInstanceState(Fragment fragment, Bundle bundle, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentSaveInstanceState(fragment, bundle, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentStarted(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStarted(fragment, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentStopped(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStopped(fragment, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentViewCreated(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewCreated(fragment, view, bundle, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentViewDestroyed(Fragment fragment, boolean z) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewDestroyed(fragment, true);
        }
        Iterator<Object> it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }
}
