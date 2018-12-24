package me.lp.test.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api") 
public class myTestController {
    @ApiOperation(value="测试数据", notes="获取字符串1+字符串2")
    @ApiImplicitParams({
      @ApiImplicitParam(name = "s1", value = "字符串1", paramType = "form", dataType = "String"),
      @ApiImplicitParam(name = "s2", value = "字符串2", paramType = "form",required = true, dataType = "String"),
      @ApiImplicitParam(name = "Authorization",value = "验证信息",required = true,paramType = "form",dataType = "string")
    
    })
    @RequestMapping(value="/get/info", method=RequestMethod.POST)
    public String getInfo(HttpServletResponse response,HttpServletRequest request) {
        String s1 = request.getParameter("s1");
        String s2 = request.getParameter("s2");

        String result = s1+s2;
        return result;
    }
}
