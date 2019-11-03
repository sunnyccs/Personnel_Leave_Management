package com.crazysunny.main.control;

import com.crazysunny.main.message.BaseMessage;
import com.crazysunny.main.service.PersonMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonMainController {

    @Autowired
    private PersonMainService personMainService;

//    @RequestMapping("/personList")
//    @ResponseBody
//     public String GetPersonList(@RequestParam("pageIndex") int pageIndex,@RequestBody Map<String,Object> selectParam) //,@RequestParam("pageIndex") int pageIndex
//     {
//         BaseMessage baseMessage = personMainService.GetMainResponseData(selectParam,pageIndex);
//         return baseMessage.GetMessageJson();
//     }


     @GetMapping("/getSinglePerson")
     @ResponseBody
     public String GetPersonInfoByID(@RequestParam("personID") int personID)
     {
        BaseMessage baseMessage = personMainService.GetPersonInfoByID(personID);
        return baseMessage.GetMessageJson();
     }

}
