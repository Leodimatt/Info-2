# Aufgabe 2
### a)
Permutation 1(Min): $A = [2, 3, 26, 38, 41, 42, 99]$
Permutation 2(Max): $A = [99, 42, 41, 38, 26, 3, 2]$
- Minimale Anzahl an Permutationen, da dass Pivotelement das letzte Element im Array ist(bei diesem Pseudocode), ist die Partition der gesamte Array und es wird nurnoch verglichen.
- Maximale Anzahl an Permutation bei einer absteigenden Sortierung, da die Partitionen sehr klein sein werden, sogar leer. Deshalb wird bei jeder Partition nur ein Element sortiert
