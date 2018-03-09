/**
 * 
 */
package application.springboot.web.services;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * @author gkovan@us.ibm.com
 *
 */
@Service
public class TwilioSendSMSMessageImpl implements TwilioSendSMSMessage {

	  private static final String ACCOUNT_SID = "AC5d1f13f93c5147912f5503bf93b3f4ec";
	  private static final String AUTH_TOKEN = "21444546ebc4b6cb7a082c5e359fa24a";

	/* (non-Javadoc)
	 * @see application.springboot.web.services.TwilioSendSMSMessage#sendSMSMessage(java.lang.String)
	 */
	  
	static {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	}
	
	@Override
	public String sendSMSMessage(String toPhoneNumber) {
		// TODO Auto-generated method stub
		

		// first phone mumber receives the message, the second number is the sender.
		Message message = Message.creator(new PhoneNumber("+1" + toPhoneNumber),
		        new PhoneNumber("+12013471339"), 
		        "This is the ship that made the Kessel Run in fourteen parsecs?").create();
		return message.getSid();
	}

}
