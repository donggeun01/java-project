package onCoder;
import java.util.*;
public class contest {

	public static void main(String[] args) {
		int[] sco = {200,10,18,17,120,42,543};
		
		Solution s = new Solution();
		System.out.println(s.solution(sco));
	}
	
	static public class Solution{
	    public double solution(int[] scores){
	        
	        double sum = 0;
	        ArrayList list = new ArrayList();
	         for(double i : scores) {
	             list.add(i);
	         }
	         
	         // 정렬
	         Collections.sort(list);
	         
	         // 중복 제거
	         if(list.size() > 1) { 
	             for (int j = 0; j < list.size(); j++) {
	                 for(int i = 0; i < list.size(); i++) {
	                     if(i == j) continue;
	                     
	                     else if (list.get(j).equals(list.get(i))) {
	                         list.remove(i);
	                         i--;
	                     }
	                 }
	             } 
	         }
	         
	         // 1개 리턴
	         if(list.size() == 1) {
	             sum = (double)list.get(0);
	             return sum;
	         }
	         
	         
	         // 최대값 최솟값 삭제
	         if (list.size() >= 3) {
	            list.remove(0);
	            list.remove(list.size()-1);
	         }
	         
	         // 값 합산
	         for(int i = 0; i < list.size(); i++) {
	              sum += (double)list.get(i);
	         }
	        
	        // 평균값 
	        sum = sum / list.size();
	    
	        
	        
	        return sum;
	    }
	}
	
}
	
	
	
	