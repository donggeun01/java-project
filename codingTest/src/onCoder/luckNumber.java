package onCoder;

public class luckNumber {

	public static void main(String[] args) {
		String s = "123231";
		
		Solution str = new Solution();
		
		System.out.println(str.solution(s));
		
	}
	
	// 행운의 숫자
	static public class Solution{
	    public int solution(String s){
	        
	        int num; // 처음 ~ 중간 합
	        int num2; // 마지막 부터 중간 합
	        int len = 0; // 행운의 숫자의 길이
	        while(true) {
	        	// 길이 체크 후 맨 앞부터 절반에 까지 합 == 맨 뒤부터 중간까지 합
	        	for(int i = 0; i < s.length(); i++) {
	                int count = s.length() - i;
	                num = 0;
	                num2 = 0;
	                if(count % 2 == 0) {
	                    for(int j = 0; j < count/2; j++) {
	                        num += Integer.parseInt(s.substring(j, j+1));
	                    }
	                    for(int k = count/2; k < count; k++) {
	                        num2 += Integer.parseInt(s.substring(k, k+1));
	                    }
	                    if (s.length() > len) {
	                        if (num == num2) len = count; 
	                    }
	                }
	            }
	        	// 문자열 인덱스 증가
	            if (s.length() != 1) {
	               s = s.substring(1,s.length());
	            }
	            else break;
	        }
	        
	        
	        return len;
	    }
	}

}
