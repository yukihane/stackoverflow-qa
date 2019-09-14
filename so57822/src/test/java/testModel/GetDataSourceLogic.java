package testModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.h2.jdbcx.JdbcDataSource;

public class GetDataSourceLogic {
    public JdbcDataSource getH2DataSource() throws IOException {

        try (InputStream in = GetDataSourceLogic.class.getResourceAsStream("/jdbc/JdbcDataSource_H2.properties")) {
            final Properties props = new Properties();
            props.load(in);
            final JdbcDataSource dataSource = new JdbcDataSource();
            dataSource.setURL(props.getProperty("JDBC_URL"));
            dataSource.setUser(props.getProperty("USER"));
            dataSource.setPassword(props.getProperty("PASSWORD"));
            return dataSource;
        }

    }
}
