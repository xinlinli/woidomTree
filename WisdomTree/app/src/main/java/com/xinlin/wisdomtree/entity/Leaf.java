package com.xinlin.wisdomtree.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by lixinlin on 2018/2/12.
 */
@Entity
public class Leaf {
    @Id
    Long id;
    @Unique
    @Property
    String name;
    @Property
    String detail;
    @Property
    Long trunkId;
    @Generated(hash = 1088601055)
    public Leaf(Long id, String name, String detail, Long trunkId) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.trunkId = trunkId;
    }
    @Generated(hash = 1622902892)
    public Leaf() {
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
    public Long getTrunkId() {
        return this.trunkId;
    }
    public void setTrunkId(Long trunkId) {
        this.trunkId = trunkId;
    }
}
