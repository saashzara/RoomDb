package sys.almas.roomdb;

import android.app.Application;

public class MasterApp extends Application {

    private static MasterApp mInstance;

    public static MasterApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        AppDatabase.getAppDatabase(this);
    }
}
