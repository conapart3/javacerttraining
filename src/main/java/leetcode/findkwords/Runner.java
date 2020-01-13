package leetcode.findkwords;

import java.util.*;
import java.util.stream.Collectors;

public class Runner
{
    public static void main(String[] args)
    {
//        String[] sentence = {"Z", "Z", "Z", "I", "like", "coding", "I", "I", "like", "node"};
        String[] sentence = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(new Runner().firstAttempt(sentence, 4));
        System.out.println(new Runner().secondAttempt(sentence, 2));

        System.out.println("Third go!");
        Solution s = new Solution();
        System.out.println(s.topKFrequent(sentence, 2));
    }


    private List<String> secondAttempt(String[] sentence, int k)
    {
        // SORT ARRAY
        Arrays.sort(sentence);

        TreeMap<String, Integer> treeMap = new TreeMap<>();

        int index = 1;
        String currentWord = sentence[0];
        int currentWordCount = 1;
        while (index < sentence.length)
        {
            if (!sentence[index].equals(currentWord))
            {
                treeMap.put(currentWord, currentWordCount);
                currentWord = sentence[index];
                currentWordCount = 1;
                System.out.println(treeMap);
            }
            else
            {
                currentWordCount++;
            }
            index++;
        }
        if(!treeMap.containsKey(currentWord))
        {
            treeMap.put(currentWord, currentWordCount);
            System.out.println(treeMap);
        }

        List<String> allResults = treeMap.entrySet().stream()
                .sorted(((o1, o2) -> o2.getValue() - o1.getValue()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        return allResults.subList(0, k);
    }

    public List<String> firstAttempt(String[] words, int k)
    {
        // First sort the words into alphabetical order ascending
        Arrays.sort(words);

        Map<String, Integer> countMap = countWordOccurrences(words);

        List<String> sortedList = sortMap(countMap);

        return sortedList.subList(0, k);
    }

    private Map<String, Integer> countWordOccurrences(String[] words)
    {
        Map<String, Integer> countMap = new HashMap<>();

        for (String s : words)
        {
            if (countMap.keySet().contains(s))
            {
                int incrementedCounter = countMap.get(s) + 1;
                countMap.put(s, incrementedCounter);
            }
            else
            {
                countMap.put(s, 1);
            }
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


}
