package kata6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;

public class Kata6 {

    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String username = "system";
        String password = "orcl";
        //String url = "jdbc:oracle:thin:@" + "10.22.46.229:1521:orcl"; //desde otro equipo en la red
        String url = "jdbc:oracle:thin:@" + "localhost:101:orcl"; //y redirigir el puerto el 101 al 1521
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("select * from CAMBIO_EUR_A");
        while (set.next()){
            print(set);
        }
        
    }

    private static void print(ResultSet set) throws SQLException {
        System.out.print(set.getString("DIVISA") + " ");
        System.out.println(set.getBigDecimal("CAMBIO"));
    }
}
