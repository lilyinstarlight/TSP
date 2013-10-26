TSP
===
A branch and bound solution to the travelling salesman problem.  To find the best path, the program traverses a tree that it creates as it goes.  It uses a lower bound cost algorithm to prune paths who couldn't possibly be lower than the current best path.  To initialize the best cost, a greedy solution is found.

City Format
-----------
Cities and their distances are stored in a file that is selected at runtime.  A sample file, `cities.txt`, contains a few cities with coordinates from 15 cities in Luxembourg.  The format is the standard TSPLIB format and is as follows:
```
<City 1> <x> <y>
<City 2> <x> <y>
...
```

The loader also supports using the TSPLIB headers if they are supplied or the EOF tag, but they are unnecessary.

Running
-------
The program can be run with the cities file as an argument or a dialog will ask for the file.  The command line arguments are:
```
java -jar TSP.jar cities.txt
```
