// Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

// List<List<String>> accounts

// accounts[i][0] = name

// accounts[i][i+1] = emails representing emails of the account

// Goal: return a string that merges the accounts

// - If two accounts have the same email and same name
// - A person can have any number of accounts but they definitely have the same name

// - First element of each account is the name, and the rest of the emails are in sorted order

// Time Complexity: O(n logn)
// Space Complexity: O(m);
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Set<String>> graph = new HashMap<>();  //<email node, neighbor nodes>
        HashMap<String, String> owner = new HashMap<>();        //<email, username>

        // Build Graph
        for(List<String> account: accounts) {
            // First element is the name/userName
            String name = account.get(0);
            // neighbor set
            Set<String> neighbors = new HashSet<>(account);
            // Remove name from neighbors, left with email
            neighbors.remove(name);

            // 
            for(int i = 1; i < account.size(); i++) {
                // Get the email at i index
                String email = account.get(i);
                // If our graph doesn't contain the email already
                if(!graph.containsKey(email)) {
                    // Put email to an empty set
                    graph.put(email, new HashSet());
                }
                // Add all the neighboring email assocaited with the email
                graph.get(email).addAll(neighbors);
                // Assocaites the email with name
                owner.put(email, name);
            }
        }

        // Visisted hashset
        Set<String> visited = new HashSet<>();
        // Return value
        List<List<String>> retVal = new ArrayList<>();

        // DFS search the graph
        for(String email: owner.keySet()) {
            // If we haven't looked at the email yet
            if(!visited.contains(email)) {
                // run a dfs on the email
                List<String> result = new ArrayList<>();
                dfs(graph, email, visited, result);
                // Sort the result
                Collections.sort(result);
                // Add the result to the main return value and add the name at the front
                result.add(0, owner.get(email));
                retVal.add(result);
            }
        }
        
        return retVal;
    }

    // DFS search

    private void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        // Adds the email to the list
        list.add(email);
        // Adds the email to the visited
        visited.add(email);
        // Checks the neighboring emails in the graph
        for( String neighbor: graph.get(email)) {
            // If we haven't visited yet run another dfs and add it to our list
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited, list);
            }
        }
    }
}