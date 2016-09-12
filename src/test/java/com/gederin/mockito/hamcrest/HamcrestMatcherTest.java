package com.gederin.mockito.hamcrest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
/**
 * Created by rgederin on 9/12/2016.
 */
public class HamcrestMatcherTest {

    @Test
    public void test(){
        List<Integer> scores = Arrays.asList(99, 100, 101);

        assertThat(scores, hasSize(3));
        assertThat(scores, everyItem(greaterThan(90)));
        assertThat(scores, hasItems(99,100));

        assertThat("", isEmptyString());
        assertThat(null, isEmptyOrNullString());

        Integer[] marks = {1,2,3};
        assertThat(marks, arrayWithSize(3));
        assertThat(marks, arrayContaining(1,2,3));
        assertThat(marks, arrayContainingInAnyOrder(1,3,2));
    }
}
