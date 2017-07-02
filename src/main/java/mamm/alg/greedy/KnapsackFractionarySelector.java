package mamm.alg.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

public class KnapsackFractionarySelector {
	@Getter
	@Setter
	@EqualsAndHashCode(callSuper=false, of={"label", "weight", "value"})
	static class Item implements Comparable<Item>{
		private String label;
		private Integer weight;
		private Float value;
		
		public Item(String label, Integer weight, Float value){
			this.label = label;
			this.weight = weight;
			this.value = value;
		}
		
		public Float getCostByWeight(){
			return value/weight;
		}

		@Override
		public int compareTo(Item o2) {
			return getCostByWeight().compareTo(o2.getCostByWeight());
		}
	}
	
	List<Item> itens = new ArrayList<>();
	List<Item> knapsack = new ArrayList<>();
	
	public KnapsackFractionarySelector(int [] w, Float [] v){
		if(w == null || v == null || w.length < 1 || w.length != v.length){
			throw new IllegalArgumentException("Incompatibles lengths");
		}
		for(int i=0; i < w.length; i++){
			itens.add(new Item(String.valueOf(i), w[i], v[i]));
		}
	}
	
	public Float fractionarySelector(int capacity){
		Collections.sort(itens, Collections.reverseOrder());
		knapsack.clear();
		return fractionarySelector(capacity, 0);
	}
	
	private Float fractionarySelector(int capacity, int i){
		if(capacity == 0){
			return 0f;
		}
		Item item = itens.get(i);
		Float v = 0f;
		if(item.getWeight() > capacity){
			Item itemPortion = new Item(item.getLabel(), capacity, capacity*item.getCostByWeight());
			knapsack.add(itemPortion);
			v = itemPortion.getValue();
		}else{
			knapsack.add(item);
			v = item.getValue() + fractionarySelector(capacity - item.getWeight(), i+1); 
		}
		return v;
	}
	
	public String getKnapsackString(){
		StringBuilder sb = new StringBuilder();
		float v = 0f;
		for (Item item : knapsack) {
			sb.append(item.getLabel()).append(": ")
			.append(item.getWeight()).append("kg x $")
			.append(item.getCostByWeight()).append(" = $")
			.append(item.getValue())
			.append("\n");
			v = v + item.getValue();
		}
		sb.append("Tot.: $").append(v);
		return sb.toString();
	}
}
