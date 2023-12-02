# Chatting Application

![JavaFX_Logo](https://github.com/darpanITadept/Chatting_Application/assets/112990024/1b97c300-5073-49ea-a4c7-14700338a5c7)

## Overview

Welcome to the **Chatting Application** – a JavaFX-based program that effortlessly connects users through a central server. This application boasts an intuitive graphical interface on both the server and client sides, making communication seamless and enjoyable.

## Getting Started

### Server Side:

1. Run the server by executing `ChattingAppServer.java`.
2. The server GUI will display comprehensive system information, including the day, time, month, date, time zone, and year.

![Picture 1](https://github.com/darpanITadept/Chatting_Application/assets/112990024/5d73d8f0-c093-4f57-814e-3b3252fc220e)

### Client Side:

1. After starting the server, launch the client application by running `ChattingAppClient.java`.
2. The client GUI will prompt for a username initially, with other nodes disabled until a username is provided.

<img width="250" alt="Screenshot 2023-12-01 at 9 10 28 PM" src="https://github.com/darpanITadept/Chatting_Application/assets/112990024/c46cb3fe-1521-40ee-b354-1f09b333fdac">

3. Upon submitting a username, the client GUI activates, and a notification is sent to the server about the new connection.

<img width="250" alt="Screenshot 2023-12-01 at 9 12 29 PM" src="https://github.com/darpanITadept/Chatting_Application/assets/112990024/31c7e014-5fbc-42c8-815c-b5620802ccd6">

4. Multiple clients can join the chat server, and existing clients are notified about new connections.

   ![New Client Notification](screenshots/new_client_notification.png)

## Features

- **Dynamic Username:** Users can input their username, and the application dynamically updates the stage title with the entered username.
- **Real-time Communication:** Clients can efficiently communicate through the server, with messages routed via sockets.
- **Scalability:** The chat server supports the addition of multiple clients, allowing for scalable communication.


## Usage

Feel free to use and modify the code as needed. For more details, refer to the comprehensive workshop report provided with this repository.

## Acknowledgments

Special thanks for your interest in the **Chatting Application**. If you encounter issues or have suggestions for improvements, please feel free to raise an issue or contribute to the development.

Happy Chatting! 😊
