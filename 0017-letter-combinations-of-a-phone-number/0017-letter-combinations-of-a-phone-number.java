class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        int n = digits.length();

        switch (n) {
            case 1: {
                String first = letters[digits.charAt(0) - '0'];

                for (int i = 0; i < first.length(); i++) {
                    ans.add("" + first.charAt(i));
                }

                break;
            }

            case 2: {
                String first = letters[digits.charAt(0) - '0'];
                String second = letters[digits.charAt(1) - '0'];

                for (int i = 0; i < first.length(); i++) {
                    for (int j = 0; j < second.length(); j++) {
                        ans.add("" + first.charAt(i)
                                + second.charAt(j));
                    }
                }

                break;
            }

            case 3: {
                String first = letters[digits.charAt(0) - '0'];
                String second = letters[digits.charAt(1) - '0'];
                String third = letters[digits.charAt(2) - '0'];

                for (int i = 0; i < first.length(); i++) {
                    for (int j = 0; j < second.length(); j++) {
                        for (int k = 0; k < third.length(); k++) {
                            ans.add("" + first.charAt(i)
                                    + second.charAt(j)
                                    + third.charAt(k));
                        }
                    }
                }

                break;
            }

            case 4: {
                String first = letters[digits.charAt(0) - '0'];
                String second = letters[digits.charAt(1) - '0'];
                String third = letters[digits.charAt(2) - '0'];
                String fourth = letters[digits.charAt(3) - '0'];

                for (int i = 0; i < first.length(); i++) {
                    for (int j = 0; j < second.length(); j++) {
                        for (int k = 0; k < third.length(); k++) {
                            for (int l = 0; l < fourth.length(); l++) {
                                ans.add("" + first.charAt(i)
                                        + second.charAt(j)
                                        + third.charAt(k)
                                        + fourth.charAt(l));
                            }
                        }
                    }
                }

                break;
            }

            default:
                return ans;
        }

        return ans;
    }

    public List<String> letterCombinationsOptimal(String digits) {
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");

        List<String> li = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        combinations(digits,li,hm,0,sb);

        return li;

    }

    public void combinations(String digits, List<String> li, HashMap<Character,String> hm,int i, StringBuilder sb){
        if(i>=digits.length()){
            li.add(sb.toString());
            return;

        }
        char ch  = digits.charAt(i);

        String temp = hm.get(ch);
        for(int j = 0;j<temp.length();j++){

            char c = temp.charAt(j);
            sb.append(c);

            combinations(digits,li,hm,i+1,sb);

            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}