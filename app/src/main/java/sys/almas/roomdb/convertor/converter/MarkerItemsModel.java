package sys.almas.roomdb.convertor.converter;

public class MarkerItemsModel
{
    private long id;
    private String title;
    private String price;
    private String imageUrl;

    public MarkerItemsModel() {}

    public MarkerItemsModel(long id, String title, String price, String imageUrl)
    {
        this.id = id;
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String name)
    {
        this.title = name;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }
}
