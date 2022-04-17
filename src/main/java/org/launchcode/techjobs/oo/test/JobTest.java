package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(jobThree.getName() instanceof String);
        assertEquals("Product tester", jobThree.getName());

        assertTrue(jobThree.getEmployer() instanceof Employer);
        assertEquals("ACME", jobThree.getEmployer().getValue());

        assertTrue(jobThree.getLocation() instanceof Location);
        assertEquals("Desert", jobThree.getLocation().getValue());

        assertTrue(jobThree.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", jobThree.getCoreCompetency().getValue());

        assertTrue(jobThree.getPositionType() instanceof PositionType);
        assertEquals("Quality control", jobThree.getPositionType().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobFour = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(jobThree.equals(jobFour));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals('\n', jobThree.toString().charAt(0));
        assertEquals('\n', jobThree.toString().charAt(jobThree.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String expected = String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n",
                jobThree.getId(), jobThree.getName(), jobThree.getEmployer(), jobThree.getLocation(),
                jobThree.getPositionType(), jobThree.getCoreCompetency());
        assertEquals(expected, jobThree.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobFive = new Job("Technology Associate", new Employer("VMLY&R"), new Location("Kansas City"), new PositionType("Web development"), new CoreCompetency(""));

        String expected = String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: Data not available\n",
                jobFive.getId(), jobFive.getName(), jobFive.getEmployer(), jobFive.getLocation(),
                jobFive.getPositionType());
        assertEquals(expected, jobFive.toString());
    }

//    @Test
//    public void testJobContainsIdOnly() {
//        Job jobOne = new Job();
//        String expected = "OOPS! This job does not seem to exist.";
//
//        assertEquals(expected, jobOne.toString());
//    }
}
