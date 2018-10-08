import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class B1_A2 {

	private static final String FILENAME = "filename.txt";
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		try {
			while( (line = br.readLine())!=null){
				if (line.equals("")) {
					writeList(list);
					System.exit(0); 
				} else {
					list.add(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String getDate() {
		Date date = new Date();
		return sdf.format(date);
	}
	
	private static void writeList(LinkedList<String> list) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			
			for (int i=0; i<list.size(); i++) {
				bw.write(Integer.toString(i)+" "+list.get(i)+"\n");
			}
			
			System.out.println("Zugriff aufgezeichnet am " + getDate() + "!");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}
}