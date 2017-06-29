package mamm.alg.dynprog;

public class LongestCommonSubsequence {
	private char [][] b;
	private int [][] c;
	private char[] x;
	private char [] y;
	
	public LongestCommonSubsequence(char[] x, char [] y){
		this.x = x.clone();
		this.y = y.clone();
		int m = x.length;
		int n = y.length;
		b = new char[m][n];
		c = new int[m+1][n+1];
	}
	
	private void lcsLenght(){
		int m = x.length;
		int n = y.length;
		for(int i=1; i <= m; i++){
			c[i][0] = 0;
		}
		for(int j=0; j <= n; j++){
			c[0][j] = 0;
		}
		for(int i=1; i <= m; i++){
			for(int j=1; j <= n; j++){
				if(x[i-1] == y[j-1]){
					c[i][j] = c[i-1][j-1]+1;
					b[i-1][j-1] = '\\';
				}else if(c[i-1][j] >= c[i][j-1]){
					c[i][j] = c[i-1][j];
					b[i-1][j-1] = '|';
				}else{
					c[i][j] = c[i][j-1];
					b[i-1][j-1] = '<';
				}
			}
		}
	}
	
	public String getLcs(){
		lcsLenght();
		StringBuilder sb = new StringBuilder();
		printLcs(x.length, y.length, sb);
		return sb.toString();
	}
	
	private void printLcs(int i, int j, StringBuilder sb){
		if(i == 0 || j == 0){
			return;
		}
		if(b[i-1][j-1] == '\\'){
			printLcs(i-1, j-1, sb);
			sb.append(x[i-1]);
		}else if(b[i-1][j-1] == '|'){
			printLcs(i-1, j, sb);
		}else{
			printLcs(i, j-1, sb);
		}
	}
}
