package inputoutput;

public class User {
	private String name;
	private String password;
	private String image;
	
	User(String str) {
		String[] usersArray = str.split("-");
		name = usersArray[0];
		image = usersArray[1];
		password = usersArray[2];
		
		
	}

}
