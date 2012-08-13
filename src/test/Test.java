package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import th.databeans.clinical.Patient;

public class Test {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		String path = "/Users/shijinliang/Desktop/CSE601/Project1/Data_For_Project1/patient.txt";
		Scanner in = new Scanner(new File(path));
		String schema = in.nextLine();
		System.out.println(schema);
		while(in.hasNext()){
			Patient test = new Patient();
			String line = in.nextLine();
			test.setP_id(line.split("	")[0]);
			test.setSsn(line.split("	")[1]);
			test.setName(line.split("	")[2]);
			test.setGender(line.split("	")[3]);
			
			SimpleDateFormat formatter = null;
			formatter = new SimpleDateFormat("yyyy-mm-dd");
			
			Date date = new Date(formatter.parse(line.split("	")[4]).getTime());
			test.setDob(date);
			System.out.println(test.toInsertStat());
			//System.out.println(in.nextLine());
		}
	}

}
