package web2.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import web2.config.ApplicationContextProvider;
import web2.service.RestService;
import web2.service.Violation;
import web2.service.Violations;

@Path("/hello")
public class RestResource {
	
	
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return "<html> " + "<title>" + "Hello Sachin" + "</title>"
                + "<body><h1>" + "Hello Sachin" + "</body></h1>" + "</html> ";
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_HTML)
    public Response saySomething(@PathParam("name") String name) {
    	
    	RestService restService = (RestService) ApplicationContextProvider.getApplicationContext().getBean("restService");    	
//    	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//    	
//    	RestService restService =  	(RestService) context.getBean("restService");
    	String statement = restService.modifyStatement(name);
        return Response.ok().entity("<html><body><h1>" + statement + "</h1></body</html>" ).build();
    }
    
    @GET
    @Path("/names")
    @Produces(MediaType.TEXT_HTML)
    public Response provideNames() {
    	
    	RestService restService = (RestService) ApplicationContextProvider.getApplicationContext().getBean("restService");    	

    	return Response.ok().entity("<html><body><h1>" + restService.giveNames() + "</h1></body</html>" ).build();
    }
    
    @GET
    @Path("/asd/df")
    @Produces(MediaType.APPLICATION_JSON)
    public Response asd() {
    	
//    	Map<String, Violations> map = new HashMap<>();

//        Violation violation = new Violation();
//        
//        violation.setCode("Dfsf");
//        violation.setMessage("fdsaffdsf");
//
//        Violations violations = new Violations();
//        
//        Collection<Violation> violatio = new ArrayList<>();
//        
//        violatio.add(violation);
    	
    	
//        
//        violations.setViolationsList(violatio);
//
//        map.put("asd", violations);
    	
    	Map<String, String> map = new HashMap<>();
    	
    	map.put("fdsaf", "Fdsaf");


        return Response.status(Response.Status.OK)
                .entity(map)
                .build();
//    	return Response.ok().entity("<html><body><h1>" + restService.giveNames() + "</h1></body</html>" ).build();
    }
    
    @GET
    @Path("/rdx/df")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "abc");
        map.put("2", "def");
        map.put("3", "ghi");

        return Response.status(Response.Status.OK).entity(map).build();
    }

}
