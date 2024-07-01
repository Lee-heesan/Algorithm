class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
       int nowHealth = health;
		int winStreak = 0;
		int attackPoint = 0;
		
		for(int i =1 ; i<=attacks[attacks.length-1][0]; i++) {
			
			if(attacks[attackPoint][0]==i) {
				nowHealth -= attacks[attackPoint][1];
				attackPoint++;
				winStreak = 0;
				if(nowHealth<=0) {
					nowHealth=-1;
					break;
				}
				continue;
			}else {
				nowHealth +=bandage[1];	
				winStreak++;
				if(winStreak==bandage[0]) {
					nowHealth +=bandage[2];
					winStreak = 0;
				}
				if(nowHealth>health) {
					nowHealth = health;
				}
			}
		}
		return nowHealth;
    }
}