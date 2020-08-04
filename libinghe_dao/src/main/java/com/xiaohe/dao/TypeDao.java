package com.xiaohe.dao;

import com.xiaohe.pojo.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeDao {

    public List<Type> findAll();

}
