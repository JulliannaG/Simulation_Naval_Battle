# Simulation_Naval_Battle
Opis zakresu projektu

Język programowania: Java

Temat: Bitwa morska pomiędzy piratami, a flotą hiszpańską.
W skład projektu wchodzi plansza 10x10, na której ustawione są statki dwóch drużyn (czarnych i czerwonych). Bitwa jest podzielona na tury, podczas których naprzemiennie porusza się inny kolor statku (raz czarny, a raz czerwony). O ilości tur decyduje użytkownik. Pierwszy ruch będzie wykonywała flota hiszpańska. W każdej turze drużyna może losowo poruszyć się jednym statkiem lub obrócić go o 90֯. Każda z flot dysponuje czterema rodzajami statków o różnych właściwościach.

Rodzaje statków:
- Mały statek – porusza się tylko jedno pole do przodu lub obraca się o 90֯
- Średni statek – porusza się tylko jedno pole po skosie lub obraca się o 90֯
- Duży statek – porusza się tylko jedno pole do przodu lub po skosie lub obraca się o 90֯
- Statek strzelający – nie ma możliwości ruchu, ale może strzelać w piąte pole przed sobą lub obracać się o 90֯ 

Każda flota dysponuje dwoma statkami każdego rodzaju, które mają ustawioną pozycję startową na planszy. 
Jeżeli statek jednej drużyny wejdzie w interakcje ze statkiem drużyny przeciwnej, wtedy 
statek, który się nie poruszył zostanie zlikwidowany, a drużyna, której była to tura otrzyma punkt. To 
samo tyczy się zestrzelenia statku przez statek strzelający. 

Rodzaje interakcji między statkami:
- Mały statek - posiada 1 życie, moc strzału = -1 życie
- Średni statek - posiada 2 życia, moc strzału = -2 życia
- Duży statek - posiada 3 życia, moc strzału = -3 życia
- Statek strzelający - posiada 4 życia, moc strzału = -2 życia

Koniec bitwy sygnalizuje ilość zdobytych punktów, brak statków danego koloru na planszy lub zakończenie ostatniej tury (określonej przez użytkownika). 
Każdy statek ma przydzieloną konkretną wartość i za jego zatopienie będą naliczane punkty drużynie przeciwnej.

Punktacja statków:
- Mały statek – 1 punkt
- Średni statek – 2 punkty
- Duży statek – 3 punkty
- Statek strzelający – 4 punkty

Dodatkowo symulacja po każdej turze sczytuje dane dotyczące bieżącej punktacji.
Na końcu rozgrywki wyświetlane jest okienko z rezultatem bitwy.
