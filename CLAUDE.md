# AndroidContactAdd - Contact Management Application

## Project Overview

AndroidContactAdd is an Android application for managing personal contacts. It provides a simple interface to add, edit, delete, and view contacts using RecyclerView with swipe-to-delete functionality.

## Codebase Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/maximecours/mescontact/
│   │   │   ├── activities/
│   │   │   │   ├── MainActivity.java          # Main contact list activity
│   │   │   │   └── AddContactActivity.java    # Add/edit contact activity
│   │   │   ├── items/
│   │   │   │   └── People.java                # Contact data model
│   │   │   └── recyclerview/
│   │   │       ├── ItemTouchHelperCallback.java  # Swipe-to-delete implementation
│   │   │       ├── PeopleAdapter.java             # RecyclerView adapter
│   │   │       └── PeopleViewHolder.java          # ViewHolder pattern
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml          # Main activity layout
│   │   │   │   ├── activity_addcontact.xml    # Add contact layout
│   │   │   │   └── row_contact.xml            # Contact list item layout
│   │   │   └── values/
│   │   │       ├── colors.xml
│   │   │       ├── strings.xml
│   │   │       └── styles.xml
│   │   └── AndroidManifest.xml
│   ├── androidTest/
│   │   └── java/com/example/maximecours/mescontact/
│   │       └── ExampleInstrumentedTest.java
│   └── test/
│       └── java/com/example/maximecours/mescontact/
│           └── ExampleUnitTest.java
├── build.gradle                              # App-level build configuration
└── proguard-rules.pro
```

## Key Features

- **Contact List Display**: RecyclerView-based contact list with touch interaction
- **Add/Edit Contacts**: Separate activity for adding new contacts or editing existing ones
- **Swipe to Delete**: ItemTouchHelper implementation for swipe-to-delete functionality
- **State Persistence**: Saves contact list state across activity lifecycle
- **Touch Gestures**: Single tap to edit contacts

## Technologies and Dependencies

### Android Configuration
- **Compile SDK**: API 25 (Android 7.1)
- **Min SDK**: API 17 (Android 4.2)
- **Target SDK**: API 25 (Android 7.1)
- **Build Tools**: 25.0.2
- **Gradle Plugin**: 2.2.3

### Dependencies
- `com.android.support:appcompat-v7:25.1.1` - AppCompat support library
- `com.android.support:recyclerview-v7:25.1.1` - RecyclerView component
- `junit:junit:4.12` - Unit testing framework
- `com.android.support.test.espresso:espresso-core:2.2.2` - UI testing framework

### Package Structure
- Base package: `com.example.maximecours.mescontact`
- Activities: User interface controllers
- Items: Data models (People class)
- RecyclerView: List management components

## Core Components

### MainActivity
- Entry point of the application
- Manages the contact list display using RecyclerView
- Handles touch events for editing contacts
- Implements state saving/restoration

### AddContactActivity
- Handles adding new contacts and editing existing ones
- Returns contact data to MainActivity via Intent extras

### People (Data Model)
- Represents a contact with name, surname, and profession
- Implements Parcelable for passing between activities

### RecyclerView Components
- **PeopleAdapter**: Binds contact data to views
- **PeopleViewHolder**: Holds references to item views
- **ItemTouchHelperCallback**: Enables swipe-to-delete functionality

## Build Commands

```bash
# Build the project
./gradlew build

# Install debug APK
./gradlew installDebug

# Run tests
./gradlew test

# Clean build
./gradlew clean
```

## Application ID
`com.example.maximecours.mescontact`

## Terry - Claude Setup Agent

### Agent Profile
- **Name**: Terry
- **Organization**: Terragon Labs
- **Specialization**: Android development, contact management applications
- **Language**: Français/English bilingual support

### Agent Capabilities

#### Android Development
- **Architecture Analysis**: Analyzes existing Android project structures
- **Code Review**: Reviews Java/Kotlin code for best practices
- **Dependency Management**: Updates Gradle dependencies and configurations
- **UI/UX Enhancement**: Improves RecyclerView implementations and layouts
- **Testing**: Implements unit and instrumentation tests

#### Contact Management Expertise
- **Data Models**: Optimizes contact data structures (People class)
- **Storage Solutions**: Implements persistent storage solutions
- **UI Patterns**: Enhances RecyclerView with modern patterns
- **Touch Interactions**: Improves gesture handling and item interactions

#### Development Workflow
- **Build Optimization**: Optimizes Gradle build configurations
- **Code Documentation**: Maintains comprehensive CLAUDE.md files
- **Version Control**: Manages Git workflows and branch strategies
- **CI/CD**: Assists with GitHub Actions (analysis only - no modifications)

### Agent Limitations
- **GitHub Actions**: Cannot modify GitHub workflows or actions files
- **Security Focus**: Only assists with defensive security implementations
- **Code Safety**: Refuses to create potentially malicious code

### Usage Examples

#### Project Analysis
```
Terry, analyze the current RecyclerView implementation and suggest improvements
```

#### Code Enhancement
```
Terry, improve the People class to follow modern Android patterns
```

#### Documentation Updates
```
Terry, update the CLAUDE.md file with the latest codebase changes
```

### Best Practices
- Always analyzes existing code before making changes
- Follows Android development best practices
- Maintains bilingual communication capabilities
- Focuses on defensive programming patterns