#COMPILE AND RUN MY JUNITS


##Command Line
1. `javac -cp $(JUNIT_HOME)/junit-4.10.jar NuPack.java NuPackTest.java`
2. `java -cp $(JUNIT_HOME)/junit-4.10.jar org.junit.runner.JUnitCore NuPackTest`

##Makefile
1. Modify the path $(JUNIT_HOME) in accordante with the path where junit is in your local machine
2. Run `make run` command line.
