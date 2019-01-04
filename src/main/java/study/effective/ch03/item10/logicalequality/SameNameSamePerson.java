package study.effective.ch03.item10.logicalequality;

public class SameNameSamePerson {
    private final String name;

    public SameNameSamePerson(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof SameNameSamePerson) && ((SameNameSamePerson) obj).name.equals(this.name) ;
    }

    private String name() {
        return this.name;
    }
}
