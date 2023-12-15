package E_commerceDbachna.servicesImpl;

import E_commerceDbachna.models.*;
import E_commerceDbachna.repositories.*;
import E_commerceDbachna.serviceInterfaces.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements IUserServices {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IRoleRepository IRoleRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;



    @Override
    public UserDto addUser(UserDto userDto) {
        User user=new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setLastname(userDto.getLastname());
        user.setFirstname(userDto.getFirstname());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setPhone(userDto.getPhone());
        user.setEnabled(true);

        switch(userDto.getRole()) {
            case "ADMIN":
                user.setRole(IRoleRepository.findByRoleName("ADMIN").get(0));
                break;
            case "CLIENT":
                user.setRole(IRoleRepository.findByRoleName("CLIENT").get(0));
                break;
        }
        userRepository.save(user);


        UserDto userDto1=new UserDto(userDto.getFirstname(),userDto.getLastname(),userDto.getEmail(),
                userDto.getRole(), userDto.getUsername(), userDto.getPassword(),userDto.getAddress(),userDto.getPhone());
        return userDto1;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }


    @Override
    public User getUsersByUsername(String username) {
        return userRepository.findByUsername(username).get(0);
    }









}
