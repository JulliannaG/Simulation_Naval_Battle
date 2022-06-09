# Simulation_Naval_Battle
Opis zakresu projektu

Język programowania: Java

Temat: Bitwa morska pomiędzy piratami, a flotą hiszpańską
W skład projektu wchodzi plansza 10x10, na której będą ustawione statki dwóch drużyn (czarnych i czerwonych). Bitwa będzie podzielona na tury, dlatego co turę będzie poruszał się inny kolor statku (raz czarny, a raz czerwony). O ilości tur decyduje użytkownik. Pierwszy ruchu będzie wykonywała flota hiszpańska. W każdej turze drużyna może losowo poruszyć się jednym statkiem lub obrócić go o 90֯. Będą cztery rodzaje statków o różnych właściwościach.

Rodzaje statków:
- Mały statek – będzie poruszał się tylko jedno pole do przodu lub obracał się o 90֯
- Średni statek – będzie poruszał się tylko jedno pole po skosie lub obracał się o 90֯
- Duży statek – będzie poruszał się tylko jedno pole do przodu lub po skosie lub obracał się o 90֯
- Statek strzelający – nie będzie się poruszał, ale będzie strzelał w piąte pole przed sobą lub obracał się o 90֯ 

Każda flota będzie dysponowała po 2 statki każdego rodzaju, które będą miały ustawioną pozycję startową na planszy. 
Jeżeli statek jednej drużyny wejdzie w interakcje ze statkiem drużyny przeciwnej, wtedy 
statek, który się nie poruszył zostaje zlikwidowany, a drużyna, której była to tura otrzymuje punkt. To 
samo tyczy się zestrzelenia statku przez statek strzelający. 

Rodzaje interakcji między statkami:
- Mały statek - posiada 1 życie, moc strzału = -1 życie
- Średni statek - posiada 2 życia, moc strzału = -2 życia
- Duży statek - posiada 3 życia, moc strzału = -3 życia
- Statek strzelający - posiada 4 życia, moc strzału = -2 życia

Koniec bitwy sygnalizuje ilość zdobytych punktów, brak statków danego koloru na planszy lub zakończenie ostatniej tury (określonej przez użytkownika). 
Każdy statek ma przydzieloną konkretną wartość i za jego zatopienie będą naliczane punkty drużynie.

Punktacja statków:
- Mały statek – 1 punkt
- Średni statek – 2 punkty
- Duży statek – 3 punkty
- Statek strzelający – 4 punkty

Dodatkowo symulacja po każdej turze będzie sczytywała dane dotyczące bieżącej punktacji.
Na końcu rozgrywki będzie wyświetlało się okienko z rezultatem bitwy.
