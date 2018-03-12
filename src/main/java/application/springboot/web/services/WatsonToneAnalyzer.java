/**
 * 
 */
package application.springboot.web.services;

import application.springboot.web.domain.AppData;

/**
 * @author gkovan@us.ibm.com
 *
 */
public interface WatsonToneAnalyzer {
	
	public String analyzeTone(AppData appData);

}
