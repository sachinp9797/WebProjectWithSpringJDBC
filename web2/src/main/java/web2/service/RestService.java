package web2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web2.DB.FirstExample;



@Service
public class RestService {
	
	@Autowired
	FirstExample firstExample;
	
	public String modifyStatement(String name) {
		return name + " is brave, he has tremendous patience";
	}
	
	
	public String giveNames() {
		return firstExample.getEmployees();
	}
	
}
