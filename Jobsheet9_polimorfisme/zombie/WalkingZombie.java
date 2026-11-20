package Jobsheet9_polimorfisme.zombie;

public class WalkingZombie extends Zombie {
    public WalkingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        switch (level) {
            case 1 -> health = Math.min(100, health + health * 10 / 100);
            case 2 -> health = Math.min(100, health + health * 30 / 100);
            case 3 -> health = Math.min(100, health + health * 40 / 100);
        }
    }

    @Override
    public void destroyed() {
        health -= health * 20 / 100;
    }

    @Override
    public String getZombieInfo() {
        return "Walking Zombie Data = " + super.getZombieInfo();
    }
}
