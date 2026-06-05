package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JsonNode extends JsonSerializable.Base implements TreeNode, Iterable<JsonNode> {
    public abstract String asText();

    public Iterator<JsonNode> elements() {
        return ClassUtil.emptyIterator();
    }

    public Iterator<String> fieldNames() {
        return ClassUtil.emptyIterator();
    }

    public abstract JsonNode get(String str);

    public abstract JsonNodeType getNodeType();

    public boolean isArray() {
        return false;
    }

    public final boolean isNull() {
        return getNodeType() == JsonNodeType.NULL;
    }

    @Override // java.lang.Iterable
    public final Iterator<JsonNode> iterator() {
        return elements();
    }

    public abstract JsonNode path(String str);

    public Set<Map.Entry<String, JsonNode>> properties() {
        return Collections.EMPTY_SET;
    }

    public int size() {
        return 0;
    }

    public String textValue() {
        return null;
    }
}
