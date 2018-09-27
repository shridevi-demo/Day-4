package co.tanay.demo.sri.springtest.parser;

public interface ParseService {
	PaymentInitWrapper parseRequestMessage(String message) throws Exception;
}
