package Greedy;
import java.util.*;
public class gymSuit {
	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	       ArrayList student = new ArrayList<Integer>();
			ArrayList removelost = new ArrayList<Integer>();
			
			int answer = 0, count = 0;
		

			// ������ ������ �л� student�� ����
			for(int temp : reserve){
				student.add(temp);
			}
			// ���� ���� �л� ����
			for(int temp : lost){
				removelost.add(temp);
			}
			 
			// ������ ������ �л� �� �������� �л� ����, �������� �л��� �����ִ� �л� ����
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
			
			// ���� �� �����ֱ�
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
