public class Convertor {

    public double unitConvertor(double measurement,String fromUnit,String toUnit){
        if(measurement<=0){
            throw new IllegalArgumentException("Measurement should not be zero or negative");
        }
        else{
            return switch (toUnit) {
                case "cm" -> convertToCentimeter(measurement, fromUnit);
                case "m" -> convertToMeter(measurement, fromUnit);
                case "km" -> convertToKiloMeter(measurement, fromUnit);
                case "kg" -> convertToKilogram(measurement,fromUnit);
                case "g" -> convertToGram(measurement, fromUnit);
                default -> throw new IllegalArgumentException("Invalid Unit");
            };
        }
    }

    public double convertToCentimeter(double measurement,String fromUnit){
        return switch (fromUnit) {
            case "cm" -> measurement;
            case "m" -> measurement * 100;
            case "km" -> measurement * 100000;
            default -> throw new IllegalArgumentException("Invalid Unit");
        };
    }

    public double convertToMeter(double measurement,String fromUnit){
        return switch (fromUnit) {
            case "cm" -> measurement / 100;
            case "m" -> measurement;
            case "km" -> measurement * 1000;
            default -> throw new IllegalArgumentException("Invalid Unit");
        };
    }

    public double convertToKiloMeter(double measurement,String fromUnit){
        return switch (fromUnit) {
            case "cm" -> measurement / 100000;
            case "m" -> measurement / 1000;
            case "km" -> measurement;
            default -> throw new IllegalArgumentException("Invalid Unit");
        };
    }

    public  double convertToKilogram(double measurement, String fromUnit){
        return switch (fromUnit){
            case "kg" -> measurement;
            case "g" -> measurement / 1000;
            default -> throw new IllegalStateException("Invalid Unit");
        };
    }

    public double convertToGram(double measurement, String fromUnit){
        return switch (fromUnit){
            case "g" -> measurement;
            case "kg" -> measurement * 1000;
            default -> throw new IllegalStateException("Invalid Unit");
        };
    }

    public double add(double measure1, String unit1, double measure2, String unit2 ){
        return unitConvertor(measure1,unit1,unit1) + unitConvertor(measure2,unit2,unit1);
    }

    public double subtract(double measure1, String unit1, double measure2, String unit2 ){
        return unitConvertor(measure1,unit1,unit1) - unitConvertor(measure2,unit2,unit1);
    }
}

