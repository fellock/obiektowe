/* Utwórz interfejs PersonPersistenceManager implementujący metody load oraz save. Napisz dwie klasy implementujące te metody i przenieś do nich funkcjonalność napisanych wcześniej funkcji statycznych klasy Person:

DirectoryPersonPersistenceManager: load = Person.fromDirectory, save = Person.toDirectory,

CsvPersonPersistgenceManager: load = Person.fromCsv, save = Person.toCsv.

Z wyjątkiem klasy Main, umieść wszystkie utworzone klasy w pakiecie “person” i zmodyfikuj potrzebne pola i metody z dostępem private na package tak, aby klasy *Manager miały do nich dostęp.


W czasie zajęć rozwijana będzie jedynie klasa DirectoryPersonPersistenceManager. Klasę CsvPersonPersistenceManager można zmodyfikować samodzielnie, aby uwzględniała zmiany wprowadzane w plikach. */