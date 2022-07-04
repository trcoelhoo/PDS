package ex3;

public class Place {
    private String name;
    private String country;
    private String city;

    public Place(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
    
    @Override
    public String toString() {
        return "Place{" + "name=" + name + ", country=" + country + ", city=" + city + '}';
    }
    
}
