package com.fasterxml.jackson.core;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.fasterxml.jackson.core.io.ContentReference;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class JsonLocation implements Serializable {
    public static final JsonLocation NA = new JsonLocation(ContentReference.unknown(), -1, -1, -1, -1);
    private static final long serialVersionUID = 2;
    protected final int _columnNr;
    protected final ContentReference _contentReference;
    protected final int _lineNr;
    protected transient String _sourceDescription;
    protected final long _totalBytes;
    protected final long _totalChars;

    public JsonLocation(ContentReference contentReference, long j, long j2, int i, int i2) {
        this._contentReference = contentReference == null ? ContentReference.unknown() : contentReference;
        this._totalBytes = j;
        this._totalChars = j2;
        this._lineNr = i;
        this._columnNr = i2;
    }

    public StringBuilder appendOffsetDescription(StringBuilder sb) {
        if (this._contentReference.hasTextualContent()) {
            sb.append("line: ");
            int i = this._lineNr;
            if (i >= 0) {
                sb.append(i);
            } else {
                sb.append("UNKNOWN");
            }
            sb.append(", column: ");
            int i2 = this._columnNr;
            if (i2 >= 0) {
                sb.append(i2);
                return sb;
            }
            sb.append("UNKNOWN");
            return sb;
        }
        if (this._lineNr > 0) {
            sb.append("line: ");
            sb.append(this._lineNr);
            if (this._columnNr > 0) {
                sb.append(", column: ");
                sb.append(this._columnNr);
            }
            return sb;
        }
        sb.append("byte offset: #");
        long j = this._totalBytes;
        if (j >= 0) {
            sb.append(j);
            return sb;
        }
        sb.append("UNKNOWN");
        return sb;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JsonLocation)) {
            return false;
        }
        JsonLocation jsonLocation = (JsonLocation) obj;
        ContentReference contentReference = this._contentReference;
        ContentReference contentReference2 = jsonLocation._contentReference;
        if (contentReference == null) {
            if (contentReference2 != null) {
                return false;
            }
        } else if (!contentReference.equals(contentReference2)) {
            return false;
        }
        return this._lineNr == jsonLocation._lineNr && this._columnNr == jsonLocation._columnNr && this._totalChars == jsonLocation._totalChars && this._totalBytes == jsonLocation._totalBytes;
    }

    public int hashCode() {
        return ((((this._contentReference == null ? 1 : 2) ^ this._lineNr) + this._columnNr) ^ ((int) this._totalChars)) + ((int) this._totalBytes);
    }

    public String sourceDescription() {
        if (this._sourceDescription == null) {
            this._sourceDescription = this._contentReference.buildSourceDescription();
        }
        return this._sourceDescription;
    }

    public String toString() {
        String strSourceDescription = sourceDescription();
        StringBuilder sb = new StringBuilder(strSourceDescription.length() + 40);
        Fragment$$ExternalSyntheticOutline1.m67m(sb, "[Source: ", strSourceDescription, "; ");
        StringBuilder sbAppendOffsetDescription = appendOffsetDescription(sb);
        sbAppendOffsetDescription.append(']');
        return sbAppendOffsetDescription.toString();
    }

    public JsonLocation(ContentReference contentReference, long j, int i, int i2) {
        this(contentReference, -1L, j, i, i2);
    }
}
