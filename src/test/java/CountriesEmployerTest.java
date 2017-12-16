import Entity.ContinentEntity;
import Entity.CountriesemployerEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import Entity.CapitalEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountriesEmployerTest {

    @BeforeAll
    static void befote(){
        Inserts.insetList();
    }
    @Test
    void Test1() throws ClassNotFoundException, SQLException {
        Connection connection = Connections.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet rset = statement.executeQuery("select * from COUNTRIESEMPLOYER");
            int i = 0;
            while (rset.next()){
                CountriesemployerEntity real = new CountriesemployerEntity(rset.getString(1),
                        rset.getString(2));
                CountriesemployerEntity expected = CountriesemployerEntity.countriesemployers.get(i);
                i++;
                assertEquals(expected, real);

            }
            rset.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connections.closeCon(connection);
    }
}
