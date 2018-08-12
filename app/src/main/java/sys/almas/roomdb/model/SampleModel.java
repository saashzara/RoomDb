package sys.almas.roomdb.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class SampleModel {


    public SampleModel(int id, String name, long createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }

    @PrimaryKey()
    private int id;
    private String name;
    private long createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
