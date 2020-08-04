package com.xiaohe.service.impl;

import com.xiaohe.dao.TypeDao;
import com.xiaohe.pojo.Type;
import com.xiaohe.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDao typeDao;

    public List<Type> findAll() {
        return typeDao.findAll();
    }
}
