package indi.eiriksgata.rulatedayapi.controller;

import indi.eiriksgata.rulateday.mapper.Dnd5ePhbDataMapper;
import indi.eiriksgata.rulatedayapi.vo.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: create by Keith
 * version: v1.0
 * description: indi.eiriksgata.rulatedayapi.controller
 * date: 2021/5/12
 **/
@RestController
@Api(tags = "查询控制器")
public class QueryController {

    @Autowired
    Dnd5ePhbDataMapper dnd5ePhbDataMapper;

    @PostMapping("/dnd5e/spell")
    @ApiOperation(value = "dnd5e法术列表", httpMethod = "POST")
    public ResponseBean dnd5eLibQuery() {
        return ResponseBean.success(dnd5ePhbDataMapper.selectAllSkillPhb());
    }


}
