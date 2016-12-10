import java.util.ArrayList;

/**
 * Created by richardje1
 */
public class ADNobject {

    //These are used together for clarity and avoid casting.
    private ArrayList<Integer> neighborColors;
    private int[] neighborId;
    // - - - - - - - - - - - -
    private int color;
    private int id;
    private int weight;

    public ADNobject(){
        neighborColors = new ArrayList<Integer>();
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArrayList<Integer> getNeighborColors() {
        return neighborColors;
    }

    public void addNeighborColors(Integer i) {
        neighborColors.add(i);
    }

    public int[] getNeighborId() {
        return neighborId;
    }

    public void setNeighborId(int[] neighborId) {
        this.neighborId = neighborId;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}



