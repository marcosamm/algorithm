package mamm.alg.dynprog;

public class ExtendedMatrixChain {
	private int [][] m;
	private int [][] s;
	private int [] p;
	
	public ExtendedMatrixChain(int [] dimensions){
		p = dimensions.clone();
		int n = p.length;
		m = new int [n][n];
		s = new int [n][n];
		for(int i=0; i < n; i++){
			for(int j=0; j < n; j++){
				m[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	public int lookupChain(){
		return lookupChainAux(1, m.length-1);
	}
	
	private int lookupChainAux(int i, int j){
		if(m[i][j] < Integer.MAX_VALUE){
			return m[i][j];
		}
		if(i == j){
			m[i][j] = 0;
		}else{
			for(int k=i; k < j; k++){
				int q = lookupChainAux(i, k) + lookupChainAux(k+1, j) + p[i-1]*p[k]*p[j];
				if(q < m[i][j]){
					m[i][j] = q;
					s[i][j] = k;
				}
			}
		}
		return m[i][j];
	}
	
	public String getOptimalParents(){
		lookupChain();
		return getOptimalParents(1, m.length-1);
	}
	
	private String getOptimalParents(int i, int j){
		StringBuilder sb = new StringBuilder();
		if(i == j){
			sb.append("A").append(i);
		}else{
			sb.append("(");
			sb.append(getOptimalParents(i, s[i][j]));
			sb.append(" ");
			sb.append(getOptimalParents(s[i][j]+1, j));
			sb.append(")");
		}
		return sb.toString().trim();
	}
}
