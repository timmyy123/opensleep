package androidx.appfunctions.compiler.core.metadata;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadata;", "", "<init>", "()V", "isNullable", "", "()Z", "description", "", "getDescription", "()Ljava/lang/String;", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadataDocument;", "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AppFunctionDataTypeMetadata {
    public static final int TYPE_ALL_OF = 12;
    public static final int TYPE_ARRAY = 10;
    public static final int TYPE_BOOLEAN = 1;
    public static final int TYPE_BYTES = 2;
    public static final int TYPE_DOUBLE = 4;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_INT = 7;
    public static final int TYPE_LONG = 6;
    public static final int TYPE_OBJECT = 3;
    public static final int TYPE_ONE_OF = 14;
    public static final int TYPE_PARCELABLE = 13;
    public static final int TYPE_REFERENCE = 11;
    public static final int TYPE_STRING = 8;
    public static final int TYPE_UNIT = 0;

    public abstract String getDescription();

    public abstract boolean isNullable();

    public abstract AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument();
}
