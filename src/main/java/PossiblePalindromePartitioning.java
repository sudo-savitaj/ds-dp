//https://www.youtube.com/watch?v=d9F1aO_idyE
//https://practice.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&problemType=functional&page=1&company[]=Amazon&query=category[]Dynamic%20ProgrammingproblemTypefunctionalpage1company[]Amazoncategory[]Dynamic%20Programming
//https://leetcode.com/submissions/detail/469339830/
import java.util.ArrayList;

public class PossiblePalindromePartitioning {
    public void display() {
       ArrayList<ArrayList<String>> listStr = getGray("geeks");

       for (ArrayList<String> list : listStr){
               System.out.println();
           for (String str : list) {
               System.out.print("      "+str);
           }
       }
    }

    static ArrayList<ArrayList<String>> getGray(String S) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        getPalindrome(S,result,new ArrayList<>());
        return result;
    }

    private static void getPalindrome(String s,ArrayList<ArrayList<String>> result,ArrayList<String> currentList) {
        if(s.isEmpty()) {
            result.add(currentList);
            return;
        }

        for(int i=1;i<=s.length();i++){
            String leftSubString = s.substring(0, i);
            String rightSubString = s.substring(i);

            if(isPalindrome(leftSubString))
            {
                ArrayList<String> list = new ArrayList<>(currentList);
                list.add(leftSubString);
                getPalindrome(rightSubString,result,list);
            }

        }
    }

    private static boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<=j||j>=0){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
