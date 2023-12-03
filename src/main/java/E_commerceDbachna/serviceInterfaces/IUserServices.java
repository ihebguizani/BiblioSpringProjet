package E_commerceDbachna.serviceInterfaces;

import E_commerceDbachna.models.User;
import E_commerceDbachna.models.UserDto;

import java.util.List;

public interface IUserServices {
    UserDto addUser(UserDto userDto);
    void deleteUser(Long userId);
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUsersByUsername(String username);

}
