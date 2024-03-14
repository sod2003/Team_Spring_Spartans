# Team Spring Spartans: Project 3
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

## Testing Strategy
We used a various amounts of testing strategies, depending on the aspect of the project.
- Front End testing - Most Front End testing was manually done, under a painstaking amount of hours. Mostly out of necessity and lack of knowledge of appropriate tooling to use.
- Back End testing - With the Back End, we used JUnit testing and Mockito to mock certain Back End components. This was our most tool dependent testing strategy, and we've actually caught many issues with the Back End this way and were able to effectively improve the application experience from the test results.
- API testing - Most of the API testing was done through the use of Postman, or from the browser. Especially with the Security implementation, getting used to HTTP headers and request/response bodies was important to debugging our API issues.

## Misc Tools
- Trello - Having a Kanban board to organize our work tasks was crucial to breaking down the to-do list of activities that were needed to deliver the project. Trello was instrumental to our team keeping track of what needed doing, and what was done.
- Git and GitHub - The use of version control software, such as Git, was also valuable to the team for delivering the project and deconflicting what each team member was developing for the project.

## Lessons Learned
Lots of time needed for storming and norming, getting organized and putting processes in place were a big hurdle to the entire team working together. The use of tools helped alleviate the pain. Our team got excited for testing out new technologies, and sometimes they worked instantly, sometimes they added stressors when debugging issues while getting them integrated into the project. We had to make some difficult decisions for getting the project done, so not everything was ideal when delivered in the initial state.

## Roadmap for the Future
[ ] - API and Backend extentions
[ ] - Swagger integration
[ ] - CSS Framework standardization
[ ] - Business Logic review
[ ] - ERD/Database Refinement

## Credits
Team Members and Roles:
- Sean O' Dowd - Team leader & Backend
- Carlos Morales - UX & Frontend
- Samuel Park - Logistics & Frontend
