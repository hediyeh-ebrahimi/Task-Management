package common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAProvider {
    private static final EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
