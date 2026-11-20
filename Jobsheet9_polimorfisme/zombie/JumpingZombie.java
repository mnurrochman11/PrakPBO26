package Jobsheet9_polimorfisme.zombie;

public class JumpingZombie extends Zombie {
    public JumpingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        switch (level) {
            case 1 -> health = Math.min(100, health + health * 30 / 100);
            case 2 -> health = Math.min(100, health + health * 40 / 100);
            case 3 -> health = Math.min(100, health + health * 50 / 100);
        }
    }

    @Override
    public void destroyed() {
        health -= health * 10 / 100;
    }

    @Override
    public String getZombieInfo() {
        return "Jumping Zombie Data = " + super.getZombieInfo();
    }
}
