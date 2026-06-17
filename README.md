# Student Resource Navigator
## Credits
**Developer:** BreAnna  
**Course:** CIS141

## Overview
The **Student Resource Navigator** is a Java‑based console application designed to help Olympic College students locate campus resources. The program loads resource data from a structured JSON file and provides an interactive menu that allows users to filter resources by **category**, **building**, or **name**. Each resource includes details such as location, hours, contact information, and a description, all displayed in a clean, readable format.

Students can also build a **custom list of resources**. This list can be viewed, modified, or exported to a text file for future reference, making the application both a search tool and a lightweight organizational system.

---

## Features
- Loads resource data from a JSON file using the Jackson library
- View a full list of resources
- Filter resources by category, building, or name
- Save resources to a personal list for quick access
- Remove saved resources at any time
- Export the saved list to a `.txt` file
- Clean, readable formatting for all resource details
- Multi‑category support for more accurate filtering
- Fully interactive console menu

---

## JSON Data Structure
Each resource in the JSON file follows this structure:

```json
{
  "name": "Example Resource",
  "building": 10,
  "room": "101",
  "phone": "360-000-0000",
  "hours": "M-F: 8am - 4pm",
  "email": "example@olympic.edu",
  "category": ["Food", "Student Life"],
  "description": "Description text here."
}
```

---

## To Run the Program
- Open terminal 
- Run the following command: `java -cp "out:lib/*" studentResourceNavigator.Main`
---
## Challenges
### JSON Mapping
**Issues:**
- I kept running into deserialization errors because the JSON structure didn’t perfectly match my `Resource` class. I fixed this by adjusting both the JSON and the class fields so they lined up correctly.
- This helped me better understand how JSON actually works and why even small inconsistencies break the parser.

### Multi‑Class Architecture
**Issues:**
- My classes originally overlapped in responsibility, which made the project harder to follow. I reorganized the structure so each class handled one clear task (filtering, loading data, menus, etc.).
- This gave me a stronger sense of how [class design](ca://s?q=Explain_class_design_principles) affects readability and long‑term maintainability.

### Scanner Input Flow
**Issues:**
- Mixing `nextInt()` and `nextLine()` — plus accidentally using multiple Scanners — caused menus to skip or freeze. I fixed this by switching to a single shared Scanner and cleaning up the input flow.
- This taught me how [Scanner buffering](ca://s?q=How_Scanner_buffering_works) really behaves behind the scenes.

### File I/O
**Issues:**
- I wasn’t handling file errors correctly at first, and some saved files came out incomplete. Using proper try/catch blocks and formatting the output more carefully solved the problem.
- This helped me understand why [file I/O](ca://s?q=Explain_Java_file_IO) is treated as a risky operation in Java.

### Data Consistency
**Issues:**
- Small typos or mismatched category names in the JSON caused filtering to fail in ways that weren’t obvious. I standardized the data and updated the filtering logic to support multi‑category resources.
- This made me more aware of how important consistent [data structures](ca://s?q=Why_data_consistency_matters) are across an entire project.


---

### Image Accreditation
asciiart.eu — “Untitled” by Hayley Jane Wakenshaw (Flump)
