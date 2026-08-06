package leetcode.google.unique_email_addresses;


public class Solution {
    private String convertSuffix(String email) {
        StringBuffer sb = new StringBuffer();
        // before @
        int i = 0;
        for(;i < email.length(); i++) {
            if(email.charAt(i) == '@') {
                // sb.append(email.charAt(i));
                break;
            }
            if(email.charAt(i) == '.') {
                continue;
            } else if(email.charAt(i) == '+') {
                break;
            } else {
                sb.append(email.charAt(i));
            }
        }
        while(email.charAt(i) != '@') {
            i++;
        }
        sb.append(email.charAt(i));
        sb.append(email.substring(i + 1, email.length()));
        //System.out.println(sb.toString());
        return sb.toString();
    }
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for(String email : emails) {
            uniqueEmails.add(convertSuffix(email));
        }
        return uniqueEmails.size();
    }
}
