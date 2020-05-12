# A* Path Search
In this case the problem that is being solved is a typical road-connection problem; We start on a specific road (s) and we need to take the shortest path to the objective goal (e) going through the different existing roads. 

Going from one road (node) to another (node) has a cost (g) that indicate distance (km) between those roads (nodes). Nevertheless, there is also an heuristic cost (h) that represents the distance between a road and the objective (e). So choosing one road or another, will depend of (f), the sum of (g) and (h). 

# How do I generate a problem?
Includes random problem generator for testing (MapGenerator class).

# See more
https://en.wikipedia.org/wiki/A*_search_algorithm
