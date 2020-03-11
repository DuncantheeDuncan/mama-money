package node;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.testng.AssertJUnit.assertEquals;

public class PrintTreeUsingJDBCTests {

    Connection connection;

    @BeforeEach
    public void setUp() throws SQLException, ClassNotFoundException {
        PrintTreeUsingJDBC jdbcNodes = new PrintTreeUsingJDBC();
        connection = DriverManager.getConnection("jdbc:h2:./target/jdbc_addingnodes", "sa", "");
        Statement statement = connection.createStatement();
        statement.addBatch("delete from NodesDB");
        statement.executeBatch();
    }

    @Test
    public void shouldAdd() throws SQLException, ClassNotFoundException {

        PrintTreeUsingJDBC add = new PrintTreeUsingJDBC();
//        add.addNodes(2, "phila", 5);

        assertEquals("K", "k");
    }
}
