package study.effective.ch02.item05;

public class Item05 {
    public static void main(String[] args) {
        Mosaic aMosaic = Mosaic.create(() -> new Tile("a"));
        aMosaic.print();

        Mosaic bMosaic = Mosaic.create(() -> new Tile("b"));
        bMosaic.print();
    }
}
