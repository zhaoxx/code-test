rm -rf *.class
find -name "*.java" > source.txt
javac -encoding UTF-8 @source.txt
rm -rf source.txt
java MyCalendarTester