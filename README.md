# github-activity
A simple CLI app that tracks GitHub activity by fetching data from the GitHub API

### Project description
This project is built based on the following guideline : 
https://roadmap.sh/projects/github-user-activity

### What can you do with this program?
You can track github activities of the github user you searched.  
This program only tracks public github actvities only.

### How to run
Copy and paste the following commands on your terminal
```text
# 1. Build an execute script
./gradlew installDist

# 2. Add to your PATH
export PATH=$PATH:$(pwd)/build/install/github-activity/bin
```

### Example
Type Github username to track
```text
github-activity <username>
```
You can read public github activity on the given github username
```text
Output:
- Pushed 3 commits to kamranahmedse/developer-roadmap
- Opened a new issue in kamranahmedse/developer-roadmap
- Starred kamranahmedse/developer-roadmap
- ...
```