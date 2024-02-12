# AutomationExercise

**This is a test automation project of the [AutomationExercise website](https://automationexercise.com), which is an e-commerce demo.**

There are [26 sample test scenarios](https://automationexercise.com/test_cases) on the AutomationExercise website. I created this automation project based on these scenarios. I made minor changes to some steps to increase reusability.

I used the following dependencies in this project;

* [Selenium 4.17](https://github.com/emrekocamann/AutomationExercise/tree/master#selenium)
* [Cucumber 7.4](https://github.com/emrekocamann/AutomationExercise/tree/master#cucumber)
* [Cucumber-JUnit](https://github.com/emrekocamann/AutomationExercise/tree/master#cucumber-junit)
* [AssertJ](https://github.com/emrekocamann/AutomationExercise/tree/master#assertj)
* [JavaFaker](https://github.com/emrekocamann/AutomationExercise/tree/master#javafaker)
* [Lombok](https://github.com/emrekocamann/AutomationExercise/tree/master#lombok)
* [commons-io](https://github.com/emrekocamann/AutomationExercise/tree/master#commons-io)

If you like this Repo, Please click the ⭐


### Selenium:

As most people interested in test automation know, Selenium is used to automate browsers.

### Cucumber:

Cucumber is a software testing tool based on the BDD (Behavior Driven Development) methodology that allows us to write test scenarios using the gherkin language and make these scenarios readable by anyone.

### cucumber-junit:

This dependency is used to integrate Cucumber-based BDD scenarios with the JUnit framework. It helps to run Cucumber scenarios (via the Runner Class), generate test reports, and better manage automated testing processes.

### AssertJ:

AssertJ is a Java library that provides a set of assertions and helpful error messages.
I used AsserJ's soft assert feature in this project.

### JavaFaker

JavaFaker is a library that can be used to generate a wide array of real-looking data from addresses to popular culture references.

### Lombok

Lombok is a Java library that automatically generates boilerplate code, such as getters, setters, and constructors, using annotations such as: @Data, @Getter, or @Setter This helps to reduce the amount of repetitive code you need to write, making your code cleaner and easier to read.

### commons-io:

There is a file download test in this project. Every time this test runs, the file must be added to the project and verification must be performed. I used the FileUtils class of this dependency to delete this downloaded file at the beginning of each run.
