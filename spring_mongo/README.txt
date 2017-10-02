Pre-requisites and steps to run the application:
1.Install mongodb 3.4 or any latest version.

2. Start the mongodb. Example : C:\Program Files\MongoDB\Server\3.4\bin>mongod.exe --dbpath \data\db

3. Install java8.(Make sure java home is set in enviroment variables.)

4. Install maven 3.3.3 or above.(Make sure maven home is set in enviroment variables.)

5. Clone or download the zip from github and copy to the local system.eg : D:\spring_mongo

6. Goto that particular directory using command prompt or console.eg : cd D:\spring_mongo

7. run the command mvn clean install eg : D:\spring_mongo>mvn clean install

8. On successfull build execute the command : mvn spring-boot:run

9. Open browser and type the URL  : http://localhost:8080/ or http://<ipaddress_of_the_server>:8080/
