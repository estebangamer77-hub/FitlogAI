# FitLogAI

FitLogAI is a desktop fitness application developed in Java using JavaFX, designed to help users manage workouts, track progress, and improve their training using structured data and AI-based ideas.

---

##  Features

-  User authentication (Login & Register)
-  Dashboard with training overview
-  Weekly workout planning
-  Routine management with real exercises
-  Progress tracking (weight, height, body fat)
-  AI-based fitness concept (future improvements)

---

##  Technologies Used

- Java (JDK 21)
- JavaFX
- MySQL
- JDBC (Database connection)
- NetBeans IDE
- Git & GitHub

---

##  Installation & Setup

### 1. Clone the repository

```bash
git clone https://github.com/estebangamer77-hub/FitlogAI.git
2. Open in NetBeans
Open NetBeans
Click Open Project
Select the FitLogAI folder
3. Configure JavaFX

Make sure JavaFX is properly configured:

Add JavaFX libraries
VM Options:
--module-path "PATH_TO_FX/lib" --add-modules javafx.controls,javafx.fxml
4. Setup MySQL Database

Create database:

CREATE DATABASE fitlogai;

Create tables:

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE progress (
    id INT AUTO_INCREMENT PRIMARY KEY,
    weight DOUBLE,
    height DOUBLE,
    bodyfat DOUBLE,
    month VARCHAR(20)
);
5. Configure Database Connection

Update your credentials in:

DatabaseConnection.java
"jdbc:mysql://localhost:3306/fitlogai",
"root",
"your_password"
 Project Structure
FitLogAI/
│── src/
│   ├── com.fitlog.fitlogai/
│   │   ├── MainApp.java
│   │   ├── DatabaseConnection.java
│   │   ├── view/
│   │   │   ├── LoginView.java
│   │   │   ├── DashboardView.java
│   │   │   ├── RoutineView.java
│
│── nbproject/
│── build.xml
 Future Improvements
AI-based workout recommendations
Better UI/UX design
User profile system
Progress charts and analytics
Mobile version
 Author
Esteban Solís
 License

This project is for educational purposes.
