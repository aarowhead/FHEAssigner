package fheActivity;

/**
 * Used to hold the Family Home Evening Activities
 *
 * Created by Aaron on 7/29/2017.
 */

public class FheActivity implements Comparable<FheActivity>{

    private String name;
    private int difficulty;
    private int order;
    private boolean partOfProgram;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isPartOfProgram() {
        return partOfProgram;
    }

    public void setPartOfProgram(boolean partOfProgram) {
        this.partOfProgram = partOfProgram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FheActivity that = (FheActivity) o;

        if (difficulty != that.difficulty) return false;
        if (order != that.order) return false;
        if (partOfProgram != that.partOfProgram) return false;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + difficulty;
        result = 31 * result + order;
        result = 31 * result + (partOfProgram ? 1 : 0);
        return result;
    }

    @Override
    public int compareTo(FheActivity other) {

        if(this.order > other.order){
            return 1;
        }else if(this.order < other.order){
            return -1;
        }

        return 0;
    }

}
