# GIT HOL 4 - Conflict Resolution

## Commands Executed

# Verify clean state
git status

# Create branch and add hello.xml
git branch GitWork
git checkout GitWork
echo "<hello>Branch Content</hello>" > hello.xml
git add hello.xml
git commit -m "Added hello.xml in GitWork branch"

# Add different hello.xml in master
git checkout master
echo "<hello>Master Content</hello>" > hello.xml
git add hello.xml
git commit -m "Added hello.xml in master"

# Merge causes conflict
git merge GitWork

# Resolve conflict manually
echo "<hello>Master and Branch Content Resolved</hello>" > hello.xml
git add hello.xml
git commit -m "Resolved merge conflict in hello.xml"

# Cleanup
echo "*.orig" >> .gitignore
git add .gitignore
git commit -m "Added .orig to gitignore"
git branch -d GitWork
git log --oneline --graph --decorate

## Output
Conflict created when same file modified in both branches.
Conflict resolved manually by editing hello.xml.
Branch deleted after successful merge.
