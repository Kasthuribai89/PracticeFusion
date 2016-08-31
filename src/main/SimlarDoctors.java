package main;

import java.util.List;

/**
 * Created by kasthuri on 8/29/16.
 *
 * Interface: Contains the list of methods
 * to implements the SimilarDoctorImpl class.
 *
 */
public interface SimlarDoctors {

    List<Doctor> addDoctor(String name,
                           String gender,
                           String speciality,
                           String location,
                           int rating);

    List<Doctor> sortByRating(boolean order);
    List<Doctor> getSimilarDoctor(Doctor doctor);
    List<Doctor> getSameSpeciality(String speciality);
    List<Doctor> getDoctorsOfSameLocation(String location);
    List<Doctor> getDoctorsOfSameRating(int rating);

}
