package in.mittu.services;

import in.mittu.dao.UserDao;
import in.mittu.models.User;

public class LoginRegisterService {
	
	public int register(User user) {
		UserDao dao=new UserDao();
		return dao.save(user);
	}
	
	public int login(User user){		
		UserDao dao=new UserDao();
		return dao.checkUserAvailable(user);
	}

	
}
