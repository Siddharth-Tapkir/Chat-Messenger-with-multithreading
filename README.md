# Client-Server Chat Application

A multi-client chat application developed in Java using **TCP socket programming and multithreading**. The application follows a client-server architecture where multiple clients can connect to a central server and communicate simultaneously.

## Features

- Supports multiple clients simultaneously
- Uses multithreading to handle each connected client independently
- Real-time message communication between clients
- TCP socket-based client-server communication
- Centralized server for managing client connections
- Handles client connection and disconnection
- Simple command-line interface

## Technologies Used

- Java
- TCP/IP
- Socket Programming
- Multithreading
- Client-Server Architecture
- Java I/O

## Architecture

```text
              ┌─────────────┐
              │   Server    │
              └──────┬──────┘
                     │
        ┌────────────┼────────────┐
        │            │            │
   ┌────▼────┐  ┌────▼────┐  ┌────▼────┐
   │ Client 1│  │ Client 2│  │ Client 3│
   └─────────┘  └─────────┘  └─────────┘
