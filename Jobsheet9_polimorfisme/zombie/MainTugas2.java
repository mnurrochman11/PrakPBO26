package Jobsheet9_polimorfisme.zombie;

public class MainTugas2 {
    public static void main(String[] args) {
        WalkingZombie wz = new WalkingZombie(100, 1);
        JumpingZombie jz = new JumpingZombie(100, 2);
        Barrier b = new Barrier(100);
        Plant p = new Plant();

        Destroyable[] d = {wz, jz, b};

        for (int i = 0; i < 4; i++) {
            for (Destroyable destroyable : d) {
                p.doDestroy(destroyable);
            }
        }

        for (Destroyable destroyable : d) {
            if (destroyable instanceof Zombie) {
                Zombie z = (Zombie) destroyable;
                z.heal();
                System.out.println(z.getZombieInfo());
            } else if (destroyable instanceof Barrier) {
                Barrier barrier = (Barrier) destroyable;
                System.out.println(barrier.getBarrierInfo());
            }
        }
    }
}
