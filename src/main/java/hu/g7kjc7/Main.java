package hu.g7kjc7;

import hu.g7kjc7.regex.RegexSimpleFunctions;
import hu.g7kjc7.services.FileService;
import hu.g7kjc7.regex.RegexFunctions;

import java.util.HashMap;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Kérlek add meg az input és output fájlneveket!");
            return;
        }

        String inputPath = args[0];
        String outputPath = args[1];

        String content = FileService.readFile(inputPath);
        if (content == null) {
            System.out.println("Hiba történt a fájl beolvasásakor.");
            return;
        }
        long start;
        long end;
        HashMap<String, Long> regexRunTime = new HashMap<>();
        HashMap<String, Long> simpleRegexRunTime = new HashMap<>();
        StringBuilder results = new StringBuilder();
        results.append("Komplex regex output: \n");
        results.append("Kiszedi az elsö szavakat és számokat a bemeneti szövegből.");
        start = System.nanoTime();
        results.append(RegexFunctions.useCapturingGroup(content));
        end = System.nanoTime();
        regexRunTime.put("useCapturingGroup", end - start);
        end = System.nanoTime();
        regexRunTime.put("useCapturingGroup", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi és gyűjti össze az érvényes dátum-idő formátumú karakterláncokat a megadott szövegből.");
        start = System.nanoTime();
        results.append(RegexFunctions.getValidDateTimes(content));
        end = System.nanoTime();
        regexRunTime.put("getValidDateTimes", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegből, majd ezekből kinyeri az évet, hónapot és napot. Az érvényes formátum: \"ÉÉÉÉ-HH-NN ÓÓ:PP:MM\".");
        start = System.nanoTime();
        results.append(RegexFunctions.dateTime(content));
        end = System.nanoTime();
        regexRunTime.put("dateTime", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi a szövegben az azonos szavakat, amelyek egymás mellett állnak.");
        start = System.nanoTime();
        results.append(RegexFunctions.findDoubleWords(content));
        end = System.nanoTime();
        regexRunTime.put("findDoubleWords", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegben több soron át. A regex kifejezésben használt \"possessive quantifier\" (++ jelölés)");
        start = System.nanoTime();
        results.append(RegexFunctions.getValidDateTimesUsingPossessive(content));
        end = System.nanoTime();
        regexRunTime.put("getValidDateTimesUsingPossessive", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegben több soron át. A regex kifejezésben használt \"lazy quantifier\" (?? jelölés)");
        start = System.nanoTime();
        results.append(RegexFunctions.getValidDateTimesUsingLazy(content));
        end = System.nanoTime();
        regexRunTime.put("getValidDateTimesUsingLazy", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegben több soron át.  használt \"atomi csoport\"");
        start = System.nanoTime();
        results.append(RegexFunctions.getValidDateTimesUsingAtomicGroup(content));
        end = System.nanoTime();
        regexRunTime.put("getValidDateTimesUsingAtomicGroup", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi az \"UTC\" előtaggal ellátott dátum-idő formátumú karakterláncokat a megadott szövegben több soron át.");
        start = System.nanoTime();
        results.append(RegexFunctions.getUTCDateTimes(content));
        end = System.nanoTime();
        regexRunTime.put("getUTCDateTimes", end - start);
        results.append("\n------------------------\n");

        results.append("Feldolgozza a szövegben található \"Év: ÉÉÉÉ, Hónap: HH, Nap: NN\" formátumú dátumoka cupture gorup és egyéb feldolgozás.");
        start = System.nanoTime();
        results.append(RegexFunctions.simplifyDate(content));
        end = System.nanoTime();
        regexRunTime.put("simplifyDate", end - start);
        results.append("\n------------------------\n");


        results.append("Simple regex output: \n");
        results.append("Kiszedi az elsö szavakat és számokat a bemeneti szövegből.");
        start = System.nanoTime();
        results.append(RegexSimpleFunctions.useCapturingGroup(content));
        end = System.nanoTime();
        simpleRegexRunTime.put("useCapturingGroup", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi és gyűjti össze az érvényes dátum-idő formátumú karakterláncokat a megadott szövegből.");
        start = System.nanoTime();
        results.append(RegexSimpleFunctions.getValidDateTimes(content));
        end = System.nanoTime();
        simpleRegexRunTime.put("getValidDateTimes", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegből, majd ezekből kinyeri az évet, hónapot és napot. Az érvényes formátum: \"ÉÉÉÉ-HH-NN ÓÓ:PP:MM\".");
        start = System.nanoTime();
        results.append(RegexSimpleFunctions.dateTime(content));
        end = System.nanoTime();
        simpleRegexRunTime.put("dateTime", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi a szövegben az azonos szavakat, amelyek egymás mellett állnak.");
        start = System.nanoTime();
        results.append(RegexSimpleFunctions.findDoubleWords(content));
        end = System.nanoTime();
        simpleRegexRunTime.put("findDoubleWords", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegben több soron át. A regex kifejezésben használt \"possessive quantifier\" (++ jelölés)");
        start = System.nanoTime();
        results.append(RegexSimpleFunctions.getValidDateTimesUsingPossessive(content));
        end = System.nanoTime();
        simpleRegexRunTime.put("getValidDateTimesUsingPossessive", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegben több soron át. A regex kifejezésben használt \"lazy quantifier\" (?? jelölés)");
        start = System.nanoTime();
        results.append(RegexSimpleFunctions.getValidDateTimesUsingLazy(content));
        end = System.nanoTime();
        simpleRegexRunTime.put("getValidDateTimesUsingLazy", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegben több soron át.  használt \"atomi csoport\"");
        start = System.nanoTime();
        results.append(RegexSimpleFunctions.getValidDateTimesUsingAtomicGroup(content));
        end = System.nanoTime();
        simpleRegexRunTime.put("getValidDateTimesUsingAtomicGroup", end - start);
        results.append("\n------------------------\n");

        results.append("Keresi az \"UTC\" előtaggal ellátott dátum-idő formátumú karakterláncokat a megadott szövegben több soron át.");
        start = System.nanoTime();
        results.append(RegexSimpleFunctions.getUTCDateTimes(content));
        end = System.nanoTime();
        simpleRegexRunTime.put("getUTCDateTimes", end - start);
        results.append("\n------------------------\n");

        results.append("Feldolgozza a szövegben található \"Év: ÉÉÉÉ, Hónap: HH, Nap: NN\" formátumú dátumoka cupture gorup és egyéb feldolgozás.");
        start = System.nanoTime();
        results.append(RegexSimpleFunctions.simplifyDate(content));
        end = System.nanoTime();
        simpleRegexRunTime.put("simplifyDate", end - start);
        results.append("\n------------------------\n");

        results.append("\n\nFutási idök:");
        results.append("Fügvény --> complex regex futási ifeje s --> egyszerü regex futási ideje s");
        System.out.println("Fügvény --> complex regex futási ifeje s --> egyszerü regex futási ideje s");
            for (String key : regexRunTime.keySet()) {
                long regexTime = regexRunTime.get(key);
                if (simpleRegexRunTime.containsKey(key)) {
                    long simpleRegexTime = simpleRegexRunTime.get(key);
                    System.out.printf("%s --> %d s --> %d s%n", key, regexTime, simpleRegexTime);
                    results.append(key + " --> " + regexTime + "s --> " + simpleRegexTime + " s");
                    results.append("\n");
                }
            }



        if (FileService.writeToFile(outputPath, results.toString())) {
            System.out.println("A feldolgozás befejeződött, az eredményt a következő fájlban találod: " + outputPath);
        } else {
            System.out.println("Hiba történt a fájlba írás során.");
        }

    }
}