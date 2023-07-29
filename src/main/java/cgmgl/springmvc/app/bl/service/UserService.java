package cgmgl.springmvc.app.bl.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import cgmgl.springmvc.app.bl.dto.ApplicantDto;
import cgmgl.springmvc.app.bl.dto.ApplicantProfileDto;
import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.bl.dto.UserDto;
import cgmgl.springmvc.app.persistence.entity.User;

public interface UserService {
    User doGetUserByName(String username);

    long doGetUserCount();

    boolean doIsEmailExist(String user_email);

    public void doSaveUser(@Valid ApplicantDto applicantForm) throws FileNotFoundException, IOException;

    public User doGetUserById(long userId);

    public void doUpdateUser(@Valid User user);

    public User doGetUserByEmail(String userEmail);

    public List<User> doGetUserList();

    public UserDto getUserByID(Long userId);

    public void doUpdateUser(@Valid UserDto userForm);
    
    public void doDeleteUser(long userId);

    public List<String> doGetEmailList();

    public void doSaveUser(@Valid UserDto userDto);

	public void doSaveCompany(@Valid CompanyDto companydto);

  User doGetLoginInfo();
    
  public boolean doIsLoggedIn();    

	public User doGetApplicantById(long userIdForApplicant) throws IOException;

	public ApplicantProfileDto doGetApplicantByEmail(String userEmail);

	public void doUpdateApplicant(@Valid ApplicantProfileDto profileDto);

    public List<User> doGetUserNameList();

    /**
     * Find by id.
     *
     * @param int id
     * @return UserDetailDto
     */
    /*
     * UserDto findById(int id);
     * 
     *//**
        * Find by email.
        *
        * @param String email
        * @return UserDetailDto
        */
    /*
     * UserDto findByEmail(String email);
     * 
     *//**
        * Create new user.
        *
        * @param UserDetailDto userDto
        */
    /*
     * void createUser(UserDto userDto);
     * 
     *//**
        * Update user.
        *
        * @param UserUpdateDto userDto
        */
    /*
     * void updateUser(UserDto userDto);
     * 
     *//**
        * Delete user.
        *
        * @param int id
        *//*
           * void deleteUser(int id);
           */
}