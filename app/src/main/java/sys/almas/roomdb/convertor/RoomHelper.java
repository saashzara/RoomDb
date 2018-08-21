//package sys.almas.roomdb.convertor;
//
//import android.content.Context;
//import android.os.AsyncTask;
//import android.support.v7.widget.SearchView;
//
//import com.example.mtabasi.mapproject.fragment.InfoWindowFragment;
//import com.example.mtabasi.mapproject.helper.Interfaces;
//import com.example.mtabasi.mapproject.helper.MapHelper;
//import com.example.mtabasi.mapproject.model.MarkerItemsModel;
//import com.example.mtabasi.mapproject.room.converter.LatLngConverter;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.Marker;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import sys.almas.roomdb.AppDatabase;
//
//public class RoomHelper
//{
//    /**
//     * insert default markers for test if doesn't exists
//     *
//     * @param locations default markers location (static for now)
//     */
//    public static void insertDefaultMarkers(final Context context, final List<LatLng> locations, final Interfaces.DatabaseCallback callback)
//    {
//        new AsyncTask<Void, Void, List<MarkerEntity>>()
//        {
//            @Override
//            protected List<MarkerEntity> doInBackground(Void... voids)
//            {
//                List<MarkerEntity> markerList = new ArrayList<>();
//                if (AppDatabase.getAppDatabase(context).markerDao().countMarkers() == 0)
//                {
//                    for (LatLng location : locations)
//                    {
//                        MarkerEntity marker = new MarkerEntity(location);
//                        marker.setTitle("بستنی فروشی");
//                        marker.setDescription("توضیحات بستنی فروشی");
//
//                        List<MarkerItemsModel> itemsList = new ArrayList<>();
//                        itemsList.add(new MarkerItemsModel("قیفی", "1500", null));
//                        itemsList.add(new MarkerItemsModel("عروسکی", "3000", null));
//                        itemsList.add(new MarkerItemsModel("لیوانی", "2500", null));
//                        marker.setItems(itemsList);
//
//                        markerList.add(marker);
//                    }
//
//                    AppDatabase.getAppDatabase(context).markerDao().insertAll(markerList);
//                }
//                return markerList;
//            }
//
//            @Override
//            protected void onPostExecute(List<MarkerEntity> markerList)
//            {
//                super.onPostExecute(markerList);
//                callback.onDatabaseChanged(false, markerList);
//            }
//
//        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//
//
////        Runnable insertRunnable = () -> {
////            android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
////
////            if (AppDatabase.getAppDatabase(context).markerDao().countMarkers() == 0)
////            {
////                List<MarkerEntity> markerList = new ArrayList<>();
////                for (LatLng location : locations)
////                {
////                    MarkerEntity marker = new MarkerEntity(location);
////                    marker.setTitle("بستنی فروشی");
////                    marker.setDescription("توضیحات بستنی فروشی");
////
////                    List<MarkerItemsModel> itemsList = new ArrayList<>();
////                    itemsList.add(new MarkerItemsModel("قیفی", "1500", null));
////                    itemsList.add(new MarkerItemsModel("عروسکی", "3000", null));
////                    itemsList.add(new MarkerItemsModel("لیوانی", "2500", null));
////                    marker.setItems(itemsList);
////
////                    markerList.add(marker);
////                }
////
////                AppDatabase.getAppDatabase(context).markerDao().insertAll(markerList);
////                callback.onDatabaseChanged(false, markerList);
////            }
////        };
////        new Thread(insertRunnable).start();
//    }
//
//    /**
//     * add a marker to database from user and call database changing callback to add marker on map
//     *
//     * @param marker   user selected location for adding marker
//     * @param callback database callback
//     */
//    public static void insertUserMarker(Context context, MarkerEntity marker,
//                                        Interfaces.DatabaseCallback callback)
//    {
//        new AsyncTask<Void, Void, List<MarkerEntity>>()
//        {
//            @Override
//            protected List<MarkerEntity> doInBackground(Void... voids)
//            {
//                MarkerDao markerDao = AppDatabase.getAppDatabase(context).markerDao();
//                markerDao.insert(marker);
//
//                List<MarkerEntity> markerList = new ArrayList<>();
//                markerList.add(marker);
//
//                return markerList;
//            }
//
//            @Override
//            protected void onPostExecute(List<MarkerEntity> markerList)
//            {
//                super.onPostExecute(markerList);
//                callback.onDatabaseChanged(false, markerList);
//            }
//
//        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//
////        Runnable insertRunnable = () -> {
////            android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
////
////            MarkerDao markerDao = AppDatabase.getAppDatabase(context).markerDao();
////            markerDao.insert(marker);
////
////            List<MarkerEntity> markerList = new ArrayList<>();
////            markerList.add(marker);
////            callback.onDatabaseChanged(false, markerList);
////        };
////        new Thread(insertRunnable).start();
//    }
//
//    /**
//     * get all markers from database and call database changing Callback to add markers on map
//     *
//     * @param callback database callback
//     */
//    public static void getAllMarkers(Context context, Interfaces.DatabaseCallback callback)
//    {
//        new AsyncTask<Void, Void, List<MarkerEntity>>()
//        {
//            @Override
//            protected List<MarkerEntity> doInBackground(Void... voids)
//            {
//                MarkerDao markerDao = AppDatabase.getAppDatabase(context).markerDao();
//
//                List<MarkerEntity> markerList = new ArrayList<>();
//                if (markerDao.countMarkers() != 0)
//                    markerList = markerDao.getAllMarkers();
//
//                return markerList;
//            }
//
//            @Override
//            protected void onPostExecute(List<MarkerEntity> markerList)
//            {
//                super.onPostExecute(markerList);
//                callback.onDatabaseChanged(false, markerList);
//            }
//
//        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//
////        Runnable insertRunnable = () -> {
////            android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
////
////            MarkerDao markerDao = AppDatabase.getAppDatabase(context).markerDao();
////            if (markerDao.countMarkers() != 0)
////            {
////                List<MarkerEntity> markerList = markerDao.getAllMarkers();
////                callback.onDatabaseChanged(false, markerList);
////            }
////        };
////        new Thread(insertRunnable).start();
//    }
//
//    /**
//     * delete a specific marker from database and call database changing Callback to reload map
//     *
//     * @param markerId marker to delete
//     * @param callback database callback
//     */
//    public static void deleteMarker(Context context, String markerId, Interfaces.DatabaseCallback callback)
//    {
//        new AsyncTask<Void, Void, Void>()
//        {
//            @Override
//            protected Void doInBackground(Void... voids)
//            {
//                MarkerDao markerDao = AppDatabase.getAppDatabase(context).markerDao();
//                MarkerEntity marker = markerDao.getMarkerById(markerId);
//                if (marker != null)
//                    markerDao.delete(marker);
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid)
//            {
//                super.onPostExecute(aVoid);
//                callback.onDatabaseChanged(true, null);
//            }
//
//        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//
////        Runnable insertRunnable = () -> {
////            android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
////
////            MarkerDao markerDao = AppDatabase.getAppDatabase(context).markerDao();
////            if (markerDao.countMarkers() != 0)
////            {
////                markerDao.deleteById(LatLngConverter.modelToString(marker.getPosition()));
////                callback.onDatabaseChanged(true, null);
////            }
////        };
////        new Thread(insertRunnable).start();
//    }
//
//    /**
//     * update an existing marker items list
//     *
//     * @param items updated items list
//     */
//    public static void updateMarkerItems(Context context, String markerId, List<MarkerItemsModel> items)
//    {
//        new AsyncTask<Void, Void, Void>()
//        {
//            @Override
//            protected Void doInBackground(Void... voids)
//            {
//                MarkerDao markerDao = AppDatabase.getAppDatabase(context).markerDao();
//                MarkerEntity marker = markerDao.getMarkerById(markerId);
//                if (marker != null)
//                {
//                    marker.setItems(items);
//                    markerDao.update(marker);
//                }
//                return null;
//            }
//
//        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//
////        Runnable insertRunnable = () -> {
////            android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
////
////            MarkerDao markerDao = AppDatabase.getAppDatabase(context).markerDao();
////            MarkerEntity marker = markerDao.getMarkerById(markerId);
////            if (marker != null)
////            {
////                marker.setItems(items);
////                markerDao.update(marker);
////            }
////        };
////        new Thread(insertRunnable).start();
//    }
//
//    /**
//     * get marker items list from database
//     *
//     * @param markerId marker that want to get its items list
//     * @param callback database callback
//     */
//    public static void getMarkerItems(Context context, String markerId, Interfaces.DatabaseCallback callback)
//    {
//        new AsyncTask<Void, Void, List<MarkerItemsModel>>()
//        {
//            private MarkerEntity marker;
//
//            @Override
//            protected List<MarkerItemsModel> doInBackground(Void... voids)
//            {
//                MarkerDao markerDao = AppDatabase.getAppDatabase(context).markerDao();
//                List<MarkerItemsModel> itemList = new ArrayList<>();
//                marker = markerDao.getMarkerById(markerId);
//                if (marker != null)
//                    itemList = marker.getItems();
//
//                return itemList;
//            }
//
//            @Override
//            protected void onPostExecute(List<MarkerItemsModel> markerItemsModels)
//            {
//                super.onPostExecute(markerItemsModels);
//                callback.onGetMarkerItemsList(markerId, marker, markerItemsModels);
//            }
//
//        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//    }
//
//    /**
//     * get a marker entity by its id from database
//     *
//     * @param markerId marker id to get its entity
//     * @param callback marker dialog callback
//     */
//    public static void getMarkerById(Context context, String markerId, Interfaces.MarkerDialogCallback callback)
//    {
//        new AsyncTask<Void, Void, MarkerEntity>()
//        {
//            @Override
//            protected MarkerEntity doInBackground(Void... voids)
//            {
//                MarkerDao markerDao = AppDatabase.getAppDatabase(context).markerDao();
//                //TODO: simulate timing for getting data from db (remove it) - start
//                try
//                {
//                    Thread.sleep(1000);
//                }
//                catch (InterruptedException e)
//                {
//                    e.printStackTrace();
//                }
//                //TODO: end
//                return markerDao.getMarkerById(markerId);
//            }
//
//            @Override
//            protected void onPostExecute(MarkerEntity marker)
//            {
//                super.onPostExecute(marker);
//                callback.onGetMarker(marker);
//            }
//
//        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//    }
//
//    public static void searchByTitle(Context context, String title, Interfaces.DatabaseSearchCallback callback)
//    {
//        new AsyncTask<Void, Void, List<MarkerEntity>>()
//        {
//            @Override
//            protected List<MarkerEntity> doInBackground(Void... voids)
//            {
//                MarkerDao markerDao = AppDatabase.getAppDatabase(context).markerDao();
//                List<MarkerEntity> allMarkers = markerDao.getAllMarkers();
//                List<MarkerEntity> searchResultMarkers = new ArrayList<>();
//                for (MarkerEntity marker : allMarkers)
//                {
//                    if (marker.getTitle().contains(title))
//                        searchResultMarkers.add(marker);
//                }
//
//                return searchResultMarkers;
//            }
//
//            @Override
//            protected void onPostExecute(List<MarkerEntity> markerEntities)
//            {
//                super.onPostExecute(markerEntities);
//                callback.onSearchResult(markerEntities);
//            }
//
//        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//    }
//}
