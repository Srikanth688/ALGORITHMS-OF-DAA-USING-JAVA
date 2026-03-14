class dijkstra {

    int mindistance(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for(int j=0; j<dist.length; j++)
        {
            if(!sptSet[j] && dist[j] <= min)
            {
                min = dist[j];
                min_index = j;
            }
        }
        return min_index;
    }

    void dijkstra(int graph[][], int src)
    {
        int v = graph.length;

        int dist[] = new int[v];
        Boolean sptSet[] = new Boolean[v];

        for(int i=0; i<v; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for(int count=0; count<v-1; count++)
        {
            int u = mindistance(dist, sptSet);
            sptSet[u] = true;

            for(int V=0; V<v; V++)
            {
                if(!sptSet[V] && graph[u][V] != 0 &&
                   dist[u] != Integer.MAX_VALUE &&
                   dist[u] + graph[u][V] < dist[V])
                {
                    dist[V] = dist[u] + graph[u][V];
                }
            }
        }

        System.out.println("Vertex \t Distance");

        for(int i=0;i<v;i++)
        {
            System.out.println(i + "\t" + dist[i]);
        }
    }

    public static void main(String[] args)
    {
        int graph[][] = {
            {0,4,0,0,0,0},
            {4,0,8,0,0,0},
            {0,8,0,7,0,4},
            {0,0,7,0,9,14},
            {0,0,0,9,0,10},
            {0,0,4,14,10,0}
        };

        dijkstra d = new dijkstra();
        d.dijkstra(graph,0);
    }
}