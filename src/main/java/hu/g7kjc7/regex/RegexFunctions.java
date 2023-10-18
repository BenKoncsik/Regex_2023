/**
 * @Author Koncsik Benedek András G7KJC7 h047161
 * @Date 17/10/2023
 */
package hu.g7kjc7.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFunctions {

    /**
     * Kiszedi az elsö szavakat és számokat a bemeneti szövegből.
     * Egy szó a következők lehet: [a-zA-Z_0-9].
     *
     * @param input A bemeneti karakterlánc, amelyből a szó karaktereket ki szeretnénk vonni.
     * @return A kivont szó karakterek, minden egyes csoport egy új sorban.
     *         Ha nincs találat, akkor üres karakterláncot ad vissza.
     */
    public static String useCapturingGroup(String input) {
        Pattern pattern = Pattern.compile("^(\\w+)", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(input);
        StringBuilder result = new StringBuilder();
        while(matcher.find()) {
            result.append(matcher.group(1)).append("\n");
        }
        return result.toString();
    }

    /**
     * Keresi és gyűjti össze az érvényes dátum-idő formátumú karakterláncokat a megadott szövegből.
     * Az érvényes formátum: "ÉÉÉÉ-HH-NN ÓÓ:PP:MM".
     *
     * Az érvényes évek: 1900-tól 2099-ig.
     * Az évek közötti elválasztó: '-'
     * Az órák érvényes tartománya: 00-tól 23-ig.
     * A percek és másodpercek érvényes tartománya: 00-tól 59-ig.
     * Az órák, percek és másodpercek közötti elválasztó: ':'
     *
     * @param text A szöveg, amiben az érvényes dátum-idő formátumú karakterláncokat keresni szeretnénk.
     * @return Egy karakterláncot ad vissza, amelyben az összes talált érvényes dátum-idő formátumú karakterláncot
     *         új sorba rendezve találjuk meg. Ha nincs találat, üres karakterláncot ad vissza.
     */
    public static String getValidDateTimes(String text) {
        String DATE_TIME_REGEX = "(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]) (?:[01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
        Pattern PATTERN = Pattern.compile(DATE_TIME_REGEX, Pattern.MULTILINE);
        Matcher matcher = PATTERN.matcher(text);
        StringBuilder validDates = new StringBuilder();

        while (matcher.find()) {
            validDates.append("\n");
            validDates.append(matcher.group());
        }

        return validDates.toString();
    }

    /**
     * Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegből, majd ezekből kinyeri az évet,
     * hónapot és napot. Az érvényes formátum: "ÉÉÉÉ-HH-NN ÓÓ:PP:MM".
     *
     * Az érvényes évek: 1900-tól 2099-ig.
     * Az évek közötti elválasztó: '-'
     * Az órák érvényes tartománya: 00-tól 23-ig.
     * A percek és másodpercek érvényes tartománya: 00-tól 59-ig.
     * Az órák, percek és másodpercek közötti elválasztó: ':'
     *
     * @param text A szöveg, amiben az érvényes dátum-idő formátumú karakterláncokat keresni és feldolgozni szeretnénk.
     * @return Egy karakterláncot ad vissza, amely tartalmazza az összes talált évet, hónapot és napot
     *         "Year: ÉÉÉÉ, Month: HH, Day: NN" formátumban, minden egyes találat új sorban.
     *         Ha nincs találat, üres karakterláncot ad vissza.
     */
    public static  String dateTime(String text){
        String DATE_TIME_REGEX = "(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]) (?:[01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
        Pattern PATTERN = Pattern.compile(DATE_TIME_REGEX);
        Matcher matcher = PATTERN.matcher(text);
        StringBuilder details = new StringBuilder();

        while (matcher.find()) {
            details.append("\n");
            String year = matcher.group(1);
            String month = matcher.group(2);
            String day = matcher.group(3);
            String detail = String.format("Year: %s, Month: %s, Day: %s", year, month, day);
            details.append(detail);
        }

        return details.toString();
    }

    /**
     * Keresi a szövegben az azonos szavakat, amelyek egymás mellett állnak.
     *
     * @param text A szöveg, amelyben keresni szeretnénk a duplán előforduló szavakat.
     * @return Egy karakterlánc, amely tartalmazza az összes talált azonos szópárt új soronként.
     *         Ha nincs találat, üres karakterláncot ad vissza.
     */
    public static String findDoubleWords(String text) {
        String DOUBLE_WORD_REGEX = "\\b(\\w+)\\s+\\1\\b";
        Pattern PATTERN = Pattern.compile(DOUBLE_WORD_REGEX, Pattern.MULTILINE);
        Matcher matcher = PATTERN.matcher(text);
        StringBuilder doubleWords = new StringBuilder();

        while (matcher.find()) {
            doubleWords.append(matcher.group()).append("\n");
        }

        return doubleWords.toString().trim();
    }

    /**
     * Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegben több soron át.
     * A regex kifejezésben használt "possessive quantifier" (++ jelölés) biztosítja, hogy ha az illeszkedés
     * megtörténik, a regex motor nem engedi, hogy visszaálljon és próbálkozzon másik lehetőséggel.
     *
     * Az érvényes formátum: "ÉÉÉÉ-HH-NN ÓÓ:PP:MM".
     * Az érvényes évek: 1900-tól 2099-ig.
     * Az évek közötti elválasztó: '-'
     * Az órák érvényes tartománya: 00-tól 23-ig.
     * A percek és másodpercek érvényes tartománya: 00-tól 59-ig.
     * Az órák, percek és másodpercek közötti elválasztó: ':'
     *
     * @param text A szöveg, amiben az érvényes dátum-idő formátumú karakterláncokat keresni és feldolgozni szeretnénk.
     * @return Egy karakterláncot ad vissza, amely tartalmazza az összes talált érvényes dátum-idő formátumú karakterláncot,
     *         minden egyes találat új sorban. Ha nincs találat, üres karakterláncot ad vissza.
     */

    public static String getValidDateTimesUsingPossessive(String text) {
        String DATE_TIME_REGEX = "(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]) (?:[01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]++";
        Pattern PATTERN = Pattern.compile(DATE_TIME_REGEX, Pattern.MULTILINE);
        Matcher matcher = PATTERN.matcher(text);
        StringBuilder validDates = new StringBuilder();

        while (matcher.find()) {
            validDates.append("\n");
            validDates.append(matcher.group());
        }

        return validDates.toString();
    }

    /**
     * Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegben több soron át.
     * A regex kifejezésben használt "lazy quantifier" (?? jelölés) az óra résznél azt jelenti,
     * hogy a lehető legkevesebb karakterrel próbálkozik megfelelni a kritériumoknak.
     *
     * Az érvényes formátum: "ÉÉÉÉ-HH-NN ÓÓ:PP:MM".
     * Az érvényes évek: 1900-tól 2099-ig.
     * Az évek közötti elválasztó: '-'
     * Az órák érvényes tartománya: 00-tól 23-ig.
     * A percek és másodpercek érvényes tartománya: 00-tól 59-ig.
     * Az órák, percek és másodpercek közötti elválasztó: ':'
     *
     * @param text A szöveg, amiben az érvényes dátum-idő formátumú karakterláncokat keresni és feldolgozni szeretnénk.
     * @return Egy karakterláncot ad vissza, amely tartalmazza az összes talált érvényes dátum-idő formátumú karakterláncot,
     *         minden egyes találat új sorban. Ha nincs találat, üres karakterláncot ad vissza.
     */
    public static String getValidDateTimesUsingLazy(String text) {
        String DATE_TIME_REGEX = "(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]) (?:[01]?[0-9]??|2[0-3]):[0-5][0-9]:[0-5][0-9]";
        Pattern PATTERN = Pattern.compile(DATE_TIME_REGEX, Pattern.MULTILINE);
        Matcher matcher = PATTERN.matcher(text);
        StringBuilder validDates = new StringBuilder();

        while (matcher.find()) {
            validDates.append("\n");
            validDates.append(matcher.group());
        }

        return validDates.toString();
    }

    /**
     * Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegben több soron át.
     * A regex kifejezésben az óra résznél használt "atomi csoport" azt jelenti,
     * hogy ha az illeszkedés megtörténik, a regex motor nem engedi, hogy visszaálljon és próbálkozzon másik lehetőséggel.
     *
     * Az érvényes formátum: "ÉÉÉÉ-HH-NN ÓÓ:PP:MM".
     * Az érvényes évek: 1900-tól 2099-ig.
     * Az évek közötti elválasztó: '-'
     * Az órák érvényes tartománya: 00-tól 23-ig.
     * A percek és másodpercek érvényes tartománya: 00-tól 59-ig.
     * Az órák, percek és másodpercek közötti elválasztó: ':'
     *
     * @param text A szöveg, amiben az érvényes dátum-idő formátumú karakterláncokat keresni és feldolgozni szeretnénk.
     * @return Egy karakterláncot ad vissza, amely tartalmazza az összes talált érvényes dátum-idő formátumú karakterláncot,
     *         minden egyes találat új sorban. Ha nincs találat, üres karakterláncot ad vissza.
     */

    public static String getValidDateTimesUsingAtomicGroup(String text) {
        String DATE_TIME_REGEX = "(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]) (?>[01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
        Pattern PATTERN = Pattern.compile(DATE_TIME_REGEX, Pattern.MULTILINE);
        Matcher matcher = PATTERN.matcher(text);
        StringBuilder validDates = new StringBuilder();

        while (matcher.find()) {
            validDates.append("\n");
            validDates.append(matcher.group());
        }

        return validDates.toString();
    }

    /**
     * Keresi az "UTC" előtaggal ellátott dátum-idő formátumú karakterláncokat a megadott szövegben több soron át.
     *
     * Az érvényes formátum: "UTC ÉÉÉÉ-HH-NN ÓÓ:PP:MM".
     *
     * A regex kifejezésben használt "lookbehind" azt jelenti,
     * hogy csak akkor illeszkedik a dátumra, ha azt "UTC" előzi meg.
     *
     * @param text A szöveg, amiben az "UTC" előtaggal ellátott dátum-idő formátumú karakterláncokat keresni és feldolgozni szeretnénk.
     * @return Egy karakterláncot ad vissza, amely tartalmazza az összes talált "UTC" előtaggal ellátott dátum-idő formátumú karakterláncot,
     *         minden egyes találat új sorban. Ha nincs találat, üres karakterláncot ad vissza.
     */
    public static String getUTCDateTimes(String text) {
        String DATE_TIME_REGEX = "(?<=UTC )\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
        Pattern PATTERN = Pattern.compile(DATE_TIME_REGEX, Pattern.MULTILINE);
        Matcher matcher = PATTERN.matcher(text);
        StringBuilder utcDates = new StringBuilder();

        while (matcher.find()) {
            utcDates.append("\n");
            utcDates.append(matcher.group());
        }

        return utcDates.toString();
    }

    /**
     * Feldolgozza a szövegben található "Év: ÉÉÉÉ, Hónap: HH, Nap: NN" formátumú dátumokat,
     * és egyszerűsített "ÉÉÉÉ-HH-NN" formában adja vissza őket.
     *
     * A regex kifejezés használja a capturing group-okat az év, hónap és nap értékeinek megkaptásához.
     *
     * @param text A szöveg, amelyben a dátumokat keresni és feldolgozni szeretnénk.
     * @return Egy karakterláncot ad vissza, amely tartalmazza az összes talált és egyszerűsített dátumot,
     *         minden egyes dátum új sorban. Ha nincs találat, üres karakterláncot ad vissza.
     */
    public static String simplifyDate(String text) {
        String DATE_REGEX = "Év:\\s*(\\d{2,4}),?\\s*Hónap:\\s*(\\d{1,2}),?\\s*Nap:\\s*(\\d{1,2})";
        Pattern PATTERN = Pattern.compile(DATE_REGEX, Pattern.MULTILINE);
        Matcher matcher = PATTERN.matcher(text);
        StringBuilder complexSimplifiedDates = new StringBuilder();


        while (matcher.find()) {
            complexSimplifiedDates.append("\n");
            String year = matcher.group(1);
            String month = matcher.group(2).length() == 1 ? "0" + matcher.group(2) : matcher.group(2); // Ha a hónap csak egy karakterből áll, akkor nullával kiegészítjük
            String day = matcher.group(3).length() == 1 ? "0" + matcher.group(3) : matcher.group(3);   // Ugyanez a napra
            complexSimplifiedDates.append(year).append("-").append(month).append("-").append(day);
        }

        return complexSimplifiedDates.toString();
    }





}
