class Solution {
    public String solution(String[] survey, int[] choices) {
        int[]  answerSheet = new int[8];
        int surveyLength = survey.length;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < surveyLength; i++){
            String temp = survey[i];
            int choice = choices[i];
            if(choice == 4) continue;

            switch (choice){
                case 1:
                    Character first = temp.charAt(0);
                    switch (first){
                        case 'R': answerSheet[0] += 3; break;
                        case 'T': answerSheet[1] += 3; break;
                        case 'C': answerSheet[2] += 3; break;
                        case 'F': answerSheet[3] += 3; break;
                        case 'J': answerSheet[4] += 3; break;
                        case 'M': answerSheet[5] += 3; break;
                        case 'A': answerSheet[6] += 3; break;
                        case 'N': answerSheet[7] += 3; break;
                    }
                    break;
                case 2:
                    Character first1 = temp.charAt(0);
                    switch (first1){
                        case 'R': answerSheet[0] += 2; break;
                        case 'T': answerSheet[1] += 2; break;
                        case 'C': answerSheet[2] += 2; break;
                        case 'F': answerSheet[3] += 2; break;
                        case 'J': answerSheet[4] += 2; break;
                        case 'M': answerSheet[5] += 2; break;
                        case 'A': answerSheet[6] += 2; break;
                        case 'N': answerSheet[7] += 2; break;
                    }
                    break;
                case 3:
                    Character first2 = temp.charAt(0);
                    switch (first2){
                        case 'R': answerSheet[0] += 1; break;
                        case 'T': answerSheet[1] += 1; break;
                        case 'C': answerSheet[2] += 1; break;
                        case 'F': answerSheet[3] += 1; break;
                        case 'J': answerSheet[4] += 1; break;
                        case 'M': answerSheet[5] += 1; break;
                        case 'A': answerSheet[6] += 1; break;
                        case 'N': answerSheet[7] += 1; break;
                    }
                    break;
                case 5:
                    Character second = temp.charAt(1);
                    switch (second){
                        case 'R': answerSheet[0] += 1; break;
                        case 'T': answerSheet[1] += 1; break;
                        case 'C': answerSheet[2] += 1; break;
                        case 'F': answerSheet[3] += 1; break;
                        case 'J': answerSheet[4] += 1; break;
                        case 'M': answerSheet[5] += 1; break;
                        case 'A': answerSheet[6] += 1; break;
                        case 'N': answerSheet[7] += 1; break;
                    }
                    break;
                case 6:
                    Character second1 = temp.charAt(1);
                    switch (second1){
                        case 'R': answerSheet[0] += 2; break;
                        case 'T': answerSheet[1] += 2; break;
                        case 'C': answerSheet[2] += 2; break;
                        case 'F': answerSheet[3] += 2; break;
                        case 'J': answerSheet[4] += 2; break;
                        case 'M': answerSheet[5] += 2; break;
                        case 'A': answerSheet[6] += 2; break;
                        case 'N': answerSheet[7] += 2; break;
                    }
                    break;
                case 7:
                    Character second2 = temp.charAt(1);
                    switch (second2){
                        case 'R': answerSheet[0] += 3; break;
                        case 'T': answerSheet[1] += 3; break;
                        case 'C': answerSheet[2] += 3; break;
                        case 'F': answerSheet[3] += 3; break;
                        case 'J': answerSheet[4] += 3; break;
                        case 'M': answerSheet[5] += 3; break;
                        case 'A': answerSheet[6] += 3; break;
                        case 'N': answerSheet[7] += 3; break;
                    }
                    break;
            }
        }
        
        if(answerSheet[0] >= answerSheet[1]) sb.append("R");
        else sb.append("T");
        
        if(answerSheet[2] >= answerSheet[3]) sb.append("C");
        else sb.append("F");
        
        if(answerSheet[4] >= answerSheet[5]) sb.append("J");
        else sb.append("M");
        
        if(answerSheet[6] >= answerSheet[7]) sb.append("A");
        else sb.append("N");
        
        for(int i = 0; i < answerSheet.length; i++){
            System.out.println(answerSheet[i]);
        }
        return sb.toString();
    }
}