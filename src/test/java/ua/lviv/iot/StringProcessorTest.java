package ua.lviv.iot;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringProcessorTest {
    StringProcessor manager = new StringProcessor();
    String testString;
    List<String> expected;
    List<String> actual;

    @BeforeEach
    public void setUp() {
        expected = new LinkedList<String>();
        actual = new LinkedList<String>();

        testString = "A Song of Ice and F5ire series was p2artly inspired by the W4ars of the Roses,"
                + " a s2eries of dynastic civil wars for th4e t4hrone of England. This painting by Richard Burchett"
                + " p2ortrays 22Edward IV demanding that his defeated enemies be taken from Tewkesbury Abbey.";

        expected.add("p2artly");
        expected.add("s2eries");
        expected.add("p2ortrays");
        expected.add("22Edward");

        manager.setLine(testString);
        manager.setNumber("2");
    }

    @Test
    public void testFindMatch() throws IOException {
        actual = manager.findMatch();
        Assertions.assertEquals(4, actual.size());
        Assertions.assertEquals(expected, actual);
        manager.showResults();
    }

    @Test
    public void testFindMatchNotFound() {
        manager.setNumber("7");
        actual = manager.findMatch();
        Assertions.assertEquals(0, actual.size());
        manager.showResults();
    }

}