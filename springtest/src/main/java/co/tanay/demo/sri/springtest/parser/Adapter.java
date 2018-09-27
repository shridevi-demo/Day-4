package co.tanay.demo.sri.springtest.parser;

public interface Adapter {
	PaymentInitWrapper processForChannel(PaymentInitWrapper paymentInitWrapper, EventParam eventParamObj);
}
