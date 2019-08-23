package repositoryClass;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import beanClasses.Login;

public class IndexDao {
	private static final String PERSISTENCE_UNIT_NAME = "TravelBookingSystemNew";
	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entitymanager = factory.createEntityManager();
	public Boolean check(Login login) {
		boolean role=false;
		entitymanager.getTransaction().begin();
		String getUser_query = "SELECT * FROM login WHERE login.username = '" + login.getUsername() + "' and login.password= '"+ login.getPassword() + "' ;";
		@SuppressWarnings("unchecked")
		List<Login> list = (List<Login>)entitymanager.createNativeQuery( getUser_query ).getResultList();
		if (!list.isEmpty()) {
			role = true;
		}
		entitymanager.getTransaction().commit();
		return role;
	}
}