package org.cloud.route;

import javax.servlet.http.HttpServletRequest;

import org.cloud.dao.ContactDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
public class ContactController {
    @Autowired
    private ContactDAO dao;

    public ContactDAO getDao() {
        return dao;
    }

    public void setDao(ContactDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/api/persons", produces = {"application/json;charset=UTF-8"})
    public
    @ResponseBody
    String execute(HttpServletRequest req) {
        String result = JSON.toJSONString((dao.findAll()));
        System.out.println("success");
        return result;
    }
}
