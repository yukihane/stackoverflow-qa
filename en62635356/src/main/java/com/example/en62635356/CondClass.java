package com.example.en62635356;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Service;

@ConditionalOnClass(MyConf.class)
@ConditionalOnBean(MyConf.class)
@Service
@RequiredArgsConstructor
public class CondClass {

}
