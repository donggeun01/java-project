package exhaustive;

public class carpet {
	
	class Solution {
	    public int[] solution(int brown, int yellow) {
	    int[] bro = new int[brown + 1]; // 10번 배열
	        int[] yel = new int[yellow + 1];    // 2번 배열
	        int[] answer = new int[2];   // 가로세로 배열 생성  
	        
	        // 갈색격자 배치
	        for(int i = 3; i < bro.length; i++) {   // 세로 길이 i, 가로길이 bro[i]
	            int j = (i-2)*2;
	            if((brown-j) % 2 == 0) bro[i] = (brown - j) / 2;
	        }
	    
	        // 노란색 격자 배치
	        for(int i = 1; i < yel.length; i++) {
	            if(yellow % i == 0) yel[i] = yellow / i;
	        }

	        for(int i = 3; i < bro.length; i++) {
	           int j = i - 2;
	            if(bro[i] >= i) {
	               if(yel[j] + 2 == bro[i]) {
	                    answer[0] = bro[i];
	                    answer[1] = i;
	            }

	           } 

	        } 
	        return answer;
	    }
	}

}
