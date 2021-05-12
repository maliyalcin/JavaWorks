package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	private List<User> users = new ArrayList<User>();
	
	public InMemoryUserDao() {
		super();
		User user1 = new User(1,"Ali", "Yalçın","aliyalcin@gmail.com", "123456", true);
		User user2 = new User(1,"Fatih", "Tartar","fatih@gmail.com", "654321", true);
		User user3 = new User(1,"Yasin", "Taş","yasin@gmail.com", "987654", true);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}
	
	@Override
	public void add(User user) {
		users.add(user);
		
		
	}

	@Override
	public void update(User user) {
		User userToUpdate = users.stream()
				.filter(u -> u.getId() == user.getId())
				.findFirst()
				.orElse(null);
		
		userToUpdate.setName(user.getName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.seteMail(user.geteMail());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setVerify(user.isVerify());
		
	}

	@Override
	public void delete(int userId) {
		User userToDelete = users.stream()
				.filter(u -> u.getId() == userId)
				.findFirst()
				.orElse(null);
		
		users.remove(userToDelete);
		
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User get(String email) {
		User user = users.stream()
				.filter(u -> u.geteMail() == email)
				.findFirst()
				.orElse(null);
		
		return user;
	}
	

}
