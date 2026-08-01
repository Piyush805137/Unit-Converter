package com.example.unitconverter.utils;

public class ConverterUtils {

    public static double convertLength(double value, String from, String to) {
        double inMeters;
        switch (from) {
            case "Millimeter (mm)": inMeters = value / 1000.0; break;
            case "Centimeter (cm)": inMeters = value / 100.0; break;
            case "Meter (m)": inMeters = value; break;
            case "Kilometer (km)": inMeters = value * 1000.0; break;
            case "Inch (in)": inMeters = value * 0.0254; break;
            case "Foot (ft)": inMeters = value * 0.3048; break;
            case "Yard (yd)": inMeters = value * 0.9144; break;
            case "Mile (mi)": inMeters = value * 1609.34; break;
            case "Nautical Mile (nmi)": inMeters = value * 1852.0; break;
            case "Micrometer (µm)": inMeters = value / 1000000.0; break;
            case "Nanometer (nm)": inMeters = value / 1000000000.0; break;
            case "Decimeter (dm)": inMeters = value / 10.0; break;
            case "Hectometer (hm)": inMeters = value * 100.0; break;
            case "Furlong": inMeters = value * 201.168; break;
            case "Chain": inMeters = value * 20.1168; break;
            default: inMeters = value;
        }
        switch (to) {
            case "Millimeter (mm)": return inMeters * 1000.0;
            case "Centimeter (cm)": return inMeters * 100.0;
            case "Meter (m)": return inMeters;
            case "Kilometer (km)": return inMeters / 1000.0;
            case "Inch (in)": return inMeters / 0.0254;
            case "Foot (ft)": return inMeters / 0.3048;
            case "Yard (yd)": return inMeters / 0.9144;
            case "Mile (mi)": return inMeters / 1609.34;
            case "Nautical Mile (nmi)": return inMeters / 1852.0;
            case "Micrometer (µm)": return inMeters * 1000000.0;
            case "Nanometer (nm)": return inMeters * 1000000000.0;
            case "Decimeter (dm)": return inMeters * 10.0;
            case "Hectometer (hm)": return inMeters / 100.0;
            case "Furlong": return inMeters / 201.168;
            case "Chain": return inMeters / 20.1168;
            default: return inMeters;
        }
    }

    public static double convertWeight(double value, String from, String to) {
        double inKg;
        switch (from) {
            case "Milligram (mg)": inKg = value / 1000000.0; break;
            case "Gram (g)": inKg = value / 1000.0; break;
            case "Kilogram (kg)": inKg = value; break;
            case "Metric Ton (t)": inKg = value * 1000.0; break;
            case "Pound (lb)": inKg = value * 0.453592; break;
            case "Ounce (oz)": inKg = value * 0.0283495; break;
            case "Stone (st)": inKg = value * 6.35029; break;
            case "Carat (ct)": inKg = value * 0.0002; break;
            case "Quintal (q)": inKg = value * 100.0; break;
            case "Microgram (µg)": inKg = value / 1000000000.0; break;
            case "Long Ton": inKg = value * 1016.05; break;
            case "Short Ton": inKg = value * 907.185; break;
            case "Dram": inKg = value * 0.00177185; break;
            case "Grain": inKg = value * 0.0000647989; break;
            case "Slug": inKg = value * 14.5939; break;
            default: inKg = value;
        }
        switch (to) {
            case "Milligram (mg)": return inKg * 1000000.0;
            case "Gram (g)": return inKg * 1000.0;
            case "Kilogram (kg)": return inKg;
            case "Metric Ton (t)": return inKg / 1000.0;
            case "Pound (lb)": return inKg / 0.453592;
            case "Ounce (oz)": return inKg / 0.0283495;
            case "Stone (st)": return inKg / 6.35029;
            case "Carat (ct)": return inKg / 0.0002;
            case "Quintal (q)": return inKg / 100.0;
            case "Microgram (µg)": return inKg * 1000000000.0;
            case "Long Ton": return inKg / 1016.05;
            case "Short Ton": return inKg / 907.185;
            case "Dram": return inKg / 0.00177185;
            case "Grain": return inKg / 0.0000647989;
            case "Slug": return inKg / 14.5939;
            default: return inKg;
        }
    }

