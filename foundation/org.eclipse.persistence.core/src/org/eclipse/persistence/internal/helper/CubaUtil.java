package org.eclipse.persistence.internal.helper;

public class CubaUtil {

    private static ThreadLocal<Boolean> disableSoftDeleteTL = new ThreadLocal<>();
    private static ThreadLocal<Boolean> disableOriginalSoftDeleteTL = new ThreadLocal<>();

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
}
