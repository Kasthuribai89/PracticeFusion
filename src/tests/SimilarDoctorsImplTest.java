package tests;

import main.Doctor;
import main.SimilarDoctorsImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by kasthuri on 8/29/16.
 *
 * Testcases for SimilarDoctorsImpl class.
 *
 */
public class SimilarDoctorsImplTest {

    static List<Doctor> doctorsList;
    static SimilarDoctorsImpl similarDoctors;

    /**
     * Initital setup to create a list of doctors.
     */
    @BeforeClass
    public static void setUp() {

        //Doctor doc4 = new Doctor(Ed Guy,Male,Pediatrician,NYC,3);
        //Doctor doc5 = new Doctor(Ruchi,Female,Orthopedic,CA,3);

        doctorsList = new ArrayList<Doctor>();
        similarDoctors = new SimilarDoctorsImpl(doctorsList);
        similarDoctors.addDoctor("Kevin", "Male", "Dermatologist", "CA", 3);
        similarDoctors.addDoctor("Alex", "Male", "Gynecologist", "NYC", 1);
        similarDoctors.addDoctor("Mark", "Male", "Dermatologist", "NYC", 4);

        //doctorsList = similarDoctors.getDoctorsList();
    }

    /**
     * Test case to add doctor object to list.
     */
    @Test
    public void testInsert () {
        Assert.assertEquals(doctorsList.size(), 3);
        similarDoctors.addDoctor("Ed Guy", "Male", "Pediatrician", "NYC", 3);
        Assert.assertEquals(doctorsList.size(), 4);
    }

    /**
     * Test case to sort list of doctors based on their rating.
     */
    @Test
    public void testSortByRating_with_rating_true () {
        List<Doctor> resultExpected = new ArrayList<Doctor>();
        SimilarDoctorsImpl similarDoctors1 = new SimilarDoctorsImpl(resultExpected);
        similarDoctors1.addDoctor("Mark", "Male", "Dermatologist", "CA", 4);
        similarDoctors1.addDoctor("Alex", "Male", "Gynecologist", "NYC", 1);

        // When the order is set to "true", Should display high to low rating
        List<Doctor> sortedList = similarDoctors.sortByRating(true);


        Assert.assertEquals(sortedList.get(0).getName(), resultExpected.get(0).getName());
        Assert.assertEquals(sortedList.get(2).getName(), resultExpected.get(1).getName());


        // When the order is set to "false", Should display high to low rating
        sortedList = similarDoctors.sortByRating(false);

        Assert.assertEquals(sortedList.get(0).getName(), resultExpected.get(1).getName());
        Assert.assertEquals(sortedList.get(2).getName(), resultExpected.get(0).getName());


    }

    /**
     * Test case to get list of similar doctor.
     */
    @Test
    public void testGetSimlarDoctor () {

        Doctor inputDoctor1 = new Doctor("perl", "Male", "Dermatologist", "CA", 4);

        List<Doctor> similarDoctorsList = similarDoctors.getSimilarDoctor(inputDoctor1);

        Assert.assertEquals(similarDoctorsList.size(), 1);

        Doctor inputDoctor2 = new Doctor("perl", "Male", "Pediatrician", "CA", 4);

        similarDoctorsList = similarDoctors.getSimilarDoctor(inputDoctor2);

        Assert.assertEquals(similarDoctorsList.size(), 0);

        // When the input is set to null, The list should be empty.
        Doctor inputDoctor3 = null;

        similarDoctorsList = similarDoctors.getSimilarDoctor(inputDoctor3);

        Assert.assertEquals(similarDoctorsList.size(), 0);


    }

    /**
     * Test case to get list of doctors with same speciality.
     */
    @Test
    public void testGetSameSpeciality () {

        List<Doctor> sameSpecialityList = similarDoctors.getSameSpeciality("Gynecologist");
        Assert.assertEquals(sameSpecialityList.size(), 1);

        sameSpecialityList = similarDoctors.getSameSpeciality("Dermatologist");
        Assert.assertEquals(sameSpecialityList.size(), 2);

        sameSpecialityList = similarDoctors.getSameSpeciality(null);
        Assert.assertEquals(sameSpecialityList.size(), 0);

    }

    /**
     * Test case to get list of doctors with same location.
     */
    @Test
    public void testGetDoctorsOfSameLocation () {

        List<Doctor> sameLocationList = similarDoctors.getDoctorsOfSameLocation("CA");
        Assert.assertEquals(sameLocationList.size(), 1);

        sameLocationList = similarDoctors.getDoctorsOfSameLocation("NYC");
        Assert.assertEquals(sameLocationList.size(), 3);

        sameLocationList = similarDoctors.getDoctorsOfSameLocation(null);
        Assert.assertEquals(sameLocationList.size(), 0);

    }

    /**
     * Test case to get list of doctors with same rating.
     */
    @Test
    public void testGetDoctorsOfSameRating () {

        List<Doctor> sameRatingList = similarDoctors.getDoctorsOfSameRating(3);
        Assert.assertEquals(sameRatingList.size(), 1);

        sameRatingList = similarDoctors.getDoctorsOfSameRating(4);
        Assert.assertEquals(sameRatingList.size(), 1);

        sameRatingList = similarDoctors.getDoctorsOfSameRating(0);
        Assert.assertEquals(sameRatingList.size(), 0);

    }
}
