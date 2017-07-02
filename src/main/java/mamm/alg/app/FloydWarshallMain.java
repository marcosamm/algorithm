package mamm.alg.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FloydWarshallMain {

	public static void main(String[] args) throws IOException {
		if(args.length > 0){
			FloydWarshallApp app = new FloydWarshallApp();
			File inputFile = new File(args[0]);
			if(inputFile.exists()){
				app.process(inputFile.toPath());
			}else{
				System.out.println("Input file not found: " + args[0]);
				System.exit(-1);
			}
			
			if(args.length > 1){
				File outputFile = new File(args[1]);
				if(outputFile.exists()){
					String output = String.join("\n", Files.readAllLines(outputFile.toPath()));
					if(app.getStringCheck().trim().equals(output.trim())){
						System.out.println("Input compatible with output");
					}else{
						System.out.println("Input incompatible with output");
					} 
				}else{
					System.out.println("Output file not found: " + args[1]);
				}
			}
			System.out.println(app.getStringCheck());
			Scanner scanner = new Scanner(System.in, "UTF-8");
			boolean exit = false;
			do{
				StringBuilder sb = new StringBuilder();
				sb.append("Choose an option:\n");
				sb.append("1 - print matrix D\n");
				sb.append("2 - print matrix P\n");
				sb.append("3 - print minimum path between vertices\n");
				sb.append("4 - print all\n");
				sb.append("5 - EXIT\n");
				System.out.println(sb.toString());
				try{
					int option = scanner.nextInt();
					switch (option) {
						case 1:
							System.out.println("D:\n"+app.getMatrixD());
							break;
						case 2:
							System.out.println("P:\n"+app.getMatrixP());
							break;
						case 3:
							try{
								System.out.print("Enter the starting vertex (0 to "+(app.getQtdVertices()-1)+"): ");
								int s = scanner.nextInt();
								System.out.print("digite o destination de destino (0 to "+(app.getQtdVertices()-1)+"): ");
								int d = scanner.nextInt();
								System.out.println("SHORTEST PATH "+s+"-"+d+": "+app.getShortestPath(s, d));
							}catch (Exception e){
								System.out.println("Illegal arguments. Try again.\n");
							}
							break;
						case 4:
							System.out.println(app.getStringCheck());
							break;
						case 5:
							exit = true;
							break;
						default:
							System.out.println("Invalid option. Try again.");
							break;
					}
				}catch(InputMismatchException e){
					System.out.println("Illegal argument. Exiting...\n");
					System.exit(-1);
				}
			}while(!exit);
			scanner.close();
		}else{
			System.out.println("Try 'java -jar algorithm-${version}.jar graph_input_file.txt [graph_output_file.txt]'");
		}
	}
}
