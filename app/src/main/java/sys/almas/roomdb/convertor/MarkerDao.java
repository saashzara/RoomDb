package sys.almas.roomdb.convertor;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;



import java.util.List;

@Dao
public interface MarkerDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MarkerEntity marker);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MarkerEntity> markers);

    @Update
    void update(MarkerEntity marker);

    @Delete
    void delete(MarkerEntity marker);

    @Query("SELECT * FROM marker WHERE marker_id = :markerId")
    MarkerEntity getMarkerById(String markerId);

    @Query("SELECT * FROM marker")
    List<MarkerEntity> getAllMarkers();

    @Query("SELECT * FROM marker WHERE marker_title LIKE :title")
    List<MarkerEntity> searchByTitle(String title);

    @Query("SELECT COUNT(*) FROM marker")
    int countMarkers();
}
