package mrs.domain.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import mrs.domain.model.User;
import mrs.domain.repository.user.EditUserRepositoryJdbc;
import mrs.domain.repository.user.UserRepository;

@Service
public class UserService {

    @Autowired
    EditUserRepositoryJdbc userRepositoryJdbc;

    @Autowired
    UserRepository userRepository;

    public void saveOrUpdate(User user, String userId) throws DataAccessException {
        System.out.println("beforeFix: " + userId);
        System.out.println("fixed: " + user.getUserId());

        userRepositoryJdbc.update(user, userId);
    }

    public boolean checkDuplicate(String userId) {
        if (userRepository.countByUserId(userId) != 0) {
            return false;
        }

        return true;
    }
}
