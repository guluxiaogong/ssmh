package com.antin.service.impl;

import com.antin.dao.UserDao;
import com.antin.entity.AcctUser;
import com.antin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public AcctUser load(String id) {
        return userDao.load(id);
    }

    @Override
    public AcctUser get(String id) {
        return userDao.get(id);
    }

    @Override
    public List<AcctUser> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void persist(AcctUser entity) {
        userDao.persist(entity);
    }

    @Override
    @Transactional
    public String save(AcctUser entity) {
        return userDao.save(entity);
    }

    @Override
    @Transactional
    public void saveOrUpdate(AcctUser entity) {
        userDao.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void flush() {
        userDao.flush();
    }

}
