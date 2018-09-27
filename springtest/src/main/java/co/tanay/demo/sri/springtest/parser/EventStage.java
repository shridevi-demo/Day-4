package co.tanay.demo.sri.springtest.parser;

public enum EventStage {
	FWD_FLOW_VALIDATION_IRRECOVERABLE_ERROR,
	FWD_FLOW_VALIDATION_RECOVERABLE_ERROR,
	FWD_FLOW_VALIDATION_SUCCESS,
	
	FWD_FLOW_ENRICH_RECOVERABLE_ERROR,
	FWD_FLOW_ENRICH_IRRECOVERABLE_ERROR,
	FWD_FLOW_ENRICH_SUCCESS,
	
	FWD_FLOW_TRANSFORM_RECOVERABLE_ERROR,
	FWD_FLOW_TRANSFORM_IRRECOVERABLE_ERROR,
	FWD_FLOW_TRANSFORM_SUCCESS,
}