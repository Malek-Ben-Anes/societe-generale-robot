# Socièté générale - Lawn Mower Program

The Lawn Mower Program is a Java application designed to automate the movement of lawn mowers on a rectangular lawn. It reads input instructions from a file or predefined inputData, simulating the movement of multiple lawn mowers across the lawn surface.

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Documentation](#documentation)
6. [Contributing](#contributing)

## Introduction

The Lawn Mower Program simulates the movement of lawn mowers on a rectangular lawn. It takes input instructions, including the dimensions of the lawn, initial positions and orientations of the lawn mowers, and sequences of movements. The program then executes these instructions, moving the lawn mowers across the lawn surface and providing their final positions.

## Features

- Supports reading input inputData from a file or predefined inputData.
- Handles multiple lawn mowers moving simultaneously.
- Checks for collisions and boundary conditions to ensure safe movement.
- Provides detailed output of the final positions of each lawn mower.

## Installation

To use the Lawn Mower Program, follow these steps:

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/Malek-Ben-Anes/societe-generale-robot
    ```

2. Navigate to the project directory:

    ```bash
    cd societe-generale-robot
    ```

3. Compile the Java files:

    ```bash
    mvn clean install
    ```

4. Change the directory

    ```bash
    cd target
    ```

5. Run the program:

    ```bash
    java -jar  com.mowitnow.mower-1.0.jar
    ```

## Docker

To facilitate deployment and ensure consistency across different environments, this project includes Docker support. Docker allows you to package your application and its dependencies into a container, providing an isolated and portable environment.

#### Building the Docker Image
To build the Docker image for this project, make sure you have Docker installed on your machine. Then, open a terminal or command prompt and navigate to the root directory of the project. Use the following command to build the Docker image:

    ```bash
    docker build -t  com.mowitnow.mower-1.0.jar .
    ```

#### Running the Docker Image
After building the Docker image, you can run the application inside a Docker container. To run the image in interactive mode and provide input to the command, use the following command:

    ```bash
    docker run -it -p 8080:8080 com.mowitnow.mower-1.0.jar 
    ```

This command allocates a pseudo-TTY and allows you to interact with the application as if it were running on your local machine. If the application expects input from the command line, you can provide it directly from your terminal.

## Usage

To use the Lawn Mower Program, you can either provide input inputData via a file or use predefined inputData within the code. The program will simulate the movement of lawn mowers according to the provided instructions and display the final positions of each lawn mower.

## Documentation

The project documentation, can be found in the `docs/Tondeuse.pdf` directory.

## Project Structure

The project follows a well-organized and modular structure, making it easy to navigate and understand. Here is an overview of the project's directory structure:

- src: Contains the main source code of the application.
- main: Holds the main application code.
- LawnMowerApplication.java: The entry point of the application.
- pom.xml: The Maven Project Object Model (POM) file containing the project's configuration and dependencies.
- .gitignore: A file specifying which files and directories should be ignored by Git version control.
- README.md: The main documentation file providing an overview, usage instructions, and other relevant information about the project.

## Contributing

Contributions to the Lawn Mower Program are welcome! If you'd like to contribute, please follow these guidelines:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and ensure all tests pass.
4. Commit your changes with clear commit messages.
5. Push your changes to your fork.
6. Create a pull request to the main repository.

Please follow the project's coding standards and conventions when contributing.

