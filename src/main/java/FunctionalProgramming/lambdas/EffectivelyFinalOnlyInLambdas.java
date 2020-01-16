package FunctionalProgramming.lambdas;

import java.util.Arrays;
import java.util.List;

public class EffectivelyFinalOnlyInLambdas
{
    private static String staticClassLevelString = "adwadw";

    public static void main(String[] args, String effectivelyFinalMethodParam)
    {
        List<String> strlist = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "z", "b", "2", "", "dawdwa");

        /**
        lambdas can access:
            - static variables
            - final or effectively final method parameters
            - final or effectively final local variables
            - instance variables

         */
        staticClassLevelString = "dawdwa";
        strlist.stream()
                .filter(param -> param.equals(staticClassLevelString))
                .findAny()
                .ifPresent(str -> System.out.println(str +"exists (" + staticClassLevelString));

        // the below stream won't compile because effectivelyFinalMethodParam is being changed and is not effectively final!
        effectivelyFinalMethodParam = "dawdwa";
//        strlist.stream()
//                .filter(param -> param.equals(effectivelyFinalMethodParam)) // does not compile
//                .findAny()
//                .ifPresent(str -> System.out.println(str +"exists (" + effectivelyFinalMethodParam)); // does not compile

        // this works because the variable isn't being changed. One way to stop us changing it is by making it final
        String effectivelyFinalLocalVariable = "dawdwa";
        strlist.stream()
                .filter(param -> param.equals(effectivelyFinalLocalVariable))
                .findAny()
                .ifPresent(str -> System.out.println(str +"exists (" + effectivelyFinalLocalVariable));


    }
}
