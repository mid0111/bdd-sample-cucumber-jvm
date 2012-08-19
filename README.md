bdd-sample-cucumber-jvm
=======================

This is a sample project of cucumber-jvm.  
See [Cucumber project page] (http://cukes.info/).  


Install Cucumber-jvm
--------------------
Maven installation

    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
    	<version>4.10</version>
    	<scope>test</scope>
    </dependency>
    <dependency>
    	<groupId>info.cukes</groupId>
    	<artifactId>cucumber-java</artifactId>
    	<version>1.0.11</version>
    </dependency>
    <dependency>
    	<groupId>info.cukes</groupId>
    	<artifactId>cucumber-junit</artifactId>
    	<version>1.0.11</version>
    </dependency>


Describe Scenario File
----------------------

    Feature: ユーザModels

    Scenario: ユーザ名を指定して登録する
        Given   ユーザ名 'tajima'
        When    ユーザを登録する
        Then    ユーザ名のみのオブジェクトが登録されること
            """
            {"name":"tajima","projects":[]}
            """

**[sample] (https://github.com/mid0111/bdd-sample-cucumber-jvm/blob/master/src/test/resource/sample/test/UserModels.feature)**

**[sample described in japanese] (https://github.com/cucumber/cucumber/tree/master/examples/i18n/ja)**

Compile Scenario File
---------------------

+ To run the .feature using a JUnit Runner, create a blank test class.

        package sample.test;
    
        import org.junit.runner.RunWith;
    
        import cucumber.junit.Cucumber;
    
        @RunWith(Cucumber.class)
        @Cucumber.Options(format = { "pretty", "html:target/cucumber" })
        public class RunTests {
      
        }

+ Run Junit test, and Take a look at the output in the Console Tab in Eclipse.

        You can implement missing steps with the snippets below:
    
        @Given("^ユーザ名 'tajima'$")
        public void ユーザ名_tajima() throws Throwable {
            // Express the Regexp above with the code you wish you had
            throw new PendingException();
        }
        
        @When("^ユーザを登録する$")
        public void ユーザを登録する() throws Throwable {
            // Express the Regexp above with the code you wish you had
            throw new PendingException();
        }
        
        @Then("^ユーザ名のみのオブジェクトが登録されること$")
        public void ユーザ名のみのオブジェクトが登録されること(String arg1) throws Throwable {
            // Express the Regexp above with the code you wish you had
            throw new PendingException();
        }


Describe code
-------------

+ [feature file] (https://github.com/mid0111/bdd-sample-cucumber-jvm/blob/master/src/test/resource/sample/test/UserModels.feature)  
+ [test code] (https://github.com/mid0111/bdd-sample-cucumber-jvm/blob/master/src/test/java/sample/test/Models/doUserModels.java)  
+ [assertThat] (http://www.jmock.org/javadoc/2.4.0/org/hamcrest/CoreMatchers.html)  


JUnit
-----

![image] (https://github.com/mid0111/bdd-sample-cucumber-jvm/blob/master/readme/Cucumber-Junit.png?raw=true)


HTML Report
-----------

**TODO**

[jenkins-cucumber-jvm-reports-plugin] (https://github.com/masterthought/jenkins-cucumber-jvm-reports-plugin)