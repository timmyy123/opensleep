package androidx.room.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u001a\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0000\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\bH\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\tH\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\rH\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\rH\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u000eH\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u000eH\u0000\u001a\u0014\u0010\u000f\u001a\u00020\b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u0011H\u0002\u001a\u0010\u0010\u0014\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u0011H\u0002¨\u0006\u0015"}, d2 = {"equalsCommon", "", "Landroidx/room/util/TableInfo;", "other", "", "hashCodeCommon", "", "toStringCommon", "", "Landroidx/room/util/TableInfo$Column;", "defaultValueEqualsCommon", "current", "containsSurroundingParenthesis", "Landroidx/room/util/TableInfo$ForeignKey;", "Landroidx/room/util/TableInfo$Index;", "formatString", "collection", "", "joinToStringMiddleWithIndent", "", "joinToStringEndWithIndent", "room-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class TableInfoKt {
    private static final boolean containsSurroundingParenthesis(String str) {
        if (str.length() == 0) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            int i4 = i3 + 1;
            if (i3 == 0 && cCharAt != '(') {
                return false;
            }
            if (cCharAt == '(') {
                i2++;
            } else if (cCharAt == ')' && i2 - 1 == 0 && i3 != str.length() - 1) {
                return false;
            }
            i++;
            i3 = i4;
        }
        return i2 == 0;
    }

    public static final boolean defaultValueEqualsCommon(String str, String str2) {
        str.getClass();
        if (Intrinsics.areEqual(str, str2)) {
            return true;
        }
        if (containsSurroundingParenthesis(str)) {
            return Intrinsics.areEqual(StringsKt.trim(str.substring(1, str.length() - 1)).toString(), str2);
        }
        return false;
    }

    public static final boolean equalsCommon(TableInfo.Column column, Object obj) {
        column.getClass();
        if (column == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.Column)) {
            return false;
        }
        TableInfo.Column column2 = (TableInfo.Column) obj;
        if (column.isPrimaryKey() != column2.isPrimaryKey() || !Intrinsics.areEqual(column.name, column2.name) || column.notNull != column2.notNull) {
            return false;
        }
        String str = column.defaultValue;
        String str2 = column2.defaultValue;
        if (column.createdFrom == 1 && column2.createdFrom == 2 && str != null && !defaultValueEqualsCommon(str, str2)) {
            return false;
        }
        if (column.createdFrom == 2 && column2.createdFrom == 1 && str2 != null && !defaultValueEqualsCommon(str2, str)) {
            return false;
        }
        int i = column.createdFrom;
        return (i == 0 || i != column2.createdFrom || (str == null ? str2 == null : defaultValueEqualsCommon(str, str2))) && column.affinity == column2.affinity;
    }

    public static final String formatString(Collection<?> collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return " }";
        }
        return StringsKt__IndentKt.prependIndent$default(CollectionsKt.joinToString$default(collection, ",\n", "\n", "\n", null, 56), null, 1, null) + "},";
    }

    public static final int hashCodeCommon(TableInfo.Index index) {
        index.getClass();
        return index.orders.hashCode() + FileInsert$$ExternalSyntheticOutline0.m((List) index.columns, (((StringsKt.startsWith$default(index.name, "index_") ? -1184239155 : index.name.hashCode()) * 31) + (index.unique ? 1 : 0)) * 31, 31);
    }

    private static final void joinToStringEndWithIndent(Collection<?> collection) {
        StringsKt__IndentKt.prependIndent$default(CollectionsKt.joinToString$default(collection, ",", null, null, null, 62), null, 1, null);
        StringsKt__IndentKt.prependIndent$default(" }", null, 1, null);
    }

    private static final void joinToStringMiddleWithIndent(Collection<?> collection) {
        StringsKt__IndentKt.prependIndent$default(CollectionsKt.joinToString$default(collection, ",", null, null, null, 62), null, 1, null);
        StringsKt__IndentKt.prependIndent$default("},", null, 1, null);
    }

    public static final String toStringCommon(TableInfo tableInfo) {
        List listEmptyList;
        tableInfo.getClass();
        StringBuilder sb = new StringBuilder("\n            |TableInfo {\n            |    name = '");
        sb.append(tableInfo.name);
        sb.append("',\n            |    columns = {");
        sb.append(formatString(CollectionsKt.sortedWith(tableInfo.columns.values(), new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((TableInfo.Column) t).name, ((TableInfo.Column) t2).name);
            }
        })));
        sb.append("\n            |    foreignKeys = {");
        sb.append(formatString(tableInfo.foreignKeys));
        sb.append("\n            |    indices = {");
        Set<TableInfo.Index> set = tableInfo.indices;
        if (set == null || (listEmptyList = CollectionsKt.sortedWith(set, new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((TableInfo.Index) t).name, ((TableInfo.Index) t2).name);
            }
        })) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        sb.append(formatString(listEmptyList));
        sb.append("\n            |}\n        ");
        return StringsKt__IndentKt.trimMargin$default(sb.toString(), null, 1, null);
    }

    public static final int hashCodeCommon(TableInfo.Column column) {
        column.getClass();
        return (((((column.name.hashCode() * 31) + column.affinity) * 31) + (column.notNull ? 1231 : 1237)) * 31) + column.primaryKeyPosition;
    }

    public static final int hashCodeCommon(TableInfo.ForeignKey foreignKey) {
        foreignKey.getClass();
        return foreignKey.referenceColumnNames.hashCode() + FileInsert$$ExternalSyntheticOutline0.m((List) foreignKey.columnNames, FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(foreignKey.referenceTable.hashCode() * 31, 31, foreignKey.onDelete), 31, foreignKey.onUpdate), 31);
    }

    public static final int hashCodeCommon(TableInfo tableInfo) {
        tableInfo.getClass();
        return tableInfo.foreignKeys.hashCode() + ((tableInfo.columns.hashCode() + (tableInfo.name.hashCode() * 31)) * 31);
    }

    public static final String toStringCommon(TableInfo.Column column) {
        column.getClass();
        StringBuilder sb = new StringBuilder("\n            |Column {\n            |   name = '");
        sb.append(column.name);
        sb.append("',\n            |   type = '");
        sb.append(column.type);
        sb.append("',\n            |   affinity = '");
        sb.append(column.affinity);
        sb.append("',\n            |   notNull = '");
        sb.append(column.notNull);
        sb.append("',\n            |   primaryKeyPosition = '");
        sb.append(column.primaryKeyPosition);
        sb.append("',\n            |   defaultValue = '");
        String str = column.defaultValue;
        if (str == null) {
            str = "undefined";
        }
        sb.append(str);
        sb.append("'\n            |}\n        ");
        return StringsKt__IndentKt.prependIndent$default(StringsKt__IndentKt.trimMargin$default(sb.toString(), null, 1, null), null, 1, null);
    }

    public static final boolean equalsCommon(TableInfo tableInfo, Object obj) {
        Set<TableInfo.Index> set;
        tableInfo.getClass();
        if (tableInfo == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo2 = (TableInfo) obj;
        if (!Intrinsics.areEqual(tableInfo.name, tableInfo2.name) || !Intrinsics.areEqual(tableInfo.columns, tableInfo2.columns) || !Intrinsics.areEqual(tableInfo.foreignKeys, tableInfo2.foreignKeys)) {
            return false;
        }
        Set<TableInfo.Index> set2 = tableInfo.indices;
        if (set2 == null || (set = tableInfo2.indices) == null) {
            return true;
        }
        return Intrinsics.areEqual(set2, set);
    }

    public static final boolean equalsCommon(TableInfo.ForeignKey foreignKey, Object obj) {
        foreignKey.getClass();
        if (foreignKey == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.ForeignKey)) {
            return false;
        }
        TableInfo.ForeignKey foreignKey2 = (TableInfo.ForeignKey) obj;
        if (Intrinsics.areEqual(foreignKey.referenceTable, foreignKey2.referenceTable) && Intrinsics.areEqual(foreignKey.onDelete, foreignKey2.onDelete) && Intrinsics.areEqual(foreignKey.onUpdate, foreignKey2.onUpdate) && Intrinsics.areEqual(foreignKey.columnNames, foreignKey2.columnNames)) {
            return Intrinsics.areEqual(foreignKey.referenceColumnNames, foreignKey2.referenceColumnNames);
        }
        return false;
    }

    public static final boolean equalsCommon(TableInfo.Index index, Object obj) {
        index.getClass();
        if (index == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.Index)) {
            return false;
        }
        TableInfo.Index index2 = (TableInfo.Index) obj;
        if (index.unique != index2.unique || !Intrinsics.areEqual(index.columns, index2.columns) || !Intrinsics.areEqual(index.orders, index2.orders)) {
            return false;
        }
        if (StringsKt.startsWith$default(index.name, "index_")) {
            return StringsKt.startsWith$default(index2.name, "index_");
        }
        return Intrinsics.areEqual(index.name, index2.name);
    }

    public static final String toStringCommon(TableInfo.ForeignKey foreignKey) {
        foreignKey.getClass();
        StringBuilder sb = new StringBuilder("\n            |ForeignKey {\n            |   referenceTable = '");
        sb.append(foreignKey.referenceTable);
        sb.append("',\n            |   onDelete = '");
        sb.append(foreignKey.onDelete);
        sb.append("',\n            |   onUpdate = '");
        sb.append(foreignKey.onUpdate);
        sb.append("',\n            |   columnNames = {");
        joinToStringMiddleWithIndent(CollectionsKt.sorted(foreignKey.columnNames));
        Unit unit = Unit.INSTANCE;
        sb.append(unit);
        sb.append("\n            |   referenceColumnNames = {");
        joinToStringEndWithIndent(CollectionsKt.sorted(foreignKey.referenceColumnNames));
        sb.append(unit);
        sb.append("\n            |}\n        ");
        return StringsKt__IndentKt.prependIndent$default(StringsKt__IndentKt.trimMargin$default(sb.toString(), null, 1, null), null, 1, null);
    }

    public static final String toStringCommon(TableInfo.Index index) {
        index.getClass();
        StringBuilder sb = new StringBuilder("\n            |Index {\n            |   name = '");
        sb.append(index.name);
        sb.append("',\n            |   unique = '");
        sb.append(index.unique);
        sb.append("',\n            |   columns = {");
        joinToStringMiddleWithIndent(index.columns);
        Unit unit = Unit.INSTANCE;
        sb.append(unit);
        sb.append("\n            |   orders = {");
        joinToStringEndWithIndent(index.orders);
        sb.append(unit);
        sb.append("\n            |}\n        ");
        return StringsKt__IndentKt.prependIndent$default(StringsKt__IndentKt.trimMargin$default(sb.toString(), null, 1, null), null, 1, null);
    }
}
