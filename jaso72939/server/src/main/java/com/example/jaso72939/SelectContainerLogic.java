package com.example.jaso72939;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/sample/json3")
public class SelectContainerLogic {

    @RequestMapping(value = "/testGetData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String testGetData(@RequestParam final String tantousya_id, @RequestParam final String simei) {
        return "{\"result\": \"ok\"}";
    }

}