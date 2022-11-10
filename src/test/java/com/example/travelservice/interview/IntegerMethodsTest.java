package com.example.travelservice.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerMethodsTest {

    @Test
    void duplicatesMap() {
        List<Integer> nums = List.of(1, 2, 1, 2, 1, 3, 5, 6, 1);
        IntegerMethods integerMethods = new IntegerMethods();
        int duplicates = integerMethods.duplicatesMap(nums);
        assertEquals(4, duplicates);
    }
}