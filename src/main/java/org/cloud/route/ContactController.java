package org.cloud.route;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import org.cloud.dao.ContactDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import java.util.List;

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

    @RequestMapping(value = "/api/contacts", produces = {"application/json;charset=UTF-8"})
    public
    @ResponseBody
    String execute(HttpServletRequest req) {
        JSONObject obj = new JSONObject();
        List list = dao.findAll();
        obj.put("count", list.size());
        obj.put("list", list);
        String result = JSON.toJSONString(obj);
        System.out.println("success");
        return result;
    }
}
