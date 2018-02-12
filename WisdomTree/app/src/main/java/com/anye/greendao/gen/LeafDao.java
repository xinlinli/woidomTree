package com.anye.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.xinlin.wisdomtree.entity.Leaf;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LEAF".
*/
public class LeafDao extends AbstractDao<Leaf, Long> {

    public static final String TABLENAME = "LEAF";

    /**
     * Properties of entity Leaf.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Detail = new Property(2, String.class, "detail", false, "DETAIL");
        public final static Property TrunkId = new Property(3, Long.class, "trunkId", false, "TRUNK_ID");
    }


    public LeafDao(DaoConfig config) {
        super(config);
    }
    
    public LeafDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LEAF\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"DETAIL\" TEXT," + // 2: detail
                "\"TRUNK_ID\" INTEGER);"); // 3: trunkId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LEAF\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Leaf entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String detail = entity.getDetail();
        if (detail != null) {
            stmt.bindString(3, detail);
        }
 
        Long trunkId = entity.getTrunkId();
        if (trunkId != null) {
            stmt.bindLong(4, trunkId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Leaf entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String detail = entity.getDetail();
        if (detail != null) {
            stmt.bindString(3, detail);
        }
 
        Long trunkId = entity.getTrunkId();
        if (trunkId != null) {
            stmt.bindLong(4, trunkId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Leaf readEntity(Cursor cursor, int offset) {
        Leaf entity = new Leaf( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // detail
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3) // trunkId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Leaf entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDetail(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTrunkId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Leaf entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Leaf entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Leaf entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}