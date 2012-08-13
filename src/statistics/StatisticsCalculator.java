package statistics;

import java.util.ArrayList;
import java.util.List;

public class StatisticsCalculator {

	public static double  tStatistics(List<Integer> input1, List<Integer> input2) {
		double tResult = 0;
		int size1 = input1.size();					//Length of input1
		int size2 = input2.size();					//Length of input2
		
		double mean1 = 0, mean2 = 0;
		
		for(int i = 0; i < size1; i++) {
			mean1 += input1.get(i);
		}
		mean1 = mean1/size1;
		
		for(int i = 0; i < size2; i++) {
			mean2 += input2.get(i);
		}
		mean2 = mean2/size2;

		double standard1 = 0, standard2 = 0;
		
		for(int i = 0; i < size1; i++){
			standard1 += Math.pow((input1.get(i) - mean1), 2);
		}
		standard1 = standard1/(size1 - 1);
		
		for(int i = 0; i < size2; i++){
			standard2 += Math.pow((input2.get(i) - mean2), 2);
		}
		standard2 = standard2/(size2 - 1);
		
		tResult = (mean1 - mean2)/Math.sqrt(standard1/size1 + standard2/size2);
		return tResult;
	}
	
	public static double  tStatisticsD(List<Double> input1, List<Double> input2) {
		double tResult = 0;
		int size1 = input1.size();					//Length of input1
		int size2 = input2.size();					//Length of input2
		
		double mean1 = 0, mean2 = 0;
		
		for(int i = 0; i < size1; i++) {
			mean1 += input1.get(i);
		}
		mean1 = mean1/size1;
		
		for(int i = 0; i < size2; i++) {
			mean2 += input2.get(i);
		}
		mean2 = mean2/size2;

		double standard1 = 0, standard2 = 0;
		
		for(int i = 0; i < size1; i++){
			standard1 += Math.pow((input1.get(i) - mean1), 2);
		}
		standard1 = standard1/(size1 - 1);
		
		for(int i = 0; i < size2; i++){
			standard2 += Math.pow((input2.get(i) - mean2), 2);
		}
		standard2 = standard2/(size2 - 1);
		
		tResult = (mean1 - mean2)/Math.sqrt(standard1/size1 + standard2/size2);
		return tResult;
	}
	
	public static double fStatistics(List<List<Integer>> input) {
		double fResult = 0;
		List<Double> meanList = new ArrayList<Double>();
		double allMean = 0;
		double sb = 0;
		double fb = input.size() - 1;
		double msb = 0;
		
		double sw = 0;
		double fw = 0;
		double msw = 0;
		
		for(int i = 0; i < input.size(); i++) {
			double tmp = 0;
			for(int j = 0; j < input.get(i).size(); j++) {
				tmp += input.get(i).get(j);
			}
			meanList.add(tmp/input.get(i).size());
			allMean += tmp/input.get(i).size();
		}
		allMean = allMean/meanList.size();
		
		for(int i =0; i < meanList.size(); i++) {
			sb += input.get(i).size() * Math.pow((meanList.get(i) - allMean), 2);
		}
		msb = sb/fb;
		
		for(int i = 0; i < input.size(); i++){
			for(int j = 0; j < input.get(i).size(); j++) {
				sw += Math.pow(input.get(i).get(j) - meanList.get(i), 2);
			}
			fw += input.get(i).size();
		}
		fw = fw - input.size();
		msw = sw/fw;
		
		fResult = msb/msw;
		
		return fResult;
	}
	
	public static double pearsonCorrelation(List<Integer> input1, List<Integer> input2) {
		double cResult = 0;
		double mean1 = 0, mean2 = 0;
		double var1 = 0, var2 = 0;
		double cov = 0;
		
		for(int i = 0; i < input1.size(); i++) {
			mean1 += input1.get(i);
			mean2 += input2.get(i);
		}
		mean1 = mean1/input1.size();
		mean2 = mean2/input2.size();
		
		for(int i = 0; i < input1.size(); i++) {
			var1 += Math.pow(input1.get(i) - mean1, 2);
			var2 += Math.pow(input2.get(i) - mean2, 2);
			cov += (input1.get(i) - mean1) * (input2.get(i) - mean2);
		}
		var1 = var1/(input1.size()-1);
		var2 = var2/(input2.size()-1);
		cov = cov/(input1.size() - 1);
		//System.out.println(mean1 + "=" + mean2 + "=" + var1 + "=" + var2 + "=" + cov);
		cResult = cov/Math.sqrt(var1*var2);
		
		return cResult;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		List<Integer> tmp1 = new ArrayList<Integer>();
		tmp1.add(6); tmp1.add(8);tmp1.add(4);tmp1.add(5);tmp1.add(3);tmp1.add(4);
		List<Integer> tmp2 = new ArrayList<Integer>();
		tmp2.add(8);tmp2.add(12);tmp2.add(9);tmp2.add(11);tmp2.add(6);tmp2.add(8);
		List<Integer> tmp3 = new ArrayList<Integer>();
		tmp3.add(13);tmp3.add(9);tmp3.add(11);tmp3.add(8);tmp3.add(7);tmp3.add(12);
		input.add(tmp1);
		input.add(tmp2);
		input.add(tmp3);
		
		StatisticsCalculator cal = new StatisticsCalculator();
		double re = cal.fStatistics(input);
		System.out.println(re);
	}

}
