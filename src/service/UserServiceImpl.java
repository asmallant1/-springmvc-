package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository ur;
	@Override
	public boolean findPersonalMessage(String id, String password, String type) {
		// TODO Auto-generated method stub
		return ur.findUserById(id, password, type);
	}

}
