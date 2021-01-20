set catalina_home=C:\tomcat
set path=%path%;C:\jdk\bin

set currpath=.\
if "%OS%" == "Windows_NT" set currpath=%~dp0%

set src=%currpath%src
set dest=%currpath%classes
set classpath=%currpath%classes

javac  -Xlint:deprecation -Xlint:unchecked -sourcepath %src%  -d %dest% %src%\server\*.java
javac   -sourcepath %src%  -d %dest% %src%\client\*.java
