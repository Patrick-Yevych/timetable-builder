## Overview
timetable-builder is an android app which assists university students in creating their semester timetables. It uses a graph ADT and pathfinding algorithm to compute a subset of sections such that the total downtime between them is minimized.

## Table of Contents
- [Overview](#overview)
- [Table of Contents](#table-of-contents)
- [Installation](#installation)
- [Usage](#usage)
  - [Add Tab](#add-tab)
  - [Sections Tab](#sections-tab)
  - [Timetable Tab](#timetable-tab)
- [Contribution](#contribution)
- [License](#license)

## Installation

## Usage

### Add Tab

<img align = "right" src ="media/add_screen.png">

Users input section information such as the associated course code, type, start and finish times, and day using the graphical user interface. The course code is an alphanumerical code that specifies what course the lecture or tutorial section is for. The start time of the section typically ranges from 9:00am to 9:00pm while the the finish time of the section should be between the start time to 9:00pm. The currently supported section types are lectures and tutorials/practicals. Tapping the "Add" button appends a new sections with the specified information to the list of sections in the Sections Tab. 


### Sections Tab

### Timetable Tab

## Contribution

timetable-builder is built using [Android Studio](https://developer.android.com/studio).

The organization of this repository is based off of the feature branch workflow. Features are documented in the [scrum](scrum) folder and branches are created for each major feature developement. Ensure that your pull requests follow this organization pattern and you document each feature development in the scrum backlogs.

## License

This repository is licensed under the GPL-3.0 license. See [LICENSE](LICENSE) for details.
