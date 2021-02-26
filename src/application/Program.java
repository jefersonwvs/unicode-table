package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {

		String path = "unicode-table.txt";
		
		try {
			File file = new File(path);
			file.delete();
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0x0; i < 0x10000; i++) { // 0 - 65535
				String str = String.format("U+%04X (%05d)\t\t%c", i, i, (char)i);
				System.out.println(str);
				bw.append(str);
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.err.print(e.getMessage());
		}
	}

}
