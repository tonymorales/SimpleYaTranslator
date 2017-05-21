package com.example.tony_.simpleyatranslator.storage.model;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity(active = true, nameInDb = "TRANSLATIONS")
public class Translation {

    private static final String LOG_TAG = "Translation";
    @Id
    private Long id;

    private String textFrom;
    private String textResult;
    private String langFrom;
    private String langTo;
    private int favorite;
    private String dateTime;


    @Override
    public String toString() {

        return "Translate text: " + textFrom + ". With result: " + textResult
                + ". Lang: " + langTo + "-" + langFrom + ". Time: " + dateTime;
    }

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 664316826)
    private transient TranslationDao myDao;

    public Translation(String textFrom, String textResult, String langFrom, String langTo, int favorite, String dateTime) {
      //  Log.d(LOG_TAG, "Building new object");
        this.textFrom = textFrom;
        this.textResult = textResult;
        this.langFrom = langFrom;
        this.langTo = langTo;
        this.favorite = favorite;
        this.dateTime = dateTime;
    }

    @Generated(hash = 307464979)
    public Translation(Long id, String textFrom, String textResult, String langFrom, String langTo, int favorite,
            String dateTime) {
        this.id = id;
        this.textFrom = textFrom;
        this.textResult = textResult;
        this.langFrom = langFrom;
        this.langTo = langTo;
        this.favorite = favorite;
        this.dateTime = dateTime;
    }

    @Generated(hash = 321689573)
    public Translation() {
    }

    public Long getId() {
        return this.id;
    }

    public String getTextFrom() {
        return textFrom;
    }

    public void setTextFrom(String textFrom) {
        this.textFrom = textFrom;
    }

    public String getTextResult() {
        return textResult;
    }

    public void setTextResult(String textResult) {
        this.textResult = textResult;
    }

    public String getLangFrom() {
        return langFrom;
    }

    public void setLangFrom(String langFrom) {
        this.langFrom = langFrom;
    }

    public String getLangTo() {
        return langTo;
    }

    public void setLangTo(String langTo) {
        this.langTo = langTo;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setId(Long id) {
        this.id = id;
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
    @Generated(hash = 618685332)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTranslationDao() : null;
    }


}
