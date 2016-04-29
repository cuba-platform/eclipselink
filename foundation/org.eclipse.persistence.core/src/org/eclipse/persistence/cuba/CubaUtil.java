package org.eclipse.persistence.cuba;

import org.eclipse.persistence.internal.sessions.AbstractSession;
import org.eclipse.persistence.sessions.UnitOfWork;
import org.eclipse.persistence.sessions.server.ServerSession;

public class CubaUtil {

    public static final String DISABLE_SOFT_DELETE = "cuba.disableSoftDelete";

    private static ThreadLocal<Boolean> disableSoftDeleteTL = new ThreadLocal<>();

    public static Object beginDisableSoftDelete(AbstractSession session) {
        AbstractSession clientSession = (session instanceof UnitOfWork) ? session.getParent() : session;
        Object property = clientSession.getProperty(DISABLE_SOFT_DELETE);
        clientSession.setProperty(DISABLE_SOFT_DELETE, true);
        disableSoftDeleteTL.set(true);
        return property;
    }

    public static void endDisableSoftDelete(AbstractSession session, Object property) {
        AbstractSession clientSession = (session instanceof UnitOfWork) ? session.getParent() : session;
        if (property != null)
            clientSession.setProperty(DISABLE_SOFT_DELETE, property);
        else
            clientSession.removeProperty(DISABLE_SOFT_DELETE);
        disableSoftDeleteTL.remove();
    }

    public static boolean isSoftDeleteDisabled(AbstractSession session) {
        if (session instanceof ServerSession) {
            return Boolean.TRUE.equals(disableSoftDeleteTL.get());
        } else {
            return Boolean.TRUE.equals(session.getProperty(DISABLE_SOFT_DELETE));
        }
    }
}
