AplikacjaZarządzaniaKoszykiem:
Autor: Marcin Tarnowski
kontakt: marcin.tarnowski2@gmail.com

Zbudowana jest z trzech klas:

1) Product 

- przechowuje dane o rodzaju produktu: (nazwa, cena, opis),
- posiada metody get dla każdego pola,
2) Cart 

- pełni rolę koszyka do którego wkładane są wybrane produkty,
- obiekty klasy Product przechowywane sa w kolekcji LinkedHashMap,
- metody addProduct() i removeProduct() służa dodawaniu wybranych produktow do mapy i ich usuwaniu,
- metoda displayProducts() drukuje w konsoli rodzaje produktow i ilosci dodane do koszyka oraz numer porzadkowy wykorzystywany w menu interfejsu uzytkownika,
- metody totalCost() i totalQuantity() zwracają łączną ilość i koszt produktów znajdujących się w koszyku,
- metody getKeySet() i getMap() zwracja Set lub Mape,
3) Shop 

- przechowuje produkty możliwe do nabycia w kolekcji LinkedList,
- po zainicjowaniu obiektu klasy Shop nalezy zapelnic listę shopItems przy pomocy metody addItem() produktami, które mają być dostępne w sklepie,
- zawiera koszyk (Cart) do którego dodawane są produkty,
- metoda displayItems() drukuje listę produktów dostępnych w sklepie i ich numer porzadkowy wykorzystywany w menu interfejsu uzytkownika,
- metoda displayMyCart() wywołuje metodę displayProducts klasy Cart,
- metody putToCart() i removeFromCart() dodaja/usuwaja produkty z koszyka,
- metoda findKeyName() pobiera jako argument numer produktu wybranego w interfejsie uzykownika i wyszukuje w koszyku rodzaju produktu jaki się pod nim kryje,
- metoda intValidation() sprawdza czy dane pobrane przez Scanner od użytkownika są typu int,
- metoda run() wyswietla kolejne menu interfejsu uzytkownika i pobiera od niego dane wejściowe,
- po menu należy nawigować wpisując 
- zabezpieczenia by wpowadzne dane nie wykraczały poza dostępny zakres (dodawanie ujemnych lub większych niż dostępne w koszyku ilości produktów) zawarte są w metodzie run(),
- metoda run() zwraca mape zawierającą obiekty klasy Product wybrane przez użytkownika,
- w menu w kazdym momencie wyswietlane sa dane na temat calkowitego kosztu oraz łącznej ilości produktów w koszyku,

Po uruchomieniu aplikacji:
- w funkcji main() zainicjowany zostaje obiekt klasy Shop,
- dodany zostaje zestaw przykładowych produktów dostępnych do dodania do koszyka,
- uruchomiona zostanie funkcja run(),
- użytkownik nawigując po menu może dokonać wyboru  jakie produkty i w jakich ilościach chce dodać lub usunąć z koszyka,
- po wybraniu opcji zakończ zmienna zakończ przechowuje mapę zwróconą przez funkcję run i z niej wydrukowana zostanie lista zakupów.

Klasa JUnitTest_1 zawiera zestaw testó jednostkowych testujących metody klasy Cart.

