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

### Futási idök:
Fügvény --> complex regex futási ifeje s --> egyszerü regex futási ideje sdateTime --> 2658900s --> 491300 s
findDoubleWords --> 4298100s --> 2085500 s
simplifyDate --> 1563300s --> 144500 s
getValidDateTimes --> 2959400s --> 19918500 s
getValidDateTimesUsingPossessive --> 452800s --> 331500 s
getValidDateTimesUsingAtomicGroup --> 586700s --> 271700 s
getUTCDateTimes --> 680100s --> 294300 s
useCapturingGroup --> 2859200s --> 1359400 s
getValidDateTimesUsingLazy --> 449000s --> 260000 s

### Off topic:
Szerintem ez minumum 60/40 pontot megér. 😂 Adná 150%-os beadandó

