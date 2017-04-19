package com.antin.service;

import com.antin.entity.AcctUser;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
public interface UserService {
    AcctUser load(String id);

    AcctUser get(String id);

    List<AcctUser> findAll();

    void persist(AcctUser entity);

    String save(AcctUser entity);

    void saveOrUpdate(AcctUser entity);

    void delete(String id);

    void flush();
}
