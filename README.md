# Vaadin-workshop
Introducing Vaadin, an open source web framework to build progressive web apps and websites using Java

# Things you need to run this project:
  * Install docker
  
## To run the project
  * Clone the project locally
  * Open terminal or PowerShell (for windows)
  * Make sure that docker is running
  * Go to the project directory and make sure you are at the root directory
  * Build the project using docker to create an image this image will contain a jar file
   *docker build -t vaadin-workshop .* | this will create a jar file that containes 
  * Second use the run command to run the project:
   docker run -p 8080:8080 vaadin-workshop
  * Open your browser and direct to:
    localhost:8080
