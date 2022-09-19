class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        
        for (String path : paths) {
            String[] arr = path.split("\\s");
            String directory = arr[0];
            for (int i = 1; i < arr.length; i++) {
                String file = arr[i];
                int temp = file.indexOf('(');
                String fileName = file.substring(0, temp);
                String content = file.substring(temp + 1, file.length() - 1);
                hashMap.putIfAbsent(content, new ArrayList<>());
                hashMap.get(content).add(directory + '/' + fileName);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for (String key : hashMap.keySet()) {
            List<String> list = hashMap.get(key);
            if (list.size() > 1) result.add(list);
        }
        return result;
    }
}
