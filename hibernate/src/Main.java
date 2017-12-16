import Entity.CountriesEntity;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();

        }
        /*Session ses = ourSessionFactory.openSession();
        List countriesafter = null;
        List countriesbefore = null;
        try {
            ses.beginTransaction();
            countriesbefore = ses.createNativeQuery("SELECT *" +
                    "  FROM Countries\n" +
                    "INNER JOIN Continent ON Countries.Mainland = Continent.Continent").addEntity(CountriesEntity.class).list();
            ses.getTransaction().commit();
            Query queryUpdate1 = ses.createNativeQuery("UPDATE COUNTRIES SET POPULATION = 0 WHERE COUNTRY = 'Russia'");
            queryUpdate1.executeUpdate();
            Query queryUpdate2 = ses.createNativeQuery("DELETE FROM COUNTRIES WHERE COUNTIMEZONE = '-6'");
            queryUpdate2.executeUpdate();
            countriesafter = ses.createNativeQuery("SELECT *" +
                    "  FROM Countries\n" +
                    "INNER JOIN Continent ON Countries.Mainland = Continent.Continent").addEntity(CountriesEntity.class).list();
            ses.getTransaction().commit();
        }catch(Exception e){
            ses.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            ses.close();
            ourSessionFactory.close();
        }
        for (Object country : countriesbefore) {
            CountriesEntity countriesEntity = (CountriesEntity) country;
            System.out.println(countriesEntity.toString());
        }
        for (Object country : countriesafter) {
            CountriesEntity countriesEntity = (CountriesEntity) country;
            System.out.println(countriesEntity.toString());
        }*/



        StandardServiceRegistryBuilder.destroy(ourSessionFactory.getSessionFactoryOptions().getServiceRegistry());

    }
}