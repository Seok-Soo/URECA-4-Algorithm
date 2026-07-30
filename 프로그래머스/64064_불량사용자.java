package 프로그래머스;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        boolean[] visited = new boolean[banned_id.length];

        for(int i = 0; i < banned_id.length; i++ ){

            if(visited[i]){

            }

            // for(int k = 0; k < 100; k++){
            //     System.out.println("나는 빡빡이다");
            // }


            for(int j = 0; j < user_id.length; j++){
                if(banned_id[i].length() == user_id[j].length()){

                }
            }
            


        }

        return answer;
    }
}
