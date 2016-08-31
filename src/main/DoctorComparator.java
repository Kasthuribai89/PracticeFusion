package main;

import java.util.Comparator;

/**
 * Created by kasthuri on 8/29/16.
 *
 * Comparator to list the list of doctors based on their name.
 *
 */
public class DoctorComparator implements Comparator<Doctor> {


    @Override
    public int compare(Doctor o1, Doctor o2) {

       return o1.getName().compareTo(o2.getName());
    }
}
