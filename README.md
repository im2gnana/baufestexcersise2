# Baufest Exercise 

### There are three types of automation in this exercise: web, web service, and mobile. Lets discuss one by one in the following line-

## Web:
1. Automating UI page https://www.demoblaze.com/index.html
2. Sign up/Sign in  any user
3. Validate if the user is already exist
4. If the user is exist then go to product list then add any laptop from list
5. Then verify whether the product is added or not
6. Then logout the user

## Web Services
1. Access to the swagger and select the few endpoint
2. Verify the POST/GET/PUT method is able to return 200 successful status and response as JSON
3. Then verify the POST/GET/PUT is also returning any error status code for invalid entry

## Mobile Automation
1. Download an demo API file
2. Verify the user is able to signup
3. Then verify the user is able to login
4. Verify the user is able to access FORM and provide an entry
5. Then verify the Web view

### Tools
- Intellij Idea JDK
- Maven
- Cucumber-JVM
- Appium/Inspector
- Android Studio
- Rest Assured

# Requirements
### In order to utilise this project you need to have the following installed locally:
- Intellij Idea JDK
- Appium
- Android Studio

#What is implemented?
Appium for Mobile automation
        <dependency>
            <groupId>io.appium</groupId>
            <artifactId>java-client</artifactId>
            <version>9.0.0</version>
        </dependency>

Rest Assured for API automation
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.3.2</version>
            <scope>test</scope>
        </dependency>

        What also can be used?
        
          <dependency>
          <groupId>com.squareup.okhttp3</groupId>
          <artifactId>okhttp</artifactId>
          <version>5.0.0-alpha.11</version>
          </dependency>
          OR
          <dependency>
          <groupId>com.konghq</groupId>
          <artifactId>unirest-java</artifactId>
          <version>4.0.0-RC2</version>
          </dependency>
          
Allure Result
        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-cucumber7-jvm</artifactId>
            <version>2.25.0</version>
        </dependency>

What need to be fixed?
Since the driver has been declared the stepdef itself. Its opening while running API script and also we need appium dependency application as well to run UI scripts. This should be fixed by creating browser class file.

What is not completed?
Mobile automation webview is not developed since the page is not working or the service might be down.
<img width="1431" alt="Screenshot 2023-12-10 at 11 22 12 PM" src="https://github.com/im2gnana/baufestexcersise2/assets/153252230/5d44ac90-e2e7-4acf-aa17-ef4f8ee69695">
