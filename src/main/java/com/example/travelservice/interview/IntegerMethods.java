package com.example.travelservice.interview;

import org.hibernate.engine.jdbc.CharacterStream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntegerMethods {



    public int duplicatesMap (List<Integer> nums){

        Map<Integer, Integer> helper = nums.stream().collect(
                Collectors.toMap(Function.identity(), num -> 1, Math::addExact));

        return  helper.values().stream().max(Integer::compare).orElse(0);
    }

    public String reverseString (String s){

        StringBuilder res = new StringBuilder();
        for (int i = s.length()-1; i > 0 ; i--) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

}
