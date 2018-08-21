package sys.almas.roomdb.convertor;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;


import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import sys.almas.roomdb.convertor.converter.LatLngConverter;
import sys.almas.roomdb.convertor.converter.MarkerItemsConverter;
import sys.almas.roomdb.convertor.converter.MarkerItemsModel;

@Entity(tableName = "marker")
@TypeConverters({MarkerItemsConverter.class, LatLngConverter.class})
public class MarkerEntity implements Parcelable
{
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "marker_id")
    private LatLng position;

    @ColumnInfo(name = "marker_title")
    private String title;

    @ColumnInfo(name = "marker_description")
    private String description;

    @ColumnInfo(name = "image_url")
    private String imageUrl;

    @ColumnInfo(name = "marker_items")
    private List<MarkerItemsModel> items = new ArrayList<>();

    public MarkerEntity(@NonNull LatLng position) {
        this.position = position;
    }

    public LatLng getPosition()
    {
        return position;
    }

    public void setPosition(LatLng position)
    {
        this.position = position;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public List<MarkerItemsModel> getItems()
    {
        return items;
    }

    public void setItems(List<MarkerItemsModel> items)
    {
        this.items = items;
    }

    @Ignore
    protected MarkerEntity(Parcel in)
    {
        position = in.readParcelable(LatLng.class.getClassLoader());
        title = in.readString();
        description = in.readString();
        imageUrl = in.readString();
    }

    @Ignore
    public static final Creator<MarkerEntity> CREATOR = new Creator<MarkerEntity>()
    {
        @Override
        public MarkerEntity createFromParcel(Parcel in)
        {
            return new MarkerEntity(in);
        }

        @Override
        public MarkerEntity[] newArray(int size)
        {
            return new MarkerEntity[size];
        }
    };

    @Ignore
    @Override
    public int describeContents()
    {
        return 0;
    }

    @Ignore
    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(position, i);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(imageUrl);
    }
}
