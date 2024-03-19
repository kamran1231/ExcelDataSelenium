package ExcelPackage;

import java.io.IOException;
import java.util.ArrayList;

public class sampleData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DataDriven p = new DataDriven();
		ArrayList<String> data = p.getData("aisha");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));


	}

}
