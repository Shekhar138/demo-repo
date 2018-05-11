import java.net.URI;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.web.client.RestTemplate;

import com.demo.model.User;
import com.demo.model.UserProfile;
import com.demo.model.UserProfileType;


public class SpringRestTestClient {
	
	 public static final String REST_SERVICE_URI = "http://localhost:8080/Spring4MVCHelloWorldDemo/rest" ;
	     
		    /* GET */
		    @SuppressWarnings("unchecked")
		    private static void listAllUsers(){
		        System.out.println("Testing listAllUsers API-----------");
		         
		        RestTemplate restTemplate = new RestTemplate();
		        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/user/", List.class);
		         
		        if(usersMap!=null){
		            for(LinkedHashMap<String, Object> map : usersMap){
		                System.out.println("User : id="+map.get("id")+", Name="+map.get("firstName"));;
		            }
		        }else{
		            System.out.println("No user exist----------");
		        }
		    }
		     
		    /* GET */
		    private static void getUser(){
		        System.out.println("Testing getUser API----------");
		        RestTemplate restTemplate = new RestTemplate();
		        User user = restTemplate.getForObject(REST_SERVICE_URI+"/user/1", User.class);
		        System.out.println(user);
		    }
		     
		    /* POST */
		    private static void createUser() {
		        System.out.println("Testing create User API----------");
		        RestTemplate restTemplate = new RestTemplate();
		        User user = new User();
		        user.setEmail("shekharsarkar138@gmail.com");
		        user.setFirstName("Shekhar");
		        user.setLastName("Sarkar");
		        user.setPassword("admin");
		        user.setSsoId("676191234");
		        Set<UserProfile> userProfiles = new HashSet<UserProfile>();
		        UserProfile userProfile = new UserProfile();
		        userProfile.setType(UserProfileType.ADMIN.getUserProfileType());
		        userProfile.setId(2);
		        userProfiles.add(userProfile);
		        user.setUserProfiles(userProfiles);
		        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/user/", user, User.class);
		        System.out.println("Location : "+uri.toASCIIString());
		    }
		 
		    /* PUT */
		    private static void updateUser() {
		        System.out.println("Testing update User API----------");
		        RestTemplate restTemplate = new RestTemplate();
		        User user = new User();
		        user.setEmail("shekharsarkar138@gmail.com");
		        user.setFirstName("Shekhar");
		        user.setLastName("Sarkar");
		        user.setPassword("admin");
		        Set<UserProfile> userProfiles = new HashSet<UserProfile>();
		        UserProfile userProfile = new UserProfile();
		        userProfile.setType(UserProfileType.ADMIN.getUserProfileType());
		        userProfile.setId(2);
		        userProfiles.add(userProfile);
		        user.setUserProfiles(userProfiles);
		        restTemplate.put(REST_SERVICE_URI+"/user/2", user);
		        System.out.println(user);
		    }
		 
		    /* DELETE */
		    private static void deleteUser() {
		        System.out.println("Testing delete User API----------");
		        RestTemplate restTemplate = new RestTemplate();
		        restTemplate.delete(REST_SERVICE_URI+"/user/3");
		    }
		 
		 
		    /* DELETE */
		    private static void deleteAllUsers() {
		        System.out.println("Testing all delete Users API----------");
		        RestTemplate restTemplate = new RestTemplate();
		        restTemplate.delete(REST_SERVICE_URI+"/user/");
		    }
		 
		    public static void main(String args[]){
		        listAllUsers();
		        getUser();
		        /*createUser();
		        listAllUsers();*/
		        /*updateUser();
		        listAllUsers();
		        deleteUser();
		        listAllUsers();
		        deleteAllUsers();
		        listAllUsers();*/
		    }

}
