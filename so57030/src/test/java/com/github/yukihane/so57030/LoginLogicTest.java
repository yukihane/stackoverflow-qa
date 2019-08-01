package com.github.yukihane.so57030;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoginLogicTest {
    private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
    private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;TRACE_LEVEL_FILE=4";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    //(変更後)
    public static IDataSet readDataSet(String dataPath) throws Exception {

        //(LoginLogicTest.java:33)

        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File(dataPath));

        return dataSet;
    }

    public static void cleanlyInsert(IDataSet dataSet) throws Exception {

        IDatabaseTester dbTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
        dbTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        dbTester.setDataSet(dataSet);
        dbTester.onSetup();
    }

    public static DataSource dataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(JDBC_URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    @BeforeAll
    public static void createSchema() throws Exception {
        RunScript.execute(JDBC_URL, USER, PASSWORD, "src/test/resources/schema.sql", null, false);

        //(LoginLogicTest.java:59)

        IDataSet dataset = readDataSet("src/test/resources/setup_dataset.xml");
        cleanlyInsert(dataset);
    }

    /**
     * 正しいUserIdとpasswordでDBからAccount情報が得られる
     */
    @Test
    public void testLoginLogic() throws Exception {

        DataSource ds = dataSource();
        PreparedStatement ps = ds.getConnection().prepareStatement("select name from account where userid='Shima5'");
        ResultSet rs = ps.executeQuery();
        rs.next();
        String name = rs.getString("name");
        assertEquals("Shima.I", name);
    }
}
