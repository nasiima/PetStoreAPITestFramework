package com.sparta.user.UserTests;

import com.sparta.user.stepDefinitions.LoggingInStepDefs;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class LoggingInTests {


    @ExtendWith(SerenityJUnit5Extension.class)
    public class loggingIn {

        LoggingInStepDefs loggingInStepDefs;

        @Test
        public void logIn() {
            loggingInStepDefs.i_am_a_registered_user();
            loggingInStepDefs.i_log_in();
            loggingInStepDefs.the_response_contains("Logged in user session");
        }

    }

}
