# GIT HOL 1 - Git Setup and Basic Commands

## Commands Executed

### Step 1: Verify Git Installation
git --version

### Step 2: Configure Git
git config --global user.name "Abhishek Reddy"
git config --global user.email "abhishekareddy2005@gmail.com"
git config --list

### Step 3: Create Repository and Add File
mkdir GitDemo
cd GitDemo
git init
echo "Hello Git World" > sample.txt
git status
git add sample.txt
git commit -m "First commit - added sample.txt"
git log

## Output
Git version confirmed, user configured successfully.
File added and committed to local repository.
