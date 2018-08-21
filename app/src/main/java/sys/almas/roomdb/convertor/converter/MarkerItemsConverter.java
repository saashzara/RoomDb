package sys.almas.roomdb.convertor.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MarkerItemsConverter
{
    @TypeConverter
    public static List<MarkerItemsModel> stringToModel(String json)
    {
        Gson gson = new Gson();
        Type type = new TypeToken<List<MarkerItemsModel>>() {}.getType();
        return gson.fromJson(json, type);
    }

    @TypeConverter
    public static String modelToString(List<MarkerItemsModel> list)
    {
        Gson gson = new Gson();
        Type type = new TypeToken<List<MarkerItemsModel>>() {}.getType();
        return gson.toJson(list, type);
    }
}
