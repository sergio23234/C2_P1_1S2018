SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_77\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH= C:\Users\sergi\Documents\Fuentes\java-cup-11b.jar
cd C:\Users\sergi\Documents\GitHub\C2_P1_1S2018\C2_P1_201213282\src\Analizadores
java -jar C:\Users\sergi\Documents\Fuentes\java-cup-11b.jar -parser Sintactico_CCSS  -symbols symc Sintactico_CCSS
pause