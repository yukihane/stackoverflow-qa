package testModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.h2.jdbcx.JdbcDataSource;

public class GetDataSourceLogic {
    public JdbcDataSource getH2DataSource() throws IOException {

        final Properties props = new Properties();
        final JdbcDataSource dataSource = new JdbcDataSource();
        try (InputStream in = ClassLoader.class.getResourceAsStream("/jdbc/JdbcDataSource_H2.properties")) {
            props.load(in);
            dataSource.setURL(props.getProperty("JDBC_URL"));
            dataSource.setUser(props.getProperty("USER"));
            dataSource.setPassword(props.getProperty("PASSWORD"));

        } catch (final IOException e) {
            e.printStackTrace();
        }
        return dataSource;

    }
}
