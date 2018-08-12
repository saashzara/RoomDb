package sys.almas.roomdb;

 import sys.almas.roomdb.model.SampleModel;

import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_ACTIVITY = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(MAIN_ACTIVITY, "inster to db");
        AppDatabase.getAppDatabase(this).sampleDao().insert(new SampleModel(1, "user 1", System.currentTimeMillis()));
        AppDatabase.getAppDatabase(this).sampleDao().insert(new SampleModel(2, "user 2", System.currentTimeMillis()));
        AppDatabase.getAppDatabase(this).sampleDao().insert(new SampleModel(3, "user 3", System.currentTimeMillis()));
        AppDatabase.getAppDatabase(this).sampleDao().insert(new SampleModel(4, "user 4", System.currentTimeMillis()));
        print();

        Log.d(MAIN_ACTIVITY, "update to db");
        AppDatabase.getAppDatabase(this).sampleDao().update(new SampleModel(2, "user 2 <--- update", System.currentTimeMillis()));
        print();


        Log.d(MAIN_ACTIVITY, "delete By Object");
        SampleModel obj = AppDatabase.getAppDatabase(this).sampleDao().findById(3);
        AppDatabase.getAppDatabase(this).sampleDao().deleteByObject(obj);
        print();

        Log.d(MAIN_ACTIVITY, "delete By Id");
        AppDatabase.getAppDatabase(this).sampleDao().deleteById(2);
        print();

    }

    private void print() {
        Log.d(MAIN_ACTIVITY, "----- show list -------");
        List<SampleModel> list = AppDatabase.getAppDatabase(this).sampleDao().getByOrder();
        for (SampleModel sampleModel : list) {
            Log.d(MAIN_ACTIVITY, sampleModel.getName());
        }
         Log.d(MAIN_ACTIVITY, "----------------------");

    }
}
