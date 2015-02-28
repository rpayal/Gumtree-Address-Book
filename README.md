# Gumtree-Address-Book
Gumtree Address Book test

Task;
Your task is to develop a small java application. We need you to build your application in your own GitHub repository. Please do not fork our repository to create your project. Once you are done, send us a link to your repository. Alternatively you can just zip-up the project folder and send it to gumtreetasks at hotmail.co.uk
Please allow yourself at least 1 hour of uninterrupted time for this task, but feel free to spend as much time on the task as you like and make the solution and the code as perfect as you like.

Your application needs to read the attached AddressBook file and answer the following questions:
How many males are in the address book?
Who is the oldest person in the address book?
How many days older is Bill than Paul?
Some insights into what we'll be looking for (and what we will not):

Feel free to use any dependency management and build tools eg maven or gradle
Please do not use database, we are more interested in your Java skills than your SQL skills
Feel free to commit as often as you'd like. The more commits the better! Please commit at least once within the first hour
It's better to complete 1 task than to start 3
Feel free to use any java libraries you feel appropriate
We will be looking at how you approach the task (e.g. how you break it into sub-tasks) and how you structure your code to answer the questions


Solution;
- Start the application

Using REST client
> to get How many males are in the address book ?
http://localhost:8585/gumtree/rest/person/Male/count
result - 3
> to get Who is the oldest person in the address book ?
http://localhost:8585/gumtree/rest/person/oldest
result - Wes Jackson
> to get How many days older is Bill than Paul ?
http://localhost:8585/gumtree/rest/person/agediff
2862
