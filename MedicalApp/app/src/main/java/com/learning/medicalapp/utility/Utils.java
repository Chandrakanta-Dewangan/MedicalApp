package com.learning.medicalapp.utility;

public class Utils {
        /**
         * Convert hex to binary number
         * @param hex -> hex number
         * @return -> binary string
         */
        public static String hexToBin(String hex) {
        hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("A", "1010");
        hex = hex.replaceAll("B", "1011");
        hex = hex.replaceAll("C", "1100");
        hex = hex.replaceAll("D", "1101");
        hex = hex.replaceAll("E", "1110");
        hex = hex.replaceAll("F", "1111");
        return hex.replace("X", "");
    }

        /**
         * Get the User status
         *
         * @param binary -> binary type for user status
         * @return -> user status
         */
        public static String getUserType(String binary) {
        String userType = "", trained;
        int strLength = binary.length();
        boolean operator = false;
        boolean admin = false;
        //5th bit
        if (Integer.parseInt(binary.substring(strLength - 6, strLength - 5)) == 1) {
            operator = true;
        }
        //6th bit
        if (Integer.parseInt(binary.substring(strLength - 7, strLength - 6)) == 1) {
            trained = Constants.USER_TYPE_TRAINED;
        } else {
            trained = Constants.USER_TYPE_UNTRAINED;
        }
        //7th bit
        if (Integer.parseInt(binary.substring(strLength - 8, strLength - 7)) == 1) {
            admin = true;
        }
        if (admin && operator) {
            userType = Constants.USER_TYPE_AUTHORIZED_OPERATOR;
        } else if (admin && !operator) {
            userType = Constants.USER_TYPE_AUTHORIZED_ADMIN;
        } else if (!admin && operator) {
            userType = Constants.USER_TYPE_DISABLE_OPERATOR;
        } else if (!admin && !operator) {
            userType = Constants.USER_TYPE_DISABLE_ADMIN;
        }
        return userType + "\t" + trained;
    }
}
