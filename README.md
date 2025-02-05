# Genetic_Algorithm
Genetic Algorithm written in Java for optimizing the Rosenbrock function for multiple variables.
1. Opis projektu.
Wykonany został algorytm genetyczny wyszukujący minimum I maksimum dla danej
funkcji przy dwóch ograniczeniach dla zmiennych.
Funkcja Rosenbrocka – funkcja niewypukła używana w optymalizacji jako test dla
algorytmów optymalizacji. Zwana jest też ze względu na swój kształt „doliną
Rosenbrocka” lub „funkcją bananową Rosenbrocka”.
Funkcja ta jest popularnie używana do przedstawiania zachowań algorytmów
optymalizacji. Minimum globalne funkcji znajduje się wewnątrz długiego,
parabolicznego wgłębienia funkcji – w punkcie ( x , y ) = ( 1 , 1 ) dla którego funkcja
przyjmuje wartość f ( x , y ) = 0.
W projekcie wykorzystano wielowymiarowe rozwinięcie tej funkcji:
![obraz](https://github.com/user-attachments/assets/7ba51bff-9c0c-48f2-b049-264f971aae7c)
Algortym testowano dla dwóch rozmiarów populacji: 20 I 50 oraz dla 2, 5 I 10
zmiennych funkcji. Ograniczenia zmiennych x: <-2; 2 >.
3. Opis algorytmu.
Chromosom składający się z 0 I 1 przedstawiony jest w postaci wektora
zawierającego rozwiązanie funkcji. Na chromosom składają się genotypy, każdy
genotyp to po dekodowaniu dany x. Ilość genotypów w chromosomie zależy od ilości
zmiennych dla których rozwiązujemy funkcję.
Na początku generujemy populację, czyli wypełniamy tablicę dwuwymiarową
losowymi chromosomami. Chromosomy są generowane w sposób losowy. Każdy
chromom musi zostać sprawdzony czy jego genotypy nie wykraczają poza zakres
naszych ograniczeń. W przypadku błędów chromosom generowany jest ponownie.
Funkcja eval przyjmuje 4 parametry: Rozmiar populacji, ilość ewaluacji, parametr do
tworzenia kolejnych plików oraz ilość genotypów dla chromosomu.
W celu zatrzymania najlepszych chromosomów została użyta ruletka.
Dla każdego chromosomu obliczana jest wartość funkcji przystosowania I na jej
podstawie obliczona jest wartość, która jest dodatkowo podniesiona do potęgi, tak
aby wyniki lepsze miały jeszcze większe szanse na bycie wylosowanym. Gdy już
otrzymamy tablicę z procentami odpowiadającymi danym chromosomom, gdzie
suma przystkich procentów wynosi 1, następuje losowanie. Losujemy wartości od 0
do 1, jeśli wylosowana wartość jest większa od danego procentu dodajemy do niego
kolejny procent. Na końcu otrzymujemy tabelę indeksów funkcji wartości
przystosowania, których odpowiadający chromosom ma zostać zachowany w
następnej populacji. Jeśli wartość danego chromosomu odpowiada wartości z tabeli
to zatrzymujemy go.
Kolejnym etapem jest krzyżowanie nowo powstałem populacji. Wykorzystane
zostało krzyżowanie dwupunktowe. Szansa na krzyżowanie aktualnego chromosomu
z innym losowym chromosomem wynosi 60%. Po każdym krzyżowaniu nowo
powstały chromosom jest sprawdzany.
Populacja skrzyżowanych chromosomów jest poddana mutacji. Szansa na mutację
dla danego bitu wynosi 0.2%. Dodatkowo zmutowane chromosomy są sprawdzane,
czy jego genotypy nie wychodzą poza wartość ograniczeń zmiennych.
Dla takiej populacji na nowo obliczane są wartości przystosowania. Wyliczona jest
średnia z wszystkich wartości przystosowania dla danej populacji oraz zapisany jest
najlepszy wynik.
4. Wyniki.
Dla każdego rodzaju populacji I ilości zmiennych algortym został uruchomiony 30
razy. W wyniku czego otrzymano 30 plików dla średniej(avg), najlepszej
globalnej(global_best) I najlepszej aktualnie (current_best) co łącznie daje 90 plików.
W celu otrzymania wykresów obliczono średnią z tych wartości dla każego rodzaju
wyniku. Wynikiem końcowym jest 6 wykresów: 3 wykresy dla populacji 20 dla ilości
zmiennych 2, 5 I 10, oraz 3 wykresy dla populacji 50 dla ilości zmiennych 2, 5 I 10.
5. Czas działania algorytmu.
Algorytm uruchomiony 30 razy.
- Populacja 50, 10 zmiennych: ~35 minut
- Populacja 50, 5 zmiennych: ~18 minut
- Populacja 50, 2 zmienne: ~7 minut
- Populacja 20, 10 zmiennych: ~6 minut
- Populacja 20, 5 zmiennych: ~3 minuty
- Populacja 20, 2 zmienne: ~1 minuta
5. Wnioski.
Algorytm niezależnie od ilości populacji dla dwóch zmiennych funkcji odnajdywał
rozwiązanie bardzo bliskie szukanego minimum. Wraz ze zwiększeniem ilości
zmiennych znacząco wydłużał się czas działania algorytmu, ponadto należy
zwiększyć ilość ewaluacji 5-10 krotnie aby uzyskać satysfakcjonujące wyniki.
Dla 5 lub 10 zmiennych widać ciągłą poprawę wyników jednak 10 tysięcy ewaluacji
jest niewystarczająca.
Długi czas działania algorytmu dla większej ilości zmiennych może być skutkiem
niewydajnego naprawiania chromosomów. Podczas operacji na danym chromosomie
gdy jeden z jego genotypów jest niewłaściwy operacja ta wykonywana jest ponownie
aż do skutku. Gdy zwiększamy ilość zmiennych prawdopodobieństwo tego, że
przynajmniej jeden genotyp będzie zły jest dużo większe. W celu poprawy działania
algorytmu należałoby naprawiać jedynie pojedyncze genotypy w chromosomie,
dzięki temu mamy pewność, że każda operacja będzie wykonywana jedynie raz