    public static double convertTemperature(double value, String from, String to) {
        double celsius;
        switch (from) {
            case "Celsius (°C)": celsius = value; break;
            case "Fahrenheit (°F)": celsius = (value - 32) * 5/9; break;
            case "Kelvin (K)": celsius = value - 273.15; break;
            case "Rankine (°Ra)": celsius = (value - 491.67) * 5/9; break;
            case "Réaumur (°Ré)": celsius = value * 1.25; break;
            default: celsius = value;
        }
        switch (to) {
            case "Celsius (°C)": return celsius;
            case "Fahrenheit (°F)": return (celsius * 9/5) + 32;
            case "Kelvin (K)": return celsius + 273.15;
            case "Rankine (°Ra)": return (celsius + 273.15) * 9/5;
            case "Réaumur (°Ré)": return celsius * 0.8;
            default: return celsius;
        }
    }

    public static double convertArea(double value, String from, String to) {
        double inSqM;
        switch (from) {
            case "Square Millimeter (mm²)": inSqM = value / 1000000.0; break;
            case "Square Centimeter (cm²)": inSqM = value / 10000.0; break;
            case "Square Meter (m²)": inSqM = value; break;
            case "Square Kilometer (km²)": inSqM = value * 1000000.0; break;
            case "Square Inch (in²)": inSqM = value * 0.00064516; break;
            case "Square Foot (ft²)": inSqM = value * 0.092903; break;
            case "Square Yard (yd²)": inSqM = value * 0.836127; break;
            case "Square Mile (mi²)": inSqM = value * 2589988.11; break;
            case "Acre": inSqM = value * 4046.86; break;
            case "Hectare": inSqM = value * 10000.0; break;
            case "Are": inSqM = value * 100.0; break;
            case "Barn": inSqM = value * 1e-28; break;
            case "Square Rod": inSqM = value * 25.29285; break;
            case "Square Perch": inSqM = value * 25.29285; break;
            case "Square Townships": inSqM = value * 93239571.97; break;
            default: inSqM = value;
        }
        switch (to) {
            case "Square Millimeter (mm²)": return inSqM * 1000000.0;
            case "Square Centimeter (cm²)": return inSqM * 10000.0;
            case "Square Meter (m²)": return inSqM;
            case "Square Kilometer (km²)": return inSqM / 1000000.0;
            case "Square Inch (in²)": return inSqM / 0.00064516;
            case "Square Foot (ft²)": return inSqM / 0.092903;
            case "Square Yard (yd²)": return inSqM / 0.836127;
            case "Square Mile (mi²)": return inSqM / 2589988.11;
            case "Acre": return inSqM / 4046.86;
            case "Hectare": return inSqM / 10000.0;
            case "Are": return inSqM / 100.0;
            case "Barn": return inSqM / 1e-28;
            case "Square Rod": return inSqM / 25.29285;
            case "Square Perch": return inSqM / 25.29285;
            case "Square Townships": return inSqM / 93239571.97;
            default: return inSqM;
        }
    }

