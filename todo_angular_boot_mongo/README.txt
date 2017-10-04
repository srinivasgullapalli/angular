Pre-requisites and steps to run the application:
1.Install mongodb 3.4 or any latest version.

2.Create a directory to store mongo db data .example : c:\data\db.

3. Start the mongodb. Example : C:\Program Files\MongoDB\Server\3.4\bin>mongod.exe --dbpath \data\db

4. Install java8.(Make sure java home is set in enviroment variables.)

5. Install maven 3.3.3 or above.(Make sure maven home is set in enviroment variables.)

6. Clone or download the zip from github and copy to the local system.eg : D:\todo_angular_boot_mongo

7. Goto that particular directory using command prompt or console.eg : cd D:\todo_angular_boot_mongo

8. run the command mvn clean install eg : D:\todo_angular_boot_mongo>mvn clean install

9. On successfull build execute the command : mvn spring-boot:run

10. Open browser and type the URL  : http://localhost:8080/ or http://<ipaddress_of_the_server>:8080/
