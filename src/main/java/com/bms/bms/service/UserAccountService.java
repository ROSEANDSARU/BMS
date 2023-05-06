package com.bms.bms.service;

import com.bms.bms.model.UserAccountModel;
import com.bms.bms.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public List<UserAccountModel> getAllUserAccounts() {
        List<UserAccountModel> userAccountModelList = null;

        try {
             userAccountModelList = userAccountRepository.findAll();
        } catch (Exception e) {
            System.out.println("Exception fetching all user accounts");
        }

        return userAccountModelList;
    }

    public Optional<UserAccountModel> getUserAccountByID(String userId) {
        Optional<UserAccountModel> userAccountModel = null;

        try {
            userAccountModel = userAccountRepository.findById(userId);
        }catch (Exception e){
            System.out.println("Exception in fetching userAccount");
        }
        return userAccountModel;

    }

    public List<UserAccountModel> getUserAccountsWithBalanceGT50000(){
        List<UserAccountModel> userAccountModelBal;
        List<UserAccountModel> userAccountModelBalGT50000 = new ArrayList<>();
        try{
            userAccountModelBal = userAccountRepository.findAll();

            userAccountModelBal.forEach(userAccountModel -> {
                int balDiff = userAccountModel.getBalance().compareTo(BigDecimal.valueOf(50000));
                if (balDiff >= 0) {
                    userAccountModelBalGT50000.add(userAccountModel);
                }
            });

            //return userAccountRepository.findAll().stream().filter(userAccountModel -> userAccountModel.getBalance().compareTo(BigDecimal.valueOf(50000)) >= 0).collect(Collectors.toList());

        }catch(Exception e)
        {
            System.out.println("Exception in fetching balance");

        }

        return userAccountModelBalGT50000;
    }


    public String addUserAccount(UserAccountModel userAccountModel){

        try{
            userAccountRepository.save(userAccountModel);

        }catch (Exception e) {
            System.out.println("Exception in adding userAccount");
        }

        return "Account added successfully";
    }

}
