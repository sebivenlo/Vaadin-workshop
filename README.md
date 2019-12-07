# Vaadin-workshop
Introducing Vaadin, an open source web framework to build progressive web apps and websites using Java

# Things you need to run this project:
  * Install docker
  [install Docker](https://docs.docker.com/docker-for-windows/install/)
  
## To run the project
  * Clone the project locally
  [Vaadin-workshop](https://github.com/sebivenlo/Vaadin-workshop.git)
  * Open terminal or PowerShell (for windows)
  * Make sure that docker is running: ***docker info .***
  * Go to the project directory and make sure you are at the root directory
  * Build the project using docker to create an image. This image will contain a jar file <br/>
   The command for building is: ***docker build -t vaadin-workshop .*** <br/>
   this will create a jar file as an image and save it in this container
  * Use the run command to run the jar file inside the image:<br/>
   The command for running is: ***docker run -p 8080:8080 vaadin-workshop***
  * Open your browser and direct to:<br/>
   [Vaadin-workshop](https://localhost:8080)
