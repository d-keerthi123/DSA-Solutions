class LRUCache {
    class Pair {
    int key;
    int value;

    Pair(int key,int value){
        this.key = key;
        this.value = value;
    }
    }


    ArrayList<Pair> cache;
    int n;
    public LRUCache(int capacity) {
        cache=new ArrayList<>();
         n=capacity;
    }
    
    public int get(int key) {
       for(int i=0;i<cache.size();i++){
        if(cache.get(i).key==key){
            int val=cache.get(i).value;

            //remove from current position
            Pair temp=cache.remove(i);

            //add the recently used element at the end
            cache.add(temp);
            return val;
        }
       }
       return -1;
    }
    
    public void put(int key, int value) {
        // key already exists
         for(int i=0;i<cache.size();i++){
            if(cache.get(i).key == key){

                cache.remove(i);

                //move the updated pair to the end
                cache.add(new Pair(key, value));
                return ;
            }
         }
            //cache full
             if(n==cache.size()){

                //remove element at front which is least recently used
                cache.remove(0);

            }
            //new key
            cache.add(new Pair(key,value));
    }
}
