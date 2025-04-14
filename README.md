# ST10447256-PROG5121-POE

# Login and Registration System - Java Swing Application

## Overview
This Java Swing application provides a user-friendly interface for registering and logging in users with proper validation. The system includes:
- A login form with username and password fields
- User registration with validation for username, password, and cell phone number
- Secure password handling
- Input validation with helpful error messages

## Features

### User Registration
- **Username Validation**: Must contain an underscore and be ≤5 characters
- **Password Complexity**: Requires:
  - At least 8 characters
  - 1 uppercase letter
  - 1 number
  - 1 special character
- **Cell Phone Validation**: Must be a valid South African number (+27 followed by 9 digits)

### Login System
- Validates credentials against registered user data
- Provides personalized welcome messages
- Secure password handling (clears password array after use)

### UI Components
- Clean, responsive interface with two panels:
  - Left panel: Application branding ("Opellink") and registration button
  - Right panel: Login form with username/password fields

## Code Structure

### Main Classes
1. `Login` - Handles the login form and authentication logic
2. `Register` - Handles user registration (launched from login form)

### Key Methods
- `checkUserName()` - Validates username format
- `checkPasswordComplexity()` - Uses regex to validate password requirements
- `checkCellPhoneNumber()` - Validates South African phone format
- `registerUser()` - Orchestrates registration with validation
- `loginUser()` - Authenticates users
- `returnLoginStatus()` - Generates personalized login messages

## Usage
1. Run the application (main method in `Login` class)
2. Click "Register" to create a new account (with valid credentials)
3. Return to login page and enter credentials
4. Successful login shows personalized welcome message

## Security Notes
- Passwords are handled securely (cleared from memory after use)
- Input validation prevents invalid data storage
- No persistent storage in this version (user data only stored in memory)

## Requirements
- Java 8 or higher
- Swing libraries

This application demonstrates proper form validation, secure credential handling, and a clean user interface using Java Swing.

# Registration System - Java Swing Application

## Overview
This Java Swing application provides a user registration interface that connects with the login system. The registration form collects and validates user credentials before storing them for future authentication.

## Features

### User Registration
- **Username Validation**: 
  - Must contain an underscore (_)
  - Maximum 5 characters long
- **Password Complexity**: 
  - Minimum 8 characters
  - At least 1 uppercase letter
  - At least 1 number
  - At least 1 special character (@#$%^&+=!)
- **Cell Phone Validation**:
  - Must be a valid South African number
  - Format: +27 followed by 9 digits (12 characters total)

### UI Components
- Clean two-panel interface:
  - Left panel: Application branding ("Opellink") with login navigation
  - Right panel: Registration form with:
    - Username field
    - Password field (masked input)
    - Cell phone number field
    - Register button
- Visual feedback for registration status

## Code Structure

### Main Class
`Register` - Handles the registration form and validation through the `Login` system

### Key Methods
- `jButtonRegisterActionPerformed()`: 
  - Collects user input
  - Validates through `loginSystem.registerUser()`
  - Shows appropriate success/error messages
  - Clears fields after registration attempt
- `jButtonBackActionPerformed()`:
  - Closes registration form
  - Opens login form for returning users

### Integration
- Uses the `Login` class instance (`loginSystem`) to:
  - Validate credentials
  - Store registered user data
  - Maintain consistency between registration and login systems

## Usage
1. User enters:
   - Username (with underscore, ≤5 chars)
   - Complex password
   - Valid South African cell number (+27XXXXXXXXX)
2. Clicks "Register" button
3. Receives immediate feedback about registration status
4. Can navigate back to login page if already registered

## Validation Messages
The system provides specific error messages for:
- Incorrect username format
- Weak password
- Invalid phone number
- Successful registration

## Security Features
- Password field uses masked input
- Sensitive data cleared after processing
- Validation occurs before storing any credentials

## Requirements
- Java 8 or higher
- Swing libraries
- Integrated with the Login system class

This registration module demonstrates proper form design, input validation, and integration with an authentication system using Java Swing.

# Login System - JUnit Test Suite

## Overview
This JUnit 5 test suite validates the functionality of the `Login` class, ensuring proper username, password, and cell phone number validation, as well as registration and login processes.

## Test Categories

### 1. Username Validation Tests
- ✅ `testCheckUserNameCorrectFormat()`  
  Verifies valid usernames containing underscore with ≤5 characters
- ❌ `testCheckUserNameNoUnderscore()`  
  Checks rejection of usernames without underscore
- ❌ `testCheckUserNameTooLong()`  
  Ensures usernames >5 characters are rejected

### 2. Password Complexity Tests
- ✅ `testCheckPasswordComplexityValid()`  
  Validates proper complex passwords (8+ chars with capital, number, special char)
- ❌ `testCheckPasswordComplexityTooShort()`  
  Checks rejection of passwords <8 characters
- ❌ `testCheckPasswordComplexityNoCapital()`  
  Ensures passwords without capital letters are rejected
- ❌ `testCheckPasswordComplexityNoNumber()`  
  Verifies passwords without numbers are rejected
- ❌ `testCheckPasswordComplexityNoSpecialChar()`  
  Tests rejection of passwords without special characters

### 3. Cell Phone Validation Tests
- ✅ `testCheckCellPhoneNumberValid()`  
  Validates correct South African format (+27 followed by 9 digits)
- ❌ `testCheckCellPhoneNumberNoInternationalCode()`  
  Checks rejection of numbers without +27 prefix
- ❌ `testCheckCellPhoneNumberWrongLength()`  
  Ensures incorrect digit counts are rejected

### 4. Registration Process Tests
- ✅ `testRegisterUserSuccess()`  
  Verifies successful registration with valid credentials
- ❌ `testRegisterUserInvalidUsername()`  
  Tests registration failure with invalid username
- ❌ `testRegisterUserInvalidPassword()`  
  Tests registration failure with invalid password
- ❌ `testRegisterUserInvalidCellNumber()`  
  Tests registration failure with invalid cell number

### 5. Login Process Tests
- ✅ `testLoginUserSuccess()`  
  Validates successful login with correct credentials
- ❌ `testLoginUserWrongPassword()`  
  Ensures login fails with wrong password
- ❌ `testLoginUserWrongUsername()`  
  Verifies login fails with wrong username

### 6. Login Status Messages
- ✅ `testReturnLoginStatusSuccess()`  
  Checks proper welcome message generation
- ❌ `testReturnLoginStatusFailure()`  
  Validates correct error message for failed logins
- ✅ `testReturnLoginStatusNameExtraction()`  
  Tests proper name extraction from usernames (firstname_lastname format)

## Test Lifecycle
- `@BeforeEach`: Creates fresh `Login` instance before each test
- `@AfterEach`: Clears registration data after each test
- Tests are isolated and independent

## Usage
1. Run tests to verify `Login` class functionality
2. Tests serve as specification for expected behavior
3. Failed tests indicate bugs in validation logic

## Requirements
- JUnit 5
- `Login` class implementation
- Java 8 or higher

This comprehensive test suite ensures robust validation and authentication functionality in the login system, covering all critical paths and edge cases.
