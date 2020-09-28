package exhaustive;

public class carpet {
	
	class Solution {
	    public int[] solution(int brown, int yellow) {
	    int[] bro = new int[brown + 1]; // 10�� �迭
	        int[] yel = new int[yellow + 1];    // 2�� �迭
	        int[] answer = new int[2];   // ���μ��� �迭 ����  
	        
	        // �������� ��ġ
	        for(int i = 3; i < bro.length; i++) {   // ���� ���� i, ���α��� bro[i]
	            int j = (i-2)*2;
	            if((brown-j) % 2 == 0) bro[i] = (brown - j) / 2;
	        }
	    
	        // ����� ���� ��ġ
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
