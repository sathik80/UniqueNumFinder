package com.nhs.launcher;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueNumberFinderSolutionTWOTest {
    private PrintStream originalSystemOut;
    private ByteArrayOutputStream systemOutContent;

    @BeforeEach
    void redirectSystemOutStream() {
        //loading current (default) sys out
        originalSystemOut = System.out;
        // custom one
        systemOutContent = new ByteArrayOutputStream();
        //diverting to custom
        System.setOut(new PrintStream(systemOutContent));
    }

    @AfterEach
    void restoreSystemOutStream() {
        //reverting to the default
        System.setOut(originalSystemOut);
    }

    @Test
    public void testCorrectSolution() {
    	UniqueNumberFinderSolutionTwo t = new UniqueNumberFinderSolutionTwo();
        //correct solution
        t.checkForSolution("083246791");
        //trim to remove trailing new line
        assertEquals("a=0, b=8, c=3, d=2, e=4, f=6, g=7, m=9, n=1", systemOutContent.toString().trim());
    }

    @Test
    public void testIncorrectSolution() {
    	UniqueNumberFinderSolutionTwo t = new UniqueNumberFinderSolutionTwo();
        //incorrect solution
        t.checkForSolution("012345678");
        //expect no output
        assertEquals("", systemOutContent.toString().trim());
    }

    @Test
    public void testPermutations() {
    	UniqueNumberFinderSolutionTwo t = new UniqueNumberFinderSolutionTwo();
        //simpler input
        t.permutation("ABC", "");
        //expected permutations are two chars long (input.length - 1)
        Set<String> expected = new HashSet<>(Arrays.asList("AB", "BC", "AC", "CA", "BA", "CB"));
        assertEquals(expected, t.getUniques());
    }

    @Test
    public void testCoverage() {
    	UniqueNumberFinderSolutionTwo.main(null);
    }
}

