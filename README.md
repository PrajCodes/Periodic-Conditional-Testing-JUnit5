# Periodic-Conditional-Testing-JUnit5-
Using Java's Extension API and Reflection API to conditionally execute just few test cases out of many test cases in JUnit5

This is an illustration of how we can use the extention API of Java to enable some test cases at runtime. 
The goal is to support periodic execution of test cases. 
Periodic.java :  This is an annotation supporting the “period” element with a default value of 1 (execute every test). It is represented as a java interface. 
PeriodicEnabling.java implements ExecutionCondition where we can keep track of which test we're executing and enable or disable the particular test case. 

In order to execute this sample code , 1) JUnit 5 Jupiter Library (https://junit.org/junit5/ ) has to be imported in the project to run the TempTest.java 
