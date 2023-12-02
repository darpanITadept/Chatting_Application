# Chatting Application

![JavaFX Logo](https://upload.wikimedia.org/wikipedia/en/c/c0/JavaFX_Logo.png)

## Overview

Welcome to the **Chatting Application** – a JavaFX-based program that effortlessly connects users through a central server. This application boasts an intuitive graphical interface on both the server and client sides, making communication seamless and enjoyable.

## Getting Started

### Server Side:

1. Run the server by executing `ChattingAppServer.java`.
2. The server GUI will display comprehensive system information, including the day, time, month, date, time zone, and year.

   ![Server GUI](screenshots/server_gui.png)

### Client Side:

1. After starting the server, launch the client application by running `ChattingAppClient.java`.
2. The client GUI will prompt for a username initially, with other nodes disabled until a username is provided.

   ![Client Initial GUI](screenshots/client_initial_gui.png)

3. Upon submitting a username, the client GUI activates, and a notification is sent to the server about the new connection.

   ![Client Activated GUI](screenshots/client_activated_gui.png)

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
