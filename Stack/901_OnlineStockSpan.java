//TC:O(n) 
//SC:O(n) Because stack may store up to all previous prices in worst case.

class StockSpanner {
     class pair{       //Because for every previous day, we need to store 2 things: price and span
                       //So pair class groups both values into one object.Without pair class, stack can store only one value type.
        int price;
        int span;

        pair(int price,int span){ //constuctor
            this.price=price;
            this.span=span;
        }
    }
    Stack<pair> s; //stack stores {price , span} pair
    public StockSpanner() {
        s= new Stack<>();  
        
    }
    
    public int next(int price) {
        int span=1; //iniatlly

        while(!s.isEmpty() && s.peek().price <=price){
            span=span+s.peek().span;
            s.pop();
        }
        pair p=new pair(price,span);
        s.push(p); //push current pair
        return span;
    }
}
