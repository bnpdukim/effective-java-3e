package study.effective.ch02.item05;

import java.util.function.Supplier;

public class Item05 {
    public static void main(String[] args) {
        Mosaic aMosaic1 = Mosaic.create(new Supplier<Tile>() {
            @Override
            public Tile get() {
                return new Tile("a");
            }
        });
        Mosaic aMosaic = Mosaic.create(() -> new Tile("a"));
        aMosaic.print();

        Mosaic bMosaic = Mosaic.create(() -> new Tile("b"));
        bMosaic.print();
    }
}
