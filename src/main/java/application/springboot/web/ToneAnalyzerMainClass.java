/**
 * 
 */
package application.springboot.web;



/**
 * @author gkovan@us.ibm.com
 *
 */
public class ToneAnalyzerMainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String FILE = "./schoolfood.json";
			Utils myUtils = new Utils();
			String rawJSONString = myUtils.getDataFromInputLocation(FILE);
			System.out.println(rawJSONString);
			myUtils.getFromJsonString(rawJSONString);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
