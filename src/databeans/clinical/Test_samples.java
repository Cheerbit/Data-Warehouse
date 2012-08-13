package databeans.clinical;

public class Test_samples {
	String test_samples_id;
	int test1;
	int test2;
	int test3;
	int test4;
	int test5;
	
	public String getTest_samples_id() {
		return test_samples_id;
	}
	public void setTest_samples_id(String test_samples_id) {
		this.test_samples_id = test_samples_id;
	}
	public int getTest1() {
		return test1;
	}
	public void setTest1(int test1) {
		this.test1 = test1;
	}
	public int getTest2() {
		return test2;
	}
	public void setTest2(int test2) {
		this.test2 = test2;
	}
	public int getTest3() {
		return test3;
	}
	public void setTest3(int test3) {
		this.test3 = test3;
	}
	public int getTest4() {
		return test4;
	}
	public void setTest4(int test4) {
		this.test4 = test4;
	}
	public int getTest5() {
		return test5;
	}
	public void setTest5(int test5) {
		this.test5 = test5;
	}
	
	@Override
	public String toString() {
		return "Test_samples [test_samples_id=" + test_samples_id + ", test1="
				+ test1 + ", test2=" + test2 + ", test3=" + test3 + ", test4="
				+ test4 + ", test5=" + test5 + "]";
	}
	
	public String toInsertStat() {
		return "Insert into test_samples(test_samples_id, test1, test2, test3, test4, test5) values('" +
				 test_samples_id + "', " + test1 + ", " + test2 + ", " + test3 + ", " + test4 + ", " + test5 + ");";
	}
}
