//Старый хэндлер, не используется
package AutoPartsStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends ConfigDB {
    Connection dbConnection;

    public Connection dbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void newDetail (String name, String price)
    {
        String insert = "INSERT " + Const.USER_TABLE + "(" + Const.USER_NAMEDETAIL + "," + Const.USER_PRICEDETAIL + ")" +
                "VALUES(?,?)";

        try {
            PreparedStatement prSt = dbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, price);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
