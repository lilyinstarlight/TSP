TSP
===
A branch and bound solution to the travelling salesman problem.  To find the best path, the program traverses a tree that it creates as it goes.  It uses a lower bound cost algorithm to prune paths who couldn't possibly be lower than the current best path.  To initialize the best cost, a greedy solution is found.

City Format
-----------
Cities and their distances are stored in a file that is selected at runtime.  A sample file, `tsp/cities.txt`, contains the coordinates from 15 cities in Luxembourg and demonstrates the file format.  The format is the standard TSPLIB format and is as follows:
```
NAME: <name>
COMMENT: <comment>
TYPE: TSP
DIMENSION: <n>
EDGE_WIEGHT_TYPE: EUC_2D
NODE_COORD_SECTION
<1> <x> <y>
<2> <x> <y>
...
<n> <x> <y>
EOF
```

The headers and EOF are all optional but the loader will use them if specified.

Running
-------
The program can be run with the cities file as an argument or a dialog will ask for the file.  The command line arguments are:
```
java -jar TSP.jar cities.txt
```
