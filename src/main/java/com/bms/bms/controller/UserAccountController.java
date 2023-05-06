package com.bms.bms.controller;

import com.bms.bms.model.UserAccountModel;
import com.bms.bms.service.UserAccountService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user-account")
@CrossOrigin("*")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;


    @GetMapping(value = "/get-all-user-accounts")
    public ResponseEntity<List<UserAccountModel>> getAllUserAccounts() {
        List<UserAccountModel> allUserAccounts = userAccountService.getAllUserAccounts();
        return ResponseEntity.ok().body(allUserAccounts);
    }

    @GetMapping(value = "/get-user-account-by-ID/{userId}")
    public ResponseEntity<Optional<UserAccountModel>> getUserAccountById(@PathVariable String userId){
        Optional<UserAccountModel> userAccountModel = userAccountService.getUserAccountByID(userId);
        return ResponseEntity.ok().body(userAccountModel);

    }

    @GetMapping(value="/get-user-account-balGT-50000")
    public ResponseEntity<List<UserAccountModel>> getUserAccountsWithBalanceGT50000(){
        List<UserAccountModel> userAccountModels = userAccountService.getUserAccountsWithBalanceGT50000();
        return ResponseEntity.ok().body(userAccountModels);
    }

    @PostMapping(value="/add-user-account")
    public ResponseEntity addUserAccount(@RequestBody UserAccountModel userAccountModel){

       String messsage = userAccountService.addUserAccount(userAccountModel);

       return ResponseEntity.ok().body(messsage);
    }



}
