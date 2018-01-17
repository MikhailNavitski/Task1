package service.validation;

import entity.criteria.Criteria;

import java.util.Map;
import java.util.regex.Pattern;

public class Validator {

    final static String REGEX_NUM = "\\d+?(.\\d+)?";
    final static String REGEX_STR = "[a-zA-Z]+";
    final static String REGEX_FILTER = "[ABC]";
    final static String REGEX_F = "\\d+-\\d+.?(\\d+)?";
    final static String REGEX_WAND_TYPE = "[a-z]+-[a-z]+-[a-z]+";
    final static String REGEX_BAG_TYPE = "[A-Z]+?(\\d+)?(-\\d+)?";

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {

        String s;
        String c = null;
        int firstCount = 0;
        int secondCount = 0;
        String type = criteria.getApplianceType();
        Map<E, Object> map = criteria.getCriteria();

        for (Map.Entry entry : map.entrySet()) {
            s = entry.getKey() + "=" + entry.getValue() + ",";
            firstCount++;
            String[] line = s.split(" ");
            if (type.equals("Oven") || type.equals("Refrigerator")) {

                secondCount = validatorOR(line, c, secondCount);

            } else if (type.equals("TabletPC") || type.equals("Speakers") || type.equals("VacuumCleaner")) {

                secondCount = validatorTSV(line, c, secondCount, s);

            } else if (type.equals("Laptop")) {

                secondCount = validatorL(line, c, secondCount, s);
            }
        }
        return map.size() == firstCount && map.size() == secondCount;
    }

    public static int validatorOR(String[] line, String c, int secondCount) {

        for (String aLine : line) {
            c = aLine.substring(aLine.indexOf("=") + 1, aLine.indexOf(","));
        }
        if (c != null && Pattern.compile(REGEX_NUM).matcher(c).matches()) {
            secondCount++;
        }
        return secondCount;
    }

    public static int validatorTSV(String[] line, String c, int secondCount, String s) {
        for (String aLine : line) {
            c = aLine.substring(aLine.indexOf("=") + 1, aLine.indexOf(","));
        }
        if (s.contains("COLOR") || s.contains("OS") && c != null && Pattern.compile(REGEX_STR).matcher(c).matches()) {
            secondCount++;
        }
        if (s.contains("FILTER_TYPE") && c != null && Pattern.compile(REGEX_FILTER).matcher(c).matches()) {
            secondCount++;
        }
        if (s.contains("WAND_TYPE") && c != null && Pattern.compile(REGEX_WAND_TYPE).matcher(c).matches()) {
            secondCount++;
        }
        if (s.contains("BAG_TYPE") && c != null && Pattern.compile(REGEX_BAG_TYPE).matcher(c).matches()) {
            secondCount++;
        }
        if (s.contains("FREQUENCY_RANGE") && c != null && Pattern.compile(REGEX_F).matcher(c).matches()) {
            secondCount++;
        } else {
            if (c != null && Pattern.compile(REGEX_NUM).matcher(c).matches()) {
                secondCount++;
            }
        }
        return secondCount;
    }

    public static int validatorL(String[] line, String c, int secondCount, String s) {
        for (String aLine : line) {
            c = aLine.substring(aLine.indexOf("=") + 1, aLine.indexOf(","));
        }
        if (s.contains("OS") && c != null && Pattern.compile(REGEX_STR).matcher(c).matches()) {
            secondCount++;
        } else {
            if (c != null && Pattern.compile(REGEX_NUM).matcher(c).matches()) {
                secondCount++;
            }
        }
        return secondCount;
    }
}

