#**App Automation Test**

## Must have before start

- Git
- Docker

### Steps

1. Pull the docker image containing the web app
`docker pull automaticbytes/demo-app`

2. Run the image
`docker run -p 3100:3100 automaticbytes/demo-app`

3. Verify the app is shown in below url and set it as the base url for the test.java.tests.
`http://localhost:3100`

4. Fork this repository and develop your test.java.tests following bellow guidances/requisites.

5. When finished open a Pull Request for Code Review.

### General requisites for submission

1. Programming languages
   - Java or Javascript are preferred.
   - Other languages like C#, Go or Python are accepted but bear in mind we work in Java/Javascript

2. Drivers. Any of these are accepted
   - Selenium Webdriver
   - Playwright
   - Puppeteer

3. Browsers
	- Chrome (preferred)
	- Firefox

### General test requisites
- All test.java.tests should provide a setup and tear down mechanism that opens and closes the browser.
- All test.java.tests should run successfully either from IDE or command line.
- Instructions to build and run the code and test.java.tests submitted must be provided.
- Submitted code implementing a Page Object Model will be taken in high consideration.

### Tests Scenarios
1.  Login Success
   - Navigate to http://localhost:3100/login
   - Successfully login with credentials: johndoe19/supersecret
   - Assert that welcome message containing username is shown.

2. Login Failure A
   - Navigate to http://localhost:3100/login
   - Enter wrong username/password
   - Assert error message is shown.

3. Login Failure B
   - Navigate to http://localhost:3100/login
   - Leave both username/password in blank
   - Assert error message is shown.

4. Checkout Form Order Success
   - Navigate to http://localhost:3100/checkout
   - Complete all the fields
   - Verify that if "Shipping address same as billing" checkbox is not checkmarked then checkmark it.
   - Submit the form and assert that the order confirmation number is not empty.

5. Checkout Form Alert
   - Navigate to http://localhost:3100/checkout
   - Complete all the fields
   - Verify that if "Shipping address same as billing" checkbox is checkmarked, then uncheckmark it.
   - Try to submit the form and validate that the alert message is shown and confirm the alert.
   - Assert alert is gone.

6. Cart Total Test
    - Navigate to http://localhost:3100/checkout
	- Assert that the cart total shown is correct for the item prices added.

7. Grid Item Test
    - Navigate to http://localhost:3100/grid
    - Assert that in position 7 the product shown is "Super Pepperoni"
	- Assert that the price shown is $10
	
8. Grid All Items Test	
	- Navigate to http://localhost:3100/grid
	- Assert that all the items have a non empty title, price, image and a button.

9. Search Success
  - Navigate to http://localhost:3100/search
  - Search for any word (for instance automation)
  - Assert that "Found one result for" plus the word you searched is shown.

10. Search Empty
	- Navigate to http://localhost:3100/search
	- Leave search box empty and submit the search
	- Assert that "Please provide a search word." message is shown.
