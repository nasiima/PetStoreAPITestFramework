package com.sparta.user.UserTests;

import com.sparta.user.stepDefinitions.UserLoginStepDefs;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

public class LoggingInTests {


    @ExtendWith(SerenityJUnit5Extension.class)
    public static class loggingIn {

        UserLoginStepDefs userLoginStepDefs;
        
        @Test
        public void logIn() {
            userLoginStepDefs.iAmAnAlreadyRegisteredUser();
            userLoginStepDefs.i_log_in();
            userLoginStepDefs.the_response_contains("user");
        }

        @Test
        public void viewAccountDetails() {
            userLoginStepDefs.iAmAnAlreadyRegisteredUser();
            userLoginStepDefs.i_view_my_account_details();
            userLoginStepDefs.the_details_contain_the_correct_information();
        }

    }

}
