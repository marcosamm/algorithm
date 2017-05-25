package mamm.alg.app;

import java.io.File;
import java.io.IOException;

public class RbTreeMain {

	public static void main(String[] args) throws IOException {
		File file = null;
		if(args.length > 0){
			file = new File(args[0]);
		}
		
		if(file.exists()){
			RbTree rb = new RbTree();
			rb.process(file.toPath());
		}else{
			System.out.println("File not found");
		}
	}
}
