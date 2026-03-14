class prims {

    int minKey(int key[], boolean mstSet[])
    {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for(int v=0; v<key.length; v++)
        {
            if(!mstSet[v] && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void primMST(int graph[][])
    {
        int V = graph.length;

        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];

        for(int i=0;i<V;i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for(int count=0; count<V-1; count++)
        {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for(int v=0; v<V; v++)
            {
                if(graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v])
                {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("Edge \t Weight");

        for(int i=1;i<V;i++)
        {
            System.out.println(parent[i] + " - " + i + "\t" + graph[parent[i]][i]);
        }
    }

    public static void main(String[] args)
    {
        int graph[][] = {
            {0,4,2,0,0},
            {4,0,1,5,0},
            {2,1,0,8,10},
            {0,5,8,0,2},
            {0,0,10,2,0}
        };

        prims obj = new prims();
        obj.primMST(graph);
    }
}