package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JDKValueInstantiators {

    public static class ArrayListInstantiator extends JDKValueInstantiator {
        static final ArrayListInstantiator INSTANCE = new ArrayListInstantiator();
        private static final long serialVersionUID = 2;

        public ArrayListInstantiator() {
            super(ArrayList.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new ArrayList();
        }
    }

    public static class ConcurrentHashMapInstantiator extends JDKValueInstantiator {
        private static final long serialVersionUID = 2;

        public ConcurrentHashMapInstantiator() {
            super(ConcurrentHashMap.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new ConcurrentHashMap();
        }
    }

    public static class ConstantValueInstantiator extends JDKValueInstantiator {
        private static final long serialVersionUID = 2;
        protected final Object _value;

        public ConstantValueInstantiator(Object obj) {
            super(obj.getClass());
            this._value = obj;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final Object createUsingDefault(DeserializationContext deserializationContext) {
            return this._value;
        }
    }

    public static class HashMapInstantiator extends JDKValueInstantiator {
        static final HashMapInstantiator INSTANCE = new HashMapInstantiator();
        private static final long serialVersionUID = 2;

        public HashMapInstantiator() {
            super(HashMap.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new HashMap();
        }
    }

    public static class HashSetInstantiator extends JDKValueInstantiator {
        static final HashSetInstantiator INSTANCE = new HashSetInstantiator();
        private static final long serialVersionUID = 2;

        public HashSetInstantiator() {
            super(HashSet.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new HashSet();
        }
    }

    public static abstract class JDKValueInstantiator extends ValueInstantiator.Base implements Serializable {
        private static final long serialVersionUID = 2;

        public JDKValueInstantiator(Class<?> cls) {
            super(cls);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final boolean canCreateUsingDefault() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final boolean canInstantiate() {
            return true;
        }
    }

    public static class LinkedHashMapInstantiator extends JDKValueInstantiator {
        static final LinkedHashMapInstantiator INSTANCE = new LinkedHashMapInstantiator();
        private static final long serialVersionUID = 2;

        public LinkedHashMapInstantiator() {
            super(LinkedHashMap.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new LinkedHashMap();
        }
    }

    public static class LinkedHashSetInstantiator extends JDKValueInstantiator {
        private static final long serialVersionUID = 2;

        public LinkedHashSetInstantiator() {
            super(LinkedHashSet.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new LinkedHashSet();
        }
    }

    public static class LinkedListInstantiator extends JDKValueInstantiator {
        private static final long serialVersionUID = 2;

        public LinkedListInstantiator() {
            super(LinkedList.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new LinkedList();
        }
    }

    public static class PropertiesInstantiator extends JDKValueInstantiator {
        private static final long serialVersionUID = 2;

        public PropertiesInstantiator() {
            super(Properties.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new Properties();
        }
    }

    public static class TreeMapInstantiator extends JDKValueInstantiator {
        private static final long serialVersionUID = 2;

        public TreeMapInstantiator() {
            super(TreeMap.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new TreeMap();
        }
    }

    public static class TreeSetInstantiator extends JDKValueInstantiator {
        private static final long serialVersionUID = 2;

        public TreeSetInstantiator() {
            super(TreeSet.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public Object createUsingDefault(DeserializationContext deserializationContext) {
            return new TreeSet();
        }
    }

    public static ValueInstantiator findStdValueInstantiator(DeserializationConfig deserializationConfig, Class<?> cls) {
        if (cls == JsonLocation.class) {
            return new JsonLocationInstantiator();
        }
        if (!Collection.class.isAssignableFrom(cls)) {
            if (!Map.class.isAssignableFrom(cls)) {
                return null;
            }
            if (cls == LinkedHashMap.class) {
                return LinkedHashMapInstantiator.INSTANCE;
            }
            if (cls == HashMap.class) {
                return HashMapInstantiator.INSTANCE;
            }
            if (cls == ConcurrentHashMap.class) {
                return new ConcurrentHashMapInstantiator();
            }
            if (cls == TreeMap.class) {
                return new TreeMapInstantiator();
            }
            if (Properties.class.isAssignableFrom(cls)) {
                return new PropertiesInstantiator();
            }
            Map map = Collections.EMPTY_MAP;
            if (cls == map.getClass()) {
                return new ConstantValueInstantiator(map);
            }
            return null;
        }
        if (cls == ArrayList.class) {
            return ArrayListInstantiator.INSTANCE;
        }
        if (cls == HashSet.class) {
            return HashSetInstantiator.INSTANCE;
        }
        if (cls == LinkedList.class) {
            return new LinkedListInstantiator();
        }
        if (cls == TreeSet.class) {
            return new TreeSetInstantiator();
        }
        if (cls == LinkedHashSet.class) {
            return new LinkedHashSetInstantiator();
        }
        Set set = Collections.EMPTY_SET;
        if (cls == set.getClass()) {
            return new ConstantValueInstantiator(set);
        }
        List list = Collections.EMPTY_LIST;
        if (cls == list.getClass()) {
            return new ConstantValueInstantiator(list);
        }
        return null;
    }
}
