package com.xinlin.wisdomtree.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lixinlin on 2018/2/12.
 */
@Entity
public class Tree {
    @Id
    Long id;
    @Property
    String name;
    @Property
    String detail;
    @Property
    Long forestId;//标明tree所属forest；
    @Generated(hash = 1755920563)
    public Tree(Long id, String name, String detail, Long forestId) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.forestId = forestId;
    }
    @Generated(hash = 439989092)
    public Tree() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDetail() {
        return this.detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public Long getForestId() {
        return this.forestId;
    }
    public void setForestId(Long forestId) {
        this.forestId = forestId;
    }
}
