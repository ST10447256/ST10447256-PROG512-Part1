/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import register.and.login.Login;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {
    
    private Login login;
    
    public LoginTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        login = new Login();
    }
    
    @AfterEach
    public void tearDown() {
        login.clearRegistration();
    }

    @Test
    public void testCheckUserNameCorrectFormat() {
        assertTrue(login.checkUserName("kyl_1"), 
            "Username with underscore and ≤5 chars should be valid");
    }
    
    @Test
    public void testCheckUserNameNoUnderscore() {
        assertFalse(login.checkUserName("kyle1"), 
            "Username without underscore should be invalid");
    }
    
    @Test
    public void testCheckUserNameTooLong() {
        assertFalse(login.checkUserName("kyle_123"), 
            "Username with >5 chars should be invalid");
    }
    
    @Test
    public void testCheckPasswordComplexityValid() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"), 
            "Password with 8+ chars, capital, number, and special char should be valid");
    }
    
    @Test
    public void testCheckPasswordComplexityTooShort() {
        assertFalse(login.checkPasswordComplexity("Pass1!"), 
            "Password with <8 chars should be invalid");
    }
    
    @Test
    public void testCheckPasswordComplexityNoCapital() {
        assertFalse(login.checkPasswordComplexity("password1!"), 
            "Password without capital letter should be invalid");
    }
    
    @Test
    public void testCheckPasswordComplexityNoNumber() {
        assertFalse(login.checkPasswordComplexity("Password!"), 
            "Password without number should be invalid");
    }
    
    @Test
    public void testCheckPasswordComplexityNoSpecialChar() {
        assertFalse(login.checkPasswordComplexity("Password1"), 
            "Password without special char should be invalid");
    }
    
    @Test
    public void testCheckCellPhoneNumberValid() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"), 
            "Cell number with +27 and 9 digits should be valid");
    }
    
    @Test
    public void testCheckCellPhoneNumberNoInternationalCode() {
        assertFalse(login.checkCellPhoneNumber("0838968976"), 
            "Cell number without +27 should be invalid");
    }
    
    @Test
    public void testCheckCellPhoneNumberWrongLength() {
        assertFalse(login.checkCellPhoneNumber("+2783896897"), 
            "Cell number with incorrect length should be invalid");
    }
    
    @Test
    public void testRegisterUserSuccess() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(result.contains("successfully"), 
            "Registration with valid details should succeed");
    }
    
    @Test
    public void testRegisterUserInvalidUsername() {
        String result = login.registerUser("kyle", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(result.contains("Username is not correctly formatted"), 
            "Registration with invalid username should fail");
    }
    
    @Test
    public void testRegisterUserInvalidPassword() {
        String result = login.registerUser("kyl_1", "password", "+27838968976");
        assertTrue(result.contains("Password is not correctly formatted"), 
            "Registration with invalid password should fail");
    }
    
    @Test
    public void testRegisterUserInvalidCellNumber() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "0838968976");
        assertTrue(result.contains("Cell phone number is incorrectly formatted"), 
            "Registration with invalid cell number should fail");
    }
    
    @Test
    public void testLoginUserSuccess() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"), 
            "Login with correct credentials should succeed");
    }
    
    @Test
    public void testLoginUserWrongPassword() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("kyl_1", "wrongpassword"), 
            "Login with wrong password should fail");
    }
    
    @Test
    public void testLoginUserWrongUsername() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("wronguser", "Ch&&sec@ke99!"), 
            "Login with wrong username should fail");
    }
    
    @Test
    public void testReturnLoginStatusSuccess() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        String message = login.returnLoginStatus(true, "kyl_1");
        assertTrue(message.contains("Welcome"), 
            "Successful login should return welcome message");
    }
    
    @Test
    public void testReturnLoginStatusFailure() {
        String message = login.returnLoginStatus(false, "kyl_1");
        assertTrue(message.contains("incorrect"), 
            "Failed login should return error message");
    }
    
    @Test
    public void testReturnLoginStatusNameExtraction() {
        login.registerUser("john_doe", "P@ssword1", "+27831234567");
        String message = login.returnLoginStatus(true, "john_doe");
        assertTrue(message.contains("Welcome john, doe"), 
            "Should extract first and last name from username");
    }
}