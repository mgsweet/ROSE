echo off
javac -d bin -classpath ../bin src/exceptions/*.java
cd src
javac -d ../bin -Djava.ext.dirs=../lib *.java
cd ..

echo on