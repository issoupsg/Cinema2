package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RechercheSql {
    private Connection conn;

    public RechercheSql(Connection conn) {
        this.conn = conn;
    }


}
