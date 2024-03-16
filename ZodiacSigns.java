package zodiacsigns;

import java.util.Scanner;

public class ZodiacSigns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the month that you born : ");
        int month = scanner.nextInt();

        System.out.println("Enter the day that you born :  ");
        int day = scanner.nextInt();

        if (isValidDate(month, day)) {
            String sign = calculateZodiacSign(month, day);
            System.out.println("We found your zodiac sign !! Your zodiac sign is: " + sign);
        } else {
            System.out.println("Invalid input! Think again.");
        }
        scanner.close();
    }
    public static boolean isValidDate(int month, int day) {
        if (month < 1 || month > 12) {
            return false;
        }
        switch (month) {
            case 2:
                if (day < 1 || day > 28) {
                    return false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day < 1 || day > 30) {
                    return false;
                }
                break;
            default:
                if (day < 1 || day > 31) {
                    return false;
                }
        }
        return true;
    }

    public static String calculateZodiacSign(int month, int day) {
        switch (month) {
            case 1:
                if (day >= 20) return "Aquarius";
                else return "Capricorn";
            case 2:
                if (day >= 19) return "Pisces";
                else return "Aquarius";
            case 3:
                if (day >= 21) return "Aries";
                else return "Pisces";
            case 4:
                if (day >= 20) return "Taurus";
                else return "Aries";
            case 5:
                if (day >= 21) return "Gemini";
                else return "Taurus";
            case 6:
                if (day >= 21) return "Cancer";
                else return "Gemini";
            case 7:
                if (day >= 23) return "Leo";
                else return "Cancer";
            case 8:
                if (day >= 23) return "Virgo";
                else return "Leo";
            case 9:
                if (day >= 23) return "Libra";
                else return "Virgo";
            case 10:
                if (day >= 23) return "Scorpio";
                else return "Libra";
            case 11:
                if (day >= 22) return "Sagittarius";
                else return "Scorpio";
            case 12:
                if (day >= 22) return "Capricorn";
                else return "Sagittarius";
            default:
                return null;
        }
    }
}
