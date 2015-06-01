package org.cloud.route;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.cloud.dao.NoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class NoteController {
    @Autowired
    private NoteDAO dao;

    public NoteDAO getDao() {
        return dao;
    }

    public void setDao(NoteDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/api/notes", produces = {"application/json;charset=UTF-8"})
    public
    @ResponseBody
    String calls(HttpServletRequest req) {
        JSONObject obj = new JSONObject();
        List list = dao.findAll();
        obj.put("count", list.size());
        obj.put("list", list);
        String result = JSON.toJSONString(obj);
        System.out.println("success");
        return result;
    }

    @RequestMapping(value = "/api/note/delete", produces = {"application/json;charset=UTF-8"})
    public
    @ResponseBody
    String delete(HttpServletRequest req) {
        JSONObject obj = new JSONObject();
        List list = dao.findAll();
        obj.put("count", list.size());
        obj.put("list", list);
        String result = JSON.toJSONString(obj);
        System.out.println("success");
        return result;
    }

}
