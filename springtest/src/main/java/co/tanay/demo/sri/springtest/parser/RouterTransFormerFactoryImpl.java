package co.tanay.demo.sri.springtest.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouterTransFormerFactoryImpl implements iPublish {

	@Autowired
	REST_APIAdapter apiRouterTransForm;
	
	@Autowired
	EmailAdapter emainRouterTransForm;
	
	@Override
	public PaymentInitWrapper publishToAChannel(PaymentInitWrapper paymentInitWrapper, EventParam eventParamObj) {
		try {
			if (eventParamObj.getClientAPI() != null && !eventParamObj.getClientAPI().isEmpty()) {
				paymentInitWrapper = apiRouterTransForm.processForChannel(paymentInitWrapper, eventParamObj);
			} else if (eventParamObj.getClientAPI() != null && !eventParamObj.getClientAPI().isEmpty()) {
				paymentInitWrapper = emainRouterTransForm.processForChannel(paymentInitWrapper, eventParamObj);
			}
		} catch (Exception e) {}
		return paymentInitWrapper;
	}
	
//	@Override
//	public PaymentInitWrapper publishToAChannel(PaymentInitWrapper paymentInitWrapper, EventParam eventParamObj) {
//		try {
//			if (eventParamObj.getClientAPI() != null && !eventParamObj.getClientAPI().isEmpty() && eventParamObj.getClientAPI().equals("client")) {
//				paymentInitWrapper = apiRouterTransForm.processForChannel(paymentInitWrapper, eventParamObj);
//			} else if (eventParamObj.getClientAPI() != null && !eventParamObj.getClientAPI().isEmpty() && eventParamObj.getClientAPI().equals("email")) {
//				paymentInitWrapper = emainRouterTransForm.processForChannel(paymentInitWrapper, eventParamObj);
//			}
//		} catch (Exception e) {}
//		return paymentInitWrapper;
//	}
}
