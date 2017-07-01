package mamm.alg.app;

import static mamm.alg.datastructure.graph.FloydWarshall.INF;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import mamm.alg.datastructure.graph.FloydWarshall;

public class FloydWarshallApp {
	FloydWarshall floydWarshall;
	
	public void process(Path pathFile) throws IOException {
		int n = 0;
		Integer [][] w = null;
		
		List<String> lines = Files.readAllLines(pathFile);
		try{
			n = Integer.parseInt(lines.get(0));
			w = new Integer[n][n];
			
			lines.remove(lines.get(0));
			if(lines.size() == 1 || lines.size() == 2){
				//All weights in one line
				String [] weights = lines.get(0).split(" ");
				if(weights.length == n*n){
					int i = 0;
					int j = 0;
					for (String weight : weights) {
						if(weight.equals("INF")){
							w[i][j] = INF;
						}else{
							w[i][j] = Integer.parseInt(weight);
						}
						if(j < n-1){
							j++;
						}else{
							j = 0;
							i++;
						}
					}
				}else{
					throw new IOException("Number of weights incompatible with the number of vertices reported in the first line of the file");
				}
			}else{
				//weights in n lines with n numbers
				if(lines.size() == n){
					for (int i=0; i < n ; i++) {
						String line = lines.get(i);
						if(!line.isEmpty()){
							String [] weights = line.split(" ");
							if(weights.length == n){
								for(int j=0; j < n; j++){
									String weight = weights[j];
									if(weight.equals("INF")){
										w[i][j] = INF;
									}else{
										w[i][j] = Integer.parseInt(weight);
									}
								}
							}else{
								throw new IOException("Number of columns incompatible with number of vertices reported on the first line");
							}
						}
					}
				}else{
					throw new IOException("Number of rows incompatible with number of vertices reported on the first line");
				}
			}
		}catch(Exception e){
			throw new IOException("The first line must be a positive integer");
		}
		floydWarshall = new FloydWarshall(w);
		floydWarshall.calc();
	}
	
	public String getMatrixD(){
		return floydWarshall.getStringMatrixD();
	}
	
	public String getMatrixP(){
		return floydWarshall.getStringMatrixP();
	}
	
	public String getShortestPath(int i, int j){
		return floydWarshall.printAllPairShortestPath(i, j);
	}
	
	public String getStringCheck(){
		return floydWarshall.getStringCheck();
	}
	
	public void process(String fileName) throws IOException{
		process(new File(fileName).toPath());
	}
}
