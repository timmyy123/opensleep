package androidx.appsearch.app;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public class PropertyPath implements Iterable<PathSegment> {
    private final List<PathSegment> mPathList;

    public static class PathSegment {
        private final int mPropertyIndex;
        private final String mPropertyName;

        public PathSegment(String str, int i) {
            this.mPropertyName = (String) ObjectsCompat.requireNonNull(str);
            this.mPropertyIndex = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof PathSegment)) {
                return false;
            }
            PathSegment pathSegment = (PathSegment) obj;
            return this.mPropertyIndex == pathSegment.mPropertyIndex && this.mPropertyName.equals(pathSegment.mPropertyName);
        }

        public int getPropertyIndex() {
            return this.mPropertyIndex;
        }

        public String getPropertyName() {
            return this.mPropertyName;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mPropertyName, Integer.valueOf(this.mPropertyIndex));
        }

        public String toString() {
            int i = this.mPropertyIndex;
            String str = this.mPropertyName;
            if (i == -1) {
                return str;
            }
            return FileInsert$$ExternalSyntheticOutline0.m(this.mPropertyIndex, "]", Fragment$$ExternalSyntheticOutline1.m(str, "["));
        }
    }

    public PropertyPath(String str) {
        Preconditions.checkNotNull(str);
        this.mPathList = new ArrayList();
        try {
            recursivePathScan(str);
        } catch (IllegalArgumentException e) {
            OggIO$$ExternalSyntheticBUOutline0.m(e.getMessage(), ": ", str);
            throw null;
        }
    }

    private String consumePropertyWithIndex(String str, int i) {
        Preconditions.checkNotNull(str);
        String strSubstring = str.substring(0, i);
        int iIndexOf = str.indexOf(93, i);
        if (iIndexOf == -1) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Malformed path (no ending ']')");
            return null;
        }
        int i2 = iIndexOf + 1;
        if (i2 < str.length() && str.charAt(i2) != '.') {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Malformed path (']' not followed by '.'): ".concat(str));
            return null;
        }
        String strSubstring2 = str.substring(i + 1, iIndexOf);
        try {
            int i3 = Integer.parseInt(strSubstring2);
            if (i3 < 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Malformed path (path index less than 0)");
                return null;
            }
            this.mPathList.add(new PathSegment(strSubstring, i3));
            if (i2 < str.length()) {
                return str.substring(iIndexOf + 2);
            }
            return null;
        } catch (NumberFormatException unused) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Malformed path (\"", strSubstring2, "\" as path index)"));
            return null;
        }
    }

    private void recursivePathScan(String str) {
        boolean z;
        String strConsumePropertyWithIndex;
        int i = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == ']') {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Malformed path (no starting '[')");
                return;
            }
            if (cCharAt == '[' || cCharAt == '.') {
                z = cCharAt == '[';
                if (i != 0 || str.isEmpty()) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Malformed path (blank property name)");
                }
                if (i == -1) {
                    this.mPathList.add(new PathSegment(str, -1));
                    return;
                }
                if (z) {
                    strConsumePropertyWithIndex = consumePropertyWithIndex(str, i);
                    if (strConsumePropertyWithIndex == null) {
                        return;
                    }
                } else {
                    String strSubstring = str.substring(0, i);
                    strConsumePropertyWithIndex = str.substring(i + 1);
                    this.mPathList.add(new PathSegment(strSubstring, -1));
                }
                recursivePathScan(strConsumePropertyWithIndex);
                return;
            }
            i++;
        }
        z = false;
        i = -1;
        if (i != 0) {
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Malformed path (blank property name)");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof PropertyPath)) {
            return ObjectsCompat.equals(this.mPathList, ((PropertyPath) obj).mPathList);
        }
        return false;
    }

    public PathSegment get(int i) {
        return this.mPathList.get(i);
    }

    public int hashCode() {
        return ObjectsCompat.hashCode(this.mPathList);
    }

    @Override // java.lang.Iterable
    public Iterator<PathSegment> iterator() {
        return this.mPathList.iterator();
    }

    public int size() {
        return this.mPathList.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.mPathList.size(); i++) {
            sb.append(get(i).toString());
            if (i < this.mPathList.size() - 1) {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}
