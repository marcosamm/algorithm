package mamm.alg.datastructure.graph;

public class FloydWarshall {
	public static final int INF = Integer.MAX_VALUE;
	
	private Integer [][] d;
	private Integer [][] p;
	private boolean hasNegativeCycle;
	
	public FloydWarshall(Integer [][] w){
		hasNegativeCycle = false;
		int n = w.length;
		d = new Integer [n][n];
		p = new Integer [n][n];
		for(int i=0; i < n; i++){
			for(int j=0; j < n; j++){
				d[i][j] = w[i][j];
				if(d[i][j] < INF){
					if(i!=j){
						p[i][j] = i;
					}else{
						p[i][j] = null;
					}
				}
			}
		}
	}
	
	public boolean calc(){
		int n = d.length;
		for(int k=0; k < n; k++){
			for(int i=0; i < n; i++){
				for(int j=0; j < n; j++){
					int q = (d[i][k] == INF || d[k][j] == INF) ? INF : d[i][k] + d[k][j];
					if(d[i][j] > q){
						d[i][j] = q;
						p[i][j] = p[k][j];
					}
				}
			}
		}
		for(int i=0; i < n; i++){
			if(d[i][i] < 0){
				hasNegativeCycle = true;
				break;
			}
		}
		return hasNegativeCycle;
	}
	
	public String printAllPairShortestPath(int i, int j){
		StringBuilder sb = new StringBuilder();
		if(!hasNegativeCycle){
			if(i == j){
				sb.append(i);
			}else if(p[i][j] == null){
				sb.append("No path found from ").append(i).append(" to ").append(j);
			}else{
				sb.append(printAllPairShortestPath(i, p[i][j])).append(" ");
				sb.append(j);
			}
		}else{
			sb.append("Negative cycle detected");
		}
		return sb.toString().trim();
	}
	
	public String getStringMatrixD(){
		return getStringMatrix(d);
	}
	
	public String getStringMatrixP(){
		return getStringMatrix(p);
	}
	
	private static String getStringMatrix(Integer [][] m){
		StringBuilder sb = new StringBuilder();
		int n = m.length;
		for(int i=0; i < n; i++){
			for(int j=0; j < n; j++){
				if(m[i][j] == null){
					sb.append("NIL");
				}else if(m[i][j] == INF){
					sb.append("INF");
				}else{
					sb.append(m[i][j]);
				}
				if(j < m.length -1){
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public String getStringCheck(){
		StringBuilder sb = new StringBuilder();
		sb.append("D:\n");
		sb.append(getStringMatrixD());
		sb.append("\n");
		sb.append("P:\n");
		sb.append(getStringMatrixP());
		sb.append("\n");
		sb.append("SHORTEST PATHS:\n");
		if(!hasNegativeCycle){
			int n = p.length;
			for(int i=0; i < n; i++){
				for(int j=0; j < n; j++){
					sb.append(i).append("-").append(j).append(": ").append(printAllPairShortestPath(i, j)).append("\n");
				}
			}
		}else{
			sb.append("Negative cycle detected\n");
		}
		return sb.toString();
	}
}
