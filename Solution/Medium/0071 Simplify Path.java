class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] names = path.split("/");
        
        for(String name : names) {
            if (!name.equals("..") && !name.equals("") && !name.equals(".")) {
                stack.push(name);
            } else if(name.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            }
        }
        
        String result = "";
        while (!stack.isEmpty()) {
            String name = stack.pop();
            result = ("/" + name) + result;
        } 
        
        if (result.equals("")) {
            return "/";
        } else {
            return result;
        }
    }
}
