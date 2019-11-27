# Vaadin-workshop
Introducing Vaadin, an open source web framework to build progressive web apps and websites using Java

# Things you need to run this project:
  * Install docker
  
# To run the project

  * Clone the project and save it locally
  * Make sure that docker is running
  * Open terminal or PowerShell (for windows)
  * Go to the project directory and make sure you are at the root directory
  * Build the project in docker using the build command:
   bold docker build -t vaadin-workshop .
  * Second use the run command to run the project:
   docker run -p 8080:8080 vaadin-workshop
  * Open your browser and direct to:
    localhost:8080
