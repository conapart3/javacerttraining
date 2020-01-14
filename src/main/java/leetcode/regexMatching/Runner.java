package leetcode.regexMatching;

public class Runner
{
    public static void main(String[] args)
    {
        System.out.println(isMatch("aa", "a")); // false
        System.out.println(isMatch("aa", "a*")); // true

//        BiPredicate<String, String> myAnswer = (s, p) -> mySolution(s, p);
//        BiPredicate<String, String> solution = (s, p) -> isMatch(s, p);
//
//        BiFunction<Boolean, Boolean, Boolean> testMyAnswerFunction = (a, b) -> a.equals(b);
//
//        System.out.println(testMyAnswerFunction.apply(myAnswer("aa", "a"), solution("aa", "a")));
    }

    public static boolean mySolution(String s, String p)
    {
        for(int i = 0; i < s.length(); i++)
        {
            char currentChar = s.charAt(i);
        }
//        s.()
        return true;
    }

    public static boolean isMatch(String inputString, String pattern)
    {
        return inputString.matches(pattern);
    }
}
