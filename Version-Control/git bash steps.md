# git bash commands

firoz@khan MINGW64:~

$ git config --global user.name "firoz khan"

firoz@khan MINGW64:~

$ git config --global user.email "firozkhan@gmail.com"

firoz@khan MINGW64:~

$ git config --global init.default branch main

## help

firoz@khan MINGW64:~

$ git config -h

firoz@khan MINGW64:~

$ git help config

## Change the directory

firoz@khan MINGW64:~

$ cd c:/Users/firozkhan

## Initialized the git repository

firoz@khan MINGW64 /c/Users/firozkhan

$ git init

Initialized empty Git repository in C:/Users/firozkhan/.git/

## To get the status:

firoz@khan MINGW64 /c/Users/firozkhan (main)

$ git status

on branch Main

No commits yet

Untracked files:

	(Use "git add <>..." to include in what will be committed)
 
         abc.txt
	
 	 test.txt
  
nothing added to commit but untracked files present (use "git add" to track)

## To track the file:

firoz@khan MINGW64 /c/Users/firozkhan (main)

$ git add abc.txt

firoz@khan MINGW64 /c/Users/firozkhan (main)

$ git status

on branch Main

No commits yet

Changes to be committed:

	(Use "git rm --cached <file>..." to unstage)
 
	new file: abc.txt 
 
Untracked files:

	(Use "git add <>..." to include in what will be committed)
 
	 test.txt

## To untrack/remove the file:

firoz@khan MINGW64 /c/Users/firozkhan (main)

$ git rm --cached abc.txt

rm abc.txt

## Again get the status:

firoz@khan MINGW64 /c/Users/firozkhan (main)

$ git status

on branch Main

No commits yet

Untracked files:

	(Use "git add <>..." to include in what will be committed)
 
         abc.txt
	 
	 test.txt
  
nothing added to commit but untracked files present (use "git add" to track)

## Create a file called .gitignore and write the command saying that

.gitignore:

## ingonre all .txt files

*.htm

firoz@khan MINGW64 /c/Users/firozkhan (main)

$ git status

on branch Main

No commits yet

Untracked files:

	(Use "git add <>..." to include in what will be committed)
 
   .gitignore
   
	 abc.txt
  
	 test.txt
  
nothing added to commit but untracked files present (use "git add" to track)

## Clear the command prommpt

firoz@khan MINGW64 /c/Users/firozkhan (main)

$ clear

## Track all the files inside the directory:

firoz@khan MINGW64 /c/Users/firozkhan (main)

$ git add --all

Or

$ git add -A

Or

$ git add .

firoz@khan MINGW64 /c/Users/firozkhan (main)

$ git status

on branch Main

No commits yet

Changes to be committed:

	(Use "git rm --cached <file>..." to unstag)
 
	new file: abc.txt 
 
  	new file: test.txt 

## Commit the code with message

firoz@khan MINGW64 /c/Users/firozkhan (main)

$ git commit -m "message - committing my first code in git repository"
