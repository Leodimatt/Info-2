Aufg.1

Lineare Suche (Array A mit n Elementen, Wert v)

// Durchlaufe das Array A von Anfang bis Ende
für i = 0 bis Länge(A) – 1
// Überprüfe, ob das aktuelle Element gleich dem gesuchten Wert v ist
wenn A[i] == v dann
// Falls ja, gib den Index zurück
gib i zurück
// Falls kein Element gleich v ist, gib nil zurück
gib nil zurück

Schleifeninvariante:

Invariante: Bevor man in jede neue Runde der Schleife geht: Der Wert v wurde bisher (also in A[0] bis A[i-1]) noch nicht gefunden.

Beweis->

• Initialisierung: Am Anfang, wenn i = 0 ist, hat man noch kein Element geprüft – also ist v auch noch nicht dabei gewesen. -> Invariante stimmt

• Aufrechterhaltung: Wenn A[i] nicht gleich v ist, guckt man beim nächsten weiter (i wird erhöht). Da man  vorher v noch nicht gefunden haben, bleibt die Bedingung bestehen.

• Terminierung: Wenn man v finden, gibt man den Index i zurück. Falls man das ganze Array durchgeht und v nie auftaucht -> nil wird zurückgegeben.
