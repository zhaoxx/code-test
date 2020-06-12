del *.class /s
dir /s /b *.java >source.txt
javac -encoding UTF-8 @source.txt
java MyCalendarTester