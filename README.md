# Team_Spring_Spartans
Project 3 for Java VET TEC 202311 Cohort Spring Spartan Team

## Spartan Wireless
What our clients say about Spartan Wireless: "This is WIRELESS!!!". 
The name of our application is Spartan Wireless, and it is a full-stack web application.

- The purpose is to provide a phone carrier with a functional and user-friendly website. The functionalities include the abilitiy to login/register, save/maintain user specific data, view/select phone plans, add lines, purchase phones, and view a report of total costs.
- The technologies we used include MySQL for our database system, Java and Spring for our server side systems, Typescript and Angular for our client side systems, Git for version control, Trello for managing tasks, and Discord for communication.
- Some challenges we faced were security and authentication implementations within backend configurations. Some things we learned are keeping the server system stateless for a consistent communication and response to clients.

## How to install and run the project
- The requirements to cloning and running our project include, Java 17, Spring, a POM file with all dependencies to third parties software including MySQL RDBMS.
- Create schema spartan_wireless in MySQL workbench. When the server side application runs, the database will also run on local host port 3306.
- Run the backend application from the main SpartanWirelessApplication.java file as a Spring project. The Spring application will run on local host port 8080. 
- Run the frontend application from the terminal within the frontend directory by using the ng serve command. The Angular application will run on local host port 4200.

## How to use the project
- Once the application is running, type in http://localhost:4200 into your browser of choice (preferably chrome). You will be greeted by our home page. You can read about our services, or you can get started by logging in or registering.
- In the login and register page, you will be guided by validation feedback immediately to help you input valid information and credentials. The user input was made dynamic using Angular's reactive forms. Once you log in, you will be greeted by your personal dashboard. 
- In your dashboard, you will see the plans and devices you chose to purchase. This information is only available to you, and no other user will see your purchases, plans, or information about your profile. There are options to either purchase a plan, add a line, and purchase a device.
- In the phone plan page, you have the option to click on different buttons to choose a plan. Once you choose a plan the cost of the plan will be added to your total purchase amount. Here you can choose to add a line, or you can add a line at a later time too. 
- In the phone device page, you have the option to search different devices we offer. Once you choose a plan the cost of the plan will also be added to your total purchase amount.

## Credits
Team Members and Roles:
Sean O' Dowd - Team leader & Backend
Matthew Simmons - Devops & Backend
Carlos Morales - UX & Frontend
Samuel Park - Logistics & Frontend

