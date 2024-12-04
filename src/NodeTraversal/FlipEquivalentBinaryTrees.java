package NodeTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Leetcode problem: 951
public class FlipEquivalentBinaryTrees {

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(new String[] {"1","2","3","4","5","6","null","null","null","7","8"});
        String[] folder = {"/a","/a/b/c","/a/b/d"};
        Arrays.sort(folder);

        List<String> res = new ArrayList<>();

        for(String dir: folder) {
            if(res.isEmpty() || !dir.startsWith(res.get(res.size() - 1) + "/")) res.add(dir);
        }
    }
}
