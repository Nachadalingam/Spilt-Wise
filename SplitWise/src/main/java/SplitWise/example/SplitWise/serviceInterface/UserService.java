package SplitWise.example.SplitWise.serviceInterface;

import SplitWise.example.SplitWise.Exception.*;
import SplitWise.example.SplitWise.dto.LoginAllowRequest;
import SplitWise.example.SplitWise.dto.LoginRequestDto;
import SplitWise.example.SplitWise.models.User;

public interface UserService {
    public void adduser(LoginRequestDto requestDto) throws EmailNotFoundException,
            NameNotFoundException, PasswordNotFoundException;

    public String verifyUser(LoginAllowRequest request) throws UserNotFoundException, PasswordMisMatchException;
}
