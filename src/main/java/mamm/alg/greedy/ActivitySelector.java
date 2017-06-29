package mamm.alg.greedy;

public class ActivitySelector {
	//Start times
	private int [] s;
	//Finish times
	private int [] f;
	
	public ActivitySelector(int [] s, int [] f){
		if(s == null || f == null || s.length < 1 || s.length != f.length){
			throw new IllegalArgumentException("Incompatibles lengths");
		}
		int length = s.length+1;
		this.s = new int [length];
		this.f = new int [length];
		this.s[0] = 0;
		this.f[0] = 0;
		for(int i=1; i < length; i++){
			this.s[i] = s[i-1];
			this.f[i] = f[i-1];
		}
	}
	
	public String recursiveActivitySelector(){
		return recursiveActivitySelector(0, s.length-1);
	}
	
	private String recursiveActivitySelector(int k, int n){
		int m = k + 1;
		while (m <= n && s[m] < f[k]){//find the first activity in Sk to finish
			m = m + 1;
		}
		String A = "";
		if(m <= n){
			A = "A"+m+" "+recursiveActivitySelector(m, n);
		}
		return A.trim();
	}
	
	public String iterativeActivitySelector(){
		int n = s.length;
		String A = "A1";
		int k = 1;
		for(int m = 2; m < n; m++){
			if(s[m] >= f[k]){
				A = A + " A"+m;
				k = m;
			}
		}
		return A;
	}
}
