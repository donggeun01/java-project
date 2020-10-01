package Dynamic;
import java.util.*;
public class N_print {
	
	static class Solution {
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		ArrayList<Integer> childList = new ArrayList<>();
	    int[][] d = new int[9][];
	    public int solution(int N, int number) {
	        int answer = -1;
	        if(N==number) return 1;
	        for(int i = 0; i < d.length; i++) {
	            d[i][0] = Integer.parseInt(Integer.toString(N*(i+1)));
	        }
	        
	        for(int i = 1; i < 9; i++) {
	            int count = 1;
	            for(int j = 0; j < i; j++) {
	                for(int num : d[j]) {
	                    for(int num2 : d[i-j-1]) {
	                        d[i][count++] = num + num2;
	                        d[i][count++] = num - num2;
	                        d[i][count++] = num * num2;
	                        d[i][count++] = num / num2;               
	                        for(int c = 0; c < d[i].length; c++) {
	                            if (number == d[i][c]) {
	                                return i+1;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        
	        return answer;
	    }
	}
	
	public static void main(String args[]) {
		Solution s = new Solution();
		s.solution(5, 12);
	}

}