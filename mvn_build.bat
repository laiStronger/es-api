cd /d %~dp0
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_91
::set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_91
call mvn clean install eclipse:eclipse  -DdownloadSources -Dmaven.test.skip=true
pause

