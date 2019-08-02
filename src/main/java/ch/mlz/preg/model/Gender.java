package ch.mlz.preg.model;

public enum Gender {
    MALE("M"), FEMALE("F"),THIRD("T"), UNKNOWN("X");
    private String code;

    Gender(String shortName) {
        this.code = shortName;
    }

    public static Gender create(String f) {
        if(FEMALE.code.equals(f)){
            return FEMALE;
        }
        if(MALE.code.equals(f)){
            return MALE;
        }
        if(THIRD.code.equals(f)){
            return THIRD;
        }
        return UNKNOWN;
    }
}
