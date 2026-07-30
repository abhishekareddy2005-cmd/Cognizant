# GIT HOL 3 - Branching and Merging

## Commands Executed

# Create and switch to new branch
git branch GitNewBranch
git branch -a
git checkout GitNewBranch

# Add file in branch
echo "This is new branch content" > branchfile.txt
git add branchfile.txt
git commit -m "Added branchfile.txt in GitNewBranch"

# Switch to master and merge
git checkout master
git diff master GitNewBranch
git merge GitNewBranch

# View log and delete branch
git log --oneline --graph --decorate
git branch -d GitNewBranch
git branch -a

## Output
Branch created, file added, merged to master successfully.
Branch deleted after merge.
