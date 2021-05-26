import java.util.ArrayList;

public class UndirectedGraph extends Graph
{
	public UndirectedGraph() 
	{
		super();
	}

	// Link vertex with key2 to the vertex with key1 (both ways)
	public void link(int key1, int key2)
	{
		Vertex vertex1 = findVertex(key1);
		Vertex vertex2 = findVertex(key2);
		
		if (vertex1 != null && vertex2 != null) {
			vertex1.getVertices().add(vertex2);
			vertex2.getVertices().add(vertex1);
		}
		
		else {
			System.out.println("At least one vertex doesn't exist");
		}
	}

	// Breadth-First Search
	public void BFS(int key) throws EmptyQueueException, FullQueueException
	{
		ArrayQueueVertex queue = new ArrayQueueVertex(vertices.size());
		Vertex searchVertex = findVertex(key);
		int iteration = 1;
		
		if (searchVertex == null) {
			System.out.println("There is no vertex with a given key");
			return;
		}
		
		for (Vertex vertex : vertices)
		{
			vertex.setColor(ColorVertex.WHITE);
			vertex.setDistance(Integer.MAX_VALUE);
			vertex.setParent(null);
		}
		
		searchVertex.setColor(ColorVertex.GREY);
		searchVertex.setDistance(0);
		searchVertex.setParent(null);
		
		queue.enqueue(searchVertex);
		System.out.println("\nQueue before doing first iteration");
		queue.printWholeQueue();
		
		while (!queue.isEmpty())
		{
			Vertex firstInQueueVertex = queue.dequeue();
			for (Vertex vertex : vertices)
			{
				if (firstInQueueVertex.getVertices().contains(vertex)) {
					if (vertex.color == ColorVertex.WHITE) {
						vertex.setColor(ColorVertex.GREY);
						vertex.setDistance(firstInQueueVertex.getDistance() + 1);
						vertex.setParent(firstInQueueVertex);
						queue.enqueue(vertex);
					}
				}
			}
			firstInQueueVertex.color = ColorVertex.BLACK;
			
			System.out.println("Queue after iteration: " + iteration + "\n");
			queue.printWholeQueue();
			iteration += 1;
		}
		
	}

	// Print path for the BFS
	public void printPath(int key1, int key2)
	{
		Vertex vertex1 = findVertex(key1);
		Vertex vertex2 = findVertex(key2);
		
		if (vertex1 == null || vertex2 == null) {
			System.out.println("One of the vertices does not exist in the graph");
			return;
		}
		
		printPath(vertex1, vertex2);
	}
	
	private void printPath(Vertex vertex1, Vertex vertex2)
	{
		if (vertex2 == vertex1) {
			System.out.println(vertex1.getKey());
		}
		
		else if (vertex2.getParent() == null) {
			System.out.println("No path from vertex with key: " + vertex1.getKey() + " to vertex with key: " + vertex2.getKey());
		}
		
		else {
			printPath(vertex1, vertex2.getParent());
			System.out.println(vertex2.getKey());
		}
	}

	// Depth-First Search (iterative version)
	public void DFS(int key) throws FullStackException, EmptyStackException
	{
		ArrayList<Vertex> orderOfAllKeys = new ArrayList<Vertex>();
		ArrayList<Vertex> orderOfKeys = new ArrayList<Vertex>();
		ArrayStackVertex stack = new ArrayStackVertex(vertices.size());
		Vertex searchVertex = findVertex(key);
		int iteration = 1;
		
		if (searchVertex == null) {
			System.out.println("There is no vertex with a given key");
			return;
		}
		
		for (Vertex vertex : vertices)
		{
			vertex.setWasVisited(false);
		}
		
		stack.push(searchVertex);
		System.out.println("\nStack before doing first iteration");
		stack.printWholeStack();
		
		while (!stack.isEmpty())
		{
			Vertex firstInStackVertex = stack.pop();
			orderOfAllKeys.add(firstInStackVertex);
			
			if (!firstInStackVertex.getWasVisited()) {
				firstInStackVertex.setWasVisited(true);
				orderOfKeys.add(firstInStackVertex);
				
				for (Vertex vertex : vertices)
				{
					if (firstInStackVertex.getVertices().contains(vertex)) {
						stack.push(vertex);
					}
				}
			}
			
			System.out.println("Stack after iteration: " + iteration + "\n");
			stack.printWholeStack();
			iteration += 1;
		}
		
		System.out.println("Order of traverse (showing all keys)");
		for (Vertex vertex : orderOfAllKeys)
		{
			System.out.print(vertex.getKey() + " ");
		}
		
		System.out.println("\nOrder of traverse (only showing keys that weren't previously visited)");
		for (Vertex vertex : orderOfKeys)
		{
			System.out.print(vertex.getKey() + " ");
		}
	}
	
}
