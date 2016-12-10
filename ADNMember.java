import java.util.ArrayList;
import java.util.Random;

/**
 * Created by richardje1
 */
public class ADNMember {
    //member is the list of objects

    //! change to private
    public ArrayList<ADNobject> member;
    int weight;
    // 1 is true, 0 is false
    private int valid;
    //private int[] colorArray;
    //private int[][] adjacenctyMatrix;
    public ADNMember(){
        weight = 0;
        valid = 1;
    }
    public void makeChild(ADNMember dad, ADNMember mom){
        member = new ArrayList<ADNobject>();
        //member = new ArrayList<ADNobject>();
        int i = 0;

        while (i < dad.member.size() / 3){
            for(int j = 0; j < dad.member.size(); j++){
                Random rand = new Random();

                int randomNum = rand.nextInt((10 - 0) + 1) + 1;
                if(randomNum == 3){
                    dad.member.set(j,mom.member.get(j));
                    i++;
                }
            }


        }


        calculateWeight();
        //System.out.println(weight);

    }
    public void makeMember(int[][] adjacenctyMatrix){

        member = new ArrayList<ADNobject>();
        int numColors = ADN.numOfColors;

        Random rand = new Random();

        for (int i = 0; i < adjacenctyMatrix.length; i++){
            int randomColorInt = rand.nextInt(numColors ) +1;
            ADNobject adno = new ADNobject();
            adno.setColor(randomColorInt);
            adno.setId(i);
            member.add(adno);

        }
        for (int i = 0; i < adjacenctyMatrix.length; i++){
            for (int j = 0; j < adjacenctyMatrix[i].length; j++ ){
                if(adjacenctyMatrix[i][j] == 1) {
                    int c = member.get(j).getColor();
                    member.get(i).addNeighborColors(c);
                }
            }
        }
        calculateWeight();

    }
    private void calculateWeight(){

        for (int i = 0; i < member.size(); i++){
            // goes through each color

            for (int j = 0; j < member.get(i).getNeighborColors().size(); j++){

                //checks the color of the object to each neighbor color
                //i'm sorry
                if(member.get(i).getColor() == member.get(i).getNeighborColors().get(j)){
                    makeInvalid();
                }
                else{
                    weight++;
                }
            }

            for(int j = 0; j < member.get(i).getNeighborColors().size(); j++){
                for(int k = j + 1; k < member.get(i).getNeighborColors().size(); k++){

                    //iterates through each color and checks the other colors
                    //i'm very sorry
                    if(member.get(i).getNeighborColors().get(j) == member.get(i).getNeighborColors().get(k)){
                        makeInvalid();
                    }
                    else{
                        weight++;
                    }
                }

            }



        }
    }
    public void makeRandomSet(){
        //for(int i = 0; )
    }
    public int getWeight(){
        return 0;
    }
    public void makeInvalid(){
        valid = 0;

    }
    public int getValid(){
        return valid;
    }

}




