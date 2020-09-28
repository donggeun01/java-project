package hash;
import java.util.*;
public class tell {
	
	class Solution {
	     public boolean solution(String[] phone_book) {
		    	boolean answer = true;
		        
		        HashMap<String, Boolean> map = new HashMap<>();
		        
		        for (String phone : phone_book) {
		        	map.put(phone, true);
		        	for(String check : phone_book) {
		        		
			        	if (map.get(phone).equals(false)) continue;	
			        		
			        	else if (!phone.equals(check)) {
			        			if (check.indexOf(phone) == 0) {
			        				answer = false;
			        			}
			        		}
		        		
		        	}
	                if(answer == false) {
			        		break;
			        	}
		        }
		        
		        return answer;
		    }
	}

}
