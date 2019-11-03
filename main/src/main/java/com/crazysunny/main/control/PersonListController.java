package com.crazysunny.main.control;

import com.crazysunny.main.entity.PersonHolidyEntity;
import com.crazysunny.main.entity.UserHabitsEntity;
import com.crazysunny.main.mapper.UserHabitsMapper;
import com.crazysunny.main.service.PersonListService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.security.Security;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonListController {

    @Autowired
    PersonListService personListService;

    @ApiOperation(value = "根据条件来筛选人员数据",notes = "可以用于首页和搜索")
    //@ApiImplicitParam(name="pageIndex",value = "页签，首页时输入0",required = true,dataType = "int")
    @GetMapping(value = "/personLists/{pageIndex}")
    @ResponseBody
    public String getPersonList(@PathVariable Integer pageIndex,@RequestBody Map<String, String> conditionDic)
    {
        Subject subject = SecurityUtils.getSubject();
        Object prinicipal = subject.getPrincipal();

        String personList = personListService.getPersonListResponse(conditionDic,(String) prinicipal,pageIndex);
        return personList;
    }

//    @RequestMapping(value = "/personLists", method = RequestMethod.GET)
//    @ResponseBody
//    public String getPersonList(@RequestParam("pageIndex") int pageIndex)
//    {
//
//        return getPersonList(pageIndex,new HashMap<>());
//    }

//    @RequestMapping(value = "/personLists", method = RequestMethod.GET)
//    @ResponseBody
//    public String getPersonList()
//    {
//
//        return getPersonList(0,new HashMap<>());
//    }
}
