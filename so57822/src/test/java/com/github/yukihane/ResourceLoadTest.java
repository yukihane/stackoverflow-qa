package com.github.yukihane;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.Before;
import org.junit.Test;
import testModel.GetDataSourceLogic;

public class ResourceLoadTest {

    private GetDataSourceLogic sut;

    @Before
    public void setUp() {
        sut = new GetDataSourceLogic();
    }

    @Test
    public void test() throws IOException {
        final JdbcDataSource res = sut.getH2DataSource();
        assertNotNull(res);
    }

}
