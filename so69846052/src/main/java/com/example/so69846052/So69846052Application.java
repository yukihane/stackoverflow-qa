package com.example.so69846052;

import java.util.Arrays;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
@RestController
@Slf4j
public class So69846052Application implements ApplicationListener<ContextRefreshedEvent> {

    @Value("#{new String[]{'${app.myvalue}'}}")
    private String[] myvalue;

    private static final String[] PATHS = new String[] { "/path1", "/path2" };
    private static final String PATH = "/path1,/path2";

    public static void main(final String[] args) {
        SpringApplication.run(So69846052Application.class, args);
    }

    @GetMapping(path = { PATHS })
    //    @GetMapping(path = "#{new String[]{'/path1','/path2'}}")
    //    @GetMapping(path = { "/path1", "/path2" })
    public String index() {
        return "" + myvalue.length + ", " + Arrays.toString(myvalue);
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        final ApplicationContext applicationContext = event.getApplicationContext();
        final RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext
            .getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
        final Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping
            .getHandlerMethods();
        map.forEach((key, value) -> log.info("{} {}", key, value));

    }

}
