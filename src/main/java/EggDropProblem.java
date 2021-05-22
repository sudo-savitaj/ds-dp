//https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
public class EggDropProblem {
    int[][] cache;
    public void display() {
    }

    int minAttemptInWorstCase(int eggs,int floors){
        setupCache(eggs,floors);
        return solve(eggs,floors);
    }

    private void setupCache(int eggs, int floors) {
        cache = new int[eggs+1][floors+1];

        for(int i=0;i<=eggs;i++){
            for (int j=0;j<=floors;j++) cache[i][j] = -1;
        }
    }

    private int solve(int eggs, int floors) {
        if(eggs == 1) return floors;
        if(floors ==0 || floors ==1) return floors;

        if(cache[eggs][floors] != -1) return cache[eggs][floors];

        int minAttempt = Integer.MAX_VALUE;

        for (int k=1;k<=floors;k++){
            int minAttemptForKFloor = 1 + Integer.max(solve(eggs-1,k-1), solve(eggs,floors-k));

            if(minAttemptForKFloor < minAttempt) minAttempt = minAttemptForKFloor;
        }

        cache[eggs][floors] = minAttempt;
        return minAttempt;
    }
}
