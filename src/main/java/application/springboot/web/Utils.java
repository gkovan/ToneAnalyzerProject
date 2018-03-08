/**
 * 
 */
package application.springboot.web;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author gkovan@us.ibm.com
 *
 */
public class Utils {
	
	   public String getDataFromInputLocation(String fileLocation) throws Exception { 
	        URI uri = this.getClass().getClassLoader().getResource(fileLocation).toURI();
	        String rawRequest = new String(Files.readAllBytes(Paths.get(uri)));
	        return rawRequest;
	    }
	   
	   public void getFromJsonString(String jsonStr) throws JsonParseException, JsonMappingException, IOException {
		   ToneAnalysisModel tam = null;
		   ObjectMapper mapper = new ObjectMapper();
		   tam = mapper.readValue(jsonStr,ToneAnalysisModel.class);
		   System.out.println(tam);
		   
	   }
	   
//	    public Flight[] getFlightFromJsonString(String jsonStr, String buildNumber, String branchName) {
//	        ObjectMapper mapper = new ObjectMapper();
//	        Flight flights[] = null;
//	        try {
//	            flights = mapper.readValue(jsonStr, Flight[].class);
//	        } catch (JsonParseException jsParseException) {
//	             Assert.fail("Failed to convert JSON String to Java Object "+jsParseException);
//	        } catch (JsonMappingException jsMappingException) {
//	            Assert.fail("Failed to convert JSON String to Java Object "+jsMappingException);
//	        } catch (IOException ioException) {
//	            Assert.fail("Failed to convert JSON String to Java Object "+ioException);
//	        }
//	        for(Flight flt : flights) {
//	            String orgFltNumber = flt.getFlightKey().getFlightNumber();
//	            String appendedFltNumber = orgFltNumber + "-" + buildNumber + "-" + branchName + "-" + FLIGHT_KEY_SUFFIX;
//	            flt.getFlightKey().setFlightNumber(appendedFltNumber);
//	        }
//	        return flights;
//	    }


}
