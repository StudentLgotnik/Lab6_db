import Entity.CountriesEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Inquiries {
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


    public static void main(String[] args) {
        Session ses = ourSessionFactory.openSession();
        List countriesbefore = null;
        List countriesafter = null;
        try {
            ses.beginTransaction();

            countriesbefore = ses.createNativeQuery("SELECT *" +
                    "  FROM Countries\n" +
                    "INNER JOIN Continent ON Countries.Mainland = Continent.Continent").addEntity(CountriesEntity.class).list();
            //ses.getTransaction().commit();

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
        System.out.println();
        for (Object country : countriesafter) {
            CountriesEntity countriesEntity = (CountriesEntity) country;
            System.out.println(countriesEntity.toString());
        }
        StandardServiceRegistryBuilder.destroy(ourSessionFactory.getSessionFactoryOptions().getServiceRegistry());


    }
}
