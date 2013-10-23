TSP
===
A branch and bound solution to the travelling salesman problem.  To find the best path, the program traverses a tree that it creates as it goes.  It uses a lower bound cost algorithm to prune paths who couldn't possibly be lower than the current best path.  To initialize the best cost, a greedy solution is found.

City Format
-----------
Cities and their distances are stored in a file that is selected at runtime.  A sample file, `cities.txt`, contains a few cities with arbitrary (but approximate) distances.  Only one tab character is allowed between each city and the distance and there should be no duplicate entries.  The format is as follows:
```
<City 2>	<City 1>	<distance>
<City 3>	<City 1>	<distance>
<City 3>	<City 2>	<distance>
<City 4>	<City 1>	<distance>
<City 4>	<City 2>	<distance>
<City 4>	<City 3>	<distance>
```

Running
-------
The program can be run with the cities file as an argument or a dialog will ask for the file.  The command line arguments are:
```
java -jar TSP.jar cities.txt
```
