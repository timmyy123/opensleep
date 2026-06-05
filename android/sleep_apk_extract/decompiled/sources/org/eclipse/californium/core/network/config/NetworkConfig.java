package org.eclipse.californium.core.network.config;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class NetworkConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) NetworkConfig.class);
    private static NetworkConfig standard;
    private List<Object> observers = new LinkedList();
    private Properties properties = new Properties();

    public interface PropertyParser<T> {
        String getTypeName();

        T parseValue(String str);
    }

    public NetworkConfig() {
        NetworkConfigDefaults.setDefaults(this);
    }

    public static NetworkConfig createStandardWithFile(File file) {
        NetworkConfig networkConfigCreateWithFile = createWithFile(file, "Californium CoAP Properties file", null);
        standard = networkConfigCreateWithFile;
        return networkConfigCreateWithFile;
    }

    public static NetworkConfig createStandardWithoutFile() {
        LOGGER.info("Creating standard network configuration properties without a file");
        NetworkConfig networkConfig = new NetworkConfig();
        standard = networkConfig;
        return networkConfig;
    }

    public static NetworkConfig createWithFile(File file, String str, NetworkConfigDefaultHandler networkConfigDefaultHandler) {
        NetworkConfig networkConfig = new NetworkConfig();
        if (networkConfigDefaultHandler != null) {
            networkConfigDefaultHandler.applyDefaults(networkConfig);
        }
        if (file.exists()) {
            networkConfig.load(file);
            return networkConfig;
        }
        networkConfig.store(file, str);
        return networkConfig;
    }

    private <T> T getNumberValue(PropertyParser<T> propertyParser, String str, T t) {
        String property = this.properties.getProperty(str);
        if (property == null) {
            LOGGER.debug("key [{}] is undefined, returning default value", str);
        } else if (property.isEmpty()) {
            LOGGER.debug("key [{}] is empty, returning default value", str);
        }
        try {
            return propertyParser.parseValue(property);
        } catch (NumberFormatException unused) {
            LOGGER.warn("value for key [{}] is not a {}, returning default value", str, propertyParser.getTypeName());
            return t;
        }
    }

    public static NetworkConfig getStandard() {
        synchronized (NetworkConfig.class) {
            try {
                if (standard == null) {
                    createStandardWithFile(new File("Californium.properties"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return standard;
    }

    public boolean getBoolean(String str) {
        String property = this.properties.getProperty(str);
        if (property != null) {
            return Boolean.parseBoolean(property);
        }
        LOGGER.warn("Key [{}] is undefined", str);
        return false;
    }

    public float getFloat(String str, float f) {
        return ((Float) getNumberValue(new PropertyParser<Float>() { // from class: org.eclipse.californium.core.network.config.NetworkConfig.5
            @Override // org.eclipse.californium.core.network.config.NetworkConfig.PropertyParser
            public String getTypeName() {
                return "float";
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.eclipse.californium.core.network.config.NetworkConfig.PropertyParser
            public Float parseValue(String str2) {
                return Float.valueOf(Float.parseFloat(str2));
            }
        }, str, Float.valueOf(f))).floatValue();
    }

    public int getInt(String str, int i) {
        return ((Integer) getNumberValue(new PropertyParser<Integer>() { // from class: org.eclipse.californium.core.network.config.NetworkConfig.3
            @Override // org.eclipse.californium.core.network.config.NetworkConfig.PropertyParser
            public String getTypeName() {
                return "int";
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.eclipse.californium.core.network.config.NetworkConfig.PropertyParser
            public Integer parseValue(String str2) {
                return Integer.valueOf(Integer.parseInt(str2));
            }
        }, str, Integer.valueOf(i))).intValue();
    }

    public long getLong(String str, long j) {
        return ((Long) getNumberValue(new PropertyParser<Long>() { // from class: org.eclipse.californium.core.network.config.NetworkConfig.4
            @Override // org.eclipse.californium.core.network.config.NetworkConfig.PropertyParser
            public String getTypeName() {
                return "long";
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.eclipse.californium.core.network.config.NetworkConfig.PropertyParser
            public Long parseValue(String str2) {
                return Long.valueOf(Long.parseLong(str2));
            }
        }, str, Long.valueOf(j))).longValue();
    }

    public String getString(String str, String str2) {
        String property = this.properties.getProperty(str);
        return property != null ? property : str2;
    }

    public void load(File file) {
        if (file == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("file must not be null");
            return;
        }
        LOGGER.info("loading properties from file {}", file.getAbsolutePath());
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                load(fileInputStream);
                fileInputStream.close();
            } finally {
            }
        } catch (IOException e) {
            LOGGER.warn("cannot load properties from file {}: {}", file.getAbsolutePath(), e.getMessage());
        }
    }

    public NetworkConfig set(String str, Object obj) {
        if (str == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("key must not be null");
            return null;
        }
        if (obj == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("value must not be null");
            return null;
        }
        this.properties.put(str, String.valueOf(obj));
        Iterator<Object> it = this.observers.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
        return this;
    }

    public NetworkConfig setBoolean(String str, boolean z) {
        return set(str, String.valueOf(z));
    }

    public NetworkConfig setFloat(String str, float f) {
        return set(str, String.valueOf(f));
    }

    public NetworkConfig setInt(String str, int i) {
        return set(str, String.valueOf(i));
    }

    public NetworkConfig setLong(String str, long j) {
        return set(str, String.valueOf(j));
    }

    public NetworkConfig setString(String str, String str2) {
        return set(str, str2);
    }

    public void store(File file, String str) {
        if (file == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("file must not be null");
            return;
        }
        LOGGER.info("writing properties to file {}", file.getAbsolutePath());
        try {
            FileWriter fileWriter = new FileWriter(file);
            try {
                this.properties.store(fileWriter, str);
                fileWriter.close();
            } finally {
            }
        } catch (IOException e) {
            LOGGER.warn("cannot write properties to file {}: {}", file.getAbsolutePath(), e.getMessage());
        }
    }

    public String getString(String str) {
        return this.properties.getProperty(str);
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public long getLong(String str) {
        return getLong(str, 0L);
    }

    public boolean getBoolean(String str, boolean z) {
        String property = this.properties.getProperty(str);
        if (property != null) {
            return Boolean.parseBoolean(property);
        }
        LOGGER.warn("Key [{}] is undefined, returning defaultValue", str);
        return z;
    }

    public void load(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            this.properties.load(inputStream);
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("input stream must not be null");
        }
    }
}
