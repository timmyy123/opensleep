package com.urbandroid.sleep.gui;

import android.view.Menu;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/gui/MenuUtil;", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class MenuUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/gui/MenuUtil$Companion;", "", "<init>", "()V", "showIcons", "", "menu", "Landroid/view/Menu;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void showIcons(Menu menu) {
            Field declaredField = null;
            if (StringsKt__StringsJVMKt.equals$default(menu != null ? menu.getClass().getSimpleName() : null, "MenuBuilder", false, 2, null)) {
                if (menu != null) {
                    try {
                        declaredField = menu.getClass().getDeclaredField("mOptionalIconsVisible");
                    } catch (Exception unused) {
                        return;
                    }
                }
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
                if (declaredField != null) {
                    declaredField.setBoolean(menu, true);
                }
            }
        }

        private Companion() {
        }
    }

    public static final void showIcons(Menu menu) {
        INSTANCE.showIcons(menu);
    }
}
