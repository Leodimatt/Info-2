## Aufgabe 3
Annahme: $f (n) = 3n^2 + 7n + 11\in\Omega(n^2)$
$3n^2+7n+11\leq c*n^2$ für alle $n\geq n_{0}$
### (a)
Für $n_{0}=1$ gilt die Ungleichung mit c = 21, da:
$$
3n^2+7n+11\leq21n^2
$$
Wie abgeschätzt?
Für $n\geq1$ gilt:
- $7n\leq7n^2$
- $11\leq11n^2$
  Also:
  $$
  f(n) = 3n^2 + 7n + 11 \leq 3n^2 + 7n^2 + 11n^2 = 21n^2 \implies f(n) \leq 21n^2
  $$

## Aufgabe 4
Annahme: Für f, g : N → R+ gilt: f ∈ Θ(g) ⇐⇒ f ∈ Ω(g) und f ∈ O(g)
### Erste Pfeilrichtung:
$$
f \in \theta(g) \implies \exists c_1,c_{2} > 0, \exists n_{0}, \forall n \geq n_{0}: c_{1}g(n) \leq f(n) \leq c_{2}g(n)
$$
Also:
- $f(n)\leq c_{2}g(n)$, ist: $f\in O(g)$
- $f(n)\geq c_{1}g(n)$ ist: $f\in \Omega(g)$
### Zweite Pfeilrichtung:
$f\in O(g)$, dann gibt es $c_{2}>0,n_{1}$, daraus folgt:
$$
f(n)\leq c_{2}*g(n), \forall n\geq n_{1}
$$
$f\in \Omega(g)$, dann $c_{1}>0,n_{2}$, daraus folgt:
$$
f(n)\geq c_{1}*g(n), \forall n \geq n_{2}
$$
Wenn wir nun das höchste n(von n1,n2) nehmen, gelten beide Ungleichungen gleichzeitig, also gilt $f\in\theta(g)$
