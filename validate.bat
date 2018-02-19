echo setting env and starting sudoku validator

SET JDK_PATH="C:\Program Files\Java\jdk1.7.0_80\bin\java"

SET CLASSPATH=%JDK_PATH%

java -jar target\UBSSudokuTest-0.0.1-SNAPSHOT.jar %*