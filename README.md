# Medical Archive Management System - REST API

System for managing a medical archive in the hospital.
Group project created as part of the 'Java od podstaw' bootcamp.

## Table of Contents

* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Screenshots](#screenshots)
* [Setup](#setup)
* [Usage](#usage)
* [Project Status](#project-status)
* [Room for Improvement](#room-for-improvement)
* [Acknowledgements](#acknowledgements)
* [Contact](#contact)

<!-- * [License](#license) -->

## General Information

- App in the form of a REST API.
- App can help to manage a medical archive in the hospital.
- App also allows to manage information about patients, hospital staff, wards, patient hospitalizations, archive folders and folders bookings.
- Requests are being called in the form of JSON.
- Response are being received in the form of JSON too.

## Technologies Used

- Java 8
- Maven
- Git
- Spring Boot 2.5.3
- Spring Data JPA
- H2 Database
- Spring Validation
- REST API
- Swagger UI

- Scrum
- Jira

## Features

List the ready features here:

- Create, read, update, delete data about:
  - Patients
  - Addresses
  - Wards
  - Staff
  - Patient hospitalizations
  - Folders
  - Folder Locations
  - Archive categories
  - Folder Bookings
- Folders with selected Archive category reporting
- Folders with selected Folder status reporting
- Folders with selected Folder type reporting
- Folders with selected Patient reporting
- Folders with selected Patient and Hospitalization reporting
- Folders borrowed by selected Staff

## Setup

To try out the app run the following in command line:
> mvn compile

To build the JAR file run the following command:
> mvn package

To execute the JAR file run:
> java -jar target/medicalarchivemanagementsystem-0.0.1-SNAPSHOT.jar`

## Usage

All REST API paths are available on local server running on base url:
`http://localhost:8080/`

Available paths with methods `GET`, `POST`, `PUT`:

`/address`, `/archiveCategory`, `/booking`, `/folder`, `/hospitalization`, `/location`, `/patient`, `/staff`, `/ward`

Swagger UI documentation is available here:

`http://localhost:8080/swagger-ui/#/`

## Project Status

> Project is: _in progress_

## Room for Improvement

-

## Contact

Created by [@KatBre](https://github.com/KatBre), [@MichalKulygin](https://github.com/MichalKulygin), [@klezner](https://github.com/klezner) - feel free to contact me!


<!-- Optional -->
<!-- ## License -->
<!-- This project is open source and available under the [... License](). -->

<!-- You don't have to include all sections - just the one's relevant to your project -->

<img src="https://i.pinimg.com/originals/26/45/bf/2645bff0709e4cf23bcaff6690965816.png">
