package org.eclipse.persistence.internal.helper;

import java.util.HashMap;
import java.util.Map;

public class CubaUtil {

    private static ThreadLocal<Boolean> disableSoftDeleteTL = new ThreadLocal<>();
    private static ThreadLocal<Boolean> disableOriginalSoftDeleteTL = new ThreadLocal<>();
    private static ThreadLocal<Boolean> disableJPQLParseCacheTL = new ThreadLocal<>();

    /**
     * Stores important additional properties such as "tenantId"
     */
    private static ThreadLocal<Map<String, Object>> propertiesTL = new ThreadLocal<>();

    public static boolean setSoftDeletion(boolean softDeletion) {
        Boolean previous = disableSoftDeleteTL.get();
        disableSoftDeleteTL.set(!softDeletion);
        return !Boolean.TRUE.equals(previous);
    }

    public static boolean isSoftDeletion() {
        return !Boolean.TRUE.equals(disableSoftDeleteTL.get());
    }

    public static boolean setOriginalSoftDeletion(boolean softDeletion) {
        Boolean previous = disableOriginalSoftDeleteTL.get();
        disableOriginalSoftDeleteTL.set(!softDeletion);
        return !Boolean.TRUE.equals(previous);
    }

    public static boolean isOriginalSoftDeletion() {
        return !Boolean.TRUE.equals(disableOriginalSoftDeleteTL.get());
    }

    public static boolean setEnabledJPQLParseCache(boolean enabled) {
        Boolean previous = disableJPQLParseCacheTL.get();
        disableJPQLParseCacheTL.set(!enabled);
        return !Boolean.TRUE.equals(previous);
    }

    public static boolean isEnabledJPQLParseCache() {
        return !Boolean.TRUE.equals(disableJPQLParseCacheTL.get());
    }

    public static void putProperty(String key, Object value) {
        checkProperties();
        propertiesTL.get().put(key, value);
    }

    public static Object getProperty(String key) {
        checkProperties();
        return propertiesTL.get().get(key);
    }

    public static Map<String,Object> getProperties() {
        checkProperties();
        return propertiesTL.get();
    }

    public static void setProperties(Map<String,Object> properties){
        checkProperties();
        propertiesTL.set(properties);
    }

    public static boolean hasProperties(){
        return !getProperties().isEmpty();
    }

    public static boolean containsProperty(String key) {
        checkProperties();
        return propertiesTL.get().containsKey(key);
    }

    public static void clearProperties() {
        propertiesTL.remove();
    }

    private static void checkProperties() {
        if (propertiesTL.get() == null) {
            propertiesTL.set(new HashMap<>());
        }
    }
}
