# Final Project - Automation Testing

## Overview
This project involves automating the testing of the **Parabank Registration Site**: [Parabank Register](https://parabank.parasoft.com/parabank/register.htm). The test cases are selected from Zephyr, with a focus on automating one **high priority** and one **medium priority** test case. The automation code interacts with the Parabank registration and login pages, verifying user actions such as registration, login, and account navigation.

## Project Details
- **Website URL**: [https://parabank.parasoft.com/parabank/register.htm](https://parabank.parasoft.com/parabank/register.htm)
- **Registration Info**: Due to automatic user deletion every 30 minutes, the user needs to be recreated for each test session.

### Test Cases Automated
- **High Priority Test Case**: Validates user login functionality after registration.
- **Medium Priority Test Case**: Verifies account navigation and details after login.

### Tests Selected for Automation
- **BM-T6**: Account link redirects user to correct account details page.
- **BM-T9**: Basic navigation through the site.

## Setup Instructions

### Prerequisites
- **Java** version 8 or above.
- **Maven** for dependency management.
- **Selenium WebDriver** (configured in the Maven `pom.xml`).
- **GitHub Repository** for version control and code submission.

### Clone the Repository
```bash
git clone https://github.com/your-username/final-project.git
