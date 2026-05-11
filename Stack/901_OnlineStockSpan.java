//TC:O(n) 
//SC:O(n) Because stack may store up to all previous prices in worst case.

class StockSpanner {
     class pair{
        int price;
        int span;

        pair(int price,int span){
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
