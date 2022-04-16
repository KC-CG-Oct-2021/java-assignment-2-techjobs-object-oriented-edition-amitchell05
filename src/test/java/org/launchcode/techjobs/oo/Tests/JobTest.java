package org.launchcode.techjobs.oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job jobOne;
    Job jobTwo;
    Job jobThree;

    @Before
    public void createJobObject() {
        jobOne = new Job();
        jobTwo = new Job();
        jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(jobThree.getName() instanceof String);
        assertEquals(jobThree.getName(), "Product tester");

        assertTrue(jobThree.getEmployer() instanceof Employer);
        assertEquals(jobThree.getEmployer().getValue(), "ACME");

        assertTrue(jobThree.getLocation() instanceof Location);
        assertEquals(jobThree.getLocation().getValue(), "Desert");

        assertTrue(jobThree.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(jobThree.getCoreCompetency().getValue(), "Persistence");

        assertTrue(jobThree.getPositionType() instanceof PositionType);
        assertEquals(jobThree.getPositionType().getValue(), "Quality control");
    }
}
