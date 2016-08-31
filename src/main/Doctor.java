package main;

/**
 * Created by kasthuri on 8/29/16.
 *
 * Getter and setter for Doctor object.
 *
 */
public class Doctor {

    String name;
    String gender;
    String speciality;
    String location;
    int rating;

    public Doctor(String name,
                  String gender,
                  String speciality,
                  String location,
                  int rating) {
        this.name = name;
        this.gender = gender;
        this.speciality = speciality;
        this.location = location;
        this.rating = rating;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
