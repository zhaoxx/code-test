rm -rf *.class
find -name "*.java" > source.txt
javac -encoding UTF-8 @source.txt
java MyCalendarTester