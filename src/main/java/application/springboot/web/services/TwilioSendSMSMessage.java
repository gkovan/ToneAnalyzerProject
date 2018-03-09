/**
 * 
 */
package application.springboot.web.services;

/**
 * @author gkovan@us.ibm.com
 *
 */
public interface TwilioSendSMSMessage {
	
	public String sendSMSMessage(String toPhoneNumber);

}
