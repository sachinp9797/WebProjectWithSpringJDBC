package web2.service;


import javax.xml.bind.annotation.*;

@XmlType(name = "", propOrder = { "code", "message" })
public class Violation {
	
	@XmlElement(name = "code")
    private String code;
	
	@XmlElement(name = "message")
    private String message;
    
//    public Violation() {
//    	
//    }
//
//    public Violation(String code, String message, String errorLevel) {
//        this.code = code;
//        this.message = message;
//    }
//
//    public Violation(String code, String message) {
//        this.code = code;
//        this.message = message;
//    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    

}