    public static double convertVolume(double value, String from, String to) {
        double inLiters;
        switch (from) {
            case "Milliliter (ml)": inLiters = value / 1000.0; break;
            case "Liter (l)": inLiters = value; break;
            case "Cubic Meter (m³)": inLiters = value * 1000.0; break;
            case "Cubic Inch (in³)": inLiters = value * 0.0163871; break;
            case "Cubic Foot (ft³)": inLiters = value * 28.3168; break;
            case "Cubic Yard (yd³)": inLiters = value * 764.555; break;
            case "Gallon (US)": inLiters = value * 3.78541; break;
            case "Gallon (UK)": inLiters = value * 4.54609; break;
            case "Quart (US)": inLiters = value * 0.946353; break;
            case "Pint (US)": inLiters = value * 0.473176; break;
            case "Cup (Metric)": inLiters = value * 0.25; break;
            case "Fluid Ounce (US)": inLiters = value * 0.0295735; break;
            case "Tablespoon (Metric)": inLiters = value * 0.015; break;
            case "Teaspoon (Metric)": inLiters = value * 0.005; break;
            case "Oil Barrel": inLiters = value * 158.987; break;
            default: inLiters = value;
        }
        switch (to) {
            case "Milliliter (ml)": return inLiters * 1000.0;
            case "Liter (l)": return inLiters;
            case "Cubic Meter (m³)": return inLiters / 1000.0;
            case "Cubic Inch (in³)": return inLiters / 0.0163871;
            case "Cubic Foot (ft³)": return inLiters / 28.3168;
            case "Cubic Yard (yd³)": return inLiters / 764.555;
            case "Gallon (US)": return inLiters / 3.78541;
            case "Gallon (UK)": return inLiters / 4.54609;
            case "Quart (US)": return inLiters / 0.946353;
            case "Pint (US)": return inLiters / 0.473176;
            case "Cup (Metric)": return inLiters / 0.25;
            case "Fluid Ounce (US)": return inLiters / 0.0295735;
            case "Tablespoon (Metric)": return inLiters / 0.015;
            case "Teaspoon (Metric)": return inLiters / 0.005;
            case "Oil Barrel": return inLiters / 158.987;
            default: return inLiters;
        }
    }

    public static double convertData(double value, String from, String to) {
        double inBytes;
        switch (from) {
            case "Bit (b)": inBytes = value / 8.0; break;
            case "Byte (B)": inBytes = value; break;
            case "Kilobit (kb)": inBytes = (value * 1000) / 8.0; break;
            case "Kilobyte (KB)": inBytes = value * 1024.0; break;
            case "Megabit (mb)": inBytes = (value * 1000000) / 8.0; break;
            case "Megabyte (MB)": inBytes = value * 1024.0 * 1024.0; break;
            case "Gigabit (gb)": inBytes = (value * 1000000000) / 8.0; break;
            case "Gigabyte (GB)": inBytes = value * Math.pow(1024, 3); break;
            case "Terabit (tb)": inBytes = (value * 1000000000000.0) / 8.0; break;
            case "Terabyte (TB)": inBytes = value * Math.pow(1024, 4); break;
            case "Petabyte (PB)": inBytes = value * Math.pow(1024, 5); break;
            case "Exabyte (EB)": inBytes = value * Math.pow(1024, 6); break;
            case "Zettabyte (ZB)": inBytes = value * Math.pow(1024, 7); break;
            case "Yottabyte (YB)": inBytes = value * Math.pow(1024, 8); break;
            case "Nibble": inBytes = value * 0.5; break;
            default: inBytes = value;
        }
        switch (to) {
            case "Bit (b)": return inBytes * 8.0;
            case "Byte (B)": return inBytes;
            case "Kilobit (kb)": return (inBytes * 8.0) / 1000.0;
            case "Kilobyte (KB)": return inBytes / 1024.0;
            case "Megabit (mb)": return (inBytes * 8.0) / 1000000.0;
            case "Megabyte (MB)": return inBytes / (1024.0 * 1024.0);
            case "Gigabit (gb)": return (inBytes * 8.0) / 1000000000.0;
            case "Gigabyte (GB)": return inBytes / Math.pow(1024, 3);
            case "Terabit (tb)": return (inBytes * 8.0) / 1000000000000.0;
            case "Terabyte (TB)": return inBytes / Math.pow(1024, 4);
            case "Petabyte (PB)": return inBytes / Math.pow(1024, 5);
            case "Exabyte (EB)": return inBytes / Math.pow(1024, 6);
            case "Zettabyte (ZB)": return inBytes / Math.pow(1024, 7);
            case "Yottabyte (YB)": return inBytes / Math.pow(1024, 8);
            case "Nibble": return inBytes / 0.5;
            default: return inBytes;
        }
    }

