package com.crazysunny.main.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/person")
public class PersonMainController {


    @RequestMapping("/personList")
    @ResponseBody
     public String GetPersonList()
     {
        return "personList";
     }
}
