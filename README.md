# E-Commerce Selenium Automation Testing – SauceDemo

## Project Overview

- This project demonstrates UI automation testing of an e-commerce web application using Selenium WebDriver and Java.

- The project focuses on automating common user workflows, including login, product selection, shopping cart operations, and checkout functionality.

## Tools & Technologies

- Java
- Selenium WebDriver
- TestNG
- Maven
- XPath and CSS Selectors
- Git & GitHub

## Application Tested

- SauceDemo e-commerce web application.
- URL: https://www.saucedemo.com/

## Testing Performed

- Login functionality validation
- Positive and negative login testing
- Product listing validation
- Add-to-cart functionality testing
- Shopping cart validation
- Checkout workflow testing
- Form field validation
- Web element identification and interaction
- Explicit waits and synchronization
- Test execution and assertion validation using TestNG

## Test Approach

- Designed test scenarios for key e-commerce workflows.
- Used Selenium WebDriver to interact with web elements.
- Used TestNG assertions to validate expected results.
- Used explicit waits to handle dynamic page elements.

## Test Execution

### Prerequisites

- Java JDK installed
- Maven installed
- Google Chrome browser installed

### Steps to Run Tests

- Clone the repository.
- Open the project in IntelliJ IDEA or Eclipse.
- Update the required configuration in GlobalData.properties.
- Run the test suite using Maven.

 Execute the following command from the project root directory:
```bash
mvn clean test
```

### Test Reports

- After execution, check the generated Extent Report in the reports/ directory, if configured to generate it there.

- The report provides details about test execution status and failures.

## Project Structure

ecommerce-selenium-automation/
├── src/main/java/
│   ├── pageObjects/
│   │   ├── CartPage.java
│   │   ├── CheckoutPage.java
│   │   ├── ConfirmationPage.java
│   │   ├── LoginPage.java
│   │   └── ProductPage.java
│   ├── resources/
│   │   ├── ExtentReporterNg.java
│   │   └── GlobalData.properties
│   └── utils/
│       └── ReusableCode.java
├── src/test/java/
│   ├── data/
│   │   └── Data.json
│   ├── ecommerce/
│   │   ├── ErrorValidationTest.java
│   │   └── SubmitOrderTest.java
│   └── testComponents/
│       ├── BaseTest.java
│       └── Listeners.java
├── reports/
│   ├── index.html
│   └── loginError.png
├── testSuites/
├── pom.xml
└── README.md
