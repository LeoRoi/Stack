# make -p -f /dev/null | less
# find -name "*.class" -delete
# find -name "*.java" >> Makefile
# find -name "Test*" >> Makfefile
# sudo apt-get install junit
# sudo find / -name junit*  

# Compile and run (JUNIT 4)
# javac -cp /usr/share/java/junit.jar $(SOURCES) ./src/test/TestStudent.java
# JUNIT 3 java -cp /usr/share/java/junit.jar:. junit.textui.TestRunner ./src/test/TestStudent.java

# Compile and run (JUNIT 4)
# javac -cp /usr/share/java/junit4.jar
# JUNIT 4 java -cp /usr/share/java/junit4.jar:. org.junit.runner.JUnitCore ./src/test/TestStudent.java

JC = javac
JCFLAGS = -g
BINDIR = bin

JDOC = javadoc
DOCDIR = java-doc

JAVA = java 

SOURCES = \
	src/Demo.java \
	src/data/CourseList.java \
	src/data/Student.java \
	src/stack/Stack.java \
	src/stack/Stackable.java \
	src/stack/Tools.java \

TESTS = \
	src/TestE03.java \


CLASSPATHS=bin:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar

# Wichtig Pfad zur Klasse mit der public void static main Funktion. Bei mir liegt diese im Package main/Main.java 
MAIN = Demo

TESTMAIN = TestE03

default: 
	mkdir -p $(BINDIR)
	$(JC) $(JCFLAGS) -cp $(CLASSPATHS) $(SOURCES) $(TESTS) -d $(BINDIR) 

run:
	$(JAVA) -cp $(CLASSPATHS) $(MAIN)

run-test: default
	$(JAVA) -cp $(CLASSPATHS) org.junit.runner.JUnitCore $(TESTMAIN)

doc:
	$(JDOC) -version -author -d $(DOCDIR) $(SOURCES)

clean:
	rm -rf $(BINDIR)

distclean: clean
	rm -rf $(DOCDIR)
