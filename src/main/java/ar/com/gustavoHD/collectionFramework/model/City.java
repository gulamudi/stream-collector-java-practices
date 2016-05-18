package ar.com.gustavoHD.collectionFramework.model;

/**
 * Created by gdohara on 18/05/2016.
 */
public class City  {

    String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}
