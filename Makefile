.phony: all run clean

JUNIT_HOME = :/Library/JUNIT
NAME = "NuPackTest"

all:
	@echo "Compiling..."
	javac -cp $(JUNIT_HOME)/junit-4.10.jar *.java

run: all
	@echo "Running..."
	java -cp $(JUNIT_HOME)/junit-4.10.jar org.junit.runner.JUnitCore $(NAME)

clean:
	rm *.class
