package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//直接依存するクラスをMock化するテスト
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockMainServiceTest {

    @InjectMocks
    MainServiceImpl mainService;

    @Mock
    SubMainService subMainService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void サブクラスをMock化() {
        doReturn("SubMainServiceはMock化されたよ").when(subMainService).subSayHello();
        Assert.assertThat(mainService.mainSayHello(), is("MainSayHello. Also...SubMainServiceはMock化されたよ"));
    }
}