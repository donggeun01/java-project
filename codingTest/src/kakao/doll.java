package kakao;

public class doll {
	
	
	    
		static int count = 0;
	    public int solution(int[][] board, int[] moves) {
	        
			int[] temp = new int[1000];
			int k = 0;
			for (int i = 0; i < moves.length; i++) {
				
				for (int j = 0; j < board.length; j++) {
						
						
						if (board[j][moves[i]-1] != 0) {
						temp[k] = board[j][moves[i]-1];	
						board[j][moves[i]-1] = 0;

						
						if (k != 0) {
						if (temp[k] == temp[k-1]) {
								temp[k] = 0;
								temp[k-1] = 0;
								k--;
								count++;
								break;
							}
						
						}
						k++;
						break;
					}
				}
			}
			
			
			int answer = count *2;
			
			return answer;
	    }
	

}
