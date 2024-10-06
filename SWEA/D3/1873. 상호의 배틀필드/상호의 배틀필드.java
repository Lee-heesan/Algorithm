import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution
{	
    static String [][] map;
	static int [] Now;
	static int H,W;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ; 
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=T; i++) {
			st= new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new String[H][W];
			
			//0 :세로 1: 가로
			Now = new int[2]; 
			
			for(int j=0; j<H;j++) {
				String str = br.readLine();
				
				// 현위치 찾기
				if(str.contains("^")) {
					Now[0]=j;
					Now[1]=str.indexOf("^");
				}else if(str.contains("v")) {
					Now[0]=j;
					Now[1]=str.indexOf("v");
				}else if(str.contains("<")) {
					Now[0]=j;
					Now[1]=str.indexOf("<");
				}else if(str.contains(">")) {
					Now[0]=j;
					Now[1]=str.indexOf(">");
				}
				
				map[j] = str.split("");
			}
			
			int N = Integer.parseInt(br.readLine());
			String []howDo = br.readLine().split("");
			
			for(int j=0; j<howDo.length; j++) {
				if(howDo[j].equals("S")){
					shoot();
//					System.out.println(howDo[j]+" "+Now[0]+" "+Now[1]);
//					for(int e=0; e<H;e++) {
//						for(int k=0; k<W; k++) {
//							System.out.print(map[e][k]);
//						}
//						System.out.print("\n");
//					}
//					System.out.print("\n");
					continue;
				}
			    move(howDo[j]);
				
//				System.out.println(howDo[j]+" "+Now[0]+" "+Now[1]);
//				for(int e=0; e<H;e++) {
//					for(int k=0; k<W; k++) {
//						System.out.print(map[e][k]);
//					}
//					System.out.print("\n");
//				}
//				System.out.print("\n");
			}
			
			sb.append("#").append(i).append(" ");
		
			for(int j=0; j<H;j++) {
				for(int k=0; k<W; k++) {
					sb.append(map[j][k]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	
	 public static void move(String command) {
		 switch (command) {
         case "U":
             if (Now[0] - 1 >= 0 && map[Now[0] - 1][Now[1]].equals(".")) {
                 map[Now[0]][Now[1]] = ".";
                 map[Now[0] - 1][Now[1]] = "^";
                 Now[0] = Now[0] - 1;
             } else {
                 map[Now[0]][Now[1]] = "^";
             }
             break;
         case "D":
             if (Now[0] + 1 < H && map[Now[0] + 1][Now[1]].equals(".")) {
                 map[Now[0]][Now[1]] = ".";
                 map[Now[0] + 1][Now[1]] = "v";
                 Now[0] = Now[0] + 1;
             } else {
                 map[Now[0]][Now[1]] = "v";
             }
             break;
         case "L":
             if (Now[1] - 1 >= 0 && map[Now[0]][Now[1] - 1].equals(".")) {
                 map[Now[0]][Now[1]] = ".";
                 map[Now[0]][Now[1] - 1] = "<";
                 Now[1] = Now[1] - 1;
             } else {
                 map[Now[0]][Now[1]] = "<";
             }
             break;
         case "R":
             if (Now[1] + 1 < W && map[Now[0]][Now[1] + 1].equals(".")) {
                 map[Now[0]][Now[1]] = ".";
                 map[Now[0]][Now[1] + 1] = ">";
                 Now[1] = Now[1] + 1;
             } else {
                 map[Now[0]][Now[1]] = ">";
             }
             break;
     }
	 }
	
	public static void shoot() {
		if(map[Now[0]][Now[1]].equals("^")) {
			int tmpUp = Now[0]-1;
			while(tmpUp>=0) {
				if(map[tmpUp][Now[1]].equals("#")) {
					break;
				}else if(map[tmpUp][Now[1]].equals("*")){
					map[tmpUp][Now[1]]=".";
					break;
				}
				tmpUp--;
			}
		}
		if(map[Now[0]][Now[1]].equals("v")) {
			int tmpDown = Now[0]+1;
			while(tmpDown<H) {
				if(map[tmpDown][Now[1]].equals("#")) {
					break;
				}else if(map[tmpDown][Now[1]].equals("*")){
					map[tmpDown][Now[1]]=".";
					break;
				}
				tmpDown++;
			}
		}
		if(map[Now[0]][Now[1]].equals("<")) {
			int tmpLeft = Now[1]-1;
			while(tmpLeft>=0) {
				if(map[Now[0]][tmpLeft].equals("#")) {
					break;
				}else if(map[Now[0]][tmpLeft].equals("*")){
					map[Now[0]][tmpLeft]=".";
					break;
				}
				tmpLeft--;
			}
		}
		if(map[Now[0]][Now[1]].equals(">")) {
			int tmpRigth = Now[1]+1;
			while(tmpRigth<W) {
				if(map[Now[0]][tmpRigth].equals("#")) {
					break;
				}else if(map[Now[0]][tmpRigth].equals("*")){
					map[Now[0]][tmpRigth]=".";
					break;
				}
				tmpRigth++;
			}
		}
	}

}
