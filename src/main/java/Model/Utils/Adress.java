package Model.Utils;

import javax.persistence.*;

@Entity
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String number;



    private String state;
    private String city;

    public Adress(){

    }
    public Adress(Long id, String street, String number, String state, String city) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.state = state;
        this.city = city;
    }
    public Adress(String street, String number, String state, String city) {
        this.street = street;
        this.number = number;
        this.state = state;
        this.city = city;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



}
