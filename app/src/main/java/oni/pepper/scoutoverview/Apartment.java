package oni.pepper.scoutoverview;

public class Apartment {

    private int image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public Apartment() {
    }

    public Apartment(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    @Override
    public String toString() {
        return this.title + ", " + this.image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
