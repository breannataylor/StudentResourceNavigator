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
## Challenges

- ### Maven Discrepancy
**Issues:**  
- I ran into a dependency mismatch with `jackson-databind` that VSCode refused to recognize, even after updating my `pom.xml`. Trying to fix it led me down a rabbit hole of restructuring my project and adjusting run configurations, which only made things more confusing. In the end, I wiped the project and rebuilt it cleanly so I could start fresh with a stable dependency setup.
- On a candid note, this is what almost *broke* me. I never asked for help because I always felt "if I could just figure ____ out, I'll be able to get it to work". Before I acknowledged it, I was at the end of my rope, and just scraped the whole thing.

### JSON Mapping
**Issues:**
- I kept running into deserialization errors because the JSON structure didn’t perfectly match my `Resource` class. I fixed this by adjusting both the JSON and the class fields so they lined up correctly.

### Multi‑Class Architecture
**Issues:**
- My classes originally overlapped in responsibility, which made the project harder to follow. I reorganized the structure so each class handled one clear task (filtering, loading data, menus, etc.).

### Scanner Input Flow
**Issues:**
- Mixing `nextInt()` and `nextLine()` — plus accidentally using multiple Scanners — caused menus to skip or freeze. I fixed this by switching to a single shared Scanner and cleaning up the input flow.

### File I/O
**Issues:**
- I wasn’t handling file errors correctly at first, and some saved files came out incomplete. Using proper try/catch blocks and formatting the output more carefully solved the problem.

### Data Consistency
**Issues:**
- Small typos or mismatched category names in the JSON caused filtering to fail in ways that weren’t obvious. I standardized the data and updated the filtering logic to support multi‑category resources.

---


### Image Accreditation
asciiart.eu — “Untitled” by Hayley Jane Wakenshaw (Flump)
