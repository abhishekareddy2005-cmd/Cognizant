# GIT HOL 2 - Git Ignore

## Commands Executed

# Create log file and folder
echo "This is a log file" > app.log
mkdir logs
echo "log content" > logs/debug.log

# Create .gitignore
echo "*.log" > .gitignore
echo "logs/" >> .gitignore

# Verify ignored
git status
git add .gitignore
git commit -m "Add .gitignore to ignore log files and folders"

## Output
.log files and logs/ folder are ignored by Git.
git status shows nothing to commit after adding .gitignore.
