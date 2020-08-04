package com.xiaohe.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaohe.pojo.File;
import com.xiaohe.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService fileService;
//    @RequestMapping("findAll")
//    public ModelAndView findAll(){
//        List<File> files = fileService.findAll();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("files",files);
//        System.out.println(files.get(0).getFile_name());
//        modelAndView.setViewName("/list.jsp");
//        return modelAndView;
//    }

    @RequestMapping("findAll")
    public Map findAll(Integer page, Integer limit){
        PageHelper.startPage(page,limit);
        List<File> files = fileService.findAll();
        PageInfo<File> pageInfo = new PageInfo<>(files);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",(Object)pageInfo.getList());
        return map;
    }
    @RequestMapping("deleteById")
    public void deleteById( String  id , HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        String[] strs = id.split(",");
        for (int i = 0; i <strs.length ; i++) {
            int id1 = Integer.parseInt(strs[i]);
            System.out.println(id1);
            int count = fileService.deleteById(id1);
        }
       response.sendRedirect("/indext.html");
    }
    @RequestMapping("findByType")
    public ModelAndView findByType(String  id){
        int id1 = Integer.parseInt(id);
        System.out.println(id1);

        List<File> files = fileService.findByType(id1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("files",files);
        modelAndView.setViewName("/list.jsp");
        return modelAndView;
    }

    @RequestMapping("fileAdd")
    public void fileAdd( File file,HttpServletRequest request,HttpServletResponse response){
        System.out.println(file);
        Date date = new Date();
        file.setUpload_date(date);
        int i = fileService.fileAdd(file);
        System.out.println(i);
        try {
            response.sendRedirect(request.getContextPath()+"/indext.html");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @RequestMapping("findById")
    public Map findById(String type_id,Integer page, Integer limit ,HttpServletRequest request, HttpServletResponse response){
        System.out.println(type_id);
        if(type_id.equals("")){
            try {
                response.sendRedirect(request.getContextPath()+"/indext.html");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        int i = Integer.parseInt(type_id);

        PageHelper.startPage(page,limit);
        HashMap<String, Object> map = new HashMap<>();
        List<File> files = fileService.findById(i);
        PageInfo<File> pageInfo = new PageInfo<>(files);
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",(Object)pageInfo.getList());
        return map;
    }

    @RequestMapping("fileUpdate")
    public void fileUpdate(File file){
//        file.setUpload_date(new Date());
        System.out.println(file);
        fileService.fileUpdate(file);
    }
}
