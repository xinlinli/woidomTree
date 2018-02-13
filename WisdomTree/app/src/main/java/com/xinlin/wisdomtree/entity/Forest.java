package com.xinlin.wisdomtree.entity;

import com.anye.greendao.gen.DaoSession;
import com.anye.greendao.gen.ForestDao;
import com.anye.greendao.gen.TreeDao;

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
public class Forest {
    @Id
    Long id;
    @Unique
    @Property
    String name;
    @Property
    String detail;

    @ToMany(referencedJoinProperty = "forestId")
    List<Tree> trees;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 620740258)
    private transient ForestDao myDao;


    @Generated(hash = 1281806730)
    public Forest(Long id, String name, String detail) {
        this.id = id;
        this.name = name;
        this.detail = detail;
    }
    @Generated(hash = 916597918)
    public Forest() {
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
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 315323624)
    public List<Tree> getTrees() {
        if (trees == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TreeDao targetDao = daoSession.getTreeDao();
            List<Tree> treesNew = targetDao._queryForest_Trees(id);
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
    @Generated(hash = 727791794)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getForestDao() : null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
