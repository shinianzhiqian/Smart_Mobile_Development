package example.myapp;

class Aqurium1{
    Integer length, height, width;
    Integer volume;
    Double water;
    public String shape = "rectangle";

    public Aqurium1(Integer length, Integer height, Integer width){
        this.length = length;
        this.height = height;
        this.width = width;
    }



    public Integer getVolume() {
        return width * height * length / 1000;
    }

    public void setVolume(Integer value) {
        this.volume = (value * 1000) / (width * height);
    }

    public Double getWater() {
        return volume * 0.9;
    }

    public void printSize(){
        System.out.println(shape);
        System.out.println("Width: " + width + " cm");
        System.out.println("Height: " + height + " cm");
        System.out.println("Length: " + length + " cm");
        System.out.println("Volume: " + getVolume() + " liters " + "Water: " + getWater() + " liters");

    }
}

// 子类TowerTank
class TowerTank1 extends Aqurium1{
    public String shape = "cylinder";

    public TowerTank1(Integer height, Integer diameter){
        super(height, height, diameter);
        this.height = height;
        this.width = diameter;
        this.length = diameter;
    }

    public Double getWater() {
        return volume * 0.8;
    }
}


// 抽象类
abstract class AquriumFish1{
    public String color;
}

// 接口
interface FishAction1{
    void eat();
}

class Shark1 extends AquriumFish1 implements FishAction1{
    public String color = "grey";

    public void eat(){
        System.out.println("Shark is eating");
    }
}

public class Main {
}
