
package com.eprogrammerz.examples.general.enums;

public enum FileType {
    OneByOne("1x1"),
    TwoByTwo("2x2");

    private final String value;

    FileType(final String value) {
        this.value = value;
    }

    public static FileType forValue(final String value) {
        for (FileType fileType : values()) {
            if (fileType.value.equalsIgnoreCase(value)) {
                return fileType;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + value + "]");
    }

    /**
     * Get enum value.
     *
     * @return Enum value
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
