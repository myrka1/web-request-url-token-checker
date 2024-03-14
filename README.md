# Request Validator

A Java program to validate HTTP requests and responses based on authentication tokens and CSRF tokens.

## Introduction
The Request Validator is a Java application designed to check the validity of HTTP requests and responses. It focuses on authentication tokens and CSRF tokens to ensure secure and valid communication.

## Classes
### Main Class
Main.java

The Main class serves as the entry point for the application. It orchestrates the validation process by handling parameters, creating requests, and utilizing the TokenChecker for CSRF validation.

Key Features
- Request Handling: Parses HTTP requests and extracts relevant information.
- Token Validation: Utilizes TokenChecker to validate CSRF tokens.
- Response Generation: Generates responses based on request validation.

### TokenChecker Class
TokenChecker.java

The TokenChecker class provides a utility for validating CSRF tokens. It ensures that the token meets specific criteria: a length of 8 or more characters and only alphanumeric characters.

Key Features

- CSRF Token Validation: Checks the length and alphanumeric nature of CSRF tokens.

### Request Class
Request.java

The Request class represents an HTTP request and stores its parameters. It is used to encapsulate the details of each request, including the request type, tokens, and additional parameters.

Key Features

- Request Type: Represents the type of HTTP request (e.g., GET, POST).
- Token and CSRF Handling: Stores authentication tokens and CSRF tokens if present.
- Parameter Management: Manages additional parameters associated with the request.
- Print Parameters: Provides a method to print the parameters for debugging or analysis.