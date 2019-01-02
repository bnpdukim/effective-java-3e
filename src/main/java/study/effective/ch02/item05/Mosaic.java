package study.effective.ch02.item05;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;
import java.util.stream.IntStream;

@Slf4j
public class Mosaic {
    private final Tile tile;

    private Mosaic(Tile tile) {
        this.tile = tile;
    }

    public void print() {
        IntStream.range(1,10)
                .forEach( i -> {
                    IntStream.range(1,i).forEach(i2->System.out.print(tile.tile()));
                    System.out.println();
                } );
    }

    public static Mosaic create(Supplier<? extends Tile> tileFactory ) {
        return new Mosaic(tileFactory.get());
    }
}
