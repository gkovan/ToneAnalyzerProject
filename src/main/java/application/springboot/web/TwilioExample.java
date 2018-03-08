/**
 * 
 */
package application.springboot.web;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioExample {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC5d1f13f93c5147912f5503bf93b3f4ec";
  public static final String AUTH_TOKEN = "21444546ebc4b6cb7a082c5e359fa24a";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    // first phone mumber receives the message, the second number is the sender.
    Message message = Message.creator(new PhoneNumber("+13473928489"),
        new PhoneNumber("+12013471339"), 
        "This is the ship that made the Kessel Run in fourteen parsecs?").create();

    System.out.println(message.getSid());
  }
}