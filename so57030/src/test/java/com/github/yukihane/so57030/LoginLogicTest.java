package com.github.yukihane.so57030;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import javax.sql.DataSource;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
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

    public static void cleanlyInsert(String dataPath) throws Exception {

//(LoginLogicTest.java:65)

        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File(dataPath));
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
        Connection conn = null;
        conn = dataSource().getConnection();
        IDatabaseConnection iDconn = new DatabaseConnection(conn);
        FlatDtdDataSet.write(iDconn.createDataSet(), new FileOutputStream("test.dtd"));
    }

    /**
     * 正しいUserIdとpasswordでDBからAccount情報が得られる
     */
    @Test
    public void testLoginLogic() throws Exception {

//(LoginLogicTest.java:92)  

        cleanlyInsert("src/test/resources/setup_dataset.xml");
//        :
//        :
    }
}
