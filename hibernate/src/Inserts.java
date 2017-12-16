
import Entity.*;
import com.sun.jndi.cosnaming.IiopUrl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class Inserts {

    public static void main(String[] args) {
        insetList();
        for (CapitalEntity cap : CapitalEntity.capitals){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.save(cap);
            if (trans.getStatus().equals(TransactionStatus.ACTIVE)) {
                trans.commit();
            }
            //session.getTransaction().commit();
        }
        for (CountriesEntity coun : CountriesEntity.countries){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.save(coun);
            if (trans.getStatus().equals(TransactionStatus.ACTIVE)) {
                trans.commit();
            }
            //session.getTransaction().commit();
        }
        for (ContinentEntity cont : ContinentEntity.continents){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.save(cont);
            if (trans.getStatus().equals(TransactionStatus.ACTIVE)) {
                trans.commit();
            }
            //session.getTransaction().commit();
        }
        for (TimezoneEntity time : TimezoneEntity.timezones){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.save(time);
            if (trans.getStatus().equals(TransactionStatus.ACTIVE)) {
                trans.commit();
            }
            //session.getTransaction().commit();
        }
        for (CountriesemployerEntity coun : CountriesemployerEntity.countriesemployers){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction trans = session.beginTransaction();
            session.save(coun);
            if (trans.getStatus().equals(TransactionStatus.ACTIVE)) {
                trans.commit();
            }
            //session.getTransaction().commit();
        }
        HibernateUtil.shutdown();




    }
    public static void insetList(){
        CapitalEntity capitalEntity = new CapitalEntity("Kiev","Clichko", (long) 2928000);
        CapitalEntity capitalEntity1 = new CapitalEntity("Moscow","Sobyanin", (long)12228000);
        CapitalEntity capitalEntity2 = new CapitalEntity("Minsk","Shorets", (long)1921000);
        CapitalEntity capitalEntity3 = new CapitalEntity("Athens","Kaminis", (long)666000);
        CapitalEntity capitalEntity4 = new CapitalEntity("Washington","Inslee", (long)7288000);
        CapitalEntity capitalEntity5 = new CapitalEntity("Ottawa","Watson", (long)934000);
        CountriesEntity countriesEntity = new CountriesEntity("Ukraine", "Eurasia", (long)48457000, "Kiev", "+2");
        CountriesEntity countriesEntity1 = new CountriesEntity("Russia", "Eurasia", (long)146804000, "Moscow", "+3");
        CountriesEntity countriesEntity2 = new CountriesEntity("Belarus", "Eurasia", (long)9505000, "Minsk", "+3");
        CountriesEntity countriesEntity3 = new CountriesEntity("Greece", "Eurasia", (long)11300000, "Athens", "+2");
        CountriesEntity countriesEntity4 = new CountriesEntity("USA", "NorthAmerica", (long)325000000, "Washington", "-6");
        CountriesEntity countriesEntity5 = new CountriesEntity("Canada", "NorthAmerica", (long)36048000, "Ottawa", "-6");
        ContinentEntity continentEntity = new ContinentEntity("Eurasia","Subtropical");
        ContinentEntity continentEntity1 = new ContinentEntity("NorthAmerica","Tropical");
        TimezoneEntity timezoneEntity = new TimezoneEntity("+2","Pres-al respublic");
        TimezoneEntity timezoneEntity1 = new TimezoneEntity("+3","Respublic");
        TimezoneEntity timezoneEntity2 = new TimezoneEntity("-6","Parl-ry republic");
        CountriesemployerEntity countriesemployerEntity = new CountriesemployerEntity("Ukraine","15.7%");
        CountriesemployerEntity countriesemployerEntity1 = new CountriesemployerEntity("Russia","19.4%");
        CountriesemployerEntity countriesemployerEntity2 = new CountriesemployerEntity("Belarus","13.2%");
        CountriesemployerEntity countriesemployerEntity3 = new CountriesemployerEntity("Greece","15.3%");
        CountriesemployerEntity countriesemployerEntity4 = new CountriesemployerEntity("USA","9.9%");
        CountriesemployerEntity countriesemployerEntity5 = new CountriesemployerEntity("Canada","11.1%");
    }
}
