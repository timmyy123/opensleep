package com.facebook.appevents.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b7\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/facebook/appevents/internal/ViewHierarchyConstants;", "", "()V", "ADAPTER_VIEW_ITEM_BITMASK", "", ViewHierarchyConstants.ADD_PAYMENT_INFO, "", ViewHierarchyConstants.ADD_TO_CART, ViewHierarchyConstants.ADD_TO_WISHLIST, "BUTTON_BITMASK", ViewHierarchyConstants.BUTTON_ID, ViewHierarchyConstants.BUTTON_TEXT, "CHECKBOX_BITMASK", "CHILDREN_VIEW_KEY", "CLASS_NAME_KEY", "CLASS_TYPE_BITMASK_KEY", "CLICKABLE_VIEW_BITMASK", ViewHierarchyConstants.COMPLETE_REGISTRATION, "DESC_KEY", "DIMENSION_HEIGHT_KEY", "DIMENSION_KEY", "DIMENSION_LEFT_KEY", "DIMENSION_SCROLL_X_KEY", "DIMENSION_SCROLL_Y_KEY", "DIMENSION_TOP_KEY", "DIMENSION_VISIBILITY_KEY", "DIMENSION_WIDTH_KEY", ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.GERMAN, "HINT_KEY", "ICON_BITMAP", "ID_KEY", "IMAGEVIEW_BITMASK", ViewHierarchyConstants.INITIATE_CHECKOUT, "INPUT_BITMASK", "INPUT_TYPE_KEY", "IS_INTERACTED_KEY", "IS_USER_INPUT_KEY", ViewHierarchyConstants.JAPANESE, "LABEL_BITMASK", ViewHierarchyConstants.LEAD, ViewHierarchyConstants.PAGE_TITLE, "PICKER_BITMASK", ViewHierarchyConstants.PURCHASE, "RADIO_GROUP_BITMASK", "RATINGBAR_BITMASK", "REACT_NATIVE_BUTTON_BITMASK", ViewHierarchyConstants.RESOLVED_DOCUMENT_LINK, "SCREEN_NAME_KEY", ViewHierarchyConstants.SEARCH, ViewHierarchyConstants.SPANISH, "SWITCH_BITMASK", "TAG_KEY", "TEXTVIEW_BITMASK", "TEXT_IS_BOLD", "TEXT_IS_ITALIC", "TEXT_KEY", "TEXT_SIZE", "TEXT_STYLE", ViewHierarchyConstants.VIEW_CONTENT, "VIEW_KEY", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewHierarchyConstants {
    public static final int ADAPTER_VIEW_ITEM_BITMASK = 9;
    public static final String ADD_PAYMENT_INFO = "ADD_PAYMENT_INFO";
    public static final String ADD_TO_CART = "ADD_TO_CART";
    public static final String ADD_TO_WISHLIST = "ADD_TO_WISHLIST";
    public static final int BUTTON_BITMASK = 2;
    public static final String BUTTON_ID = "BUTTON_ID";
    public static final String BUTTON_TEXT = "BUTTON_TEXT";
    public static final int CHECKBOX_BITMASK = 15;
    public static final String CHILDREN_VIEW_KEY = "childviews";
    public static final String CLASS_NAME_KEY = "classname";
    public static final String CLASS_TYPE_BITMASK_KEY = "classtypebitmask";
    public static final int CLICKABLE_VIEW_BITMASK = 5;
    public static final String COMPLETE_REGISTRATION = "COMPLETE_REGISTRATION";
    public static final String DESC_KEY = "description";
    public static final String DIMENSION_HEIGHT_KEY = "height";
    public static final String DIMENSION_KEY = "dimension";
    public static final String DIMENSION_LEFT_KEY = "left";
    public static final String DIMENSION_SCROLL_X_KEY = "scrollx";
    public static final String DIMENSION_SCROLL_Y_KEY = "scrolly";
    public static final String DIMENSION_TOP_KEY = "top";
    public static final String DIMENSION_VISIBILITY_KEY = "visibility";
    public static final String DIMENSION_WIDTH_KEY = "width";
    public static final String ENGLISH = "ENGLISH";
    public static final String GERMAN = "GERMAN";
    public static final String HINT_KEY = "hint";
    public static final String ICON_BITMAP = "icon_image";
    public static final String ID_KEY = "id";
    public static final int IMAGEVIEW_BITMASK = 1;
    public static final String INITIATE_CHECKOUT = "INITIATE_CHECKOUT";
    public static final int INPUT_BITMASK = 11;
    public static final String INPUT_TYPE_KEY = "inputtype";
    public static final ViewHierarchyConstants INSTANCE = new ViewHierarchyConstants();
    public static final String IS_INTERACTED_KEY = "is_interacted";
    public static final String IS_USER_INPUT_KEY = "is_user_input";
    public static final String JAPANESE = "JAPANESE";
    public static final int LABEL_BITMASK = 10;
    public static final String LEAD = "LEAD";
    public static final String PAGE_TITLE = "PAGE_TITLE";
    public static final int PICKER_BITMASK = 12;
    public static final String PURCHASE = "PURCHASE";
    public static final int RADIO_GROUP_BITMASK = 14;
    public static final int RATINGBAR_BITMASK = 16;
    public static final int REACT_NATIVE_BUTTON_BITMASK = 6;
    public static final String RESOLVED_DOCUMENT_LINK = "RESOLVED_DOCUMENT_LINK";
    public static final String SCREEN_NAME_KEY = "screenname";
    public static final String SEARCH = "SEARCH";
    public static final String SPANISH = "SPANISH";
    public static final int SWITCH_BITMASK = 13;
    public static final String TAG_KEY = "tag";
    public static final int TEXTVIEW_BITMASK = 0;
    public static final String TEXT_IS_BOLD = "is_bold";
    public static final String TEXT_IS_ITALIC = "is_italic";
    public static final String TEXT_KEY = "text";
    public static final String TEXT_SIZE = "font_size";
    public static final String TEXT_STYLE = "text_style";
    public static final String VIEW_CONTENT = "VIEW_CONTENT";
    public static final String VIEW_KEY = "view";

    private ViewHierarchyConstants() {
    }
}
