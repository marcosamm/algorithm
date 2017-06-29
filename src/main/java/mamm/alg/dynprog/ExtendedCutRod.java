package mamm.alg.dynprog;

public class ExtendedCutRod {
	private Float [] r;
	private int [] s;
	private Float [] p;
	
	public ExtendedCutRod(Float [] prices){
		p = prices.clone();
		r = new Float [p.length];
		s = new int [p.length];
	}
	
	public Float recursiveCutRod(int length){
		r = new Float[length+1];
		s = new int [length+1];
		for(int i=0; i <= length; i++){
			r[i] = Float.NEGATIVE_INFINITY;
			s[i] = 0;
		}
		return recursiveCutRodAux(length);
	}
	
	private Float recursiveCutRodAux(int length){
		Float q = 0f;
		if(r[length] > 0f){
			return r[length];
		}
		if(length == 0){
			q = 0f;
		}else{
			q = Float.NEGATIVE_INFINITY;
			for(int i=1; i <= length; i++){
				Float ql = p[i]+recursiveCutRodAux(length-i);
				if(q < ql){
					q = ql;
					s[length] = i;
				}
			}
			r[length] = q;
		}
		return q;
	}
	
	public Float bottomUpCutRod(int length){
		r = new Float[length+1];
		s = new int [length+1];
		for(int i=0; i <= length; i++){
			r[i] = Float.NEGATIVE_INFINITY;
			s[i] = 0;
		}
		r[0] = 0f;
		Float q;
		for(int j=1; j <= length; j++){
			q = Float.NEGATIVE_INFINITY;
			for(int i=1; i <= j; i++){
				Float ql = p[i] + r[j-i];
				if(q < ql){
					q = ql;
					s[j] = i;
				}
			}
			r[j] = q;
		}
		return r[length];
	}
	
	public String getRecursiveCutRodSolution(int length){
		recursiveCutRod(length);
		return getCutRodSolution(length);
	}
	
	public String getBottomUpCutRodSolution(int length){
		bottomUpCutRod(length);
		return getCutRodSolution(length);
	}
	
	public String getCutRodSolution(int length){
		StringBuilder sb = new StringBuilder();
		while(length > 0){
			sb.append(s[length]).append(" ");
			length = length - s[length];
		}
		return sb.toString().trim();
	}
}
