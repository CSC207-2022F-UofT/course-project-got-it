# Got It: Request Item Delivery System

## Screenshots
#<img width="629" alt="Screenshot 2022-12-08 at 11 04 53 PM" src="https://user-images.githubusercontent.com/66842156/206622807-5430d4f1-24cd-4023-8356-7227844fff08.png">
<img width="305" alt="Screenshot 2022-12-08 at 11 07 22 PM" src="https://user-images.githubusercontent.com/66842156/206622791-88d994ea-6dc8-4b23-b871-da425a8b1920.png">
<img width="607" alt="Screenshot 2022-12-08 at 11 06 33 PM" src="https://user-images.githubusercontent.com/66842156/206622798-449c6cd9-b31a-4367-a8ca-ac427f4d36b2.png">
<img width="307" alt="Screenshot 2022-12-08 at 11 06 16 PM" src="https://user-images.githubusercontent.com/66842156/206622804-6b032232-4175-4bd7-9042-a350672441ec.png">
<img width="407" alt="Screenshot 2022-12-08 at 11 05 07 PM" src="https://user-images.githubusercontent.com/66842156/206622805-fc474919-5b86-41d4-b69b-5fafee34b840.png">



## Summary
Got It! is an app that helps you get what you need, when you need it. 
With Got It you can quickly get an item delivered to you by our many drivers!
Just submit a request, and we've got it!

## Problem
A User needs an item delievered to them.
This item could be anything they are unable to procure themselves due to varying circumstances (ex. long commute, disability, illness, etc.). The item could be a necessity (ex. groceries) or items they may have lost or forgotten. 

## Solution

The Got It! application provides a sleek interface for users to request any items they need delivered to them by one of our drivers. They simply fill out delivery information and item descriptions, and are then assigned a driver and given their estimated delviery time. 


## API Keys

## Core Features
### User Authentication and Updates
#### Login
- The application verifys the account exists in the database
- Navigates to Home Screen and Sets the current
#### Register
- Users can create an account within the database
- The password/email fields are validated
- The address is converted into a longitude/latitude format using the PositionStack API
#### Updates
- Users can update their account information
- Passwords are hidden for security reasons
- The address string is converted to a longitude/latitude format using the PositionStack API
### Creating/Viewing a Request
#### Creating a Request
- Users can create a request which is stored in the database
- Users get assigned a closest driver from the drivers collection in the database
- Address are converted from Strings to geocodes in the database
#### Viewing Requests
- Users can view past requests on the Past Requests screen
- Users can view their active request on the current request screen
- Users can see an estimated time of arrival by clicking the get time of delivery button
### Navigation
#### Back Functionality
- Users can go back from any screen to their previous screen
- Some screens automatically go back once the user submits a response (e.g. confirmation screens)
#### Presenting New Screen
- Screens are implemented using the observer pattern and a hash map
- When the app is notified about a screen change from presenter, it searches through its screen hash map to get the controller and interactor to complete the use case

## Design Patterns & Clean Architecture
### Observer/Observerable
- We used the observer/observerable pattern to implement the presenter
- We used Clean Architecture to follow SOLID principles
- Accessed the database and APIs through gateways to prevent dependence
### Factory Pattern
- Implemented on Register Screen 
- Creates a User Entity

## Contributions
Home Screen, Past Requests and Current Request were a collective effort of Pranav Agarwal, Arjun Saili, Varchas Sharma, Aziz Shahid and Hailey Ng. Though the commits are attributed to a few individuals, this work was a team effort. 

Aziz Shahid implemented the interactor and controller for the MakeRequest use case which takes input from the user and stores the request information in the database. He also implemented the interactor and controller for the Delivery use case which calculates the estimated delivery time. @ArjunSaili1 helped to integrate shahi7's work into the main branch (so the commits are attributed to Arjun but the work was mostly by @shahi7). 

Hailey Ng helped create the first draft GUI for the MakeRequest and Delivery use cases. She also created the tests for the program and created the presentation slides. She created the entities and helped Aziz Shahid with the controllers. Work was integrated in a PR by Arjun Saili so the commits were attributed to him but the work was done by Hailey

Varchas Sharma implemented the BackButton functionality which allows navigation to the previous screen. He also helped create the presentation and added all the documentation/comments to the code. Intially helped with allocate driver before being reassigned to back functionality.

Arjun Saili created the database and the functions which access it, and established the connection to a geocoder API which converts String addresses to latitude/longitude coordinates. He also implemented the Login use case which handles user authentication and login, and helped to integrate branches and resolve merge conflicts. He also created the presenter observer system to show screens. 

Pranav Agarwal implemented the Register use case and assisted Arjun Saili with the Login use case. He also created the past and current request screens which display estimated delivery time and up to the past three requests the user had made. He also independetly made the update profile functionality and intergrated the JFrames screens created by Zhaolin Chen. 

Zhaolin Chen created most of the JFrames for the GUI.
