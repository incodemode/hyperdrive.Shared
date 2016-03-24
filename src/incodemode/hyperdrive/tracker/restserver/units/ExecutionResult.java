package incodemode.hyperdrive.tracker.restserver.units;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ExecutionResult<D> {
	private Boolean done;
	private D response;
    private Boolean error;
    private String errorDescription;
    
    
    public ExecutionResult( boolean done, D response, boolean error, String errorDescription ) {
        this.done = done;
        this.response = response;
        this.error = error;
        this.errorDescription = errorDescription;
    }
    public ExecutionResult() {
        
    }
    
    
    public boolean getDone() {
        return done;
    }
    
    public D getResponse(){
    	return response;
    }
    
    public boolean getError() {
        return error;
    }
    
    public String getErrorDescription(){
    	return errorDescription;
    }
    
    @Override
    public String toString() {
        return "ExecutionResult{" +
                "done='" + done + '\'' +
                ", error=" + error +
                ", errorDescription=" + errorDescription+
                '}';
    }
}
