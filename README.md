# Java GUI Dialog Box Application

This is a simple Java Swing-based GUI application that demonstrates how to use dialog boxes for user interaction. It includes a main GUI window and a dialog box component implemented in separate classes.

## Features

- A main window with a button to trigger a custom dialog box.
- A modal dialog box that takes user input.
- Clear separation between GUI logic (`Gui.java`) and dialog box logic (`DialogBox.java`).

## File Structure

- `Gui.java` — The main GUI application with a frame and a button.
- `DialogBox.java` — A modal dialog box that interacts with the main GUI.

## Requirements

- Java JDK 8 or higher
- Any IDE that supports Java (Eclipse, IntelliJ IDEA, NetBeans, etc.) or just use the terminal.

## How to Compile and Run

### Compile:

```bash
javac Gui.java DialogBox.java
