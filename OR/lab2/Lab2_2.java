import java.util.*;

public class Lab2_2 {
    public static void main(String[] args) {
        int[] tasks = {10, 20, 30}; // Task durations
        int numCombinations = 8; // 2^3 combinations

        int minMaxTime = Integer.MAX_VALUE;
        String bestCombination = "";

        for (int i = 0; i < numCombinations; i++) {
            String binary = String.format("%3s", Integer.toBinaryString(i)).replace(' ', '0');
            int server1 = 0, server2 = 0;

            for (int j = 0; j < 3; j++) {
                if (binary.charAt(j) == '0')
                    server1 += tasks[j];
                else
                    server2 += tasks[j];
            }

            int maxTime = Math.max(server1, server2);

            if (maxTime < minMaxTime) {
                minMaxTime = maxTime;
                bestCombination = binary;
            }
        }

        System.out.println("Optimal Assignment (0 = Server1, 1 = Server2): " + bestCombination);
        System.out.println("Minimum Completion Time: " + minMaxTime + " minutes");
    }
}