    public static double convertTime(double value, String from, String to) {
        double inSeconds;
        switch (from) {
            case "Millisecond (ms)": inSeconds = value / 1000.0; break;
            case "Second (s)": inSeconds = value; break;
            case "Minute (min)": inSeconds = value * 60.0; break;
            case "Hour (h)": inSeconds = value * 3600.0; break;
            case "Day (d)": inSeconds = value * 86400.0; break;
            case "Week (wk)": inSeconds = value * 604800.0; break;
            case "Month (mo)": inSeconds = value * 2629746.0; break;
            case "Year (yr)": inSeconds = value * 31556952.0; break;
            case "Decade": inSeconds = value * 315569520.0; break;
            case "Century": inSeconds = value * 3155695200.0; break;
            case "Microsecond (µs)": inSeconds = value / 1000000.0; break;
            case "Nanosecond (ns)": inSeconds = value / 1000000000.0; break;
            case "Fortnight": inSeconds = value * 1209600.0; break;
            case "Leap Year": inSeconds = value * 31622400.0; break;
            case "Millennium": inSeconds = value * 31556952000.0; break;
            default: inSeconds = value;
        }
        switch (to) {
            case "Millisecond (ms)": return inSeconds * 1000.0;
            case "Second (s)": return inSeconds;
            case "Minute (min)": return inSeconds / 60.0;
            case "Hour (h)": return inSeconds / 3600.0;
            case "Day (d)": return inSeconds / 86400.0;
            case "Week (wk)": return inSeconds / 604800.0;
            case "Month (mo)": return inSeconds / 2629746.0;
            case "Year (yr)": return inSeconds / 31556952.0;
            case "Decade": return inSeconds / 315569520.0;
            case "Century": return inSeconds / 3155695200.0;
            case "Microsecond (µs)": return inSeconds * 1000000.0;
            case "Nanosecond (ns)": return inSeconds * 1000000000.0;
            case "Fortnight": return inSeconds / 1209600.0;
            case "Leap Year": return inSeconds / 31622400.0;
            case "Millennium": return inSeconds / 31556952000.0;
            default: return inSeconds;
        }
    }

    public static double convertSpeed(double value, String from, String to) {
        double inMps;
        switch (from) {
            case "Meters per second (m/s)": inMps = value; break;
            case "Kilometers per hour (km/h)": inMps = value / 3.6; break;
            case "Miles per hour (mph)": inMps = value * 0.44704; break;
            case "Knot (kn)": inMps = value * 0.514444; break;
            case "Mach": inMps = value * 343.0; break;
            case "Feet per second (fps)": inMps = value * 0.3048; break;
            case "Inch per second": inMps = value * 0.0254; break;
            case "Kilometer per second": inMps = value * 1000.0; break;
            case "Mile per second": inMps = value * 1609.34; break;
            case "Light Speed": inMps = value * 299792458.0; break;
            case "Sound Speed": inMps = value * 343.0; break;
            case "Yard per second": inMps = value * 0.9144; break;
            case "Millimeter per second": inMps = value / 1000.0; break;
            case "Centimeter per second": inMps = value / 100.0; break;
            case "Hectometer per hour": inMps = value / 36.0; break;
            default: inMps = value;
        }
        switch (to) {
            case "Meters per second (m/s)": return inMps;
            case "Kilometers per hour (km/h)": return inMps * 3.6;
            case "Miles per hour (mph)": return inMps / 0.44704;
            case "Knot (kn)": return inMps / 0.514444;
            case "Mach": return inMps / 343.0;
            case "Feet per second (fps)": return inMps / 0.3048;
            case "Inch per second": return inMps / 0.0254;
            case "Kilometer per second": return inMps / 1000.0;
            case "Mile per second": return inMps / 1609.34;
            case "Light Speed": return inMps / 299792458.0;
            case "Sound Speed": return inMps / 343.0;
            case "Yard per second": return inMps / 0.9144;
            case "Millimeter per second": return inMps * 1000.0;
            case "Centimeter per second": return inMps * 100.0;
            case "Hectometer per hour": return inMps * 36.0;
            default: return inMps;
        }
    }

