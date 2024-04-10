package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class DisasterVictimInterfaceTest {

    @Test
    public void testGenerateDisasterVictim() {
        DisasterVictim victim = DisasterVictimInterface.generateDisasterVictim();
        assertNotNull("generateDisasterVictim should generate DisasterVictim Instance",victim);
    }
}





