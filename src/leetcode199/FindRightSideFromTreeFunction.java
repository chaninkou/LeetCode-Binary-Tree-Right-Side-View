package leetcode199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindRightSideFromTreeFunction {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        dfs(root, result, 0);
        
        return result;
    }
    
    // dfs checking right node first
    private void dfs(TreeNode current, List<Integer> result, int currentDepth){
        if(current == null){
            return;
        }
        
        if(result.size() == currentDepth){
            result.add(current.val);
        }
        
        dfs(current.right, result, currentDepth + 1);
        dfs(current.left, result, currentDepth + 1);
    }
    
    // bfs with queue
	public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size > 0){
                size--;
                
                TreeNode current = queue.poll();
                
                if(size == 0){
                    result.add(current.val);
                }
                
                if(current.left != null){
                    queue.offer(current.left);
                }
                
                if(current.right != null){
                    queue.offer(current.right);
                }
                
            }
        }
        
        return result;
    }
}
