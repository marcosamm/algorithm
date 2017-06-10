package mamm.alg.search;

import lombok.Getter;

public class MaxSubarray {
	@Getter
	static class MaxCrossingValues{
		private int maxLeft;
		private int maxRight;
		private int sum;
		
		public MaxCrossingValues(int maxLeft, int maxRight, int sum) {
			this.maxLeft = maxLeft;
			this.maxRight = maxRight;
			this.sum = sum;
		}
	}
	
	private MaxCrossingValues findMaxCrossingSubarray(Integer[] a, int low, int mid, int high){
		Integer sum = 0;
		
		Integer leftSum = Integer.MIN_VALUE;
		int maxLeft = 0;
		for(int i=mid; i >= low; i--){
			sum = sum + a[i];
			if(sum > leftSum){
				leftSum = sum;
				maxLeft = i;
			}
		}
		
		sum = 0;
		Integer rightSum = Integer.MIN_VALUE;
		int maxRight = 0;
		for(int j=mid+1; j <= high; j++){
			sum = sum + a[j];
			if(sum > rightSum){
				rightSum = sum;
				maxRight = j;
			}
		}
		
		return new MaxCrossingValues(maxLeft, maxRight, leftSum + rightSum);
	}
	
	private MaxCrossingValues findMaximumSubarrayRecursive(Integer[] a, int low, int high){
		MaxCrossingValues ret = null;
		if(high == low){
			ret = new MaxCrossingValues(low, high, a[low]);
		}else{
			int mid = (int) ((low + high)/2);
			MaxCrossingValues left = findMaximumSubarrayRecursive(a, low, mid);
			MaxCrossingValues right = findMaximumSubarrayRecursive(a, mid+1, high);
			MaxCrossingValues cross = findMaxCrossingSubarray(a, low, mid, high);
			if(left.getSum() >= right.getSum() && left.getSum() >= cross.getSum()){
				ret = left;
			} else if(right.getSum() >= left.getSum() && right.getSum() >= cross.getSum()){
				ret = right;
			}else{
				ret = cross;
			}
		}
		return ret;
	}
	
	public MaxCrossingValues findMaximumSubarrayRecursive(Integer[] a){
		if(a == null || a.length == 0){
			throw new IllegalArgumentException("a.lenght == 0 or a == null");
		}
		return findMaximumSubarrayRecursive(a, 0, a.length-1);
	}
	
	public MaxCrossingValues findMaximumSubarrayLinear(Integer[] a){
		if(a == null || a.length == 0){
			throw new IllegalArgumentException("a.lenght == 0 or a == null");
		}
		
		int tStart = 0;
		int startPos = 0;
		int endPos = 0;
		int somaAtual = 0;
		int maxSum = 0;
		
		for (int i=0; i < a.length; i++){
			somaAtual = somaAtual + a[i];
			if (a[i] > somaAtual){
				somaAtual = a[i];
				tStart = i;
			}
			if (somaAtual > maxSum){
				maxSum = somaAtual;
				startPos = tStart;
				endPos = i;
			}
		}
		return new MaxCrossingValues(startPos, endPos, maxSum);
	}
}