    public static double convertPressure(double value, String from, String to) {
        double inPa;
        switch (from) {
            case "Pascal (Pa)": inPa = value; break;
            case "Kilopascal (kPa)": inPa = value * 1000.0; break;
            case "Bar": inPa = value * 100000.0; break;
            case "Millibar (mbar)": inPa = value * 100.0; break;
            case "PSI (Pound per sq in)": inPa = value * 6894.76; break;
            case "Atmosphere (atm)": inPa = value * 101325.0; break;
            case "Torr (mmHg)": inPa = value * 133.322; break;
            case "Inches of Mercury (inHg)": inPa = value * 3386.39; break;
            case "Megapascal (MPa)": inPa = value * 1000000.0; break;
            case "Newton per sq meter": inPa = value; break;
            case "Hectopascal (hPa)": inPa = value * 100.0; break;
            case "Barye (ba)": inPa = value * 0.1; break;
            case "Standard Atmosphere": inPa = value * 101325.0; break;
            case "Technical Atmosphere": inPa = value * 98066.5; break;
            default: inPa = value;
        }
        switch (to) {
            case "Pascal (Pa)": return inPa;
            case "Kilopascal (kPa)": return inPa / 1000.0;
            case "Bar": return inPa / 100000.0;
            case "Millibar (mbar)": return inPa / 100.0;
            case "PSI (Pound per sq in)": return inPa / 6894.76;
            case "Atmosphere (atm)": return inPa / 101325.0;
            case "Torr (mmHg)": return inPa / 133.322;
            case "Inches of Mercury (inHg)": return inPa / 3386.39;
            case "Megapascal (MPa)": return inPa / 1000000.0;
            case "Newton per sq meter": return inPa;
            case "Hectopascal (hPa)": return inPa / 100.0;
            case "Barye (ba)": return inPa * 10.0;
            case "Standard Atmosphere": return inPa / 101325.0;
            case "Technical Atmosphere": return inPa / 98066.5;
            default: return inPa;
        }
    }

    public static double convertEnergy(double value, String from, String to) {
        double inJoules;
        switch (from) {
            case "Joule (J)": inJoules = value; break;
            case "Kilojoule (kJ)": inJoules = value * 1000.0; break;
            case "Calorie (cal)": inJoules = value * 4.184; break;
            case "Kilocalorie (kcal)": inJoules = value * 4184.0; break;
            case "Watt-hour (Wh)": inJoules = value * 3600.0; break;
            case "Kilowatt-hour (kWh)": inJoules = value * 3600000.0; break;
            case "Electronvolt (eV)": inJoules = value * 1.60218e-19; break;
            case "British Thermal Unit (BTU)": inJoules = value * 1055.06; break;
            case "US Therm": inJoules = value * 1.0548e8; break;
            case "Foot-pound": inJoules = value * 1.35582; break;
            case "Gram calorie": inJoules = value * 4.184; break;
            case "Mega joule": inJoules = value * 1000000.0; break;
            case "Giga joule": inJoules = value * 1000000000.0; break;
            case "Newton meter": inJoules = value; break;
            case "Erg": inJoules = value * 1e-7; break;
            default: inJoules = value;
        }
        switch (to) {
            case "Joule (J)": return inJoules;
            case "Kilojoule (kJ)": return inJoules / 1000.0;
            case "Calorie (cal)": return inJoules / 4.184;
            case "Kilocalorie (kcal)": return inJoules / 4184.0;
            case "Watt-hour (Wh)": return inJoules / 3600.0;
            case "Kilowatt-hour (kWh)": return inJoules / 3600000.0;
            case "Electronvolt (eV)": return inJoules / 1.60218e-19;
            case "British Thermal Unit (BTU)": return inJoules / 1055.06;
            case "US Therm": return inJoules / 1.0548e8;
            case "Foot-pound": return inJoules / 1.35582;
            case "Gram calorie": return inJoules / 4.184;
            case "Mega joule": return inJoules / 1000000.0;
            case "Giga joule": return inJoules / 1000000000.0;
            case "Newton meter": return inJoules;
            case "Erg": return inJoules * 1e7;
            default: return inJoules;
        }
    }

