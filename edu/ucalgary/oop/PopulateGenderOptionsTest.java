package edu.ucalgary.oop;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class PopulateGenderOptionsTest {
    private String fileName = "GenderOptions.txt";
    private ArrayList<String> expectedOptions = new ArrayList<String>();
    
    @Before
    public void setUp() {
        expectedOptions.add("boy");
        expectedOptions.add("queer");
        expectedOptions.add("girl");
        expectedOptions.add("man");
        expectedOptions.add("non-binary");
        expectedOptions.add("two-spirit");
        expectedOptions.add("woman");
    }
    

    @Test
    public void testGenerateGenderOptions() {
        assertEquals("populateGenderOptions should match expected output",expectedOptions, PopulateGenderOptions.generateGenderOptions(fileName));
    }
}
