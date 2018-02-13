package com.xinlin.wisdomtree.entity;

import com.anye.greendao.gen.DaoSession;
import com.anye.greendao.gen.TreeDao;
import com.anye.greendao.gen.TrunkDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;

/**
 * Created by lixinlin on 2018/2/12.
 */
@Entity
public class Tree {
    @Id
    Long id;
    @Unique
    @Property
    String name;
    @Property
    String detail;
    @Property
    Long forestId;//标明tree所属forest；
    @ToMany(referencedJoinProperty = "treeId")
    List<Trunk> trees;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 948839816)
    private transient TreeDao myDao;

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
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1128962199)
    public List<Trunk> getTrees() {
        if (trees == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TrunkDao targetDao = daoSession.getTrunkDao();
            List<Trunk> treesNew = targetDao._queryTree_Trees(id);
            synchronized (this) {
                if (trees == null) {
                    trees = treesNew;
                }
            }
        }
        return trees;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1311440767)
    public synchronized void resetTrees() {
        trees = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1935359770)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTreeDao() : null;
    }
}
