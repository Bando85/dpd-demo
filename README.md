

# DPD Demo Application

The application provides all the funcionality to manage Persons.

The website is mobile-friendly.

## Configuration

These steps require to have Docker installed on your system. You can download Docker from here: https://www.docker.com/products/docker-desktop/

To build the application, please build the backend first with the following command in the [root directory](/../../):

`./mvnw install`

or

`mvnw.cmd install`

Then build the Docker image and start the backend with the following command:

`docker-compose up -d`

After that please build and run the frontend Docker image with the following command in the [frontend directory](/frontend):

`docker-compose up -d`

The application is running on port 3000 by default, visit here: http://localhost:3000.

## Functions

The application stores details about Persons. Users are able to create, modify and depersonalize persons as well as list them.

**Pleas use ";" delimiter in Address and Phone fields when you want to add more than one line**