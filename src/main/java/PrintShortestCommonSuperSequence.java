public class PrintShortestCommonSuperSequence {
    void display(){
        shortestCommonSuperSequence("HELLO","GEEK");

    }

    void shortestCommonSuperSequence(String s1, String s2){
        int s1Length = s1.length();
        int s2Length = s2.length();

        int[][] t = new int[s1Length+1][s2Length+1];

        for(int i=0;i<=s1Length;i++){
            for(int j=0;j<=s2Length;j++){
                if(i==0||j==0){
                    t[i][j] =0;
                    continue;
                }

                if(s1.charAt(i-1) == s2.charAt(j-1)) t[i][j] = 1 + t[i-1][j-1];
                else t[i][j] = Integer.max(t[i-1][j],t[i][j-1]);
            }
        }

        int lcs = t[s1Length][s2Length];
        int superSequenceLength = s1Length + s2Length - lcs;
        char[] superSequence = new char[superSequenceLength];

        int k =superSequenceLength-1;
        int i=s1Length;
        int j=s2Length;
        while (i>0 && j>0){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    superSequence[k] = s1.charAt(i-1);
                    k--;
                    i--;
                    j--;
                } else if(t[i-1][j] > t[i][j-1]){
                    superSequence[k] = s1.charAt(i-1);
                    i--;
                    k--;
                } else{
                    superSequence[k] = s2.charAt(j-1);
                    j--;
                    k--;
                }
        }

        while (i>0){
            superSequence[k] = s1.charAt(i-1);
            i--;
            k--;
        }

        while (j>0){
            superSequence[k] = s2.charAt(j-1);
            j--;
            k--;
        }

        for (char c : superSequence) {
            System.out.println(c);
        }


     }
}
