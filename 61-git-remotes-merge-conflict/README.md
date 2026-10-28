# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository

git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git

Output:
   Cloning into 'OOP-git-merge-conflict-test'...
   remote: Enumerating objects: 24, done.
   remote: Counting objects: 100% (16/16), done.
   remote: Compressing objects: 100% (11/11), done.
   remote: Total 24 (delta 5), reused 13 (delta 5), pack-reused 8 (from 1)
   Receiving objects: 100% (24/24), done.
   Resolving deltas: 100% (6/6), done.

cd OOP-git-merge-conflict-test/

Output:


git status

Output:
   On branch master
   Your branch is up to date with 'origin/master'.

   nothing to commit, working tree clean

2. Ci si assicuri di avere localmente entrambi i branch remoti

git branch -a

Output:
   * master
   remotes/origin/HEAD -> origin/master
   remotes/origin/feature
   remotes/origin/master

git switch feature

Output:
   branch 'feature' set up to track 'origin/feature'.
   Switched to a new branch 'feature'

git switch master

Output:
   Switched to branch 'master'
   Your branch is up to date with 'origin/master'.

git branch -vv

Output:
   feature d809d3e [origin/feature] switch to Java 25 IO.println
   * master  2f617a5 [origin/master] switch to Java 25 IO.println

git status

Output:
   On branch master
   Your branch is up to date with 'origin/master'.

   nothing to commit, working tree clean

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`

git branch

Output:
   feature
   * master

git merge feature

Output:
   Auto-merging HelloWorld.java
   CONFLICT (content): Merge conflict in HelloWorld.java
   Automatic merge failed; fix conflicts and then commit the result.

4. Si noti che viene generato un **merge conflict**!
git status

Output:
   On branch master
   Your branch is up to date with 'origin/master'.

   You have unmerged paths.
   (fix conflicts and run "git commit")
   (use "git merge --abort" to abort the merge)

   Unmerged paths:
   (use "git add <file>..." to mark resolution)
      both modified:   HelloWorld.java

   no changes added to commit (use "git add" and/or "git commit -a")

5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)

git diff

Output:
   diff --cc HelloWorld.java
   index 1bd0971,25bff93..0000000
   --- a/HelloWorld.java
   +++ b/HelloWorld.java
   @@@ -1,7 -1,5 +1,14 @@@
   ++<<<<<<< HEAD
   +int procNumber() {
   +      return Runtime.getRuntime().availableProcessors();
   +}
   +
   +void main() {
   +      IO.println("This program is running in a PC with " + procNumber() + " logic processors!");
   ++=======
   + final String AUTHOR = "Danilo Pianini";
   + 
   + void main() {
   +       IO.println("This program has been realised by " + AUTHOR);
   ++>>>>>>> feature
   }

sudo nano HelloWorld.java

Output:


git status

Output:
   On branch master
   Your branch is up to date with 'origin/master'.

   You have unmerged paths.
   (fix conflicts and run "git commit")
   (use "git merge --abort" to abort the merge)

   Unmerged paths:
   (use "git add <file>..." to mark resolution)
      both modified:   HelloWorld.java

   no changes added to commit (use "git add" and/or "git commit -a")

6. Si crei un nuovo repository nel proprio github personale

git add HelloWorld.java

Output:


git status

Output:
   On branch master
   Your branch is up to date with 'origin/master'.

   All conflicts fixed but you are still merging.
   (use "git commit" to conclude merge)

   Changes to be committed:
      modified:   HelloWorld.java

git commit -m "Merged the functions of branches 'master' and 'feature'"

Output:
   [master 793571e] Merged the functions of branches 'master' and 'feature'

7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote

git remote add myRemote https://github.com/pulcenanni-pixel/lab-06.git

Output:


git remote -v

Output:
   myRemote	https://github.com/pulcenanni-pixel/lab-06.git (fetch)
   myRemote	https://github.com/pulcenanni-pixel/lab-06.git (push)
   origin	https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
   origin	https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (push)

8. Si faccia push del branch `master` sul proprio repository

git push myRemote master

Output:
   Username for 'https://github.com': pulcenanni-pixel
   Password for 'https://pulcenanni-pixel@github.com': 
   Enumerating objects: 27, done.
   Counting objects: 100% (27/27), done.
   Delta compression using up to 16 threads
   Compressing objects: 100% (19/19), done.
   Writing objects: 100% (27/27), 3.85 KiB | 3.85 MiB/s, done.
   Total 27 (delta 6), reused 24 (delta 6), pack-reused 0 (from 0)
   remote: Resolving deltas: 100% (6/6), done.
   To https://github.com/pulcenanni-pixel/lab-06.git
   * [new branch]      master -> master

git status

Output:
   On branch master
   Your branch is ahead of 'origin/master' by 4 commits.
   (use "git push" to publish your local commits)

   nothing to commit, working tree clean

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale

git branch --set-upstream-to=myRemote/master master

Output:
   branch 'master' set up to track 'myRemote/master'.

git status

Output:
   On branch master
   Your branch is up to date with 'myRemote/master'.

   nothing to commit, working tree clean
