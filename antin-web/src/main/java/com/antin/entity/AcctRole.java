package com.antin.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/4/18.
 */
@Entity
@Table(name = "acct_role", catalog = "ssh")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AcctRole /*implements Serializable*/ {
    //private static final long serialVersionUID = 1;
    private String id;
    private String name;

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