    public static double convertPower(double value, String from, String to) {
        double inWatts;
        switch (from) {
            case "Watt (W)": inWatts = value; break;
            case "Kilowatt (kW)": inWatts = value * 1000.0; break;
            case "Megawatt (MW)": inWatts = value * 1000000.0; break;
            case "Horsepower (hp)": inWatts = value * 745.7; break;
            case "Milliwatt (mW)": inWatts = value / 1000.0; break;
            case "Gigawatt (GW)": inWatts = value * 1000000000.0; break;
            case "Calorie per second": inWatts = value * 4.184; break;
            case "BTU per hour": inWatts = value * 0.293071; break;
            case "Foot-pound per second": inWatts = value * 1.35582; break;
            case "Kilocalorie per hour": inWatts = value * 1.163; break;
            case "Joule per second": inWatts = value; break;
            case "Erg per second": inWatts = value * 1e-7; break;
            case "Kilogram-meter per second": inWatts = value * 9.80665; break;
            case "Metric horsepower": inWatts = value * 735.499; break;
            case "Mechanical horsepower": inWatts = value * 745.7; break;
            default: inWatts = value;
        }
        switch (to) {
            case "Watt (W)": return inWatts;
            case "Kilowatt (kW)": return inWatts / 1000.0;
            case "Megawatt (MW)": return inWatts / 1000000.0;
            case "Horsepower (hp)": return inWatts / 745.7;
            case "Milliwatt (mW)": return inWatts * 1000.0;
            case "Gigawatt (GW)": return inWatts / 1000000000.0;
            case "Calorie per second": return inWatts / 4.184;
            case "BTU per hour": return inWatts / 0.293071;
            case "Foot-pound per second": return inWatts / 1.35582;
            case "Kilocalorie per hour": return inWatts / 1.163;
            case "Joule per second": return inWatts;
            case "Erg per second": return inWatts * 1e7;
            case "Kilogram-meter per second": return inWatts / 9.80665;
            case "Metric horsepower": return inWatts / 735.499;
            case "Mechanical horsepower": return inWatts / 745.7;
            default: return inWatts;
        }
    }

    public static double convertAngle(double value, String from, String to) {
        double inDegrees;
        switch (from) {
            case "Degree (°)": inDegrees = value; break;
            case "Radian (rad)": inDegrees = Math.toDegrees(value); break;
            case "Gradian (grad)": inDegrees = value * 0.9; break;
            case "Minute of arc": inDegrees = value / 60.0; break;
            case "Second of arc": inDegrees = value / 3600.0; break;
            case "Circle": inDegrees = value * 360.0; break;
            case "Turn": inDegrees = value * 360.0; break;
            case "Quadrant": inDegrees = value * 90.0; break;
            case "Sextant": inDegrees = value * 60.0; break;
            case "Octant": inDegrees = value * 45.0; break;
            case "Sign": inDegrees = value * 30.0; break;
            case "Mil (NATO)": inDegrees = value * 0.05625; break;
            case "Angular mil": inDegrees = value * (360.0 / 6400.0); break;
            case "Point": inDegrees = value * 11.25; break;
            case "Hour angle": inDegrees = value * 15.0; break;
            default: inDegrees = value;
        }
        switch (to) {
            case "Degree (°)": return inDegrees;
            case "Radian (rad)": return Math.toRadians(inDegrees);
            case "Gradian (grad)": return inDegrees / 0.9;
            case "Minute of arc": return inDegrees * 60.0;
            case "Second of arc": return inDegrees * 3600.0;
            case "Circle": return inDegrees / 360.0;
            case "Turn": return inDegrees / 360.0;
            case "Quadrant": return inDegrees / 90.0;
            case "Sextant": return inDegrees / 60.0;
            case "Octant": return inDegrees / 45.0;
            case "Sign": return inDegrees / 30.0;
            case "Mil (NATO)": return inDegrees / 0.05625;
            case "Angular mil": return inDegrees / (360.0 / 6400.0);
            case "Point": return inDegrees / 11.25;
            case "Hour angle": return inDegrees / 15.0;
            default: return inDegrees;
        }
    }

