package sys.almas.roomdb.interfaces;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import sys.almas.roomdb.model.SampleModel;


@Dao
public interface SampleDao
{
    @Query("SELECT * FROM SampleModel WHERE id = :id LIMIT 1")
    SampleModel findById(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(SampleModel model);

    @Delete()
    void deleteByObject(SampleModel model);

    @Query("DELETE FROM SampleModel WHERE id=:id_")
    void deleteById(int id_);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(SampleModel model);

    @Query("SELECT * FROM SampleModel ORDER BY `createTime` ASC")
    List<SampleModel> getByOrder();



//    //**********************************************************************************************
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    long insertInstagram(InstagramModel model);
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    long insertTelegram(TelegramModel model);
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    long insertTwitter(TwitterModel model);
//
//    //----------------------------------------------------------------------------------------------
//    @Query("SELECT * FROM InstagramModel WHERE isSend=0 ORDER BY `insertDate` DESC,`send_date` ASC LIMIT 1")
//    InstagramModel orderByInstagram();
//
//    @Query("SELECT * FROM TelegramModel WHERE isSend=0 ORDER BY `insertDate` DESC,`send_date` ASC LIMIT 1")
//    TelegramModel orderByTelegram();
//
//    @Query("SELECT * FROM TwitterModel WHERE isSend=0 ORDER BY `insertDate` DESC,`send_date` ASC LIMIT 1")
//    TwitterModel orderByTwitter();
//
//    //----------------------------------------------------------------------------------------------
//    @Query("SELECT * FROM InstagramModel WHERE commandID = :id LIMIT 1")
//    InstagramModel findByIdInstagram(int id);
//
//    @Query("SELECT * FROM TelegramModel WHERE commandID = :id LIMIT 1")
//    TelegramModel findByIdTelegram(int id);
//
//    @Query("SELECT * FROM TwitterModel WHERE commandID = :id LIMIT 1")
//    TwitterModel findByIdTwitter(int id);
//
//    //----------------------------------------------------------------------------------------------
//    @Update(onConflict = OnConflictStrategy.IGNORE)
//    void updateInstagram(InstagramModel model);
//
//    @Update(onConflict = OnConflictStrategy.IGNORE)
//    void updateTelegram(TelegramModel model);
//
//    @Update(onConflict = OnConflictStrategy.IGNORE)
//    void updateTwitter(TwitterModel model);
}