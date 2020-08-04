package com.xiaohe.service;

import com.xiaohe.pojo.File;

import java.util.List;

public interface FileService {

    public List<File> findAll();
    public int deleteById(Integer id);
    public List<File> findByType( Integer id);
    public int fileAdd(File file);
    public List<File> findById(Integer type_id);
    public void fileUpdate(File file);
}
