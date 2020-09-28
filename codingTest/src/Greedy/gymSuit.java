package Greedy;
import java.util.*;
public class gymSuit {
	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	       ArrayList student = new ArrayList<Integer>();
			ArrayList removelost = new ArrayList<Integer>();
			
			int answer = 0, count = 0;
		

			// 여벌을 가져온 학생 student에 복사
			for(int temp : reserve){
				student.add(temp);
			}
			// 도난 당한 학생 복사
			for(int temp : lost){
				removelost.add(temp);
			}
			 
			// 여벌을 가져온 학생 중 도난당한 학생 제외, 도난당한 학생중 여벌있는 학생 제외
			for(int i = 0; i < student.size(); i++) {
				for(int j = 0; j < removelost.size(); j++) {
					if(student.get(i).equals(removelost.get(j))) {
						student.remove(i);
						removelost.remove(j);
	                    i--;
						break;
					}
				}
			}
			
			// 여별 옷 나눠주기
			for (int i = 0; i < student.size(); i++) {
				for(int j = 0; j < removelost.size(); j++) {
					if ((int)removelost.get(j) == ((int)student.get(i) - 1)) {
						removelost.remove(j);
						break;
					}
					else if ((int)removelost.get(j) == ((int)student.get(i) +1)) {
						removelost.remove(j);
						break;
					}
				}
			}
			
			answer = n - removelost.size();
			

			return answer;
	    }
	}

}
