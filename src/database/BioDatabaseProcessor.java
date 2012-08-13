package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Vector;

import javax.xml.validation.Schema;

import com.mysql.jdbc.Statement;

import th.databeans.clinical.*;
import th.databeans.experiment.*;
import th.databeans.gene.*;
import th.databeans.microarrayandproteomic.*;
import th.databeans.sample.*;

public class BioDatabaseProcessor {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws FileNotFoundException, SQLException, ParseException {
		//Build database Connection
		SQLConnector db = new SQLConnector();
		java.sql.Statement st = db.conn.createStatement();
		
		String dataFolderPath = 
			"/Users/shijinliang/Desktop/CSE601/Project1/Data_For_Project1";
		File file = new File(dataFolderPath);
		String[] list = file.list();
		
		Vector<String> fileList = new Vector<String>();
		for(int i = 0; i < list.length; i++){
			//if (!list[i].contains("fact")) {
				if(!list[i].contains("README")){
					fileList.add(list[i]);
				}
			//}
		}
		for(int i = 0; i < fileList.size(); i++){
			//System.out.println("System.out.println(\"========" + fileList.get(i) + "========\");");
			fileList.set(i, dataFolderPath + "/" + fileList.get(i));
			System.out.println(fileList.get(i));
		}
		
		Scanner in;
		String schema;
		
