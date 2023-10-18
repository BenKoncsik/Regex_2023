# G7KJC7 Regex

## Funkciók:


Ahol `input.txt` az input szövegfájl neve, és `output.txt` a kimeneti fájl, amelybe az eredmények kerülnek.

## Funkciók

A program a következő függvényeket hívja meg a szövegfeldolgozáshoz:

- `useCapturingGroup`: Kiszedi az első szavakat és számokat a bemeneti szövegből.
- `getValidDateTimes`: Keresi és gyűjti össze az érvényes dátum-idő formátumú karakterláncokat a megadott szövegből.
- `dateTime`: Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegből, majd ezekből kinyeri az évet, hónapot és napot.
- `findDoubleWords`: Keresi a szövegben az azonos szavakat, amelyek egymás mellett állnak.
- `getValidDateTimesUsingPossessive`: Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegben több soron át, és a regex kifejezésben használt "possessive quantifier"-t használja.
- `getValidDateTimesUsingLazy`: Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegben több soron át, és a regex kifejezésben használt "lazy quantifier"-t használja.
- `getValidDateTimesUsingAtomicGroup`: Keresi az érvényes dátum-idő formátumú karakterláncokat a megadott szövegben több soron át, és "atomi csoportot" alkalmaz.
- `getUTCDateTimes`: Keresi az "UTC" előtaggal ellátott dátum-idő formátumú karakterláncokat a megadott szövegben több soron át.
- `simplifyDate`: Feldolgozza a szövegben található "Év: ÉÉÉÉ, Hónap: HH, Nap: NN" formátumú dátumokat, kinyeri az évet, hónapot és napot, majd további feldolgozást végez.

A program minden függvény futási idejét összehasonlítja a komplex regex és az egyszerű regex megközelítés között, és ezeket az eredményeket is a kimeneti fájlba írja.


## Használat:

`java Main input.txt output.txt`
