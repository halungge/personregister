package ch.mlz.preg.model;

import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;


public class GenderTest {

    @Test
    public void createFromCode(){
        assertThat(Gender.create("F"), CoreMatchers.is(Gender.FEMALE));
        assertThat(Gender.create("M"), CoreMatchers.is(Gender.MALE));
        assertThat(Gender.create("T"), is(Gender.THIRD));
        assertThat(Gender.create("X"), is(Gender.UNKNOWN));
    }

    //TODO Test cases
    // 1. map case independent
    // 2. todo anything other than F, M, T maps to unknown
  // 3. serialization
}