		SimpleDateFormat formatter = null;
		formatter = new SimpleDateFormat("yyyy-mm-dd");
		//Assay.txt
		System.out.println("========Assay========");
		in = new Scanner(new File(fileList.get(0)));
		schema = in.nextLine();
		while(in.hasNext()){
			Assay test = new Assay();
			String line = in.nextLine();
			test.setAs_id(line.split("	")[0]);
			test.setName(line.split("	")[1]);
			test.setType(line.split("	")[2]);
			test.setSetting(line.split("	")[3]);
			test.setDescription(line.split("	")[4]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Cluster.txt
		System.out.println("========Cluster========");
		in = new Scanner(new File(fileList.get(2)));
		schema = in.nextLine();
		while(in.hasNext()){
			Cluster test = new Cluster();
			String line = in.nextLine();
			test.setCl_id(line.split("	")[0]);
			test.setNum(line.split("	")[1]);
			test.setPattern(line.split("	")[2]);
			test.setTool(line.split("	")[3]);
			test.settSetting(line.split("	")[4]);
			test.setDescription(line.split("	")[5]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Disease.txt
		System.out.println("========Disease========");
		in = new Scanner(new File(fileList.get(3)));
		schema = in.nextLine();
		while(in.hasNext()){
			Disease test = new Disease();
			String line = in.nextLine();
			test.setDs_id(line.split("	")[0]);
			test.setName(line.split("	")[1]);
			test.setType(line.split("	")[2]);
			test.setDescription(line.split("	")[3]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Domain.txt
		System.out.println("========Domain========");
		in = new Scanner(new File(fileList.get(4)));
		schema = in.nextLine();
		while(in.hasNext()){
			Domain test = new Domain();
			String line = in.nextLine();
			test.setDm_id(line.split("	")[0]);
			test.setType(line.split("	")[1]);
			test.setDb(line.split("	")[2]);
			test.setAccession(line.split("	")[3]);
			test.setTitle(line.split("	")[4]);
			test.setLength(Integer.parseInt(line.split("	")[5]));
			test.setDescription(line.split("	")[6]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Drug.txt
		System.out.println("========drug.txt========");
		in = new Scanner(new File(fileList.get(5)));
		schema = in.nextLine();
		while(in.hasNext()){
			Drug test = new Drug();
			String line = in.nextLine();
			test.setDr_id(line.split("	")[0]);
			test.setName(line.split("	")[1]);
			test.setType(line.split("	")[2]);
			test.setDescription(line.split("	")[3]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Experiment.txt
		System.out.println("========experiment.txt========");
		in = new Scanner(new File(fileList.get(6)));
		schema = in.nextLine();
		while(in.hasNext()){
			Experiment test = new Experiment();
			String line = in.nextLine();
			test.setE_id(line.split("	")[0]);
			test.setName(line.split("	")[1]);
			test.setType(line.split("	")[2]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Gene.txt		
		System.out.println("========gene.txt========");
		in = new Scanner(new File(fileList.get(8)));
		schema = in.nextLine();
		while(in.hasNext()){
			Gene test = new Gene();
			String line = in.nextLine();
			test.setUID(line.split("	")[0]);
			test.setSeqType(line.split("	")[1]);
			test.setAccession(line.split("	")[2]);
			test.setVersion(line.split("	")[3]);
			test.setSeqDataset(line.split("	")[4]);
			test.setSpeciesID(line.split("	")[5]);
			test.setStatus(line.split("	")[6]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Go.txt
		System.out.println("========go.txt========");
		in = new Scanner(new File(fileList.get(10)));
		schema = in.nextLine();
		while(in.hasNext()){
			Go test = new Go();
			String line = in.nextLine();
			test.setGo_id(line.split("	")[0]);
			test.setAccession(line.split("	")[1]);
			test.setType(line.split("	")[2]);
			test.setName(line.split("	")[3]);
			test.setDefinition(line.split("	")[4]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Marker.txt
		System.out.println("========marker.txt========");
		in = new Scanner(new File(fileList.get(11)));
		schema = in.nextLine();
		while(in.hasNext()){
			Marker test = new Marker();
			String line = in.nextLine();
			test.setMk_id(line.split("	")[0]);
			test.setName(line.split("	")[1]);
			test.setType(line.split("	")[2]);
			test.setLocus(line.split("	")[3]);
			test.setDescription(line.split("	")[4]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//MeasureUnit.txt
		System.out.println("========measureUnit.txt========");
		in = new Scanner(new File(fileList.get(12)));
		schema = in.nextLine();
		while(in.hasNext()){
			MeasureUnit test = new MeasureUnit();
			String line = in.nextLine();
			test.setMu_id(line.split("	")[0]);
			test.setName(line.split("	")[1]);
			test.setType(line.split("	")[2]);
			test.setDescription(line.split("	")[3]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Norm.txt
		System.out.println("========norm.txt========");
		in = new Scanner(new File(fileList.get(14)));
		schema = in.nextLine();
		while(in.hasNext()){
			Norm test = new Norm();
			String line = in.nextLine();
			test.setNm_id(line.split("	")[0]);
			test.setType(line.split("	")[1]);
			test.setSoftware(line.split("	")[2]);
			test.setParameters(line.split("	")[3]);
			test.setDescription(line.split("	")[4]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Patient.txt
		System.out.println("========patient.txt========");
		in = new Scanner(new File(fileList.get(15)));
		schema = in.nextLine();
		while(in.hasNext()){
			Patient test = new Patient();
			String line = in.nextLine();
			test.setP_id(line.split("	")[0]);
			test.setSsn(line.split("	")[1]);
			test.setName(line.split("	")[2]);
			test.setGender(line.split("	")[3]);
			test.setDob(new Date(formatter.parse(line.split("	")[4]).getTime()));
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Person.txt
		System.out.println("========person.txt========");
		in = new Scanner(new File(fileList.get(16)));
		schema = in.nextLine();
		while(in.hasNext()){
			Person test = new Person();
			String line = in.nextLine();
			test.setPn_id(line.split("	")[0]);
			test.setName(line.split("	")[1]);
			test.setLabName(line.split("	")[2]);
			test.setContact(line.split("	")[3]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		
		//Platform.txt
		System.out.println("========platform.txt========");
		in = new Scanner(new File(fileList.get(17)));
		schema = in.nextLine();
		while(in.hasNext()){
			Platform test = new Platform();
			String line = in.nextLine();
			test.setPf_id(line.split("	")[0]);
			test.setHardware(line.split("	")[1]);
			test.setSoftware(line.split("	")[2]);
			test.setSettings(line.split("	")[3]);
			test.setDescription(line.split("	")[4]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Probe.txt
		System.out.println("========probe.txt========");
		in = new Scanner(new File(fileList.get(18)));
		schema = in.nextLine();
		while(in.hasNext()){
			Probe test = new Probe();
			String line = in.nextLine();
			test.setPb_id(line.split("	")[0]);
			test.setUID(line.split("	")[1]);
			test.setName(line.split("	")[2]);
			test.setDescription(line.split("	")[3]);
			Boolean qc = false;
			if(line.split("	")[4].equals("True"))
				qc = true;
			else 
				qc = false;
			test.setQC(qc);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Project.txt
		System.out.println("========project.txt========");
		in = new Scanner(new File(fileList.get(19)));
		schema = in.nextLine();
		while(in.hasNext()){
			Project test = new Project();
			String line = in.nextLine();
			test.setPj_id(line.split("	")[0]);
			test.setName(line.split("	")[1]);
			test.setInvestigator(line.split("	")[2]);
			test.setDescription(line.split("	")[3]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Promoter.txt
		System.out.println("========promoter.txt========");
		in = new Scanner(new File(fileList.get(20)));
		schema = in.nextLine();
		while(in.hasNext()){
			Promoter test = new Promoter();
			String line = in.nextLine();
			test.setPm_id(line.split("	")[0]);
			test.setType(line.split("	")[1]);
			test.setSequence(line.split("	")[2]);
			test.setLength(Integer.parseInt(line.split("	")[3]));
			test.setDescription(line.split("	")[4]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Protocal.txt
		System.out.println("========protocal.txt========");
		in = new Scanner(new File(fileList.get(21)));
		schema = in.nextLine();
		while(in.hasNext()){
			Protocal test = new Protocal();
			String line = in.nextLine();
			test.setPt_id(line.split("	")[0]);
			test.setName(line.split("	")[1]);
			test.setText(line.split("	")[2]);
			test.setCreatedby(line.split("	")[3]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Publication.txt
		System.out.println("========publication.txt========");
		in = new Scanner(new File(fileList.get(22)));
		schema = in.nextLine();
		while(in.hasNext()){
			Publication test = new Publication();
			String line = in.nextLine();
			test.setPu_id(line.split("	")[0]);
			test.setPub_med_id(line.split("	")[1]);
			test.setTitle(line.split("	")[2]);
			test.setAuthors(line.split("	")[3]);
			test.setAbstractString(line.split("	")[4]);
			test.setPubDate(new Date(formatter.parse(line.split("	")[5]).getTime()));
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Sample.txt
		System.out.println("========sample.txt========");
		in = new Scanner(new File(fileList.get(23)));
		schema = in.nextLine();
		while(in.hasNext()){
			Sample test = new Sample();
			String line = in.nextLine();
			test.setS_id(line.split("	")[0]);
			test.setSource(line.split("	")[1]);
			test.setAmount(Integer.parseInt(line.split("	")[2]));
			test.setSp_date(new Date(formatter.parse(line.split("	")[3]).getTime()));
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Term.txt
		System.out.println("========term.txt========");
		in = new Scanner(new File(fileList.get(25)));
		schema = in.nextLine();
		while(in.hasNext()){
			Term test = new Term();
			String line = in.nextLine();
			test.setTm_id(line.split("	")[0]);
			test.setName(line.split("	")[1]);
			test.setType(line.split("	")[2]);
			test.setSetting(line.split("	")[3]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		//Test.txt
		System.out.println("========test.txt========");
		in = new Scanner(new File(fileList.get(26)));
		schema = in.nextLine();
		while(in.hasNext()){
			Test test = new Test();
			String line = in.nextLine();
			test.setTt_id(line.split("	")[0]);
			test.setName(line.split("	")[1]);
			test.setType(line.split("	")[2]);
			test.setSetting(line.split("	")[3]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		System.out.println("========test_samples.txt========");
		in = new Scanner(new File(fileList.get(27)));
		schema = in.nextLine();
		while(in.hasNext()){
			Test_samples test = new Test_samples();
			String line = in.nextLine();
			test.setTest_samples_id(line.split("	")[0]);
			test.setTest1(Integer.parseInt(line.split("	")[1]));
			test.setTest2(Integer.parseInt(line.split("	")[2]));
			test.setTest3(Integer.parseInt(line.split("	")[3]));
			test.setTest4(Integer.parseInt(line.split("	")[4]));
			test.setTest5(Integer.parseInt(line.split("	")[5]));
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		System.out.println("========clinical_fact.txt========");
		in = new Scanner(new File(fileList.get(1)));
		schema = in.nextLine();
		while(in.hasNext()){
			FactClinical test = new FactClinical();
			String line = in.nextLine();
			test.setP_id(line.split("	")[0]);
			test.setDs_id(line.split("	")[1]);
			test.setSympton(line.split("	")[2]);
			
			if(line.split("	")[3].equals("null"))
				test.setDs_from_date(null);
			else {
				test.setDs_from_date(new Date(formatter.parse(line.split("	")[3]).getTime()));
			}
			if(line.split("	")[4].equals("null"))
				test.setDs_from_date(null);
			else {
				test.setDs_to_date(new Date(formatter.parse(line.split("	")[4]).getTime()));
			}
			
			test.setDr_id(line.split("	")[5]);
			
			test.setDosage(line.split("	")[6]);
			
			if(line.split("	")[7].equals("null"))
				test.setDs_from_date(null);
			else {
				test.setDr_from_date(new Date(formatter.parse(line.split("	")[7]).getTime()));
			}
			
			if(line.split("	")[8].equals("null"))
				test.setDs_from_date(null);
			else {
				test.setDr_to_date(new Date(formatter.parse(line.split("	")[8]).getTime()));
			}
			
			test.setTt_id(line.split("	")[9]);
			test.setResult(line.split("	")[10]);
			if(line.split("	")[11].equals("null"))
				test.setTt_date(null);
			else {
				test.setTt_date(new Date(formatter.parse(line.split("	")[11]).getTime()));
			}
			
			test.setS_id(line.split("	")[12]);
			
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		System.out.println("=======sample_fact.txt=======");
		in = new Scanner(new File(fileList.get(24)));
		schema = in.nextLine();
		while (in.hasNext()) {
			FactSample test = new FactSample();
			String line = in.nextLine();
			test.setS_id(line.split("	")[0]);
			test.setMk_id(line.split("	")[1]);
			test.setMk_result(line.split("	")[2]);
			if (line.split("	")[3].equals("null")) {
				test.setMk_date(null);
			}else {
				test.setMk_date(new Date(formatter.parse(line.split("	")[3]).getTime()));
			}
			test.setAs_id(line.split("	")[4]);
			test.setAs_result(line.split("	")[5]);
			if(line.split("	")[6].equals("null")){
				test.setAs_date(null);
			}else {
				test.setAs_date(new Date(formatter.parse(line.split("	")[6]).getTime()));
			}
			test.setTm_id(line.split("	")[7]);
			test.setTm_description(line.split("	")[8]);
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		System.out.println("=======microarray_fact.txt=======");
		in = new Scanner(new File(fileList.get(13)));
		schema = in.nextLine();
		while(in.hasNext()){
			FactMicroarray test = new FactMicroarray();
			String line = in.nextLine();
			test.setS_id(line.split("	")[0]);
			test.setE_id(line.split("	")[1]);
			test.setPb_id(line.split("	")[2]);
			test.setMu_id(line.split("	")[3]);
			test.setExp(Integer.parseInt(line.split("	")[4]));
			
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		System.out.println("=======gene_fact.txt=======");
		in = new Scanner(new File(fileList.get(9)));
		schema = in.nextLine();
		while(in.hasNext()){
			FactGene test = new FactGene();
			String line = in.nextLine();
			test.setUID(line.split("	")[0]);
			test.setGo_id(line.split("	")[1]);
			test.setCl_id(line.split("	")[2]);
			test.setDm_id(line.split("	")[3]);
			test.setPm_id(line.split("	")[4]);
			test.setUID2(line.split("	")[5]);
			
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		System.out.println("=======experiment_fact.txt=======");
		in = new Scanner(new File(fileList.get(7)));
		schema = in.nextLine();
		while(in.hasNext()){
			FactExperiment test = new FactExperiment();
			String line = in.nextLine();
			test.setE_id(line.split("	")[0]);
			test.setNm_id(line.split("	")[1]);
			test.setPj_id(line.split("	")[2]);
			test.setPn_id(line.split("	")[3]);
			test.setPf_id(line.split("	")[4]);
			test.setPt_id(line.split("	")[5]);
			test.setPu_id(line.split("	")[6]);
			
			//System.out.println(test.toInsertStat());
			//st.executeUpdate(test.toInsertStat());
		}
		
		in.close();
		System.out.println("Import Data Done!");
	}
}
