package application.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;

import application.springboot.web.domain.AppData;
import application.springboot.web.services.TwilioSendSMSMessage;
import application.springboot.web.services.WatsonToneAnalyzer;

@RestController
public class LibertyHelloController {
	
	
	@Autowired
	WatsonToneAnalyzer toneAnalyzer;
	
	@Autowired
	TwilioSendSMSMessage sendSMS;
	
	@RequestMapping("/whatsyourtone")
	public String elianasToneAnalyzer(@RequestParam(value="phonenumber", required=true) String phonenumber, @RequestParam(value="sentence", required=true) String sentence) {
		System.out.println(phonenumber);
		System.out.println(sentence);

		AppData appData = new AppData();
		appData.setPhonenumber(phonenumber);
		appData.setSentence(sentence);
		toneAnalyzer.analyzeTone(appData);
		sendSMS.sendSMSMessage(phonenumber);
		return appData.toString();
		//return phonenumber + sentence + toneAnalyzer.analyzeTone(sentence);
		
	}
	
	
	@RequestMapping("/test")
	public String test() {
		return "TEST";
	}

	@RequestMapping("/springbootweb")
	public String hello() {
	
		final String VERSION_DATE = "2016-05-19";
		ToneAnalyzer service = new ToneAnalyzer(VERSION_DATE);
		service.setUsernameAndPassword("43233b68-ae7e-4804-b7b5-3302597d1834", "g8a4Lt6g5jrT");

		String text = "I know the times are difficult! Our sales have been "
				+ "disappointing for the past three quarters for our data analytics "
				+ "product suite. We have a competitive data analytics product "
				+ "suite in the industry. But we need to do our job selling it! "
				+ "We need to acknowledge and fix our sales challenges. "
				+ "We can’t blame the economy for our lack of execution! "
				+ "We are missing critical sales opportunities. "
				+ "Our product is in no way inferior to the competitor products. "
				+ "Our clients are hungry for analytical tools to improve their "
				+ "business outcomes. Economy has nothing to do with it.";

		// Call the service and get the tone
		ToneOptions toneOptions = new ToneOptions.Builder().html(text).build();
		ToneAnalysis tone = service.tone(toneOptions).execute();
		System.out.println(tone);

		return tone.toString();
		//return "Hello from Spring Boot MVC running on Liberty!";
	}

}
