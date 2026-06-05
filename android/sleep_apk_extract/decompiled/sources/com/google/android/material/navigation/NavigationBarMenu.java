package com.google.android.material.navigation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class NavigationBarMenu extends MenuBuilder {
    private final int maxItemCount;
    private final boolean subMenuSupported;
    private final Class<?> viewClass;

    public NavigationBarMenu(Context context, Class<?> cls, int i, boolean z) {
        super(context);
        this.viewClass = cls;
        this.maxItemCount = i;
        this.subMenuSupported = z;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public MenuItem addInternal(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 <= this.maxItemCount) {
            stopDispatchingItemsChanged();
            MenuItem menuItemAddInternal = super.addInternal(i, i2, i3, charSequence);
            startDispatchingItemsChanged();
            return menuItemAddInternal;
        }
        String simpleName = this.viewClass.getSimpleName();
        StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Maximum number of items supported by ", simpleName, " is ");
        sbM5m.append(this.maxItemCount);
        sbM5m.append(". Limit can be checked with ");
        sbM5m.append(simpleName);
        sbM5m.append("#getMaxItemCount()");
        throw new IllegalArgumentException(sbM5m.toString());
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        if (!this.subMenuSupported) {
            Utf8$$ExternalSyntheticBUOutline0.m(this.viewClass.getSimpleName().concat(" does not support submenus"));
            return null;
        }
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i, i2, i3, charSequence);
        NavigationBarSubMenu navigationBarSubMenu = new NavigationBarSubMenu(getContext(), this, menuItemImpl);
        menuItemImpl.setSubMenu(navigationBarSubMenu);
        return navigationBarSubMenu;
    }
}
