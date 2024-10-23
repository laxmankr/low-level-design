# BookMyShow - Low-Level Design Implementation

## Project Overview
This is a simple low-level design of the **BookMyShow** system. The application allows users to search for movies, view available shows, and registered users can book tickets for shows. Theater owners can also manage shows. This system is implemented using an **in-memory database** and follows **SOLID principles**.

## Features
- **Movie Management**: List and search for movies.
- **Show Management**: List different shows for a movie, add/edit shows.
- **Booking System**: Registered users can book tickets for a show, and their booking history is saved.
- **Guest Search**: Guest users can search for movies.
- **Theater Management**: A theater can add/edit shows for a single screen.

## Assumptions
- Every theater has a single screen.
- Each theater has a limited seating capacity.
- Registered users have access to booking functionality and booking history.
- Movies are available in two languages: Hindi and English.
- Movie genres include Action, Romance, Comedy, and Horror.

## Technologies Used
- **Java 8+**: Core language used for the implementation.
- **In-memory Data Structures**: Used to simulate data persistence.
- **SOLID Principles**: The design adheres to SOLID principles for better maintainability and flexibility.

## Project Structure
- **model**: Contains the domain entities (`Movie`, `Show`, `Theatre`, `Booking`, `User`).
- **repository**: Contains repository interfaces and their in-memory implementations.
- **service**: Contains service interfaces and business logic implementations.

## Running the Application

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/LowLevelDesign-BookMyShow.git
   cd LowLevelDesign-BookMyShow
