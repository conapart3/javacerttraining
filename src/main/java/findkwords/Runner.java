package findkwords;

import java.util.*;
import java.util.stream.Collectors;

public class Runner
{
    public static void main(String[] args)
    {
        String[] sentence = {"Z", "Z", "Z", "I", "like", "coding", "I", "I", "like", "node"};
        System.out.println(new Runner().firstAttempt(sentence, 2));
        System.out.println(new Runner().secondAttempt(sentence, 2));
    }

    public List<String> firstAttempt(String[] words, int k)
    {
        Map<String, Integer> countMap = countWordOccurrences(words);
        List<String> sortedMap = sortMap(countMap);
        return sortedMap.subList(0, k);
    }

    private Map<String, Integer> countWordOccurrences(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();

        for(String s : words)
        {
            if(countMap.keySet().contains(s))
            {
                int incrememtedCounter = countMap.get(s) + 1;
                countMap.put(s, incrememtedCounter);
            }
            else
            {
                countMap.put(s, 1);
            }
            System.out.println("Map is now: " + countMap);
        }
        return countMap;
    }

    private List<String> sortMap(Map<String, Integer> countMap)
    {
        return countMap.entrySet().stream()
                // descending order means get(0) of list will have biggest?
                .sorted(((entry1, entry2) -> entry2.getValue() - entry1.getValue()))
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }


    private List<String> secondAttempt(String[] sentence, int i)
    {
        // SORT ARRAY
        // ITERATE THRU, COUNT HOW MANY OF THE SAME WORD YOU GET, ADD TO THE LIST, MAKING SURE WE STILL HAVE < K WORDS
        // WHEN ONTO THE NEXT WORD, COUNT IT, IF GREATER THAN PREVIOUS WORD COUNT THEN PUT TO INDEX 0 OF LIST OTHERWISE 1
        // THIS WILL ALLOW JUST 1 ITERATION OF THE ARRAY AND 1 LIST.
        // probably will still need to keep a hashmap

        return null;
    }
}
