package com.github.yukihane.so;

import java.util.List;
import lombok.Data;

@Data
public class TestDto {

    public String jsonrpc;

    public List<Result> result;

    @Data
    public class Result {
        public String hostid;

        public String name;

        public String type;
    }

    public Integer id;
}