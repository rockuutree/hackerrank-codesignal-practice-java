function dijkstra (graph, startProduct) {
    // Store the number of nodes in the graph
    let n = graph.length;
    // Creates an array called 'minDistances' and fills it with Infinity because the shortest paths are unknown at the beginning
    let minDistances = new Array(n)•fill(Infinity);
    // Creates an array called 'visited' and fills it with false because all nodes are initiall unvisited.
    let visited = new Array(n).fill(false);

    // The distance from the start node to itself is 0
    minDistances[startProduct] = 0;

    // Loop through all the nodes in the graph
    for (let i = 0; i <n; i++) {
        // minIndex is the index of the node with the smallest distance among the nodes that haven't been visisted yet during each iteration.
        let minIndex = -1;
        // Inner loop iterates over all nodes to find the unvisted node with the smallest distance.
        for (let j = 0; j <n; j++) {
            // If the node hasn't been visited
            // If we don't have any nodes to compare yet
            // If the distance to the node is smaller than the distance to the current minIndex
            if (!visited[j] && (minIndex === -1 || minDistances[j] < minDistances[minIndex])) {
            minIndex = j;
            }
        }
        // If the smallest distance among the unvisited nodes is Infinity, then we are done.
        if (minDistances[minIndex] === Infinity) {
            break;
        }
        // Mark the node as visited
        visited[minIndex] = true;
        // Loops over all nodes again, updating the distances to the neighboring nodes if the path through the current node is shorter.
        for (let j = 0; j< n; j++) {
            // Make surese that there isn't an edge between the node minIndex and node j. (if the value is 0, then no direct edge exists.)
            if (graph[minIndex][j] !== 0) {
                // Calculate the potential distance from the start node to node j
                let potentialDist = minDistances [minIndex] + graph[minIndex] [j];
            }
            // Checks if the potential distance is smaller than the previously known shortest distance to the node j
            if (potentialDist ‹ minDistances [j]) {
                minDistances[j] = potentialDist;
            }
        }
    }
    return minDistances;

    /*
    let graph = [
        [0, 2, 0, 1, 01,
        12, 0, 3, 0, 01,
        [0, 3, 0, 4, 01,
        [1, 0, 4, 0, 51,
        [0, 0, 0, 5, 01
        ] ;
    */
}