package resources;

public class Constants {

    // addresses
    public static final String HOMEPAGE_URL = "https://parabank.parasoft.com/parabank/index.htm";
    public static final String LOGIN_URL = "https://parabank.parasoft.com/parabank/login.htm";
    public static final String FORGOT_USER_URL = "https://parabank.parasoft.com/parabank/lookup.htm";
    public static final String LOGGED_IN_URL = "https://parabank.parasoft.com/parabank/overview.htm";
    public static final String REGISTER_URL = "https://parabank.parasoft.com/parabank/register.htm";

    // element locators
    // login
    public static final String LOGIN_USERNAME_FIELD = "username"; //name
    public static final String LOGIN_PASS_FIELD = "password"; //name
    public static final String LOGIN_BUTTON = "//*[@id='loginPanel']/form/div[3]/input"; //xpath
    public static final String LOGIN_ERROR_MSG = "rightPanel"; //id
    public static final String FORGET_LOGIN_INFO_LINK = "//a[contains(text(),'Forgot login info?')]"; //xpath
    public static final String REGISTER_LINK = "//a[contains(text(),'Register')]"; //xpath

    //register
    public static final String REGISTER_FIRSTNAME_FIELD = "customer.firstName"; // id
    public static final String REGISTER_FIRSTNAME_ERROR_MSG = "customer.firstName.errors"; //id
    public static final String REGISTER_LASTNAME_FIELD = "customer.lastName"; //id
    public static final String REGISTER_LASTNAME_ERROR_MSG = "customer.lastName.errors"; //id
    public static final String REGISTER_ADDRESS_FIELD = "customer.address.street"; //id
    public static final String REGISTER_ADDRESS_ERROR_MSG = "customer.address.street.errors"; //id
    public static final String REGISTER_CITY_FIELD = "customer.address.city"; //id
    public static final String REGISTER_CITY_ERROR_MSG = "customer.address.city.errors"; //id
    public static final String REGISTER_STATE_FIELD = "customer.address.state"; //id
    public static final String REGISTER_STATE_ERROR_MSG = "customer.address.state.errors"; //id
    public static final String REGISTER_ZIPCODE_FIELD = "customer.address.zipCode"; //id
    public static final String REGISTER_ZIPCODE_ERROR_MSG = "customer.address.zipCode.errors"; //id
    public static final String REGISTER_PHONE_FIELD = "customer.phoneNumber"; //id
    public static final String REGISTER_SSN_FIELD = "customer.ssn"; //id
    public static final String REGISTER_SSN_ERROR_MSG = "customer.ssn.errors"; //id
    public static final String REGISTER_USERNAME_FIELD = "customer.username"; //id
    public static final String REGISTER_USERNAME_ERROR_MSG = "customer.username.errors"; //id
    public static final String REGISTER_PASS_FIELD = "customer.password"; //id
    public static final String REGISTER_PASS_ERROR_MSG = "customer.password.errors"; //id
    public static final String REGISTER_CONFIRM_FIELD = "repeatedPassword"; //id
    public static final String REGISTER_CONFIRM_ERROR_MSG = "repeatedPassword.errors"; //id
    public static final String REGISTER_BUTTON = "//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input"; //xpath
    public static final String REGISTER_FORM = "customerForm"; //id

    //forget info
    public static final String FORGET_FORM = "lookupForm"; //id
    public static final String FORGET_FIRSTNAME = "firstName"; //id
    public static final String FORGET_FIRSTNAME_ERROR_MSG = "firstName.errors"; //id
    public static final String FORGET_LASTNAME = "lastName"; //id
    public static final String FORGET_LASTNAME_ERROR_MSG = "lastName.errors"; //id
    public static final String FORGET_ADDRESS = "address.street"; //id
    public static final String FORGET_ADDRESS_ERROR_MSG = "address.street.errors"; //id
    public static final String FORGET_CITY = "address.city"; //id
    public static final String FORGET_CITY_ERROR_MSG = "address.city.errors"; //id
    public static final String FORGET_STATE = "address.state"; //id
    public static final String FORGET_STATE_ERROR_MSG = "address.state.errors"; //id
    public static final String FORGET_ZIPCODE = "address.zipCode"; //id
    public static final String FORGET_ZIPCODE_ERROR_MSG = "address.zipCode.errors"; //id
    public static final String FORGET_SSN = "ssn"; //id
    public static final String FORGET_SSN_ERROR_MSG = "ssn.errors"; //id
    public static final String FIND_LOGIN_INFO_BUTTON = "//*[@id='lookupForm']/table/tbody/tr[8]/td[2]/input"; //xpath

    public static final String LOG_OUT = "//a[contains(text(),'Log Out')]"; //xpath

    // overview page
    public static final String SITE_MAP = "//a[contains(text(),'Site Map')]"; //xpath
    public static final String OPEN_NEW_ACCOUNT = "//a[contains(text(), 'Open New Account')]"; //XPATH
    public static final String ACCOUNT_OVERVIEW = "//a[contains(text(), 'Accounts Overview')]"; //XPATH
    public static final String TRANSFER_FUNDS = "//a[contains(text(), 'Transfer Funds')]"; //XPATH
    public static final String BILL_PAY = "//a[contains(text(), 'Bill Pay')]"; //XPATH
    public static final String FIND_TRANSACTIONS = "//a[contains(text(), 'Find Transactions')]"; //XPATH
    public static final String UPDATE_PROFILE = "//a[contains(text(), 'Update')]"; //XPATH
    public static final String REQUEST_LOAN = "//a[contains(text(), 'Request Loan')]"; //XPATH





}
