//Solution 1
class Solution {
   
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        preOrder(root,result);
        return result;
        
    }
    private void preOrder(TreeNode root,List<Integer> result){

        if(root== null){
            return;
        }
        result.add(root.val);
        preOrder(root.left,result);
        preOrder(root.right,result);
    }
}

//solution 2
class Solution {
    List<Integer> result=new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        
        if(root != null){
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);

        }
        return result;
        
    }
    
}
