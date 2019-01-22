package dhruv.weatherapp;

public class Temperature {

    private double value;

    private TemperatureUnit unit;

    public Temperature(
            double value,
            TemperatureUnit unit
    ) {
        super();

        /**
         * Initialize value.
         */

        this.value = value;

        /**
         * Initialize unit.
         */

        this.unit = unit;
    }

    /**
     * Returns temperature value in target scale.
     * @param targetUnit Required temperature scale.
     * @return Tempevalue value in target scale.
     */
    public double getValue(TemperatureUnit targetUnit) {
        switch (this.unit) {
            case CELCIUS:
                switch (targetUnit) {
                    case CELCIUS:
                        return this.value;
                    case FAHRENHEIT:
                        return (this.value * 1.8) + 32.0;

                    default:
                        return this.value;
                }

            case FAHRENHEIT:
                switch (targetUnit) {
                    case CELCIUS:
                        return (this.value - 32.0) / 1.8;
                    case FAHRENHEIT:
                        return this.value;
                    default:
                        return this.value;
                }
            default:
                return this.value;
        }
    }

    /**
     * Returns difference between current temperature and specified one.
     * @param temperature The temperature to find difference with.
     * @param unit Temperature scale.
     * @return Difference between current temperature and specified one.
     */
    public double getDifference(Temperature temperature, TemperatureUnit unit) {
        return this.getValue(unit) - temperature.getValue(unit);
    }
}