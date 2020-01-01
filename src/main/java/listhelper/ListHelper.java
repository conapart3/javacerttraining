package listhelper;

import java.util.*;

import static java.util.Collections.*;

import java.lang.*;

public class ListHelper
{
    public List<String> copyAndSort(List<String> toCopy)
    {
        List<String> copied = new ArrayList<>(toCopy);
        sort(copied);
        return copied;
    }
}
