package main;

import java.util.*;

/**
 * Created by kasthuri on 8/29/16.
 *
 * Class implements all the methods of the Interface SimilarDoctor
 *
 */
public class SimilarDoctorsImpl implements SimlarDoctors {

    List<Doctor> doctorList;

    public SimilarDoctorsImpl(List<Doctor> doctorList) {
      this.doctorList = doctorList;
    }


    /**
     * Adds the doctor object.
     *
     * @param name
     * @param gender
     * @param speciality
     * @param location
     * @param rating
     * @return
     */
    @Override
    public List<Doctor> addDoctor(String name, String gender, String speciality, String location, int rating) {
        Doctor doctor = new Doctor(name, gender, speciality, location, rating);
        doctorList.add(doctor);

        return doctorList;
    }


    /**
     * Sort the list of Doctors based on their rating.
     *
     * @param order
     * @return
     */
    @Override
    public List<Doctor> sortByRating(boolean order) {

        if (!order) {
             Collections.sort(doctorList, new Comparator<Doctor>() {
                @Override
                public int compare(Doctor o1, Doctor o2) {
                    return o1.getRating() - o2.getRating();
                }
            });
        } else {
            Collections.sort(doctorList, new Comparator<Doctor>() {
                @Override
                public int compare(Doctor o1, Doctor o2) {
                    return o2.getRating() - o1.getRating();
                }
            });

        }

        return doctorList;

    }

    /**
     * Gets similar doctors based on the given doctor's
     * speciality and location.
     *
     * @param doctor
     * @return
     */
    @Override
    public List<Doctor> getSimilarDoctor(Doctor doctor) {
        List<Doctor> sameSpecialityDoctors = new ArrayList<Doctor>();

        if (doctor == null) {
            return sameSpecialityDoctors;
        }
        Iterator<Doctor> doctorIterator = doctorList.iterator();

        while (doctorIterator.hasNext()) {
            Doctor currentDoc = doctorIterator.next();

            if(doctor.getSpeciality().equals(currentDoc.getSpeciality()) &&
                    doctor.getLocation().equals(currentDoc.getLocation())) {

                sameSpecialityDoctors.add(currentDoc);
            }

        }

        Collections.sort(sameSpecialityDoctors, new DoctorComparator());

        return sameSpecialityDoctors;
    }

    /**
     * Gets the list of doctors based on their speciality.
     *
     * @param speciality
     * @return
     */
    @Override
    public List<Doctor> getSameSpeciality(String speciality) {

        Iterator<Doctor> doctorIterator = doctorList.iterator();
        List<Doctor> doctorsOfSameSpeciality = new ArrayList<Doctor>();

        while (doctorIterator.hasNext()) {
            Doctor currentDoc = doctorIterator.next();

            if (currentDoc.getSpeciality().equals(speciality)) {
                doctorsOfSameSpeciality.add(currentDoc);
            }
        }

        Collections.sort(doctorsOfSameSpeciality, new DoctorComparator());

        return doctorsOfSameSpeciality;
    }

    /**
     * Gets the list of doctors based on their location.
     *
     * @param location
     * @return
     */
    @Override
    public List<Doctor> getDoctorsOfSameLocation(String location) {

        Iterator<Doctor> doctorIterator = doctorList.iterator();
        List<Doctor> doctorsOfSameLocation = new ArrayList<Doctor>();

        while (doctorIterator.hasNext()) {
            Doctor currentDoc = doctorIterator.next();

            if (currentDoc.getLocation().equals(location)) {
                doctorsOfSameLocation.add(currentDoc);
            }
        }

        Collections.sort(doctorsOfSameLocation, new DoctorComparator());

        return doctorsOfSameLocation;
    }

    /**
     * Gets the list of doctors based on their rating.
     *
     * @param rating
     * @return
     */
    @Override
    public List<Doctor> getDoctorsOfSameRating(int rating) {

        Iterator<Doctor> doctorIterator = doctorList.iterator();
        List<Doctor> doctorsOfSameRating = new ArrayList<Doctor>();

        while (doctorIterator.hasNext()) {
            Doctor currentDoc = doctorIterator.next();

            if (currentDoc.getRating() == rating) {
                doctorsOfSameRating.add(currentDoc);
            }
        }

        Collections.sort(doctorsOfSameRating, new DoctorComparator());

        return doctorsOfSameRating;
    }


}
