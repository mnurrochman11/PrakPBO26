package Jobsheet9_polimorfisme.zombie;

public class MainTugas3 {
    public static void main(String[] args) {
        Zombie z = new WalkingZombie(100, 1);
        Destroyable d = z;
        // Zombie z2 = d;
        Zombie z3 = (Zombie) d;
        // Zombie z4 = new Zombie(100, 1);
        // Destroyable d2 = new Plant();
        Zombie z5 = new JumpingZombie(100, 2);
        WalkingZombie w = (WalkingZombie) z5;
    }
}