    public static double convertFuel(double value, String from, String to) {
        double inKmL;
        switch (from) {
            case "Kilometers per Liter (km/L)": inKmL = value; break;
            case "Liters per 100km (L/100km)": inKmL = 100.0 / value; break;
            case "Miles per Gallon (US) (mpg)": inKmL = value * 0.425144; break;
            case "Miles per Gallon (UK) (mpg)": inKmL = value * 0.354006; break;
            case "Miles per Liter": inKmL = value * 1.60934; break;
            default: inKmL = value;
        }
        switch (to) {
            case "Kilometers per Liter (km/L)": return inKmL;
            case "Liters per 100km (L/100km)": return 100.0 / inKmL;
            case "Miles per Gallon (US) (mpg)": return inKmL / 0.425144;
            case "Miles per Gallon (UK) (mpg)": return inKmL / 0.354006;
            case "Miles per Liter": return inKmL / 1.60934;
            default: return inKmL;
        }
    }

    public static double convertFrequency(double value, String from, String to) {
        double inHz;
        switch (from) {
            case "Hertz (Hz)": inHz = value; break;
            case "Kilohertz (kHz)": inHz = value * 1e3; break;
            case "Megahertz (MHz)": inHz = value * 1e6; break;
            case "Gigahertz (GHz)": inHz = value * 1e9; break;
            case "Terahertz (THz)": inHz = value * 1e12; break;
            case "Revolution per Minute (RPM)": inHz = value / 60.0; break;
            default: inHz = value;
        }
        switch (to) {
            case "Hertz (Hz)": return inHz;
            case "Kilohertz (kHz)": return inHz / 1e3;
            case "Megahertz (MHz)": return inHz / 1e6;
            case "Gigahertz (GHz)": return inHz / 1e9;
            case "Terahertz (THz)": return inHz / 1e12;
            case "Revolution per Minute (RPM)": return inHz * 60.0;
            default: return inHz;
        }
    }

    public static double convertForce(double value, String from, String to) {
        double inNewtons;
        switch (from) {
            case "Newton (N)": inNewtons = value; break;
            case "Kilonewton (kN)": inNewtons = value * 1e3; break;
            case "Pound-force (lbf)": inNewtons = value * 4.44822; break;
            case "Kilogram-force (kgf)": inNewtons = value * 9.80665; break;
            case "Dyne (dyn)": inNewtons = value * 1e-5; break;
            default: inNewtons = value;
        }
        switch (to) {
            case "Newton (N)": return inNewtons;
            case "Kilonewton (kN)": return inNewtons / 1e3;
            case "Pound-force (lbf)": return inNewtons / 4.44822;
            case "Kilogram-force (kgf)": return inNewtons / 9.80665;
            case "Dyne (dyn)": return inNewtons * 1e5;
            default: return inNewtons;
        }
    }

    public static double convertDensity(double value, String from, String to) {
        double inKgM3;
        switch (from) {
            case "Kilogram per cubic meter (kg/m³)": inKgM3 = value; break;
            case "Gram per cubic centimeter (g/cm³)": inKgM3 = value * 1000.0; break;
            case "Pound per cubic foot (lb/ft³)": inKgM3 = value * 16.0185; break;
            case "Pound per cubic inch (lb/in³)": inKgM3 = value * 27679.9; break;
            default: inKgM3 = value;
        }
        switch (to) {
            case "Kilogram per cubic meter (kg/m³)": return inKgM3;
            case "Gram per cubic centimeter (g/cm³)": return inKgM3 / 1000.0;
            case "Pound per cubic foot (lb/ft³)": return inKgM3 / 16.0185;
            case "Pound per cubic inch (lb/in³)": return inKgM3 / 27679.9;
            default: return inKgM3;
        }
    }

    public static double convertCooking(double value, String from, String to) {
        double inMl;
        switch (from) {
            case "Teaspoon (Metric)": inMl = value * 5.0; break;
            case "Tablespoon (Metric)": inMl = value * 15.0; break;
            case "Cup (Metric)": inMl = value * 250.0; break;
            case "Milliliter (ml)": inMl = value; break;
            case "Liter (l)": inMl = value * 1000.0; break;
            default: inMl = value;
        }
        switch (to) {
            case "Teaspoon (Metric)": return inMl / 5.0;
            case "Tablespoon (Metric)": return inMl / 15.0;
            case "Cup (Metric)": return inMl / 250.0;
            case "Milliliter (ml)": return inMl;
            case "Liter (l)": return inMl / 1000.0;
            default: return inMl;
        }
    }
}