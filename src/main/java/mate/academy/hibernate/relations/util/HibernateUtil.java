package mate.academy.hibernate.relations.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory instance = initSF();

    private HibernateUtil() {
    }

    private static SessionFactory initSF() {
        return new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getInstance() {
        return instance;
    }
}
