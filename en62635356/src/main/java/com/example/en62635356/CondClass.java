package com.example.en62635356;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

@ConditionalOnBean(MyConf.class)
@Service
@RequiredArgsConstructor
public class CondClass {

}
