# **Automation challenge**

## Introduction 🚀

Automation made for a business challenge, with transactions to buy products and call API.

#### Scenarios

- Enter the website, search for a product, add it to the cart and validate that the product name remains in the cart, validate the message.
- Call an API, consume the POST method to update data, and validate that lastUpdate with GET method.

## Pre requirements to execute 📋
- Java version 1.8, update 151 or higher and JDK (environment variables configured).
- Eclipse IDE or IntelliJ IDEA (version 2018.3 or higher).
- Gradle version 6.0 or higher (environment variables configured).
- Cucumber for Java Plugin (updated version).
- Gherkin Plugin (updated version).
- ChromeDriver v89.

## Installation 🔧
- To clone this repository locally, the following command must be run: 
```git clone https://github.com/diegalez/RetoSophosSolutions.git``` 
- Import the project from Eclipse or IntelliJ IDE under the structure of an existing Gradle project. 
- Configure JRE System Library with JavaSE-1.8.
- Configure the encoding to UTF-8 to the project once it is imported.

## Compile the project and generate Wrapper 🔨
- To build the project you must run the command:
```gradle clean build -x test```
- To generate the project wrapper files, you must run the command:
```gradle wrapper --gradle-distribution-url https://services.gradle.org/distributions/gradle-6.0-bin.zip```

## Command for execution 💻
The project can be executed from the console with the following command:
```gradle clean test aggregate```

## Web browser 🌐
Automation currently runs in the following browsers:
- Google Chrome v85 or higher.

## Project structure 🚧

* ```src/main/java/com/sophossolutions/```
``` 
+ exceptions
    Classes that catch custom exceptions when automation fails and cannot find an expected field.

+ models
    Classes with which the data models are built using the builder pattern.

+ questions
    Classes with which values are obtained and then verified in the stepdefinitions (asserts).

+ tasks
    Classes that perform high-level actions, such as login in the application, enter data into a form, etc.

+ userinterface
    Classes where the elements of the user interface are mapped throw Xpaths.

+ utilities
    Classes that contain common functionalities.
```

* ```src/test/java/com/sophossolutions/```
```
+ runners
    Classes to run automation with the scenarios indicated in the feature.

+ stepdefinitions
    Classes that are the entry point of the feature to translate from Gherkin language to machine language and thus allow the execution of automation.
 ```

* ```src/test/resources/```
```

+ drivers
    WebDriver userd in automation.

+ features
    The project features are found.

```

## Built with 🛠
Automation was developed with:
 - BDD - Development strategy
 - Screenplay
 - Gradle - Dependency manager
 - Selenium Web Driver - Tool to automate actions in web browsers
 - Cucumber - Framework to automate BDD tests
 - Serenity BDD - Open source library for report generation
 - Gherkin - Business Readable DSL Language (Business-readable domain specific language)
 
## Versioning 📌 
Git was used for version control, applying GitFlow 🔀

## Authors 👨

* **Diego Alejandro Zapata Betancur** - [dazb12@hotmail.com]()