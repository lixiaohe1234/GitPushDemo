package com.xiaohe.dao;

import com.xiaohe.pojo.File;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDao {
    public List<File> findAll();
    public int deleteById(Integer id);
    public List<File> findByType( Integer id);
    public int fileAdd(File file);
    public List<File> findById(Integer type_id);
    public void fileUpdate(File file);
}
