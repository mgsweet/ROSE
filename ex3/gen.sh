cd src/
source ~/.bash_profile
jflex oberon.flex
java -jar ../lib/java-cup/java-cup-11b.jar oberon.cup 
cd ..

echo 
echo finish!
