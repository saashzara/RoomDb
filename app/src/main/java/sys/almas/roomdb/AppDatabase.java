package sys.almas.roomdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


import sys.almas.roomdb.interfaces.SampleDao;
import sys.almas.roomdb.model.SampleModel;

/**
 * @author V.Mohtasham
 * @version 1
 * @see android.arch.persistence.room.RoomDatabase
 */
@Database(entities = {SampleModel.class }, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase
{

    private static AppDatabase INSTANCE;
    public abstract SampleDao sampleDao();

    public static AppDatabase getAppDatabase(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "sampledb")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }
}