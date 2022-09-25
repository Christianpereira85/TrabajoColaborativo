package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringUtils {

	public StringUtils() {
		// TODO Auto-generated constructor stub
	}


	public static String[] reverseArray(String[] arr) {
        List<String> list = Arrays.asList(arr);
        
        Collections.reverse(list);
        
        String[] reversedArray = list.toArray(arr);
        
        return reversedArray;
   }
}
