package com.danmiller.customtags;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/** Unit test class for the WelcomeMessageTag.
 *  This class is used to
 *  1. verify the individual methods of WelcomeMessageTag work properly using a few test string that were provided in the 
 *  project specs.
 */
class WelcomeMessageTagTest {

    WelcomeMessageTag tag;

    /**
     * Create a new WelcomeMessageTag object before each test is run.
     */
    @BeforeEach
    void setUp() {
        tag = new WelcomeMessageTag();

    }

    /**
     * Determine the greeting tag, which is passed in as a string
     */
    //@Test
    //void determineGreetingTag() {

        //assertEquals("Good Night", tag.getGreeting());
        //assertTrue(tag.getGreeting() == "Good Night");
    //}
}
