package sys.almas.roomdb.convertor.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class LatLngConverter
{
    @TypeConverter
    public static LatLng stringToModel(String json)
    {
        Gson gson = new Gson();
        Type type = new TypeToken<LatLng>() {}.getType();
        return gson.fromJson(json, type);
    }

    @TypeConverter
    public static String modelToString(LatLng position)
    {
        Gson gson = new Gson();
        Type type = new TypeToken<LatLng>() {}.getType();
        return gson.toJson(position, type);
    }
}
