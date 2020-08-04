package com.xiaohe.service.impl;

import com.xiaohe.dao.FileDao;
import com.xiaohe.pojo.File;
import com.xiaohe.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;
    public List<File> findAll() {
        return fileDao.findAll();
    }

    public int deleteById(Integer id) {
        return fileDao.deleteById(id);
    }

    public List<File> findByType(Integer id) {
        return fileDao.findByType(id);
    }

    public int fileAdd(File file) {
        return fileDao.fileAdd(file);
    }

    public List<File> findById(Integer type_id) {
        return fileDao.findById(type_id);
    }


    public void fileUpdate(File file ){
        fileDao.fileUpdate(file);
    }
}
