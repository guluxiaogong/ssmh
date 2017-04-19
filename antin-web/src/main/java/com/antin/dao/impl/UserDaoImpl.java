package com.antin.dao.impl;

import com.antin.dao.UserDao;
import com.antin.entity.AcctUser;
import com.antin.entity.UserModel;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private SqlSession getSqlSession() {
        return this.sqlSessionFactory.openSession();
    }

    @Override
    public AcctUser load(String id) {
        return (AcctUser) this.getCurrentSession().load(AcctUser.class, id);
    }

    @Override
    public AcctUser get(String id) {
        return (AcctUser) this.getCurrentSession().get(AcctUser.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AcctUser> findAll() {

        List<AcctUser> acctUsers = this.getCurrentSession().createQuery("from AcctUser").setCacheable(true).list();

        List<UserModel> list = getSqlSession().selectList("selectAll");
        for (UserModel um : list)
            System.out.println("=======================" + um);

        return acctUsers;
    }

    @Override
    public void persist(AcctUser entity) {
        this.getCurrentSession().persist(entity);

    }

    @Override
    public String save(AcctUser entity) {
        return (String) this.getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(AcctUser entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(String id) {
        AcctUser entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    @Override
    public void flush() {
        this.getCurrentSession().flush();

    }

}
