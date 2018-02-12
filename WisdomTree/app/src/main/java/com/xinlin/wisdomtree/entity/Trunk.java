package com.xinlin.wisdomtree.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lixinlin on 2018/2/12.
 */
@Entity
public class Trunk {
    @Id
    Long id;
    @Property
    String name;
    @Property
    String detail;
    @Property
    Long treeId;
    @Generated(hash = 1474134355)
    public Trunk(Long id, String name, String detail, Long treeId) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.treeId = treeId;
    }
    @Generated(hash = 171164349)
    public Trunk() {
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
    public Long getTreeId() {
        return this.treeId;
    }
    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }
}
