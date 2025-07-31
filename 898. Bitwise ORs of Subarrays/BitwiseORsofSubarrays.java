class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for(int num : arr) {
            Set<Integer> current = new HashSet<>();
            current.add(num);

            for(int preVal : prev) {
                current.add(num | preVal);
            }

            prev= current;
            result.addAll(current);
        }

        return result.size();
    }
}
