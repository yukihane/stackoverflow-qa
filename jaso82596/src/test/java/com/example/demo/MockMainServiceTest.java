package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//直接依存するクラスをMock化するテスト
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockMainServiceTest {

    @Autowired
    MainService mainService;

    @MockBean
    SubSubMainService subSubMainService;

    @Test
    public void サブクラスをMock化() {
        doReturn("SubSubMainServiceはMock化されたよ").when(subSubMainService).subSubSayHello();
        Assert.assertThat(mainService.mainSayHello(),
            is("MainSayHello. Also...SubSayHello. Also...SubSubMainServiceはMock化されたよ"));
    }
}
