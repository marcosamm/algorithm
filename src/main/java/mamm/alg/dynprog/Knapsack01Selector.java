package mamm.alg.dynprog;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Knapsack01Selector {
	@Getter
	@Setter
	static class Item {
		private String label;
		private Integer weight;
		private Float value;
		
		public Item(String label, Integer weight, Float value){
			this.label = label;
			this.weight = weight;
			this.value = value;
		}
	}
	
	List<Item> itens = new ArrayList<>();
	int capacity;
	int [][] w;
	float [][] c;
	
	public Knapsack01Selector(int [] weights, Float [] values, int capacity){
		if(weights == null || values == null || weights.length < 1 || weights.length != values.length){
			throw new IllegalArgumentException("Incompatibles lengths");
		}
		this.capacity = capacity;
		for(int i=0; i < weights.length; i++){
			itens.add(new Item(String.valueOf(i), weights[i], values[i]));
		}
		c = new float[itens.size()+1][capacity+1];
		w = new int[itens.size()+1][capacity+1];
		for(int i = 0; i <= itens.size(); i++){
			for(int j = 0; j <= capacity; j++){
				w[i][j] = -1;
			}
		}
	}
	
	public Float select(){
		for(int i=1; i <= itens.size(); i++){
			Item it = itens.get(i-1);
			for(int k=0; k <= capacity; k++){
				if(it.getWeight() > k){
					c[i][k] = c[i-1][k];
					w[i][k] = w[i-1][k];
				}else{
					int free = k-it.getWeight();
					Float q = it.getValue() + c[i-1][free];
					if(c[i][k] < q){
						c[i][k] = q;
						w[i][k] = i-1;
					}
				}
			}
		}
		return c[itens.size()][capacity];
	}
	
	public String getKnapsackString(){
		Float tot = select();
		StringBuilder sb = new StringBuilder();
		int i = itens.size();
		int j = capacity;
		while(w[i][j] > -1){
			Item item = itens.get(w[i][j]);
			sb.append(item.getLabel()).append(": ")
			.append(item.getWeight()).append("kg - $")
			.append(item.getValue())
			.append("\n");
			j = j - item.getWeight();
			i = i -1;
		}
		sb.append("Tot.: $").append(tot);
		return sb.toString().trim();
	}
}
