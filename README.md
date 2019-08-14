# GitRepoAccessRestProject
Task: Develop rest endpoints for User entity and accessing Git user repositories using tokens
----------------------------------------------------------------------------------------------

Instructions to Run :
---------------------
mvn clean install<br />
java -jar target/remind-git-rest-0.0.1-SNAPSHOT.jar<br />

Configurations :
------------------
Please change the personal access token for git in src/main/resources/application.properties.<br/>
auth.token=xxx

Git Repository Endpoint:
--------------------------
<pre>
GET http://localhost:1200/users/{userId}/repositories
[
   {
        "name": "GitRepoAccessRestProject",
        "full_name": "poojashrinidhi/GitRepoAccessRestProject",
        "url": "https://api.github.com/repos/poojashrinidhi/GitRepoAccessRestProject",
        "language": "Java"
    }
]
</pre>
<br/>
User Endpoints
----------------
<pre>
GET http://localhost:1200/users/
[
    {
        "id": "7445db46-fa5b-43ed-82f5-425011178edd",
        "created": "2019-08-14T16:11:39.554+0000",
        "lastModified": "2019-08-14T16:11:39.554+0000",
        "firstName": "Test",
        "surName": "TestSurname",
        "position": "Senioremployee",
        "githubProfileUrl": "https://github.com"
    }
]
