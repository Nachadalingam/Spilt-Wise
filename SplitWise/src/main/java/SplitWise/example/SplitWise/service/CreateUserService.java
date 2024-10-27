package SplitWise.example.SplitWise.service;

import SplitWise.example.SplitWise.Exception.*;
import SplitWise.example.SplitWise.dto.LoginAllowRequest;
import SplitWise.example.SplitWise.dto.LoginRequestDto;
import SplitWise.example.SplitWise.models.User;
import SplitWise.example.SplitWise.repository.UserRepository;
import SplitWise.example.SplitWise.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void adduser(LoginRequestDto requestDto) throws EmailNotFoundException, NameNotFoundException, PasswordNotFoundException {
        validiateUserDetais
                (requestDto.getEmail(),requestDto.getName(),requestDto.getPassword());
        User u=new User();
        u.setEmail(requestDto.getEmail());
        u.setPassword(requestDto.getPassword());
        u.setName(requestDto.getName());
        userRepository.save(u);

    }

    @Override
    public String verifyUser(LoginAllowRequest request) throws UserNotFoundException, PasswordMisMatchException {
        User user=userRepository.findByEmail(request.getEmail());
        if(user==null)
        {
            throw new UserNotFoundException("User Account Not Found ");
        }
        if(!(user.getPassword().equals(request.getPassword())))
        {
            throw new PasswordMisMatchException("Psssword MisMatch Exception");
        }
        return "Logged Successfully";
    }

    private void validiateUserDetais(String email,String userNme,String passWord) throws EmailNotFoundException, NameNotFoundException, PasswordNotFoundException {
        if(email==null)
        {
            throw  new EmailNotFoundException("Email Not Found");
        }
        if(userNme==null)
        {
            throw new NameNotFoundException("Name Not Found");
        }
        if(passWord==null)
        {
            throw new PasswordNotFoundException("Password Not Found");
        }
        int numberCount=0;
        int specialCharacterCount=0;
        if(passWord.length()!=6)
        {
            throw new PasswordNotFoundException("Password Length is not valid");
        }
        for(int i=0;i<passWord.length();i++)
        {
            if(passWord.charAt(i)>=1 && passWord.charAt(i)<=9)
            {
                numberCount++;
            }
            if(passWord.charAt(i)=='@' || passWord.charAt(i)=='$'||passWord.charAt(i)=='#')
            {
                specialCharacterCount++;
            }
        }
        if(numberCount!=2 || specialCharacterCount!=1)
        {
            throw new PasswordNotFoundException("Password Character is Inavlid!");
        }

    }

}
