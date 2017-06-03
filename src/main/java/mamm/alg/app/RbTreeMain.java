package mamm.alg.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class RbTreeMain {

	public static void main(String[] args) throws IOException {
		if(args.length > 1){
			RbTree rb = new RbTree();
			File inputFile = new File(args[0]);
			if(inputFile.exists()){
				rb.process(inputFile.toPath());
			}else{
				System.out.println("Input file not found: " + args[0]);
			}
			
			if(args.length > 2){
				File outputFile = new File(args[1]);
				if(outputFile.exists()){
					String output = String.join("\n", Files.readAllLines(outputFile.toPath()));
					if(rb.getStringCheck().equals(output)){
						System.out.println("Input compatible with output");
					}else{
						System.out.println("Input incompatible with output");
					} 
				}else{
					System.out.println("Output file not found: " + args[1]);
				}
			}
			Scanner scanner = new Scanner(System.in);
			boolean exit = false;
			do{
				System.out.print("Enter a word to search or 'EXIT' to exit: ");
				String word = scanner.nextLine();
				if(!word.equals("EXIT")){
					rb.rbSearch(word);
				}
			}while(!exit);
			scanner.close();
		}else{
			System.out.println("Try 'java -jar algorithm-${version}.jar dicionary_input_file.txt [dicionary_output_file.txt]'");
		}
	}
}
